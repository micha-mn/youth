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

import basic.model.profileWorkExperience;

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
 * The persistence utility for the profile work experience service. This utility wraps <code>basic.service.persistence.impl.profileWorkExperiencePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see profileWorkExperiencePersistence
 * @generated
 */
@ProviderType
public class profileWorkExperienceUtil {

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
	public static void clearCache(profileWorkExperience profileWorkExperience) {
		getPersistence().clearCache(profileWorkExperience);
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
	public static Map<Serializable, profileWorkExperience> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<profileWorkExperience> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<profileWorkExperience> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<profileWorkExperience> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<profileWorkExperience> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static profileWorkExperience update(
		profileWorkExperience profileWorkExperience) {

		return getPersistence().update(profileWorkExperience);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static profileWorkExperience update(
		profileWorkExperience profileWorkExperience,
		ServiceContext serviceContext) {

		return getPersistence().update(profileWorkExperience, serviceContext);
	}

	/**
	 * Returns all the profile work experiences where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching profile work experiences
	 */
	public static List<profileWorkExperience> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the profile work experiences where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>profileWorkExperienceModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of profile work experiences
	 * @param end the upper bound of the range of profile work experiences (not inclusive)
	 * @return the range of matching profile work experiences
	 */
	public static List<profileWorkExperience> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the profile work experiences where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>profileWorkExperienceModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByUuid(String, int, int, OrderByComparator)}
	 * @param uuid the uuid
	 * @param start the lower bound of the range of profile work experiences
	 * @param end the upper bound of the range of profile work experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching profile work experiences
	 */
	@Deprecated
	public static List<profileWorkExperience> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<profileWorkExperience> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the profile work experiences where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>profileWorkExperienceModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of profile work experiences
	 * @param end the upper bound of the range of profile work experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching profile work experiences
	 */
	public static List<profileWorkExperience> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<profileWorkExperience> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns the first profile work experience in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching profile work experience
	 * @throws NoSuchprofileWorkExperienceException if a matching profile work experience could not be found
	 */
	public static profileWorkExperience findByUuid_First(
			String uuid,
			OrderByComparator<profileWorkExperience> orderByComparator)
		throws basic.exception.NoSuchprofileWorkExperienceException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first profile work experience in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching profile work experience, or <code>null</code> if a matching profile work experience could not be found
	 */
	public static profileWorkExperience fetchByUuid_First(
		String uuid,
		OrderByComparator<profileWorkExperience> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last profile work experience in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching profile work experience
	 * @throws NoSuchprofileWorkExperienceException if a matching profile work experience could not be found
	 */
	public static profileWorkExperience findByUuid_Last(
			String uuid,
			OrderByComparator<profileWorkExperience> orderByComparator)
		throws basic.exception.NoSuchprofileWorkExperienceException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last profile work experience in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching profile work experience, or <code>null</code> if a matching profile work experience could not be found
	 */
	public static profileWorkExperience fetchByUuid_Last(
		String uuid,
		OrderByComparator<profileWorkExperience> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the profile work experiences before and after the current profile work experience in the ordered set where uuid = &#63;.
	 *
	 * @param Id the primary key of the current profile work experience
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next profile work experience
	 * @throws NoSuchprofileWorkExperienceException if a profile work experience with the primary key could not be found
	 */
	public static profileWorkExperience[] findByUuid_PrevAndNext(
			long Id, String uuid,
			OrderByComparator<profileWorkExperience> orderByComparator)
		throws basic.exception.NoSuchprofileWorkExperienceException {

		return getPersistence().findByUuid_PrevAndNext(
			Id, uuid, orderByComparator);
	}

	/**
	 * Removes all the profile work experiences where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of profile work experiences where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching profile work experiences
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the profile work experience where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchprofileWorkExperienceException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching profile work experience
	 * @throws NoSuchprofileWorkExperienceException if a matching profile work experience could not be found
	 */
	public static profileWorkExperience findByUUID_G(String uuid, long groupId)
		throws basic.exception.NoSuchprofileWorkExperienceException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the profile work experience where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchByUUID_G(String,long)}
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching profile work experience, or <code>null</code> if a matching profile work experience could not be found
	 */
	@Deprecated
	public static profileWorkExperience fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Returns the profile work experience where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching profile work experience, or <code>null</code> if a matching profile work experience could not be found
	 */
	public static profileWorkExperience fetchByUUID_G(
		String uuid, long groupId) {

		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Removes the profile work experience where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the profile work experience that was removed
	 */
	public static profileWorkExperience removeByUUID_G(
			String uuid, long groupId)
		throws basic.exception.NoSuchprofileWorkExperienceException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of profile work experiences where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching profile work experiences
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the profile work experiences where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching profile work experiences
	 */
	public static List<profileWorkExperience> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the profile work experiences where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>profileWorkExperienceModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of profile work experiences
	 * @param end the upper bound of the range of profile work experiences (not inclusive)
	 * @return the range of matching profile work experiences
	 */
	public static List<profileWorkExperience> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the profile work experiences where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>profileWorkExperienceModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByUuid_C(String,long, int, int, OrderByComparator)}
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of profile work experiences
	 * @param end the upper bound of the range of profile work experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching profile work experiences
	 */
	@Deprecated
	public static List<profileWorkExperience> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<profileWorkExperience> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the profile work experiences where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>profileWorkExperienceModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of profile work experiences
	 * @param end the upper bound of the range of profile work experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching profile work experiences
	 */
	public static List<profileWorkExperience> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<profileWorkExperience> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the first profile work experience in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching profile work experience
	 * @throws NoSuchprofileWorkExperienceException if a matching profile work experience could not be found
	 */
	public static profileWorkExperience findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<profileWorkExperience> orderByComparator)
		throws basic.exception.NoSuchprofileWorkExperienceException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first profile work experience in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching profile work experience, or <code>null</code> if a matching profile work experience could not be found
	 */
	public static profileWorkExperience fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<profileWorkExperience> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last profile work experience in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching profile work experience
	 * @throws NoSuchprofileWorkExperienceException if a matching profile work experience could not be found
	 */
	public static profileWorkExperience findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<profileWorkExperience> orderByComparator)
		throws basic.exception.NoSuchprofileWorkExperienceException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last profile work experience in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching profile work experience, or <code>null</code> if a matching profile work experience could not be found
	 */
	public static profileWorkExperience fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<profileWorkExperience> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the profile work experiences before and after the current profile work experience in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param Id the primary key of the current profile work experience
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next profile work experience
	 * @throws NoSuchprofileWorkExperienceException if a profile work experience with the primary key could not be found
	 */
	public static profileWorkExperience[] findByUuid_C_PrevAndNext(
			long Id, String uuid, long companyId,
			OrderByComparator<profileWorkExperience> orderByComparator)
		throws basic.exception.NoSuchprofileWorkExperienceException {

		return getPersistence().findByUuid_C_PrevAndNext(
			Id, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the profile work experiences where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of profile work experiences where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching profile work experiences
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Caches the profile work experience in the entity cache if it is enabled.
	 *
	 * @param profileWorkExperience the profile work experience
	 */
	public static void cacheResult(
		profileWorkExperience profileWorkExperience) {

		getPersistence().cacheResult(profileWorkExperience);
	}

	/**
	 * Caches the profile work experiences in the entity cache if it is enabled.
	 *
	 * @param profileWorkExperiences the profile work experiences
	 */
	public static void cacheResult(
		List<profileWorkExperience> profileWorkExperiences) {

		getPersistence().cacheResult(profileWorkExperiences);
	}

	/**
	 * Creates a new profile work experience with the primary key. Does not add the profile work experience to the database.
	 *
	 * @param Id the primary key for the new profile work experience
	 * @return the new profile work experience
	 */
	public static profileWorkExperience create(long Id) {
		return getPersistence().create(Id);
	}

	/**
	 * Removes the profile work experience with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param Id the primary key of the profile work experience
	 * @return the profile work experience that was removed
	 * @throws NoSuchprofileWorkExperienceException if a profile work experience with the primary key could not be found
	 */
	public static profileWorkExperience remove(long Id)
		throws basic.exception.NoSuchprofileWorkExperienceException {

		return getPersistence().remove(Id);
	}

	public static profileWorkExperience updateImpl(
		profileWorkExperience profileWorkExperience) {

		return getPersistence().updateImpl(profileWorkExperience);
	}

	/**
	 * Returns the profile work experience with the primary key or throws a <code>NoSuchprofileWorkExperienceException</code> if it could not be found.
	 *
	 * @param Id the primary key of the profile work experience
	 * @return the profile work experience
	 * @throws NoSuchprofileWorkExperienceException if a profile work experience with the primary key could not be found
	 */
	public static profileWorkExperience findByPrimaryKey(long Id)
		throws basic.exception.NoSuchprofileWorkExperienceException {

		return getPersistence().findByPrimaryKey(Id);
	}

	/**
	 * Returns the profile work experience with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param Id the primary key of the profile work experience
	 * @return the profile work experience, or <code>null</code> if a profile work experience with the primary key could not be found
	 */
	public static profileWorkExperience fetchByPrimaryKey(long Id) {
		return getPersistence().fetchByPrimaryKey(Id);
	}

	/**
	 * Returns all the profile work experiences.
	 *
	 * @return the profile work experiences
	 */
	public static List<profileWorkExperience> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the profile work experiences.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>profileWorkExperienceModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of profile work experiences
	 * @param end the upper bound of the range of profile work experiences (not inclusive)
	 * @return the range of profile work experiences
	 */
	public static List<profileWorkExperience> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the profile work experiences.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>profileWorkExperienceModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of profile work experiences
	 * @param end the upper bound of the range of profile work experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of profile work experiences
	 */
	@Deprecated
	public static List<profileWorkExperience> findAll(
		int start, int end,
		OrderByComparator<profileWorkExperience> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the profile work experiences.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>profileWorkExperienceModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of profile work experiences
	 * @param end the upper bound of the range of profile work experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of profile work experiences
	 */
	public static List<profileWorkExperience> findAll(
		int start, int end,
		OrderByComparator<profileWorkExperience> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Removes all the profile work experiences from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of profile work experiences.
	 *
	 * @return the number of profile work experiences
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static profileWorkExperiencePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<profileWorkExperiencePersistence, profileWorkExperiencePersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			profileWorkExperiencePersistence.class);

		ServiceTracker
			<profileWorkExperiencePersistence, profileWorkExperiencePersistence>
				serviceTracker =
					new ServiceTracker
						<profileWorkExperiencePersistence,
						 profileWorkExperiencePersistence>(
							 bundle.getBundleContext(),
							 profileWorkExperiencePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}