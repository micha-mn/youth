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

import com.liferay.portal.kernel.service.ServiceWrapper;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides a wrapper for {@link JourneyLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see JourneyLocalService
 * @generated
 */
@ProviderType
public class JourneyLocalServiceWrapper
	implements JourneyLocalService, ServiceWrapper<JourneyLocalService> {

	public JourneyLocalServiceWrapper(JourneyLocalService journeyLocalService) {
		_journeyLocalService = journeyLocalService;
	}

	/**
	 * Adds the journey to the database. Also notifies the appropriate model listeners.
	 *
	 * @param journey the journey
	 * @return the journey that was added
	 */
	@Override
	public basic.model.Journey addJourney(basic.model.Journey journey) {
		return _journeyLocalService.addJourney(journey);
	}

	/**
	 * Creates a new journey with the primary key. Does not add the journey to the database.
	 *
	 * @param journeyId the primary key for the new journey
	 * @return the new journey
	 */
	@Override
	public basic.model.Journey createJourney(long journeyId) {
		return _journeyLocalService.createJourney(journeyId);
	}

	/**
	 * Deletes the journey from the database. Also notifies the appropriate model listeners.
	 *
	 * @param journey the journey
	 * @return the journey that was removed
	 */
	@Override
	public basic.model.Journey deleteJourney(basic.model.Journey journey) {
		return _journeyLocalService.deleteJourney(journey);
	}

	/**
	 * Deletes the journey with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param journeyId the primary key of the journey
	 * @return the journey that was removed
	 * @throws PortalException if a journey with the primary key could not be found
	 */
	@Override
	public basic.model.Journey deleteJourney(long journeyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _journeyLocalService.deleteJourney(journeyId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _journeyLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _journeyLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _journeyLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>basic.model.impl.JourneyModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _journeyLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>basic.model.impl.JourneyModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _journeyLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _journeyLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _journeyLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public basic.model.Journey fetchJourney(long journeyId) {
		return _journeyLocalService.fetchJourney(journeyId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _journeyLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _journeyLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns a range of all the journeies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>basic.model.impl.JourneyModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of journeies
	 * @param end the upper bound of the range of journeies (not inclusive)
	 * @return the range of journeies
	 */
	@Override
	public java.util.List<basic.model.Journey> getJourneies(
		int start, int end) {

		return _journeyLocalService.getJourneies(start, end);
	}

	/**
	 * Returns the number of journeies.
	 *
	 * @return the number of journeies
	 */
	@Override
	public int getJourneiesCount() {
		return _journeyLocalService.getJourneiesCount();
	}

	/**
	 * Returns the journey with the primary key.
	 *
	 * @param journeyId the primary key of the journey
	 * @return the journey
	 * @throws PortalException if a journey with the primary key could not be found
	 */
	@Override
	public basic.model.Journey getJourney(long journeyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _journeyLocalService.getJourney(journeyId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _journeyLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _journeyLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public basic.model.JourneyPictureBlobBlobModel getPictureBlobBlobModel(
		java.io.Serializable primaryKey) {

		return _journeyLocalService.getPictureBlobBlobModel(primaryKey);
	}

	/**
	 * Updates the journey in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param journey the journey
	 * @return the journey that was updated
	 */
	@Override
	public basic.model.Journey updateJourney(basic.model.Journey journey) {
		return _journeyLocalService.updateJourney(journey);
	}

	@Override
	public JourneyLocalService getWrappedService() {
		return _journeyLocalService;
	}

	@Override
	public void setWrappedService(JourneyLocalService journeyLocalService) {
		_journeyLocalService = journeyLocalService;
	}

	private JourneyLocalService _journeyLocalService;

}