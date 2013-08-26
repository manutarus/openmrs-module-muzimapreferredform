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
package org.openmrs.module.muzimapreferredform.api;

import org.openmrs.api.OpenmrsService;
import org.openmrs.module.muzimapreferredform.PreferredForm;
import org.openmrs.module.muzimapreferredform.PreferredFormAttributeType;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * This service exposes module's core functionality. It is a Spring managed bean which is configured in moduleApplicationContext.xml.
 * <p/>
 * It can be accessed only via Context:<br>
 * <code>
 * Context.getService(PreferredFormService.class).someMethod();
 * </code>
 *
 * @see org.openmrs.api.context.Context
 */
@Transactional
public interface PreferredFormService extends OpenmrsService {

    /**
     * Service method to save
     * @param preferredForm
     * @return
     */
    PreferredForm savePreferredForm(final PreferredForm preferredForm);

    PreferredFormAttributeType savePreferredFormAttributeType(final PreferredFormAttributeType preferredFormAttributeType);

    PreferredForm getPreferredForm(final Integer id);

    PreferredForm getPreferredFormByUuid(final String uuid);

    List<PreferredForm> getAllPreferredForm();

    List<PreferredForm> getPreferredFormByTag(final String tag);

    PreferredFormAttributeType getPreferredFormAttributeTypeByUuid(final String uuid);

    List<PreferredFormAttributeType> getAllPreferredFormAttributeTypes(final String search, final Integer pageNumber, final Integer pageSize);

    Number countFormAttributes();
}