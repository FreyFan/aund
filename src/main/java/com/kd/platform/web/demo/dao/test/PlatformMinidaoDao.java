package com.kd.platform.web.demo.dao.test;

import java.util.List;
import java.util.Map;

import com.kd.platform.minidao.annotation.Arguments;
import com.kd.platform.minidao.annotation.MiniDao;
import com.kd.platform.minidao.annotation.ResultType;
import com.kd.platform.minidao.annotation.Sql;
import com.kd.platform.minidao.hibernate.MiniDaoSupportHiber;
import com.kd.platform.web.demo.entity.test.PlatformMinidaoEntity;

/**
 * Minidao例子
 * @author fancq
 */
@MiniDao(value = "")
public interface PlatformMinidaoDao extends MiniDaoSupportHiber<PlatformMinidaoEntity> {
    @Arguments({ "platformMinidao", "page", "rows" })
    public List<Map> getAllEntities(PlatformMinidaoEntity platformMinidao, int page, int rows);

    @Arguments({ "platformMinidao", "page", "rows" })
    @ResultType(PlatformMinidaoEntity.class)
    public List<PlatformMinidaoEntity> getAllEntities2(PlatformMinidaoEntity platformMinidao, int page, int rows);

    @Sql("SELECT count(*) FROM PLATFORM.platform_minidao")
    Integer getCount();

    @Sql("SELECT SUM(salary) FROM PLATFORM.platform_minidao")
    Integer getSumSalary();
}
