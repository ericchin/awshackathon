package foundation.fitness.portal.reporting.student;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import foundation.fitness.portal.service.constants.ReportingPortletKeys;
import org.osgi.service.component.annotations.Component;

import javax.portlet.Portlet;

/**
 * @author Eric Chin
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.css-class-wrapper=fitness-foundation student-reporting",
		"com.liferay.portlet.display-category=fitness.foundation",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.header-portlet-javascript=/js/main.js",
		"com.liferay.portlet.instanceable=false",
		"com.liferay.portlet.single-page-application=false",
		"javax.portlet.display-name=Student Reporting Portlet",
		"javax.portlet.init-param.add-process-action-success-action=false",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + ReportingPortletKeys.STUDENT_REPORTING_PORTLET,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class StudentReportingPortlet extends MVCPortlet {
}
