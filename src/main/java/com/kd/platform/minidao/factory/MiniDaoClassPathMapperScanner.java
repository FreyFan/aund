/*******************************************************************************
 * @(#)MiniDaoClassPathMapperScanner.java 2015-6-9
 *
 * Copyright 2015 Frey.Fan. All rights reserved.
 *******************************************************************************/
package com.kd.platform.minidao.factory;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.filter.AnnotationTypeFilter;

/**
 * <b>Application name:</b> MiniDaoClassPathMapperScanner.java <br>
 * <b>Application describing: </b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-6-9 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class MiniDaoClassPathMapperScanner extends ClassPathBeanDefinitionScanner {
    private static final Logger logger = LoggerFactory.getLogger(MiniDaoClassPathMapperScanner.class);

    public MiniDaoClassPathMapperScanner(BeanDefinitionRegistry registry, Class<? extends Annotation> annotation) {
        super(registry);
        addIncludeFilter(new AnnotationTypeFilter(annotation));
    }

    public Set<BeanDefinitionHolder> doScan(String[] basePackages) {
        Set beanDefinitions = super.doScan(basePackages);

        if (beanDefinitions.isEmpty()) {
            logger.warn("No Dao interface was found in '" + Arrays.toString(basePackages) + "' package. Please check your configuration.");
        }

        // Iterator iterator = beanDefinitions.iterator();
        // while (iterator.hasNext()) {
        // BeanDefinitionHolder definition = (BeanDefinitionHolder) iterator.next();
        // definition.getPropertyValues().add("proxy",
        // getRegistry().getBeanDefinition("miniDaoHandler"));
        // definition.getPropertyValues().add("daoInterface", definition.getBeanClassName());
        // if (logger.isInfoEnabled()) {
        // logger.info("register minidao name is {}", definition.getBeanClassName());
        // }
        // definition.setBeanClass(MiniDaoBeanFactory.class);
        // }

        GenericBeanDefinition definition;
        for (Iterator iterator = beanDefinitions.iterator(); iterator.hasNext(); definition.setBeanClass(MiniDaoBeanFactory.class)) {
            BeanDefinitionHolder holder = (BeanDefinitionHolder) iterator.next();
            definition = (GenericBeanDefinition) holder.getBeanDefinition();
            definition.getPropertyValues().add("proxy", getRegistry().getBeanDefinition("miniDaoHandler"));
            definition.getPropertyValues().add("daoInterface", definition.getBeanClassName());
            if (logger.isInfoEnabled()) {
                logger.info("register minidao name is {}", definition.getBeanClassName());
            }
        }

        return beanDefinitions;
    }

    protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
        return (beanDefinition.getMetadata().isInterface()) && (beanDefinition.getMetadata().isIndependent());
    }
}
