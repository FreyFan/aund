package com.kd.platform.web.cgreport.dao.core;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.kd.platform.minidao.annotation.Arguments;

/**
 * @author Frey.Fan
 */
@Repository("cgReportDao")
public interface CgReportDao {

    @Arguments("configId")
    List<Map<String, Object>> queryCgReportItems(String configId);

    @Arguments("id")
    Map queryCgReportMainConfig(String id);
}
