package com.kd.platform.minidao.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <b>Application name:</b> Arguments.java <br>
 * <b>Application describing: 规则： 1. [注释标签参数]必须和[方法参数]，保持顺序一致 2. [注释标签参数]的参数数目不能大于[方法参数]的参数数目 3.
 * 只有在[注释标签参数]标注的参数，才会传递到SQL模板里 4. 如果[方法参数]只有一个，如果用户不设置 [注释标签参数]，则默认参数名为miniDto <b>Copyright:</b>
 * Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-6-10 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD })
public @interface Arguments {
    public abstract String[] value();
}
