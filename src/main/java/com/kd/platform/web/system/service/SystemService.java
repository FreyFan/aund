package com.kd.platform.web.system.service;

import java.util.List;
import java.util.Set;

import com.kd.platform.web.system.pojo.base.DictEntity;
import com.kd.platform.web.system.pojo.base.TSFunction;
import com.kd.platform.web.system.pojo.base.TSIcon;
import com.kd.platform.web.system.pojo.base.TSType;
import com.kd.platform.web.system.pojo.base.TSTypegroup;
import com.kd.platform.web.system.pojo.base.TSUser;
import com.kd.platform.core.common.service.CommonService;

/**
 * <b>Application name:</b> SystemService.java <br>
 * <b>Application describing: 系统公用业务接口</b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-7-10 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public interface SystemService extends CommonService {
    /**
     * 查询数据字典
     * @param dicTable
     * @param dicCode
     * @param dicText
     * @return 返回类型： List<DictEntity>
     */
    public List<DictEntity> queryDict(String dicTable, String dicCode, String dicText);

    /**
     * 登陆用户检查
     * @param user
     * @return
     * @throws Exception
     */
    public TSUser checkUserExits(TSUser user) throws Exception;

    /**
     * 日志添加
     * @param LogContent 内容
     * @param loglevel 级别
     * @param operatetype 类型
     * @param TUser 操作人
     */
    public void addLog(String LogContent, Short loglevel, Short operatetype);

    /**
     * 根据类型编码和类型名称获取Type,如果为空则创建一个
     * @param typecode
     * @param typename
     * @return
     */
    public TSType getType(String typecode, String typename, TSTypegroup tsTypegroup);

    /**
     * 根据类型分组编码和名称获取TypeGroup,如果为空则创建一个
     * @param typecode
     * @param typename
     * @return
     */
    public TSTypegroup getTypeGroup(String typegroupcode, String typgroupename);

    /**
     * 根据用户ID 和 菜单Id 获取 具有操作权限的按钮Codes
     * @param roleId
     * @param functionId
     * @return
     */
    public Set<String> getOperationCodesByUserIdAndFunctionId(String userId, String functionId);

    /**
     * 根据角色ID 和 菜单Id 获取 具有操作权限的按钮Codes
     * @param roleId
     * @param functionId
     * @return
     */
    public Set<String> getOperationCodesByRoleIdAndFunctionId(String roleId, String functionId);

    /**
     * 根据编码获取字典组
     * @param typegroupCode
     * @return
     */
    public TSTypegroup getTypeGroupByCode(String typegroupCode);

    /**
     * 对数据字典进行缓存
     */
    public void initAllTypeGroups();

    /**
     * 刷新字典缓存
     * @param type
     */
    public void refleshTypesCach(TSType type);

    /**
     * 刷新字典分组缓存
     */
    public void refleshTypeGroupCach();

    /**
     * 刷新菜单
     * @param id
     */
    public void flushRoleFunciton(String id, TSFunction newFunciton);

    /**
     * 生成组织机构编码
     * @param id 组织机构主键
     * @param pid 组织机构的父级主键
     * @return 组织机构编码
     */
    String generateOrgCode(String id, String pid);

    /**
     * 根据角色id 和 菜单Id 获取 具有操作权限的数据规则
     * @param @param roleId
     * @param @param functionId
     * @param @return 设定文件
     * @return Set<String> 返回类型
     * @throws
     */
    public Set<String> getOperationCodesByRoleIdAndruleDataId(String roleId, String functionId);

    public Set<String> getOperationCodesByUserIdAndDataId(String userId, String functionId);

    /**
     * 加载所有图标
     * @return
     */
    public void initAllTSIcons();

    /**
     * 更新图标
     * @param icon
     */
    public void upTSIcons(TSIcon icon);

    /**
     * 删除图标
     * @param icon
     */
    public void delTSIcons(TSIcon icon);
}