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

import basic.exception.NoSuchprofileImageException;

import basic.model.profileImage;

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the profile image service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see profileImageUtil
 * @generated
 */
@ProviderType
public interface profileImagePersistence extends BasePersistence<profileImage> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link profileImageUtil} to access the profile image persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the profile images where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching profile images
	 */
	public java.util.List<profileImage> findByUuid(String uuid);

	/**
	 * Returns a range of all the profile images where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>profileImageModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of profile images
	 * @param end the upper bound of the range of profile images (not inclusive)
	 * @return the range of matching profile images
	 */
	public java.util.List<profileImage> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the profile images where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>profileImageModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByUuid(String, int, int, OrderByComparator)}
	 * @param uuid the uuid
	 * @param start the lower bound of the range of profile images
	 * @param end the upper bound of the range of profile images (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching profile images
	 */
	@Deprecated
	public java.util.List<profileImage> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<profileImage> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the profile images where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>profileImageModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of profile images
	 * @param end the upper bound of the range of profile images (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching profile images
	 */
	public java.util.List<profileImage> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<profileImage> orderByComparator);

	/**
	 * Returns the first profile image in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching profile image
	 * @throws NoSuchprofileImageException if a matching profile image could not be found
	 */
	public profileImage findByUuid_First(
			String uuid, OrderByComparator<profileImage> orderByComparator)
		throws NoSuchprofileImageException;

	/**
	 * Returns the first profile image in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching profile image, or <code>null</code> if a matching profile image could not be found
	 */
	public profileImage fetchByUuid_First(
		String uuid, OrderByComparator<profileImage> orderByComparator);

	/**
	 * Returns the last profile image in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching profile image
	 * @throws NoSuchprofileImageException if a matching profile image could not be found
	 */
	public profileImage findByUuid_Last(
			String uuid, OrderByComparator<profileImage> orderByComparator)
		throws NoSuchprofileImageException;

	/**
	 * Returns the last profile image in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching profile image, or <code>null</code> if a matching profile image could not be found
	 */
	public profileImage fetchByUuid_Last(
		String uuid, OrderByComparator<profileImage> orderByComparator);

	/**
	 * Returns the profile images before and after the current profile image in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current profile image
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next profile image
	 * @throws NoSuchprofileImageException if a profile image with the primary key could not be found
	 */
	public profileImage[] findByUuid_PrevAndNext(
			long id, String uuid,
			OrderByComparator<profileImage> orderByComparator)
		throws NoSuchprofileImageException;

	/**
	 * Removes all the profile images where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of profile images where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching profile images
	 */
	public int countByUuid(String uuid);

	/**
	 * Caches the profile image in the entity cache if it is enabled.
	 *
	 * @param profileImage the profile image
	 */
	public void cacheResult(profileImage profileImage);

	/**
	 * Caches the profile images in the entity cache if it is enabled.
	 *
	 * @param profileImages the profile images
	 */
	public void cacheResult(java.util.List<profileImage> profileImages);

	/**
	 * Creates a new profile image with the primary key. Does not add the profile image to the database.
	 *
	 * @param id the primary key for the new profile image
	 * @return the new profile image
	 */
	public profileImage create(long id);

	/**
	 * Removes the profile image with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the profile image
	 * @return the profile image that was removed
	 * @throws NoSuchprofileImageException if a profile image with the primary key could not be found
	 */
	public profileImage remove(long id) throws NoSuchprofileImageException;

	public profileImage updateImpl(profileImage profileImage);

	/**
	 * Returns the profile image with the primary key or throws a <code>NoSuchprofileImageException</code> if it could not be found.
	 *
	 * @param id the primary key of the profile image
	 * @return the profile image
	 * @throws NoSuchprofileImageException if a profile image with the primary key could not be found
	 */
	public profileImage findByPrimaryKey(long id)
		throws NoSuchprofileImageException;

	/**
	 * Returns the profile image with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the profile image
	 * @return the profile image, or <code>null</code> if a profile image with the primary key could not be found
	 */
	public profileImage fetchByPrimaryKey(long id);

	/**
	 * Returns all the profile images.
	 *
	 * @return the profile images
	 */
	public java.util.List<profileImage> findAll();

	/**
	 * Returns a range of all the profile images.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>profileImageModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of profile images
	 * @param end the upper bound of the range of profile images (not inclusive)
	 * @return the range of profile images
	 */
	public java.util.List<profileImage> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the profile images.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>profileImageModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of profile images
	 * @param end the upper bound of the range of profile images (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of profile images
	 */
	@Deprecated
	public java.util.List<profileImage> findAll(
		int start, int end, OrderByComparator<profileImage> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the profile images.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>profileImageModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of profile images
	 * @param end the upper bound of the range of profile images (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of profile images
	 */
	public java.util.List<profileImage> findAll(
		int start, int end, OrderByComparator<profileImage> orderByComparator);

	/**
	 * Removes all the profile images from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of profile images.
	 *
	 * @return the number of profile images
	 */
	public int countAll();

}