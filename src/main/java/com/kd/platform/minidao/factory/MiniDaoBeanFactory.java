package com.kd.platform.minidao.factory;

import java.lang.reflect.Proxy;
import com.kd.platform.minidao.aop.MiniDaoHandler;
import org.springframework.beans.factory.FactoryBean;

/**
 * <b>Application name:</b> MiniDaoBeanFactory.java <br>
 * <b>Application describing: </b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-6-10 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class MiniDaoBeanFactory<T> implements FactoryBean<T> {
    private Class<T> daoInterface;

    private MiniDaoHandler proxy;

    public T getObject() throws Exception {
        return newInstance();
    }

    public Class<?> getObjectType() {
        return this.daoInterface;
    }

    public MiniDaoHandler getProxy() {
        return this.proxy;
    }

    public boolean isSingleton() {
        return true;
    }

    private T newInstance() {
        return (T) Proxy.newProxyInstance(this.daoInterface.getClassLoader(), new Class[] { this.daoInterface }, this.proxy);
    }

    public void setProxy(MiniDaoHandler proxy) {
        this.proxy = proxy;
    }

    public void setDaoInterface(Class<T> daoInterface) {
        this.daoInterface = daoInterface;
    }
}
