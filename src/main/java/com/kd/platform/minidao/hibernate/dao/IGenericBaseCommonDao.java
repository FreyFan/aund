package com.kd.platform.minidao.hibernate.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;

/**
 * 类描述：DAO层泛型基类接口
 * @author: Frey.Fan
 * @date： 日期：2012-12-8 时间：下午05:37:33
 * @version 1.0
 */
public abstract interface IGenericBaseCommonDao {
    public abstract <T> void delete(T paramT);

    public abstract <T> void deleteEntityById(Class<?> paramClass, Serializable paramSerializable);

    public abstract <T> T findUniqueByProperty(Class<T> paramClass, String paramString, Object paramObject);

    public abstract <T> T get(Class<T> paramClass, Serializable paramSerializable);

    public abstract <T> T get(T paramT);

    public abstract Session getSession();

    public abstract <T> List<T> loadAll(T paramT);

    public abstract <T> void save(T paramT);

    public abstract <T> void saveOrUpdate(T paramT);
}
