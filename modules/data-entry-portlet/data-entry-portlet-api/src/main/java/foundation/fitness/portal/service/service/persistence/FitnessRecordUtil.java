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

package foundation.fitness.portal.service.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import foundation.fitness.portal.service.model.FitnessRecord;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the fitness record service. This utility wraps {@link foundation.fitness.portal.service.service.persistence.impl.FitnessRecordPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Sten Martinez
 * @see FitnessRecordPersistence
 * @see foundation.fitness.portal.service.service.persistence.impl.FitnessRecordPersistenceImpl
 * @generated
 */
@ProviderType
public class FitnessRecordUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(FitnessRecord fitnessRecord) {
		getPersistence().clearCache(fitnessRecord);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<FitnessRecord> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<FitnessRecord> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<FitnessRecord> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<FitnessRecord> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static FitnessRecord update(FitnessRecord fitnessRecord) {
		return getPersistence().update(fitnessRecord);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static FitnessRecord update(FitnessRecord fitnessRecord,
		ServiceContext serviceContext) {
		return getPersistence().update(fitnessRecord, serviceContext);
	}

	/**
	* Returns all the fitness records where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching fitness records
	*/
	public static List<FitnessRecord> findByUuid(java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the fitness records where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FitnessRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of fitness records
	* @param end the upper bound of the range of fitness records (not inclusive)
	* @return the range of matching fitness records
	*/
	public static List<FitnessRecord> findByUuid(java.lang.String uuid,
		int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the fitness records where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FitnessRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of fitness records
	* @param end the upper bound of the range of fitness records (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching fitness records
	*/
	public static List<FitnessRecord> findByUuid(java.lang.String uuid,
		int start, int end, OrderByComparator<FitnessRecord> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the fitness records where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FitnessRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of fitness records
	* @param end the upper bound of the range of fitness records (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching fitness records
	*/
	public static List<FitnessRecord> findByUuid(java.lang.String uuid,
		int start, int end, OrderByComparator<FitnessRecord> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first fitness record in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fitness record
	* @throws NoSuchFitnessRecordException if a matching fitness record could not be found
	*/
	public static FitnessRecord findByUuid_First(java.lang.String uuid,
		OrderByComparator<FitnessRecord> orderByComparator)
		throws foundation.fitness.portal.service.exception.NoSuchFitnessRecordException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first fitness record in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fitness record, or <code>null</code> if a matching fitness record could not be found
	*/
	public static FitnessRecord fetchByUuid_First(java.lang.String uuid,
		OrderByComparator<FitnessRecord> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last fitness record in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fitness record
	* @throws NoSuchFitnessRecordException if a matching fitness record could not be found
	*/
	public static FitnessRecord findByUuid_Last(java.lang.String uuid,
		OrderByComparator<FitnessRecord> orderByComparator)
		throws foundation.fitness.portal.service.exception.NoSuchFitnessRecordException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last fitness record in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fitness record, or <code>null</code> if a matching fitness record could not be found
	*/
	public static FitnessRecord fetchByUuid_Last(java.lang.String uuid,
		OrderByComparator<FitnessRecord> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the fitness records before and after the current fitness record in the ordered set where uuid = &#63;.
	*
	* @param recordId the primary key of the current fitness record
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next fitness record
	* @throws NoSuchFitnessRecordException if a fitness record with the primary key could not be found
	*/
	public static FitnessRecord[] findByUuid_PrevAndNext(long recordId,
		java.lang.String uuid,
		OrderByComparator<FitnessRecord> orderByComparator)
		throws foundation.fitness.portal.service.exception.NoSuchFitnessRecordException {
		return getPersistence()
				   .findByUuid_PrevAndNext(recordId, uuid, orderByComparator);
	}

	/**
	* Removes all the fitness records where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of fitness records where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching fitness records
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the fitness record where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchFitnessRecordException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching fitness record
	* @throws NoSuchFitnessRecordException if a matching fitness record could not be found
	*/
	public static FitnessRecord findByUUID_G(java.lang.String uuid, long groupId)
		throws foundation.fitness.portal.service.exception.NoSuchFitnessRecordException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the fitness record where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching fitness record, or <code>null</code> if a matching fitness record could not be found
	*/
	public static FitnessRecord fetchByUUID_G(java.lang.String uuid,
		long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the fitness record where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching fitness record, or <code>null</code> if a matching fitness record could not be found
	*/
	public static FitnessRecord fetchByUUID_G(java.lang.String uuid,
		long groupId, boolean retrieveFromCache) {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the fitness record where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the fitness record that was removed
	*/
	public static FitnessRecord removeByUUID_G(java.lang.String uuid,
		long groupId)
		throws foundation.fitness.portal.service.exception.NoSuchFitnessRecordException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of fitness records where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching fitness records
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the fitness records where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching fitness records
	*/
	public static List<FitnessRecord> findByUuid_C(java.lang.String uuid,
		long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the fitness records where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FitnessRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of fitness records
	* @param end the upper bound of the range of fitness records (not inclusive)
	* @return the range of matching fitness records
	*/
	public static List<FitnessRecord> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end) {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the fitness records where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FitnessRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of fitness records
	* @param end the upper bound of the range of fitness records (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching fitness records
	*/
	public static List<FitnessRecord> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<FitnessRecord> orderByComparator) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the fitness records where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FitnessRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of fitness records
	* @param end the upper bound of the range of fitness records (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching fitness records
	*/
	public static List<FitnessRecord> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<FitnessRecord> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first fitness record in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fitness record
	* @throws NoSuchFitnessRecordException if a matching fitness record could not be found
	*/
	public static FitnessRecord findByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<FitnessRecord> orderByComparator)
		throws foundation.fitness.portal.service.exception.NoSuchFitnessRecordException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first fitness record in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fitness record, or <code>null</code> if a matching fitness record could not be found
	*/
	public static FitnessRecord fetchByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<FitnessRecord> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last fitness record in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fitness record
	* @throws NoSuchFitnessRecordException if a matching fitness record could not be found
	*/
	public static FitnessRecord findByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<FitnessRecord> orderByComparator)
		throws foundation.fitness.portal.service.exception.NoSuchFitnessRecordException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last fitness record in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fitness record, or <code>null</code> if a matching fitness record could not be found
	*/
	public static FitnessRecord fetchByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<FitnessRecord> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the fitness records before and after the current fitness record in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param recordId the primary key of the current fitness record
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next fitness record
	* @throws NoSuchFitnessRecordException if a fitness record with the primary key could not be found
	*/
	public static FitnessRecord[] findByUuid_C_PrevAndNext(long recordId,
		java.lang.String uuid, long companyId,
		OrderByComparator<FitnessRecord> orderByComparator)
		throws foundation.fitness.portal.service.exception.NoSuchFitnessRecordException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(recordId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the fitness records where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public static void removeByUuid_C(java.lang.String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of fitness records where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching fitness records
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the fitness records where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching fitness records
	*/
	public static List<FitnessRecord> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	* Returns a range of all the fitness records where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FitnessRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of fitness records
	* @param end the upper bound of the range of fitness records (not inclusive)
	* @return the range of matching fitness records
	*/
	public static List<FitnessRecord> findByGroupId(long groupId, int start,
		int end) {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the fitness records where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FitnessRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of fitness records
	* @param end the upper bound of the range of fitness records (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching fitness records
	*/
	public static List<FitnessRecord> findByGroupId(long groupId, int start,
		int end, OrderByComparator<FitnessRecord> orderByComparator) {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the fitness records where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FitnessRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of fitness records
	* @param end the upper bound of the range of fitness records (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching fitness records
	*/
	public static List<FitnessRecord> findByGroupId(long groupId, int start,
		int end, OrderByComparator<FitnessRecord> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first fitness record in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fitness record
	* @throws NoSuchFitnessRecordException if a matching fitness record could not be found
	*/
	public static FitnessRecord findByGroupId_First(long groupId,
		OrderByComparator<FitnessRecord> orderByComparator)
		throws foundation.fitness.portal.service.exception.NoSuchFitnessRecordException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first fitness record in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fitness record, or <code>null</code> if a matching fitness record could not be found
	*/
	public static FitnessRecord fetchByGroupId_First(long groupId,
		OrderByComparator<FitnessRecord> orderByComparator) {
		return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last fitness record in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fitness record
	* @throws NoSuchFitnessRecordException if a matching fitness record could not be found
	*/
	public static FitnessRecord findByGroupId_Last(long groupId,
		OrderByComparator<FitnessRecord> orderByComparator)
		throws foundation.fitness.portal.service.exception.NoSuchFitnessRecordException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last fitness record in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fitness record, or <code>null</code> if a matching fitness record could not be found
	*/
	public static FitnessRecord fetchByGroupId_Last(long groupId,
		OrderByComparator<FitnessRecord> orderByComparator) {
		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the fitness records before and after the current fitness record in the ordered set where groupId = &#63;.
	*
	* @param recordId the primary key of the current fitness record
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next fitness record
	* @throws NoSuchFitnessRecordException if a fitness record with the primary key could not be found
	*/
	public static FitnessRecord[] findByGroupId_PrevAndNext(long recordId,
		long groupId, OrderByComparator<FitnessRecord> orderByComparator)
		throws foundation.fitness.portal.service.exception.NoSuchFitnessRecordException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(recordId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the fitness records where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	*/
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Returns the number of fitness records where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching fitness records
	*/
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns all the fitness records where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching fitness records
	*/
	public static List<FitnessRecord> findByUserId(long userId) {
		return getPersistence().findByUserId(userId);
	}

	/**
	* Returns a range of all the fitness records where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FitnessRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of fitness records
	* @param end the upper bound of the range of fitness records (not inclusive)
	* @return the range of matching fitness records
	*/
	public static List<FitnessRecord> findByUserId(long userId, int start,
		int end) {
		return getPersistence().findByUserId(userId, start, end);
	}

	/**
	* Returns an ordered range of all the fitness records where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FitnessRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of fitness records
	* @param end the upper bound of the range of fitness records (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching fitness records
	*/
	public static List<FitnessRecord> findByUserId(long userId, int start,
		int end, OrderByComparator<FitnessRecord> orderByComparator) {
		return getPersistence()
				   .findByUserId(userId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the fitness records where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FitnessRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of fitness records
	* @param end the upper bound of the range of fitness records (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching fitness records
	*/
	public static List<FitnessRecord> findByUserId(long userId, int start,
		int end, OrderByComparator<FitnessRecord> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUserId(userId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first fitness record in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fitness record
	* @throws NoSuchFitnessRecordException if a matching fitness record could not be found
	*/
	public static FitnessRecord findByUserId_First(long userId,
		OrderByComparator<FitnessRecord> orderByComparator)
		throws foundation.fitness.portal.service.exception.NoSuchFitnessRecordException {
		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

	/**
	* Returns the first fitness record in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fitness record, or <code>null</code> if a matching fitness record could not be found
	*/
	public static FitnessRecord fetchByUserId_First(long userId,
		OrderByComparator<FitnessRecord> orderByComparator) {
		return getPersistence().fetchByUserId_First(userId, orderByComparator);
	}

	/**
	* Returns the last fitness record in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fitness record
	* @throws NoSuchFitnessRecordException if a matching fitness record could not be found
	*/
	public static FitnessRecord findByUserId_Last(long userId,
		OrderByComparator<FitnessRecord> orderByComparator)
		throws foundation.fitness.portal.service.exception.NoSuchFitnessRecordException {
		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the last fitness record in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fitness record, or <code>null</code> if a matching fitness record could not be found
	*/
	public static FitnessRecord fetchByUserId_Last(long userId,
		OrderByComparator<FitnessRecord> orderByComparator) {
		return getPersistence().fetchByUserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the fitness records before and after the current fitness record in the ordered set where userId = &#63;.
	*
	* @param recordId the primary key of the current fitness record
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next fitness record
	* @throws NoSuchFitnessRecordException if a fitness record with the primary key could not be found
	*/
	public static FitnessRecord[] findByUserId_PrevAndNext(long recordId,
		long userId, OrderByComparator<FitnessRecord> orderByComparator)
		throws foundation.fitness.portal.service.exception.NoSuchFitnessRecordException {
		return getPersistence()
				   .findByUserId_PrevAndNext(recordId, userId, orderByComparator);
	}

	/**
	* Removes all the fitness records where userId = &#63; from the database.
	*
	* @param userId the user ID
	*/
	public static void removeByUserId(long userId) {
		getPersistence().removeByUserId(userId);
	}

	/**
	* Returns the number of fitness records where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching fitness records
	*/
	public static int countByUserId(long userId) {
		return getPersistence().countByUserId(userId);
	}

	/**
	* Caches the fitness record in the entity cache if it is enabled.
	*
	* @param fitnessRecord the fitness record
	*/
	public static void cacheResult(FitnessRecord fitnessRecord) {
		getPersistence().cacheResult(fitnessRecord);
	}

	/**
	* Caches the fitness records in the entity cache if it is enabled.
	*
	* @param fitnessRecords the fitness records
	*/
	public static void cacheResult(List<FitnessRecord> fitnessRecords) {
		getPersistence().cacheResult(fitnessRecords);
	}

	/**
	* Creates a new fitness record with the primary key. Does not add the fitness record to the database.
	*
	* @param recordId the primary key for the new fitness record
	* @return the new fitness record
	*/
	public static FitnessRecord create(long recordId) {
		return getPersistence().create(recordId);
	}

	/**
	* Removes the fitness record with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param recordId the primary key of the fitness record
	* @return the fitness record that was removed
	* @throws NoSuchFitnessRecordException if a fitness record with the primary key could not be found
	*/
	public static FitnessRecord remove(long recordId)
		throws foundation.fitness.portal.service.exception.NoSuchFitnessRecordException {
		return getPersistence().remove(recordId);
	}

	public static FitnessRecord updateImpl(FitnessRecord fitnessRecord) {
		return getPersistence().updateImpl(fitnessRecord);
	}

	/**
	* Returns the fitness record with the primary key or throws a {@link NoSuchFitnessRecordException} if it could not be found.
	*
	* @param recordId the primary key of the fitness record
	* @return the fitness record
	* @throws NoSuchFitnessRecordException if a fitness record with the primary key could not be found
	*/
	public static FitnessRecord findByPrimaryKey(long recordId)
		throws foundation.fitness.portal.service.exception.NoSuchFitnessRecordException {
		return getPersistence().findByPrimaryKey(recordId);
	}

	/**
	* Returns the fitness record with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param recordId the primary key of the fitness record
	* @return the fitness record, or <code>null</code> if a fitness record with the primary key could not be found
	*/
	public static FitnessRecord fetchByPrimaryKey(long recordId) {
		return getPersistence().fetchByPrimaryKey(recordId);
	}

	public static java.util.Map<java.io.Serializable, FitnessRecord> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the fitness records.
	*
	* @return the fitness records
	*/
	public static List<FitnessRecord> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the fitness records.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FitnessRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of fitness records
	* @param end the upper bound of the range of fitness records (not inclusive)
	* @return the range of fitness records
	*/
	public static List<FitnessRecord> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the fitness records.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FitnessRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of fitness records
	* @param end the upper bound of the range of fitness records (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of fitness records
	*/
	public static List<FitnessRecord> findAll(int start, int end,
		OrderByComparator<FitnessRecord> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the fitness records.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FitnessRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of fitness records
	* @param end the upper bound of the range of fitness records (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of fitness records
	*/
	public static List<FitnessRecord> findAll(int start, int end,
		OrderByComparator<FitnessRecord> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the fitness records from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of fitness records.
	*
	* @return the number of fitness records
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static FitnessRecordPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<FitnessRecordPersistence, FitnessRecordPersistence> _serviceTracker =
		ServiceTrackerFactory.open(FitnessRecordPersistence.class);
}