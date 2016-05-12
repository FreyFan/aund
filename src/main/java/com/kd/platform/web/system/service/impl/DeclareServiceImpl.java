package com.kd.platform.web.system.service.impl;

import java.util.List;

import com.kd.platform.web.system.pojo.base.TSAttachment;
import com.kd.platform.web.system.service.DeclareService;

import com.kd.platform.core.common.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("declareService")
@Transactional
public class DeclareServiceImpl extends CommonServiceImpl implements DeclareService {

    public List<TSAttachment> getAttachmentsByCode(String businessKey, String description) {
        String hql = "from TSAttachment t where t.businessKey='" + businessKey + "' and t.description='" + description + "'";
        return commonDao.findByQueryString(hql);
    }
}