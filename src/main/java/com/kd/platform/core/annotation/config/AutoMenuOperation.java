package com.kd.platform.core.annotation.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <b>Application name:</b> AutoMenuOperation.java <br>
 * <b>Application describing: 菜单操作按钮注释标签 系统启动自动加载菜单对应的操作权限 Method级别</b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-6-29 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface AutoMenuOperation {

    /**
     * 操作名称
     * @return
     */
    public String name();

    /**
     * 操作码
     * @return
     */
    public String code();

    /**
     * 操作码类型
     * @return
     */
    public MenuCodeType codeType() default MenuCodeType.TAG;

    /**
     * 图标
     * @return
     */
    public String icon() default "";

    /**
     * 状态
     * @return
     */
    public int status() default 0;
}
