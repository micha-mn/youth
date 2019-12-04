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
 * Provides the local service utility for ImageCalendar. This utility wraps
 * <code>basic.service.impl.ImageCalendarLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ImageCalendarLocalService
 * @generated
 */
@ProviderType
public class ImageCalendarLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>basic.service.impl.ImageCalendarLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the image calendar to the database. Also notifies the appropriate model listeners.
	 *
	 * @param imageCalendar the image calendar
	 * @return the image calendar that was added
	 */
	public static basic.model.ImageCalendar addImageCalendar(
		basic.model.ImageCalendar imageCalendar) {

		return getService().addImageCalendar(imageCalendar);
	}

	/**
	 * Creates a new image calendar with the primary key. Does not add the image calendar to the database.
	 *
	 * @param Id the primary key for the new image calendar
	 * @return the new image calendar
	 */
	public static basic.model.ImageCalendar createImageCalendar(long Id) {
		return getService().createImageCalendar(Id);
	}

	/**
	 * Deletes the image calendar from the database. Also notifies the appropriate model listeners.
	 *
	 * @param imageCalendar the image calendar
	 * @return the image calendar that was removed
	 */
	public static basic.model.ImageCalendar deleteImageCalendar(
		basic.model.ImageCalendar imageCalendar) {

		return getService().deleteImageCalendar(imageCalendar);
	}

	/**
	 * Deletes the image calendar with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param Id the primary key of the image calendar
	 * @return the image calendar that was removed
	 * @throws PortalException if a image calendar with the primary key could not be found
	 */
	public static basic.model.ImageCalendar deleteImageCalendar(long Id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteImageCalendar(Id);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>basic.model.impl.ImageCalendarModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>basic.model.impl.ImageCalendarModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static basic.model.ImageCalendar fetchImageCalendar(long Id) {
		return getService().fetchImageCalendar(Id);
	}

	/**
	 * Returns the image calendar matching the UUID and group.
	 *
	 * @param uuid the image calendar's UUID
	 * @param groupId the primary key of the group
	 * @return the matching image calendar, or <code>null</code> if a matching image calendar could not be found
	 */
	public static basic.model.ImageCalendar fetchImageCalendarByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchImageCalendarByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static basic.model.ImageCalendarDataBlobModel getDataBlobModel(
		java.io.Serializable primaryKey) {

		return getService().getDataBlobModel(primaryKey);
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	/**
	 * Returns the image calendar with the primary key.
	 *
	 * @param Id the primary key of the image calendar
	 * @return the image calendar
	 * @throws PortalException if a image calendar with the primary key could not be found
	 */
	public static basic.model.ImageCalendar getImageCalendar(long Id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getImageCalendar(Id);
	}

	/**
	 * Returns the image calendar matching the UUID and group.
	 *
	 * @param uuid the image calendar's UUID
	 * @param groupId the primary key of the group
	 * @return the matching image calendar
	 * @throws PortalException if a matching image calendar could not be found
	 */
	public static basic.model.ImageCalendar getImageCalendarByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getImageCalendarByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the image calendars.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>basic.model.impl.ImageCalendarModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of image calendars
	 * @param end the upper bound of the range of image calendars (not inclusive)
	 * @return the range of image calendars
	 */
	public static java.util.List<basic.model.ImageCalendar> getImageCalendars(
		int start, int end) {

		return getService().getImageCalendars(start, end);
	}

	/**
	 * Returns all the image calendars matching the UUID and company.
	 *
	 * @param uuid the UUID of the image calendars
	 * @param companyId the primary key of the company
	 * @return the matching image calendars, or an empty list if no matches were found
	 */
	public static java.util.List<basic.model.ImageCalendar>
		getImageCalendarsByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getImageCalendarsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of image calendars matching the UUID and company.
	 *
	 * @param uuid the UUID of the image calendars
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of image calendars
	 * @param end the upper bound of the range of image calendars (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching image calendars, or an empty list if no matches were found
	 */
	public static java.util.List<basic.model.ImageCalendar>
		getImageCalendarsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<basic.model.ImageCalendar> orderByComparator) {

		return getService().getImageCalendarsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of image calendars.
	 *
	 * @return the number of image calendars
	 */
	public static int getImageCalendarsCount() {
		return getService().getImageCalendarsCount();
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
	 * Updates the image calendar in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param imageCalendar the image calendar
	 * @return the image calendar that was updated
	 */
	public static basic.model.ImageCalendar updateImageCalendar(
		basic.model.ImageCalendar imageCalendar) {

		return getService().updateImageCalendar(imageCalendar);
	}

	public static ImageCalendarLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<ImageCalendarLocalService, ImageCalendarLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			ImageCalendarLocalService.class);

		ServiceTracker<ImageCalendarLocalService, ImageCalendarLocalService>
			serviceTracker =
				new ServiceTracker
					<ImageCalendarLocalService, ImageCalendarLocalService>(
						bundle.getBundleContext(),
						ImageCalendarLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}