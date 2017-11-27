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

package foundation.fitness.portal.service.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import foundation.fitness.portal.service.model.FitnessRecord;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing FitnessRecord in entity cache.
 *
 * @author Sten Martinez
 * @see FitnessRecord
 * @generated
 */
@ProviderType
public class FitnessRecordCacheModel implements CacheModel<FitnessRecord>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FitnessRecordCacheModel)) {
			return false;
		}

		FitnessRecordCacheModel fitnessRecordCacheModel = (FitnessRecordCacheModel)obj;

		if (recordId == fitnessRecordCacheModel.recordId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, recordId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(89);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", recordId=");
		sb.append(recordId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", teacherUserId=");
		sb.append(teacherUserId);
		sb.append(", className=");
		sb.append(className);
		sb.append(", studentFirstName=");
		sb.append(studentFirstName);
		sb.append(", studentLastName=");
		sb.append(studentLastName);
		sb.append(", studentGender=");
		sb.append(studentGender);
		sb.append(", studentId=");
		sb.append(studentId);
		sb.append(", studentGrade=");
		sb.append(studentGrade);
		sb.append(", studentAge=");
		sb.append(studentAge);
		sb.append(", testDate=");
		sb.append(testDate);
		sb.append(", heightFeet=");
		sb.append(heightFeet);
		sb.append(", heightInches=");
		sb.append(heightInches);
		sb.append(", weight=");
		sb.append(weight);
		sb.append(", bmi=");
		sb.append(bmi);
		sb.append(", triSkinfold=");
		sb.append(triSkinfold);
		sb.append(", calfSkinfold=");
		sb.append(calfSkinfold);
		sb.append(", percentBodyFatCalc=");
		sb.append(percentBodyFatCalc);
		sb.append(", percentBodyFatEntered=");
		sb.append(percentBodyFatEntered);
		sb.append(", twentyMPacerLaps=");
		sb.append(twentyMPacerLaps);
		sb.append(", fifteenMPacerLaps=");
		sb.append(fifteenMPacerLaps);
		sb.append(", pacerVo2Max=");
		sb.append(pacerVo2Max);
		sb.append(", mileRunMinutes=");
		sb.append(mileRunMinutes);
		sb.append(", mileRunSeconds=");
		sb.append(mileRunSeconds);
		sb.append(", mileRunVo2Max=");
		sb.append(mileRunVo2Max);
		sb.append(", walkTestMinutes=");
		sb.append(walkTestMinutes);
		sb.append(", walkTestSeconds=");
		sb.append(walkTestSeconds);
		sb.append(", walkTestHrBpm=");
		sb.append(walkTestHrBpm);
		sb.append(", walkTestVo2Max=");
		sb.append(walkTestVo2Max);
		sb.append(", curlUps=");
		sb.append(curlUps);
		sb.append(", trunkLiftInches=");
		sb.append(trunkLiftInches);
		sb.append(", pushups=");
		sb.append(pushups);
		sb.append(", modPullUps=");
		sb.append(modPullUps);
		sb.append(", flexArmHangSeconds=");
		sb.append(flexArmHangSeconds);
		sb.append(", sitReachLInches=");
		sb.append(sitReachLInches);
		sb.append(", sitReachRInches=");
		sb.append(sitReachRInches);
		sb.append(", shoulderStretchL=");
		sb.append(shoulderStretchL);
		sb.append(", shoulderStretchR=");
		sb.append(shoulderStretchR);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public FitnessRecord toEntityModel() {
		FitnessRecordImpl fitnessRecordImpl = new FitnessRecordImpl();

		if (uuid == null) {
			fitnessRecordImpl.setUuid(StringPool.BLANK);
		}
		else {
			fitnessRecordImpl.setUuid(uuid);
		}

		fitnessRecordImpl.setRecordId(recordId);
		fitnessRecordImpl.setGroupId(groupId);
		fitnessRecordImpl.setCompanyId(companyId);
		fitnessRecordImpl.setUserId(userId);

		if (userName == null) {
			fitnessRecordImpl.setUserName(StringPool.BLANK);
		}
		else {
			fitnessRecordImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			fitnessRecordImpl.setCreateDate(null);
		}
		else {
			fitnessRecordImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			fitnessRecordImpl.setModifiedDate(null);
		}
		else {
			fitnessRecordImpl.setModifiedDate(new Date(modifiedDate));
		}

		fitnessRecordImpl.setTeacherUserId(teacherUserId);

		if (className == null) {
			fitnessRecordImpl.setClassName(StringPool.BLANK);
		}
		else {
			fitnessRecordImpl.setClassName(className);
		}

		if (studentFirstName == null) {
			fitnessRecordImpl.setStudentFirstName(StringPool.BLANK);
		}
		else {
			fitnessRecordImpl.setStudentFirstName(studentFirstName);
		}

		if (studentLastName == null) {
			fitnessRecordImpl.setStudentLastName(StringPool.BLANK);
		}
		else {
			fitnessRecordImpl.setStudentLastName(studentLastName);
		}

		if (studentGender == null) {
			fitnessRecordImpl.setStudentGender(StringPool.BLANK);
		}
		else {
			fitnessRecordImpl.setStudentGender(studentGender);
		}

		if (studentId == null) {
			fitnessRecordImpl.setStudentId(StringPool.BLANK);
		}
		else {
			fitnessRecordImpl.setStudentId(studentId);
		}

		if (studentGrade == null) {
			fitnessRecordImpl.setStudentGrade(StringPool.BLANK);
		}
		else {
			fitnessRecordImpl.setStudentGrade(studentGrade);
		}

		fitnessRecordImpl.setStudentAge(studentAge);

		if (testDate == Long.MIN_VALUE) {
			fitnessRecordImpl.setTestDate(null);
		}
		else {
			fitnessRecordImpl.setTestDate(new Date(testDate));
		}

		fitnessRecordImpl.setHeightFeet(heightFeet);
		fitnessRecordImpl.setHeightInches(heightInches);
		fitnessRecordImpl.setWeight(weight);
		fitnessRecordImpl.setBmi(bmi);
		fitnessRecordImpl.setTriSkinfold(triSkinfold);
		fitnessRecordImpl.setCalfSkinfold(calfSkinfold);
		fitnessRecordImpl.setPercentBodyFatCalc(percentBodyFatCalc);
		fitnessRecordImpl.setPercentBodyFatEntered(percentBodyFatEntered);
		fitnessRecordImpl.setTwentyMPacerLaps(twentyMPacerLaps);
		fitnessRecordImpl.setFifteenMPacerLaps(fifteenMPacerLaps);
		fitnessRecordImpl.setPacerVo2Max(pacerVo2Max);
		fitnessRecordImpl.setMileRunMinutes(mileRunMinutes);
		fitnessRecordImpl.setMileRunSeconds(mileRunSeconds);
		fitnessRecordImpl.setMileRunVo2Max(mileRunVo2Max);
		fitnessRecordImpl.setWalkTestMinutes(walkTestMinutes);
		fitnessRecordImpl.setWalkTestSeconds(walkTestSeconds);
		fitnessRecordImpl.setWalkTestHrBpm(walkTestHrBpm);
		fitnessRecordImpl.setWalkTestVo2Max(walkTestVo2Max);
		fitnessRecordImpl.setCurlUps(curlUps);
		fitnessRecordImpl.setTrunkLiftInches(trunkLiftInches);
		fitnessRecordImpl.setPushups(pushups);
		fitnessRecordImpl.setModPullUps(modPullUps);
		fitnessRecordImpl.setFlexArmHangSeconds(flexArmHangSeconds);
		fitnessRecordImpl.setSitReachLInches(sitReachLInches);
		fitnessRecordImpl.setSitReachRInches(sitReachRInches);
		fitnessRecordImpl.setShoulderStretchL(shoulderStretchL);
		fitnessRecordImpl.setShoulderStretchR(shoulderStretchR);

		fitnessRecordImpl.resetOriginalValues();

		return fitnessRecordImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		recordId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		teacherUserId = objectInput.readLong();
		className = objectInput.readUTF();
		studentFirstName = objectInput.readUTF();
		studentLastName = objectInput.readUTF();
		studentGender = objectInput.readUTF();
		studentId = objectInput.readUTF();
		studentGrade = objectInput.readUTF();

		studentAge = objectInput.readInt();
		testDate = objectInput.readLong();

		heightFeet = objectInput.readInt();

		heightInches = objectInput.readInt();

		weight = objectInput.readInt();

		bmi = objectInput.readInt();

		triSkinfold = objectInput.readInt();

		calfSkinfold = objectInput.readInt();

		percentBodyFatCalc = objectInput.readFloat();

		percentBodyFatEntered = objectInput.readFloat();

		twentyMPacerLaps = objectInput.readInt();

		fifteenMPacerLaps = objectInput.readInt();

		pacerVo2Max = objectInput.readFloat();

		mileRunMinutes = objectInput.readInt();

		mileRunSeconds = objectInput.readInt();

		mileRunVo2Max = objectInput.readFloat();

		walkTestMinutes = objectInput.readInt();

		walkTestSeconds = objectInput.readInt();

		walkTestHrBpm = objectInput.readInt();

		walkTestVo2Max = objectInput.readFloat();

		curlUps = objectInput.readInt();

		trunkLiftInches = objectInput.readInt();

		pushups = objectInput.readInt();

		modPullUps = objectInput.readInt();

		flexArmHangSeconds = objectInput.readInt();

		sitReachLInches = objectInput.readInt();

		sitReachRInches = objectInput.readInt();

		shoulderStretchL = objectInput.readBoolean();

		shoulderStretchR = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(recordId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(teacherUserId);

		if (className == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(className);
		}

		if (studentFirstName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(studentFirstName);
		}

		if (studentLastName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(studentLastName);
		}

		if (studentGender == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(studentGender);
		}

		if (studentId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(studentId);
		}

		if (studentGrade == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(studentGrade);
		}

		objectOutput.writeInt(studentAge);
		objectOutput.writeLong(testDate);

		objectOutput.writeInt(heightFeet);

		objectOutput.writeInt(heightInches);

		objectOutput.writeInt(weight);

		objectOutput.writeInt(bmi);

		objectOutput.writeInt(triSkinfold);

		objectOutput.writeInt(calfSkinfold);

		objectOutput.writeFloat(percentBodyFatCalc);

		objectOutput.writeFloat(percentBodyFatEntered);

		objectOutput.writeInt(twentyMPacerLaps);

		objectOutput.writeInt(fifteenMPacerLaps);

		objectOutput.writeFloat(pacerVo2Max);

		objectOutput.writeInt(mileRunMinutes);

		objectOutput.writeInt(mileRunSeconds);

		objectOutput.writeFloat(mileRunVo2Max);

		objectOutput.writeInt(walkTestMinutes);

		objectOutput.writeInt(walkTestSeconds);

		objectOutput.writeInt(walkTestHrBpm);

		objectOutput.writeFloat(walkTestVo2Max);

		objectOutput.writeInt(curlUps);

		objectOutput.writeInt(trunkLiftInches);

		objectOutput.writeInt(pushups);

		objectOutput.writeInt(modPullUps);

		objectOutput.writeInt(flexArmHangSeconds);

		objectOutput.writeInt(sitReachLInches);

		objectOutput.writeInt(sitReachRInches);

		objectOutput.writeBoolean(shoulderStretchL);

		objectOutput.writeBoolean(shoulderStretchR);
	}

	public String uuid;
	public long recordId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long teacherUserId;
	public String className;
	public String studentFirstName;
	public String studentLastName;
	public String studentGender;
	public String studentId;
	public String studentGrade;
	public int studentAge;
	public long testDate;
	public int heightFeet;
	public int heightInches;
	public int weight;
	public int bmi;
	public int triSkinfold;
	public int calfSkinfold;
	public float percentBodyFatCalc;
	public float percentBodyFatEntered;
	public int twentyMPacerLaps;
	public int fifteenMPacerLaps;
	public float pacerVo2Max;
	public int mileRunMinutes;
	public int mileRunSeconds;
	public float mileRunVo2Max;
	public int walkTestMinutes;
	public int walkTestSeconds;
	public int walkTestHrBpm;
	public float walkTestVo2Max;
	public int curlUps;
	public int trunkLiftInches;
	public int pushups;
	public int modPullUps;
	public int flexArmHangSeconds;
	public int sitReachLInches;
	public int sitReachRInches;
	public boolean shoulderStretchL;
	public boolean shoulderStretchR;
}