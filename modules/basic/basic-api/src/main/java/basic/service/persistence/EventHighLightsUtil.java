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

import basic.model.EventHighLights;

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
 * The persistence utility for the event high lights service. This utility wraps <code>basic.service.persistence.impl.EventHighLightsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EventHighLightsPersistence
 * @generated
 */
@ProviderType
public class EventHighLightsUtil {

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
	public static void clearCache(EventHighLights eventHighLights) {
		getPersistence().clearCache(eventHighLights);
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
	public static Map<Serializable, EventHighLights> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<EventHighLights> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EventHighLights> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EventHighLights> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<EventHighLights> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static EventHighLights update(EventHighLights eventHighLights) {
		return getPersistence().update(eventHighLights);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static EventHighLights update(
		EventHighLights eventHighLights, ServiceContext serviceContext) {

		return getPersistence().update(eventHighLights, serviceContext);
	}

	/**
	 * Returns all the event high lightses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching event high lightses
	 */
	public static List<EventHighLights> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the event high lightses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EventHighLightsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of event high lightses
	 * @param end the upper bound of the range of event high lightses (not inclusive)
	 * @return the range of matching event high lightses
	 */
	public static List<EventHighLights> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the event high lightses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EventHighLightsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByUuid(String, int, int, OrderByComparator)}
	 * @param uuid the uuid
	 * @param start the lower bound of the range of event high lightses
	 * @param end the upper bound of the range of event high lightses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching event high lightses
	 */
	@Deprecated
	public static List<EventHighLights> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EventHighLights> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the event high lightses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EventHighLightsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of event high lightses
	 * @param end the upper bound of the range of event high lightses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching event high lightses
	 */
	public static List<EventHighLights> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EventHighLights> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns the first event high lights in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event high lights
	 * @throws NoSuchEventHighLightsException if a matching event high lights could not be found
	 */
	public static EventHighLights findByUuid_First(
			String uuid, OrderByComparator<EventHighLights> orderByComparator)
		throws basic.exception.NoSuchEventHighLightsException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first event high lights in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event high lights, or <code>null</code> if a matching event high lights could not be found
	 */
	public static EventHighLights fetchByUuid_First(
		String uuid, OrderByComparator<EventHighLights> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last event high lights in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event high lights
	 * @throws NoSuchEventHighLightsException if a matching event high lights could not be found
	 */
	public static EventHighLights findByUuid_Last(
			String uuid, OrderByComparator<EventHighLights> orderByComparator)
		throws basic.exception.NoSuchEventHighLightsException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last event high lights in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event high lights, or <code>null</code> if a matching event high lights could not be found
	 */
	public static EventHighLights fetchByUuid_Last(
		String uuid, OrderByComparator<EventHighLights> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the event high lightses before and after the current event high lights in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current event high lights
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next event high lights
	 * @throws NoSuchEventHighLightsException if a event high lights with the primary key could not be found
	 */
	public static EventHighLights[] findByUuid_PrevAndNext(
			long id, String uuid,
			OrderByComparator<EventHighLights> orderByComparator)
		throws basic.exception.NoSuchEventHighLightsException {

		return getPersistence().findByUuid_PrevAndNext(
			id, uuid, orderByComparator);
	}

	/**
	 * Removes all the event high lightses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of event high lightses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching event high lightses
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Caches the event high lights in the entity cache if it is enabled.
	 *
	 * @param eventHighLights the event high lights
	 */
	public static void cacheResult(EventHighLights eventHighLights) {
		getPersistence().cacheResult(eventHighLights);
	}

	/**
	 * Caches the event high lightses in the entity cache if it is enabled.
	 *
	 * @param eventHighLightses the event high lightses
	 */
	public static void cacheResult(List<EventHighLights> eventHighLightses) {
		getPersistence().cacheResult(eventHighLightses);
	}

	/**
	 * Creates a new event high lights with the primary key. Does not add the event high lights to the database.
	 *
	 * @param id the primary key for the new event high lights
	 * @return the new event high lights
	 */
	public static EventHighLights create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the event high lights with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the event high lights
	 * @return the event high lights that was removed
	 * @throws NoSuchEventHighLightsException if a event high lights with the primary key could not be found
	 */
	public static EventHighLights remove(long id)
		throws basic.exception.NoSuchEventHighLightsException {

		return getPersistence().remove(id);
	}

	public static EventHighLights updateImpl(EventHighLights eventHighLights) {
		return getPersistence().updateImpl(eventHighLights);
	}

	/**
	 * Returns the event high lights with the primary key or throws a <code>NoSuchEventHighLightsException</code> if it could not be found.
	 *
	 * @param id the primary key of the event high lights
	 * @return the event high lights
	 * @throws NoSuchEventHighLightsException if a event high lights with the primary key could not be found
	 */
	public static EventHighLights findByPrimaryKey(long id)
		throws basic.exception.NoSuchEventHighLightsException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the event high lights with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the event high lights
	 * @return the event high lights, or <code>null</code> if a event high lights with the primary key could not be found
	 */
	public static EventHighLights fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the event high lightses.
	 *
	 * @return the event high lightses
	 */
	public static List<EventHighLights> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the event high lightses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EventHighLightsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of event high lightses
	 * @param end the upper bound of the range of event high lightses (not inclusive)
	 * @return the range of event high lightses
	 */
	public static List<EventHighLights> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the event high lightses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EventHighLightsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of event high lightses
	 * @param end the upper bound of the range of event high lightses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of event high lightses
	 */
	@Deprecated
	public static List<EventHighLights> findAll(
		int start, int end,
		OrderByComparator<EventHighLights> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the event high lightses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EventHighLightsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of event high lightses
	 * @param end the upper bound of the range of event high lightses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of event high lightses
	 */
	public static List<EventHighLights> findAll(
		int start, int end,
		OrderByComparator<EventHighLights> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Removes all the event high lightses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of event high lightses.
	 *
	 * @return the number of event high lightses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static EventHighLightsPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<EventHighLightsPersistence, EventHighLightsPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			EventHighLightsPersistence.class);

		ServiceTracker<EventHighLightsPersistence, EventHighLightsPersistence>
			serviceTracker =
				new ServiceTracker
					<EventHighLightsPersistence, EventHighLightsPersistence>(
						bundle.getBundleContext(),
						EventHighLightsPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}