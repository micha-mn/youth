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

import basic.model.EventAttributes;

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
 * The persistence utility for the event attributes service. This utility wraps <code>basic.service.persistence.impl.EventAttributesPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EventAttributesPersistence
 * @generated
 */
@ProviderType
public class EventAttributesUtil {

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
	public static void clearCache(EventAttributes eventAttributes) {
		getPersistence().clearCache(eventAttributes);
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
	public static Map<Serializable, EventAttributes> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<EventAttributes> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EventAttributes> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EventAttributes> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<EventAttributes> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static EventAttributes update(EventAttributes eventAttributes) {
		return getPersistence().update(eventAttributes);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static EventAttributes update(
		EventAttributes eventAttributes, ServiceContext serviceContext) {

		return getPersistence().update(eventAttributes, serviceContext);
	}

	/**
	 * Caches the event attributes in the entity cache if it is enabled.
	 *
	 * @param eventAttributes the event attributes
	 */
	public static void cacheResult(EventAttributes eventAttributes) {
		getPersistence().cacheResult(eventAttributes);
	}

	/**
	 * Caches the event attributeses in the entity cache if it is enabled.
	 *
	 * @param eventAttributeses the event attributeses
	 */
	public static void cacheResult(List<EventAttributes> eventAttributeses) {
		getPersistence().cacheResult(eventAttributeses);
	}

	/**
	 * Creates a new event attributes with the primary key. Does not add the event attributes to the database.
	 *
	 * @param id the primary key for the new event attributes
	 * @return the new event attributes
	 */
	public static EventAttributes create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the event attributes with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the event attributes
	 * @return the event attributes that was removed
	 * @throws NoSuchEventAttributesException if a event attributes with the primary key could not be found
	 */
	public static EventAttributes remove(long id)
		throws basic.exception.NoSuchEventAttributesException {

		return getPersistence().remove(id);
	}

	public static EventAttributes updateImpl(EventAttributes eventAttributes) {
		return getPersistence().updateImpl(eventAttributes);
	}

	/**
	 * Returns the event attributes with the primary key or throws a <code>NoSuchEventAttributesException</code> if it could not be found.
	 *
	 * @param id the primary key of the event attributes
	 * @return the event attributes
	 * @throws NoSuchEventAttributesException if a event attributes with the primary key could not be found
	 */
	public static EventAttributes findByPrimaryKey(long id)
		throws basic.exception.NoSuchEventAttributesException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the event attributes with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the event attributes
	 * @return the event attributes, or <code>null</code> if a event attributes with the primary key could not be found
	 */
	public static EventAttributes fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the event attributeses.
	 *
	 * @return the event attributeses
	 */
	public static List<EventAttributes> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the event attributeses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EventAttributesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of event attributeses
	 * @param end the upper bound of the range of event attributeses (not inclusive)
	 * @return the range of event attributeses
	 */
	public static List<EventAttributes> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the event attributeses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EventAttributesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of event attributeses
	 * @param end the upper bound of the range of event attributeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of event attributeses
	 */
	@Deprecated
	public static List<EventAttributes> findAll(
		int start, int end,
		OrderByComparator<EventAttributes> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the event attributeses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EventAttributesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of event attributeses
	 * @param end the upper bound of the range of event attributeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of event attributeses
	 */
	public static List<EventAttributes> findAll(
		int start, int end,
		OrderByComparator<EventAttributes> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Removes all the event attributeses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of event attributeses.
	 *
	 * @return the number of event attributeses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static EventAttributesPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<EventAttributesPersistence, EventAttributesPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			EventAttributesPersistence.class);

		ServiceTracker<EventAttributesPersistence, EventAttributesPersistence>
			serviceTracker =
				new ServiceTracker
					<EventAttributesPersistence, EventAttributesPersistence>(
						bundle.getBundleContext(),
						EventAttributesPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}