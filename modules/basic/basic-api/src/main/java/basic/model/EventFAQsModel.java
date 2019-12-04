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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the EventFAQs service. Represents a row in the &quot;EventFAQs&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>basic.model.impl.EventFAQsModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>basic.model.impl.EventFAQsImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EventFAQs
 * @generated
 */
@ProviderType
public interface EventFAQsModel extends BaseModel<EventFAQs> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a event fa qs model instance should use the {@link EventFAQs} interface instead.
	 */

	/**
	 * Returns the primary key of this event fa qs.
	 *
	 * @return the primary key of this event fa qs
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this event fa qs.
	 *
	 * @param primaryKey the primary key of this event fa qs
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this event fa qs.
	 *
	 * @return the uuid of this event fa qs
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this event fa qs.
	 *
	 * @param uuid the uuid of this event fa qs
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the ID of this event fa qs.
	 *
	 * @return the ID of this event fa qs
	 */
	public long getId();

	/**
	 * Sets the ID of this event fa qs.
	 *
	 * @param id the ID of this event fa qs
	 */
	public void setId(long id);

	/**
	 * Returns the question of this event fa qs.
	 *
	 * @return the question of this event fa qs
	 */
	@AutoEscape
	public String getQuestion();

	/**
	 * Sets the question of this event fa qs.
	 *
	 * @param Question the question of this event fa qs
	 */
	public void setQuestion(String Question);

	/**
	 * Returns the answer of this event fa qs.
	 *
	 * @return the answer of this event fa qs
	 */
	@AutoEscape
	public String getAnswer();

	/**
	 * Sets the answer of this event fa qs.
	 *
	 * @param Answer the answer of this event fa qs
	 */
	public void setAnswer(String Answer);

	/**
	 * Returns the event ID of this event fa qs.
	 *
	 * @return the event ID of this event fa qs
	 */
	@AutoEscape
	public String getEventId();

	/**
	 * Sets the event ID of this event fa qs.
	 *
	 * @param eventId the event ID of this event fa qs
	 */
	public void setEventId(String eventId);

}