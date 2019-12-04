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

import basic.exception.NoSuchEventAttributesException;

import basic.model.EventAttributes;

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the event attributes service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EventAttributesUtil
 * @generated
 */
@ProviderType
public interface EventAttributesPersistence
	extends BasePersistence<EventAttributes> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EventAttributesUtil} to access the event attributes persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the event attributes in the entity cache if it is enabled.
	 *
	 * @param eventAttributes the event attributes
	 */
	public void cacheResult(EventAttributes eventAttributes);

	/**
	 * Caches the event attributeses in the entity cache if it is enabled.
	 *
	 * @param eventAttributeses the event attributeses
	 */
	public void cacheResult(java.util.List<EventAttributes> eventAttributeses);

	/**
	 * Creates a new event attributes with the primary key. Does not add the event attributes to the database.
	 *
	 * @param id the primary key for the new event attributes
	 * @return the new event attributes
	 */
	public EventAttributes create(long id);

	/**
	 * Removes the event attributes with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the event attributes
	 * @return the event attributes that was removed
	 * @throws NoSuchEventAttributesException if a event attributes with the primary key could not be found
	 */
	public EventAttributes remove(long id)
		throws NoSuchEventAttributesException;

	public EventAttributes updateImpl(EventAttributes eventAttributes);

	/**
	 * Returns the event attributes with the primary key or throws a <code>NoSuchEventAttributesException</code> if it could not be found.
	 *
	 * @param id the primary key of the event attributes
	 * @return the event attributes
	 * @throws NoSuchEventAttributesException if a event attributes with the primary key could not be found
	 */
	public EventAttributes findByPrimaryKey(long id)
		throws NoSuchEventAttributesException;

	/**
	 * Returns the event attributes with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the event attributes
	 * @return the event attributes, or <code>null</code> if a event attributes with the primary key could not be found
	 */
	public EventAttributes fetchByPrimaryKey(long id);

	/**
	 * Returns all the event attributeses.
	 *
	 * @return the event attributeses
	 */
	public java.util.List<EventAttributes> findAll();

	/**
	 * Returns a range of all the event attributeses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EventAttributesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of event attributeses
	 * @param end the upper bound of the range of event attributeses (not inclusive)
	 * @return the range of event attributeses
	 */
	public java.util.List<EventAttributes> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the event attributeses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EventAttributesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of event attributeses
	 * @param end the upper bound of the range of event attributeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of event attributeses
	 */
	@Deprecated
	public java.util.List<EventAttributes> findAll(
		int start, int end,
		OrderByComparator<EventAttributes> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the event attributeses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EventAttributesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of event attributeses
	 * @param end the upper bound of the range of event attributeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of event attributeses
	 */
	public java.util.List<EventAttributes> findAll(
		int start, int end,
		OrderByComparator<EventAttributes> orderByComparator);

	/**
	 * Removes all the event attributeses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of event attributeses.
	 *
	 * @return the number of event attributeses
	 */
	public int countAll();

}