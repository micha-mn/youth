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
 * Provides the local service utility for ProfileJobWishList. This utility wraps
 * <code>basic.service.impl.ProfileJobWishListLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ProfileJobWishListLocalService
 * @generated
 */
@ProviderType
public class ProfileJobWishListLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>basic.service.impl.ProfileJobWishListLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the profile job wish list to the database. Also notifies the appropriate model listeners.
	 *
	 * @param profileJobWishList the profile job wish list
	 * @return the profile job wish list that was added
	 */
	public static basic.model.ProfileJobWishList addProfileJobWishList(
		basic.model.ProfileJobWishList profileJobWishList) {

		return getService().addProfileJobWishList(profileJobWishList);
	}

	/**
	 * Creates a new profile job wish list with the primary key. Does not add the profile job wish list to the database.
	 *
	 * @param Id the primary key for the new profile job wish list
	 * @return the new profile job wish list
	 */
	public static basic.model.ProfileJobWishList createProfileJobWishList(
		long Id) {

		return getService().createProfileJobWishList(Id);
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
	 * Deletes the profile job wish list with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param Id the primary key of the profile job wish list
	 * @return the profile job wish list that was removed
	 * @throws PortalException if a profile job wish list with the primary key could not be found
	 */
	public static basic.model.ProfileJobWishList deleteProfileJobWishList(
			long Id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteProfileJobWishList(Id);
	}

	/**
	 * Deletes the profile job wish list from the database. Also notifies the appropriate model listeners.
	 *
	 * @param profileJobWishList the profile job wish list
	 * @return the profile job wish list that was removed
	 */
	public static basic.model.ProfileJobWishList deleteProfileJobWishList(
		basic.model.ProfileJobWishList profileJobWishList) {

		return getService().deleteProfileJobWishList(profileJobWishList);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>basic.model.impl.ProfileJobWishListModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>basic.model.impl.ProfileJobWishListModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static basic.model.ProfileJobWishList fetchProfileJobWishList(
		long Id) {

		return getService().fetchProfileJobWishList(Id);
	}

	/**
	 * Returns the profile job wish list matching the UUID and group.
	 *
	 * @param uuid the profile job wish list's UUID
	 * @param groupId the primary key of the group
	 * @return the matching profile job wish list, or <code>null</code> if a matching profile job wish list could not be found
	 */
	public static basic.model.ProfileJobWishList
		fetchProfileJobWishListByUuidAndGroupId(String uuid, long groupId) {

		return getService().fetchProfileJobWishListByUuidAndGroupId(
			uuid, groupId);
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
	 * Returns the profile job wish list with the primary key.
	 *
	 * @param Id the primary key of the profile job wish list
	 * @return the profile job wish list
	 * @throws PortalException if a profile job wish list with the primary key could not be found
	 */
	public static basic.model.ProfileJobWishList getProfileJobWishList(long Id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getProfileJobWishList(Id);
	}

	/**
	 * Returns the profile job wish list matching the UUID and group.
	 *
	 * @param uuid the profile job wish list's UUID
	 * @param groupId the primary key of the group
	 * @return the matching profile job wish list
	 * @throws PortalException if a matching profile job wish list could not be found
	 */
	public static basic.model.ProfileJobWishList
			getProfileJobWishListByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getProfileJobWishListByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the profile job wish lists.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>basic.model.impl.ProfileJobWishListModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of profile job wish lists
	 * @param end the upper bound of the range of profile job wish lists (not inclusive)
	 * @return the range of profile job wish lists
	 */
	public static java.util.List<basic.model.ProfileJobWishList>
		getProfileJobWishLists(int start, int end) {

		return getService().getProfileJobWishLists(start, end);
	}

	/**
	 * Returns all the profile job wish lists matching the UUID and company.
	 *
	 * @param uuid the UUID of the profile job wish lists
	 * @param companyId the primary key of the company
	 * @return the matching profile job wish lists, or an empty list if no matches were found
	 */
	public static java.util.List<basic.model.ProfileJobWishList>
		getProfileJobWishListsByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getProfileJobWishListsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of profile job wish lists matching the UUID and company.
	 *
	 * @param uuid the UUID of the profile job wish lists
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of profile job wish lists
	 * @param end the upper bound of the range of profile job wish lists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching profile job wish lists, or an empty list if no matches were found
	 */
	public static java.util.List<basic.model.ProfileJobWishList>
		getProfileJobWishListsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<basic.model.ProfileJobWishList> orderByComparator) {

		return getService().getProfileJobWishListsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of profile job wish lists.
	 *
	 * @return the number of profile job wish lists
	 */
	public static int getProfileJobWishListsCount() {
		return getService().getProfileJobWishListsCount();
	}

	/**
	 * Updates the profile job wish list in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param profileJobWishList the profile job wish list
	 * @return the profile job wish list that was updated
	 */
	public static basic.model.ProfileJobWishList updateProfileJobWishList(
		basic.model.ProfileJobWishList profileJobWishList) {

		return getService().updateProfileJobWishList(profileJobWishList);
	}

	public static ProfileJobWishListLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<ProfileJobWishListLocalService, ProfileJobWishListLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			ProfileJobWishListLocalService.class);

		ServiceTracker
			<ProfileJobWishListLocalService, ProfileJobWishListLocalService>
				serviceTracker =
					new ServiceTracker
						<ProfileJobWishListLocalService,
						 ProfileJobWishListLocalService>(
							 bundle.getBundleContext(),
							 ProfileJobWishListLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}