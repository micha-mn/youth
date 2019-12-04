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

import basic.model.ProfileTestimonial;

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
 * The persistence utility for the profile testimonial service. This utility wraps <code>basic.service.persistence.impl.ProfileTestimonialPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProfileTestimonialPersistence
 * @generated
 */
@ProviderType
public class ProfileTestimonialUtil {

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
	public static void clearCache(ProfileTestimonial profileTestimonial) {
		getPersistence().clearCache(profileTestimonial);
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
	public static Map<Serializable, ProfileTestimonial> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ProfileTestimonial> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ProfileTestimonial> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ProfileTestimonial> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ProfileTestimonial> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ProfileTestimonial update(
		ProfileTestimonial profileTestimonial) {

		return getPersistence().update(profileTestimonial);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ProfileTestimonial update(
		ProfileTestimonial profileTestimonial, ServiceContext serviceContext) {

		return getPersistence().update(profileTestimonial, serviceContext);
	}

	/**
	 * Returns all the profile testimonials where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching profile testimonials
	 */
	public static List<ProfileTestimonial> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the profile testimonials where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ProfileTestimonialModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of profile testimonials
	 * @param end the upper bound of the range of profile testimonials (not inclusive)
	 * @return the range of matching profile testimonials
	 */
	public static List<ProfileTestimonial> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the profile testimonials where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ProfileTestimonialModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByUuid(String, int, int, OrderByComparator)}
	 * @param uuid the uuid
	 * @param start the lower bound of the range of profile testimonials
	 * @param end the upper bound of the range of profile testimonials (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching profile testimonials
	 */
	@Deprecated
	public static List<ProfileTestimonial> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProfileTestimonial> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the profile testimonials where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ProfileTestimonialModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of profile testimonials
	 * @param end the upper bound of the range of profile testimonials (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching profile testimonials
	 */
	public static List<ProfileTestimonial> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProfileTestimonial> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns the first profile testimonial in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching profile testimonial
	 * @throws NoSuchProfileTestimonialException if a matching profile testimonial could not be found
	 */
	public static ProfileTestimonial findByUuid_First(
			String uuid,
			OrderByComparator<ProfileTestimonial> orderByComparator)
		throws basic.exception.NoSuchProfileTestimonialException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first profile testimonial in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching profile testimonial, or <code>null</code> if a matching profile testimonial could not be found
	 */
	public static ProfileTestimonial fetchByUuid_First(
		String uuid, OrderByComparator<ProfileTestimonial> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last profile testimonial in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching profile testimonial
	 * @throws NoSuchProfileTestimonialException if a matching profile testimonial could not be found
	 */
	public static ProfileTestimonial findByUuid_Last(
			String uuid,
			OrderByComparator<ProfileTestimonial> orderByComparator)
		throws basic.exception.NoSuchProfileTestimonialException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last profile testimonial in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching profile testimonial, or <code>null</code> if a matching profile testimonial could not be found
	 */
	public static ProfileTestimonial fetchByUuid_Last(
		String uuid, OrderByComparator<ProfileTestimonial> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the profile testimonials before and after the current profile testimonial in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current profile testimonial
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next profile testimonial
	 * @throws NoSuchProfileTestimonialException if a profile testimonial with the primary key could not be found
	 */
	public static ProfileTestimonial[] findByUuid_PrevAndNext(
			long id, String uuid,
			OrderByComparator<ProfileTestimonial> orderByComparator)
		throws basic.exception.NoSuchProfileTestimonialException {

		return getPersistence().findByUuid_PrevAndNext(
			id, uuid, orderByComparator);
	}

	/**
	 * Removes all the profile testimonials where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of profile testimonials where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching profile testimonials
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the profile testimonial where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProfileTestimonialException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching profile testimonial
	 * @throws NoSuchProfileTestimonialException if a matching profile testimonial could not be found
	 */
	public static ProfileTestimonial findByUUID_G(String uuid, long groupId)
		throws basic.exception.NoSuchProfileTestimonialException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the profile testimonial where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchByUUID_G(String,long)}
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching profile testimonial, or <code>null</code> if a matching profile testimonial could not be found
	 */
	@Deprecated
	public static ProfileTestimonial fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Returns the profile testimonial where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching profile testimonial, or <code>null</code> if a matching profile testimonial could not be found
	 */
	public static ProfileTestimonial fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Removes the profile testimonial where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the profile testimonial that was removed
	 */
	public static ProfileTestimonial removeByUUID_G(String uuid, long groupId)
		throws basic.exception.NoSuchProfileTestimonialException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of profile testimonials where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching profile testimonials
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the profile testimonials where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching profile testimonials
	 */
	public static List<ProfileTestimonial> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the profile testimonials where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ProfileTestimonialModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of profile testimonials
	 * @param end the upper bound of the range of profile testimonials (not inclusive)
	 * @return the range of matching profile testimonials
	 */
	public static List<ProfileTestimonial> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the profile testimonials where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ProfileTestimonialModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByUuid_C(String,long, int, int, OrderByComparator)}
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of profile testimonials
	 * @param end the upper bound of the range of profile testimonials (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching profile testimonials
	 */
	@Deprecated
	public static List<ProfileTestimonial> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProfileTestimonial> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the profile testimonials where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ProfileTestimonialModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of profile testimonials
	 * @param end the upper bound of the range of profile testimonials (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching profile testimonials
	 */
	public static List<ProfileTestimonial> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProfileTestimonial> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the first profile testimonial in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching profile testimonial
	 * @throws NoSuchProfileTestimonialException if a matching profile testimonial could not be found
	 */
	public static ProfileTestimonial findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ProfileTestimonial> orderByComparator)
		throws basic.exception.NoSuchProfileTestimonialException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first profile testimonial in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching profile testimonial, or <code>null</code> if a matching profile testimonial could not be found
	 */
	public static ProfileTestimonial fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ProfileTestimonial> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last profile testimonial in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching profile testimonial
	 * @throws NoSuchProfileTestimonialException if a matching profile testimonial could not be found
	 */
	public static ProfileTestimonial findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ProfileTestimonial> orderByComparator)
		throws basic.exception.NoSuchProfileTestimonialException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last profile testimonial in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching profile testimonial, or <code>null</code> if a matching profile testimonial could not be found
	 */
	public static ProfileTestimonial fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ProfileTestimonial> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the profile testimonials before and after the current profile testimonial in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param id the primary key of the current profile testimonial
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next profile testimonial
	 * @throws NoSuchProfileTestimonialException if a profile testimonial with the primary key could not be found
	 */
	public static ProfileTestimonial[] findByUuid_C_PrevAndNext(
			long id, String uuid, long companyId,
			OrderByComparator<ProfileTestimonial> orderByComparator)
		throws basic.exception.NoSuchProfileTestimonialException {

		return getPersistence().findByUuid_C_PrevAndNext(
			id, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the profile testimonials where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of profile testimonials where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching profile testimonials
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Caches the profile testimonial in the entity cache if it is enabled.
	 *
	 * @param profileTestimonial the profile testimonial
	 */
	public static void cacheResult(ProfileTestimonial profileTestimonial) {
		getPersistence().cacheResult(profileTestimonial);
	}

	/**
	 * Caches the profile testimonials in the entity cache if it is enabled.
	 *
	 * @param profileTestimonials the profile testimonials
	 */
	public static void cacheResult(
		List<ProfileTestimonial> profileTestimonials) {

		getPersistence().cacheResult(profileTestimonials);
	}

	/**
	 * Creates a new profile testimonial with the primary key. Does not add the profile testimonial to the database.
	 *
	 * @param id the primary key for the new profile testimonial
	 * @return the new profile testimonial
	 */
	public static ProfileTestimonial create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the profile testimonial with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the profile testimonial
	 * @return the profile testimonial that was removed
	 * @throws NoSuchProfileTestimonialException if a profile testimonial with the primary key could not be found
	 */
	public static ProfileTestimonial remove(long id)
		throws basic.exception.NoSuchProfileTestimonialException {

		return getPersistence().remove(id);
	}

	public static ProfileTestimonial updateImpl(
		ProfileTestimonial profileTestimonial) {

		return getPersistence().updateImpl(profileTestimonial);
	}

	/**
	 * Returns the profile testimonial with the primary key or throws a <code>NoSuchProfileTestimonialException</code> if it could not be found.
	 *
	 * @param id the primary key of the profile testimonial
	 * @return the profile testimonial
	 * @throws NoSuchProfileTestimonialException if a profile testimonial with the primary key could not be found
	 */
	public static ProfileTestimonial findByPrimaryKey(long id)
		throws basic.exception.NoSuchProfileTestimonialException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the profile testimonial with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the profile testimonial
	 * @return the profile testimonial, or <code>null</code> if a profile testimonial with the primary key could not be found
	 */
	public static ProfileTestimonial fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the profile testimonials.
	 *
	 * @return the profile testimonials
	 */
	public static List<ProfileTestimonial> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the profile testimonials.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ProfileTestimonialModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of profile testimonials
	 * @param end the upper bound of the range of profile testimonials (not inclusive)
	 * @return the range of profile testimonials
	 */
	public static List<ProfileTestimonial> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the profile testimonials.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ProfileTestimonialModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of profile testimonials
	 * @param end the upper bound of the range of profile testimonials (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of profile testimonials
	 */
	@Deprecated
	public static List<ProfileTestimonial> findAll(
		int start, int end,
		OrderByComparator<ProfileTestimonial> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the profile testimonials.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ProfileTestimonialModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of profile testimonials
	 * @param end the upper bound of the range of profile testimonials (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of profile testimonials
	 */
	public static List<ProfileTestimonial> findAll(
		int start, int end,
		OrderByComparator<ProfileTestimonial> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Removes all the profile testimonials from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of profile testimonials.
	 *
	 * @return the number of profile testimonials
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ProfileTestimonialPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<ProfileTestimonialPersistence, ProfileTestimonialPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			ProfileTestimonialPersistence.class);

		ServiceTracker
			<ProfileTestimonialPersistence, ProfileTestimonialPersistence>
				serviceTracker =
					new ServiceTracker
						<ProfileTestimonialPersistence,
						 ProfileTestimonialPersistence>(
							 bundle.getBundleContext(),
							 ProfileTestimonialPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}