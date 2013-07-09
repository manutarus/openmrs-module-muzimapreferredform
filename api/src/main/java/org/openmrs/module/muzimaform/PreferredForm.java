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

import org.openmrs.BaseCustomizableData;
import org.openmrs.BaseOpenmrsMetadata;
import org.openmrs.BaseOpenmrsObject;
import org.openmrs.module.reporting.cohort.definition.CohortDefinition;

import java.io.Serializable;
import java.util.Set;

/**
 * It is a model class. It should extend either {@link BaseOpenmrsObject} or {@link BaseOpenmrsMetadata}.
 */
public class PreferredForm extends BaseCustomizableData<PreferredFormAttribute> implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private CohortDefinition definition;

    private Set<PreferredFormTag> tags;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public CohortDefinition getDefinition() {
        return definition;
    }

    public void setDefinition(final CohortDefinition definition) {
        this.definition = definition;
    }

    public Set<PreferredFormTag> getTags() {
        return tags;
    }

    public void setTags(final Set<PreferredFormTag> tags) {
        this.tags = tags;
    }
}