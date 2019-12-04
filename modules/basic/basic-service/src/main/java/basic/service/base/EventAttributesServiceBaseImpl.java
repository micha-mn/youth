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

import basic.model.EventAttributes;

import basic.service.EventAttributesService;
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
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.service.BaseServiceImpl;
import com.liferay.portal.kernel.util.PortalUtil;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the event attributes remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link basic.service.impl.EventAttributesServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see basic.service.impl.EventAttributesServiceImpl
 * @generated
 */
public abstract class EventAttributesServiceBaseImpl
	extends BaseServiceImpl
	implements EventAttributesService, AopService, IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>EventAttributesService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>basic.service.EventAttributesServiceUtil</code>.
	 */
	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			EventAttributesService.class, IdentifiableOSGiService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		eventAttributesService = (EventAttributesService)aopProxy;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return EventAttributesService.class.getName();
	}

	protected Class<?> getModelClass() {
		return EventAttributes.class;
	}

	protected String getModelClassName() {
		return EventAttributes.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = eventAttributesPersistence.getDataSource();

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
	protected basic.service.EventAttributesLocalService
		eventAttributesLocalService;

	protected EventAttributesService eventAttributesService;

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
	protected com.liferay.portal.kernel.service.ClassNameService
		classNameService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserService userService;

}