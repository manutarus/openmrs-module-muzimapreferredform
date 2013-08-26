/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
package org.openmrs.module.muzimapreferredform.web.controller;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.context.Context;
import org.openmrs.module.muzimapreferredform.PreferredFormAttributeType;
import org.openmrs.module.muzimapreferredform.api.PreferredFormService;
import org.openmrs.module.muzimapreferredform.web.utils.WebConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * The main controller.
 */
@Controller
@RequestMapping(value = "/module/muzimapreferredform/attributeType.json")
public class PreferredFormAttributeTypeController {
    private final Log log = LogFactory.getLog(getClass());
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public Map<String, Object> view(final @RequestParam(value = "uuid") String uuid) {
        PreferredFormService preferredFormService = Context.getService(PreferredFormService.class);
        PreferredFormAttributeType attributeTypeData = preferredFormService.getPreferredFormAttributeTypeByUuid(uuid);
        return WebConverter.convert(attributeTypeData);
    }
    @RequestMapping(method = RequestMethod.POST)
    public void save(final @RequestBody Map<String, Object> map) {
        String uuid = (String) map.get("uuid");
        String name = (String) map.get("name");
        String description = (String) map.get("description");
        PreferredFormService preferredFormService = Context.getService(PreferredFormService.class);
        if (StringUtils.isNotBlank(uuid)) {
            PreferredFormAttributeType preferredFormAttributeTypeData = preferredFormService.getPreferredFormAttributeTypeByUuid(uuid);
            if (StringUtils.isNotBlank(name) || StringUtils.isNotBlank(description)) {
                preferredFormAttributeTypeData.setName(name);
                preferredFormAttributeTypeData.setDescription(description);
                System.out.println(preferredFormAttributeTypeData);
                preferredFormService.savePreferredFormAttributeType(preferredFormAttributeTypeData);
            } else {
                preferredFormAttributeTypeData.setRetired(true);
                preferredFormAttributeTypeData.setRetireReason("form attribute type out of date");
                preferredFormService.savePreferredFormAttributeType(preferredFormAttributeTypeData);
            }
        }else {
            PreferredFormAttributeType preferredFormAttributeType = new PreferredFormAttributeType();
            preferredFormAttributeType.setName(name);
            preferredFormAttributeType.setDescription(description);
            preferredFormService.savePreferredFormAttributeType(preferredFormAttributeType);
        }
    }
}