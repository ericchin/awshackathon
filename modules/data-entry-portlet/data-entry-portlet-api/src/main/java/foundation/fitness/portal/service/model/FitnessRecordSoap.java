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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link foundation.fitness.portal.service.service.http.FitnessRecordServiceSoap}.
 *
 * @author Sten Martinez
 * @see foundation.fitness.portal.service.service.http.FitnessRecordServiceSoap
 * @generated
 */
@ProviderType
public class FitnessRecordSoap implements Serializable {
	public static FitnessRecordSoap toSoapModel(FitnessRecord model) {
		FitnessRecordSoap soapModel = new FitnessRecordSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setRecordId(model.getRecordId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setTeacherUserId(model.getTeacherUserId());
		soapModel.setClassName(model.getClassName());
		soapModel.setStudentFirstName(model.getStudentFirstName());
		soapModel.setStudentLastName(model.getStudentLastName());
		soapModel.setStudentGender(model.getStudentGender());
		soapModel.setStudentId(model.getStudentId());
		soapModel.setStudentGrade(model.getStudentGrade());
		soapModel.setStudentAge(model.getStudentAge());
		soapModel.setTestDate(model.getTestDate());
		soapModel.setHeightFeet(model.getHeightFeet());
		soapModel.setHeightInches(model.getHeightInches());
		soapModel.setWeight(model.getWeight());
		soapModel.setBmi(model.getBmi());
		soapModel.setTriSkinfold(model.getTriSkinfold());
		soapModel.setCalfSkinfold(model.getCalfSkinfold());
		soapModel.setPercentBodyFatCalc(model.getPercentBodyFatCalc());
		soapModel.setPercentBodyFatEntered(model.getPercentBodyFatEntered());
		soapModel.setTwentyMPacerLaps(model.getTwentyMPacerLaps());
		soapModel.setFifteenMPacerLaps(model.getFifteenMPacerLaps());
		soapModel.setPacerVo2Max(model.getPacerVo2Max());
		soapModel.setMileRunMinutes(model.getMileRunMinutes());
		soapModel.setMileRunSeconds(model.getMileRunSeconds());
		soapModel.setMileRunVo2Max(model.getMileRunVo2Max());
		soapModel.setWalkTestMinutes(model.getWalkTestMinutes());
		soapModel.setWalkTestSeconds(model.getWalkTestSeconds());
		soapModel.setWalkTestHrBpm(model.getWalkTestHrBpm());
		soapModel.setWalkTestVo2Max(model.getWalkTestVo2Max());
		soapModel.setCurlUps(model.getCurlUps());
		soapModel.setTrunkLiftInches(model.getTrunkLiftInches());
		soapModel.setPushups(model.getPushups());
		soapModel.setModPullUps(model.getModPullUps());
		soapModel.setFlexArmHangSeconds(model.getFlexArmHangSeconds());
		soapModel.setSitReachLInches(model.getSitReachLInches());
		soapModel.setSitReachRInches(model.getSitReachRInches());
		soapModel.setShoulderStretchL(model.getShoulderStretchL());
		soapModel.setShoulderStretchR(model.getShoulderStretchR());

		return soapModel;
	}

	public static FitnessRecordSoap[] toSoapModels(FitnessRecord[] models) {
		FitnessRecordSoap[] soapModels = new FitnessRecordSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FitnessRecordSoap[][] toSoapModels(FitnessRecord[][] models) {
		FitnessRecordSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new FitnessRecordSoap[models.length][models[0].length];
		}
		else {
			soapModels = new FitnessRecordSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FitnessRecordSoap[] toSoapModels(List<FitnessRecord> models) {
		List<FitnessRecordSoap> soapModels = new ArrayList<FitnessRecordSoap>(models.size());

		for (FitnessRecord model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new FitnessRecordSoap[soapModels.size()]);
	}

	public FitnessRecordSoap() {
	}

	public long getPrimaryKey() {
		return _recordId;
	}

	public void setPrimaryKey(long pk) {
		setRecordId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getRecordId() {
		return _recordId;
	}

	public void setRecordId(long recordId) {
		_recordId = recordId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getTeacherUserId() {
		return _teacherUserId;
	}

	public void setTeacherUserId(long teacherUserId) {
		_teacherUserId = teacherUserId;
	}

	public String getClassName() {
		return _className;
	}

	public void setClassName(String className) {
		_className = className;
	}

	public String getStudentFirstName() {
		return _studentFirstName;
	}

	public void setStudentFirstName(String studentFirstName) {
		_studentFirstName = studentFirstName;
	}

	public String getStudentLastName() {
		return _studentLastName;
	}

	public void setStudentLastName(String studentLastName) {
		_studentLastName = studentLastName;
	}

	public String getStudentGender() {
		return _studentGender;
	}

	public void setStudentGender(String studentGender) {
		_studentGender = studentGender;
	}

	public String getStudentId() {
		return _studentId;
	}

	public void setStudentId(String studentId) {
		_studentId = studentId;
	}

	public String getStudentGrade() {
		return _studentGrade;
	}

	public void setStudentGrade(String studentGrade) {
		_studentGrade = studentGrade;
	}

	public int getStudentAge() {
		return _studentAge;
	}

	public void setStudentAge(int studentAge) {
		_studentAge = studentAge;
	}

	public Date getTestDate() {
		return _testDate;
	}

	public void setTestDate(Date testDate) {
		_testDate = testDate;
	}

	public int getHeightFeet() {
		return _heightFeet;
	}

	public void setHeightFeet(int heightFeet) {
		_heightFeet = heightFeet;
	}

	public int getHeightInches() {
		return _heightInches;
	}

	public void setHeightInches(int heightInches) {
		_heightInches = heightInches;
	}

	public int getWeight() {
		return _weight;
	}

	public void setWeight(int weight) {
		_weight = weight;
	}

	public float getBmi() {
		return _bmi;
	}

	public void setBmi(float bmi) {
		_bmi = bmi;
	}

	public int getTriSkinfold() {
		return _triSkinfold;
	}

	public void setTriSkinfold(int triSkinfold) {
		_triSkinfold = triSkinfold;
	}

	public int getCalfSkinfold() {
		return _calfSkinfold;
	}

	public void setCalfSkinfold(int calfSkinfold) {
		_calfSkinfold = calfSkinfold;
	}

	public float getPercentBodyFatCalc() {
		return _percentBodyFatCalc;
	}

	public void setPercentBodyFatCalc(float percentBodyFatCalc) {
		_percentBodyFatCalc = percentBodyFatCalc;
	}

	public float getPercentBodyFatEntered() {
		return _percentBodyFatEntered;
	}

	public void setPercentBodyFatEntered(float percentBodyFatEntered) {
		_percentBodyFatEntered = percentBodyFatEntered;
	}

	public int getTwentyMPacerLaps() {
		return _twentyMPacerLaps;
	}

	public void setTwentyMPacerLaps(int twentyMPacerLaps) {
		_twentyMPacerLaps = twentyMPacerLaps;
	}

	public int getFifteenMPacerLaps() {
		return _fifteenMPacerLaps;
	}

	public void setFifteenMPacerLaps(int fifteenMPacerLaps) {
		_fifteenMPacerLaps = fifteenMPacerLaps;
	}

	public float getPacerVo2Max() {
		return _pacerVo2Max;
	}

	public void setPacerVo2Max(float pacerVo2Max) {
		_pacerVo2Max = pacerVo2Max;
	}

	public int getMileRunMinutes() {
		return _mileRunMinutes;
	}

	public void setMileRunMinutes(int mileRunMinutes) {
		_mileRunMinutes = mileRunMinutes;
	}

	public int getMileRunSeconds() {
		return _mileRunSeconds;
	}

	public void setMileRunSeconds(int mileRunSeconds) {
		_mileRunSeconds = mileRunSeconds;
	}

	public float getMileRunVo2Max() {
		return _mileRunVo2Max;
	}

	public void setMileRunVo2Max(float mileRunVo2Max) {
		_mileRunVo2Max = mileRunVo2Max;
	}

	public int getWalkTestMinutes() {
		return _walkTestMinutes;
	}

	public void setWalkTestMinutes(int walkTestMinutes) {
		_walkTestMinutes = walkTestMinutes;
	}

	public int getWalkTestSeconds() {
		return _walkTestSeconds;
	}

	public void setWalkTestSeconds(int walkTestSeconds) {
		_walkTestSeconds = walkTestSeconds;
	}

	public int getWalkTestHrBpm() {
		return _walkTestHrBpm;
	}

	public void setWalkTestHrBpm(int walkTestHrBpm) {
		_walkTestHrBpm = walkTestHrBpm;
	}

	public float getWalkTestVo2Max() {
		return _walkTestVo2Max;
	}

	public void setWalkTestVo2Max(float walkTestVo2Max) {
		_walkTestVo2Max = walkTestVo2Max;
	}

	public int getCurlUps() {
		return _curlUps;
	}

	public void setCurlUps(int curlUps) {
		_curlUps = curlUps;
	}

	public int getTrunkLiftInches() {
		return _trunkLiftInches;
	}

	public void setTrunkLiftInches(int trunkLiftInches) {
		_trunkLiftInches = trunkLiftInches;
	}

	public int getPushups() {
		return _pushups;
	}

	public void setPushups(int pushups) {
		_pushups = pushups;
	}

	public int getModPullUps() {
		return _modPullUps;
	}

	public void setModPullUps(int modPullUps) {
		_modPullUps = modPullUps;
	}

	public int getFlexArmHangSeconds() {
		return _flexArmHangSeconds;
	}

	public void setFlexArmHangSeconds(int flexArmHangSeconds) {
		_flexArmHangSeconds = flexArmHangSeconds;
	}

	public int getSitReachLInches() {
		return _sitReachLInches;
	}

	public void setSitReachLInches(int sitReachLInches) {
		_sitReachLInches = sitReachLInches;
	}

	public int getSitReachRInches() {
		return _sitReachRInches;
	}

	public void setSitReachRInches(int sitReachRInches) {
		_sitReachRInches = sitReachRInches;
	}

	public boolean getShoulderStretchL() {
		return _shoulderStretchL;
	}

	public boolean isShoulderStretchL() {
		return _shoulderStretchL;
	}

	public void setShoulderStretchL(boolean shoulderStretchL) {
		_shoulderStretchL = shoulderStretchL;
	}

	public boolean getShoulderStretchR() {
		return _shoulderStretchR;
	}

	public boolean isShoulderStretchR() {
		return _shoulderStretchR;
	}

	public void setShoulderStretchR(boolean shoulderStretchR) {
		_shoulderStretchR = shoulderStretchR;
	}

	private String _uuid;
	private long _recordId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _teacherUserId;
	private String _className;
	private String _studentFirstName;
	private String _studentLastName;
	private String _studentGender;
	private String _studentId;
	private String _studentGrade;
	private int _studentAge;
	private Date _testDate;
	private int _heightFeet;
	private int _heightInches;
	private int _weight;
	private float _bmi;
	private int _triSkinfold;
	private int _calfSkinfold;
	private float _percentBodyFatCalc;
	private float _percentBodyFatEntered;
	private int _twentyMPacerLaps;
	private int _fifteenMPacerLaps;
	private float _pacerVo2Max;
	private int _mileRunMinutes;
	private int _mileRunSeconds;
	private float _mileRunVo2Max;
	private int _walkTestMinutes;
	private int _walkTestSeconds;
	private int _walkTestHrBpm;
	private float _walkTestVo2Max;
	private int _curlUps;
	private int _trunkLiftInches;
	private int _pushups;
	private int _modPullUps;
	private int _flexArmHangSeconds;
	private int _sitReachLInches;
	private int _sitReachRInches;
	private boolean _shoulderStretchL;
	private boolean _shoulderStretchR;
}