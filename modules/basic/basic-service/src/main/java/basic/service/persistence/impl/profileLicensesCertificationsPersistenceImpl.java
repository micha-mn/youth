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

import basic.exception.NoSuchprofileLicensesCertificationsException;

import basic.model.impl.profileLicensesCertificationsImpl;
import basic.model.impl.profileLicensesCertificationsModelImpl;
import basic.model.profileLicensesCertifications;

import basic.service.persistence.impl.constants.FOOPersistenceConstants;
import basic.service.persistence.profileLicensesCertificationsPersistence;

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
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
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
import java.util.Date;
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
 * The persistence implementation for the profile licenses certifications service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = profileLicensesCertificationsPersistence.class)
@ProviderType
public class profileLicensesCertificationsPersistenceImpl
	extends BasePersistenceImpl<profileLicensesCertifications>
	implements profileLicensesCertificationsPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>profileLicensesCertificationsUtil</code> to access the profile licenses certifications persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		profileLicensesCertificationsImpl.class.getName();

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
	 * Returns all the profile licenses certificationses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching profile licenses certificationses
	 */
	@Override
	public List<profileLicensesCertifications> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the profile licenses certificationses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>profileLicensesCertificationsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of profile licenses certificationses
	 * @param end the upper bound of the range of profile licenses certificationses (not inclusive)
	 * @return the range of matching profile licenses certificationses
	 */
	@Override
	public List<profileLicensesCertifications> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the profile licenses certificationses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>profileLicensesCertificationsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByUuid(String, int, int, OrderByComparator)}
	 * @param uuid the uuid
	 * @param start the lower bound of the range of profile licenses certificationses
	 * @param end the upper bound of the range of profile licenses certificationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching profile licenses certificationses
	 */
	@Deprecated
	@Override
	public List<profileLicensesCertifications> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<profileLicensesCertifications> orderByComparator,
		boolean useFinderCache) {

		return findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the profile licenses certificationses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>profileLicensesCertificationsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of profile licenses certificationses
	 * @param end the upper bound of the range of profile licenses certificationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching profile licenses certificationses
	 */
	@Override
	public List<profileLicensesCertifications> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<profileLicensesCertifications> orderByComparator) {

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

		List<profileLicensesCertifications> list =
			(List<profileLicensesCertifications>)finderCache.getResult(
				finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (profileLicensesCertifications profileLicensesCertifications :
					list) {

				if (!uuid.equals(profileLicensesCertifications.getUuid())) {
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

			query.append(_SQL_SELECT_PROFILELICENSESCERTIFICATIONS_WHERE);

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
				query.append(
					profileLicensesCertificationsModelImpl.ORDER_BY_JPQL);
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
					list = (List<profileLicensesCertifications>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<profileLicensesCertifications>)QueryUtil.list(
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
	 * Returns the first profile licenses certifications in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching profile licenses certifications
	 * @throws NoSuchprofileLicensesCertificationsException if a matching profile licenses certifications could not be found
	 */
	@Override
	public profileLicensesCertifications findByUuid_First(
			String uuid,
			OrderByComparator<profileLicensesCertifications> orderByComparator)
		throws NoSuchprofileLicensesCertificationsException {

		profileLicensesCertifications profileLicensesCertifications =
			fetchByUuid_First(uuid, orderByComparator);

		if (profileLicensesCertifications != null) {
			return profileLicensesCertifications;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchprofileLicensesCertificationsException(msg.toString());
	}

	/**
	 * Returns the first profile licenses certifications in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching profile licenses certifications, or <code>null</code> if a matching profile licenses certifications could not be found
	 */
	@Override
	public profileLicensesCertifications fetchByUuid_First(
		String uuid,
		OrderByComparator<profileLicensesCertifications> orderByComparator) {

		List<profileLicensesCertifications> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last profile licenses certifications in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching profile licenses certifications
	 * @throws NoSuchprofileLicensesCertificationsException if a matching profile licenses certifications could not be found
	 */
	@Override
	public profileLicensesCertifications findByUuid_Last(
			String uuid,
			OrderByComparator<profileLicensesCertifications> orderByComparator)
		throws NoSuchprofileLicensesCertificationsException {

		profileLicensesCertifications profileLicensesCertifications =
			fetchByUuid_Last(uuid, orderByComparator);

		if (profileLicensesCertifications != null) {
			return profileLicensesCertifications;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchprofileLicensesCertificationsException(msg.toString());
	}

	/**
	 * Returns the last profile licenses certifications in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching profile licenses certifications, or <code>null</code> if a matching profile licenses certifications could not be found
	 */
	@Override
	public profileLicensesCertifications fetchByUuid_Last(
		String uuid,
		OrderByComparator<profileLicensesCertifications> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<profileLicensesCertifications> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the profile licenses certificationses before and after the current profile licenses certifications in the ordered set where uuid = &#63;.
	 *
	 * @param Id the primary key of the current profile licenses certifications
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next profile licenses certifications
	 * @throws NoSuchprofileLicensesCertificationsException if a profile licenses certifications with the primary key could not be found
	 */
	@Override
	public profileLicensesCertifications[] findByUuid_PrevAndNext(
			long Id, String uuid,
			OrderByComparator<profileLicensesCertifications> orderByComparator)
		throws NoSuchprofileLicensesCertificationsException {

		uuid = Objects.toString(uuid, "");

		profileLicensesCertifications profileLicensesCertifications =
			findByPrimaryKey(Id);

		Session session = null;

		try {
			session = openSession();

			profileLicensesCertifications[] array =
				new profileLicensesCertificationsImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, profileLicensesCertifications, uuid, orderByComparator,
				true);

			array[1] = profileLicensesCertifications;

			array[2] = getByUuid_PrevAndNext(
				session, profileLicensesCertifications, uuid, orderByComparator,
				false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected profileLicensesCertifications getByUuid_PrevAndNext(
		Session session,
		profileLicensesCertifications profileLicensesCertifications,
		String uuid,
		OrderByComparator<profileLicensesCertifications> orderByComparator,
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

		query.append(_SQL_SELECT_PROFILELICENSESCERTIFICATIONS_WHERE);

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
			query.append(profileLicensesCertificationsModelImpl.ORDER_BY_JPQL);
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
						profileLicensesCertifications)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<profileLicensesCertifications> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the profile licenses certificationses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (profileLicensesCertifications profileLicensesCertifications :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(profileLicensesCertifications);
		}
	}

	/**
	 * Returns the number of profile licenses certificationses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching profile licenses certificationses
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PROFILELICENSESCERTIFICATIONS_WHERE);

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
		"profileLicensesCertifications.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(profileLicensesCertifications.uuid IS NULL OR profileLicensesCertifications.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the profile licenses certifications where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchprofileLicensesCertificationsException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching profile licenses certifications
	 * @throws NoSuchprofileLicensesCertificationsException if a matching profile licenses certifications could not be found
	 */
	@Override
	public profileLicensesCertifications findByUUID_G(String uuid, long groupId)
		throws NoSuchprofileLicensesCertificationsException {

		profileLicensesCertifications profileLicensesCertifications =
			fetchByUUID_G(uuid, groupId);

		if (profileLicensesCertifications == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchprofileLicensesCertificationsException(
				msg.toString());
		}

		return profileLicensesCertifications;
	}

	/**
	 * Returns the profile licenses certifications where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchByUUID_G(String,long)}
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching profile licenses certifications, or <code>null</code> if a matching profile licenses certifications could not be found
	 */
	@Deprecated
	@Override
	public profileLicensesCertifications fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the profile licenses certifications where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching profile licenses certifications, or <code>null</code> if a matching profile licenses certifications could not be found
	 */
	@Override
	public profileLicensesCertifications fetchByUUID_G(
		String uuid, long groupId) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = new Object[] {uuid, groupId};

		Object result = finderCache.getResult(
			_finderPathFetchByUUID_G, finderArgs, this);

		if (result instanceof profileLicensesCertifications) {
			profileLicensesCertifications profileLicensesCertifications =
				(profileLicensesCertifications)result;

			if (!Objects.equals(
					uuid, profileLicensesCertifications.getUuid()) ||
				(groupId != profileLicensesCertifications.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_PROFILELICENSESCERTIFICATIONS_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
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

				List<profileLicensesCertifications> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchByUUID_G, finderArgs, list);
				}
				else {
					profileLicensesCertifications
						profileLicensesCertifications = list.get(0);

					result = profileLicensesCertifications;

					cacheResult(profileLicensesCertifications);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(_finderPathFetchByUUID_G, finderArgs);

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
			return (profileLicensesCertifications)result;
		}
	}

	/**
	 * Removes the profile licenses certifications where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the profile licenses certifications that was removed
	 */
	@Override
	public profileLicensesCertifications removeByUUID_G(
			String uuid, long groupId)
		throws NoSuchprofileLicensesCertificationsException {

		profileLicensesCertifications profileLicensesCertifications =
			findByUUID_G(uuid, groupId);

		return remove(profileLicensesCertifications);
	}

	/**
	 * Returns the number of profile licenses certificationses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching profile licenses certificationses
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PROFILELICENSESCERTIFICATIONS_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
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

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"profileLicensesCertifications.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(profileLicensesCertifications.uuid IS NULL OR profileLicensesCertifications.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"profileLicensesCertifications.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the profile licenses certificationses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching profile licenses certificationses
	 */
	@Override
	public List<profileLicensesCertifications> findByUuid_C(
		String uuid, long companyId) {

		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the profile licenses certificationses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>profileLicensesCertificationsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of profile licenses certificationses
	 * @param end the upper bound of the range of profile licenses certificationses (not inclusive)
	 * @return the range of matching profile licenses certificationses
	 */
	@Override
	public List<profileLicensesCertifications> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the profile licenses certificationses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>profileLicensesCertificationsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByUuid_C(String,long, int, int, OrderByComparator)}
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of profile licenses certificationses
	 * @param end the upper bound of the range of profile licenses certificationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching profile licenses certificationses
	 */
	@Deprecated
	@Override
	public List<profileLicensesCertifications> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<profileLicensesCertifications> orderByComparator,
		boolean useFinderCache) {

		return findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the profile licenses certificationses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>profileLicensesCertificationsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of profile licenses certificationses
	 * @param end the upper bound of the range of profile licenses certificationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching profile licenses certificationses
	 */
	@Override
	public List<profileLicensesCertifications> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<profileLicensesCertifications> orderByComparator) {

		uuid = Objects.toString(uuid, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByUuid_C;
			finderArgs = new Object[] {uuid, companyId};
		}
		else {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<profileLicensesCertifications> list =
			(List<profileLicensesCertifications>)finderCache.getResult(
				finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (profileLicensesCertifications profileLicensesCertifications :
					list) {

				if (!uuid.equals(profileLicensesCertifications.getUuid()) ||
					(companyId !=
						profileLicensesCertifications.getCompanyId())) {

					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_PROFILELICENSESCERTIFICATIONS_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(
					profileLicensesCertificationsModelImpl.ORDER_BY_JPQL);
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
					list = (List<profileLicensesCertifications>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<profileLicensesCertifications>)QueryUtil.list(
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
	 * Returns the first profile licenses certifications in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching profile licenses certifications
	 * @throws NoSuchprofileLicensesCertificationsException if a matching profile licenses certifications could not be found
	 */
	@Override
	public profileLicensesCertifications findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<profileLicensesCertifications> orderByComparator)
		throws NoSuchprofileLicensesCertificationsException {

		profileLicensesCertifications profileLicensesCertifications =
			fetchByUuid_C_First(uuid, companyId, orderByComparator);

		if (profileLicensesCertifications != null) {
			return profileLicensesCertifications;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchprofileLicensesCertificationsException(msg.toString());
	}

	/**
	 * Returns the first profile licenses certifications in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching profile licenses certifications, or <code>null</code> if a matching profile licenses certifications could not be found
	 */
	@Override
	public profileLicensesCertifications fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<profileLicensesCertifications> orderByComparator) {

		List<profileLicensesCertifications> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last profile licenses certifications in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching profile licenses certifications
	 * @throws NoSuchprofileLicensesCertificationsException if a matching profile licenses certifications could not be found
	 */
	@Override
	public profileLicensesCertifications findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<profileLicensesCertifications> orderByComparator)
		throws NoSuchprofileLicensesCertificationsException {

		profileLicensesCertifications profileLicensesCertifications =
			fetchByUuid_C_Last(uuid, companyId, orderByComparator);

		if (profileLicensesCertifications != null) {
			return profileLicensesCertifications;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchprofileLicensesCertificationsException(msg.toString());
	}

	/**
	 * Returns the last profile licenses certifications in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching profile licenses certifications, or <code>null</code> if a matching profile licenses certifications could not be found
	 */
	@Override
	public profileLicensesCertifications fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<profileLicensesCertifications> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<profileLicensesCertifications> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the profile licenses certificationses before and after the current profile licenses certifications in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param Id the primary key of the current profile licenses certifications
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next profile licenses certifications
	 * @throws NoSuchprofileLicensesCertificationsException if a profile licenses certifications with the primary key could not be found
	 */
	@Override
	public profileLicensesCertifications[] findByUuid_C_PrevAndNext(
			long Id, String uuid, long companyId,
			OrderByComparator<profileLicensesCertifications> orderByComparator)
		throws NoSuchprofileLicensesCertificationsException {

		uuid = Objects.toString(uuid, "");

		profileLicensesCertifications profileLicensesCertifications =
			findByPrimaryKey(Id);

		Session session = null;

		try {
			session = openSession();

			profileLicensesCertifications[] array =
				new profileLicensesCertificationsImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, profileLicensesCertifications, uuid, companyId,
				orderByComparator, true);

			array[1] = profileLicensesCertifications;

			array[2] = getByUuid_C_PrevAndNext(
				session, profileLicensesCertifications, uuid, companyId,
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

	protected profileLicensesCertifications getByUuid_C_PrevAndNext(
		Session session,
		profileLicensesCertifications profileLicensesCertifications,
		String uuid, long companyId,
		OrderByComparator<profileLicensesCertifications> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_PROFILELICENSESCERTIFICATIONS_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

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
			query.append(profileLicensesCertificationsModelImpl.ORDER_BY_JPQL);
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
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						profileLicensesCertifications)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<profileLicensesCertifications> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the profile licenses certificationses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (profileLicensesCertifications profileLicensesCertifications :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(profileLicensesCertifications);
		}
	}

	/**
	 * Returns the number of profile licenses certificationses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching profile licenses certificationses
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PROFILELICENSESCERTIFICATIONS_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
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

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"profileLicensesCertifications.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(profileLicensesCertifications.uuid IS NULL OR profileLicensesCertifications.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"profileLicensesCertifications.companyId = ?";

	public profileLicensesCertificationsPersistenceImpl() {
		setModelClass(profileLicensesCertifications.class);

		setModelImplClass(profileLicensesCertificationsImpl.class);
		setModelPKClass(long.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);
	}

	/**
	 * Caches the profile licenses certifications in the entity cache if it is enabled.
	 *
	 * @param profileLicensesCertifications the profile licenses certifications
	 */
	@Override
	public void cacheResult(
		profileLicensesCertifications profileLicensesCertifications) {

		entityCache.putResult(
			entityCacheEnabled, profileLicensesCertificationsImpl.class,
			profileLicensesCertifications.getPrimaryKey(),
			profileLicensesCertifications);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				profileLicensesCertifications.getUuid(),
				profileLicensesCertifications.getGroupId()
			},
			profileLicensesCertifications);

		profileLicensesCertifications.resetOriginalValues();
	}

	/**
	 * Caches the profile licenses certificationses in the entity cache if it is enabled.
	 *
	 * @param profileLicensesCertificationses the profile licenses certificationses
	 */
	@Override
	public void cacheResult(
		List<profileLicensesCertifications> profileLicensesCertificationses) {

		for (profileLicensesCertifications profileLicensesCertifications :
				profileLicensesCertificationses) {

			if (entityCache.getResult(
					entityCacheEnabled, profileLicensesCertificationsImpl.class,
					profileLicensesCertifications.getPrimaryKey()) == null) {

				cacheResult(profileLicensesCertifications);
			}
			else {
				profileLicensesCertifications.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all profile licenses certificationses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(profileLicensesCertificationsImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the profile licenses certifications.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		profileLicensesCertifications profileLicensesCertifications) {

		entityCache.removeResult(
			entityCacheEnabled, profileLicensesCertificationsImpl.class,
			profileLicensesCertifications.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(
			(profileLicensesCertificationsModelImpl)
				profileLicensesCertifications,
			true);
	}

	@Override
	public void clearCache(
		List<profileLicensesCertifications> profileLicensesCertificationses) {

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (profileLicensesCertifications profileLicensesCertifications :
				profileLicensesCertificationses) {

			entityCache.removeResult(
				entityCacheEnabled, profileLicensesCertificationsImpl.class,
				profileLicensesCertifications.getPrimaryKey());

			clearUniqueFindersCache(
				(profileLicensesCertificationsModelImpl)
					profileLicensesCertifications,
				true);
		}
	}

	protected void cacheUniqueFindersCache(
		profileLicensesCertificationsModelImpl
			profileLicensesCertificationsModelImpl) {

		Object[] args = new Object[] {
			profileLicensesCertificationsModelImpl.getUuid(),
			profileLicensesCertificationsModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathCountByUUID_G, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByUUID_G, args,
			profileLicensesCertificationsModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		profileLicensesCertificationsModelImpl
			profileLicensesCertificationsModelImpl,
		boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				profileLicensesCertificationsModelImpl.getUuid(),
				profileLicensesCertificationsModelImpl.getGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}

		if ((profileLicensesCertificationsModelImpl.getColumnBitmask() &
			 _finderPathFetchByUUID_G.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				profileLicensesCertificationsModelImpl.getOriginalUuid(),
				profileLicensesCertificationsModelImpl.getOriginalGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}
	}

	/**
	 * Creates a new profile licenses certifications with the primary key. Does not add the profile licenses certifications to the database.
	 *
	 * @param Id the primary key for the new profile licenses certifications
	 * @return the new profile licenses certifications
	 */
	@Override
	public profileLicensesCertifications create(long Id) {
		profileLicensesCertifications profileLicensesCertifications =
			new profileLicensesCertificationsImpl();

		profileLicensesCertifications.setNew(true);
		profileLicensesCertifications.setPrimaryKey(Id);

		String uuid = PortalUUIDUtil.generate();

		profileLicensesCertifications.setUuid(uuid);

		profileLicensesCertifications.setCompanyId(
			CompanyThreadLocal.getCompanyId());

		return profileLicensesCertifications;
	}

	/**
	 * Removes the profile licenses certifications with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param Id the primary key of the profile licenses certifications
	 * @return the profile licenses certifications that was removed
	 * @throws NoSuchprofileLicensesCertificationsException if a profile licenses certifications with the primary key could not be found
	 */
	@Override
	public profileLicensesCertifications remove(long Id)
		throws NoSuchprofileLicensesCertificationsException {

		return remove((Serializable)Id);
	}

	/**
	 * Removes the profile licenses certifications with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the profile licenses certifications
	 * @return the profile licenses certifications that was removed
	 * @throws NoSuchprofileLicensesCertificationsException if a profile licenses certifications with the primary key could not be found
	 */
	@Override
	public profileLicensesCertifications remove(Serializable primaryKey)
		throws NoSuchprofileLicensesCertificationsException {

		Session session = null;

		try {
			session = openSession();

			profileLicensesCertifications profileLicensesCertifications =
				(profileLicensesCertifications)session.get(
					profileLicensesCertificationsImpl.class, primaryKey);

			if (profileLicensesCertifications == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchprofileLicensesCertificationsException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(profileLicensesCertifications);
		}
		catch (NoSuchprofileLicensesCertificationsException nsee) {
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
	protected profileLicensesCertifications removeImpl(
		profileLicensesCertifications profileLicensesCertifications) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(profileLicensesCertifications)) {
				profileLicensesCertifications =
					(profileLicensesCertifications)session.get(
						profileLicensesCertificationsImpl.class,
						profileLicensesCertifications.getPrimaryKeyObj());
			}

			if (profileLicensesCertifications != null) {
				session.delete(profileLicensesCertifications);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (profileLicensesCertifications != null) {
			clearCache(profileLicensesCertifications);
		}

		return profileLicensesCertifications;
	}

	@Override
	public profileLicensesCertifications updateImpl(
		profileLicensesCertifications profileLicensesCertifications) {

		boolean isNew = profileLicensesCertifications.isNew();

		if (!(profileLicensesCertifications instanceof
				profileLicensesCertificationsModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(
					profileLicensesCertifications.getClass())) {

				invocationHandler = ProxyUtil.getInvocationHandler(
					profileLicensesCertifications);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in profileLicensesCertifications proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom profileLicensesCertifications implementation " +
					profileLicensesCertifications.getClass());
		}

		profileLicensesCertificationsModelImpl
			profileLicensesCertificationsModelImpl =
				(profileLicensesCertificationsModelImpl)
					profileLicensesCertifications;

		if (Validator.isNull(profileLicensesCertifications.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			profileLicensesCertifications.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (profileLicensesCertifications.getCreateDate() == null)) {
			if (serviceContext == null) {
				profileLicensesCertifications.setCreateDate(now);
			}
			else {
				profileLicensesCertifications.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!profileLicensesCertificationsModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				profileLicensesCertifications.setModifiedDate(now);
			}
			else {
				profileLicensesCertifications.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (profileLicensesCertifications.isNew()) {
				session.save(profileLicensesCertifications);

				profileLicensesCertifications.setNew(false);
			}
			else {
				profileLicensesCertifications =
					(profileLicensesCertifications)session.merge(
						profileLicensesCertifications);
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
				profileLicensesCertificationsModelImpl.getUuid()
			};

			finderCache.removeResult(_finderPathCountByUuid, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid, args);

			args = new Object[] {
				profileLicensesCertificationsModelImpl.getUuid(),
				profileLicensesCertificationsModelImpl.getCompanyId()
			};

			finderCache.removeResult(_finderPathCountByUuid_C, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid_C, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((profileLicensesCertificationsModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					profileLicensesCertificationsModelImpl.getOriginalUuid()
				};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);

				args = new Object[] {
					profileLicensesCertificationsModelImpl.getUuid()
				};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);
			}

			if ((profileLicensesCertificationsModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid_C.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					profileLicensesCertificationsModelImpl.getOriginalUuid(),
					profileLicensesCertificationsModelImpl.
						getOriginalCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);

				args = new Object[] {
					profileLicensesCertificationsModelImpl.getUuid(),
					profileLicensesCertificationsModelImpl.getCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, profileLicensesCertificationsImpl.class,
			profileLicensesCertifications.getPrimaryKey(),
			profileLicensesCertifications, false);

		clearUniqueFindersCache(profileLicensesCertificationsModelImpl, false);
		cacheUniqueFindersCache(profileLicensesCertificationsModelImpl);

		profileLicensesCertifications.resetOriginalValues();

		return profileLicensesCertifications;
	}

	/**
	 * Returns the profile licenses certifications with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the profile licenses certifications
	 * @return the profile licenses certifications
	 * @throws NoSuchprofileLicensesCertificationsException if a profile licenses certifications with the primary key could not be found
	 */
	@Override
	public profileLicensesCertifications findByPrimaryKey(
			Serializable primaryKey)
		throws NoSuchprofileLicensesCertificationsException {

		profileLicensesCertifications profileLicensesCertifications =
			fetchByPrimaryKey(primaryKey);

		if (profileLicensesCertifications == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchprofileLicensesCertificationsException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return profileLicensesCertifications;
	}

	/**
	 * Returns the profile licenses certifications with the primary key or throws a <code>NoSuchprofileLicensesCertificationsException</code> if it could not be found.
	 *
	 * @param Id the primary key of the profile licenses certifications
	 * @return the profile licenses certifications
	 * @throws NoSuchprofileLicensesCertificationsException if a profile licenses certifications with the primary key could not be found
	 */
	@Override
	public profileLicensesCertifications findByPrimaryKey(long Id)
		throws NoSuchprofileLicensesCertificationsException {

		return findByPrimaryKey((Serializable)Id);
	}

	/**
	 * Returns the profile licenses certifications with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param Id the primary key of the profile licenses certifications
	 * @return the profile licenses certifications, or <code>null</code> if a profile licenses certifications with the primary key could not be found
	 */
	@Override
	public profileLicensesCertifications fetchByPrimaryKey(long Id) {
		return fetchByPrimaryKey((Serializable)Id);
	}

	/**
	 * Returns all the profile licenses certificationses.
	 *
	 * @return the profile licenses certificationses
	 */
	@Override
	public List<profileLicensesCertifications> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the profile licenses certificationses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>profileLicensesCertificationsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of profile licenses certificationses
	 * @param end the upper bound of the range of profile licenses certificationses (not inclusive)
	 * @return the range of profile licenses certificationses
	 */
	@Override
	public List<profileLicensesCertifications> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the profile licenses certificationses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>profileLicensesCertificationsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of profile licenses certificationses
	 * @param end the upper bound of the range of profile licenses certificationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of profile licenses certificationses
	 */
	@Deprecated
	@Override
	public List<profileLicensesCertifications> findAll(
		int start, int end,
		OrderByComparator<profileLicensesCertifications> orderByComparator,
		boolean useFinderCache) {

		return findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the profile licenses certificationses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>profileLicensesCertificationsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of profile licenses certificationses
	 * @param end the upper bound of the range of profile licenses certificationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of profile licenses certificationses
	 */
	@Override
	public List<profileLicensesCertifications> findAll(
		int start, int end,
		OrderByComparator<profileLicensesCertifications> orderByComparator) {

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

		List<profileLicensesCertifications> list =
			(List<profileLicensesCertifications>)finderCache.getResult(
				finderPath, finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_PROFILELICENSESCERTIFICATIONS);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PROFILELICENSESCERTIFICATIONS;

				if (pagination) {
					sql = sql.concat(
						profileLicensesCertificationsModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<profileLicensesCertifications>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<profileLicensesCertifications>)QueryUtil.list(
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
	 * Removes all the profile licenses certificationses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (profileLicensesCertifications profileLicensesCertifications :
				findAll()) {

			remove(profileLicensesCertifications);
		}
	}

	/**
	 * Returns the number of profile licenses certificationses.
	 *
	 * @return the number of profile licenses certificationses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(
					_SQL_COUNT_PROFILELICENSESCERTIFICATIONS);

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
		return "Id";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PROFILELICENSESCERTIFICATIONS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return profileLicensesCertificationsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the profile licenses certifications persistence.
	 */
	@Activate
	public void activate() {
		profileLicensesCertificationsModelImpl.setEntityCacheEnabled(
			entityCacheEnabled);
		profileLicensesCertificationsModelImpl.setFinderCacheEnabled(
			finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			profileLicensesCertificationsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			profileLicensesCertificationsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			profileLicensesCertificationsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			profileLicensesCertificationsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()},
			profileLicensesCertificationsModelImpl.UUID_COLUMN_BITMASK);

		_finderPathCountByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()});

		_finderPathFetchByUUID_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			profileLicensesCertificationsImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			profileLicensesCertificationsModelImpl.UUID_COLUMN_BITMASK |
			profileLicensesCertificationsModelImpl.GROUPID_COLUMN_BITMASK);

		_finderPathCountByUUID_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			profileLicensesCertificationsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			profileLicensesCertificationsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			profileLicensesCertificationsModelImpl.UUID_COLUMN_BITMASK |
			profileLicensesCertificationsModelImpl.COMPANYID_COLUMN_BITMASK);

		_finderPathCountByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(
			profileLicensesCertificationsImpl.class.getName());
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
				"value.object.column.bitmask.enabled.basic.model.profileLicensesCertifications"),
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

	private static final String _SQL_SELECT_PROFILELICENSESCERTIFICATIONS =
		"SELECT profileLicensesCertifications FROM profileLicensesCertifications profileLicensesCertifications";

	private static final String
		_SQL_SELECT_PROFILELICENSESCERTIFICATIONS_WHERE =
			"SELECT profileLicensesCertifications FROM profileLicensesCertifications profileLicensesCertifications WHERE ";

	private static final String _SQL_COUNT_PROFILELICENSESCERTIFICATIONS =
		"SELECT COUNT(profileLicensesCertifications) FROM profileLicensesCertifications profileLicensesCertifications";

	private static final String _SQL_COUNT_PROFILELICENSESCERTIFICATIONS_WHERE =
		"SELECT COUNT(profileLicensesCertifications) FROM profileLicensesCertifications profileLicensesCertifications WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"profileLicensesCertifications.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No profileLicensesCertifications exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No profileLicensesCertifications exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		profileLicensesCertificationsPersistenceImpl.class);

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