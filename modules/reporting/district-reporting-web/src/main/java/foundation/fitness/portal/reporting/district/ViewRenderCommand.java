package foundation.fitness.portal.reporting.district;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import foundation.fitness.portal.service.constants.ReportingPortletKeys;
import org.osgi.service.component.annotations.Component;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

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

		return "/view.jsp";
	}

}
