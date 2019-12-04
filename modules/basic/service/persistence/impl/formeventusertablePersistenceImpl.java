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

package basic.service.persistence.impl;

import basic.exception.NoSuchformeventusertableException;

import basic.model.formeventusertable;
import basic.model.impl.formeventusertableImpl;
import basic.model.impl.formeventusertableModelImpl;

import basic.service.persistence.formeventusertablePersistence;
import basic.service.persistence.impl.constants.FOOPersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the formeventusertable service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = formeventusertablePersistence.class)
@ProviderType
public class formeventusertablePersistenceImpl
	extends BasePersistenceImpl<formeventusertable>
	implements formeventusertablePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>formeventusertableUtil</code> to access the formeventusertable persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		formeventusertableImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the formeventusertables where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching formeventusertables
	 */
	@Override
	public List<formeventusertable> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the formeventusertables where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>formeventusertableModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of formeventusertables
	 * @param end the upper bound of the range of formeventusertables (not inclusive)
	 * @return the range of matching formeventusertables
	 */
	@Override
	public List<formeventusertable> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the formeventusertables where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>formeventusertableModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByUuid(String, int, int, OrderByComparator)}
	 * @param uuid the uuid
	 * @param start the lower bound of the range of formeventusertables
	 * @param end the upper bound of the range of formeventusertables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching formeventusertables
	 */
	@Deprecated
	@Override
	public List<formeventusertable> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<formeventusertable> orderByComparator,
		boolean useFinderCache) {

		return findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the formeventusertables where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>formeventusertableModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of formeventusertables
	 * @param end the upper bound of the range of formeventusertables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching formeventusertables
	 */
	@Override
	public List<formeventusertable> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<formeventusertable> orderByComparator) {

		uuid = Objects.toString(uuid, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByUuid;
			finderArgs = new Object[] {uuid};
		}
		else {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<formeventusertable> list =
			(List<formeventusertable>)finderCache.getResult(
				finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (formeventusertable formeventusertable : list) {
				if (!uuid.equals(formeventusertable.getUuid())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_FORMEVENTUSERTABLE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(formeventusertableModelImpl.ORDER_BY_JPQL);
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
					list = (List<formeventusertable>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<formeventusertable>)QueryUtil.list(
						q, getDialect(), start, end);
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
	 * Returns the first formeventusertable in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching formeventusertable
	 * @throws NoSuchformeventusertableException if a matching formeventusertable could not be found
	 */
	@Override
	public formeventusertable findByUuid_First(
			String uuid,
			OrderByComparator<formeventusertable> orderByComparator)
		throws NoSuchformeventusertableException {

		formeventusertable formeventusertable = fetchByUuid_First(
			uuid, orderByComparator);

		if (formeventusertable != null) {
			return formeventusertable;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchformeventusertableException(msg.toString());
	}

	/**
	 * Returns the first formeventusertable in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching formeventusertable, or <code>null</code> if a matching formeventusertable could not be found
	 */
	@Override
	public formeventusertable fetchByUuid_First(
		String uuid, OrderByComparator<formeventusertable> orderByComparator) {

		List<formeventusertable> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last formeventusertable in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching formeventusertable
	 * @throws NoSuchformeventusertableException if a matching formeventusertable could not be found
	 */
	@Override
	public formeventusertable findByUuid_Last(
			String uuid,
			OrderByComparator<formeventusertable> orderByComparator)
		throws NoSuchformeventusertableException {

		formeventusertable formeventusertable = fetchByUuid_Last(
			uuid, orderByComparator);

		if (formeventusertable != null) {
			return formeventusertable;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchformeventusertableException(msg.toString());
	}

	/**
	 * Returns the last formeventusertable in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching formeventusertable, or <code>null</code> if a matching formeventusertable could not be found
	 */
	@Override
	public formeventusertable fetchByUuid_Last(
		String uuid, OrderByComparator<formeventusertable> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<formeventusertable> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the formeventusertables before and after the current formeventusertable in the ordered set where uuid = &#63;.
	 *
	 * @param ID the primary key of the current formeventusertable
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next formeventusertable
	 * @throws NoSuchformeventusertableException if a formeventusertable with the primary key could not be found
	 */
	@Override
	public formeventusertable[] findByUuid_PrevAndNext(
			long ID, String uuid,
			OrderByComparator<formeventusertable> orderByComparator)
		throws NoSuchformeventusertableException {

		uuid = Objects.toString(uuid, "");

		formeventusertable formeventusertable = findByPrimaryKey(ID);

		Session session = null;

		try {
			session = openSession();

			formeventusertable[] array = new formeventusertableImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, formeventusertable, uuid, orderByComparator, true);

			array[1] = formeventusertable;

			array[2] = getByUuid_PrevAndNext(
				session, formeventusertable, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected formeventusertable getByUuid_PrevAndNext(
		Session session, formeventusertable formeventusertable, String uuid,
		OrderByComparator<formeventusertable> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FORMEVENTUSERTABLE_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

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
			query.append(formeventusertableModelImpl.ORDER_BY_JPQL);
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
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						formeventusertable)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<formeventusertable> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the formeventusertables where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (formeventusertable formeventusertable :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(formeventusertable);
		}
	}

	/**
	 * Returns the number of formeventusertables where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching formeventusertables
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FORMEVENTUSERTABLE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
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

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"formeventusertable.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(formeventusertable.uuid IS NULL OR formeventusertable.uuid = '')";

	public formeventusertablePersistenceImpl() {
		setModelClass(formeventusertable.class);

		setModelImplClass(formeventusertableImpl.class);
		setModelPKClass(long.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);
	}

	/**
	 * Caches the formeventusertable in the entity cache if it is enabled.
	 *
	 * @param formeventusertable the formeventusertable
	 */
	@Override
	public void cacheResult(formeventusertable formeventusertable) {
		entityCache.putResult(
			entityCacheEnabled, formeventusertableImpl.class,
			formeventusertable.getPrimaryKey(), formeventusertable);

		formeventusertable.resetOriginalValues();
	}

	/**
	 * Caches the formeventusertables in the entity cache if it is enabled.
	 *
	 * @param formeventusertables the formeventusertables
	 */
	@Override
	public void cacheResult(List<formeventusertable> formeventusertables) {
		for (formeventusertable formeventusertable : formeventusertables) {
			if (entityCache.getResult(
					entityCacheEnabled, formeventusertableImpl.class,
					formeventusertable.getPrimaryKey()) == null) {

				cacheResult(formeventusertable);
			}
			else {
				formeventusertable.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all formeventusertables.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(formeventusertableImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the formeventusertable.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(formeventusertable formeventusertable) {
		entityCache.removeResult(
			entityCacheEnabled, formeventusertableImpl.class,
			formeventusertable.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<formeventusertable> formeventusertables) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (formeventusertable formeventusertable : formeventusertables) {
			entityCache.removeResult(
				entityCacheEnabled, formeventusertableImpl.class,
				formeventusertable.getPrimaryKey());
		}
	}

	/**
	 * Creates a new formeventusertable with the primary key. Does not add the formeventusertable to the database.
	 *
	 * @param ID the primary key for the new formeventusertable
	 * @return the new formeventusertable
	 */
	@Override
	public formeventusertable create(long ID) {
		formeventusertable formeventusertable = new formeventusertableImpl();

		formeventusertable.setNew(true);
		formeventusertable.setPrimaryKey(ID);

		String uuid = PortalUUIDUtil.generate();

		formeventusertable.setUuid(uuid);

		return formeventusertable;
	}

	/**
	 * Removes the formeventusertable with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ID the primary key of the formeventusertable
	 * @return the formeventusertable that was removed
	 * @throws NoSuchformeventusertableException if a formeventusertable with the primary key could not be found
	 */
	@Override
	public formeventusertable remove(long ID)
		throws NoSuchformeventusertableException {

		return remove((Serializable)ID);
	}

	/**
	 * Removes the formeventusertable with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the formeventusertable
	 * @return the formeventusertable that was removed
	 * @throws NoSuchformeventusertableException if a formeventusertable with the primary key could not be found
	 */
	@Override
	public formeventusertable remove(Serializable primaryKey)
		throws NoSuchformeventusertableException {

		Session session = null;

		try {
			session = openSession();

			formeventusertable formeventusertable =
				(formeventusertable)session.get(
					formeventusertableImpl.class, primaryKey);

			if (formeventusertable == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchformeventusertableException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(formeventusertable);
		}
		catch (NoSuchformeventusertableException nsee) {
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
	protected formeventusertable removeImpl(
		formeventusertable formeventusertable) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(formeventusertable)) {
				formeventusertable = (formeventusertable)session.get(
					formeventusertableImpl.class,
					formeventusertable.getPrimaryKeyObj());
			}

			if (formeventusertable != null) {
				session.delete(formeventusertable);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (formeventusertable != null) {
			clearCache(formeventusertable);
		}

		return formeventusertable;
	}

	@Override
	public formeventusertable updateImpl(
		formeventusertable formeventusertable) {

		boolean isNew = formeventusertable.isNew();

		if (!(formeventusertable instanceof formeventusertableModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(formeventusertable.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					formeventusertable);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in formeventusertable proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom formeventusertable implementation " +
					formeventusertable.getClass());
		}

		formeventusertableModelImpl formeventusertableModelImpl =
			(formeventusertableModelImpl)formeventusertable;

		if (Validator.isNull(formeventusertable.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			formeventusertable.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (formeventusertable.isNew()) {
				session.save(formeventusertable);

				formeventusertable.setNew(false);
			}
			else {
				formeventusertable = (formeventusertable)session.merge(
					formeventusertable);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!_columnBitmaskEnabled) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {
				formeventusertableModelImpl.getUuid()
			};

			finderCache.removeResult(_finderPathCountByUuid, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((formeventusertableModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					formeventusertableModelImpl.getOriginalUuid()
				};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);

				args = new Object[] {formeventusertableModelImpl.getUuid()};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, formeventusertableImpl.class,
			formeventusertable.getPrimaryKey(), formeventusertable, false);

		formeventusertable.resetOriginalValues();

		return formeventusertable;
	}

	/**
	 * Returns the formeventusertable with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the formeventusertable
	 * @return the formeventusertable
	 * @throws NoSuchformeventusertableException if a formeventusertable with the primary key could not be found
	 */
	@Override
	public formeventusertable findByPrimaryKey(Serializable primaryKey)
		throws NoSuchformeventusertableException {

		formeventusertable formeventusertable = fetchByPrimaryKey(primaryKey);

		if (formeventusertable == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchformeventusertableException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return formeventusertable;
	}

	/**
	 * Returns the formeventusertable with the primary key or throws a <code>NoSuchformeventusertableException</code> if it could not be found.
	 *
	 * @param ID the primary key of the formeventusertable
	 * @return the formeventusertable
	 * @throws NoSuchformeventusertableException if a formeventusertable with the primary key could not be found
	 */
	@Override
	public formeventusertable findByPrimaryKey(long ID)
		throws NoSuchformeventusertableException {

		return findByPrimaryKey((Serializable)ID);
	}

	/**
	 * Returns the formeventusertable with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ID the primary key of the formeventusertable
	 * @return the formeventusertable, or <code>null</code> if a formeventusertable with the primary key could not be found
	 */
	@Override
	public formeventusertable fetchByPrimaryKey(long ID) {
		return fetchByPrimaryKey((Serializable)ID);
	}

	/**
	 * Returns all the formeventusertables.
	 *
	 * @return the formeventusertables
	 */
	@Override
	public List<formeventusertable> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the formeventusertables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>formeventusertableModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of formeventusertables
	 * @param end the upper bound of the range of formeventusertables (not inclusive)
	 * @return the range of formeventusertables
	 */
	@Override
	public List<formeventusertable> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the formeventusertables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>formeventusertableModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of formeventusertables
	 * @param end the upper bound of the range of formeventusertables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of formeventusertables
	 */
	@Deprecated
	@Override
	public List<formeventusertable> findAll(
		int start, int end,
		OrderByComparator<formeventusertable> orderByComparator,
		boolean useFinderCache) {

		return findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the formeventusertables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>formeventusertableModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of formeventusertables
	 * @param end the upper bound of the range of formeventusertables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of formeventusertables
	 */
	@Override
	public List<formeventusertable> findAll(
		int start, int end,
		OrderByComparator<formeventusertable> orderByComparator) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindAll;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<formeventusertable> list =
			(List<formeventusertable>)finderCache.getResult(
				finderPath, finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_FORMEVENTUSERTABLE);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FORMEVENTUSERTABLE;

				if (pagination) {
					sql = sql.concat(formeventusertableModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<formeventusertable>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<formeventusertable>)QueryUtil.list(
						q, getDialect(), start, end);
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
	 * Removes all the formeventusertables from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (formeventusertable formeventusertable : findAll()) {
			remove(formeventusertable);
		}
	}

	/**
	 * Returns the number of formeventusertables.
	 *
	 * @return the number of formeventusertables
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_FORMEVENTUSERTABLE);

				count = (Long)q.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

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
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "ID";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_FORMEVENTUSERTABLE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return formeventusertableModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the formeventusertable persistence.
	 */
	@Activate
	public void activate() {
		formeventusertableModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		formeventusertableModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			formeventusertableImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			formeventusertableImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			formeventusertableImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			formeventusertableImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()},
			formeventusertableModelImpl.UUID_COLUMN_BITMASK);

		_finderPathCountByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(formeventusertableImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = FOOPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.basic.model.formeventusertable"),
			true);
	}

	@Override
	@Reference(
		target = FOOPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = FOOPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private boolean _columnBitmaskEnabled;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_FORMEVENTUSERTABLE =
		"SELECT formeventusertable FROM formeventusertable formeventusertable";

	private static final String _SQL_SELECT_FORMEVENTUSERTABLE_WHERE =
		"SELECT formeventusertable FROM formeventusertable formeventusertable WHERE ";

	private static final String _SQL_COUNT_FORMEVENTUSERTABLE =
		"SELECT COUNT(formeventusertable) FROM formeventusertable formeventusertable";

	private static final String _SQL_COUNT_FORMEVENTUSERTABLE_WHERE =
		"SELECT COUNT(formeventusertable) FROM formeventusertable formeventusertable WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "formeventusertable.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No formeventusertable exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No formeventusertable exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		formeventusertablePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	static {
		try {
			Class.forName(FOOPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException cnfe) {
			throw new ExceptionInInitializerError(cnfe);
		}
	}

}