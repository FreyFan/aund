package com.kd.platform.web.demo.controller.test;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kd.platform.core.common.controller.BaseController;

/**
 * <b>Application name:</b> ZTreeController.java <br>
 * <b>Application describing: ztree树形的demo</b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-7-15 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
@Controller
@RequestMapping("/zTreeController")
public class ZTreeController extends BaseController {
    /**
     * Logger for this class
     */
    private static final Logger logger = Logger.getLogger(ZTreeController.class);

    @RequestMapping(params = "ztree")
    public String ztree(HttpServletRequest request) {
        return "platform/demo/test/ztree";
    }
}
