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

import java.sql.Blob;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The Blob model class for lazy loading the data column in ImageCalendar.
 *
 * @author Brian Wing Shun Chan
 * @see ImageCalendar
 * @generated
 */
@ProviderType
public class ImageCalendarDataBlobModel {

	public ImageCalendarDataBlobModel() {
	}

	public ImageCalendarDataBlobModel(long Id) {
		_Id = Id;
	}

	public ImageCalendarDataBlobModel(long Id, Blob dataBlob) {
		_Id = Id;
		_dataBlob = dataBlob;
	}

	public long getId() {
		return _Id;
	}

	public void setId(long Id) {
		_Id = Id;
	}

	public Blob getDataBlob() {
		return _dataBlob;
	}

	public void setDataBlob(Blob dataBlob) {
		_dataBlob = dataBlob;
	}

	private long _Id;
	private Blob _dataBlob;

}