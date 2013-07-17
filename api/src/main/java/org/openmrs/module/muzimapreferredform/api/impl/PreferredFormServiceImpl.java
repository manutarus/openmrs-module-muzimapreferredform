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
package org.openmrs.module.muzimapreferredform.api.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.muzimapreferredform.PreferredForm;
import org.openmrs.module.muzimapreferredform.api.PreferredFormService;
import org.openmrs.module.muzimapreferredform.api.db.PreferredFormDAO;

import java.util.List;

/**
 * It is a default implementation of {@link PreferredFormService}.
 */
public class PreferredFormServiceImpl extends BaseOpenmrsService implements PreferredFormService {

    protected final Log log = LogFactory.getLog(this.getClass());

    private PreferredFormDAO dao;

    /**
     * @param dao the dao to set
     */
    public void setDao(PreferredFormDAO dao) {
        this.dao = dao;
    }

    /**
     * @return the dao
     */
    public PreferredFormDAO getDao() {
        return dao;
    }

    @Override
    public PreferredForm savePreferredForm(final PreferredForm preferredForm) {
        return dao.savePreferredForm(preferredForm);
    }

    @Override
    public PreferredForm getPreferredForm(final Integer id) {
        return dao.getPreferredForm(id);
    }

    @Override
    public PreferredForm getPreferredFormByUuid(final String uuid) {
        return dao.getPreferredFormByUuid(uuid);
    }

    @Override
    public List<PreferredForm> getAllPreferredForm() {
        return dao.getAllPreferredForm();
    }

    @Override
    public List<PreferredForm> getPreferredFormByTag(final String tag) {
        return dao.getPreferredFormByTag(tag);
    }
}