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

import basic.exception.NoSuchTableNewTestException;

import basic.model.TableNewTest;

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the table new test service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TableNewTestUtil
 * @generated
 */
@ProviderType
public interface TableNewTestPersistence extends BasePersistence<TableNewTest> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TableNewTestUtil} to access the table new test persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the table new tests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching table new tests
	 */
	public java.util.List<TableNewTest> findByUuid(String uuid);

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
	public java.util.List<TableNewTest> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<TableNewTest> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TableNewTest> orderByComparator,
		boolean useFinderCache);

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
	public java.util.List<TableNewTest> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TableNewTest> orderByComparator);

	/**
	 * Returns the first table new test in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table new test
	 * @throws NoSuchTableNewTestException if a matching table new test could not be found
	 */
	public TableNewTest findByUuid_First(
			String uuid, OrderByComparator<TableNewTest> orderByComparator)
		throws NoSuchTableNewTestException;

	/**
	 * Returns the first table new test in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table new test, or <code>null</code> if a matching table new test could not be found
	 */
	public TableNewTest fetchByUuid_First(
		String uuid, OrderByComparator<TableNewTest> orderByComparator);

	/**
	 * Returns the last table new test in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table new test
	 * @throws NoSuchTableNewTestException if a matching table new test could not be found
	 */
	public TableNewTest findByUuid_Last(
			String uuid, OrderByComparator<TableNewTest> orderByComparator)
		throws NoSuchTableNewTestException;

	/**
	 * Returns the last table new test in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table new test, or <code>null</code> if a matching table new test could not be found
	 */
	public TableNewTest fetchByUuid_Last(
		String uuid, OrderByComparator<TableNewTest> orderByComparator);

	/**
	 * Returns the table new tests before and after the current table new test in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current table new test
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next table new test
	 * @throws NoSuchTableNewTestException if a table new test with the primary key could not be found
	 */
	public TableNewTest[] findByUuid_PrevAndNext(
			long id, String uuid,
			OrderByComparator<TableNewTest> orderByComparator)
		throws NoSuchTableNewTestException;

	/**
	 * Removes all the table new tests where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of table new tests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching table new tests
	 */
	public int countByUuid(String uuid);

	/**
	 * Caches the table new test in the entity cache if it is enabled.
	 *
	 * @param tableNewTest the table new test
	 */
	public void cacheResult(TableNewTest tableNewTest);

	/**
	 * Caches the table new tests in the entity cache if it is enabled.
	 *
	 * @param tableNewTests the table new tests
	 */
	public void cacheResult(java.util.List<TableNewTest> tableNewTests);

	/**
	 * Creates a new table new test with the primary key. Does not add the table new test to the database.
	 *
	 * @param id the primary key for the new table new test
	 * @return the new table new test
	 */
	public TableNewTest create(long id);

	/**
	 * Removes the table new test with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the table new test
	 * @return the table new test that was removed
	 * @throws NoSuchTableNewTestException if a table new test with the primary key could not be found
	 */
	public TableNewTest remove(long id) throws NoSuchTableNewTestException;

	public TableNewTest updateImpl(TableNewTest tableNewTest);

	/**
	 * Returns the table new test with the primary key or throws a <code>NoSuchTableNewTestException</code> if it could not be found.
	 *
	 * @param id the primary key of the table new test
	 * @return the table new test
	 * @throws NoSuchTableNewTestException if a table new test with the primary key could not be found
	 */
	public TableNewTest findByPrimaryKey(long id)
		throws NoSuchTableNewTestException;

	/**
	 * Returns the table new test with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the table new test
	 * @return the table new test, or <code>null</code> if a table new test with the primary key could not be found
	 */
	public TableNewTest fetchByPrimaryKey(long id);

	/**
	 * Returns all the table new tests.
	 *
	 * @return the table new tests
	 */
	public java.util.List<TableNewTest> findAll();

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
	public java.util.List<TableNewTest> findAll(int start, int end);

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
	public java.util.List<TableNewTest> findAll(
		int start, int end, OrderByComparator<TableNewTest> orderByComparator,
		boolean useFinderCache);

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
	public java.util.List<TableNewTest> findAll(
		int start, int end, OrderByComparator<TableNewTest> orderByComparator);

	/**
	 * Removes all the table new tests from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of table new tests.
	 *
	 * @return the number of table new tests
	 */
	public int countAll();

}