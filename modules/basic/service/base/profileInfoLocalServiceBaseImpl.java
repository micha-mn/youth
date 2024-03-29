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

import basic.model.profileInfo;

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
import basic.service.profileInfoLocalService;

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
 * Provides the base implementation for the profile info local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link basic.service.impl.profileInfoLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see basic.service.impl.profileInfoLocalServiceImpl
 * @generated
 */
@ProviderType
public abstract class profileInfoLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements profileInfoLocalService, AopService, IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>profileInfoLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>basic.service.profileInfoLocalServiceUtil</code>.
	 */

	/**
	 * Adds the profile info to the database. Also notifies the appropriate model listeners.
	 *
	 * @param profileInfo the profile info
	 * @return the profile info that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public profileInfo addprofileInfo(profileInfo profileInfo) {
		profileInfo.setNew(true);

		return profileInfoPersistence.update(profileInfo);
	}

	/**
	 * Creates a new profile info with the primary key. Does not add the profile info to the database.
	 *
	 * @param id the primary key for the new profile info
	 * @return the new profile info
	 */
	@Override
	@Transactional(enabled = false)
	public profileInfo createprofileInfo(long id) {
		return profileInfoPersistence.create(id);
	}

	/**
	 * Deletes the profile info with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the profile info
	 * @return the profile info that was removed
	 * @throws PortalException if a profile info with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public profileInfo deleteprofileInfo(long id) throws PortalException {
		return profileInfoPersistence.remove(id);
	}

	/**
	 * Deletes the profile info from the database. Also notifies the appropriate model listeners.
	 *
	 * @param profileInfo the profile info
	 * @return the profile info that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public profileInfo deleteprofileInfo(profileInfo profileInfo) {
		return profileInfoPersistence.remove(profileInfo);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			profileInfo.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return profileInfoPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>basic.model.impl.profileInfoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return profileInfoPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>basic.model.impl.profileInfoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return profileInfoPersistence.findWithDynamicQuery(
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
		return profileInfoPersistence.countWithDynamicQuery(dynamicQuery);
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

		return profileInfoPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public profileInfo fetchprofileInfo(long id) {
		return profileInfoPersistence.fetchByPrimaryKey(id);
	}

	/**
	 * Returns the profile info matching the UUID and group.
	 *
	 * @param uuid the profile info's UUID
	 * @param groupId the primary key of the group
	 * @return the matching profile info, or <code>null</code> if a matching profile info could not be found
	 */
	@Override
	public profileInfo fetchprofileInfoByUuidAndGroupId(
		String uuid, long groupId) {

		return profileInfoPersistence.fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the profile info with the primary key.
	 *
	 * @param id the primary key of the profile info
	 * @return the profile info
	 * @throws PortalException if a profile info with the primary key could not be found
	 */
	@Override
	public profileInfo getprofileInfo(long id) throws PortalException {
		return profileInfoPersistence.findByPrimaryKey(id);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(profileInfoLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(profileInfo.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("id");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			profileInfoLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(profileInfo.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName("id");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(profileInfoLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(profileInfo.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("id");
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
			new ActionableDynamicQuery.PerformActionMethod<profileInfo>() {

				@Override
				public void performAction(profileInfo profileInfo)
					throws PortalException {

					StagedModelDataHandlerUtil.exportStagedModel(
						portletDataContext, profileInfo);
				}

			});
		exportActionableDynamicQuery.setStagedModelType(
			new StagedModelType(
				PortalUtil.getClassNameId(profileInfo.class.getName())));

		return exportActionableDynamicQuery;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return profileInfoLocalService.deleteprofileInfo(
			(profileInfo)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return profileInfoPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns all the profile infos matching the UUID and company.
	 *
	 * @param uuid the UUID of the profile infos
	 * @param companyId the primary key of the company
	 * @return the matching profile infos, or an empty list if no matches were found
	 */
	@Override
	public List<profileInfo> getprofileInfosByUuidAndCompanyId(
		String uuid, long companyId) {

		return profileInfoPersistence.findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of profile infos matching the UUID and company.
	 *
	 * @param uuid the UUID of the profile infos
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of profile infos
	 * @param end the upper bound of the range of profile infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching profile infos, or an empty list if no matches were found
	 */
	@Override
	public List<profileInfo> getprofileInfosByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<profileInfo> orderByComparator) {

		return profileInfoPersistence.findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the profile info matching the UUID and group.
	 *
	 * @param uuid the profile info's UUID
	 * @param groupId the primary key of the group
	 * @return the matching profile info
	 * @throws PortalException if a matching profile info could not be found
	 */
	@Override
	public profileInfo getprofileInfoByUuidAndGroupId(String uuid, long groupId)
		throws PortalException {

		return profileInfoPersistence.findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns a range of all the profile infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>basic.model.impl.profileInfoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of profile infos
	 * @param end the upper bound of the range of profile infos (not inclusive)
	 * @return the range of profile infos
	 */
	@Override
	public List<profileInfo> getprofileInfos(int start, int end) {
		return profileInfoPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of profile infos.
	 *
	 * @return the number of profile infos
	 */
	@Override
	public int getprofileInfosCount() {
		return profileInfoPersistence.countAll();
	}

	/**
	 * Updates the profile info in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param profileInfo the profile info
	 * @return the profile info that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public profileInfo updateprofileInfo(profileInfo profileInfo) {
		return profileInfoPersistence.update(profileInfo);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			profileInfoLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		profileInfoLocalService = (profileInfoLocalService)aopProxy;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return profileInfoLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return profileInfo.class;
	}

	protected String getModelClassName() {
		return profileInfo.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = profileInfoPersistence.getDataSource();

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

	protected profileInfoLocalService profileInfoLocalService;

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

	@Reference
	protected com.liferay.asset.kernel.service.AssetEntryLocalService
		assetEntryLocalService;

	@Reference
	protected com.liferay.asset.kernel.service.AssetTagLocalService
		assetTagLocalService;

}