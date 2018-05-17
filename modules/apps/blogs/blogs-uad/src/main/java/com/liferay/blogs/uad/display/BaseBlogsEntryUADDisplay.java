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

package com.liferay.blogs.uad.display;

import com.liferay.blogs.model.BlogsEntry;
import com.liferay.blogs.service.BlogsEntryLocalService;
import com.liferay.blogs.uad.constants.BlogsUADConstants;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;

import com.liferay.user.associated.data.display.BaseModelUADDisplay;

import org.osgi.service.component.annotations.Reference;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the base implementation for the BlogsEntry UAD display.
 *
 * <p>
 * This implementation exists only as a container for the default methods
 * generated by ServiceBuilder. All custom methods should be put in
 * {@link BlogsEntryUADDisplay}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class BaseBlogsEntryUADDisplay extends BaseModelUADDisplay<BlogsEntry> {
	@Override
	public BlogsEntry get(Serializable primaryKey) throws PortalException {
		return blogsEntryLocalService.getBlogsEntry(Long.valueOf(
				primaryKey.toString()));
	}

	@Override
	public String[] getDisplayFieldNames() {
		return new String[] {
			"title", "subtitle", "urlTitle", "description", "content",
			"smallImage", "smallImageId"
		};
	}

	@Override
	public Class<BlogsEntry> getTypeClass() {
		return BlogsEntry.class;
	}

	@Override
	protected long doCount(DynamicQuery dynamicQuery) {
		return blogsEntryLocalService.dynamicQueryCount(dynamicQuery);
	}

	@Override
	protected DynamicQuery doGetDynamicQuery() {
		return blogsEntryLocalService.dynamicQuery();
	}

	@Override
	protected List<BlogsEntry> doGetRange(DynamicQuery dynamicQuery, int start,
		int end) {
		return blogsEntryLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	@Override
	protected String[] doGetUserIdFieldNames() {
		return BlogsUADConstants.USER_ID_FIELD_NAMES_BLOGS_ENTRY;
	}

	@Reference
	protected BlogsEntryLocalService blogsEntryLocalService;
}