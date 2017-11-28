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

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for FitnessRecord. This utility wraps
 * {@link foundation.fitness.portal.service.service.impl.FitnessRecordLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Sten Martinez
 * @see FitnessRecordLocalService
 * @see foundation.fitness.portal.service.service.base.FitnessRecordLocalServiceBaseImpl
 * @see foundation.fitness.portal.service.service.impl.FitnessRecordLocalServiceImpl
 * @generated
 */
@ProviderType
public class FitnessRecordLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link foundation.fitness.portal.service.service.impl.FitnessRecordLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Adds the fitness record to the database. Also notifies the appropriate model listeners.
	*
	* @param fitnessRecord the fitness record
	* @return the fitness record that was added
	*/
	public static foundation.fitness.portal.service.model.FitnessRecord addFitnessRecord(
		foundation.fitness.portal.service.model.FitnessRecord fitnessRecord) {
		return getService().addFitnessRecord(fitnessRecord);
	}

	/**
	* Creates a new fitness record with the primary key. Does not add the fitness record to the database.
	*
	* @param recordId the primary key for the new fitness record
	* @return the new fitness record
	*/
	public static foundation.fitness.portal.service.model.FitnessRecord createFitnessRecord(
		long recordId) {
		return getService().createFitnessRecord(recordId);
	}

	/**
	* Deletes the fitness record from the database. Also notifies the appropriate model listeners.
	*
	* @param fitnessRecord the fitness record
	* @return the fitness record that was removed
	*/
	public static foundation.fitness.portal.service.model.FitnessRecord deleteFitnessRecord(
		foundation.fitness.portal.service.model.FitnessRecord fitnessRecord) {
		return getService().deleteFitnessRecord(fitnessRecord);
	}

	/**
	* Deletes the fitness record with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param recordId the primary key of the fitness record
	* @return the fitness record that was removed
	* @throws PortalException if a fitness record with the primary key could not be found
	*/
	public static foundation.fitness.portal.service.model.FitnessRecord deleteFitnessRecord(
		long recordId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteFitnessRecord(recordId);
	}

	public static foundation.fitness.portal.service.model.FitnessRecord fetchFitnessRecord(
		long recordId) {
		return getService().fetchFitnessRecord(recordId);
	}

	/**
	* Returns the fitness record matching the UUID and group.
	*
	* @param uuid the fitness record's UUID
	* @param groupId the primary key of the group
	* @return the matching fitness record, or <code>null</code> if a matching fitness record could not be found
	*/
	public static foundation.fitness.portal.service.model.FitnessRecord fetchFitnessRecordByUuidAndGroupId(
		java.lang.String uuid, long groupId) {
		return getService().fetchFitnessRecordByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the fitness record with the primary key.
	*
	* @param recordId the primary key of the fitness record
	* @return the fitness record
	* @throws PortalException if a fitness record with the primary key could not be found
	*/
	public static foundation.fitness.portal.service.model.FitnessRecord getFitnessRecord(
		long recordId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getFitnessRecord(recordId);
	}

	/**
	* Returns the fitness record matching the UUID and group.
	*
	* @param uuid the fitness record's UUID
	* @param groupId the primary key of the group
	* @return the matching fitness record
	* @throws PortalException if a matching fitness record could not be found
	*/
	public static foundation.fitness.portal.service.model.FitnessRecord getFitnessRecordByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getFitnessRecordByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Updates the fitness record in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param fitnessRecord the fitness record
	* @return the fitness record that was updated
	*/
	public static foundation.fitness.portal.service.model.FitnessRecord updateFitnessRecord(
		foundation.fitness.portal.service.model.FitnessRecord fitnessRecord) {
		return getService().updateFitnessRecord(fitnessRecord);
	}

	/**
	* Returns the number of fitness records.
	*
	* @return the number of fitness records
	*/
	public static int getFitnessRecordsCount() {
		return getService().getFitnessRecordsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link foundation.fitness.portal.service.model.impl.FitnessRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link foundation.fitness.portal.service.model.impl.FitnessRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns a range of all the fitness records.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link foundation.fitness.portal.service.model.impl.FitnessRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of fitness records
	* @param end the upper bound of the range of fitness records (not inclusive)
	* @return the range of fitness records
	*/
	public static java.util.List<foundation.fitness.portal.service.model.FitnessRecord> getFitnessRecords(
		int start, int end) {
		return getService().getFitnessRecords(start, end);
	}

	public static java.util.List<foundation.fitness.portal.service.model.FitnessRecord> getFitnessRecordsByGroupId(
		long groupId) {
		return getService().getFitnessRecordsByGroupId(groupId);
	}

	public static java.util.List<foundation.fitness.portal.service.model.FitnessRecord> getFitnessRecordsByUserId(
		long userId) {
		return getService().getFitnessRecordsByUserId(userId);
	}

	/**
	* Returns all the fitness records matching the UUID and company.
	*
	* @param uuid the UUID of the fitness records
	* @param companyId the primary key of the company
	* @return the matching fitness records, or an empty list if no matches were found
	*/
	public static java.util.List<foundation.fitness.portal.service.model.FitnessRecord> getFitnessRecordsByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return getService().getFitnessRecordsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns a range of fitness records matching the UUID and company.
	*
	* @param uuid the UUID of the fitness records
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of fitness records
	* @param end the upper bound of the range of fitness records (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching fitness records, or an empty list if no matches were found
	*/
	public static java.util.List<foundation.fitness.portal.service.model.FitnessRecord> getFitnessRecordsByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<foundation.fitness.portal.service.model.FitnessRecord> orderByComparator) {
		return getService()
				   .getFitnessRecordsByUuidAndCompanyId(uuid, companyId, start,
			end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static FitnessRecordLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<FitnessRecordLocalService, FitnessRecordLocalService> _serviceTracker =
		ServiceTrackerFactory.open(FitnessRecordLocalService.class);
}