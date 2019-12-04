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

import basic.exception.NoSuchformeventusertableException;

import basic.model.formeventusertable;

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the formeventusertable service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see formeventusertableUtil
 * @generated
 */
@ProviderType
public interface formeventusertablePersistence
	extends BasePersistence<formeventusertable> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link formeventusertableUtil} to access the formeventusertable persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the formeventusertables where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching formeventusertables
	 */
	public java.util.List<formeventusertable> findByUuid(String uuid);

	/**
	 * Returns a range of all the formeventusertables where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>formeventusertableModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of formeventusertables
	 * @param end the upper bound of the range of formeventusertables (not inclusive)
	 * @return the range of matching formeventusertables
	 */
	public java.util.List<formeventusertable> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the formeventusertables where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>formeventusertableModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByUuid(String, int, int, OrderByComparator)}
	 * @param uuid the uuid
	 * @param start the lower bound of the range of formeventusertables
	 * @param end the upper bound of the range of formeventusertables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching formeventusertables
	 */
	@Deprecated
	public java.util.List<formeventusertable> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<formeventusertable> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the formeventusertables where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>formeventusertableModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of formeventusertables
	 * @param end the upper bound of the range of formeventusertables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching formeventusertables
	 */
	public java.util.List<formeventusertable> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<formeventusertable> orderByComparator);

	/**
	 * Returns the first formeventusertable in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching formeventusertable
	 * @throws NoSuchformeventusertableException if a matching formeventusertable could not be found
	 */
	public formeventusertable findByUuid_First(
			String uuid,
			OrderByComparator<formeventusertable> orderByComparator)
		throws NoSuchformeventusertableException;

	/**
	 * Returns the first formeventusertable in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching formeventusertable, or <code>null</code> if a matching formeventusertable could not be found
	 */
	public formeventusertable fetchByUuid_First(
		String uuid, OrderByComparator<formeventusertable> orderByComparator);

	/**
	 * Returns the last formeventusertable in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching formeventusertable
	 * @throws NoSuchformeventusertableException if a matching formeventusertable could not be found
	 */
	public formeventusertable findByUuid_Last(
			String uuid,
			OrderByComparator<formeventusertable> orderByComparator)
		throws NoSuchformeventusertableException;

	/**
	 * Returns the last formeventusertable in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching formeventusertable, or <code>null</code> if a matching formeventusertable could not be found
	 */
	public formeventusertable fetchByUuid_Last(
		String uuid, OrderByComparator<formeventusertable> orderByComparator);

	/**
	 * Returns the formeventusertables before and after the current formeventusertable in the ordered set where uuid = &#63;.
	 *
	 * @param ID the primary key of the current formeventusertable
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next formeventusertable
	 * @throws NoSuchformeventusertableException if a formeventusertable with the primary key could not be found
	 */
	public formeventusertable[] findByUuid_PrevAndNext(
			long ID, String uuid,
			OrderByComparator<formeventusertable> orderByComparator)
		throws NoSuchformeventusertableException;

	/**
	 * Removes all the formeventusertables where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of formeventusertables where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching formeventusertables
	 */
	public int countByUuid(String uuid);

	/**
	 * Caches the formeventusertable in the entity cache if it is enabled.
	 *
	 * @param formeventusertable the formeventusertable
	 */
	public void cacheResult(formeventusertable formeventusertable);

	/**
	 * Caches the formeventusertables in the entity cache if it is enabled.
	 *
	 * @param formeventusertables the formeventusertables
	 */
	public void cacheResult(
		java.util.List<formeventusertable> formeventusertables);

	/**
	 * Creates a new formeventusertable with the primary key. Does not add the formeventusertable to the database.
	 *
	 * @param ID the primary key for the new formeventusertable
	 * @return the new formeventusertable
	 */
	public formeventusertable create(long ID);

	/**
	 * Removes the formeventusertable with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ID the primary key of the formeventusertable
	 * @return the formeventusertable that was removed
	 * @throws NoSuchformeventusertableException if a formeventusertable with the primary key could not be found
	 */
	public formeventusertable remove(long ID)
		throws NoSuchformeventusertableException;

	public formeventusertable updateImpl(formeventusertable formeventusertable);

	/**
	 * Returns the formeventusertable with the primary key or throws a <code>NoSuchformeventusertableException</code> if it could not be found.
	 *
	 * @param ID the primary key of the formeventusertable
	 * @return the formeventusertable
	 * @throws NoSuchformeventusertableException if a formeventusertable with the primary key could not be found
	 */
	public formeventusertable findByPrimaryKey(long ID)
		throws NoSuchformeventusertableException;

	/**
	 * Returns the formeventusertable with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ID the primary key of the formeventusertable
	 * @return the formeventusertable, or <code>null</code> if a formeventusertable with the primary key could not be found
	 */
	public formeventusertable fetchByPrimaryKey(long ID);

	/**
	 * Returns all the formeventusertables.
	 *
	 * @return the formeventusertables
	 */
	public java.util.List<formeventusertable> findAll();

	/**
	 * Returns a range of all the formeventusertables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>formeventusertableModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of formeventusertables
	 * @param end the upper bound of the range of formeventusertables (not inclusive)
	 * @return the range of formeventusertables
	 */
	public java.util.List<formeventusertable> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the formeventusertables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>formeventusertableModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of formeventusertables
	 * @param end the upper bound of the range of formeventusertables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of formeventusertables
	 */
	@Deprecated
	public java.util.List<formeventusertable> findAll(
		int start, int end,
		OrderByComparator<formeventusertable> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the formeventusertables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>formeventusertableModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of formeventusertables
	 * @param end the upper bound of the range of formeventusertables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of formeventusertables
	 */
	public java.util.List<formeventusertable> findAll(
		int start, int end,
		OrderByComparator<formeventusertable> orderByComparator);

	/**
	 * Removes all the formeventusertables from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of formeventusertables.
	 *
	 * @return the number of formeventusertables
	 */
	public int countAll();

}