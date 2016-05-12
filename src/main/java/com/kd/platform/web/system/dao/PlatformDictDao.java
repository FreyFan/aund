package com.kd.platform.web.system.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.kd.platform.minidao.annotation.Arguments;
import com.kd.platform.minidao.annotation.ResultType;
import com.kd.platform.web.system.pojo.base.DictEntity;

/**
 * <b>Application name:</b> PlatformDictDao.java <br>
 * <b>Application describing: </b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-6-18 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
@Repository("platformDictDao")
public interface PlatformDictDao {

    /**
     * 方法描述: 查询自定义字典 作 者： yiming.zhang 日 期： 2014年5月13日-下午8:27:26
     * @param dicTable
     * @param dicCode
     * @param dicText
     * @return 返回类型： List<DictEntity>
     */
    @Arguments({ "dicTable", "dicCode", "dicText" })
    @ResultType(DictEntity.class)
    public List<DictEntity> queryCustomDict(String dicTable, String dicCode, String dicText);

    /**
     * 方法描述: 查询系统字典 作 者： yiming.zhang 日 期： 2014年5月13日-下午8:27:00
     * @param dicCode
     * @return 返回类型： List<DictEntity>
     */
    @Arguments({ "dicCode" })
    @ResultType(DictEntity.class)
    public List<DictEntity> querySystemDict(String dicCode);
}
