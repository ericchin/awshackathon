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

package foundation.fitness.portal.service.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link FitnessRecordService}.
 *
 * @author Sten Martinez
 * @see FitnessRecordService
 * @generated
 */
@ProviderType
public class FitnessRecordServiceWrapper implements FitnessRecordService,
	ServiceWrapper<FitnessRecordService> {
	public FitnessRecordServiceWrapper(
		FitnessRecordService fitnessRecordService) {
		_fitnessRecordService = fitnessRecordService;
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _fitnessRecordService.getOSGiServiceIdentifier();
	}

	@Override
	public FitnessRecordService getWrappedService() {
		return _fitnessRecordService;
	}

	@Override
	public void setWrappedService(FitnessRecordService fitnessRecordService) {
		_fitnessRecordService = fitnessRecordService;
	}

	private FitnessRecordService _fitnessRecordService;
}