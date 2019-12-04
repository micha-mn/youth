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

package basic.service.persistence;

import basic.model.EventFAQs;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the event fa qs service. This utility wraps <code>basic.service.persistence.impl.EventFAQsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EventFAQsPersistence
 * @generated
 */
@ProviderType
public class EventFAQsUtil {

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
	public static void clearCache(EventFAQs eventFAQs) {
		getPersistence().clearCache(eventFAQs);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, EventFAQs> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<EventFAQs> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EventFAQs> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EventFAQs> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<EventFAQs> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static EventFAQs update(EventFAQs eventFAQs) {
		return getPersistence().update(eventFAQs);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static EventFAQs update(
		EventFAQs eventFAQs, ServiceContext serviceContext) {

		return getPersistence().update(eventFAQs, serviceContext);
	}

	/**
	 * Returns all the event fa qses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching event fa qses
	 */
	public static List<EventFAQs> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the event fa qses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EventFAQsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of event fa qses
	 * @param end the upper bound of the range of event fa qses (not inclusive)
	 * @return the range of matching event fa qses
	 */
	public static List<EventFAQs> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the event fa qses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EventFAQsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByUuid(String, int, int, OrderByComparator)}
	 * @param uuid the uuid
	 * @param start the lower bound of the range of event fa qses
	 * @param end the upper bound of the range of event fa qses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching event fa qses
	 */
	@Deprecated
	public static List<EventFAQs> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EventFAQs> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the event fa qses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EventFAQsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of event fa qses
	 * @param end the upper bound of the range of event fa qses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching event fa qses
	 */
	public static List<EventFAQs> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EventFAQs> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns the first event fa qs in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event fa qs
	 * @throws NoSuchEventFAQsException if a matching event fa qs could not be found
	 */
	public static EventFAQs findByUuid_First(
			String uuid, OrderByComparator<EventFAQs> orderByComparator)
		throws basic.exception.NoSuchEventFAQsException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first event fa qs in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event fa qs, or <code>null</code> if a matching event fa qs could not be found
	 */
	public static EventFAQs fetchByUuid_First(
		String uuid, OrderByComparator<EventFAQs> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last event fa qs in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event fa qs
	 * @throws NoSuchEventFAQsException if a matching event fa qs could not be found
	 */
	public static EventFAQs findByUuid_Last(
			String uuid, OrderByComparator<EventFAQs> orderByComparator)
		throws basic.exception.NoSuchEventFAQsException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last event fa qs in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event fa qs, or <code>null</code> if a matching event fa qs could not be found
	 */
	public static EventFAQs fetchByUuid_Last(
		String uuid, OrderByComparator<EventFAQs> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the event fa qses before and after the current event fa qs in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current event fa qs
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next event fa qs
	 * @throws NoSuchEventFAQsException if a event fa qs with the primary key could not be found
	 */
	public static EventFAQs[] findByUuid_PrevAndNext(
			long id, String uuid,
			OrderByComparator<EventFAQs> orderByComparator)
		throws basic.exception.NoSuchEventFAQsException {

		return getPersistence().findByUuid_PrevAndNext(
			id, uuid, orderByComparator);
	}

	/**
	 * Removes all the event fa qses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of event fa qses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching event fa qses
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Caches the event fa qs in the entity cache if it is enabled.
	 *
	 * @param eventFAQs the event fa qs
	 */
	public static void cacheResult(EventFAQs eventFAQs) {
		getPersistence().cacheResult(eventFAQs);
	}

	/**
	 * Caches the event fa qses in the entity cache if it is enabled.
	 *
	 * @param eventFAQses the event fa qses
	 */
	public static void cacheResult(List<EventFAQs> eventFAQses) {
		getPersistence().cacheResult(eventFAQses);
	}

	/**
	 * Creates a new event fa qs with the primary key. Does not add the event fa qs to the database.
	 *
	 * @param id the primary key for the new event fa qs
	 * @return the new event fa qs
	 */
	public static EventFAQs create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the event fa qs with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the event fa qs
	 * @return the event fa qs that was removed
	 * @throws NoSuchEventFAQsException if a event fa qs with the primary key could not be found
	 */
	public static EventFAQs remove(long id)
		throws basic.exception.NoSuchEventFAQsException {

		return getPersistence().remove(id);
	}

	public static EventFAQs updateImpl(EventFAQs eventFAQs) {
		return getPersistence().updateImpl(eventFAQs);
	}

	/**
	 * Returns the event fa qs with the primary key or throws a <code>NoSuchEventFAQsException</code> if it could not be found.
	 *
	 * @param id the primary key of the event fa qs
	 * @return the event fa qs
	 * @throws NoSuchEventFAQsException if a event fa qs with the primary key could not be found
	 */
	public static EventFAQs findByPrimaryKey(long id)
		throws basic.exception.NoSuchEventFAQsException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the event fa qs with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the event fa qs
	 * @return the event fa qs, or <code>null</code> if a event fa qs with the primary key could not be found
	 */
	public static EventFAQs fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the event fa qses.
	 *
	 * @return the event fa qses
	 */
	public static List<EventFAQs> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the event fa qses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EventFAQsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of event fa qses
	 * @param end the upper bound of the range of event fa qses (not inclusive)
	 * @return the range of event fa qses
	 */
	public static List<EventFAQs> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the event fa qses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EventFAQsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of event fa qses
	 * @param end the upper bound of the range of event fa qses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of event fa qses
	 */
	@Deprecated
	public static List<EventFAQs> findAll(
		int start, int end, OrderByComparator<EventFAQs> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the event fa qses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EventFAQsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of event fa qses
	 * @param end the upper bound of the range of event fa qses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of event fa qses
	 */
	public static List<EventFAQs> findAll(
		int start, int end, OrderByComparator<EventFAQs> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Removes all the event fa qses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of event fa qses.
	 *
	 * @return the number of event fa qses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static EventFAQsPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<EventFAQsPersistence, EventFAQsPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(EventFAQsPersistence.class);

		ServiceTracker<EventFAQsPersistence, EventFAQsPersistence>
			serviceTracker =
				new ServiceTracker<EventFAQsPersistence, EventFAQsPersistence>(
					bundle.getBundleContext(), EventFAQsPersistence.class,
					null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}