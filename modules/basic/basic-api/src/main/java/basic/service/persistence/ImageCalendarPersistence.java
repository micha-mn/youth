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

import basic.exception.NoSuchImageCalendarException;

import basic.model.ImageCalendar;

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the image calendar service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ImageCalendarUtil
 * @generated
 */
@ProviderType
public interface ImageCalendarPersistence
	extends BasePersistence<ImageCalendar> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ImageCalendarUtil} to access the image calendar persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the image calendars where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching image calendars
	 */
	public java.util.List<ImageCalendar> findByUuid(String uuid);

	/**
	 * Returns a range of all the image calendars where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ImageCalendarModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of image calendars
	 * @param end the upper bound of the range of image calendars (not inclusive)
	 * @return the range of matching image calendars
	 */
	public java.util.List<ImageCalendar> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the image calendars where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ImageCalendarModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByUuid(String, int, int, OrderByComparator)}
	 * @param uuid the uuid
	 * @param start the lower bound of the range of image calendars
	 * @param end the upper bound of the range of image calendars (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching image calendars
	 */
	@Deprecated
	public java.util.List<ImageCalendar> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ImageCalendar> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the image calendars where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ImageCalendarModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of image calendars
	 * @param end the upper bound of the range of image calendars (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching image calendars
	 */
	public java.util.List<ImageCalendar> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ImageCalendar> orderByComparator);

	/**
	 * Returns the first image calendar in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching image calendar
	 * @throws NoSuchImageCalendarException if a matching image calendar could not be found
	 */
	public ImageCalendar findByUuid_First(
			String uuid, OrderByComparator<ImageCalendar> orderByComparator)
		throws NoSuchImageCalendarException;

	/**
	 * Returns the first image calendar in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching image calendar, or <code>null</code> if a matching image calendar could not be found
	 */
	public ImageCalendar fetchByUuid_First(
		String uuid, OrderByComparator<ImageCalendar> orderByComparator);

	/**
	 * Returns the last image calendar in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching image calendar
	 * @throws NoSuchImageCalendarException if a matching image calendar could not be found
	 */
	public ImageCalendar findByUuid_Last(
			String uuid, OrderByComparator<ImageCalendar> orderByComparator)
		throws NoSuchImageCalendarException;

	/**
	 * Returns the last image calendar in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching image calendar, or <code>null</code> if a matching image calendar could not be found
	 */
	public ImageCalendar fetchByUuid_Last(
		String uuid, OrderByComparator<ImageCalendar> orderByComparator);

	/**
	 * Returns the image calendars before and after the current image calendar in the ordered set where uuid = &#63;.
	 *
	 * @param Id the primary key of the current image calendar
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next image calendar
	 * @throws NoSuchImageCalendarException if a image calendar with the primary key could not be found
	 */
	public ImageCalendar[] findByUuid_PrevAndNext(
			long Id, String uuid,
			OrderByComparator<ImageCalendar> orderByComparator)
		throws NoSuchImageCalendarException;

	/**
	 * Removes all the image calendars where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of image calendars where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching image calendars
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the image calendar where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchImageCalendarException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching image calendar
	 * @throws NoSuchImageCalendarException if a matching image calendar could not be found
	 */
	public ImageCalendar findByUUID_G(String uuid, long groupId)
		throws NoSuchImageCalendarException;

	/**
	 * Returns the image calendar where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchByUUID_G(String,long)}
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching image calendar, or <code>null</code> if a matching image calendar could not be found
	 */
	@Deprecated
	public ImageCalendar fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Returns the image calendar where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching image calendar, or <code>null</code> if a matching image calendar could not be found
	 */
	public ImageCalendar fetchByUUID_G(String uuid, long groupId);

	/**
	 * Removes the image calendar where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the image calendar that was removed
	 */
	public ImageCalendar removeByUUID_G(String uuid, long groupId)
		throws NoSuchImageCalendarException;

	/**
	 * Returns the number of image calendars where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching image calendars
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the image calendars where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching image calendars
	 */
	public java.util.List<ImageCalendar> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the image calendars where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ImageCalendarModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of image calendars
	 * @param end the upper bound of the range of image calendars (not inclusive)
	 * @return the range of matching image calendars
	 */
	public java.util.List<ImageCalendar> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the image calendars where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ImageCalendarModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByUuid_C(String,long, int, int, OrderByComparator)}
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of image calendars
	 * @param end the upper bound of the range of image calendars (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching image calendars
	 */
	@Deprecated
	public java.util.List<ImageCalendar> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ImageCalendar> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the image calendars where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ImageCalendarModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of image calendars
	 * @param end the upper bound of the range of image calendars (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching image calendars
	 */
	public java.util.List<ImageCalendar> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ImageCalendar> orderByComparator);

	/**
	 * Returns the first image calendar in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching image calendar
	 * @throws NoSuchImageCalendarException if a matching image calendar could not be found
	 */
	public ImageCalendar findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ImageCalendar> orderByComparator)
		throws NoSuchImageCalendarException;

	/**
	 * Returns the first image calendar in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching image calendar, or <code>null</code> if a matching image calendar could not be found
	 */
	public ImageCalendar fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ImageCalendar> orderByComparator);

	/**
	 * Returns the last image calendar in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching image calendar
	 * @throws NoSuchImageCalendarException if a matching image calendar could not be found
	 */
	public ImageCalendar findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ImageCalendar> orderByComparator)
		throws NoSuchImageCalendarException;

	/**
	 * Returns the last image calendar in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching image calendar, or <code>null</code> if a matching image calendar could not be found
	 */
	public ImageCalendar fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ImageCalendar> orderByComparator);

	/**
	 * Returns the image calendars before and after the current image calendar in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param Id the primary key of the current image calendar
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next image calendar
	 * @throws NoSuchImageCalendarException if a image calendar with the primary key could not be found
	 */
	public ImageCalendar[] findByUuid_C_PrevAndNext(
			long Id, String uuid, long companyId,
			OrderByComparator<ImageCalendar> orderByComparator)
		throws NoSuchImageCalendarException;

	/**
	 * Removes all the image calendars where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of image calendars where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching image calendars
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Caches the image calendar in the entity cache if it is enabled.
	 *
	 * @param imageCalendar the image calendar
	 */
	public void cacheResult(ImageCalendar imageCalendar);

	/**
	 * Caches the image calendars in the entity cache if it is enabled.
	 *
	 * @param imageCalendars the image calendars
	 */
	public void cacheResult(java.util.List<ImageCalendar> imageCalendars);

	/**
	 * Creates a new image calendar with the primary key. Does not add the image calendar to the database.
	 *
	 * @param Id the primary key for the new image calendar
	 * @return the new image calendar
	 */
	public ImageCalendar create(long Id);

	/**
	 * Removes the image calendar with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param Id the primary key of the image calendar
	 * @return the image calendar that was removed
	 * @throws NoSuchImageCalendarException if a image calendar with the primary key could not be found
	 */
	public ImageCalendar remove(long Id) throws NoSuchImageCalendarException;

	public ImageCalendar updateImpl(ImageCalendar imageCalendar);

	/**
	 * Returns the image calendar with the primary key or throws a <code>NoSuchImageCalendarException</code> if it could not be found.
	 *
	 * @param Id the primary key of the image calendar
	 * @return the image calendar
	 * @throws NoSuchImageCalendarException if a image calendar with the primary key could not be found
	 */
	public ImageCalendar findByPrimaryKey(long Id)
		throws NoSuchImageCalendarException;

	/**
	 * Returns the image calendar with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param Id the primary key of the image calendar
	 * @return the image calendar, or <code>null</code> if a image calendar with the primary key could not be found
	 */
	public ImageCalendar fetchByPrimaryKey(long Id);

	/**
	 * Returns all the image calendars.
	 *
	 * @return the image calendars
	 */
	public java.util.List<ImageCalendar> findAll();

	/**
	 * Returns a range of all the image calendars.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ImageCalendarModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of image calendars
	 * @param end the upper bound of the range of image calendars (not inclusive)
	 * @return the range of image calendars
	 */
	public java.util.List<ImageCalendar> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the image calendars.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ImageCalendarModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of image calendars
	 * @param end the upper bound of the range of image calendars (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of image calendars
	 */
	@Deprecated
	public java.util.List<ImageCalendar> findAll(
		int start, int end, OrderByComparator<ImageCalendar> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the image calendars.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ImageCalendarModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of image calendars
	 * @param end the upper bound of the range of image calendars (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of image calendars
	 */
	public java.util.List<ImageCalendar> findAll(
		int start, int end, OrderByComparator<ImageCalendar> orderByComparator);

	/**
	 * Removes all the image calendars from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of image calendars.
	 *
	 * @return the number of image calendars
	 */
	public int countAll();

}