package foundation.fitness.portal.reporting.school;

import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.OrganizationLocalService;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import foundation.fitness.portal.ds.FitnessChartService;
import foundation.fitness.portal.service.constants.ReportingPortletKeys;
import foundation.fitness.portal.service.model.FitnessRecord;
import foundation.fitness.portal.service.service.FitnessRecordLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

/**
 * @author Eric Chin
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + ReportingPortletKeys.SCHOOL_REPORTING_PORTLET,
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

		Group group = themeDisplay.getScopeGroup();

		long organizationId = group.getOrganizationId();

		Organization organization = _organizationLocalService.fetchOrganization(
				organizationId);


		StringBundler seriesJSON = new StringBundler();

		seriesJSON.append(StringPool.OPEN_BRACKET);

		if (!Objects.isNull(organization)) {
			long parentOrganizationId = organization.getParentOrganizationId();

			if (parentOrganizationId > 0) {
				Organization org = _organizationLocalService.fetchOrganization(
					parentOrganizationId);

				List<User> users = _userLocalService.getOrganizationUsers(
					organizationId);

				for (User user : users) {
					List<FitnessRecord> fitnessRecords =
						_fitnessRecordLocalService.getFitnessRecordsByStudentUserId(
							user.getUserId());

					String seriesJSONObject =
						_fitnessChartService.generateSeries(
							user.getFullName(), fitnessRecords);

					seriesJSON.append(seriesJSONObject);
					seriesJSON.append(StringPool.COMMA);
				}
			}
		}

		if (seriesJSON.index() - 1 > 0) {
			seriesJSON.setIndex(seriesJSON.index() - 1);
		}

		seriesJSON.append(StringPool.CLOSE_BRACKET);

		renderRequest.setAttribute("series", seriesJSON.toString());

		return "/view.jsp";
	}

	@Reference
	private FitnessChartService _fitnessChartService;

	@Reference
	private FitnessRecordLocalService _fitnessRecordLocalService;

	@Reference
	private GroupLocalService _groupLocalService;

	@Reference
	private OrganizationLocalService _organizationLocalService;

	@Reference
	private UserLocalService _userLocalService;

}
