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

package basic.service.base;

import basic.model.EventSpeakers;
import basic.model.EventSpeakersSpeakerImageBlobModel;

import basic.service.EventSpeakersLocalService;
import basic.service.persistence.EventAssigneeTablePersistence;
import basic.service.persistence.EventAttributesPersistence;
import basic.service.persistence.EventFAQsPersistence;
import basic.service.persistence.EventHighLightsPersistence;
import basic.service.persistence.EventSpeakersPersistence;
import basic.service.persistence.EventTimelinePersistence;
import basic.service.persistence.FooPersistence;
import basic.service.persistence.ImageCalendarPersistence;
import basic.service.persistence.JourneyPersistence;
import basic.service.persistence.ProfileJobWishListPersistence;
import basic.service.persistence.ProfileTestimonialPersistence;
import basic.service.persistence.RegisterEventPersistence;
import basic.service.persistence.TableNewTestPersistence;
import basic.service.persistence.formeventusertablePersistence;
import basic.service.persistence.profileEducationPersistence;
import basic.service.persistence.profileImagePersistence;
import basic.service.persistence.profileInfoPersistence;
import basic.service.persistence.profileIntrestPersistence;
import basic.service.persistence.profileLicensesCertificationsPersistence;
import basic.service.persistence.profileWorkExperiencePersistence;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the event speakers local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link basic.service.impl.EventSpeakersLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see basic.service.impl.EventSpeakersLocalServiceImpl
 * @generated
 */
@ProviderType
public abstract class EventSpeakersLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements EventSpeakersLocalService, AopService, IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>EventSpeakersLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>basic.service.EventSpeakersLocalServiceUtil</code>.
	 */

	/**
	 * Adds the event speakers to the database. Also notifies the appropriate model listeners.
	 *
	 * @param eventSpeakers the event speakers
	 * @return the event speakers that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public EventSpeakers addEventSpeakers(EventSpeakers eventSpeakers) {
		eventSpeakers.setNew(true);

		return eventSpeakersPersistence.update(eventSpeakers);
	}

	/**
	 * Creates a new event speakers with the primary key. Does not add the event speakers to the database.
	 *
	 * @param id the primary key for the new event speakers
	 * @return the new event speakers
	 */
	@Override
	@Transactional(enabled = false)
	public EventSpeakers createEventSpeakers(long id) {
		return eventSpeakersPersistence.create(id);
	}

	/**
	 * Deletes the event speakers with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the event speakers
	 * @return the event speakers that was removed
	 * @throws PortalException if a event speakers with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public EventSpeakers deleteEventSpeakers(long id) throws PortalException {
		return eventSpeakersPersistence.remove(id);
	}

	/**
	 * Deletes the event speakers from the database. Also notifies the appropriate model listeners.
	 *
	 * @param eventSpeakers the event speakers
	 * @return the event speakers that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public EventSpeakers deleteEventSpeakers(EventSpeakers eventSpeakers) {
		return eventSpeakersPersistence.remove(eventSpeakers);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			EventSpeakers.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return eventSpeakersPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>basic.model.impl.EventSpeakersModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return eventSpeakersPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>basic.model.impl.EventSpeakersModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return eventSpeakersPersistence.findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return eventSpeakersPersistence.countWithDynamicQuery(dynamicQuery);
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
		DynamicQuery dynamicQuery, Projection projection) {

		return eventSpeakersPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public EventSpeakers fetchEventSpeakers(long id) {
		return eventSpeakersPersistence.fetchByPrimaryKey(id);
	}

	/**
	 * Returns the event speakers with the primary key.
	 *
	 * @param id the primary key of the event speakers
	 * @return the event speakers
	 * @throws PortalException if a event speakers with the primary key could not be found
	 */
	@Override
	public EventSpeakers getEventSpeakers(long id) throws PortalException {
		return eventSpeakersPersistence.findByPrimaryKey(id);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(eventSpeakersLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(EventSpeakers.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("id");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			eventSpeakersLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(EventSpeakers.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName("id");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(eventSpeakersLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(EventSpeakers.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("id");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return eventSpeakersLocalService.deleteEventSpeakers(
			(EventSpeakers)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return eventSpeakersPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the event speakerses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>basic.model.impl.EventSpeakersModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of event speakerses
	 * @param end the upper bound of the range of event speakerses (not inclusive)
	 * @return the range of event speakerses
	 */
	@Override
	public List<EventSpeakers> getEventSpeakerses(int start, int end) {
		return eventSpeakersPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of event speakerses.
	 *
	 * @return the number of event speakerses
	 */
	@Override
	public int getEventSpeakersesCount() {
		return eventSpeakersPersistence.countAll();
	}

	/**
	 * Updates the event speakers in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param eventSpeakers the event speakers
	 * @return the event speakers that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public EventSpeakers updateEventSpeakers(EventSpeakers eventSpeakers) {
		return eventSpeakersPersistence.update(eventSpeakers);
	}

	@Override
	public EventSpeakersSpeakerImageBlobModel getSpeakerImageBlobModel(
		Serializable primaryKey) {

		Session session = null;

		try {
			session = eventSpeakersPersistence.openSession();

			return (EventSpeakersSpeakerImageBlobModel)session.get(
				EventSpeakersSpeakerImageBlobModel.class, primaryKey);
		}
		catch (Exception e) {
			throw eventSpeakersPersistence.processException(e);
		}
		finally {
			eventSpeakersPersistence.closeSession(session);
		}
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			EventSpeakersLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		eventSpeakersLocalService = (EventSpeakersLocalService)aopProxy;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return EventSpeakersLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return EventSpeakers.class;
	}

	protected String getModelClassName() {
		return EventSpeakers.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = eventSpeakersPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@Reference
	protected EventAssigneeTablePersistence eventAssigneeTablePersistence;

	@Reference
	protected EventAttributesPersistence eventAttributesPersistence;

	@Reference
	protected EventFAQsPersistence eventFAQsPersistence;

	@Reference
	protected EventHighLightsPersistence eventHighLightsPersistence;

	protected EventSpeakersLocalService eventSpeakersLocalService;

	@Reference
	protected EventSpeakersPersistence eventSpeakersPersistence;

	@Reference
	protected EventTimelinePersistence eventTimelinePersistence;

	@Reference
	protected FooPersistence fooPersistence;

	@Reference
	protected formeventusertablePersistence formeventusertablePersistence;

	@Reference
	protected ImageCalendarPersistence imageCalendarPersistence;

	@Reference
	protected JourneyPersistence journeyPersistence;

	@Reference
	protected profileEducationPersistence profileEducationPersistence;

	@Reference
	protected profileImagePersistence profileImagePersistence;

	@Reference
	protected profileInfoPersistence profileInfoPersistence;

	@Reference
	protected profileIntrestPersistence profileIntrestPersistence;

	@Reference
	protected ProfileJobWishListPersistence profileJobWishListPersistence;

	@Reference
	protected profileLicensesCertificationsPersistence
		profileLicensesCertificationsPersistence;

	@Reference
	protected ProfileTestimonialPersistence profileTestimonialPersistence;

	@Reference
	protected profileWorkExperiencePersistence profileWorkExperiencePersistence;

	@Reference
	protected RegisterEventPersistence registerEventPersistence;

	@Reference
	protected TableNewTestPersistence tableNewTestPersistence;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

}