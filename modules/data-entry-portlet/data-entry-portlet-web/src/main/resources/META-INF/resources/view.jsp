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

	<aui:button type="submit" />
</aui:form>