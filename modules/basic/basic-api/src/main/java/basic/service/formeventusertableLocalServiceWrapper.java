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
 * Provides a wrapper for {@link formeventusertableLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see formeventusertableLocalService
 * @generated
 */
@ProviderType
public class formeventusertableLocalServiceWrapper
	implements formeventusertableLocalService,
			   ServiceWrapper<formeventusertableLocalService> {

	public formeventusertableLocalServiceWrapper(
		formeventusertableLocalService formeventusertableLocalService) {

		_formeventusertableLocalService = formeventusertableLocalService;
	}

	/**
	 * Adds the formeventusertable to the database. Also notifies the appropriate model listeners.
	 *
	 * @param formeventusertable the formeventusertable
	 * @return the formeventusertable that was added
	 */
	@Override
	public basic.model.formeventusertable addformeventusertable(
		basic.model.formeventusertable formeventusertable) {

		return _formeventusertableLocalService.addformeventusertable(
			formeventusertable);
	}

	/**
	 * Creates a new formeventusertable with the primary key. Does not add the formeventusertable to the database.
	 *
	 * @param ID the primary key for the new formeventusertable
	 * @return the new formeventusertable
	 */
	@Override
	public basic.model.formeventusertable createformeventusertable(long ID) {
		return _formeventusertableLocalService.createformeventusertable(ID);
	}

	/**
	 * Deletes the formeventusertable from the database. Also notifies the appropriate model listeners.
	 *
	 * @param formeventusertable the formeventusertable
	 * @return the formeventusertable that was removed
	 */
	@Override
	public basic.model.formeventusertable deleteformeventusertable(
		basic.model.formeventusertable formeventusertable) {

		return _formeventusertableLocalService.deleteformeventusertable(
			formeventusertable);
	}

	/**
	 * Deletes the formeventusertable with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ID the primary key of the formeventusertable
	 * @return the formeventusertable that was removed
	 * @throws PortalException if a formeventusertable with the primary key could not be found
	 */
	@Override
	public basic.model.formeventusertable deleteformeventusertable(long ID)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _formeventusertableLocalService.deleteformeventusertable(ID);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _formeventusertableLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _formeventusertableLocalService.dynamicQuery();
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

		return _formeventusertableLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>basic.model.impl.formeventusertableModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _formeventusertableLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>basic.model.impl.formeventusertableModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _formeventusertableLocalService.dynamicQuery(
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

		return _formeventusertableLocalService.dynamicQueryCount(dynamicQuery);
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

		return _formeventusertableLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public basic.model.formeventusertable fetchformeventusertable(long ID) {
		return _formeventusertableLocalService.fetchformeventusertable(ID);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _formeventusertableLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the formeventusertable with the primary key.
	 *
	 * @param ID the primary key of the formeventusertable
	 * @return the formeventusertable
	 * @throws PortalException if a formeventusertable with the primary key could not be found
	 */
	@Override
	public basic.model.formeventusertable getformeventusertable(long ID)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _formeventusertableLocalService.getformeventusertable(ID);
	}

	/**
	 * Returns a range of all the formeventusertables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>basic.model.impl.formeventusertableModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of formeventusertables
	 * @param end the upper bound of the range of formeventusertables (not inclusive)
	 * @return the range of formeventusertables
	 */
	@Override
	public java.util.List<basic.model.formeventusertable>
		getformeventusertables(int start, int end) {

		return _formeventusertableLocalService.getformeventusertables(
			start, end);
	}

	/**
	 * Returns the number of formeventusertables.
	 *
	 * @return the number of formeventusertables
	 */
	@Override
	public int getformeventusertablesCount() {
		return _formeventusertableLocalService.getformeventusertablesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _formeventusertableLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _formeventusertableLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _formeventusertableLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the formeventusertable in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param formeventusertable the formeventusertable
	 * @return the formeventusertable that was updated
	 */
	@Override
	public basic.model.formeventusertable updateformeventusertable(
		basic.model.formeventusertable formeventusertable) {

		return _formeventusertableLocalService.updateformeventusertable(
			formeventusertable);
	}

	@Override
	public formeventusertableLocalService getWrappedService() {
		return _formeventusertableLocalService;
	}

	@Override
	public void setWrappedService(
		formeventusertableLocalService formeventusertableLocalService) {

		_formeventusertableLocalService = formeventusertableLocalService;
	}

	private formeventusertableLocalService _formeventusertableLocalService;

}