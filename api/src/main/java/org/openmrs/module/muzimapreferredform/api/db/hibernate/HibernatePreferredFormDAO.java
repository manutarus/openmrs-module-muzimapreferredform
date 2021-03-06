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
package org.openmrs.module.muzimapreferredform.api.db.hibernate;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.openmrs.module.muzimapreferredform.PreferredForm;
import org.openmrs.module.muzimapreferredform.api.db.PreferredFormDAO;

import java.util.List;

/**
 * It is a default implementation of  {@link PreferredFormDAO}.
 */
public class HibernatePreferredFormDAO implements PreferredFormDAO {
    protected final Log log = LogFactory.getLog(this.getClass());

    private SessionFactory sessionFactory;

    /**
     * @param sessionFactory the sessionFactory to set
     */
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * @return the sessionFactory
     */
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Override
    public PreferredForm savePreferredForm(final PreferredForm preferredForm) {
        getSessionFactory().getCurrentSession().saveOrUpdate(preferredForm);
        return preferredForm;
    }

    @Override
    public PreferredForm getPreferredForm(final Integer id) {
        return (PreferredForm) getSessionFactory().getCurrentSession().get(PreferredForm.class, id);
    }

    @Override
    public PreferredForm getPreferredFormByUuid(final String uuid) {
        Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(PreferredForm.class);
        criteria.add(Restrictions.eq("uuid", uuid));
        criteria.add(Restrictions.eq("voided", Boolean.FALSE));
        return (PreferredForm) criteria.uniqueResult();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<PreferredForm> getAllPreferredForm() {
        Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(PreferredForm.class);
        criteria.add(Restrictions.eq("voided", Boolean.FALSE));
        return criteria.list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<PreferredForm> getPreferredFormByTag(final String tag) {
        Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(PreferredForm.class);
        criteria.createAlias("tags", "tag");
        criteria.add(Restrictions.eq("tag.tag", tag));
        criteria.add(Restrictions.eq("voided", Boolean.FALSE));
        return criteria.list();
    }
}