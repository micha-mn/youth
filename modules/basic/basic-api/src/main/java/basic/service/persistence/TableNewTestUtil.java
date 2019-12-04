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

import basic.model.TableNewTest;

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
 * The persistence utility for the table new test service. This utility wraps <code>basic.service.persistence.impl.TableNewTestPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TableNewTestPersistence
 * @generated
 */
@ProviderType
public class TableNewTestUtil {

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
	public static void clearCache(TableNewTest tableNewTest) {
		getPersistence().clearCache(tableNewTest);
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
	public static Map<Serializable, TableNewTest> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<TableNewTest> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TableNewTest> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TableNewTest> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TableNewTest> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TableNewTest update(TableNewTest tableNewTest) {
		return getPersistence().update(tableNewTest);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TableNewTest update(
		TableNewTest tableNewTest, ServiceContext serviceContext) {

		return getPersistence().update(tableNewTest, serviceContext);
	}

	/**
	 * Returns all the table new tests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching table new tests
	 */
	public static List<TableNewTest> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the table new tests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TableNewTestModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of table new tests
	 * @param end the upper bound of the range of table new tests (not inclusive)
	 * @return the range of matching table new tests
	 */
	public static List<TableNewTest> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the table new tests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TableNewTestModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByUuid(String, int, int, OrderByComparator)}
	 * @param uuid the uuid
	 * @param start the lower bound of the range of table new tests
	 * @param end the upper bound of the range of table new tests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching table new tests
	 */
	@Deprecated
	public static List<TableNewTest> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TableNewTest> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the table new tests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TableNewTestModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of table new tests
	 * @param end the upper bound of the range of table new tests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching table new tests
	 */
	public static List<TableNewTest> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TableNewTest> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns the first table new test in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table new test
	 * @throws NoSuchTableNewTestException if a matching table new test could not be found
	 */
	public static TableNewTest findByUuid_First(
			String uuid, OrderByComparator<TableNewTest> orderByComparator)
		throws basic.exception.NoSuchTableNewTestException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first table new test in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table new test, or <code>null</code> if a matching table new test could not be found
	 */
	public static TableNewTest fetchByUuid_First(
		String uuid, OrderByComparator<TableNewTest> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last table new test in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table new test
	 * @throws NoSuchTableNewTestException if a matching table new test could not be found
	 */
	public static TableNewTest findByUuid_Last(
			String uuid, OrderByComparator<TableNewTest> orderByComparator)
		throws basic.exception.NoSuchTableNewTestException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last table new test in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table new test, or <code>null</code> if a matching table new test could not be found
	 */
	public static TableNewTest fetchByUuid_Last(
		String uuid, OrderByComparator<TableNewTest> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the table new tests before and after the current table new test in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current table new test
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next table new test
	 * @throws NoSuchTableNewTestException if a table new test with the primary key could not be found
	 */
	public static TableNewTest[] findByUuid_PrevAndNext(
			long id, String uuid,
			OrderByComparator<TableNewTest> orderByComparator)
		throws basic.exception.NoSuchTableNewTestException {

		return getPersistence().findByUuid_PrevAndNext(
			id, uuid, orderByComparator);
	}

	/**
	 * Removes all the table new tests where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of table new tests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching table new tests
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Caches the table new test in the entity cache if it is enabled.
	 *
	 * @param tableNewTest the table new test
	 */
	public static void cacheResult(TableNewTest tableNewTest) {
		getPersistence().cacheResult(tableNewTest);
	}

	/**
	 * Caches the table new tests in the entity cache if it is enabled.
	 *
	 * @param tableNewTests the table new tests
	 */
	public static void cacheResult(List<TableNewTest> tableNewTests) {
		getPersistence().cacheResult(tableNewTests);
	}

	/**
	 * Creates a new table new test with the primary key. Does not add the table new test to the database.
	 *
	 * @param id the primary key for the new table new test
	 * @return the new table new test
	 */
	public static TableNewTest create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the table new test with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the table new test
	 * @return the table new test that was removed
	 * @throws NoSuchTableNewTestException if a table new test with the primary key could not be found
	 */
	public static TableNewTest remove(long id)
		throws basic.exception.NoSuchTableNewTestException {

		return getPersistence().remove(id);
	}

	public static TableNewTest updateImpl(TableNewTest tableNewTest) {
		return getPersistence().updateImpl(tableNewTest);
	}

	/**
	 * Returns the table new test with the primary key or throws a <code>NoSuchTableNewTestException</code> if it could not be found.
	 *
	 * @param id the primary key of the table new test
	 * @return the table new test
	 * @throws NoSuchTableNewTestException if a table new test with the primary key could not be found
	 */
	public static TableNewTest findByPrimaryKey(long id)
		throws basic.exception.NoSuchTableNewTestException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the table new test with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the table new test
	 * @return the table new test, or <code>null</code> if a table new test with the primary key could not be found
	 */
	public static TableNewTest fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the table new tests.
	 *
	 * @return the table new tests
	 */
	public static List<TableNewTest> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the table new tests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TableNewTestModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of table new tests
	 * @param end the upper bound of the range of table new tests (not inclusive)
	 * @return the range of table new tests
	 */
	public static List<TableNewTest> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the table new tests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TableNewTestModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of table new tests
	 * @param end the upper bound of the range of table new tests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of table new tests
	 */
	@Deprecated
	public static List<TableNewTest> findAll(
		int start, int end, OrderByComparator<TableNewTest> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the table new tests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TableNewTestModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of table new tests
	 * @param end the upper bound of the range of table new tests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of table new tests
	 */
	public static List<TableNewTest> findAll(
		int start, int end, OrderByComparator<TableNewTest> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Removes all the table new tests from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of table new tests.
	 *
	 * @return the number of table new tests
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TableNewTestPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<TableNewTestPersistence, TableNewTestPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(TableNewTestPersistence.class);

		ServiceTracker<TableNewTestPersistence, TableNewTestPersistence>
			serviceTracker =
				new ServiceTracker
					<TableNewTestPersistence, TableNewTestPersistence>(
						bundle.getBundleContext(),
						TableNewTestPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}