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

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the FitnessRecord service. Represents a row in the &quot;NFF_FitnessRecord&quot; database table, with each column mapped to a property of this class.
 *
 * @author Sten Martinez
 * @see FitnessRecordModel
 * @see foundation.fitness.portal.service.model.impl.FitnessRecordImpl
 * @see foundation.fitness.portal.service.model.impl.FitnessRecordModelImpl
 * @generated
 */
@ImplementationClassName("foundation.fitness.portal.service.model.impl.FitnessRecordImpl")
@ProviderType
public interface FitnessRecord extends FitnessRecordModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link foundation.fitness.portal.service.model.impl.FitnessRecordImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<FitnessRecord, Long> RECORD_ID_ACCESSOR = new Accessor<FitnessRecord, Long>() {
			@Override
			public Long get(FitnessRecord fitnessRecord) {
				return fitnessRecord.getRecordId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<FitnessRecord> getTypeClass() {
				return FitnessRecord.class;
			}
		};
}