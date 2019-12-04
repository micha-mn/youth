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

import java.sql.Blob;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the TableNewTest service. Represents a row in the &quot;TableNewTest&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>basic.model.impl.TableNewTestModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>basic.model.impl.TableNewTestImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TableNewTest
 * @generated
 */
@ProviderType
public interface TableNewTestModel extends BaseModel<TableNewTest> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a table new test model instance should use the {@link TableNewTest} interface instead.
	 */

	/**
	 * Returns the primary key of this table new test.
	 *
	 * @return the primary key of this table new test
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this table new test.
	 *
	 * @param primaryKey the primary key of this table new test
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this table new test.
	 *
	 * @return the uuid of this table new test
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this table new test.
	 *
	 * @param uuid the uuid of this table new test
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the ID of this table new test.
	 *
	 * @return the ID of this table new test
	 */
	public long getId();

	/**
	 * Sets the ID of this table new test.
	 *
	 * @param id the ID of this table new test
	 */
	public void setId(long id);

	/**
	 * Returns the title of this table new test.
	 *
	 * @return the title of this table new test
	 */
	@AutoEscape
	public String getTitle();

	/**
	 * Sets the title of this table new test.
	 *
	 * @param Title the title of this table new test
	 */
	public void setTitle(String Title);

	/**
	 * Returns the description of this table new test.
	 *
	 * @return the description of this table new test
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this table new test.
	 *
	 * @param Description the description of this table new test
	 */
	public void setDescription(String Description);

	/**
	 * Returns the image of this table new test.
	 *
	 * @return the image of this table new test
	 */
	public Blob getImage();

	/**
	 * Sets the image of this table new test.
	 *
	 * @param Image the image of this table new test
	 */
	public void setImage(Blob Image);

	/**
	 * Returns the event ID of this table new test.
	 *
	 * @return the event ID of this table new test
	 */
	@AutoEscape
	public String getEventId();

	/**
	 * Sets the event ID of this table new test.
	 *
	 * @param eventId the event ID of this table new test
	 */
	public void setEventId(String eventId);

}