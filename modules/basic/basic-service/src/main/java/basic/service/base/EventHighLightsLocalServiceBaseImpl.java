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

import basic.model.EventHighLights;
import basic.model.EventHighLightsImageBlobModel;

import basic.service.EventHighLightsLocalService;
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
import basic.service.persistence.profileSkillsPersistence;
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
 * Provides the base implementation for the event high lights local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link basic.service.impl.EventHighLightsLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see basic.service.impl.EventHighLightsLocalServiceImpl
 * @generated
 */
@ProviderType
public abstract class EventHighLightsLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements EventHighLightsLocalService, AopService,
			   IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>EventHighLightsLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>basic.service.EventHighLightsLocalServiceUtil</code>.
	 */

	/**
	 * Adds the event high lights to the database. Also notifies the appropriate model listeners.
	 *
	 * @param eventHighLights the event high lights
	 * @return the event high lights that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public EventHighLights addEventHighLights(EventHighLights eventHighLights) {
		eventHighLights.setNew(true);

		return eventHighLightsPersistence.update(eventHighLights);
	}

	/**
	 * Creates a new event high lights with the primary key. Does not add the event high lights to the database.
	 *
	 * @param id the primary key for the new event high lights
	 * @return the new event high lights
	 */
	@Override
	@Transactional(enabled = false)
	public EventHighLights createEventHighLights(long id) {
		return eventHighLightsPersistence.create(id);
	}

	/**
	 * Deletes the event high lights with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the event high lights
	 * @return the event high lights that was removed
	 * @throws PortalException if a event high lights with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public EventHighLights deleteEventHighLights(long id)
		throws PortalException {

		return eventHighLightsPersistence.remove(id);
	}

	/**
	 * Deletes the event high lights from the database. Also notifies the appropriate model listeners.
	 *
	 * @param eventHighLights the event high lights
	 * @return the event high lights that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public EventHighLights deleteEventHighLights(
		EventHighLights eventHighLights) {

		return eventHighLightsPersistence.remove(eventHighLights);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			EventHighLights.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return eventHighLightsPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>basic.model.impl.EventHighLightsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return eventHighLightsPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>basic.model.impl.EventHighLightsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return eventHighLightsPersistence.findWithDynamicQuery(
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
		return eventHighLightsPersistence.countWithDynamicQuery(dynamicQuery);
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

		return eventHighLightsPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public EventHighLights fetchEventHighLights(long id) {
		return eventHighLightsPersistence.fetchByPrimaryKey(id);
	}

	/**
	 * Returns the event high lights with the primary key.
	 *
	 * @param id the primary key of the event high lights
	 * @return the event high lights
	 * @throws PortalException if a event high lights with the primary key could not be found
	 */
	@Override
	public EventHighLights getEventHighLights(long id) throws PortalException {
		return eventHighLightsPersistence.findByPrimaryKey(id);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(eventHighLightsLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(EventHighLights.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("id");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			eventHighLightsLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(EventHighLights.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName("id");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(eventHighLightsLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(EventHighLights.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("id");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return eventHighLightsLocalService.deleteEventHighLights(
			(EventHighLights)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return eventHighLightsPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the event high lightses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>basic.model.impl.EventHighLightsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of event high lightses
	 * @param end the upper bound of the range of event high lightses (not inclusive)
	 * @return the range of event high lightses
	 */
	@Override
	public List<EventHighLights> getEventHighLightses(int start, int end) {
		return eventHighLightsPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of event high lightses.
	 *
	 * @return the number of event high lightses
	 */
	@Override
	public int getEventHighLightsesCount() {
		return eventHighLightsPersistence.countAll();
	}

	/**
	 * Updates the event high lights in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param eventHighLights the event high lights
	 * @return the event high lights that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public EventHighLights updateEventHighLights(
		EventHighLights eventHighLights) {

		return eventHighLightsPersistence.update(eventHighLights);
	}

	@Override
	public EventHighLightsImageBlobModel getImageBlobModel(
		Serializable primaryKey) {

		Session session = null;

		try {
			session = eventHighLightsPersistence.openSession();

			return (EventHighLightsImageBlobModel)session.get(
				EventHighLightsImageBlobModel.class, primaryKey);
		}
		catch (Exception e) {
			throw eventHighLightsPersistence.processException(e);
		}
		finally {
			eventHighLightsPersistence.closeSession(session);
		}
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			EventHighLightsLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		eventHighLightsLocalService = (EventHighLightsLocalService)aopProxy;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return EventHighLightsLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return EventHighLights.class;
	}

	protected String getModelClassName() {
		return EventHighLights.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = eventHighLightsPersistence.getDataSource();

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

	protected EventHighLightsLocalService eventHighLightsLocalService;

	@Reference
	protected EventHighLightsPersistence eventHighLightsPersistence;

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
	protected profileSkillsPersistence profileSkillsPersistence;

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