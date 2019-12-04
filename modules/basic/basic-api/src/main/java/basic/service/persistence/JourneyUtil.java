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

import basic.model.Journey;

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
 * The persistence utility for the journey service. This utility wraps <code>basic.service.persistence.impl.JourneyPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see JourneyPersistence
 * @generated
 */
@ProviderType
public class JourneyUtil {

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
	public static void clearCache(Journey journey) {
		getPersistence().clearCache(journey);
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
	public static Map<Serializable, Journey> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Journey> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Journey> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Journey> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Journey> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Journey update(Journey journey) {
		return getPersistence().update(journey);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Journey update(
		Journey journey, ServiceContext serviceContext) {

		return getPersistence().update(journey, serviceContext);
	}

	/**
	 * Caches the journey in the entity cache if it is enabled.
	 *
	 * @param journey the journey
	 */
	public static void cacheResult(Journey journey) {
		getPersistence().cacheResult(journey);
	}

	/**
	 * Caches the journeies in the entity cache if it is enabled.
	 *
	 * @param journeies the journeies
	 */
	public static void cacheResult(List<Journey> journeies) {
		getPersistence().cacheResult(journeies);
	}

	/**
	 * Creates a new journey with the primary key. Does not add the journey to the database.
	 *
	 * @param journeyId the primary key for the new journey
	 * @return the new journey
	 */
	public static Journey create(long journeyId) {
		return getPersistence().create(journeyId);
	}

	/**
	 * Removes the journey with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param journeyId the primary key of the journey
	 * @return the journey that was removed
	 * @throws NoSuchJourneyException if a journey with the primary key could not be found
	 */
	public static Journey remove(long journeyId)
		throws basic.exception.NoSuchJourneyException {

		return getPersistence().remove(journeyId);
	}

	public static Journey updateImpl(Journey journey) {
		return getPersistence().updateImpl(journey);
	}

	/**
	 * Returns the journey with the primary key or throws a <code>NoSuchJourneyException</code> if it could not be found.
	 *
	 * @param journeyId the primary key of the journey
	 * @return the journey
	 * @throws NoSuchJourneyException if a journey with the primary key could not be found
	 */
	public static Journey findByPrimaryKey(long journeyId)
		throws basic.exception.NoSuchJourneyException {

		return getPersistence().findByPrimaryKey(journeyId);
	}

	/**
	 * Returns the journey with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param journeyId the primary key of the journey
	 * @return the journey, or <code>null</code> if a journey with the primary key could not be found
	 */
	public static Journey fetchByPrimaryKey(long journeyId) {
		return getPersistence().fetchByPrimaryKey(journeyId);
	}

	/**
	 * Returns all the journeies.
	 *
	 * @return the journeies
	 */
	public static List<Journey> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the journeies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JourneyModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of journeies
	 * @param end the upper bound of the range of journeies (not inclusive)
	 * @return the range of journeies
	 */
	public static List<Journey> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the journeies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JourneyModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of journeies
	 * @param end the upper bound of the range of journeies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of journeies
	 */
	@Deprecated
	public static List<Journey> findAll(
		int start, int end, OrderByComparator<Journey> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the journeies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JourneyModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of journeies
	 * @param end the upper bound of the range of journeies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of journeies
	 */
	public static List<Journey> findAll(
		int start, int end, OrderByComparator<Journey> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Removes all the journeies from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of journeies.
	 *
	 * @return the number of journeies
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static JourneyPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<JourneyPersistence, JourneyPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(JourneyPersistence.class);

		ServiceTracker<JourneyPersistence, JourneyPersistence> serviceTracker =
			new ServiceTracker<JourneyPersistence, JourneyPersistence>(
				bundle.getBundleContext(), JourneyPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}