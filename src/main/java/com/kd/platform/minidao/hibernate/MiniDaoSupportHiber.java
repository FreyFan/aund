package com.kd.platform.minidao.hibernate;

import java.io.Serializable;
import java.util.List;

/**
 * <b>Application name:</b> MiniDaoSupportHiber.java <br>
 * <b>Application describing:支持Hbiernate实体维护 MiniDao自动生成SQL </b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-6-10 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public abstract interface MiniDaoSupportHiber<T> {
    public abstract void deleteByHiber(T paramT);

    public abstract <T> void deleteByIdHiber(Class<?> paramClass, Serializable paramSerializable);

    public abstract <T> T getByEntityHiber(T paramT);

    public abstract <T> T getByIdHiber(Class<T> paramClass, Serializable paramSerializable);

    public abstract List<T> listByHiber(T paramT);

    public abstract void saveByHiber(T paramT);

    public abstract void updateByHiber(T paramT);
}
