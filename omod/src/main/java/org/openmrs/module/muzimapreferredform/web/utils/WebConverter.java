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
package org.openmrs.module.muzimapreferredform.web.utils;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.codehaus.jackson.map.ObjectMapper;
import org.openmrs.api.context.Context;
import org.openmrs.module.muzimapreferredform.PreferredForm;
import org.openmrs.module.muzimapreferredform.PreferredFormAttribute;
import org.openmrs.module.muzimapreferredform.PreferredFormAttributeType;
import org.openmrs.module.muzimapreferredform.PreferredFormTag;
import org.openmrs.module.muzimapreferredform.api.PreferredFormService;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * TODO: Write brief description about the class here.
 */
public class WebConverter {

    public static Map<String, Object> convert(final PreferredForm preferredForm) {
        PreferredFormService preferredFormService = Context.getService(PreferredFormService.class);
        Map<String, Object> converted = new HashMap<String, Object>();
        if (preferredForm != null) {
            JSONArray list = new JSONArray();
            converted.put("uuid", preferredForm.getUuid());
            converted.put("name", preferredForm.getName());
            converted.put("cohortDefinition", preferredForm.getDefinition());
            converted.put("attributeCount", preferredForm.getActiveAttributes().size());

            for (PreferredFormTag s : preferredForm.getTags()) {
                list.add(s.getName());
            }

            converted.put("tags",list);

        }
        return converted;
    }

    public static Map<String, Object> convert(final PreferredFormAttribute preferredFormAttribute) {
        Map<String, Object> converted = new HashMap<String, Object>();
        if (preferredFormAttribute != null) {
            converted.put("uuid", preferredFormAttribute.getUuid());
        }
        return converted;
    }

    public static Map<String, Object> convert(final PreferredFormAttributeType preferredFormAttributeType) {
        Map<String, Object> converted = new HashMap<String, Object>();
        if (preferredFormAttributeType != null) {
            converted.put("uuid", preferredFormAttributeType.getUuid());
        }
        return converted;
    }

    public static Map<String, Object> convert(final PreferredFormTag preferredFormTag) {
        Map<String, Object> converted = new HashMap<String, Object>();
        if (preferredFormTag != null) {
            converted.put("uuid", preferredFormTag.getUuid());
        }
        return converted;
    }

}
