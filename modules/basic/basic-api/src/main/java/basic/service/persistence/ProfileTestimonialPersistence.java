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

import basic.exception.NoSuchProfileTestimonialException;

import basic.model.ProfileTestimonial;

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the profile testimonial service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProfileTestimonialUtil
 * @generated
 */
@ProviderType
public interface ProfileTestimonialPersistence
	extends BasePersistence<ProfileTestimonial> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProfileTestimonialUtil} to access the profile testimonial persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the profile testimonials where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching profile testimonials
	 */
	public java.util.List<ProfileTestimonial> findByUuid(String uuid);

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
	public java.util.List<ProfileTestimonial> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<ProfileTestimonial> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProfileTestimonial> orderByComparator,
		boolean useFinderCache);

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
	public java.util.List<ProfileTestimonial> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProfileTestimonial> orderByComparator);

	/**
	 * Returns the first profile testimonial in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching profile testimonial
	 * @throws NoSuchProfileTestimonialException if a matching profile testimonial could not be found
	 */
	public ProfileTestimonial findByUuid_First(
			String uuid,
			OrderByComparator<ProfileTestimonial> orderByComparator)
		throws NoSuchProfileTestimonialException;

	/**
	 * Returns the first profile testimonial in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching profile testimonial, or <code>null</code> if a matching profile testimonial could not be found
	 */
	public ProfileTestimonial fetchByUuid_First(
		String uuid, OrderByComparator<ProfileTestimonial> orderByComparator);

	/**
	 * Returns the last profile testimonial in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching profile testimonial
	 * @throws NoSuchProfileTestimonialException if a matching profile testimonial could not be found
	 */
	public ProfileTestimonial findByUuid_Last(
			String uuid,
			OrderByComparator<ProfileTestimonial> orderByComparator)
		throws NoSuchProfileTestimonialException;

	/**
	 * Returns the last profile testimonial in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching profile testimonial, or <code>null</code> if a matching profile testimonial could not be found
	 */
	public ProfileTestimonial fetchByUuid_Last(
		String uuid, OrderByComparator<ProfileTestimonial> orderByComparator);

	/**
	 * Returns the profile testimonials before and after the current profile testimonial in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current profile testimonial
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next profile testimonial
	 * @throws NoSuchProfileTestimonialException if a profile testimonial with the primary key could not be found
	 */
	public ProfileTestimonial[] findByUuid_PrevAndNext(
			long id, String uuid,
			OrderByComparator<ProfileTestimonial> orderByComparator)
		throws NoSuchProfileTestimonialException;

	/**
	 * Removes all the profile testimonials where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of profile testimonials where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching profile testimonials
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the profile testimonial where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProfileTestimonialException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching profile testimonial
	 * @throws NoSuchProfileTestimonialException if a matching profile testimonial could not be found
	 */
	public ProfileTestimonial findByUUID_G(String uuid, long groupId)
		throws NoSuchProfileTestimonialException;

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
	public ProfileTestimonial fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Returns the profile testimonial where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching profile testimonial, or <code>null</code> if a matching profile testimonial could not be found
	 */
	public ProfileTestimonial fetchByUUID_G(String uuid, long groupId);

	/**
	 * Removes the profile testimonial where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the profile testimonial that was removed
	 */
	public ProfileTestimonial removeByUUID_G(String uuid, long groupId)
		throws NoSuchProfileTestimonialException;

	/**
	 * Returns the number of profile testimonials where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching profile testimonials
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the profile testimonials where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching profile testimonials
	 */
	public java.util.List<ProfileTestimonial> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<ProfileTestimonial> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<ProfileTestimonial> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProfileTestimonial> orderByComparator,
		boolean useFinderCache);

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
	public java.util.List<ProfileTestimonial> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProfileTestimonial> orderByComparator);

	/**
	 * Returns the first profile testimonial in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching profile testimonial
	 * @throws NoSuchProfileTestimonialException if a matching profile testimonial could not be found
	 */
	public ProfileTestimonial findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ProfileTestimonial> orderByComparator)
		throws NoSuchProfileTestimonialException;

	/**
	 * Returns the first profile testimonial in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching profile testimonial, or <code>null</code> if a matching profile testimonial could not be found
	 */
	public ProfileTestimonial fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ProfileTestimonial> orderByComparator);

	/**
	 * Returns the last profile testimonial in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching profile testimonial
	 * @throws NoSuchProfileTestimonialException if a matching profile testimonial could not be found
	 */
	public ProfileTestimonial findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ProfileTestimonial> orderByComparator)
		throws NoSuchProfileTestimonialException;

	/**
	 * Returns the last profile testimonial in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching profile testimonial, or <code>null</code> if a matching profile testimonial could not be found
	 */
	public ProfileTestimonial fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ProfileTestimonial> orderByComparator);

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
	public ProfileTestimonial[] findByUuid_C_PrevAndNext(
			long id, String uuid, long companyId,
			OrderByComparator<ProfileTestimonial> orderByComparator)
		throws NoSuchProfileTestimonialException;

	/**
	 * Removes all the profile testimonials where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of profile testimonials where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching profile testimonials
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Caches the profile testimonial in the entity cache if it is enabled.
	 *
	 * @param profileTestimonial the profile testimonial
	 */
	public void cacheResult(ProfileTestimonial profileTestimonial);

	/**
	 * Caches the profile testimonials in the entity cache if it is enabled.
	 *
	 * @param profileTestimonials the profile testimonials
	 */
	public void cacheResult(
		java.util.List<ProfileTestimonial> profileTestimonials);

	/**
	 * Creates a new profile testimonial with the primary key. Does not add the profile testimonial to the database.
	 *
	 * @param id the primary key for the new profile testimonial
	 * @return the new profile testimonial
	 */
	public ProfileTestimonial create(long id);

	/**
	 * Removes the profile testimonial with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the profile testimonial
	 * @return the profile testimonial that was removed
	 * @throws NoSuchProfileTestimonialException if a profile testimonial with the primary key could not be found
	 */
	public ProfileTestimonial remove(long id)
		throws NoSuchProfileTestimonialException;

	public ProfileTestimonial updateImpl(ProfileTestimonial profileTestimonial);

	/**
	 * Returns the profile testimonial with the primary key or throws a <code>NoSuchProfileTestimonialException</code> if it could not be found.
	 *
	 * @param id the primary key of the profile testimonial
	 * @return the profile testimonial
	 * @throws NoSuchProfileTestimonialException if a profile testimonial with the primary key could not be found
	 */
	public ProfileTestimonial findByPrimaryKey(long id)
		throws NoSuchProfileTestimonialException;

	/**
	 * Returns the profile testimonial with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the profile testimonial
	 * @return the profile testimonial, or <code>null</code> if a profile testimonial with the primary key could not be found
	 */
	public ProfileTestimonial fetchByPrimaryKey(long id);

	/**
	 * Returns all the profile testimonials.
	 *
	 * @return the profile testimonials
	 */
	public java.util.List<ProfileTestimonial> findAll();

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
	public java.util.List<ProfileTestimonial> findAll(int start, int end);

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
	public java.util.List<ProfileTestimonial> findAll(
		int start, int end,
		OrderByComparator<ProfileTestimonial> orderByComparator,
		boolean useFinderCache);

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
	public java.util.List<ProfileTestimonial> findAll(
		int start, int end,
		OrderByComparator<ProfileTestimonial> orderByComparator);

	/**
	 * Removes all the profile testimonials from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of profile testimonials.
	 *
	 * @return the number of profile testimonials
	 */
	public int countAll();

}