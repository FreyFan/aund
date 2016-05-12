package com.kd.platform.web.sms.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kd.platform.core.common.service.impl.CommonServiceImpl;
import com.kd.platform.web.sms.service.TSSmsSqlServiceI;

@Service("tSSmsSqlService")
@Transactional
public class TSSmsSqlServiceImpl extends CommonServiceImpl implements TSSmsSqlServiceI {

    @Resource
    private JdbcTemplate jdbcTemplate;

    /**
     * 执行业务查询出来的sql
     */
    public Map<String, Object> getMap(String sql, Map<String, Object> map) {
        return this.jdbcTemplate.queryForMap(sql, map);
    }
}
