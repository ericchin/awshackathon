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

package foundation.fitness.portal.service.service.impl;

import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Organization;
import foundation.fitness.portal.service.model.FitnessRecord;
import foundation.fitness.portal.service.service.base.FitnessRecordLocalServiceBaseImpl;

import java.util.List;
import java.util.Objects;

/**
 * The implementation of the fitness record local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link foundation.fitness.portal.service.service.FitnessRecordLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Sten Martinez
 * @see FitnessRecordLocalServiceBaseImpl
 * @see foundation.fitness.portal.service.service.FitnessRecordLocalServiceUtil
 */
public class FitnessRecordLocalServiceImpl
	extends FitnessRecordLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link foundation.fitness.portal.service.service.FitnessRecordLocalServiceUtil} to access the fitness record local service.
	 */

	public List<FitnessRecord> getFitnessRecordsByGroupId(long groupId) {
		return fitnessRecordPersistence.findByGroupId(groupId);
	}

	public List<FitnessRecord> getFitnessRecordsByUserId(long userId) {
		return fitnessRecordPersistence.findByUserId(userId);
	}
}