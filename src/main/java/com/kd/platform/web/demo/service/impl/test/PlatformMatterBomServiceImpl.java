package com.kd.platform.web.demo.service.impl.test;

import com.kd.platform.web.demo.service.test.PlatformMatterBomServiceI;

import com.kd.platform.core.common.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <b>Application name:</b> PlatformMatterBomServiceImpl.java <br>
 * <b>Application describing: 物料Bom业务接口实现类</b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-7-2 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
@Service("platformMatterBomService")
@Transactional
public class PlatformMatterBomServiceImpl extends CommonServiceImpl implements PlatformMatterBomServiceI {

}
