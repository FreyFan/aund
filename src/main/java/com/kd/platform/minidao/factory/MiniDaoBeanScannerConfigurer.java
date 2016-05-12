/*******************************************************************************
 * @(#)MiniDaoBeanScannerConfigurer.java 2015-6-9
 *
 * Copyright 2015 Frey.Fan. All rights reserved.
 *******************************************************************************/
package com.kd.platform.minidao.factory;

import java.lang.annotation.Annotation;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.util.StringUtils;

import com.kd.platform.minidao.annotation.MiniDao;
import com.kd.platform.minidao.aop.MiniDaoHandler;
import com.kd.platform.minidao.hibernate.dao.impl.GenericBaseCommonDao;

/**
 * <b>Application name:</b> MiniDaoBeanScannerConfigurer.java <br>
 * <b>Application describing: </b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-6-9 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class MiniDaoBeanScannerConfigurer implements BeanDefinitionRegistryPostProcessor {
    private String basePackage;

    private Class<? extends Annotation> annotation = MiniDao.class;

    private String keyType = "origin";

    private boolean formatSql = false;

    private boolean showSql = false;

    private String dbType;

    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        registerGenericBaseCommonDao(registry);

        registerRequestProxyHandler(registry);

        MiniDaoClassPathMapperScanner scanner = new MiniDaoClassPathMapperScanner(registry, this.annotation);

        scanner.scan(StringUtils.tokenizeToStringArray(this.basePackage, ",; \t\n"));
    }

    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
    }

    private void registerGenericBaseCommonDao(BeanDefinitionRegistry registry) {
        GenericBeanDefinition genericBaseCommonDaofinition = new GenericBeanDefinition();
        genericBaseCommonDaofinition.setBeanClass(GenericBaseCommonDao.class);
        registry.registerBeanDefinition("genericBaseCommonDao", genericBaseCommonDaofinition);
    }

    private void registerRequestProxyHandler(BeanDefinitionRegistry registry) {
        GenericBeanDefinition jdbcDaoProxyDefinition = new GenericBeanDefinition();
        jdbcDaoProxyDefinition.setBeanClass(MiniDaoHandler.class);
        jdbcDaoProxyDefinition.getPropertyValues().add("formatSql", Boolean.valueOf(this.formatSql));
        jdbcDaoProxyDefinition.getPropertyValues().add("keyType", this.keyType);
        jdbcDaoProxyDefinition.getPropertyValues().add("showSql", Boolean.valueOf(this.showSql));
        jdbcDaoProxyDefinition.getPropertyValues().add("dbType", this.dbType);
        registry.registerBeanDefinition("miniDaoHandler", jdbcDaoProxyDefinition);
    }

    public void setAnnotation(Class<? extends Annotation> annotation) {
        this.annotation = annotation;
    }

    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }

    public void setDbType(String dbType) {
        this.dbType = dbType;
    }

    public void setFormatSql(boolean formatSql) {
        this.formatSql = formatSql;
    }

    public void setKeyType(String keyType) {
        this.keyType = keyType;
    }

    public void setShowSql(boolean showSql) {
        this.showSql = showSql;
    }
}
