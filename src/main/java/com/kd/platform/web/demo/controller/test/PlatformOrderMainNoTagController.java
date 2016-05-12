package com.kd.platform.web.demo.controller.test;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kd.platform.web.demo.entity.test.PlatformOrderCustomEntity;
import com.kd.platform.web.demo.entity.test.PlatformOrderMainEntity;
import com.kd.platform.web.demo.entity.test.PlatformOrderProductEntity;
import com.kd.platform.web.demo.page.PlatformOrderMainPage;
import com.kd.platform.web.demo.service.test.PlatformOrderMainServiceI;
import com.kd.platform.web.system.service.SystemService;

import org.apache.log4j.Logger;
import com.kd.platform.core.common.controller.BaseController;
import com.kd.platform.core.common.hibernate.qbc.CriteriaQuery;
import com.kd.platform.core.common.model.json.AjaxJson;
import com.kd.platform.core.common.model.json.DataGrid;
import com.kd.platform.core.constant.Globals;
import com.kd.platform.core.util.StringUtil;
import com.kd.platform.tag.core.easyui.TagUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Title: Controller
 * @Description: 订单信息
 * @author Frey.Fan
 * @date 2013-03-19 22:01:34
 * @version V1.0
 */
@Scope("prototype")
@Controller
@RequestMapping("/platformOrderMainNoTagController")
public class PlatformOrderMainNoTagController extends BaseController {
    /**
     * Logger for this class
     */
    private static final Logger logger = Logger.getLogger(PlatformOrderMainController.class);

    @Autowired
    private PlatformOrderMainServiceI platformOrderMainService;

    @Autowired
    private SystemService systemService;

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 订单信息列表 页面跳转
     * @return
     */
    @RequestMapping(params = "platformOrderMainNoTag")
    public ModelAndView platformOrderMain(HttpServletRequest request) {
        return new ModelAndView("platform/demo/notag/platformOrderMainListNoTag");
    }

    /**
     * easyui AJAX请求数据
     * @param request
     * @param response
     * @param dataGrid
     * @param user
     */

    @RequestMapping(params = "datagrid")
    public void datagrid(HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
        CriteriaQuery cq = new CriteriaQuery(PlatformOrderMainEntity.class, dataGrid);
        this.platformOrderMainService.getDataGridReturn(cq, true);
        TagUtil.datagrid(response, dataGrid);
    }

    /**
     * 删除订单信息
     * @return
     */
    @RequestMapping(params = "del")
    @ResponseBody
    public AjaxJson del(PlatformOrderMainEntity platformOrderMain, HttpServletRequest request) {
        AjaxJson j = new AjaxJson();
        platformOrderMain = systemService.getEntity(PlatformOrderMainEntity.class, platformOrderMain.getId());
        message = "删除成功";
        platformOrderMainService.delMain(platformOrderMain);
        systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
        j.setMsg(message);
        return j;
    }

    /**
     * 添加订单及明细信息
     * @param ids
     * @return
     */
    @RequestMapping(params = "save")
    @ResponseBody
    public AjaxJson save(PlatformOrderMainEntity platformOrderMain, PlatformOrderMainPage platformOrderMainPage, HttpServletRequest request) {
        List<PlatformOrderProductEntity> platformOrderProducList = platformOrderMainPage.getPlatformOrderProductList();
        List<PlatformOrderCustomEntity> platformOrderCustomList = platformOrderMainPage.getPlatformOrderCustomList();
        Boolean platformOrderCustomShow = "true".equals(request.getParameter("platformOrderCustomShow"));
        AjaxJson j = new AjaxJson();
        if (StringUtil.isNotEmpty(platformOrderMain.getId())) {
            message = "更新成功";
            platformOrderMainService.updateMain(platformOrderMain, platformOrderProducList, platformOrderCustomList, platformOrderCustomShow);
            systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
        } else {
            message = "添加成功";
            platformOrderMainService.addMain(platformOrderMain, platformOrderProducList, platformOrderCustomList);
            systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
        }
        j.setMsg(message);
        return j;
    }

    /**
     * 订单信息列表页面跳转
     * @return
     */
    @RequestMapping(params = "addorupdateNoTag")
    public ModelAndView addorupdate(PlatformOrderMainEntity platformOrderMain, HttpServletRequest req) {
        if (StringUtil.isNotEmpty(platformOrderMain.getId())) {
            platformOrderMain = platformOrderMainService.getEntity(PlatformOrderMainEntity.class, platformOrderMain.getId());
            req.setAttribute("platformOrderMainPage", platformOrderMain);
        }
        if (StringUtil.isNotEmpty(platformOrderMain.getGoOrderCode())) {
            List<PlatformOrderProductEntity> platformOrderProductEntityList = platformOrderMainService.findByProperty(PlatformOrderProductEntity.class, "goOrderCode", platformOrderMain.getGoOrderCode());
            req.setAttribute("platformOrderProductList", platformOrderProductEntityList);
        }
        if (StringUtil.isNotEmpty(platformOrderMain.getGoOrderCode())) {
            List<PlatformOrderCustomEntity> platformPlatformOrderCustomEntityList = platformOrderMainService.findByProperty(PlatformOrderCustomEntity.class, "goOrderCode", platformOrderMain.getGoOrderCode());
            req.setAttribute("platformOrderCustomList", platformPlatformOrderCustomEntityList);
        }
        return new ModelAndView("platform/demo/notag/platformOrderMainNoTag");
    }
}
