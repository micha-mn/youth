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

package basic.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides a wrapper for {@link TableNewTestLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TableNewTestLocalService
 * @generated
 */
@ProviderType
public class TableNewTestLocalServiceWrapper
	implements TableNewTestLocalService,
			   ServiceWrapper<TableNewTestLocalService> {

	public TableNewTestLocalServiceWrapper(
		TableNewTestLocalService tableNewTestLocalService) {

		_tableNewTestLocalService = tableNewTestLocalService;
	}

	/**
	 * Adds the table new test to the database. Also notifies the appropriate model listeners.
	 *
	 * @param tableNewTest the table new test
	 * @return the table new test that was added
	 */
	@Override
	public basic.model.TableNewTest addTableNewTest(
		basic.model.TableNewTest tableNewTest) {

		return _tableNewTestLocalService.addTableNewTest(tableNewTest);
	}

	/**
	 * Creates a new table new test with the primary key. Does not add the table new test to the database.
	 *
	 * @param id the primary key for the new table new test
	 * @return the new table new test
	 */
	@Override
	public basic.model.TableNewTest createTableNewTest(long id) {
		return _tableNewTestLocalService.createTableNewTest(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tableNewTestLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the table new test with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the table new test
	 * @return the table new test that was removed
	 * @throws PortalException if a table new test with the primary key could not be found
	 */
	@Override
	public basic.model.TableNewTest deleteTableNewTest(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tableNewTestLocalService.deleteTableNewTest(id);
	}

	/**
	 * Deletes the table new test from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tableNewTest the table new test
	 * @return the table new test that was removed
	 */
	@Override
	public basic.model.TableNewTest deleteTableNewTest(
		basic.model.TableNewTest tableNewTest) {

		return _tableNewTestLocalService.deleteTableNewTest(tableNewTest);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _tableNewTestLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _tableNewTestLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>basic.model.impl.TableNewTestModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _tableNewTestLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>basic.model.impl.TableNewTestModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _tableNewTestLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _tableNewTestLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _tableNewTestLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public basic.model.TableNewTest fetchTableNewTest(long id) {
		return _tableNewTestLocalService.fetchTableNewTest(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _tableNewTestLocalService.getActionableDynamicQuery();
	}

	@Override
	public basic.model.TableNewTestImageBlobModel getImageBlobModel(
		java.io.Serializable primaryKey) {

		return _tableNewTestLocalService.getImageBlobModel(primaryKey);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _tableNewTestLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _tableNewTestLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tableNewTestLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the table new test with the primary key.
	 *
	 * @param id the primary key of the table new test
	 * @return the table new test
	 * @throws PortalException if a table new test with the primary key could not be found
	 */
	@Override
	public basic.model.TableNewTest getTableNewTest(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tableNewTestLocalService.getTableNewTest(id);
	}

	/**
	 * Returns a range of all the table new tests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>basic.model.impl.TableNewTestModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of table new tests
	 * @param end the upper bound of the range of table new tests (not inclusive)
	 * @return the range of table new tests
	 */
	@Override
	public java.util.List<basic.model.TableNewTest> getTableNewTests(
		int start, int end) {

		return _tableNewTestLocalService.getTableNewTests(start, end);
	}

	/**
	 * Returns the number of table new tests.
	 *
	 * @return the number of table new tests
	 */
	@Override
	public int getTableNewTestsCount() {
		return _tableNewTestLocalService.getTableNewTestsCount();
	}

	/**
	 * Updates the table new test in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param tableNewTest the table new test
	 * @return the table new test that was updated
	 */
	@Override
	public basic.model.TableNewTest updateTableNewTest(
		basic.model.TableNewTest tableNewTest) {

		return _tableNewTestLocalService.updateTableNewTest(tableNewTest);
	}

	@Override
	public TableNewTestLocalService getWrappedService() {
		return _tableNewTestLocalService;
	}

	@Override
	public void setWrappedService(
		TableNewTestLocalService tableNewTestLocalService) {

		_tableNewTestLocalService = tableNewTestLocalService;
	}

	private TableNewTestLocalService _tableNewTestLocalService;

}