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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.context.Context;
import org.openmrs.module.muzimapreferredform.PreferredFormAttributeType;
import org.openmrs.module.muzimapreferredform.api.PreferredFormService;
import org.openmrs.module.muzimapreferredform.web.utils.WebConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The main controller.
 */
@Controller
@RequestMapping(value = "/module/muzimapreferredform/attributeTypes.json")
public class PreferredFormAttributeTypesController {

    private final Log log = LogFactory.getLog(getClass());

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public Map<String, Object> view(final @RequestParam(value = "search") String search,
                                    final @RequestParam(value = "pageNumber") Integer pageNumber,
                                    final @RequestParam(value = "pageSize") Integer pageSize) {

        Map<String, Object> response = new HashMap<String, Object>();
        PreferredFormService preferredFormService = Context.getService(PreferredFormService.class);
        int pages = (preferredFormService.countFormAttributes().intValue() + pageSize - 1)/ pageSize;
        List<Object> objects = new ArrayList<Object>();
        for (PreferredFormAttributeType preferredFormAttributeTypeList : preferredFormService.getAllPreferredFormAttributeTypes(search,pageNumber, pageSize)) {
            objects.add(WebConverter.convert(preferredFormAttributeTypeList));
        }
        response.put("pages", pages);
        response.put("objects", objects);
        return response;

    }
}