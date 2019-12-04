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

package basic.model.impl;

import basic.model.EventSpeakers;
import basic.model.EventSpeakersModel;
import basic.model.EventSpeakersSoap;
import basic.model.EventSpeakersSpeakerImageBlobModel;

import basic.service.EventSpeakersLocalServiceUtil;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Blob;
import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model implementation for the EventSpeakers service. Represents a row in the &quot;EventSpeakers&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>EventSpeakersModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link EventSpeakersImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EventSpeakersImpl
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class EventSpeakersModelImpl
	extends BaseModelImpl<EventSpeakers> implements EventSpeakersModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a event speakers model instance should use the <code>EventSpeakers</code> interface instead.
	 */
	public static final String TABLE_NAME = "EventSpeakers";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"id_", Types.BIGINT},
		{"position", Types.VARCHAR}, {"speakerImage", Types.BLOB},
		{"speakerImageString", Types.VARCHAR}, {"nationality", Types.VARCHAR},
		{"email", Types.VARCHAR}, {"firstName", Types.VARCHAR},
		{"userId", Types.VARCHAR}, {"lastName", Types.VARCHAR},
		{"isNotificationSent", Types.VARCHAR}, {"eventId", Types.VARCHAR},
		{"isNotifEnabled", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("id_", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("position", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("speakerImage", Types.BLOB);
		TABLE_COLUMNS_MAP.put("speakerImageString", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("nationality", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("email", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("firstName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("userId", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("lastName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("isNotificationSent", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("eventId", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("isNotifEnabled", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table EventSpeakers (uuid_ VARCHAR(75) null,id_ LONG not null primary key,position VARCHAR(75) null,speakerImage BLOB,speakerImageString VARCHAR(75) null,nationality VARCHAR(75) null,email VARCHAR(75) null,firstName VARCHAR(75) null,userId VARCHAR(75) null,lastName VARCHAR(75) null,isNotificationSent VARCHAR(75) null,eventId VARCHAR(75) null,isNotifEnabled VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP = "drop table EventSpeakers";

	public static final String ORDER_BY_JPQL = " ORDER BY eventSpeakers.id ASC";

	public static final String ORDER_BY_SQL = " ORDER BY EventSpeakers.id_ ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final long UUID_COLUMN_BITMASK = 1L;

	public static final long ID_COLUMN_BITMASK = 2L;

	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
		_entityCacheEnabled = entityCacheEnabled;
	}

	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
		_finderCacheEnabled = finderCacheEnabled;
	}

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static EventSpeakers toModel(EventSpeakersSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		EventSpeakers model = new EventSpeakersImpl();

		model.setUuid(soapModel.getUuid());
		model.setId(soapModel.getId());
		model.setPosition(soapModel.getPosition());
		model.setSpeakerImage(soapModel.getSpeakerImage());
		model.setSpeakerImageString(soapModel.getSpeakerImageString());
		model.setNationality(soapModel.getNationality());
		model.setEmail(soapModel.getEmail());
		model.setFirstName(soapModel.getFirstName());
		model.setUserId(soapModel.getUserId());
		model.setLastName(soapModel.getLastName());
		model.setIsNotificationSent(soapModel.getIsNotificationSent());
		model.setEventId(soapModel.getEventId());
		model.setIsNotifEnabled(soapModel.getIsNotifEnabled());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<EventSpeakers> toModels(EventSpeakersSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<EventSpeakers> models = new ArrayList<EventSpeakers>(
			soapModels.length);

		for (EventSpeakersSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public EventSpeakersModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _id;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _id;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return EventSpeakers.class;
	}

	@Override
	public String getModelClassName() {
		return EventSpeakers.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<EventSpeakers, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<EventSpeakers, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<EventSpeakers, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((EventSpeakers)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<EventSpeakers, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<EventSpeakers, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(EventSpeakers)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<EventSpeakers, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<EventSpeakers, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, EventSpeakers>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			EventSpeakers.class.getClassLoader(), EventSpeakers.class,
			ModelWrapper.class);

		try {
			Constructor<EventSpeakers> constructor =
				(Constructor<EventSpeakers>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException roe) {
					throw new InternalError(roe);
				}
			};
		}
		catch (NoSuchMethodException nsme) {
			throw new InternalError(nsme);
		}
	}

	private static final Map<String, Function<EventSpeakers, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<EventSpeakers, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<EventSpeakers, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<EventSpeakers, Object>>();
		Map<String, BiConsumer<EventSpeakers, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<EventSpeakers, ?>>();

		attributeGetterFunctions.put("uuid", EventSpeakers::getUuid);
		attributeSetterBiConsumers.put(
			"uuid", (BiConsumer<EventSpeakers, String>)EventSpeakers::setUuid);
		attributeGetterFunctions.put("id", EventSpeakers::getId);
		attributeSetterBiConsumers.put(
			"id", (BiConsumer<EventSpeakers, Long>)EventSpeakers::setId);
		attributeGetterFunctions.put("position", EventSpeakers::getPosition);
		attributeSetterBiConsumers.put(
			"position",
			(BiConsumer<EventSpeakers, String>)EventSpeakers::setPosition);
		attributeGetterFunctions.put(
			"speakerImage", EventSpeakers::getSpeakerImage);
		attributeSetterBiConsumers.put(
			"speakerImage",
			(BiConsumer<EventSpeakers, Blob>)EventSpeakers::setSpeakerImage);
		attributeGetterFunctions.put(
			"speakerImageString", EventSpeakers::getSpeakerImageString);
		attributeSetterBiConsumers.put(
			"speakerImageString",
			(BiConsumer<EventSpeakers, String>)
				EventSpeakers::setSpeakerImageString);
		attributeGetterFunctions.put(
			"nationality", EventSpeakers::getNationality);
		attributeSetterBiConsumers.put(
			"nationality",
			(BiConsumer<EventSpeakers, String>)EventSpeakers::setNationality);
		attributeGetterFunctions.put("email", EventSpeakers::getEmail);
		attributeSetterBiConsumers.put(
			"email",
			(BiConsumer<EventSpeakers, String>)EventSpeakers::setEmail);
		attributeGetterFunctions.put("firstName", EventSpeakers::getFirstName);
		attributeSetterBiConsumers.put(
			"firstName",
			(BiConsumer<EventSpeakers, String>)EventSpeakers::setFirstName);
		attributeGetterFunctions.put("userId", EventSpeakers::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<EventSpeakers, String>)EventSpeakers::setUserId);
		attributeGetterFunctions.put("lastName", EventSpeakers::getLastName);
		attributeSetterBiConsumers.put(
			"lastName",
			(BiConsumer<EventSpeakers, String>)EventSpeakers::setLastName);
		attributeGetterFunctions.put(
			"isNotificationSent", EventSpeakers::getIsNotificationSent);
		attributeSetterBiConsumers.put(
			"isNotificationSent",
			(BiConsumer<EventSpeakers, String>)
				EventSpeakers::setIsNotificationSent);
		attributeGetterFunctions.put("eventId", EventSpeakers::getEventId);
		attributeSetterBiConsumers.put(
			"eventId",
			(BiConsumer<EventSpeakers, String>)EventSpeakers::setEventId);
		attributeGetterFunctions.put(
			"isNotifEnabled", EventSpeakers::getIsNotifEnabled);
		attributeSetterBiConsumers.put(
			"isNotifEnabled",
			(BiConsumer<EventSpeakers, String>)
				EventSpeakers::setIsNotifEnabled);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		_columnBitmask |= UUID_COLUMN_BITMASK;

		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@JSON
	@Override
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		_id = id;
	}

	@JSON
	@Override
	public String getPosition() {
		if (_position == null) {
			return "";
		}
		else {
			return _position;
		}
	}

	@Override
	public void setPosition(String position) {
		_position = position;
	}

	@JSON
	@Override
	public Blob getSpeakerImage() {
		if (_speakerImageBlobModel == null) {
			try {
				_speakerImageBlobModel =
					EventSpeakersLocalServiceUtil.getSpeakerImageBlobModel(
						getPrimaryKey());
			}
			catch (Exception e) {
			}
		}

		Blob blob = null;

		if (_speakerImageBlobModel != null) {
			blob = _speakerImageBlobModel.getSpeakerImageBlob();
		}

		return blob;
	}

	@Override
	public void setSpeakerImage(Blob speakerImage) {
		if (_speakerImageBlobModel == null) {
			_speakerImageBlobModel = new EventSpeakersSpeakerImageBlobModel(
				getPrimaryKey(), speakerImage);
		}
		else {
			_speakerImageBlobModel.setSpeakerImageBlob(speakerImage);
		}
	}

	@JSON
	@Override
	public String getSpeakerImageString() {
		if (_speakerImageString == null) {
			return "";
		}
		else {
			return _speakerImageString;
		}
	}

	@Override
	public void setSpeakerImageString(String speakerImageString) {
		_speakerImageString = speakerImageString;
	}

	@JSON
	@Override
	public String getNationality() {
		if (_nationality == null) {
			return "";
		}
		else {
			return _nationality;
		}
	}

	@Override
	public void setNationality(String nationality) {
		_nationality = nationality;
	}

	@JSON
	@Override
	public String getEmail() {
		if (_email == null) {
			return "";
		}
		else {
			return _email;
		}
	}

	@Override
	public void setEmail(String email) {
		_email = email;
	}

	@JSON
	@Override
	public String getFirstName() {
		if (_firstName == null) {
			return "";
		}
		else {
			return _firstName;
		}
	}

	@Override
	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	@JSON
	@Override
	public String getUserId() {
		if (_userId == null) {
			return "";
		}
		else {
			return _userId;
		}
	}

	@Override
	public void setUserId(String userId) {
		_userId = userId;
	}

	@JSON
	@Override
	public String getLastName() {
		if (_lastName == null) {
			return "";
		}
		else {
			return _lastName;
		}
	}

	@Override
	public void setLastName(String lastName) {
		_lastName = lastName;
	}

	@JSON
	@Override
	public String getIsNotificationSent() {
		if (_isNotificationSent == null) {
			return "";
		}
		else {
			return _isNotificationSent;
		}
	}

	@Override
	public void setIsNotificationSent(String isNotificationSent) {
		_isNotificationSent = isNotificationSent;
	}

	@JSON
	@Override
	public String getEventId() {
		if (_eventId == null) {
			return "";
		}
		else {
			return _eventId;
		}
	}

	@Override
	public void setEventId(String eventId) {
		_eventId = eventId;
	}

	@JSON
	@Override
	public String getIsNotifEnabled() {
		if (_isNotifEnabled == null) {
			return "";
		}
		else {
			return _isNotifEnabled;
		}
	}

	@Override
	public void setIsNotifEnabled(String isNotifEnabled) {
		_isNotifEnabled = isNotifEnabled;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, EventSpeakers.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public EventSpeakers toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, EventSpeakers>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		EventSpeakersImpl eventSpeakersImpl = new EventSpeakersImpl();

		eventSpeakersImpl.setUuid(getUuid());
		eventSpeakersImpl.setId(getId());
		eventSpeakersImpl.setPosition(getPosition());
		eventSpeakersImpl.setSpeakerImageString(getSpeakerImageString());
		eventSpeakersImpl.setNationality(getNationality());
		eventSpeakersImpl.setEmail(getEmail());
		eventSpeakersImpl.setFirstName(getFirstName());
		eventSpeakersImpl.setUserId(getUserId());
		eventSpeakersImpl.setLastName(getLastName());
		eventSpeakersImpl.setIsNotificationSent(getIsNotificationSent());
		eventSpeakersImpl.setEventId(getEventId());
		eventSpeakersImpl.setIsNotifEnabled(getIsNotifEnabled());

		eventSpeakersImpl.resetOriginalValues();

		return eventSpeakersImpl;
	}

	@Override
	public int compareTo(EventSpeakers eventSpeakers) {
		long primaryKey = eventSpeakers.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EventSpeakers)) {
			return false;
		}

		EventSpeakers eventSpeakers = (EventSpeakers)obj;

		long primaryKey = eventSpeakers.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _entityCacheEnabled;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _finderCacheEnabled;
	}

	@Override
	public void resetOriginalValues() {
		EventSpeakersModelImpl eventSpeakersModelImpl = this;

		eventSpeakersModelImpl._originalUuid = eventSpeakersModelImpl._uuid;

		eventSpeakersModelImpl._speakerImageBlobModel = null;

		eventSpeakersModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<EventSpeakers> toCacheModel() {
		EventSpeakersCacheModel eventSpeakersCacheModel =
			new EventSpeakersCacheModel();

		eventSpeakersCacheModel.uuid = getUuid();

		String uuid = eventSpeakersCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			eventSpeakersCacheModel.uuid = null;
		}

		eventSpeakersCacheModel.id = getId();

		eventSpeakersCacheModel.position = getPosition();

		String position = eventSpeakersCacheModel.position;

		if ((position != null) && (position.length() == 0)) {
			eventSpeakersCacheModel.position = null;
		}

		eventSpeakersCacheModel.speakerImageString = getSpeakerImageString();

		String speakerImageString = eventSpeakersCacheModel.speakerImageString;

		if ((speakerImageString != null) &&
			(speakerImageString.length() == 0)) {

			eventSpeakersCacheModel.speakerImageString = null;
		}

		eventSpeakersCacheModel.nationality = getNationality();

		String nationality = eventSpeakersCacheModel.nationality;

		if ((nationality != null) && (nationality.length() == 0)) {
			eventSpeakersCacheModel.nationality = null;
		}

		eventSpeakersCacheModel.email = getEmail();

		String email = eventSpeakersCacheModel.email;

		if ((email != null) && (email.length() == 0)) {
			eventSpeakersCacheModel.email = null;
		}

		eventSpeakersCacheModel.firstName = getFirstName();

		String firstName = eventSpeakersCacheModel.firstName;

		if ((firstName != null) && (firstName.length() == 0)) {
			eventSpeakersCacheModel.firstName = null;
		}

		eventSpeakersCacheModel.userId = getUserId();

		String userId = eventSpeakersCacheModel.userId;

		if ((userId != null) && (userId.length() == 0)) {
			eventSpeakersCacheModel.userId = null;
		}

		eventSpeakersCacheModel.lastName = getLastName();

		String lastName = eventSpeakersCacheModel.lastName;

		if ((lastName != null) && (lastName.length() == 0)) {
			eventSpeakersCacheModel.lastName = null;
		}

		eventSpeakersCacheModel.isNotificationSent = getIsNotificationSent();

		String isNotificationSent = eventSpeakersCacheModel.isNotificationSent;

		if ((isNotificationSent != null) &&
			(isNotificationSent.length() == 0)) {

			eventSpeakersCacheModel.isNotificationSent = null;
		}

		eventSpeakersCacheModel.eventId = getEventId();

		String eventId = eventSpeakersCacheModel.eventId;

		if ((eventId != null) && (eventId.length() == 0)) {
			eventSpeakersCacheModel.eventId = null;
		}

		eventSpeakersCacheModel.isNotifEnabled = getIsNotifEnabled();

		String isNotifEnabled = eventSpeakersCacheModel.isNotifEnabled;

		if ((isNotifEnabled != null) && (isNotifEnabled.length() == 0)) {
			eventSpeakersCacheModel.isNotifEnabled = null;
		}

		return eventSpeakersCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", id=");
		sb.append(getId());
		sb.append(", position=");
		sb.append(getPosition());
		sb.append(", speakerImageString=");
		sb.append(getSpeakerImageString());
		sb.append(", nationality=");
		sb.append(getNationality());
		sb.append(", email=");
		sb.append(getEmail());
		sb.append(", firstName=");
		sb.append(getFirstName());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", lastName=");
		sb.append(getLastName());
		sb.append(", isNotificationSent=");
		sb.append(getIsNotificationSent());
		sb.append(", eventId=");
		sb.append(getEventId());
		sb.append(", isNotifEnabled=");
		sb.append(getIsNotifEnabled());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("basic.model.EventSpeakers");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>position</column-name><column-value><![CDATA[");
		sb.append(getPosition());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>speakerImageString</column-name><column-value><![CDATA[");
		sb.append(getSpeakerImageString());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nationality</column-name><column-value><![CDATA[");
		sb.append(getNationality());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>email</column-name><column-value><![CDATA[");
		sb.append(getEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>firstName</column-name><column-value><![CDATA[");
		sb.append(getFirstName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastName</column-name><column-value><![CDATA[");
		sb.append(getLastName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isNotificationSent</column-name><column-value><![CDATA[");
		sb.append(getIsNotificationSent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>eventId</column-name><column-value><![CDATA[");
		sb.append(getEventId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isNotifEnabled</column-name><column-value><![CDATA[");
		sb.append(getIsNotifEnabled());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, EventSpeakers>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private String _uuid;
	private String _originalUuid;
	private long _id;
	private String _position;
	private EventSpeakersSpeakerImageBlobModel _speakerImageBlobModel;
	private String _speakerImageString;
	private String _nationality;
	private String _email;
	private String _firstName;
	private String _userId;
	private String _lastName;
	private String _isNotificationSent;
	private String _eventId;
	private String _isNotifEnabled;
	private long _columnBitmask;
	private EventSpeakers _escapedModel;

}