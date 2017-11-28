/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package foundation.fitness.portal.service.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link FitnessRecord}.
 * </p>
 *
 * @author Sten Martinez
 * @see FitnessRecord
 * @generated
 */
@ProviderType
public class FitnessRecordWrapper implements FitnessRecord,
	ModelWrapper<FitnessRecord> {
	public FitnessRecordWrapper(FitnessRecord fitnessRecord) {
		_fitnessRecord = fitnessRecord;
	}

	@Override
	public Class<?> getModelClass() {
		return FitnessRecord.class;
	}

	@Override
	public String getModelClassName() {
		return FitnessRecord.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("recordId", getRecordId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("teacherUserId", getTeacherUserId());
		attributes.put("className", getClassName());
		attributes.put("studentFirstName", getStudentFirstName());
		attributes.put("studentLastName", getStudentLastName());
		attributes.put("studentGender", getStudentGender());
		attributes.put("studentId", getStudentId());
		attributes.put("studentGrade", getStudentGrade());
		attributes.put("studentAge", getStudentAge());
		attributes.put("testDate", getTestDate());
		attributes.put("heightFeet", getHeightFeet());
		attributes.put("heightInches", getHeightInches());
		attributes.put("weight", getWeight());
		attributes.put("bmi", getBmi());
		attributes.put("triSkinfold", getTriSkinfold());
		attributes.put("calfSkinfold", getCalfSkinfold());
		attributes.put("percentBodyFatCalc", getPercentBodyFatCalc());
		attributes.put("percentBodyFatEntered", getPercentBodyFatEntered());
		attributes.put("twentyMPacerLaps", getTwentyMPacerLaps());
		attributes.put("fifteenMPacerLaps", getFifteenMPacerLaps());
		attributes.put("pacerVo2Max", getPacerVo2Max());
		attributes.put("mileRunMinutes", getMileRunMinutes());
		attributes.put("mileRunSeconds", getMileRunSeconds());
		attributes.put("mileRunVo2Max", getMileRunVo2Max());
		attributes.put("walkTestMinutes", getWalkTestMinutes());
		attributes.put("walkTestSeconds", getWalkTestSeconds());
		attributes.put("walkTestHrBpm", getWalkTestHrBpm());
		attributes.put("walkTestVo2Max", getWalkTestVo2Max());
		attributes.put("curlUps", getCurlUps());
		attributes.put("trunkLiftInches", getTrunkLiftInches());
		attributes.put("pushups", getPushups());
		attributes.put("modPullUps", getModPullUps());
		attributes.put("flexArmHangSeconds", getFlexArmHangSeconds());
		attributes.put("sitReachLInches", getSitReachLInches());
		attributes.put("sitReachRInches", getSitReachRInches());
		attributes.put("shoulderStretchL", getShoulderStretchL());
		attributes.put("shoulderStretchR", getShoulderStretchR());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long recordId = (Long)attributes.get("recordId");

		if (recordId != null) {
			setRecordId(recordId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long teacherUserId = (Long)attributes.get("teacherUserId");

		if (teacherUserId != null) {
			setTeacherUserId(teacherUserId);
		}

		String className = (String)attributes.get("className");

		if (className != null) {
			setClassName(className);
		}

		String studentFirstName = (String)attributes.get("studentFirstName");

		if (studentFirstName != null) {
			setStudentFirstName(studentFirstName);
		}

		String studentLastName = (String)attributes.get("studentLastName");

		if (studentLastName != null) {
			setStudentLastName(studentLastName);
		}

		String studentGender = (String)attributes.get("studentGender");

		if (studentGender != null) {
			setStudentGender(studentGender);
		}

		String studentId = (String)attributes.get("studentId");

		if (studentId != null) {
			setStudentId(studentId);
		}

		String studentGrade = (String)attributes.get("studentGrade");

		if (studentGrade != null) {
			setStudentGrade(studentGrade);
		}

		Integer studentAge = (Integer)attributes.get("studentAge");

		if (studentAge != null) {
			setStudentAge(studentAge);
		}

		Date testDate = (Date)attributes.get("testDate");

		if (testDate != null) {
			setTestDate(testDate);
		}

		Integer heightFeet = (Integer)attributes.get("heightFeet");

		if (heightFeet != null) {
			setHeightFeet(heightFeet);
		}

		Integer heightInches = (Integer)attributes.get("heightInches");

		if (heightInches != null) {
			setHeightInches(heightInches);
		}

		Integer weight = (Integer)attributes.get("weight");

		if (weight != null) {
			setWeight(weight);
		}

		Float bmi = (Float)attributes.get("bmi");

		if (bmi != null) {
			setBmi(bmi);
		}

		Integer triSkinfold = (Integer)attributes.get("triSkinfold");

		if (triSkinfold != null) {
			setTriSkinfold(triSkinfold);
		}

		Integer calfSkinfold = (Integer)attributes.get("calfSkinfold");

		if (calfSkinfold != null) {
			setCalfSkinfold(calfSkinfold);
		}

		Float percentBodyFatCalc = (Float)attributes.get("percentBodyFatCalc");

		if (percentBodyFatCalc != null) {
			setPercentBodyFatCalc(percentBodyFatCalc);
		}

		Float percentBodyFatEntered = (Float)attributes.get(
				"percentBodyFatEntered");

		if (percentBodyFatEntered != null) {
			setPercentBodyFatEntered(percentBodyFatEntered);
		}

		Integer twentyMPacerLaps = (Integer)attributes.get("twentyMPacerLaps");

		if (twentyMPacerLaps != null) {
			setTwentyMPacerLaps(twentyMPacerLaps);
		}

		Integer fifteenMPacerLaps = (Integer)attributes.get("fifteenMPacerLaps");

		if (fifteenMPacerLaps != null) {
			setFifteenMPacerLaps(fifteenMPacerLaps);
		}

		Float pacerVo2Max = (Float)attributes.get("pacerVo2Max");

		if (pacerVo2Max != null) {
			setPacerVo2Max(pacerVo2Max);
		}

		Integer mileRunMinutes = (Integer)attributes.get("mileRunMinutes");

		if (mileRunMinutes != null) {
			setMileRunMinutes(mileRunMinutes);
		}

		Integer mileRunSeconds = (Integer)attributes.get("mileRunSeconds");

		if (mileRunSeconds != null) {
			setMileRunSeconds(mileRunSeconds);
		}

		Float mileRunVo2Max = (Float)attributes.get("mileRunVo2Max");

		if (mileRunVo2Max != null) {
			setMileRunVo2Max(mileRunVo2Max);
		}

		Integer walkTestMinutes = (Integer)attributes.get("walkTestMinutes");

		if (walkTestMinutes != null) {
			setWalkTestMinutes(walkTestMinutes);
		}

		Integer walkTestSeconds = (Integer)attributes.get("walkTestSeconds");

		if (walkTestSeconds != null) {
			setWalkTestSeconds(walkTestSeconds);
		}

		Integer walkTestHrBpm = (Integer)attributes.get("walkTestHrBpm");

		if (walkTestHrBpm != null) {
			setWalkTestHrBpm(walkTestHrBpm);
		}

		Float walkTestVo2Max = (Float)attributes.get("walkTestVo2Max");

		if (walkTestVo2Max != null) {
			setWalkTestVo2Max(walkTestVo2Max);
		}

		Integer curlUps = (Integer)attributes.get("curlUps");

		if (curlUps != null) {
			setCurlUps(curlUps);
		}

		Integer trunkLiftInches = (Integer)attributes.get("trunkLiftInches");

		if (trunkLiftInches != null) {
			setTrunkLiftInches(trunkLiftInches);
		}

		Integer pushups = (Integer)attributes.get("pushups");

		if (pushups != null) {
			setPushups(pushups);
		}

		Integer modPullUps = (Integer)attributes.get("modPullUps");

		if (modPullUps != null) {
			setModPullUps(modPullUps);
		}

		Integer flexArmHangSeconds = (Integer)attributes.get(
				"flexArmHangSeconds");

		if (flexArmHangSeconds != null) {
			setFlexArmHangSeconds(flexArmHangSeconds);
		}

		Integer sitReachLInches = (Integer)attributes.get("sitReachLInches");

		if (sitReachLInches != null) {
			setSitReachLInches(sitReachLInches);
		}

		Integer sitReachRInches = (Integer)attributes.get("sitReachRInches");

		if (sitReachRInches != null) {
			setSitReachRInches(sitReachRInches);
		}

		Boolean shoulderStretchL = (Boolean)attributes.get("shoulderStretchL");

		if (shoulderStretchL != null) {
			setShoulderStretchL(shoulderStretchL);
		}

		Boolean shoulderStretchR = (Boolean)attributes.get("shoulderStretchR");

		if (shoulderStretchR != null) {
			setShoulderStretchR(shoulderStretchR);
		}
	}

	/**
	* Returns the shoulder stretch l of this fitness record.
	*
	* @return the shoulder stretch l of this fitness record
	*/
	@Override
	public boolean getShoulderStretchL() {
		return _fitnessRecord.getShoulderStretchL();
	}

	/**
	* Returns the shoulder stretch r of this fitness record.
	*
	* @return the shoulder stretch r of this fitness record
	*/
	@Override
	public boolean getShoulderStretchR() {
		return _fitnessRecord.getShoulderStretchR();
	}

	@Override
	public boolean isCachedModel() {
		return _fitnessRecord.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _fitnessRecord.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _fitnessRecord.isNew();
	}

	/**
	* Returns <code>true</code> if this fitness record is shoulder stretch l.
	*
	* @return <code>true</code> if this fitness record is shoulder stretch l; <code>false</code> otherwise
	*/
	@Override
	public boolean isShoulderStretchL() {
		return _fitnessRecord.isShoulderStretchL();
	}

	/**
	* Returns <code>true</code> if this fitness record is shoulder stretch r.
	*
	* @return <code>true</code> if this fitness record is shoulder stretch r; <code>false</code> otherwise
	*/
	@Override
	public boolean isShoulderStretchR() {
		return _fitnessRecord.isShoulderStretchR();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _fitnessRecord.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<foundation.fitness.portal.service.model.FitnessRecord> toCacheModel() {
		return _fitnessRecord.toCacheModel();
	}

	/**
	* Returns the bmi of this fitness record.
	*
	* @return the bmi of this fitness record
	*/
	@Override
	public float getBmi() {
		return _fitnessRecord.getBmi();
	}

	/**
	* Returns the mile run vo2 max of this fitness record.
	*
	* @return the mile run vo2 max of this fitness record
	*/
	@Override
	public float getMileRunVo2Max() {
		return _fitnessRecord.getMileRunVo2Max();
	}

	/**
	* Returns the pacer vo2 max of this fitness record.
	*
	* @return the pacer vo2 max of this fitness record
	*/
	@Override
	public float getPacerVo2Max() {
		return _fitnessRecord.getPacerVo2Max();
	}

	/**
	* Returns the percent body fat calc of this fitness record.
	*
	* @return the percent body fat calc of this fitness record
	*/
	@Override
	public float getPercentBodyFatCalc() {
		return _fitnessRecord.getPercentBodyFatCalc();
	}

	/**
	* Returns the percent body fat entered of this fitness record.
	*
	* @return the percent body fat entered of this fitness record
	*/
	@Override
	public float getPercentBodyFatEntered() {
		return _fitnessRecord.getPercentBodyFatEntered();
	}

	/**
	* Returns the walk test vo2 max of this fitness record.
	*
	* @return the walk test vo2 max of this fitness record
	*/
	@Override
	public float getWalkTestVo2Max() {
		return _fitnessRecord.getWalkTestVo2Max();
	}

	@Override
	public foundation.fitness.portal.service.model.FitnessRecord toEscapedModel() {
		return new FitnessRecordWrapper(_fitnessRecord.toEscapedModel());
	}

	@Override
	public foundation.fitness.portal.service.model.FitnessRecord toUnescapedModel() {
		return new FitnessRecordWrapper(_fitnessRecord.toUnescapedModel());
	}

	@Override
	public int compareTo(
		foundation.fitness.portal.service.model.FitnessRecord fitnessRecord) {
		return _fitnessRecord.compareTo(fitnessRecord);
	}

	/**
	* Returns the calf skinfold of this fitness record.
	*
	* @return the calf skinfold of this fitness record
	*/
	@Override
	public int getCalfSkinfold() {
		return _fitnessRecord.getCalfSkinfold();
	}

	/**
	* Returns the curl ups of this fitness record.
	*
	* @return the curl ups of this fitness record
	*/
	@Override
	public int getCurlUps() {
		return _fitnessRecord.getCurlUps();
	}

	/**
	* Returns the fifteen m pacer laps of this fitness record.
	*
	* @return the fifteen m pacer laps of this fitness record
	*/
	@Override
	public int getFifteenMPacerLaps() {
		return _fitnessRecord.getFifteenMPacerLaps();
	}

	/**
	* Returns the flex arm hang seconds of this fitness record.
	*
	* @return the flex arm hang seconds of this fitness record
	*/
	@Override
	public int getFlexArmHangSeconds() {
		return _fitnessRecord.getFlexArmHangSeconds();
	}

	/**
	* Returns the height feet of this fitness record.
	*
	* @return the height feet of this fitness record
	*/
	@Override
	public int getHeightFeet() {
		return _fitnessRecord.getHeightFeet();
	}

	/**
	* Returns the height inches of this fitness record.
	*
	* @return the height inches of this fitness record
	*/
	@Override
	public int getHeightInches() {
		return _fitnessRecord.getHeightInches();
	}

	/**
	* Returns the mile run minutes of this fitness record.
	*
	* @return the mile run minutes of this fitness record
	*/
	@Override
	public int getMileRunMinutes() {
		return _fitnessRecord.getMileRunMinutes();
	}

	/**
	* Returns the mile run seconds of this fitness record.
	*
	* @return the mile run seconds of this fitness record
	*/
	@Override
	public int getMileRunSeconds() {
		return _fitnessRecord.getMileRunSeconds();
	}

	/**
	* Returns the mod pull ups of this fitness record.
	*
	* @return the mod pull ups of this fitness record
	*/
	@Override
	public int getModPullUps() {
		return _fitnessRecord.getModPullUps();
	}

	/**
	* Returns the pushups of this fitness record.
	*
	* @return the pushups of this fitness record
	*/
	@Override
	public int getPushups() {
		return _fitnessRecord.getPushups();
	}

	/**
	* Returns the sit reach l inches of this fitness record.
	*
	* @return the sit reach l inches of this fitness record
	*/
	@Override
	public int getSitReachLInches() {
		return _fitnessRecord.getSitReachLInches();
	}

	/**
	* Returns the sit reach r inches of this fitness record.
	*
	* @return the sit reach r inches of this fitness record
	*/
	@Override
	public int getSitReachRInches() {
		return _fitnessRecord.getSitReachRInches();
	}

	/**
	* Returns the student age of this fitness record.
	*
	* @return the student age of this fitness record
	*/
	@Override
	public int getStudentAge() {
		return _fitnessRecord.getStudentAge();
	}

	/**
	* Returns the tri skinfold of this fitness record.
	*
	* @return the tri skinfold of this fitness record
	*/
	@Override
	public int getTriSkinfold() {
		return _fitnessRecord.getTriSkinfold();
	}

	/**
	* Returns the trunk lift inches of this fitness record.
	*
	* @return the trunk lift inches of this fitness record
	*/
	@Override
	public int getTrunkLiftInches() {
		return _fitnessRecord.getTrunkLiftInches();
	}

	/**
	* Returns the twenty m pacer laps of this fitness record.
	*
	* @return the twenty m pacer laps of this fitness record
	*/
	@Override
	public int getTwentyMPacerLaps() {
		return _fitnessRecord.getTwentyMPacerLaps();
	}

	/**
	* Returns the walk test hr bpm of this fitness record.
	*
	* @return the walk test hr bpm of this fitness record
	*/
	@Override
	public int getWalkTestHrBpm() {
		return _fitnessRecord.getWalkTestHrBpm();
	}

	/**
	* Returns the walk test minutes of this fitness record.
	*
	* @return the walk test minutes of this fitness record
	*/
	@Override
	public int getWalkTestMinutes() {
		return _fitnessRecord.getWalkTestMinutes();
	}

	/**
	* Returns the walk test seconds of this fitness record.
	*
	* @return the walk test seconds of this fitness record
	*/
	@Override
	public int getWalkTestSeconds() {
		return _fitnessRecord.getWalkTestSeconds();
	}

	/**
	* Returns the weight of this fitness record.
	*
	* @return the weight of this fitness record
	*/
	@Override
	public int getWeight() {
		return _fitnessRecord.getWeight();
	}

	@Override
	public int hashCode() {
		return _fitnessRecord.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _fitnessRecord.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new FitnessRecordWrapper((FitnessRecord)_fitnessRecord.clone());
	}

	/**
	* Returns the class name of this fitness record.
	*
	* @return the class name of this fitness record
	*/
	@Override
	public java.lang.String getClassName() {
		return _fitnessRecord.getClassName();
	}

	/**
	* Returns the student first name of this fitness record.
	*
	* @return the student first name of this fitness record
	*/
	@Override
	public java.lang.String getStudentFirstName() {
		return _fitnessRecord.getStudentFirstName();
	}

	/**
	* Returns the student gender of this fitness record.
	*
	* @return the student gender of this fitness record
	*/
	@Override
	public java.lang.String getStudentGender() {
		return _fitnessRecord.getStudentGender();
	}

	/**
	* Returns the student grade of this fitness record.
	*
	* @return the student grade of this fitness record
	*/
	@Override
	public java.lang.String getStudentGrade() {
		return _fitnessRecord.getStudentGrade();
	}

	/**
	* Returns the student ID of this fitness record.
	*
	* @return the student ID of this fitness record
	*/
	@Override
	public java.lang.String getStudentId() {
		return _fitnessRecord.getStudentId();
	}

	/**
	* Returns the student last name of this fitness record.
	*
	* @return the student last name of this fitness record
	*/
	@Override
	public java.lang.String getStudentLastName() {
		return _fitnessRecord.getStudentLastName();
	}

	/**
	* Returns the teacher user uuid of this fitness record.
	*
	* @return the teacher user uuid of this fitness record
	*/
	@Override
	public java.lang.String getTeacherUserUuid() {
		return _fitnessRecord.getTeacherUserUuid();
	}

	/**
	* Returns the user name of this fitness record.
	*
	* @return the user name of this fitness record
	*/
	@Override
	public java.lang.String getUserName() {
		return _fitnessRecord.getUserName();
	}

	/**
	* Returns the user uuid of this fitness record.
	*
	* @return the user uuid of this fitness record
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _fitnessRecord.getUserUuid();
	}

	/**
	* Returns the uuid of this fitness record.
	*
	* @return the uuid of this fitness record
	*/
	@Override
	public java.lang.String getUuid() {
		return _fitnessRecord.getUuid();
	}

	@Override
	public java.lang.String toString() {
		return _fitnessRecord.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _fitnessRecord.toXmlString();
	}

	/**
	* Returns the create date of this fitness record.
	*
	* @return the create date of this fitness record
	*/
	@Override
	public Date getCreateDate() {
		return _fitnessRecord.getCreateDate();
	}

	/**
	* Returns the modified date of this fitness record.
	*
	* @return the modified date of this fitness record
	*/
	@Override
	public Date getModifiedDate() {
		return _fitnessRecord.getModifiedDate();
	}

	/**
	* Returns the test date of this fitness record.
	*
	* @return the test date of this fitness record
	*/
	@Override
	public Date getTestDate() {
		return _fitnessRecord.getTestDate();
	}

	/**
	* Returns the company ID of this fitness record.
	*
	* @return the company ID of this fitness record
	*/
	@Override
	public long getCompanyId() {
		return _fitnessRecord.getCompanyId();
	}

	/**
	* Returns the group ID of this fitness record.
	*
	* @return the group ID of this fitness record
	*/
	@Override
	public long getGroupId() {
		return _fitnessRecord.getGroupId();
	}

	/**
	* Returns the primary key of this fitness record.
	*
	* @return the primary key of this fitness record
	*/
	@Override
	public long getPrimaryKey() {
		return _fitnessRecord.getPrimaryKey();
	}

	/**
	* Returns the record ID of this fitness record.
	*
	* @return the record ID of this fitness record
	*/
	@Override
	public long getRecordId() {
		return _fitnessRecord.getRecordId();
	}

	/**
	* Returns the teacher user ID of this fitness record.
	*
	* @return the teacher user ID of this fitness record
	*/
	@Override
	public long getTeacherUserId() {
		return _fitnessRecord.getTeacherUserId();
	}

	/**
	* Returns the user ID of this fitness record.
	*
	* @return the user ID of this fitness record
	*/
	@Override
	public long getUserId() {
		return _fitnessRecord.getUserId();
	}

	@Override
	public void persist() {
		_fitnessRecord.persist();
	}

	/**
	* Sets the bmi of this fitness record.
	*
	* @param bmi the bmi of this fitness record
	*/
	@Override
	public void setBmi(float bmi) {
		_fitnessRecord.setBmi(bmi);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_fitnessRecord.setCachedModel(cachedModel);
	}

	/**
	* Sets the calf skinfold of this fitness record.
	*
	* @param calfSkinfold the calf skinfold of this fitness record
	*/
	@Override
	public void setCalfSkinfold(int calfSkinfold) {
		_fitnessRecord.setCalfSkinfold(calfSkinfold);
	}

	/**
	* Sets the class name of this fitness record.
	*
	* @param className the class name of this fitness record
	*/
	@Override
	public void setClassName(java.lang.String className) {
		_fitnessRecord.setClassName(className);
	}

	/**
	* Sets the company ID of this fitness record.
	*
	* @param companyId the company ID of this fitness record
	*/
	@Override
	public void setCompanyId(long companyId) {
		_fitnessRecord.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this fitness record.
	*
	* @param createDate the create date of this fitness record
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_fitnessRecord.setCreateDate(createDate);
	}

	/**
	* Sets the curl ups of this fitness record.
	*
	* @param curlUps the curl ups of this fitness record
	*/
	@Override
	public void setCurlUps(int curlUps) {
		_fitnessRecord.setCurlUps(curlUps);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_fitnessRecord.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_fitnessRecord.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_fitnessRecord.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the fifteen m pacer laps of this fitness record.
	*
	* @param fifteenMPacerLaps the fifteen m pacer laps of this fitness record
	*/
	@Override
	public void setFifteenMPacerLaps(int fifteenMPacerLaps) {
		_fitnessRecord.setFifteenMPacerLaps(fifteenMPacerLaps);
	}

	/**
	* Sets the flex arm hang seconds of this fitness record.
	*
	* @param flexArmHangSeconds the flex arm hang seconds of this fitness record
	*/
	@Override
	public void setFlexArmHangSeconds(int flexArmHangSeconds) {
		_fitnessRecord.setFlexArmHangSeconds(flexArmHangSeconds);
	}

	/**
	* Sets the group ID of this fitness record.
	*
	* @param groupId the group ID of this fitness record
	*/
	@Override
	public void setGroupId(long groupId) {
		_fitnessRecord.setGroupId(groupId);
	}

	/**
	* Sets the height feet of this fitness record.
	*
	* @param heightFeet the height feet of this fitness record
	*/
	@Override
	public void setHeightFeet(int heightFeet) {
		_fitnessRecord.setHeightFeet(heightFeet);
	}

	/**
	* Sets the height inches of this fitness record.
	*
	* @param heightInches the height inches of this fitness record
	*/
	@Override
	public void setHeightInches(int heightInches) {
		_fitnessRecord.setHeightInches(heightInches);
	}

	/**
	* Sets the mile run minutes of this fitness record.
	*
	* @param mileRunMinutes the mile run minutes of this fitness record
	*/
	@Override
	public void setMileRunMinutes(int mileRunMinutes) {
		_fitnessRecord.setMileRunMinutes(mileRunMinutes);
	}

	/**
	* Sets the mile run seconds of this fitness record.
	*
	* @param mileRunSeconds the mile run seconds of this fitness record
	*/
	@Override
	public void setMileRunSeconds(int mileRunSeconds) {
		_fitnessRecord.setMileRunSeconds(mileRunSeconds);
	}

	/**
	* Sets the mile run vo2 max of this fitness record.
	*
	* @param mileRunVo2Max the mile run vo2 max of this fitness record
	*/
	@Override
	public void setMileRunVo2Max(float mileRunVo2Max) {
		_fitnessRecord.setMileRunVo2Max(mileRunVo2Max);
	}

	/**
	* Sets the mod pull ups of this fitness record.
	*
	* @param modPullUps the mod pull ups of this fitness record
	*/
	@Override
	public void setModPullUps(int modPullUps) {
		_fitnessRecord.setModPullUps(modPullUps);
	}

	/**
	* Sets the modified date of this fitness record.
	*
	* @param modifiedDate the modified date of this fitness record
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_fitnessRecord.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_fitnessRecord.setNew(n);
	}

	/**
	* Sets the pacer vo2 max of this fitness record.
	*
	* @param pacerVo2Max the pacer vo2 max of this fitness record
	*/
	@Override
	public void setPacerVo2Max(float pacerVo2Max) {
		_fitnessRecord.setPacerVo2Max(pacerVo2Max);
	}

	/**
	* Sets the percent body fat calc of this fitness record.
	*
	* @param percentBodyFatCalc the percent body fat calc of this fitness record
	*/
	@Override
	public void setPercentBodyFatCalc(float percentBodyFatCalc) {
		_fitnessRecord.setPercentBodyFatCalc(percentBodyFatCalc);
	}

	/**
	* Sets the percent body fat entered of this fitness record.
	*
	* @param percentBodyFatEntered the percent body fat entered of this fitness record
	*/
	@Override
	public void setPercentBodyFatEntered(float percentBodyFatEntered) {
		_fitnessRecord.setPercentBodyFatEntered(percentBodyFatEntered);
	}

	/**
	* Sets the primary key of this fitness record.
	*
	* @param primaryKey the primary key of this fitness record
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_fitnessRecord.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_fitnessRecord.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the pushups of this fitness record.
	*
	* @param pushups the pushups of this fitness record
	*/
	@Override
	public void setPushups(int pushups) {
		_fitnessRecord.setPushups(pushups);
	}

	/**
	* Sets the record ID of this fitness record.
	*
	* @param recordId the record ID of this fitness record
	*/
	@Override
	public void setRecordId(long recordId) {
		_fitnessRecord.setRecordId(recordId);
	}

	/**
	* Sets whether this fitness record is shoulder stretch l.
	*
	* @param shoulderStretchL the shoulder stretch l of this fitness record
	*/
	@Override
	public void setShoulderStretchL(boolean shoulderStretchL) {
		_fitnessRecord.setShoulderStretchL(shoulderStretchL);
	}

	/**
	* Sets whether this fitness record is shoulder stretch r.
	*
	* @param shoulderStretchR the shoulder stretch r of this fitness record
	*/
	@Override
	public void setShoulderStretchR(boolean shoulderStretchR) {
		_fitnessRecord.setShoulderStretchR(shoulderStretchR);
	}

	/**
	* Sets the sit reach l inches of this fitness record.
	*
	* @param sitReachLInches the sit reach l inches of this fitness record
	*/
	@Override
	public void setSitReachLInches(int sitReachLInches) {
		_fitnessRecord.setSitReachLInches(sitReachLInches);
	}

	/**
	* Sets the sit reach r inches of this fitness record.
	*
	* @param sitReachRInches the sit reach r inches of this fitness record
	*/
	@Override
	public void setSitReachRInches(int sitReachRInches) {
		_fitnessRecord.setSitReachRInches(sitReachRInches);
	}

	/**
	* Sets the student age of this fitness record.
	*
	* @param studentAge the student age of this fitness record
	*/
	@Override
	public void setStudentAge(int studentAge) {
		_fitnessRecord.setStudentAge(studentAge);
	}

	/**
	* Sets the student first name of this fitness record.
	*
	* @param studentFirstName the student first name of this fitness record
	*/
	@Override
	public void setStudentFirstName(java.lang.String studentFirstName) {
		_fitnessRecord.setStudentFirstName(studentFirstName);
	}

	/**
	* Sets the student gender of this fitness record.
	*
	* @param studentGender the student gender of this fitness record
	*/
	@Override
	public void setStudentGender(java.lang.String studentGender) {
		_fitnessRecord.setStudentGender(studentGender);
	}

	/**
	* Sets the student grade of this fitness record.
	*
	* @param studentGrade the student grade of this fitness record
	*/
	@Override
	public void setStudentGrade(java.lang.String studentGrade) {
		_fitnessRecord.setStudentGrade(studentGrade);
	}

	/**
	* Sets the student ID of this fitness record.
	*
	* @param studentId the student ID of this fitness record
	*/
	@Override
	public void setStudentId(java.lang.String studentId) {
		_fitnessRecord.setStudentId(studentId);
	}

	/**
	* Sets the student last name of this fitness record.
	*
	* @param studentLastName the student last name of this fitness record
	*/
	@Override
	public void setStudentLastName(java.lang.String studentLastName) {
		_fitnessRecord.setStudentLastName(studentLastName);
	}

	/**
	* Sets the teacher user ID of this fitness record.
	*
	* @param teacherUserId the teacher user ID of this fitness record
	*/
	@Override
	public void setTeacherUserId(long teacherUserId) {
		_fitnessRecord.setTeacherUserId(teacherUserId);
	}

	/**
	* Sets the teacher user uuid of this fitness record.
	*
	* @param teacherUserUuid the teacher user uuid of this fitness record
	*/
	@Override
	public void setTeacherUserUuid(java.lang.String teacherUserUuid) {
		_fitnessRecord.setTeacherUserUuid(teacherUserUuid);
	}

	/**
	* Sets the test date of this fitness record.
	*
	* @param testDate the test date of this fitness record
	*/
	@Override
	public void setTestDate(Date testDate) {
		_fitnessRecord.setTestDate(testDate);
	}

	/**
	* Sets the tri skinfold of this fitness record.
	*
	* @param triSkinfold the tri skinfold of this fitness record
	*/
	@Override
	public void setTriSkinfold(int triSkinfold) {
		_fitnessRecord.setTriSkinfold(triSkinfold);
	}

	/**
	* Sets the trunk lift inches of this fitness record.
	*
	* @param trunkLiftInches the trunk lift inches of this fitness record
	*/
	@Override
	public void setTrunkLiftInches(int trunkLiftInches) {
		_fitnessRecord.setTrunkLiftInches(trunkLiftInches);
	}

	/**
	* Sets the twenty m pacer laps of this fitness record.
	*
	* @param twentyMPacerLaps the twenty m pacer laps of this fitness record
	*/
	@Override
	public void setTwentyMPacerLaps(int twentyMPacerLaps) {
		_fitnessRecord.setTwentyMPacerLaps(twentyMPacerLaps);
	}

	/**
	* Sets the user ID of this fitness record.
	*
	* @param userId the user ID of this fitness record
	*/
	@Override
	public void setUserId(long userId) {
		_fitnessRecord.setUserId(userId);
	}

	/**
	* Sets the user name of this fitness record.
	*
	* @param userName the user name of this fitness record
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_fitnessRecord.setUserName(userName);
	}

	/**
	* Sets the user uuid of this fitness record.
	*
	* @param userUuid the user uuid of this fitness record
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_fitnessRecord.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this fitness record.
	*
	* @param uuid the uuid of this fitness record
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_fitnessRecord.setUuid(uuid);
	}

	/**
	* Sets the walk test hr bpm of this fitness record.
	*
	* @param walkTestHrBpm the walk test hr bpm of this fitness record
	*/
	@Override
	public void setWalkTestHrBpm(int walkTestHrBpm) {
		_fitnessRecord.setWalkTestHrBpm(walkTestHrBpm);
	}

	/**
	* Sets the walk test minutes of this fitness record.
	*
	* @param walkTestMinutes the walk test minutes of this fitness record
	*/
	@Override
	public void setWalkTestMinutes(int walkTestMinutes) {
		_fitnessRecord.setWalkTestMinutes(walkTestMinutes);
	}

	/**
	* Sets the walk test seconds of this fitness record.
	*
	* @param walkTestSeconds the walk test seconds of this fitness record
	*/
	@Override
	public void setWalkTestSeconds(int walkTestSeconds) {
		_fitnessRecord.setWalkTestSeconds(walkTestSeconds);
	}

	/**
	* Sets the walk test vo2 max of this fitness record.
	*
	* @param walkTestVo2Max the walk test vo2 max of this fitness record
	*/
	@Override
	public void setWalkTestVo2Max(float walkTestVo2Max) {
		_fitnessRecord.setWalkTestVo2Max(walkTestVo2Max);
	}

	/**
	* Sets the weight of this fitness record.
	*
	* @param weight the weight of this fitness record
	*/
	@Override
	public void setWeight(int weight) {
		_fitnessRecord.setWeight(weight);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FitnessRecordWrapper)) {
			return false;
		}

		FitnessRecordWrapper fitnessRecordWrapper = (FitnessRecordWrapper)obj;

		if (Objects.equals(_fitnessRecord, fitnessRecordWrapper._fitnessRecord)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _fitnessRecord.getStagedModelType();
	}

	@Override
	public FitnessRecord getWrappedModel() {
		return _fitnessRecord;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _fitnessRecord.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _fitnessRecord.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_fitnessRecord.resetOriginalValues();
	}

	private final FitnessRecord _fitnessRecord;
}