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

import basic.model.EventAttributes;
import basic.model.EventAttributesModel;
import basic.model.EventAttributesSoap;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

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
 * The base model implementation for the EventAttributes service. Represents a row in the &quot;EventAttributes&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>EventAttributesModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link EventAttributesImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EventAttributesImpl
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class EventAttributesModelImpl
	extends BaseModelImpl<EventAttributes> implements EventAttributesModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a event attributes model instance should use the <code>EventAttributes</code> interface instead.
	 */
	public static final String TABLE_NAME = "EventAttributes";

	public static final Object[][] TABLE_COLUMNS = {
		{"id_", Types.BIGINT}, {"attributeNumber", Types.VARCHAR},
		{"attributeName", Types.VARCHAR}, {"eventId", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("id_", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("attributeNumber", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("attributeName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("eventId", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table EventAttributes (id_ LONG not null primary key,attributeNumber VARCHAR(75) null,attributeName VARCHAR(75) null,eventId VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP = "drop table EventAttributes";

	public static final String ORDER_BY_JPQL =
		" ORDER BY eventAttributes.id ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY EventAttributes.id_ ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

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
	public static EventAttributes toModel(EventAttributesSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		EventAttributes model = new EventAttributesImpl();

		model.setId(soapModel.getId());
		model.setAttributeNumber(soapModel.getAttributeNumber());
		model.setAttributeName(soapModel.getAttributeName());
		model.setEventId(soapModel.getEventId());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<EventAttributes> toModels(
		EventAttributesSoap[] soapModels) {

		if (soapModels == null) {
			return null;
		}

		List<EventAttributes> models = new ArrayList<EventAttributes>(
			soapModels.length);

		for (EventAttributesSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public EventAttributesModelImpl() {
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
		return EventAttributes.class;
	}

	@Override
	public String getModelClassName() {
		return EventAttributes.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<EventAttributes, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<EventAttributes, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<EventAttributes, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((EventAttributes)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<EventAttributes, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<EventAttributes, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(EventAttributes)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<EventAttributes, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<EventAttributes, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, EventAttributes>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			EventAttributes.class.getClassLoader(), EventAttributes.class,
			ModelWrapper.class);

		try {
			Constructor<EventAttributes> constructor =
				(Constructor<EventAttributes>)proxyClass.getConstructor(
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

	private static final Map<String, Function<EventAttributes, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<EventAttributes, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<EventAttributes, Object>>
			attributeGetterFunctions =
				new LinkedHashMap<String, Function<EventAttributes, Object>>();
		Map<String, BiConsumer<EventAttributes, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<EventAttributes, ?>>();

		attributeGetterFunctions.put("id", EventAttributes::getId);
		attributeSetterBiConsumers.put(
			"id", (BiConsumer<EventAttributes, Long>)EventAttributes::setId);
		attributeGetterFunctions.put(
			"attributeNumber", EventAttributes::getAttributeNumber);
		attributeSetterBiConsumers.put(
			"attributeNumber",
			(BiConsumer<EventAttributes, String>)
				EventAttributes::setAttributeNumber);
		attributeGetterFunctions.put(
			"attributeName", EventAttributes::getAttributeName);
		attributeSetterBiConsumers.put(
			"attributeName",
			(BiConsumer<EventAttributes, String>)
				EventAttributes::setAttributeName);
		attributeGetterFunctions.put("eventId", EventAttributes::getEventId);
		attributeSetterBiConsumers.put(
			"eventId",
			(BiConsumer<EventAttributes, String>)EventAttributes::setEventId);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
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
	public String getAttributeNumber() {
		if (_attributeNumber == null) {
			return "";
		}
		else {
			return _attributeNumber;
		}
	}

	@Override
	public void setAttributeNumber(String attributeNumber) {
		_attributeNumber = attributeNumber;
	}

	@JSON
	@Override
	public String getAttributeName() {
		if (_attributeName == null) {
			return "";
		}
		else {
			return _attributeName;
		}
	}

	@Override
	public void setAttributeName(String attributeName) {
		_attributeName = attributeName;
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

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, EventAttributes.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public EventAttributes toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, EventAttributes>
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
		EventAttributesImpl eventAttributesImpl = new EventAttributesImpl();

		eventAttributesImpl.setId(getId());
		eventAttributesImpl.setAttributeNumber(getAttributeNumber());
		eventAttributesImpl.setAttributeName(getAttributeName());
		eventAttributesImpl.setEventId(getEventId());

		eventAttributesImpl.resetOriginalValues();

		return eventAttributesImpl;
	}

	@Override
	public int compareTo(EventAttributes eventAttributes) {
		long primaryKey = eventAttributes.getPrimaryKey();

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

		if (!(obj instanceof EventAttributes)) {
			return false;
		}

		EventAttributes eventAttributes = (EventAttributes)obj;

		long primaryKey = eventAttributes.getPrimaryKey();

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
	}

	@Override
	public CacheModel<EventAttributes> toCacheModel() {
		EventAttributesCacheModel eventAttributesCacheModel =
			new EventAttributesCacheModel();

		eventAttributesCacheModel.id = getId();

		eventAttributesCacheModel.attributeNumber = getAttributeNumber();

		String attributeNumber = eventAttributesCacheModel.attributeNumber;

		if ((attributeNumber != null) && (attributeNumber.length() == 0)) {
			eventAttributesCacheModel.attributeNumber = null;
		}

		eventAttributesCacheModel.attributeName = getAttributeName();

		String attributeName = eventAttributesCacheModel.attributeName;

		if ((attributeName != null) && (attributeName.length() == 0)) {
			eventAttributesCacheModel.attributeName = null;
		}

		eventAttributesCacheModel.eventId = getEventId();

		String eventId = eventAttributesCacheModel.eventId;

		if ((eventId != null) && (eventId.length() == 0)) {
			eventAttributesCacheModel.eventId = null;
		}

		return eventAttributesCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<EventAttributes, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<EventAttributes, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<EventAttributes, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((EventAttributes)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<EventAttributes, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<EventAttributes, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<EventAttributes, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((EventAttributes)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, EventAttributes>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private long _id;
	private String _attributeNumber;
	private String _attributeName;
	private String _eventId;
	private EventAttributes _escapedModel;

}