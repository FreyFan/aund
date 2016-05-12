package com.kd.platform.minidao.datasource;

/**
 * <b>Application name:</b> DataSourceContextHolder.java <br>
 * <b>Application describing:获得和设置上下文环境的类，主要负责改变上下文数据源的名称 DataSourceContextHolder </b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-6-10 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class DataSourceContextHolder {
    private static final ThreadLocal<DataSourceType> contextHolder = new ThreadLocal();

    public static void clearDataSourceType() {
        contextHolder.remove();
    }

    public static DataSourceType getDataSourceType() {
        return (DataSourceType) contextHolder.get();
    }

    public static void setDataSourceType(DataSourceType dataSourceType) {
        contextHolder.set(dataSourceType);
    }
}
