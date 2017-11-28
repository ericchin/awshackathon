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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import foundation.fitness.portal.service.exception.NoSuchFitnessRecordException;
import foundation.fitness.portal.service.model.FitnessRecord;

/**
 * The persistence interface for the fitness record service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Sten Martinez
 * @see foundation.fitness.portal.service.service.persistence.impl.FitnessRecordPersistenceImpl
 * @see FitnessRecordUtil
 * @generated
 */
@ProviderType
public interface FitnessRecordPersistence extends BasePersistence<FitnessRecord> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FitnessRecordUtil} to access the fitness record persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the fitness records where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching fitness records
	*/
	public java.util.List<FitnessRecord> findByUuid(java.lang.String uuid);

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
	public java.util.List<FitnessRecord> findByUuid(java.lang.String uuid,
		int start, int end);

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
	public java.util.List<FitnessRecord> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FitnessRecord> orderByComparator);

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
	public java.util.List<FitnessRecord> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FitnessRecord> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first fitness record in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fitness record
	* @throws NoSuchFitnessRecordException if a matching fitness record could not be found
	*/
	public FitnessRecord findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<FitnessRecord> orderByComparator)
		throws NoSuchFitnessRecordException;

	/**
	* Returns the first fitness record in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fitness record, or <code>null</code> if a matching fitness record could not be found
	*/
	public FitnessRecord fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<FitnessRecord> orderByComparator);

	/**
	* Returns the last fitness record in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fitness record
	* @throws NoSuchFitnessRecordException if a matching fitness record could not be found
	*/
	public FitnessRecord findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<FitnessRecord> orderByComparator)
		throws NoSuchFitnessRecordException;

	/**
	* Returns the last fitness record in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fitness record, or <code>null</code> if a matching fitness record could not be found
	*/
	public FitnessRecord fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<FitnessRecord> orderByComparator);

	/**
	* Returns the fitness records before and after the current fitness record in the ordered set where uuid = &#63;.
	*
	* @param recordId the primary key of the current fitness record
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next fitness record
	* @throws NoSuchFitnessRecordException if a fitness record with the primary key could not be found
	*/
	public FitnessRecord[] findByUuid_PrevAndNext(long recordId,
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<FitnessRecord> orderByComparator)
		throws NoSuchFitnessRecordException;

	/**
	* Removes all the fitness records where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of fitness records where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching fitness records
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Returns the fitness record where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchFitnessRecordException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching fitness record
	* @throws NoSuchFitnessRecordException if a matching fitness record could not be found
	*/
	public FitnessRecord findByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchFitnessRecordException;

	/**
	* Returns the fitness record where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching fitness record, or <code>null</code> if a matching fitness record could not be found
	*/
	public FitnessRecord fetchByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns the fitness record where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching fitness record, or <code>null</code> if a matching fitness record could not be found
	*/
	public FitnessRecord fetchByUUID_G(java.lang.String uuid, long groupId,
		boolean retrieveFromCache);

	/**
	* Removes the fitness record where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the fitness record that was removed
	*/
	public FitnessRecord removeByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchFitnessRecordException;

	/**
	* Returns the number of fitness records where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching fitness records
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns all the fitness records where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching fitness records
	*/
	public java.util.List<FitnessRecord> findByUuid_C(java.lang.String uuid,
		long companyId);

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
	public java.util.List<FitnessRecord> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end);

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
	public java.util.List<FitnessRecord> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FitnessRecord> orderByComparator);

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
	public java.util.List<FitnessRecord> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FitnessRecord> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first fitness record in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fitness record
	* @throws NoSuchFitnessRecordException if a matching fitness record could not be found
	*/
	public FitnessRecord findByUuid_C_First(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<FitnessRecord> orderByComparator)
		throws NoSuchFitnessRecordException;

	/**
	* Returns the first fitness record in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fitness record, or <code>null</code> if a matching fitness record could not be found
	*/
	public FitnessRecord fetchByUuid_C_First(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<FitnessRecord> orderByComparator);

	/**
	* Returns the last fitness record in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fitness record
	* @throws NoSuchFitnessRecordException if a matching fitness record could not be found
	*/
	public FitnessRecord findByUuid_C_Last(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<FitnessRecord> orderByComparator)
		throws NoSuchFitnessRecordException;

	/**
	* Returns the last fitness record in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fitness record, or <code>null</code> if a matching fitness record could not be found
	*/
	public FitnessRecord fetchByUuid_C_Last(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<FitnessRecord> orderByComparator);

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
	public FitnessRecord[] findByUuid_C_PrevAndNext(long recordId,
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<FitnessRecord> orderByComparator)
		throws NoSuchFitnessRecordException;

	/**
	* Removes all the fitness records where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns the number of fitness records where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching fitness records
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns all the fitness records where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching fitness records
	*/
	public java.util.List<FitnessRecord> findByGroupId(long groupId);

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
	public java.util.List<FitnessRecord> findByGroupId(long groupId, int start,
		int end);

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
	public java.util.List<FitnessRecord> findByGroupId(long groupId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<FitnessRecord> orderByComparator);

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
	public java.util.List<FitnessRecord> findByGroupId(long groupId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<FitnessRecord> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first fitness record in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fitness record
	* @throws NoSuchFitnessRecordException if a matching fitness record could not be found
	*/
	public FitnessRecord findByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<FitnessRecord> orderByComparator)
		throws NoSuchFitnessRecordException;

	/**
	* Returns the first fitness record in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fitness record, or <code>null</code> if a matching fitness record could not be found
	*/
	public FitnessRecord fetchByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<FitnessRecord> orderByComparator);

	/**
	* Returns the last fitness record in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fitness record
	* @throws NoSuchFitnessRecordException if a matching fitness record could not be found
	*/
	public FitnessRecord findByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<FitnessRecord> orderByComparator)
		throws NoSuchFitnessRecordException;

	/**
	* Returns the last fitness record in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fitness record, or <code>null</code> if a matching fitness record could not be found
	*/
	public FitnessRecord fetchByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<FitnessRecord> orderByComparator);

	/**
	* Returns the fitness records before and after the current fitness record in the ordered set where groupId = &#63;.
	*
	* @param recordId the primary key of the current fitness record
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next fitness record
	* @throws NoSuchFitnessRecordException if a fitness record with the primary key could not be found
	*/
	public FitnessRecord[] findByGroupId_PrevAndNext(long recordId,
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<FitnessRecord> orderByComparator)
		throws NoSuchFitnessRecordException;

	/**
	* Removes all the fitness records where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	*/
	public void removeByGroupId(long groupId);

	/**
	* Returns the number of fitness records where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching fitness records
	*/
	public int countByGroupId(long groupId);

	/**
	* Returns all the fitness records where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching fitness records
	*/
	public java.util.List<FitnessRecord> findByUserId(long userId);

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
	public java.util.List<FitnessRecord> findByUserId(long userId, int start,
		int end);

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
	public java.util.List<FitnessRecord> findByUserId(long userId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<FitnessRecord> orderByComparator);

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
	public java.util.List<FitnessRecord> findByUserId(long userId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<FitnessRecord> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first fitness record in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fitness record
	* @throws NoSuchFitnessRecordException if a matching fitness record could not be found
	*/
	public FitnessRecord findByUserId_First(long userId,
		com.liferay.portal.kernel.util.OrderByComparator<FitnessRecord> orderByComparator)
		throws NoSuchFitnessRecordException;

	/**
	* Returns the first fitness record in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fitness record, or <code>null</code> if a matching fitness record could not be found
	*/
	public FitnessRecord fetchByUserId_First(long userId,
		com.liferay.portal.kernel.util.OrderByComparator<FitnessRecord> orderByComparator);

	/**
	* Returns the last fitness record in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fitness record
	* @throws NoSuchFitnessRecordException if a matching fitness record could not be found
	*/
	public FitnessRecord findByUserId_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator<FitnessRecord> orderByComparator)
		throws NoSuchFitnessRecordException;

	/**
	* Returns the last fitness record in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fitness record, or <code>null</code> if a matching fitness record could not be found
	*/
	public FitnessRecord fetchByUserId_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator<FitnessRecord> orderByComparator);

	/**
	* Returns the fitness records before and after the current fitness record in the ordered set where userId = &#63;.
	*
	* @param recordId the primary key of the current fitness record
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next fitness record
	* @throws NoSuchFitnessRecordException if a fitness record with the primary key could not be found
	*/
	public FitnessRecord[] findByUserId_PrevAndNext(long recordId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator<FitnessRecord> orderByComparator)
		throws NoSuchFitnessRecordException;

	/**
	* Removes all the fitness records where userId = &#63; from the database.
	*
	* @param userId the user ID
	*/
	public void removeByUserId(long userId);

	/**
	* Returns the number of fitness records where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching fitness records
	*/
	public int countByUserId(long userId);

	/**
	* Caches the fitness record in the entity cache if it is enabled.
	*
	* @param fitnessRecord the fitness record
	*/
	public void cacheResult(FitnessRecord fitnessRecord);

	/**
	* Caches the fitness records in the entity cache if it is enabled.
	*
	* @param fitnessRecords the fitness records
	*/
	public void cacheResult(java.util.List<FitnessRecord> fitnessRecords);

	/**
	* Creates a new fitness record with the primary key. Does not add the fitness record to the database.
	*
	* @param recordId the primary key for the new fitness record
	* @return the new fitness record
	*/
	public FitnessRecord create(long recordId);

	/**
	* Removes the fitness record with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param recordId the primary key of the fitness record
	* @return the fitness record that was removed
	* @throws NoSuchFitnessRecordException if a fitness record with the primary key could not be found
	*/
	public FitnessRecord remove(long recordId)
		throws NoSuchFitnessRecordException;

	public FitnessRecord updateImpl(FitnessRecord fitnessRecord);

	/**
	* Returns the fitness record with the primary key or throws a {@link NoSuchFitnessRecordException} if it could not be found.
	*
	* @param recordId the primary key of the fitness record
	* @return the fitness record
	* @throws NoSuchFitnessRecordException if a fitness record with the primary key could not be found
	*/
	public FitnessRecord findByPrimaryKey(long recordId)
		throws NoSuchFitnessRecordException;

	/**
	* Returns the fitness record with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param recordId the primary key of the fitness record
	* @return the fitness record, or <code>null</code> if a fitness record with the primary key could not be found
	*/
	public FitnessRecord fetchByPrimaryKey(long recordId);

	@Override
	public java.util.Map<java.io.Serializable, FitnessRecord> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the fitness records.
	*
	* @return the fitness records
	*/
	public java.util.List<FitnessRecord> findAll();

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
	public java.util.List<FitnessRecord> findAll(int start, int end);

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
	public java.util.List<FitnessRecord> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FitnessRecord> orderByComparator);

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
	public java.util.List<FitnessRecord> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FitnessRecord> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the fitness records from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of fitness records.
	*
	* @return the number of fitness records
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}