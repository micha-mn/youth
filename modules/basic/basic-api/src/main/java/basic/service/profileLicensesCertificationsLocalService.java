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

import basic.model.profileLicensesCertifications;

import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for profileLicensesCertifications. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see profileLicensesCertificationsLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface profileLicensesCertificationsLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link profileLicensesCertificationsLocalServiceUtil} to access the profile licenses certifications local service. Add custom service methods to <code>basic.service.impl.profileLicensesCertificationsLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	 * Adds the profile licenses certifications to the database. Also notifies the appropriate model listeners.
	 *
	 * @param profileLicensesCertifications the profile licenses certifications
	 * @return the profile licenses certifications that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public profileLicensesCertifications addprofileLicensesCertifications(
		profileLicensesCertifications profileLicensesCertifications);

	/**
	 * Creates a new profile licenses certifications with the primary key. Does not add the profile licenses certifications to the database.
	 *
	 * @param Id the primary key for the new profile licenses certifications
	 * @return the new profile licenses certifications
	 */
	@Transactional(enabled = false)
	public profileLicensesCertifications createprofileLicensesCertifications(
		long Id);

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	/**
	 * Deletes the profile licenses certifications with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param Id the primary key of the profile licenses certifications
	 * @return the profile licenses certifications that was removed
	 * @throws PortalException if a profile licenses certifications with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public profileLicensesCertifications deleteprofileLicensesCertifications(
			long Id)
		throws PortalException;

	/**
	 * Deletes the profile licenses certifications from the database. Also notifies the appropriate model listeners.
	 *
	 * @param profileLicensesCertifications the profile licenses certifications
	 * @return the profile licenses certifications that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public profileLicensesCertifications deleteprofileLicensesCertifications(
		profileLicensesCertifications profileLicensesCertifications);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>basic.model.impl.profileLicensesCertificationsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>basic.model.impl.profileLicensesCertificationsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public profileLicensesCertifications fetchprofileLicensesCertifications(
		long Id);

	/**
	 * Returns the profile licenses certifications matching the UUID and group.
	 *
	 * @param uuid the profile licenses certifications's UUID
	 * @param groupId the primary key of the group
	 * @return the matching profile licenses certifications, or <code>null</code> if a matching profile licenses certifications could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public profileLicensesCertifications
		fetchprofileLicensesCertificationsByUuidAndGroupId(
			String uuid, long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Returns the profile licenses certifications with the primary key.
	 *
	 * @param Id the primary key of the profile licenses certifications
	 * @return the profile licenses certifications
	 * @throws PortalException if a profile licenses certifications with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public profileLicensesCertifications getprofileLicensesCertifications(
			long Id)
		throws PortalException;

	/**
	 * Returns the profile licenses certifications matching the UUID and group.
	 *
	 * @param uuid the profile licenses certifications's UUID
	 * @param groupId the primary key of the group
	 * @return the matching profile licenses certifications
	 * @throws PortalException if a matching profile licenses certifications could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public profileLicensesCertifications
			getprofileLicensesCertificationsByUuidAndGroupId(
				String uuid, long groupId)
		throws PortalException;

	/**
	 * Returns a range of all the profile licenses certificationses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>basic.model.impl.profileLicensesCertificationsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of profile licenses certificationses
	 * @param end the upper bound of the range of profile licenses certificationses (not inclusive)
	 * @return the range of profile licenses certificationses
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<profileLicensesCertifications>
		getprofileLicensesCertificationses(int start, int end);

	/**
	 * Returns all the profile licenses certificationses matching the UUID and company.
	 *
	 * @param uuid the UUID of the profile licenses certificationses
	 * @param companyId the primary key of the company
	 * @return the matching profile licenses certificationses, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<profileLicensesCertifications>
		getprofileLicensesCertificationsesByUuidAndCompanyId(
			String uuid, long companyId);

	/**
	 * Returns a range of profile licenses certificationses matching the UUID and company.
	 *
	 * @param uuid the UUID of the profile licenses certificationses
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of profile licenses certificationses
	 * @param end the upper bound of the range of profile licenses certificationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching profile licenses certificationses, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<profileLicensesCertifications>
		getprofileLicensesCertificationsesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<profileLicensesCertifications> orderByComparator);

	/**
	 * Returns the number of profile licenses certificationses.
	 *
	 * @return the number of profile licenses certificationses
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getprofileLicensesCertificationsesCount();

	/**
	 * Updates the profile licenses certifications in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param profileLicensesCertifications the profile licenses certifications
	 * @return the profile licenses certifications that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public profileLicensesCertifications updateprofileLicensesCertifications(
		profileLicensesCertifications profileLicensesCertifications);

}