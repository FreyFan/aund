<#if packageStyle == "service">
package ${bussiPackage}.${entityPackage}.service;
import ${bussiPackage}.${entityPackage}.entity.${entityName}Entity;
<#else>
package ${bussiPackage}.service.${entityPackage};
import ${bussiPackage}.entity.${entityPackage}.${entityName}Entity;
</#if>
import com.kd.platform.core.common.service.CommonService;

import java.io.Serializable;

/**
 * <b>Application name:</b> ${entityName}ServiceI.java <br>
 * <b>Application describing:${ftl_description} </b> <br>
 * <b>Copyright:</b> Copyright &copy; 2014 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> ${ftl_create_time} <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public interface ${entityName}ServiceI extends CommonService{
	
 	public <T> void delete(T entity);
 	
 	public <T> Serializable save(T entity);
 	
 	public <T> void saveOrUpdate(T entity);
 	
	<#list buttons as btn>
 	<#if btn.buttonStyle =='button' && btn.optType=='action'>
 	/**
	 * 自定义按钮-sql增强-${btn.buttonName}
	 * @param id
	 * @return
	 */
	 public boolean do${btn.buttonCode?cap_first}Sql(${entityName}Entity t);
 	</#if>
 	</#list> 
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(${entityName}Entity t);
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(${entityName}Entity t);
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(${entityName}Entity t);
}
