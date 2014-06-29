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

package com.liferay.portal.servlet;

import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.util.PortletKeys;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Carlos Sierra Andrés
 * @author Raymond Augé
 */
public class ModulePathContainerTest {

	@Test
	public void testModulePathWithNoContext() {
		String modulePath = "/js/javascript.js";

		Assert.assertEquals(
			PortletKeys.PORTAL, ComboServlet.getModulePortletId(modulePath));
		Assert.assertEquals(
			"/js/javascript.js", ComboServlet.getResourcePath(modulePath));
	}

	@Test
	public void testModulePathWithPortletId() {
		String modulePath = PortletKeys.ACTIVITIES + ":/js/javascript.js";

		Assert.assertEquals(
			PortletKeys.ACTIVITIES,
			ComboServlet.getModulePortletId(modulePath));
		Assert.assertEquals(
			"/js/javascript.js", ComboServlet.getResourcePath(modulePath));
	}

	@Test
	public void testModulePathWithPortletIdAndNoResource() {
		String modulePath = PortletKeys.ACTIVITIES + ":";

		Assert.assertEquals(
			PortletKeys.ACTIVITIES,
			ComboServlet.getModulePortletId(modulePath));
		Assert.assertEquals(
			StringPool.BLANK, ComboServlet.getResourcePath(modulePath));
	}

}