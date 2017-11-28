<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>

<portlet:actionURL name="/add_fitness_record" var="addRecordURL"/>

<aui:form action="${addRecordURL}" method="post" name="fm">
	<aui:fieldset-group markupView="lexicon">
		<aui:fieldset label="Teacher/Class Info">
			<%--@elvariable id="teacherUser" type="com.liferay.portal.kernel.model.User"--%>
			<aui:input name="teacherName" label="Teacher" value="${teacherUser.getFullName(false, false)}" disabled="true"/>
			<aui:input name="class" label="Class"/>
		</aui:fieldset>
	</aui:fieldset-group>

	<aui:fieldset-group markupView="lexicon">
		<aui:fieldset label="Student Info">
			<aui:input name="firstName" label="First Name"/>
			<aui:input name="lastName" label="Last Name"/>
			<aui:input name="studentId" label="ID"/>
			<aui:input name="gender" label="Gender" required="true"/>
			<aui:input name="grade" label="Grade" required="true"/>
			<aui:input name="age" label="Age" required="true"/>
		</aui:fieldset>
	</aui:fieldset-group>

	<aui:fieldset-group markupView="lexicon">
		<aui:fieldset label="Body Composition">
			<aui:input name="heightFeet" label="Height (Feet)"/>
			<aui:input name="heightInches" label="Height (Inches)"/>
			<aui:input name="weightPounds" label="Weight (Pounds)"/>
			<aui:input name="bmi" label="BMI (Calculated)" disabled="true"/>
			<aui:input name="triSkinfold" label="Triceps Skinfold"/>
			<aui:input name="calfSkinfold" label="Calf Skinfold" />
			<aui:input name="percentBodyFatCalc" label="Percent Body Fat (Calculated)" disabled="true"/>
			<aui:input name="percentBodyFatEntered" label="Percent Body Fat (Entered)"/>
		</aui:fieldset>
	</aui:fieldset-group>

	<aui:fieldset-group markupView="lexicon">
		<aui:fieldset label="Aerobic Capacity">
			<aui:input name="twentyMPacerLaps" label="20M PACER Laps"/>
			<aui:input name="fifteenMPacerLaps" label="15M PACER Laps"/>
			<aui:input name="pacerVo2Max" label="PACER VO2max" disabled="true"/>
			<aui:input name="mileMinutes" label="Mile Run - Minutes"/>
			<aui:input name="mileSeconds" label="Mile Run - Seconds"/>
			<aui:input name="mileVo2Max" label="Mile Run VO2max" disabled="true" />
			<aui:input name="walkMinutes" label="Walk Test - Minutes"/>
			<aui:input name="walkSeconds" label="Walk Test - Seconds"/>
			<aui:input name="walkHrBpm" label="Walk Test - HR (BPM)"/>
			<aui:input name="walkVo2Max" label="Walk Test VO2max" disabled="true"/>
		</aui:fieldset>
	</aui:fieldset-group>

	<aui:button type="submit" />
</aui:form>