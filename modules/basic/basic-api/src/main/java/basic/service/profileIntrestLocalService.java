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

import basic.model.profileIntrest;

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
 * Provides the local service interface for profileIntrest. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see profileIntrestLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface profileIntrestLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link profileIntrestLocalServiceUtil} to access the profile intrest local service. Add custom service methods to <code>basic.service.impl.profileIntrestLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	 * Adds the profile intrest to the database. Also notifies the appropriate model listeners.
	 *
	 * @param profileIntrest the profile intrest
	 * @return the profile intrest that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public profileIntrest addprofileIntrest(profileIntrest profileIntrest);

	/**
	 * Creates a new profile intrest with the primary key. Does not add the profile intrest to the database.
	 *
	 * @param Id the primary key for the new profile intrest
	 * @return the new profile intrest
	 */
	@Transactional(enabled = false)
	public profileIntrest createprofileIntrest(long Id);

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	/**
	 * Deletes the profile intrest with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param Id the primary key of the profile intrest
	 * @return the profile intrest that was removed
	 * @throws PortalException if a profile intrest with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public profileIntrest deleteprofileIntrest(long Id) throws PortalException;

	/**
	 * Deletes the profile intrest from the database. Also notifies the appropriate model listeners.
	 *
	 * @param profileIntrest the profile intrest
	 * @return the profile intrest that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public profileIntrest deleteprofileIntrest(profileIntrest profileIntrest);

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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>basic.model.impl.profileIntrestModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>basic.model.impl.profileIntrestModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public profileIntrest fetchprofileIntrest(long Id);

	/**
	 * Returns the profile intrest matching the UUID and group.
	 *
	 * @param uuid the profile intrest's UUID
	 * @param groupId the primary key of the group
	 * @return the matching profile intrest, or <code>null</code> if a matching profile intrest could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public profileIntrest fetchprofileIntrestByUuidAndGroupId(
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
	 * Returns the profile intrest with the primary key.
	 *
	 * @param Id the primary key of the profile intrest
	 * @return the profile intrest
	 * @throws PortalException if a profile intrest with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public profileIntrest getprofileIntrest(long Id) throws PortalException;

	/**
	 * Returns the profile intrest matching the UUID and group.
	 *
	 * @param uuid the profile intrest's UUID
	 * @param groupId the primary key of the group
	 * @return the matching profile intrest
	 * @throws PortalException if a matching profile intrest could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public profileIntrest getprofileIntrestByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<profileIntrest> getprofileIntrests(int start, int end);

	/**
	 * Returns all the profile intrests matching the UUID and company.
	 *
	 * @param uuid the UUID of the profile intrests
	 * @param companyId the primary key of the company
	 * @return the matching profile intrests, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<profileIntrest> getprofileIntrestsByUuidAndCompanyId(
		String uuid, long companyId);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<profileIntrest> getprofileIntrestsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<profileIntrest> orderByComparator);

	/**
	 * Returns the number of profile intrests.
	 *
	 * @return the number of profile intrests
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getprofileIntrestsCount();

	/**
	 * Updates the profile intrest in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param profileIntrest the profile intrest
	 * @return the profile intrest that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public profileIntrest updateprofileIntrest(profileIntrest profileIntrest);

}