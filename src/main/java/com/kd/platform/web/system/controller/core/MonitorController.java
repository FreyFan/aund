package com.kd.platform.web.system.controller.core;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kd.platform.core.common.controller.BaseController;

/**
 * <b>Application name:</b> MonitorController.java <br>
 * <b>Application describing: 平台监控</b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-6-26 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
@Controller
@RequestMapping("/monitorController")
public class MonitorController extends BaseController {

    /**
     * 跳转到平台监控页面
     * @return
     */
    @RequestMapping(params = "goMonitor")
    public ModelAndView goMonitor() {
        return new ModelAndView("/system/monitor/index");
    }
}
