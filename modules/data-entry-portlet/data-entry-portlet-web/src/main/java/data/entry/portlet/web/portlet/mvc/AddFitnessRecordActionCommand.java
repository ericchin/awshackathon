package data.entry.portlet.web.portlet.mvc;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import foundation.fitness.portal.service.model.FitnessRecord;
import foundation.fitness.portal.service.service.FitnessRecordLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import java.util.Date;

/**
 * User: Sten Martinez
 * Date: 11/27/17
 * Time: 12:46 PM
 */
@Component(
		immediate = true,
		property = {
				"javax.portlet.name=nff_data_entry_portlet",
				"mvc.command.name=/add_fitness_record"
		},
		service = MVCActionCommand.class
)
public class AddFitnessRecordActionCommand extends BaseMVCActionCommand {
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
				WebKeys.THEME_DISPLAY);

		long userId = themeDisplay.getUserId();
		long groupId = themeDisplay.getScopeGroupId();

		String className = ParamUtil.getString(actionRequest, "class");
		String firstName = ParamUtil.getString(actionRequest, "firstName");
		String lastName = ParamUtil.getString(actionRequest, "lastName");
		String studentId = ParamUtil.getString(actionRequest, "studentId");
		String gender = ParamUtil.getString(actionRequest, "gender");
		String grade = ParamUtil.getString(actionRequest, "grade");
		int age = ParamUtil.getInteger(actionRequest, "age");

		FitnessRecord fitnessRecord = fitnessRecordLocalService.createFitnessRecord(counterLocalService.increment());
		fitnessRecord.setUserId(userId);
		fitnessRecord.setUserName(themeDisplay.getUser().getFullName());
		fitnessRecord.setGroupId(groupId);
		fitnessRecord.setTeacherUserId(userId);
		fitnessRecord.setCompanyId(themeDisplay.getCompanyId());
		fitnessRecord.setCreateDate(new Date());

		fitnessRecord.setClassName(className);
		fitnessRecord.setStudentFirstName(firstName);
		fitnessRecord.setStudentLastName(lastName);
		fitnessRecord.setStudentId(studentId);
		fitnessRecord.setStudentGender(gender);
		fitnessRecord.setStudentGrade(grade);
		fitnessRecord.setStudentAge(age);

		fitnessRecordLocalService.updateFitnessRecord(fitnessRecord);
	}

	@Reference
	private FitnessRecordLocalService fitnessRecordLocalService;

	@Reference
	private CounterLocalService counterLocalService;
}
