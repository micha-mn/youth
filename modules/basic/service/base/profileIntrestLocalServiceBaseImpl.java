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

import basic.model.profileIntrest;

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
import basic.service.profileIntrestLocalService;

import com.liferay.exportimport.kernel.lar.ExportImportHelperUtil;
import com.liferay.exportimport.kernel.lar.ManifestSummary;
import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandlerUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
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
 * Provides the base implementation for the profile intrest local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link basic.service.impl.profileIntrestLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see basic.service.impl.profileIntrestLocalServiceImpl
 * @generated
 */
@ProviderType
public abstract class profileIntrestLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements profileIntrestLocalService, AopService, IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>profileIntrestLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>basic.service.profileIntrestLocalServiceUtil</code>.
	 */

	/**
	 * Adds the profile intrest to the database. Also notifies the appropriate model listeners.
	 *
	 * @param profileIntrest the profile intrest
	 * @return the profile intrest that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public profileIntrest addprofileIntrest(profileIntrest profileIntrest) {
		profileIntrest.setNew(true);

		return profileIntrestPersistence.update(profileIntrest);
	}

	/**
	 * Creates a new profile intrest with the primary key. Does not add the profile intrest to the database.
	 *
	 * @param Id the primary key for the new profile intrest
	 * @return the new profile intrest
	 */
	@Override
	@Transactional(enabled = false)
	public profileIntrest createprofileIntrest(long Id) {
		return profileIntrestPersistence.create(Id);
	}

	/**
	 * Deletes the profile intrest with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param Id the primary key of the profile intrest
	 * @return the profile intrest that was removed
	 * @throws PortalException if a profile intrest with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public profileIntrest deleteprofileIntrest(long Id) throws PortalException {
		return profileIntrestPersistence.remove(Id);
	}

	/**
	 * Deletes the profile intrest from the database. Also notifies the appropriate model listeners.
	 *
	 * @param profileIntrest the profile intrest
	 * @return the profile intrest that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public profileIntrest deleteprofileIntrest(profileIntrest profileIntrest) {
		return profileIntrestPersistence.remove(profileIntrest);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			profileIntrest.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return profileIntrestPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>basic.model.impl.profileIntrestModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return profileIntrestPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>basic.model.impl.profileIntrestModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return profileIntrestPersistence.findWithDynamicQuery(
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
		return profileIntrestPersistence.countWithDynamicQuery(dynamicQuery);
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

		return profileIntrestPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public profileIntrest fetchprofileIntrest(long Id) {
		return profileIntrestPersistence.fetchByPrimaryKey(Id);
	}

	/**
	 * Returns the profile intrest matching the UUID and group.
	 *
	 * @param uuid the profile intrest's UUID
	 * @param groupId the primary key of the group
	 * @return the matching profile intrest, or <code>null</code> if a matching profile intrest could not be found
	 */
	@Override
	public profileIntrest fetchprofileIntrestByUuidAndGroupId(
		String uuid, long groupId) {

		return profileIntrestPersistence.fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the profile intrest with the primary key.
	 *
	 * @param Id the primary key of the profile intrest
	 * @return the profile intrest
	 * @throws PortalException if a profile intrest with the primary key could not be found
	 */
	@Override
	public profileIntrest getprofileIntrest(long Id) throws PortalException {
		return profileIntrestPersistence.findByPrimaryKey(Id);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(profileIntrestLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(profileIntrest.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("Id");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			profileIntrestLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(profileIntrest.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName("Id");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(profileIntrestLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(profileIntrest.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("Id");
	}

	@Override
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		final PortletDataContext portletDataContext) {

		final ExportActionableDynamicQuery exportActionableDynamicQuery =
			new ExportActionableDynamicQuery() {

				@Override
				public long performCount() throws PortalException {
					ManifestSummary manifestSummary =
						portletDataContext.getManifestSummary();

					StagedModelType stagedModelType = getStagedModelType();

					long modelAdditionCount = super.performCount();

					manifestSummary.addModelAdditionCount(
						stagedModelType, modelAdditionCount);

					long modelDeletionCount =
						ExportImportHelperUtil.getModelDeletionCount(
							portletDataContext, stagedModelType);

					manifestSummary.addModelDeletionCount(
						stagedModelType, modelDeletionCount);

					return modelAdditionCount;
				}

			};

		initActionableDynamicQuery(exportActionableDynamicQuery);

		exportActionableDynamicQuery.setAddCriteriaMethod(
			new ActionableDynamicQuery.AddCriteriaMethod() {

				@Override
				public void addCriteria(DynamicQuery dynamicQuery) {
					portletDataContext.addDateRangeCriteria(
						dynamicQuery, "modifiedDate");
				}

			});

		exportActionableDynamicQuery.setCompanyId(
			portletDataContext.getCompanyId());

		exportActionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<profileIntrest>() {

				@Override
				public void performAction(profileIntrest profileIntrest)
					throws PortalException {

					StagedModelDataHandlerUtil.exportStagedModel(
						portletDataContext, profileIntrest);
				}

			});
		exportActionableDynamicQuery.setStagedModelType(
			new StagedModelType(
				PortalUtil.getClassNameId(profileIntrest.class.getName())));

		return exportActionableDynamicQuery;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return profileIntrestLocalService.deleteprofileIntrest(
			(profileIntrest)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return profileIntrestPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns all the profile intrests matching the UUID and company.
	 *
	 * @param uuid the UUID of the profile intrests
	 * @param companyId the primary key of the company
	 * @return the matching profile intrests, or an empty list if no matches were found
	 */
	@Override
	public List<profileIntrest> getprofileIntrestsByUuidAndCompanyId(
		String uuid, long companyId) {

		return profileIntrestPersistence.findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of profile intrests matching the UUID and company.
	 *
	 * @param uuid the UUID of the profile intrests
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of profile intrests
	 * @param end the upper bound of the range of profile intrests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching profile intrests, or an empty list if no matches were found
	 */
	@Override
	public List<profileIntrest> getprofileIntrestsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<profileIntrest> orderByComparator) {

		return profileIntrestPersistence.findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the profile intrest matching the UUID and group.
	 *
	 * @param uuid the profile intrest's UUID
	 * @param groupId the primary key of the group
	 * @return the matching profile intrest
	 * @throws PortalException if a matching profile intrest could not be found
	 */
	@Override
	public profileIntrest getprofileIntrestByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return profileIntrestPersistence.findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns a range of all the profile intrests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>basic.model.impl.profileIntrestModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of profile intrests
	 * @param end the upper bound of the range of profile intrests (not inclusive)
	 * @return the range of profile intrests
	 */
	@Override
	public List<profileIntrest> getprofileIntrests(int start, int end) {
		return profileIntrestPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of profile intrests.
	 *
	 * @return the number of profile intrests
	 */
	@Override
	public int getprofileIntrestsCount() {
		return profileIntrestPersistence.countAll();
	}

	/**
	 * Updates the profile intrest in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param profileIntrest the profile intrest
	 * @return the profile intrest that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public profileIntrest updateprofileIntrest(profileIntrest profileIntrest) {
		return profileIntrestPersistence.update(profileIntrest);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			profileIntrestLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		profileIntrestLocalService = (profileIntrestLocalService)aopProxy;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return profileIntrestLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return profileIntrest.class;
	}

	protected String getModelClassName() {
		return profileIntrest.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = profileIntrestPersistence.getDataSource();

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

	protected profileIntrestLocalService profileIntrestLocalService;

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