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

package basic.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * <p>
 * This class is a wrapper for {@link ProfileTestimonial}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProfileTestimonial
 * @generated
 */
@ProviderType
public class ProfileTestimonialWrapper
	extends BaseModelWrapper<ProfileTestimonial>
	implements ProfileTestimonial, ModelWrapper<ProfileTestimonial> {

	public ProfileTestimonialWrapper(ProfileTestimonial profileTestimonial) {
		super(profileTestimonial);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("id", getId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("testimonialprovidername", getTestimonialprovidername());
		attributes.put(
			"testimonialprovideremail", getTestimonialprovideremail());
		attributes.put("testimonialprovorgname", getTestimonialprovorgname());
		attributes.put(
			"testimonialprovidertitle", getTestimonialprovidertitle());
		attributes.put(
			"testimonialprivatemessage", getTestimonialprivatemessage());
		attributes.put("imagePreview", getImagePreview());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String testimonialprovidername = (String)attributes.get(
			"testimonialprovidername");

		if (testimonialprovidername != null) {
			setTestimonialprovidername(testimonialprovidername);
		}

		String testimonialprovideremail = (String)attributes.get(
			"testimonialprovideremail");

		if (testimonialprovideremail != null) {
			setTestimonialprovideremail(testimonialprovideremail);
		}

		String testimonialprovorgname = (String)attributes.get(
			"testimonialprovorgname");

		if (testimonialprovorgname != null) {
			setTestimonialprovorgname(testimonialprovorgname);
		}

		String testimonialprovidertitle = (String)attributes.get(
			"testimonialprovidertitle");

		if (testimonialprovidertitle != null) {
			setTestimonialprovidertitle(testimonialprovidertitle);
		}

		String testimonialprivatemessage = (String)attributes.get(
			"testimonialprivatemessage");

		if (testimonialprivatemessage != null) {
			setTestimonialprivatemessage(testimonialprivatemessage);
		}

		String imagePreview = (String)attributes.get("imagePreview");

		if (imagePreview != null) {
			setImagePreview(imagePreview);
		}
	}

	/**
	 * Returns the company ID of this profile testimonial.
	 *
	 * @return the company ID of this profile testimonial
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this profile testimonial.
	 *
	 * @return the create date of this profile testimonial
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this profile testimonial.
	 *
	 * @return the group ID of this profile testimonial
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the ID of this profile testimonial.
	 *
	 * @return the ID of this profile testimonial
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the image preview of this profile testimonial.
	 *
	 * @return the image preview of this profile testimonial
	 */
	@Override
	public String getImagePreview() {
		return model.getImagePreview();
	}

	/**
	 * Returns the modified date of this profile testimonial.
	 *
	 * @return the modified date of this profile testimonial
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this profile testimonial.
	 *
	 * @return the primary key of this profile testimonial
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the testimonialprivatemessage of this profile testimonial.
	 *
	 * @return the testimonialprivatemessage of this profile testimonial
	 */
	@Override
	public String getTestimonialprivatemessage() {
		return model.getTestimonialprivatemessage();
	}

	/**
	 * Returns the testimonialprovideremail of this profile testimonial.
	 *
	 * @return the testimonialprovideremail of this profile testimonial
	 */
	@Override
	public String getTestimonialprovideremail() {
		return model.getTestimonialprovideremail();
	}

	/**
	 * Returns the testimonialprovidername of this profile testimonial.
	 *
	 * @return the testimonialprovidername of this profile testimonial
	 */
	@Override
	public String getTestimonialprovidername() {
		return model.getTestimonialprovidername();
	}

	/**
	 * Returns the testimonialprovidertitle of this profile testimonial.
	 *
	 * @return the testimonialprovidertitle of this profile testimonial
	 */
	@Override
	public String getTestimonialprovidertitle() {
		return model.getTestimonialprovidertitle();
	}

	/**
	 * Returns the testimonialprovorgname of this profile testimonial.
	 *
	 * @return the testimonialprovorgname of this profile testimonial
	 */
	@Override
	public String getTestimonialprovorgname() {
		return model.getTestimonialprovorgname();
	}

	/**
	 * Returns the user ID of this profile testimonial.
	 *
	 * @return the user ID of this profile testimonial
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this profile testimonial.
	 *
	 * @return the user name of this profile testimonial
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this profile testimonial.
	 *
	 * @return the user uuid of this profile testimonial
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this profile testimonial.
	 *
	 * @return the uuid of this profile testimonial
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this profile testimonial.
	 *
	 * @param companyId the company ID of this profile testimonial
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this profile testimonial.
	 *
	 * @param createDate the create date of this profile testimonial
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this profile testimonial.
	 *
	 * @param groupId the group ID of this profile testimonial
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the ID of this profile testimonial.
	 *
	 * @param id the ID of this profile testimonial
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the image preview of this profile testimonial.
	 *
	 * @param imagePreview the image preview of this profile testimonial
	 */
	@Override
	public void setImagePreview(String imagePreview) {
		model.setImagePreview(imagePreview);
	}

	/**
	 * Sets the modified date of this profile testimonial.
	 *
	 * @param modifiedDate the modified date of this profile testimonial
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this profile testimonial.
	 *
	 * @param primaryKey the primary key of this profile testimonial
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the testimonialprivatemessage of this profile testimonial.
	 *
	 * @param testimonialprivatemessage the testimonialprivatemessage of this profile testimonial
	 */
	@Override
	public void setTestimonialprivatemessage(String testimonialprivatemessage) {
		model.setTestimonialprivatemessage(testimonialprivatemessage);
	}

	/**
	 * Sets the testimonialprovideremail of this profile testimonial.
	 *
	 * @param testimonialprovideremail the testimonialprovideremail of this profile testimonial
	 */
	@Override
	public void setTestimonialprovideremail(String testimonialprovideremail) {
		model.setTestimonialprovideremail(testimonialprovideremail);
	}

	/**
	 * Sets the testimonialprovidername of this profile testimonial.
	 *
	 * @param testimonialprovidername the testimonialprovidername of this profile testimonial
	 */
	@Override
	public void setTestimonialprovidername(String testimonialprovidername) {
		model.setTestimonialprovidername(testimonialprovidername);
	}

	/**
	 * Sets the testimonialprovidertitle of this profile testimonial.
	 *
	 * @param testimonialprovidertitle the testimonialprovidertitle of this profile testimonial
	 */
	@Override
	public void setTestimonialprovidertitle(String testimonialprovidertitle) {
		model.setTestimonialprovidertitle(testimonialprovidertitle);
	}

	/**
	 * Sets the testimonialprovorgname of this profile testimonial.
	 *
	 * @param testimonialprovorgname the testimonialprovorgname of this profile testimonial
	 */
	@Override
	public void setTestimonialprovorgname(String testimonialprovorgname) {
		model.setTestimonialprovorgname(testimonialprovorgname);
	}

	/**
	 * Sets the user ID of this profile testimonial.
	 *
	 * @param userId the user ID of this profile testimonial
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this profile testimonial.
	 *
	 * @param userName the user name of this profile testimonial
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this profile testimonial.
	 *
	 * @param userUuid the user uuid of this profile testimonial
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this profile testimonial.
	 *
	 * @param uuid the uuid of this profile testimonial
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected ProfileTestimonialWrapper wrap(
		ProfileTestimonial profileTestimonial) {

		return new ProfileTestimonialWrapper(profileTestimonial);
	}

}