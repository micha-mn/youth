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
 * The Blob model class for lazy loading the pictureBlob column in Journey.
 *
 * @author Brian Wing Shun Chan
 * @see Journey
 * @generated
 */
@ProviderType
public class JourneyPictureBlobBlobModel {

	public JourneyPictureBlobBlobModel() {
	}

	public JourneyPictureBlobBlobModel(long journeyId) {
		_journeyId = journeyId;
	}

	public JourneyPictureBlobBlobModel(long journeyId, Blob pictureBlobBlob) {
		_journeyId = journeyId;
		_pictureBlobBlob = pictureBlobBlob;
	}

	public long getJourneyId() {
		return _journeyId;
	}

	public void setJourneyId(long journeyId) {
		_journeyId = journeyId;
	}

	public Blob getPictureBlobBlob() {
		return _pictureBlobBlob;
	}

	public void setPictureBlobBlob(Blob pictureBlobBlob) {
		_pictureBlobBlob = pictureBlobBlob;
	}

	private long _journeyId;
	private Blob _pictureBlobBlob;

}