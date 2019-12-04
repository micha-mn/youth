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
 * Provides the local service utility for EventHighLights. This utility wraps
 * <code>basic.service.impl.EventHighLightsLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see EventHighLightsLocalService
 * @generated
 */
@ProviderType
public class EventHighLightsLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>basic.service.impl.EventHighLightsLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the event high lights to the database. Also notifies the appropriate model listeners.
	 *
	 * @param eventHighLights the event high lights
	 * @return the event high lights that was added
	 */
	public static basic.model.EventHighLights addEventHighLights(
		basic.model.EventHighLights eventHighLights) {

		return getService().addEventHighLights(eventHighLights);
	}

	/**
	 * Creates a new event high lights with the primary key. Does not add the event high lights to the database.
	 *
	 * @param id the primary key for the new event high lights
	 * @return the new event high lights
	 */
	public static basic.model.EventHighLights createEventHighLights(long id) {
		return getService().createEventHighLights(id);
	}

	/**
	 * Deletes the event high lights from the database. Also notifies the appropriate model listeners.
	 *
	 * @param eventHighLights the event high lights
	 * @return the event high lights that was removed
	 */
	public static basic.model.EventHighLights deleteEventHighLights(
		basic.model.EventHighLights eventHighLights) {

		return getService().deleteEventHighLights(eventHighLights);
	}

	/**
	 * Deletes the event high lights with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the event high lights
	 * @return the event high lights that was removed
	 * @throws PortalException if a event high lights with the primary key could not be found
	 */
	public static basic.model.EventHighLights deleteEventHighLights(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteEventHighLights(id);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>basic.model.impl.EventHighLightsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>basic.model.impl.EventHighLightsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static basic.model.EventHighLights fetchEventHighLights(long id) {
		return getService().fetchEventHighLights(id);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the event high lights with the primary key.
	 *
	 * @param id the primary key of the event high lights
	 * @return the event high lights
	 * @throws PortalException if a event high lights with the primary key could not be found
	 */
	public static basic.model.EventHighLights getEventHighLights(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getEventHighLights(id);
	}

	/**
	 * Returns a range of all the event high lightses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>basic.model.impl.EventHighLightsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of event high lightses
	 * @param end the upper bound of the range of event high lightses (not inclusive)
	 * @return the range of event high lightses
	 */
	public static java.util.List<basic.model.EventHighLights>
		getEventHighLightses(int start, int end) {

		return getService().getEventHighLightses(start, end);
	}

	/**
	 * Returns the number of event high lightses.
	 *
	 * @return the number of event high lightses
	 */
	public static int getEventHighLightsesCount() {
		return getService().getEventHighLightsesCount();
	}

	public static basic.model.EventHighLightsImageBlobModel getImageBlobModel(
		java.io.Serializable primaryKey) {

		return getService().getImageBlobModel(primaryKey);
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
	 * Updates the event high lights in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param eventHighLights the event high lights
	 * @return the event high lights that was updated
	 */
	public static basic.model.EventHighLights updateEventHighLights(
		basic.model.EventHighLights eventHighLights) {

		return getService().updateEventHighLights(eventHighLights);
	}

	public static EventHighLightsLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<EventHighLightsLocalService, EventHighLightsLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			EventHighLightsLocalService.class);

		ServiceTracker<EventHighLightsLocalService, EventHighLightsLocalService>
			serviceTracker =
				new ServiceTracker
					<EventHighLightsLocalService, EventHighLightsLocalService>(
						bundle.getBundleContext(),
						EventHighLightsLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}