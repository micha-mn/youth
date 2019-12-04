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
 * Provides the local service utility for EventAssigneeTable. This utility wraps
 * <code>basic.service.impl.EventAssigneeTableLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see EventAssigneeTableLocalService
 * @generated
 */
@ProviderType
public class EventAssigneeTableLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>basic.service.impl.EventAssigneeTableLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the event assignee table to the database. Also notifies the appropriate model listeners.
	 *
	 * @param eventAssigneeTable the event assignee table
	 * @return the event assignee table that was added
	 */
	public static basic.model.EventAssigneeTable addEventAssigneeTable(
		basic.model.EventAssigneeTable eventAssigneeTable) {

		return getService().addEventAssigneeTable(eventAssigneeTable);
	}

	/**
	 * Creates a new event assignee table with the primary key. Does not add the event assignee table to the database.
	 *
	 * @param Id the primary key for the new event assignee table
	 * @return the new event assignee table
	 */
	public static basic.model.EventAssigneeTable createEventAssigneeTable(
		int Id) {

		return getService().createEventAssigneeTable(Id);
	}

	/**
	 * Deletes the event assignee table from the database. Also notifies the appropriate model listeners.
	 *
	 * @param eventAssigneeTable the event assignee table
	 * @return the event assignee table that was removed
	 */
	public static basic.model.EventAssigneeTable deleteEventAssigneeTable(
		basic.model.EventAssigneeTable eventAssigneeTable) {

		return getService().deleteEventAssigneeTable(eventAssigneeTable);
	}

	/**
	 * Deletes the event assignee table with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param Id the primary key of the event assignee table
	 * @return the event assignee table that was removed
	 * @throws PortalException if a event assignee table with the primary key could not be found
	 */
	public static basic.model.EventAssigneeTable deleteEventAssigneeTable(
			int Id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteEventAssigneeTable(Id);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>basic.model.impl.EventAssigneeTableModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>basic.model.impl.EventAssigneeTableModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static basic.model.EventAssigneeTable fetchEventAssigneeTable(
		int Id) {

		return getService().fetchEventAssigneeTable(Id);
	}

	/**
	 * Returns the event assignee table matching the UUID and group.
	 *
	 * @param uuid the event assignee table's UUID
	 * @param groupId the primary key of the group
	 * @return the matching event assignee table, or <code>null</code> if a matching event assignee table could not be found
	 */
	public static basic.model.EventAssigneeTable
		fetchEventAssigneeTableByUuidAndGroupId(String uuid, long groupId) {

		return getService().fetchEventAssigneeTableByUuidAndGroupId(
			uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the event assignee table with the primary key.
	 *
	 * @param Id the primary key of the event assignee table
	 * @return the event assignee table
	 * @throws PortalException if a event assignee table with the primary key could not be found
	 */
	public static basic.model.EventAssigneeTable getEventAssigneeTable(int Id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getEventAssigneeTable(Id);
	}

	/**
	 * Returns the event assignee table matching the UUID and group.
	 *
	 * @param uuid the event assignee table's UUID
	 * @param groupId the primary key of the group
	 * @return the matching event assignee table
	 * @throws PortalException if a matching event assignee table could not be found
	 */
	public static basic.model.EventAssigneeTable
			getEventAssigneeTableByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getEventAssigneeTableByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the event assignee tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>basic.model.impl.EventAssigneeTableModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of event assignee tables
	 * @param end the upper bound of the range of event assignee tables (not inclusive)
	 * @return the range of event assignee tables
	 */
	public static java.util.List<basic.model.EventAssigneeTable>
		getEventAssigneeTables(int start, int end) {

		return getService().getEventAssigneeTables(start, end);
	}

	/**
	 * Returns all the event assignee tables matching the UUID and company.
	 *
	 * @param uuid the UUID of the event assignee tables
	 * @param companyId the primary key of the company
	 * @return the matching event assignee tables, or an empty list if no matches were found
	 */
	public static java.util.List<basic.model.EventAssigneeTable>
		getEventAssigneeTablesByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getEventAssigneeTablesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of event assignee tables matching the UUID and company.
	 *
	 * @param uuid the UUID of the event assignee tables
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of event assignee tables
	 * @param end the upper bound of the range of event assignee tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching event assignee tables, or an empty list if no matches were found
	 */
	public static java.util.List<basic.model.EventAssigneeTable>
		getEventAssigneeTablesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<basic.model.EventAssigneeTable> orderByComparator) {

		return getService().getEventAssigneeTablesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of event assignee tables.
	 *
	 * @return the number of event assignee tables
	 */
	public static int getEventAssigneeTablesCount() {
		return getService().getEventAssigneeTablesCount();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
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
	 * Updates the event assignee table in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param eventAssigneeTable the event assignee table
	 * @return the event assignee table that was updated
	 */
	public static basic.model.EventAssigneeTable updateEventAssigneeTable(
		basic.model.EventAssigneeTable eventAssigneeTable) {

		return getService().updateEventAssigneeTable(eventAssigneeTable);
	}

	public static EventAssigneeTableLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<EventAssigneeTableLocalService, EventAssigneeTableLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			EventAssigneeTableLocalService.class);

		ServiceTracker
			<EventAssigneeTableLocalService, EventAssigneeTableLocalService>
				serviceTracker =
					new ServiceTracker
						<EventAssigneeTableLocalService,
						 EventAssigneeTableLocalService>(
							 bundle.getBundleContext(),
							 EventAssigneeTableLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}