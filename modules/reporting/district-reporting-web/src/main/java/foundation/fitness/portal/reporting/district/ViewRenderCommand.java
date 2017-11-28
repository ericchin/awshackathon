package foundation.fitness.portal.reporting.district;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.OrganizationLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;

import foundation.fitness.portal.service.constants.ReportingPortletKeys;
import foundation.fitness.portal.service.model.FitnessRecord;
import foundation.fitness.portal.service.service.FitnessRecordLocalService;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.TimeZone;

/**
 * @author Eric Chin
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + ReportingPortletKeys.DISTRICT_REPORTING_PORTLET,
		"mvc.command.name=/view", "mvc.command.name=/"
	},
	service = MVCRenderCommand.class
)
public class ViewRenderCommand implements MVCRenderCommand {

	@Override
	public String render(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		long companyId = themeDisplay.getCompanyId();

		Group group = themeDisplay.getScopeGroup();

		long organizationId = group.getOrganizationId();

		Organization organization = _organizationLocalService.fetchOrganization(
			organizationId);

		StringBundler seriesJSON = new StringBundler();

		seriesJSON.append(StringPool.OPEN_BRACKET);

		if (!Objects.isNull(organization)) {
			long parentOrganizationId = organization.getParentOrganizationId();

			if (parentOrganizationId > 0) {
				List<Organization> schoolOrgs =
					_organizationLocalService.getOrganizations(
						companyId, parentOrganizationId);

				for (Organization schoolOrg : schoolOrgs) {
					long schoolGroupId = schoolOrg.getGroupId();

					Group schoolGroup = _groupLocalService.fetchGroup(
						schoolGroupId);

					if (Objects.isNull(schoolGroup)) {
						continue;
					}

					List<FitnessRecord> fitnessRecords =
						_fitnessRecordLocalService.getFitnessRecordsByGroupId(
							schoolGroupId);

					String seriesJSONObject = _generateSeriesJSONObject(
						schoolGroup.getName(
							Locale.getDefault()), fitnessRecords);

					seriesJSON.append(seriesJSONObject);
					seriesJSON.append(StringPool.COMMA);
				}
			}
		}

		seriesJSON.setIndex(seriesJSON.index() - 1);

		seriesJSON.append(StringPool.CLOSE_BRACKET);

		renderRequest.setAttribute("series", seriesJSON.toString());

		return "/view.jsp";
	}

	private String _generateSeriesJSONObject(
		String groupName, List<FitnessRecord> fitnessRecords) {

		StringBundler jsonObject = new StringBundler();

		jsonObject.append(StringPool.OPEN_CURLY_BRACE);

		jsonObject.append(StringPool.QUOTE);
		jsonObject.append("name");
		jsonObject.append(StringPool.QUOTE);
		jsonObject.append(StringPool.COLON);
		jsonObject.append(StringPool.QUOTE);
		jsonObject.append(groupName);
		jsonObject.append(StringPool.QUOTE);
		jsonObject.append(StringPool.COMMA);

		JSONArray dataJSONArray = JSONFactoryUtil.createJSONArray();

		Calendar calendar = CalendarFactoryUtil.getCalendar();

		calendar.setTimeZone(TimeZone.getTimeZone("UTC"));

		calendar.set(Calendar.MONTH, 0);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.YEAR, 1970);

		StringBundler sb = new StringBundler();

		sb.append(StringPool.OPEN_BRACKET);

		for (FitnessRecord fitnessRecord : fitnessRecords) {
			int minutes = fitnessRecord.getMileRunMinutes();
			int seconds = fitnessRecord.getMileRunSeconds();

			calendar.set(Calendar.MINUTE, minutes);
			calendar.set(Calendar.SECOND, seconds);

			dataJSONArray.put(calendar.getTimeInMillis());

			sb.append(calendar.getTimeInMillis());
			sb.append(StringPool.COMMA);
		}

		sb.setIndex(sb.index() - 1);

		sb.append(StringPool.CLOSE_BRACKET);

		jsonObject.append(StringPool.QUOTE);
		jsonObject.append("data");
		jsonObject.append(StringPool.QUOTE);
		jsonObject.append(StringPool.COLON);
		jsonObject.append(sb.toString());

		jsonObject.append(StringPool.CLOSE_CURLY_BRACE);

		return jsonObject.toString();
	}

	@Reference
	private FitnessRecordLocalService _fitnessRecordLocalService;

	@Reference
	private GroupLocalService _groupLocalService;

	@Reference
	private OrganizationLocalService _organizationLocalService;

}
