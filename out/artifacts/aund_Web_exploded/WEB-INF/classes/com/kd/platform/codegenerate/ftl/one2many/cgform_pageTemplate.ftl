
<#if packageStyle == "service">
package ${bussiPackage}.${entityPackage}.page;
import ${bussiPackage}.${entityPackage}.entity.${entityName}Entity;
<#list subTab as sub>
import ${bussiPackage}.${sub.entityPackage}.entity.${sub.entityName}Entity;
</#list>
<#else>
package ${bussiPackage}.page.${entityPackage};
import ${bussiPackage}.entity.${entityPackage}.${entityName}Entity;
<#list subTab as sub>
import ${bussiPackage}.entity.${sub.entityPackage}.${sub.entityName}Entity;
</#list>
</#if>

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.SequenceGenerator;


/**
 * <b>Application name:</b> ${entityName}Page.java <br>
 * <b>Application describing:${ftl_description} </b> <br>
 * <b>Copyright:</b> Copyright &copy; 2014 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> ${ftl_create_time} <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class ${entityName}Page implements java.io.Serializable {
	<#list subTab as sub>
	/**保存-${sub.ftlDescription}*/
	private List<${sub.entityName}Entity> ${sub.entityName?uncap_first}List = new ArrayList<${sub.entityName}Entity>();
	public List<${sub.entityName}Entity> get${sub.entityName}List() {
		return ${sub.entityName?uncap_first}List;
	}
	public void set${sub.entityName}List(List<${sub.entityName}Entity> ${sub.entityName?uncap_first}List) {
		this.${sub.entityName?uncap_first}List = ${sub.entityName?uncap_first}List;
	}
	</#list>

	<#list columns as po>
	/**${po.content}*/
	private ${po.type} ${po.fieldName};
	</#list>
	
	<#list columns as po>
	/**
	 *方法: 取得${po.type}
	 *@return: ${po.type}  ${po.content}
	 */
	public ${po.type} get${po.fieldName?cap_first}(){
		return this.${po.fieldName};
	}

	/**
	 *方法: 设置${po.type}
	 *@param: ${po.type}  ${po.content}
	 */
	public void set${po.fieldName?cap_first}(${po.type} ${po.fieldName}){
		this.${po.fieldName} = ${po.fieldName};
	}
	</#list>
}
