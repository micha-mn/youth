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
 * Provides the local service utility for RegisterEvent. This utility wraps
 * <code>basic.service.impl.RegisterEventLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see RegisterEventLocalService
 * @generated
 */
@ProviderType
public class RegisterEventLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>basic.service.impl.RegisterEventLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the register event to the database. Also notifies the appropriate model listeners.
	 *
	 * @param registerEvent the register event
	 * @return the register event that was added
	 */
	public static basic.model.RegisterEvent addRegisterEvent(
		basic.model.RegisterEvent registerEvent) {

		return getService().addRegisterEvent(registerEvent);
	}

	/**
	 * Creates a new register event with the primary key. Does not add the register event to the database.
	 *
	 * @param Id the primary key for the new register event
	 * @return the new register event
	 */
	public static basic.model.RegisterEvent createRegisterEvent(long Id) {
		return getService().createRegisterEvent(Id);
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

	/**
	 * Deletes the register event with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param Id the primary key of the register event
	 * @return the register event that was removed
	 * @throws PortalException if a register event with the primary key could not be found
	 */
	public static basic.model.RegisterEvent deleteRegisterEvent(long Id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteRegisterEvent(Id);
	}

	/**
	 * Deletes the register event from the database. Also notifies the appropriate model listeners.
	 *
	 * @param registerEvent the register event
	 * @return the register event that was removed
	 */
	public static basic.model.RegisterEvent deleteRegisterEvent(
		basic.model.RegisterEvent registerEvent) {

		return getService().deleteRegisterEvent(registerEvent);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>basic.model.impl.RegisterEventModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>basic.model.impl.RegisterEventModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static basic.model.RegisterEvent fetchRegisterEvent(long Id) {
		return getService().fetchRegisterEvent(Id);
	}

	/**
	 * Returns the register event matching the UUID and group.
	 *
	 * @param uuid the register event's UUID
	 * @param groupId the primary key of the group
	 * @return the matching register event, or <code>null</code> if a matching register event could not be found
	 */
	public static basic.model.RegisterEvent fetchRegisterEventByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchRegisterEventByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
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
	 * Returns the register event with the primary key.
	 *
	 * @param Id the primary key of the register event
	 * @return the register event
	 * @throws PortalException if a register event with the primary key could not be found
	 */
	public static basic.model.RegisterEvent getRegisterEvent(long Id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getRegisterEvent(Id);
	}

	/**
	 * Returns the register event matching the UUID and group.
	 *
	 * @param uuid the register event's UUID
	 * @param groupId the primary key of the group
	 * @return the matching register event
	 * @throws PortalException if a matching register event could not be found
	 */
	public static basic.model.RegisterEvent getRegisterEventByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getRegisterEventByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the register events.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>basic.model.impl.RegisterEventModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of register events
	 * @param end the upper bound of the range of register events (not inclusive)
	 * @return the range of register events
	 */
	public static java.util.List<basic.model.RegisterEvent> getRegisterEvents(
		int start, int end) {

		return getService().getRegisterEvents(start, end);
	}

	/**
	 * Returns all the register events matching the UUID and company.
	 *
	 * @param uuid the UUID of the register events
	 * @param companyId the primary key of the company
	 * @return the matching register events, or an empty list if no matches were found
	 */
	public static java.util.List<basic.model.RegisterEvent>
		getRegisterEventsByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getRegisterEventsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of register events matching the UUID and company.
	 *
	 * @param uuid the UUID of the register events
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of register events
	 * @param end the upper bound of the range of register events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching register events, or an empty list if no matches were found
	 */
	public static java.util.List<basic.model.RegisterEvent>
		getRegisterEventsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<basic.model.RegisterEvent> orderByComparator) {

		return getService().getRegisterEventsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of register events.
	 *
	 * @return the number of register events
	 */
	public static int getRegisterEventsCount() {
		return getService().getRegisterEventsCount();
	}

	/**
	 * Updates the register event in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param registerEvent the register event
	 * @return the register event that was updated
	 */
	public static basic.model.RegisterEvent updateRegisterEvent(
		basic.model.RegisterEvent registerEvent) {

		return getService().updateRegisterEvent(registerEvent);
	}

	public static RegisterEventLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<RegisterEventLocalService, RegisterEventLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			RegisterEventLocalService.class);

		ServiceTracker<RegisterEventLocalService, RegisterEventLocalService>
			serviceTracker =
				new ServiceTracker
					<RegisterEventLocalService, RegisterEventLocalService>(
						bundle.getBundleContext(),
						RegisterEventLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}