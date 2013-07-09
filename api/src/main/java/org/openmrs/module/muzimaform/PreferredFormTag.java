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
package org.openmrs.module.muzimaform;

import org.openmrs.BaseOpenmrsData;
import org.openmrs.BaseOpenmrsMetadata;
import org.openmrs.BaseOpenmrsObject;

import java.io.Serializable;

/**
 * It is a model class. It should extend either {@link org.openmrs.BaseOpenmrsObject} or {@link org.openmrs.BaseOpenmrsMetadata}.
 */
public class PreferredFormTag extends BaseOpenmrsMetadata implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getTag() {
        return getName();
    }

    public void setTag(final String tag) {
        this.setName(tag);
    }
}