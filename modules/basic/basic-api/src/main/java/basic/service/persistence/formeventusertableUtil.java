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

import basic.model.formeventusertable;

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
 * The persistence utility for the formeventusertable service. This utility wraps <code>basic.service.persistence.impl.formeventusertablePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see formeventusertablePersistence
 * @generated
 */
@ProviderType
public class formeventusertableUtil {

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
	public static void clearCache(formeventusertable formeventusertable) {
		getPersistence().clearCache(formeventusertable);
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
	public static Map<Serializable, formeventusertable> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<formeventusertable> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<formeventusertable> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<formeventusertable> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<formeventusertable> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static formeventusertable update(
		formeventusertable formeventusertable) {

		return getPersistence().update(formeventusertable);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static formeventusertable update(
		formeventusertable formeventusertable, ServiceContext serviceContext) {

		return getPersistence().update(formeventusertable, serviceContext);
	}

	/**
	 * Returns all the formeventusertables where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching formeventusertables
	 */
	public static List<formeventusertable> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
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
	public static List<formeventusertable> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
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
	public static List<formeventusertable> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<formeventusertable> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
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
	public static List<formeventusertable> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<formeventusertable> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns the first formeventusertable in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching formeventusertable
	 * @throws NoSuchformeventusertableException if a matching formeventusertable could not be found
	 */
	public static formeventusertable findByUuid_First(
			String uuid,
			OrderByComparator<formeventusertable> orderByComparator)
		throws basic.exception.NoSuchformeventusertableException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first formeventusertable in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching formeventusertable, or <code>null</code> if a matching formeventusertable could not be found
	 */
	public static formeventusertable fetchByUuid_First(
		String uuid, OrderByComparator<formeventusertable> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last formeventusertable in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching formeventusertable
	 * @throws NoSuchformeventusertableException if a matching formeventusertable could not be found
	 */
	public static formeventusertable findByUuid_Last(
			String uuid,
			OrderByComparator<formeventusertable> orderByComparator)
		throws basic.exception.NoSuchformeventusertableException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last formeventusertable in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching formeventusertable, or <code>null</code> if a matching formeventusertable could not be found
	 */
	public static formeventusertable fetchByUuid_Last(
		String uuid, OrderByComparator<formeventusertable> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
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
	public static formeventusertable[] findByUuid_PrevAndNext(
			long ID, String uuid,
			OrderByComparator<formeventusertable> orderByComparator)
		throws basic.exception.NoSuchformeventusertableException {

		return getPersistence().findByUuid_PrevAndNext(
			ID, uuid, orderByComparator);
	}

	/**
	 * Removes all the formeventusertables where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of formeventusertables where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching formeventusertables
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Caches the formeventusertable in the entity cache if it is enabled.
	 *
	 * @param formeventusertable the formeventusertable
	 */
	public static void cacheResult(formeventusertable formeventusertable) {
		getPersistence().cacheResult(formeventusertable);
	}

	/**
	 * Caches the formeventusertables in the entity cache if it is enabled.
	 *
	 * @param formeventusertables the formeventusertables
	 */
	public static void cacheResult(
		List<formeventusertable> formeventusertables) {

		getPersistence().cacheResult(formeventusertables);
	}

	/**
	 * Creates a new formeventusertable with the primary key. Does not add the formeventusertable to the database.
	 *
	 * @param ID the primary key for the new formeventusertable
	 * @return the new formeventusertable
	 */
	public static formeventusertable create(long ID) {
		return getPersistence().create(ID);
	}

	/**
	 * Removes the formeventusertable with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ID the primary key of the formeventusertable
	 * @return the formeventusertable that was removed
	 * @throws NoSuchformeventusertableException if a formeventusertable with the primary key could not be found
	 */
	public static formeventusertable remove(long ID)
		throws basic.exception.NoSuchformeventusertableException {

		return getPersistence().remove(ID);
	}

	public static formeventusertable updateImpl(
		formeventusertable formeventusertable) {

		return getPersistence().updateImpl(formeventusertable);
	}

	/**
	 * Returns the formeventusertable with the primary key or throws a <code>NoSuchformeventusertableException</code> if it could not be found.
	 *
	 * @param ID the primary key of the formeventusertable
	 * @return the formeventusertable
	 * @throws NoSuchformeventusertableException if a formeventusertable with the primary key could not be found
	 */
	public static formeventusertable findByPrimaryKey(long ID)
		throws basic.exception.NoSuchformeventusertableException {

		return getPersistence().findByPrimaryKey(ID);
	}

	/**
	 * Returns the formeventusertable with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ID the primary key of the formeventusertable
	 * @return the formeventusertable, or <code>null</code> if a formeventusertable with the primary key could not be found
	 */
	public static formeventusertable fetchByPrimaryKey(long ID) {
		return getPersistence().fetchByPrimaryKey(ID);
	}

	/**
	 * Returns all the formeventusertables.
	 *
	 * @return the formeventusertables
	 */
	public static List<formeventusertable> findAll() {
		return getPersistence().findAll();
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
	public static List<formeventusertable> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<formeventusertable> findAll(
		int start, int end,
		OrderByComparator<formeventusertable> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
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
	public static List<formeventusertable> findAll(
		int start, int end,
		OrderByComparator<formeventusertable> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Removes all the formeventusertables from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of formeventusertables.
	 *
	 * @return the number of formeventusertables
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static formeventusertablePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<formeventusertablePersistence, formeventusertablePersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			formeventusertablePersistence.class);

		ServiceTracker
			<formeventusertablePersistence, formeventusertablePersistence>
				serviceTracker =
					new ServiceTracker
						<formeventusertablePersistence,
						 formeventusertablePersistence>(
							 bundle.getBundleContext(),
							 formeventusertablePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}