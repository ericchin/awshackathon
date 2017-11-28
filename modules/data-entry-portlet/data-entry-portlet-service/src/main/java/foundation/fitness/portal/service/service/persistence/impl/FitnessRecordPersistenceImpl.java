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

package foundation.fitness.portal.service.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReflectionUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import foundation.fitness.portal.service.exception.NoSuchFitnessRecordException;
import foundation.fitness.portal.service.model.FitnessRecord;
import foundation.fitness.portal.service.model.impl.FitnessRecordImpl;
import foundation.fitness.portal.service.model.impl.FitnessRecordModelImpl;
import foundation.fitness.portal.service.service.persistence.FitnessRecordPersistence;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the fitness record service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Sten Martinez
 * @see FitnessRecordPersistence
 * @see foundation.fitness.portal.service.service.persistence.FitnessRecordUtil
 * @generated
 */
@ProviderType
public class FitnessRecordPersistenceImpl extends BasePersistenceImpl<FitnessRecord>
	implements FitnessRecordPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link FitnessRecordUtil} to access the fitness record persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = FitnessRecordImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(FitnessRecordModelImpl.ENTITY_CACHE_ENABLED,
			FitnessRecordModelImpl.FINDER_CACHE_ENABLED,
			FitnessRecordImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(FitnessRecordModelImpl.ENTITY_CACHE_ENABLED,
			FitnessRecordModelImpl.FINDER_CACHE_ENABLED,
			FitnessRecordImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FitnessRecordModelImpl.ENTITY_CACHE_ENABLED,
			FitnessRecordModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(FitnessRecordModelImpl.ENTITY_CACHE_ENABLED,
			FitnessRecordModelImpl.FINDER_CACHE_ENABLED,
			FitnessRecordImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(FitnessRecordModelImpl.ENTITY_CACHE_ENABLED,
			FitnessRecordModelImpl.FINDER_CACHE_ENABLED,
			FitnessRecordImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByUuid", new String[] { String.class.getName() },
			FitnessRecordModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(FitnessRecordModelImpl.ENTITY_CACHE_ENABLED,
			FitnessRecordModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the fitness records where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching fitness records
	 */
	@Override
	public List<FitnessRecord> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<FitnessRecord> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<FitnessRecord> findByUuid(String uuid, int start, int end,
		OrderByComparator<FitnessRecord> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<FitnessRecord> findByUuid(String uuid, int start, int end,
		OrderByComparator<FitnessRecord> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<FitnessRecord> list = null;

		if (retrieveFromCache) {
			list = (List<FitnessRecord>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (FitnessRecord fitnessRecord : list) {
					if (!Objects.equals(uuid, fitnessRecord.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_FITNESSRECORD_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(FitnessRecordModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<FitnessRecord>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<FitnessRecord>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first fitness record in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fitness record
	 * @throws NoSuchFitnessRecordException if a matching fitness record could not be found
	 */
	@Override
	public FitnessRecord findByUuid_First(String uuid,
		OrderByComparator<FitnessRecord> orderByComparator)
		throws NoSuchFitnessRecordException {
		FitnessRecord fitnessRecord = fetchByUuid_First(uuid, orderByComparator);

		if (fitnessRecord != null) {
			return fitnessRecord;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFitnessRecordException(msg.toString());
	}

	/**
	 * Returns the first fitness record in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fitness record, or <code>null</code> if a matching fitness record could not be found
	 */
	@Override
	public FitnessRecord fetchByUuid_First(String uuid,
		OrderByComparator<FitnessRecord> orderByComparator) {
		List<FitnessRecord> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last fitness record in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fitness record
	 * @throws NoSuchFitnessRecordException if a matching fitness record could not be found
	 */
	@Override
	public FitnessRecord findByUuid_Last(String uuid,
		OrderByComparator<FitnessRecord> orderByComparator)
		throws NoSuchFitnessRecordException {
		FitnessRecord fitnessRecord = fetchByUuid_Last(uuid, orderByComparator);

		if (fitnessRecord != null) {
			return fitnessRecord;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFitnessRecordException(msg.toString());
	}

	/**
	 * Returns the last fitness record in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fitness record, or <code>null</code> if a matching fitness record could not be found
	 */
	@Override
	public FitnessRecord fetchByUuid_Last(String uuid,
		OrderByComparator<FitnessRecord> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<FitnessRecord> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public FitnessRecord[] findByUuid_PrevAndNext(long recordId, String uuid,
		OrderByComparator<FitnessRecord> orderByComparator)
		throws NoSuchFitnessRecordException {
		FitnessRecord fitnessRecord = findByPrimaryKey(recordId);

		Session session = null;

		try {
			session = openSession();

			FitnessRecord[] array = new FitnessRecordImpl[3];

			array[0] = getByUuid_PrevAndNext(session, fitnessRecord, uuid,
					orderByComparator, true);

			array[1] = fitnessRecord;

			array[2] = getByUuid_PrevAndNext(session, fitnessRecord, uuid,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected FitnessRecord getByUuid_PrevAndNext(Session session,
		FitnessRecord fitnessRecord, String uuid,
		OrderByComparator<FitnessRecord> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FITNESSRECORD_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(FitnessRecordModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(fitnessRecord);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<FitnessRecord> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the fitness records where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (FitnessRecord fitnessRecord : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(fitnessRecord);
		}
	}

	/**
	 * Returns the number of fitness records where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching fitness records
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FITNESSRECORD_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "fitnessRecord.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "fitnessRecord.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(fitnessRecord.uuid IS NULL OR fitnessRecord.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(FitnessRecordModelImpl.ENTITY_CACHE_ENABLED,
			FitnessRecordModelImpl.FINDER_CACHE_ENABLED,
			FitnessRecordImpl.class, FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			FitnessRecordModelImpl.UUID_COLUMN_BITMASK |
			FitnessRecordModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(FitnessRecordModelImpl.ENTITY_CACHE_ENABLED,
			FitnessRecordModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the fitness record where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchFitnessRecordException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching fitness record
	 * @throws NoSuchFitnessRecordException if a matching fitness record could not be found
	 */
	@Override
	public FitnessRecord findByUUID_G(String uuid, long groupId)
		throws NoSuchFitnessRecordException {
		FitnessRecord fitnessRecord = fetchByUUID_G(uuid, groupId);

		if (fitnessRecord == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchFitnessRecordException(msg.toString());
		}

		return fitnessRecord;
	}

	/**
	 * Returns the fitness record where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching fitness record, or <code>null</code> if a matching fitness record could not be found
	 */
	@Override
	public FitnessRecord fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the fitness record where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching fitness record, or <code>null</code> if a matching fitness record could not be found
	 */
	@Override
	public FitnessRecord fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof FitnessRecord) {
			FitnessRecord fitnessRecord = (FitnessRecord)result;

			if (!Objects.equals(uuid, fitnessRecord.getUuid()) ||
					(groupId != fitnessRecord.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_FITNESSRECORD_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				List<FitnessRecord> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					FitnessRecord fitnessRecord = list.get(0);

					result = fitnessRecord;

					cacheResult(fitnessRecord);

					if ((fitnessRecord.getUuid() == null) ||
							!fitnessRecord.getUuid().equals(uuid) ||
							(fitnessRecord.getGroupId() != groupId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, fitnessRecord);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (FitnessRecord)result;
		}
	}

	/**
	 * Removes the fitness record where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the fitness record that was removed
	 */
	@Override
	public FitnessRecord removeByUUID_G(String uuid, long groupId)
		throws NoSuchFitnessRecordException {
		FitnessRecord fitnessRecord = findByUUID_G(uuid, groupId);

		return remove(fitnessRecord);
	}

	/**
	 * Returns the number of fitness records where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching fitness records
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_G;

		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_FITNESSRECORD_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "fitnessRecord.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "fitnessRecord.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(fitnessRecord.uuid IS NULL OR fitnessRecord.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "fitnessRecord.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(FitnessRecordModelImpl.ENTITY_CACHE_ENABLED,
			FitnessRecordModelImpl.FINDER_CACHE_ENABLED,
			FitnessRecordImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(FitnessRecordModelImpl.ENTITY_CACHE_ENABLED,
			FitnessRecordModelImpl.FINDER_CACHE_ENABLED,
			FitnessRecordImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			FitnessRecordModelImpl.UUID_COLUMN_BITMASK |
			FitnessRecordModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(FitnessRecordModelImpl.ENTITY_CACHE_ENABLED,
			FitnessRecordModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the fitness records where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching fitness records
	 */
	@Override
	public List<FitnessRecord> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<FitnessRecord> findByUuid_C(String uuid, long companyId,
		int start, int end) {
		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<FitnessRecord> findByUuid_C(String uuid, long companyId,
		int start, int end, OrderByComparator<FitnessRecord> orderByComparator) {
		return findByUuid_C(uuid, companyId, start, end, orderByComparator, true);
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
	@Override
	public List<FitnessRecord> findByUuid_C(String uuid, long companyId,
		int start, int end, OrderByComparator<FitnessRecord> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] { uuid, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] {
					uuid, companyId,
					
					start, end, orderByComparator
				};
		}

		List<FitnessRecord> list = null;

		if (retrieveFromCache) {
			list = (List<FitnessRecord>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (FitnessRecord fitnessRecord : list) {
					if (!Objects.equals(uuid, fitnessRecord.getUuid()) ||
							(companyId != fitnessRecord.getCompanyId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_FITNESSRECORD_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(FitnessRecordModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				if (!pagination) {
					list = (List<FitnessRecord>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<FitnessRecord>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public FitnessRecord findByUuid_C_First(String uuid, long companyId,
		OrderByComparator<FitnessRecord> orderByComparator)
		throws NoSuchFitnessRecordException {
		FitnessRecord fitnessRecord = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (fitnessRecord != null) {
			return fitnessRecord;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFitnessRecordException(msg.toString());
	}

	/**
	 * Returns the first fitness record in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fitness record, or <code>null</code> if a matching fitness record could not be found
	 */
	@Override
	public FitnessRecord fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator<FitnessRecord> orderByComparator) {
		List<FitnessRecord> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public FitnessRecord findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<FitnessRecord> orderByComparator)
		throws NoSuchFitnessRecordException {
		FitnessRecord fitnessRecord = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (fitnessRecord != null) {
			return fitnessRecord;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFitnessRecordException(msg.toString());
	}

	/**
	 * Returns the last fitness record in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fitness record, or <code>null</code> if a matching fitness record could not be found
	 */
	@Override
	public FitnessRecord fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<FitnessRecord> orderByComparator) {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<FitnessRecord> list = findByUuid_C(uuid, companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public FitnessRecord[] findByUuid_C_PrevAndNext(long recordId, String uuid,
		long companyId, OrderByComparator<FitnessRecord> orderByComparator)
		throws NoSuchFitnessRecordException {
		FitnessRecord fitnessRecord = findByPrimaryKey(recordId);

		Session session = null;

		try {
			session = openSession();

			FitnessRecord[] array = new FitnessRecordImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, fitnessRecord, uuid,
					companyId, orderByComparator, true);

			array[1] = fitnessRecord;

			array[2] = getByUuid_C_PrevAndNext(session, fitnessRecord, uuid,
					companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected FitnessRecord getByUuid_C_PrevAndNext(Session session,
		FitnessRecord fitnessRecord, String uuid, long companyId,
		OrderByComparator<FitnessRecord> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_FITNESSRECORD_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(FitnessRecordModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(fitnessRecord);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<FitnessRecord> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the fitness records where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (FitnessRecord fitnessRecord : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(fitnessRecord);
		}
	}

	/**
	 * Returns the number of fitness records where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching fitness records
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

		Object[] finderArgs = new Object[] { uuid, companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_FITNESSRECORD_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "fitnessRecord.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "fitnessRecord.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(fitnessRecord.uuid IS NULL OR fitnessRecord.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "fitnessRecord.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(FitnessRecordModelImpl.ENTITY_CACHE_ENABLED,
			FitnessRecordModelImpl.FINDER_CACHE_ENABLED,
			FitnessRecordImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(FitnessRecordModelImpl.ENTITY_CACHE_ENABLED,
			FitnessRecordModelImpl.FINDER_CACHE_ENABLED,
			FitnessRecordImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByGroupId", new String[] { Long.class.getName() },
			FitnessRecordModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(FitnessRecordModelImpl.ENTITY_CACHE_ENABLED,
			FitnessRecordModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the fitness records where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching fitness records
	 */
	@Override
	public List<FitnessRecord> findByGroupId(long groupId) {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<FitnessRecord> findByGroupId(long groupId, int start, int end) {
		return findByGroupId(groupId, start, end, null);
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
	@Override
	public List<FitnessRecord> findByGroupId(long groupId, int start, int end,
		OrderByComparator<FitnessRecord> orderByComparator) {
		return findByGroupId(groupId, start, end, orderByComparator, true);
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
	@Override
	public List<FitnessRecord> findByGroupId(long groupId, int start, int end,
		OrderByComparator<FitnessRecord> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId, start, end, orderByComparator };
		}

		List<FitnessRecord> list = null;

		if (retrieveFromCache) {
			list = (List<FitnessRecord>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (FitnessRecord fitnessRecord : list) {
					if ((groupId != fitnessRecord.getGroupId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_FITNESSRECORD_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(FitnessRecordModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<FitnessRecord>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<FitnessRecord>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first fitness record in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fitness record
	 * @throws NoSuchFitnessRecordException if a matching fitness record could not be found
	 */
	@Override
	public FitnessRecord findByGroupId_First(long groupId,
		OrderByComparator<FitnessRecord> orderByComparator)
		throws NoSuchFitnessRecordException {
		FitnessRecord fitnessRecord = fetchByGroupId_First(groupId,
				orderByComparator);

		if (fitnessRecord != null) {
			return fitnessRecord;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFitnessRecordException(msg.toString());
	}

	/**
	 * Returns the first fitness record in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fitness record, or <code>null</code> if a matching fitness record could not be found
	 */
	@Override
	public FitnessRecord fetchByGroupId_First(long groupId,
		OrderByComparator<FitnessRecord> orderByComparator) {
		List<FitnessRecord> list = findByGroupId(groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last fitness record in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fitness record
	 * @throws NoSuchFitnessRecordException if a matching fitness record could not be found
	 */
	@Override
	public FitnessRecord findByGroupId_Last(long groupId,
		OrderByComparator<FitnessRecord> orderByComparator)
		throws NoSuchFitnessRecordException {
		FitnessRecord fitnessRecord = fetchByGroupId_Last(groupId,
				orderByComparator);

		if (fitnessRecord != null) {
			return fitnessRecord;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFitnessRecordException(msg.toString());
	}

	/**
	 * Returns the last fitness record in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fitness record, or <code>null</code> if a matching fitness record could not be found
	 */
	@Override
	public FitnessRecord fetchByGroupId_Last(long groupId,
		OrderByComparator<FitnessRecord> orderByComparator) {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<FitnessRecord> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public FitnessRecord[] findByGroupId_PrevAndNext(long recordId,
		long groupId, OrderByComparator<FitnessRecord> orderByComparator)
		throws NoSuchFitnessRecordException {
		FitnessRecord fitnessRecord = findByPrimaryKey(recordId);

		Session session = null;

		try {
			session = openSession();

			FitnessRecord[] array = new FitnessRecordImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, fitnessRecord,
					groupId, orderByComparator, true);

			array[1] = fitnessRecord;

			array[2] = getByGroupId_PrevAndNext(session, fitnessRecord,
					groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected FitnessRecord getByGroupId_PrevAndNext(Session session,
		FitnessRecord fitnessRecord, long groupId,
		OrderByComparator<FitnessRecord> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FITNESSRECORD_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(FitnessRecordModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(fitnessRecord);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<FitnessRecord> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the fitness records where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (FitnessRecord fitnessRecord : findByGroupId(groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(fitnessRecord);
		}
	}

	/**
	 * Returns the number of fitness records where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching fitness records
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPID;

		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FITNESSRECORD_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "fitnessRecord.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(FitnessRecordModelImpl.ENTITY_CACHE_ENABLED,
			FitnessRecordModelImpl.FINDER_CACHE_ENABLED,
			FitnessRecordImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUserId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(FitnessRecordModelImpl.ENTITY_CACHE_ENABLED,
			FitnessRecordModelImpl.FINDER_CACHE_ENABLED,
			FitnessRecordImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByUserId", new String[] { Long.class.getName() },
			FitnessRecordModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(FitnessRecordModelImpl.ENTITY_CACHE_ENABLED,
			FitnessRecordModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the fitness records where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching fitness records
	 */
	@Override
	public List<FitnessRecord> findByUserId(long userId) {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<FitnessRecord> findByUserId(long userId, int start, int end) {
		return findByUserId(userId, start, end, null);
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
	@Override
	public List<FitnessRecord> findByUserId(long userId, int start, int end,
		OrderByComparator<FitnessRecord> orderByComparator) {
		return findByUserId(userId, start, end, orderByComparator, true);
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
	@Override
	public List<FitnessRecord> findByUserId(long userId, int start, int end,
		OrderByComparator<FitnessRecord> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId, start, end, orderByComparator };
		}

		List<FitnessRecord> list = null;

		if (retrieveFromCache) {
			list = (List<FitnessRecord>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (FitnessRecord fitnessRecord : list) {
					if ((userId != fitnessRecord.getUserId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_FITNESSRECORD_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(FitnessRecordModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (!pagination) {
					list = (List<FitnessRecord>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<FitnessRecord>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first fitness record in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fitness record
	 * @throws NoSuchFitnessRecordException if a matching fitness record could not be found
	 */
	@Override
	public FitnessRecord findByUserId_First(long userId,
		OrderByComparator<FitnessRecord> orderByComparator)
		throws NoSuchFitnessRecordException {
		FitnessRecord fitnessRecord = fetchByUserId_First(userId,
				orderByComparator);

		if (fitnessRecord != null) {
			return fitnessRecord;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFitnessRecordException(msg.toString());
	}

	/**
	 * Returns the first fitness record in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fitness record, or <code>null</code> if a matching fitness record could not be found
	 */
	@Override
	public FitnessRecord fetchByUserId_First(long userId,
		OrderByComparator<FitnessRecord> orderByComparator) {
		List<FitnessRecord> list = findByUserId(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last fitness record in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fitness record
	 * @throws NoSuchFitnessRecordException if a matching fitness record could not be found
	 */
	@Override
	public FitnessRecord findByUserId_Last(long userId,
		OrderByComparator<FitnessRecord> orderByComparator)
		throws NoSuchFitnessRecordException {
		FitnessRecord fitnessRecord = fetchByUserId_Last(userId,
				orderByComparator);

		if (fitnessRecord != null) {
			return fitnessRecord;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFitnessRecordException(msg.toString());
	}

	/**
	 * Returns the last fitness record in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fitness record, or <code>null</code> if a matching fitness record could not be found
	 */
	@Override
	public FitnessRecord fetchByUserId_Last(long userId,
		OrderByComparator<FitnessRecord> orderByComparator) {
		int count = countByUserId(userId);

		if (count == 0) {
			return null;
		}

		List<FitnessRecord> list = findByUserId(userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public FitnessRecord[] findByUserId_PrevAndNext(long recordId, long userId,
		OrderByComparator<FitnessRecord> orderByComparator)
		throws NoSuchFitnessRecordException {
		FitnessRecord fitnessRecord = findByPrimaryKey(recordId);

		Session session = null;

		try {
			session = openSession();

			FitnessRecord[] array = new FitnessRecordImpl[3];

			array[0] = getByUserId_PrevAndNext(session, fitnessRecord, userId,
					orderByComparator, true);

			array[1] = fitnessRecord;

			array[2] = getByUserId_PrevAndNext(session, fitnessRecord, userId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected FitnessRecord getByUserId_PrevAndNext(Session session,
		FitnessRecord fitnessRecord, long userId,
		OrderByComparator<FitnessRecord> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FITNESSRECORD_WHERE);

		query.append(_FINDER_COLUMN_USERID_USERID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(FitnessRecordModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(fitnessRecord);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<FitnessRecord> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the fitness records where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	@Override
	public void removeByUserId(long userId) {
		for (FitnessRecord fitnessRecord : findByUserId(userId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(fitnessRecord);
		}
	}

	/**
	 * Returns the number of fitness records where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching fitness records
	 */
	@Override
	public int countByUserId(long userId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERID;

		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FITNESSRECORD_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_USERID_USERID_2 = "fitnessRecord.userId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STUDENTID =
		new FinderPath(FitnessRecordModelImpl.ENTITY_CACHE_ENABLED,
			FitnessRecordModelImpl.FINDER_CACHE_ENABLED,
			FitnessRecordImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByStudentId",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STUDENTID =
		new FinderPath(FitnessRecordModelImpl.ENTITY_CACHE_ENABLED,
			FitnessRecordModelImpl.FINDER_CACHE_ENABLED,
			FitnessRecordImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByStudentId", new String[] { String.class.getName() },
			FitnessRecordModelImpl.STUDENTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STUDENTID = new FinderPath(FitnessRecordModelImpl.ENTITY_CACHE_ENABLED,
			FitnessRecordModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStudentId",
			new String[] { String.class.getName() });

	/**
	 * Returns all the fitness records where studentId = &#63;.
	 *
	 * @param studentId the student ID
	 * @return the matching fitness records
	 */
	@Override
	public List<FitnessRecord> findByStudentId(String studentId) {
		return findByStudentId(studentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the fitness records where studentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FitnessRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param studentId the student ID
	 * @param start the lower bound of the range of fitness records
	 * @param end the upper bound of the range of fitness records (not inclusive)
	 * @return the range of matching fitness records
	 */
	@Override
	public List<FitnessRecord> findByStudentId(String studentId, int start,
		int end) {
		return findByStudentId(studentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the fitness records where studentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FitnessRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param studentId the student ID
	 * @param start the lower bound of the range of fitness records
	 * @param end the upper bound of the range of fitness records (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching fitness records
	 */
	@Override
	public List<FitnessRecord> findByStudentId(String studentId, int start,
		int end, OrderByComparator<FitnessRecord> orderByComparator) {
		return findByStudentId(studentId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the fitness records where studentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FitnessRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param studentId the student ID
	 * @param start the lower bound of the range of fitness records
	 * @param end the upper bound of the range of fitness records (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching fitness records
	 */
	@Override
	public List<FitnessRecord> findByStudentId(String studentId, int start,
		int end, OrderByComparator<FitnessRecord> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STUDENTID;
			finderArgs = new Object[] { studentId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STUDENTID;
			finderArgs = new Object[] { studentId, start, end, orderByComparator };
		}

		List<FitnessRecord> list = null;

		if (retrieveFromCache) {
			list = (List<FitnessRecord>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (FitnessRecord fitnessRecord : list) {
					if (!Objects.equals(studentId, fitnessRecord.getStudentId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_FITNESSRECORD_WHERE);

			boolean bindStudentId = false;

			if (studentId == null) {
				query.append(_FINDER_COLUMN_STUDENTID_STUDENTID_1);
			}
			else if (studentId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STUDENTID_STUDENTID_3);
			}
			else {
				bindStudentId = true;

				query.append(_FINDER_COLUMN_STUDENTID_STUDENTID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(FitnessRecordModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindStudentId) {
					qPos.add(studentId);
				}

				if (!pagination) {
					list = (List<FitnessRecord>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<FitnessRecord>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first fitness record in the ordered set where studentId = &#63;.
	 *
	 * @param studentId the student ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fitness record
	 * @throws NoSuchFitnessRecordException if a matching fitness record could not be found
	 */
	@Override
	public FitnessRecord findByStudentId_First(String studentId,
		OrderByComparator<FitnessRecord> orderByComparator)
		throws NoSuchFitnessRecordException {
		FitnessRecord fitnessRecord = fetchByStudentId_First(studentId,
				orderByComparator);

		if (fitnessRecord != null) {
			return fitnessRecord;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("studentId=");
		msg.append(studentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFitnessRecordException(msg.toString());
	}

	/**
	 * Returns the first fitness record in the ordered set where studentId = &#63;.
	 *
	 * @param studentId the student ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fitness record, or <code>null</code> if a matching fitness record could not be found
	 */
	@Override
	public FitnessRecord fetchByStudentId_First(String studentId,
		OrderByComparator<FitnessRecord> orderByComparator) {
		List<FitnessRecord> list = findByStudentId(studentId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last fitness record in the ordered set where studentId = &#63;.
	 *
	 * @param studentId the student ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fitness record
	 * @throws NoSuchFitnessRecordException if a matching fitness record could not be found
	 */
	@Override
	public FitnessRecord findByStudentId_Last(String studentId,
		OrderByComparator<FitnessRecord> orderByComparator)
		throws NoSuchFitnessRecordException {
		FitnessRecord fitnessRecord = fetchByStudentId_Last(studentId,
				orderByComparator);

		if (fitnessRecord != null) {
			return fitnessRecord;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("studentId=");
		msg.append(studentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFitnessRecordException(msg.toString());
	}

	/**
	 * Returns the last fitness record in the ordered set where studentId = &#63;.
	 *
	 * @param studentId the student ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fitness record, or <code>null</code> if a matching fitness record could not be found
	 */
	@Override
	public FitnessRecord fetchByStudentId_Last(String studentId,
		OrderByComparator<FitnessRecord> orderByComparator) {
		int count = countByStudentId(studentId);

		if (count == 0) {
			return null;
		}

		List<FitnessRecord> list = findByStudentId(studentId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the fitness records before and after the current fitness record in the ordered set where studentId = &#63;.
	 *
	 * @param recordId the primary key of the current fitness record
	 * @param studentId the student ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next fitness record
	 * @throws NoSuchFitnessRecordException if a fitness record with the primary key could not be found
	 */
	@Override
	public FitnessRecord[] findByStudentId_PrevAndNext(long recordId,
		String studentId, OrderByComparator<FitnessRecord> orderByComparator)
		throws NoSuchFitnessRecordException {
		FitnessRecord fitnessRecord = findByPrimaryKey(recordId);

		Session session = null;

		try {
			session = openSession();

			FitnessRecord[] array = new FitnessRecordImpl[3];

			array[0] = getByStudentId_PrevAndNext(session, fitnessRecord,
					studentId, orderByComparator, true);

			array[1] = fitnessRecord;

			array[2] = getByStudentId_PrevAndNext(session, fitnessRecord,
					studentId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected FitnessRecord getByStudentId_PrevAndNext(Session session,
		FitnessRecord fitnessRecord, String studentId,
		OrderByComparator<FitnessRecord> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FITNESSRECORD_WHERE);

		boolean bindStudentId = false;

		if (studentId == null) {
			query.append(_FINDER_COLUMN_STUDENTID_STUDENTID_1);
		}
		else if (studentId.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_STUDENTID_STUDENTID_3);
		}
		else {
			bindStudentId = true;

			query.append(_FINDER_COLUMN_STUDENTID_STUDENTID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(FitnessRecordModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindStudentId) {
			qPos.add(studentId);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(fitnessRecord);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<FitnessRecord> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the fitness records where studentId = &#63; from the database.
	 *
	 * @param studentId the student ID
	 */
	@Override
	public void removeByStudentId(String studentId) {
		for (FitnessRecord fitnessRecord : findByStudentId(studentId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(fitnessRecord);
		}
	}

	/**
	 * Returns the number of fitness records where studentId = &#63;.
	 *
	 * @param studentId the student ID
	 * @return the number of matching fitness records
	 */
	@Override
	public int countByStudentId(String studentId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STUDENTID;

		Object[] finderArgs = new Object[] { studentId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FITNESSRECORD_WHERE);

			boolean bindStudentId = false;

			if (studentId == null) {
				query.append(_FINDER_COLUMN_STUDENTID_STUDENTID_1);
			}
			else if (studentId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STUDENTID_STUDENTID_3);
			}
			else {
				bindStudentId = true;

				query.append(_FINDER_COLUMN_STUDENTID_STUDENTID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindStudentId) {
					qPos.add(studentId);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_STUDENTID_STUDENTID_1 = "fitnessRecord.studentId IS NULL";
	private static final String _FINDER_COLUMN_STUDENTID_STUDENTID_2 = "fitnessRecord.studentId = ?";
	private static final String _FINDER_COLUMN_STUDENTID_STUDENTID_3 = "(fitnessRecord.studentId IS NULL OR fitnessRecord.studentId = '')";

	public FitnessRecordPersistenceImpl() {
		setModelClass(FitnessRecord.class);

		try {
			Field field = ReflectionUtil.getDeclaredField(BasePersistenceImpl.class,
					"_dbColumnNames");

			Map<String, String> dbColumnNames = new HashMap<String, String>();

			dbColumnNames.put("uuid", "uuid_");

			field.set(this, dbColumnNames);
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e, e);
			}
		}
	}

	/**
	 * Caches the fitness record in the entity cache if it is enabled.
	 *
	 * @param fitnessRecord the fitness record
	 */
	@Override
	public void cacheResult(FitnessRecord fitnessRecord) {
		entityCache.putResult(FitnessRecordModelImpl.ENTITY_CACHE_ENABLED,
			FitnessRecordImpl.class, fitnessRecord.getPrimaryKey(),
			fitnessRecord);

		finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { fitnessRecord.getUuid(), fitnessRecord.getGroupId() },
			fitnessRecord);

		fitnessRecord.resetOriginalValues();
	}

	/**
	 * Caches the fitness records in the entity cache if it is enabled.
	 *
	 * @param fitnessRecords the fitness records
	 */
	@Override
	public void cacheResult(List<FitnessRecord> fitnessRecords) {
		for (FitnessRecord fitnessRecord : fitnessRecords) {
			if (entityCache.getResult(
						FitnessRecordModelImpl.ENTITY_CACHE_ENABLED,
						FitnessRecordImpl.class, fitnessRecord.getPrimaryKey()) == null) {
				cacheResult(fitnessRecord);
			}
			else {
				fitnessRecord.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all fitness records.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(FitnessRecordImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the fitness record.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FitnessRecord fitnessRecord) {
		entityCache.removeResult(FitnessRecordModelImpl.ENTITY_CACHE_ENABLED,
			FitnessRecordImpl.class, fitnessRecord.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((FitnessRecordModelImpl)fitnessRecord, true);
	}

	@Override
	public void clearCache(List<FitnessRecord> fitnessRecords) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (FitnessRecord fitnessRecord : fitnessRecords) {
			entityCache.removeResult(FitnessRecordModelImpl.ENTITY_CACHE_ENABLED,
				FitnessRecordImpl.class, fitnessRecord.getPrimaryKey());

			clearUniqueFindersCache((FitnessRecordModelImpl)fitnessRecord, true);
		}
	}

	protected void cacheUniqueFindersCache(
		FitnessRecordModelImpl fitnessRecordModelImpl) {
		Object[] args = new Object[] {
				fitnessRecordModelImpl.getUuid(),
				fitnessRecordModelImpl.getGroupId()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
			fitnessRecordModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		FitnessRecordModelImpl fitnessRecordModelImpl, boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					fitnessRecordModelImpl.getUuid(),
					fitnessRecordModelImpl.getGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		if ((fitnessRecordModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					fitnessRecordModelImpl.getOriginalUuid(),
					fitnessRecordModelImpl.getOriginalGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new fitness record with the primary key. Does not add the fitness record to the database.
	 *
	 * @param recordId the primary key for the new fitness record
	 * @return the new fitness record
	 */
	@Override
	public FitnessRecord create(long recordId) {
		FitnessRecord fitnessRecord = new FitnessRecordImpl();

		fitnessRecord.setNew(true);
		fitnessRecord.setPrimaryKey(recordId);

		String uuid = PortalUUIDUtil.generate();

		fitnessRecord.setUuid(uuid);

		fitnessRecord.setCompanyId(companyProvider.getCompanyId());

		return fitnessRecord;
	}

	/**
	 * Removes the fitness record with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param recordId the primary key of the fitness record
	 * @return the fitness record that was removed
	 * @throws NoSuchFitnessRecordException if a fitness record with the primary key could not be found
	 */
	@Override
	public FitnessRecord remove(long recordId)
		throws NoSuchFitnessRecordException {
		return remove((Serializable)recordId);
	}

	/**
	 * Removes the fitness record with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the fitness record
	 * @return the fitness record that was removed
	 * @throws NoSuchFitnessRecordException if a fitness record with the primary key could not be found
	 */
	@Override
	public FitnessRecord remove(Serializable primaryKey)
		throws NoSuchFitnessRecordException {
		Session session = null;

		try {
			session = openSession();

			FitnessRecord fitnessRecord = (FitnessRecord)session.get(FitnessRecordImpl.class,
					primaryKey);

			if (fitnessRecord == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFitnessRecordException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(fitnessRecord);
		}
		catch (NoSuchFitnessRecordException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected FitnessRecord removeImpl(FitnessRecord fitnessRecord) {
		fitnessRecord = toUnwrappedModel(fitnessRecord);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(fitnessRecord)) {
				fitnessRecord = (FitnessRecord)session.get(FitnessRecordImpl.class,
						fitnessRecord.getPrimaryKeyObj());
			}

			if (fitnessRecord != null) {
				session.delete(fitnessRecord);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (fitnessRecord != null) {
			clearCache(fitnessRecord);
		}

		return fitnessRecord;
	}

	@Override
	public FitnessRecord updateImpl(FitnessRecord fitnessRecord) {
		fitnessRecord = toUnwrappedModel(fitnessRecord);

		boolean isNew = fitnessRecord.isNew();

		FitnessRecordModelImpl fitnessRecordModelImpl = (FitnessRecordModelImpl)fitnessRecord;

		if (Validator.isNull(fitnessRecord.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			fitnessRecord.setUuid(uuid);
		}

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (fitnessRecord.getCreateDate() == null)) {
			if (serviceContext == null) {
				fitnessRecord.setCreateDate(now);
			}
			else {
				fitnessRecord.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!fitnessRecordModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				fitnessRecord.setModifiedDate(now);
			}
			else {
				fitnessRecord.setModifiedDate(serviceContext.getModifiedDate(
						now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (fitnessRecord.isNew()) {
				session.save(fitnessRecord);

				fitnessRecord.setNew(false);
			}
			else {
				fitnessRecord = (FitnessRecord)session.merge(fitnessRecord);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!FitnessRecordModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { fitnessRecordModelImpl.getUuid() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
				args);

			args = new Object[] {
					fitnessRecordModelImpl.getUuid(),
					fitnessRecordModelImpl.getCompanyId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
				args);

			args = new Object[] { fitnessRecordModelImpl.getGroupId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
				args);

			args = new Object[] { fitnessRecordModelImpl.getUserId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
				args);

			args = new Object[] { fitnessRecordModelImpl.getStudentId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_STUDENTID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STUDENTID,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((fitnessRecordModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						fitnessRecordModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { fitnessRecordModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((fitnessRecordModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						fitnessRecordModelImpl.getOriginalUuid(),
						fitnessRecordModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						fitnessRecordModelImpl.getUuid(),
						fitnessRecordModelImpl.getCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((fitnessRecordModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						fitnessRecordModelImpl.getOriginalGroupId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { fitnessRecordModelImpl.getGroupId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((fitnessRecordModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						fitnessRecordModelImpl.getOriginalUserId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] { fitnessRecordModelImpl.getUserId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}

			if ((fitnessRecordModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STUDENTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						fitnessRecordModelImpl.getOriginalStudentId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_STUDENTID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STUDENTID,
					args);

				args = new Object[] { fitnessRecordModelImpl.getStudentId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_STUDENTID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STUDENTID,
					args);
			}
		}

		entityCache.putResult(FitnessRecordModelImpl.ENTITY_CACHE_ENABLED,
			FitnessRecordImpl.class, fitnessRecord.getPrimaryKey(),
			fitnessRecord, false);

		clearUniqueFindersCache(fitnessRecordModelImpl, false);
		cacheUniqueFindersCache(fitnessRecordModelImpl);

		fitnessRecord.resetOriginalValues();

		return fitnessRecord;
	}

	protected FitnessRecord toUnwrappedModel(FitnessRecord fitnessRecord) {
		if (fitnessRecord instanceof FitnessRecordImpl) {
			return fitnessRecord;
		}

		FitnessRecordImpl fitnessRecordImpl = new FitnessRecordImpl();

		fitnessRecordImpl.setNew(fitnessRecord.isNew());
		fitnessRecordImpl.setPrimaryKey(fitnessRecord.getPrimaryKey());

		fitnessRecordImpl.setUuid(fitnessRecord.getUuid());
		fitnessRecordImpl.setRecordId(fitnessRecord.getRecordId());
		fitnessRecordImpl.setGroupId(fitnessRecord.getGroupId());
		fitnessRecordImpl.setCompanyId(fitnessRecord.getCompanyId());
		fitnessRecordImpl.setUserId(fitnessRecord.getUserId());
		fitnessRecordImpl.setUserName(fitnessRecord.getUserName());
		fitnessRecordImpl.setCreateDate(fitnessRecord.getCreateDate());
		fitnessRecordImpl.setModifiedDate(fitnessRecord.getModifiedDate());
		fitnessRecordImpl.setTeacherUserId(fitnessRecord.getTeacherUserId());
		fitnessRecordImpl.setClassName(fitnessRecord.getClassName());
		fitnessRecordImpl.setStudentFirstName(fitnessRecord.getStudentFirstName());
		fitnessRecordImpl.setStudentLastName(fitnessRecord.getStudentLastName());
		fitnessRecordImpl.setStudentGender(fitnessRecord.getStudentGender());
		fitnessRecordImpl.setStudentId(fitnessRecord.getStudentId());
		fitnessRecordImpl.setStudentGrade(fitnessRecord.getStudentGrade());
		fitnessRecordImpl.setStudentAge(fitnessRecord.getStudentAge());
		fitnessRecordImpl.setTestDate(fitnessRecord.getTestDate());
		fitnessRecordImpl.setHeightFeet(fitnessRecord.getHeightFeet());
		fitnessRecordImpl.setHeightInches(fitnessRecord.getHeightInches());
		fitnessRecordImpl.setWeight(fitnessRecord.getWeight());
		fitnessRecordImpl.setBmi(fitnessRecord.getBmi());
		fitnessRecordImpl.setTriSkinfold(fitnessRecord.getTriSkinfold());
		fitnessRecordImpl.setCalfSkinfold(fitnessRecord.getCalfSkinfold());
		fitnessRecordImpl.setPercentBodyFatCalc(fitnessRecord.getPercentBodyFatCalc());
		fitnessRecordImpl.setPercentBodyFatEntered(fitnessRecord.getPercentBodyFatEntered());
		fitnessRecordImpl.setTwentyMPacerLaps(fitnessRecord.getTwentyMPacerLaps());
		fitnessRecordImpl.setFifteenMPacerLaps(fitnessRecord.getFifteenMPacerLaps());
		fitnessRecordImpl.setPacerVo2Max(fitnessRecord.getPacerVo2Max());
		fitnessRecordImpl.setMileRunMinutes(fitnessRecord.getMileRunMinutes());
		fitnessRecordImpl.setMileRunSeconds(fitnessRecord.getMileRunSeconds());
		fitnessRecordImpl.setMileRunVo2Max(fitnessRecord.getMileRunVo2Max());
		fitnessRecordImpl.setWalkTestMinutes(fitnessRecord.getWalkTestMinutes());
		fitnessRecordImpl.setWalkTestSeconds(fitnessRecord.getWalkTestSeconds());
		fitnessRecordImpl.setWalkTestHrBpm(fitnessRecord.getWalkTestHrBpm());
		fitnessRecordImpl.setWalkTestVo2Max(fitnessRecord.getWalkTestVo2Max());
		fitnessRecordImpl.setCurlUps(fitnessRecord.getCurlUps());
		fitnessRecordImpl.setTrunkLiftInches(fitnessRecord.getTrunkLiftInches());
		fitnessRecordImpl.setPushups(fitnessRecord.getPushups());
		fitnessRecordImpl.setModPullUps(fitnessRecord.getModPullUps());
		fitnessRecordImpl.setFlexArmHangSeconds(fitnessRecord.getFlexArmHangSeconds());
		fitnessRecordImpl.setSitReachLInches(fitnessRecord.getSitReachLInches());
		fitnessRecordImpl.setSitReachRInches(fitnessRecord.getSitReachRInches());
		fitnessRecordImpl.setShoulderStretchL(fitnessRecord.isShoulderStretchL());
		fitnessRecordImpl.setShoulderStretchR(fitnessRecord.isShoulderStretchR());

		return fitnessRecordImpl;
	}

	/**
	 * Returns the fitness record with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the fitness record
	 * @return the fitness record
	 * @throws NoSuchFitnessRecordException if a fitness record with the primary key could not be found
	 */
	@Override
	public FitnessRecord findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFitnessRecordException {
		FitnessRecord fitnessRecord = fetchByPrimaryKey(primaryKey);

		if (fitnessRecord == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFitnessRecordException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return fitnessRecord;
	}

	/**
	 * Returns the fitness record with the primary key or throws a {@link NoSuchFitnessRecordException} if it could not be found.
	 *
	 * @param recordId the primary key of the fitness record
	 * @return the fitness record
	 * @throws NoSuchFitnessRecordException if a fitness record with the primary key could not be found
	 */
	@Override
	public FitnessRecord findByPrimaryKey(long recordId)
		throws NoSuchFitnessRecordException {
		return findByPrimaryKey((Serializable)recordId);
	}

	/**
	 * Returns the fitness record with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the fitness record
	 * @return the fitness record, or <code>null</code> if a fitness record with the primary key could not be found
	 */
	@Override
	public FitnessRecord fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(FitnessRecordModelImpl.ENTITY_CACHE_ENABLED,
				FitnessRecordImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		FitnessRecord fitnessRecord = (FitnessRecord)serializable;

		if (fitnessRecord == null) {
			Session session = null;

			try {
				session = openSession();

				fitnessRecord = (FitnessRecord)session.get(FitnessRecordImpl.class,
						primaryKey);

				if (fitnessRecord != null) {
					cacheResult(fitnessRecord);
				}
				else {
					entityCache.putResult(FitnessRecordModelImpl.ENTITY_CACHE_ENABLED,
						FitnessRecordImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(FitnessRecordModelImpl.ENTITY_CACHE_ENABLED,
					FitnessRecordImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return fitnessRecord;
	}

	/**
	 * Returns the fitness record with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param recordId the primary key of the fitness record
	 * @return the fitness record, or <code>null</code> if a fitness record with the primary key could not be found
	 */
	@Override
	public FitnessRecord fetchByPrimaryKey(long recordId) {
		return fetchByPrimaryKey((Serializable)recordId);
	}

	@Override
	public Map<Serializable, FitnessRecord> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, FitnessRecord> map = new HashMap<Serializable, FitnessRecord>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			FitnessRecord fitnessRecord = fetchByPrimaryKey(primaryKey);

			if (fitnessRecord != null) {
				map.put(primaryKey, fitnessRecord);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(FitnessRecordModelImpl.ENTITY_CACHE_ENABLED,
					FitnessRecordImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (FitnessRecord)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_FITNESSRECORD_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append((long)primaryKey);

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (FitnessRecord fitnessRecord : (List<FitnessRecord>)q.list()) {
				map.put(fitnessRecord.getPrimaryKeyObj(), fitnessRecord);

				cacheResult(fitnessRecord);

				uncachedPrimaryKeys.remove(fitnessRecord.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(FitnessRecordModelImpl.ENTITY_CACHE_ENABLED,
					FitnessRecordImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the fitness records.
	 *
	 * @return the fitness records
	 */
	@Override
	public List<FitnessRecord> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<FitnessRecord> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<FitnessRecord> findAll(int start, int end,
		OrderByComparator<FitnessRecord> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<FitnessRecord> findAll(int start, int end,
		OrderByComparator<FitnessRecord> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<FitnessRecord> list = null;

		if (retrieveFromCache) {
			list = (List<FitnessRecord>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_FITNESSRECORD);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FITNESSRECORD;

				if (pagination) {
					sql = sql.concat(FitnessRecordModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<FitnessRecord>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<FitnessRecord>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the fitness records from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (FitnessRecord fitnessRecord : findAll()) {
			remove(fitnessRecord);
		}
	}

	/**
	 * Returns the number of fitness records.
	 *
	 * @return the number of fitness records
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_FITNESSRECORD);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return FitnessRecordModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the fitness record persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(FitnessRecordImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_FITNESSRECORD = "SELECT fitnessRecord FROM FitnessRecord fitnessRecord";
	private static final String _SQL_SELECT_FITNESSRECORD_WHERE_PKS_IN = "SELECT fitnessRecord FROM FitnessRecord fitnessRecord WHERE recordId IN (";
	private static final String _SQL_SELECT_FITNESSRECORD_WHERE = "SELECT fitnessRecord FROM FitnessRecord fitnessRecord WHERE ";
	private static final String _SQL_COUNT_FITNESSRECORD = "SELECT COUNT(fitnessRecord) FROM FitnessRecord fitnessRecord";
	private static final String _SQL_COUNT_FITNESSRECORD_WHERE = "SELECT COUNT(fitnessRecord) FROM FitnessRecord fitnessRecord WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "fitnessRecord.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No FitnessRecord exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No FitnessRecord exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(FitnessRecordPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}