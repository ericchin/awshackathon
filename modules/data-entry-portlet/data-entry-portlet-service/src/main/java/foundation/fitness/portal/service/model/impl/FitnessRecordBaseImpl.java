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

import foundation.fitness.portal.service.model.FitnessRecord;
import foundation.fitness.portal.service.service.FitnessRecordLocalServiceUtil;

/**
 * The extended model base implementation for the FitnessRecord service. Represents a row in the &quot;NFF_FitnessRecord&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link FitnessRecordImpl}.
 * </p>
 *
 * @author Sten Martinez
 * @see FitnessRecordImpl
 * @see FitnessRecord
 * @generated
 */
@ProviderType
public abstract class FitnessRecordBaseImpl extends FitnessRecordModelImpl
	implements FitnessRecord {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a fitness record model instance should use the {@link FitnessRecord} interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			FitnessRecordLocalServiceUtil.addFitnessRecord(this);
		}
		else {
			FitnessRecordLocalServiceUtil.updateFitnessRecord(this);
		}
	}
}