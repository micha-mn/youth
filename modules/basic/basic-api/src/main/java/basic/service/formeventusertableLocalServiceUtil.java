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

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for formeventusertable. This utility wraps
 * <code>basic.service.impl.formeventusertableLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see formeventusertableLocalService
 * @generated
 */
@ProviderType
public class formeventusertableLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>basic.service.impl.formeventusertableLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the formeventusertable to the database. Also notifies the appropriate model listeners.
	 *
	 * @param formeventusertable the formeventusertable
	 * @return the formeventusertable that was added
	 */
	public static basic.model.formeventusertable addformeventusertable(
		basic.model.formeventusertable formeventusertable) {

		return getService().addformeventusertable(formeventusertable);
	}

	/**
	 * Creates a new formeventusertable with the primary key. Does not add the formeventusertable to the database.
	 *
	 * @param ID the primary key for the new formeventusertable
	 * @return the new formeventusertable
	 */
	public static basic.model.formeventusertable createformeventusertable(
		long ID) {

		return getService().createformeventusertable(ID);
	}

	/**
	 * Deletes the formeventusertable from the database. Also notifies the appropriate model listeners.
	 *
	 * @param formeventusertable the formeventusertable
	 * @return the formeventusertable that was removed
	 */
	public static basic.model.formeventusertable deleteformeventusertable(
		basic.model.formeventusertable formeventusertable) {

		return getService().deleteformeventusertable(formeventusertable);
	}

	/**
	 * Deletes the formeventusertable with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ID the primary key of the formeventusertable
	 * @return the formeventusertable that was removed
	 * @throws PortalException if a formeventusertable with the primary key could not be found
	 */
	public static basic.model.formeventusertable deleteformeventusertable(
			long ID)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteformeventusertable(ID);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static basic.model.formeventusertable fetchformeventusertable(
		long ID) {

		return getService().fetchformeventusertable(ID);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the formeventusertable with the primary key.
	 *
	 * @param ID the primary key of the formeventusertable
	 * @return the formeventusertable
	 * @throws PortalException if a formeventusertable with the primary key could not be found
	 */
	public static basic.model.formeventusertable getformeventusertable(long ID)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getformeventusertable(ID);
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
	public static java.util.List<basic.model.formeventusertable>
		getformeventusertables(int start, int end) {

		return getService().getformeventusertables(start, end);
	}

	/**
	 * Returns the number of formeventusertables.
	 *
	 * @return the number of formeventusertables
	 */
	public static int getformeventusertablesCount() {
		return getService().getformeventusertablesCount();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the formeventusertable in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param formeventusertable the formeventusertable
	 * @return the formeventusertable that was updated
	 */
	public static basic.model.formeventusertable updateformeventusertable(
		basic.model.formeventusertable formeventusertable) {

		return getService().updateformeventusertable(formeventusertable);
	}

	public static formeventusertableLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<formeventusertableLocalService, formeventusertableLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			formeventusertableLocalService.class);

		ServiceTracker
			<formeventusertableLocalService, formeventusertableLocalService>
				serviceTracker =
					new ServiceTracker
						<formeventusertableLocalService,
						 formeventusertableLocalService>(
							 bundle.getBundleContext(),
							 formeventusertableLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}