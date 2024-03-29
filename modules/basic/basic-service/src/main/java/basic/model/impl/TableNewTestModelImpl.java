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

import basic.model.TableNewTest;
import basic.model.TableNewTestImageBlobModel;
import basic.model.TableNewTestModel;
import basic.model.TableNewTestSoap;

import basic.service.TableNewTestLocalServiceUtil;

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
 * The base model implementation for the TableNewTest service. Represents a row in the &quot;TableNewTest&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>TableNewTestModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link TableNewTestImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TableNewTestImpl
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class TableNewTestModelImpl
	extends BaseModelImpl<TableNewTest> implements TableNewTestModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a table new test model instance should use the <code>TableNewTest</code> interface instead.
	 */
	public static final String TABLE_NAME = "TableNewTest";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"id_", Types.BIGINT},
		{"Title", Types.VARCHAR}, {"Description", Types.VARCHAR},
		{"Image", Types.BLOB}, {"eventId", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("id_", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("Title", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("Description", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("Image", Types.BLOB);
		TABLE_COLUMNS_MAP.put("eventId", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table TableNewTest (uuid_ VARCHAR(75) null,id_ LONG not null primary key,Title VARCHAR(75) null,Description VARCHAR(75) null,Image BLOB,eventId VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP = "drop table TableNewTest";

	public static final String ORDER_BY_JPQL = " ORDER BY tableNewTest.id ASC";

	public static final String ORDER_BY_SQL = " ORDER BY TableNewTest.id_ ASC";

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
	public static TableNewTest toModel(TableNewTestSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		TableNewTest model = new TableNewTestImpl();

		model.setUuid(soapModel.getUuid());
		model.setId(soapModel.getId());
		model.setTitle(soapModel.getTitle());
		model.setDescription(soapModel.getDescription());
		model.setImage(soapModel.getImage());
		model.setEventId(soapModel.getEventId());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<TableNewTest> toModels(TableNewTestSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<TableNewTest> models = new ArrayList<TableNewTest>(
			soapModels.length);

		for (TableNewTestSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public TableNewTestModelImpl() {
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
		return TableNewTest.class;
	}

	@Override
	public String getModelClassName() {
		return TableNewTest.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<TableNewTest, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<TableNewTest, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<TableNewTest, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((TableNewTest)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<TableNewTest, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<TableNewTest, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(TableNewTest)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<TableNewTest, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<TableNewTest, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, TableNewTest>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			TableNewTest.class.getClassLoader(), TableNewTest.class,
			ModelWrapper.class);

		try {
			Constructor<TableNewTest> constructor =
				(Constructor<TableNewTest>)proxyClass.getConstructor(
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

	private static final Map<String, Function<TableNewTest, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<TableNewTest, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<TableNewTest, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<TableNewTest, Object>>();
		Map<String, BiConsumer<TableNewTest, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<TableNewTest, ?>>();

		attributeGetterFunctions.put("uuid", TableNewTest::getUuid);
		attributeSetterBiConsumers.put(
			"uuid", (BiConsumer<TableNewTest, String>)TableNewTest::setUuid);
		attributeGetterFunctions.put("id", TableNewTest::getId);
		attributeSetterBiConsumers.put(
			"id", (BiConsumer<TableNewTest, Long>)TableNewTest::setId);
		attributeGetterFunctions.put("Title", TableNewTest::getTitle);
		attributeSetterBiConsumers.put(
			"Title", (BiConsumer<TableNewTest, String>)TableNewTest::setTitle);
		attributeGetterFunctions.put(
			"Description", TableNewTest::getDescription);
		attributeSetterBiConsumers.put(
			"Description",
			(BiConsumer<TableNewTest, String>)TableNewTest::setDescription);
		attributeGetterFunctions.put("Image", TableNewTest::getImage);
		attributeSetterBiConsumers.put(
			"Image", (BiConsumer<TableNewTest, Blob>)TableNewTest::setImage);
		attributeGetterFunctions.put("eventId", TableNewTest::getEventId);
		attributeSetterBiConsumers.put(
			"eventId",
			(BiConsumer<TableNewTest, String>)TableNewTest::setEventId);

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
	public String getTitle() {
		if (_Title == null) {
			return "";
		}
		else {
			return _Title;
		}
	}

	@Override
	public void setTitle(String Title) {
		_Title = Title;
	}

	@JSON
	@Override
	public String getDescription() {
		if (_Description == null) {
			return "";
		}
		else {
			return _Description;
		}
	}

	@Override
	public void setDescription(String Description) {
		_Description = Description;
	}

	@JSON
	@Override
	public Blob getImage() {
		if (_ImageBlobModel == null) {
			try {
				_ImageBlobModel =
					TableNewTestLocalServiceUtil.getImageBlobModel(
						getPrimaryKey());
			}
			catch (Exception e) {
			}
		}

		Blob blob = null;

		if (_ImageBlobModel != null) {
			blob = _ImageBlobModel.getImageBlob();
		}

		return blob;
	}

	@Override
	public void setImage(Blob Image) {
		if (_ImageBlobModel == null) {
			_ImageBlobModel = new TableNewTestImageBlobModel(
				getPrimaryKey(), Image);
		}
		else {
			_ImageBlobModel.setImageBlob(Image);
		}
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

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, TableNewTest.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public TableNewTest toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, TableNewTest>
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
		TableNewTestImpl tableNewTestImpl = new TableNewTestImpl();

		tableNewTestImpl.setUuid(getUuid());
		tableNewTestImpl.setId(getId());
		tableNewTestImpl.setTitle(getTitle());
		tableNewTestImpl.setDescription(getDescription());
		tableNewTestImpl.setEventId(getEventId());

		tableNewTestImpl.resetOriginalValues();

		return tableNewTestImpl;
	}

	@Override
	public int compareTo(TableNewTest tableNewTest) {
		long primaryKey = tableNewTest.getPrimaryKey();

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

		if (!(obj instanceof TableNewTest)) {
			return false;
		}

		TableNewTest tableNewTest = (TableNewTest)obj;

		long primaryKey = tableNewTest.getPrimaryKey();

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
		TableNewTestModelImpl tableNewTestModelImpl = this;

		tableNewTestModelImpl._originalUuid = tableNewTestModelImpl._uuid;

		tableNewTestModelImpl._ImageBlobModel = null;

		tableNewTestModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<TableNewTest> toCacheModel() {
		TableNewTestCacheModel tableNewTestCacheModel =
			new TableNewTestCacheModel();

		tableNewTestCacheModel.uuid = getUuid();

		String uuid = tableNewTestCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			tableNewTestCacheModel.uuid = null;
		}

		tableNewTestCacheModel.id = getId();

		tableNewTestCacheModel.Title = getTitle();

		String Title = tableNewTestCacheModel.Title;

		if ((Title != null) && (Title.length() == 0)) {
			tableNewTestCacheModel.Title = null;
		}

		tableNewTestCacheModel.Description = getDescription();

		String Description = tableNewTestCacheModel.Description;

		if ((Description != null) && (Description.length() == 0)) {
			tableNewTestCacheModel.Description = null;
		}

		tableNewTestCacheModel.eventId = getEventId();

		String eventId = tableNewTestCacheModel.eventId;

		if ((eventId != null) && (eventId.length() == 0)) {
			tableNewTestCacheModel.eventId = null;
		}

		return tableNewTestCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", id=");
		sb.append(getId());
		sb.append(", Title=");
		sb.append(getTitle());
		sb.append(", Description=");
		sb.append(getDescription());
		sb.append(", eventId=");
		sb.append(getEventId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("basic.model.TableNewTest");
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
			"<column><column-name>Title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>eventId</column-name><column-value><![CDATA[");
		sb.append(getEventId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, TableNewTest>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private String _uuid;
	private String _originalUuid;
	private long _id;
	private String _Title;
	private String _Description;
	private TableNewTestImageBlobModel _ImageBlobModel;
	private String _eventId;
	private long _columnBitmask;
	private TableNewTest _escapedModel;

}