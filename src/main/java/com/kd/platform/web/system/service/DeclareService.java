package com.kd.platform.web.system.service;

import java.util.List;

import com.kd.platform.web.system.pojo.base.TSAttachment;

import com.kd.platform.core.common.service.CommonService;

/**
 * <b>Application name:</b> DeclareService.java <br>
 * <b>Application describing: </b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-7-10 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public interface DeclareService extends CommonService {

    public List<TSAttachment> getAttachmentsByCode(String businessKey, String description);
}
