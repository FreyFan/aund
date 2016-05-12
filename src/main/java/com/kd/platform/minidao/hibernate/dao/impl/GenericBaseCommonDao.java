package com.kd.platform.minidao.hibernate.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;
import com.kd.platform.minidao.hibernate.dao.IGenericBaseCommonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

/**
 * 类描述： DAO层泛型基类
 * @author: Frey.Fan
 * @date： 日期：2012-12-7 时间：上午10:16:48
 * @version 1.0
 */
public class GenericBaseCommonDao<T, PK extends Serializable> implements IGenericBaseCommonDao {
    private static final Logger logger = Logger.getLogger(GenericBaseCommonDao.class);

    @Autowired
    private SessionFactory sessionFactory;

    private <T> Criteria createCriteria(Class<T> entityClass, Criterion[] criterions) {
        Criteria criteria = getSession().createCriteria(entityClass);
        for (Criterion c : criterions) {
            criteria.add(c);
        }
        return criteria;
    }

    public <T> void delete(T entity) {
        try {
            getSession().delete(entity);
            getSession().flush();
            if (logger.isDebugEnabled()) logger.debug("删除成功," + entity.getClass().getName());
        } catch (RuntimeException e) {
            logger.error("删除异常", e);
            throw e;
        }
    }

    public <T> void deleteEntityById(Class<?> entityName, Serializable id) {
        delete(get(entityName, id));
        getSession().flush();
    }

    public <T> List<T> findByProperty(Class<T> entityClass, String propertyName, Object value) {
        Assert.hasText(propertyName);
        return createCriteria(entityClass, new Criterion[] { Restrictions.eq(propertyName, value) }).list();
    }

    public <T> T findUniqueByProperty(Class<T> entityClass, String propertyName, Object value) {
        Assert.hasText(propertyName);
        return (T) createCriteria(entityClass, new Criterion[] { Restrictions.eq(propertyName, value) }).uniqueResult();
    }

    public <T> T get(Class<T> entityClass, Serializable id) {
        return (T) getSession().get(entityClass, id);
    }

    public <T> T get(T entitie) {
        Criteria executableCriteria = getSession().createCriteria(entitie.getClass());
        executableCriteria.add(Example.create(entitie));
        if (executableCriteria.list().size() == 0) {
            return null;
        }
        return (T) executableCriteria.list().get(0);
    }

    public Session getSession() {
        try {
            return this.sessionFactory.getCurrentSession();
        } catch (Exception e) {
        }
        return this.sessionFactory.openSession();
    }

    public <T> List<T> loadAll(T entitie) {
        Criteria executableCriteria = getSession().createCriteria(entitie.getClass());
        executableCriteria.add(Example.create(entitie));
        return executableCriteria.list();
    }

    public <T> void save(T entity) {
        try {
            getSession().save(entity);
            getSession().flush();
            if (logger.isDebugEnabled()) logger.debug("保存实体成功," + entity.getClass().getName());
        } catch (RuntimeException e) {
            logger.error("保存实体异常", e);
            throw e;
        }
    }

    public <T> void saveOrUpdate(T entity) {
        try {
            getSession().saveOrUpdate(entity);
            getSession().flush();
            if (logger.isDebugEnabled()) logger.debug("添加或更新成功," + entity.getClass().getName());
        } catch (RuntimeException e) {
            logger.error("添加或更新异常", e);
            throw e;
        }
    }
}
