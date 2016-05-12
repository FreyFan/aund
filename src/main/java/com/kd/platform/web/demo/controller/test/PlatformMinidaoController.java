package com.kd.platform.web.demo.controller.test;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kd.platform.core.common.controller.BaseController;
import com.kd.platform.core.common.model.json.AjaxJson;
import com.kd.platform.core.common.model.json.DataGrid;
import com.kd.platform.core.constant.Globals;
import com.kd.platform.core.util.MyBeanUtils;
import com.kd.platform.core.util.StringUtil;
import com.kd.platform.tag.core.easyui.TagUtil;
import com.kd.platform.web.demo.entity.test.PlatformMinidaoEntity;
import com.kd.platform.web.demo.service.test.PlatformMinidaoServiceI;
import com.kd.platform.web.system.pojo.base.TSDepart;
import com.kd.platform.web.system.service.SystemService;

/**
 * @Title: Controller
 * @Description: Minidao例子
 * @author fancq
 * @date 2013-12-23 21:18:59
 * @version V1.0
 */
@Scope("prototype")
@Controller
@RequestMapping("/platformMinidaoController")
public class PlatformMinidaoController extends BaseController {
    /**
     * Logger for this class
     */
    private static final Logger logger = Logger.getLogger(PlatformMinidaoController.class);

    @Autowired
    private PlatformMinidaoServiceI platformMinidaoService;

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
     * Minidao例子列表 页面跳转
     * @return
     */
    @RequestMapping(params = "platformMinidao")
    public ModelAndView platformMinidao(HttpServletRequest request) {
        return new ModelAndView("platform/demo/test/platformMinidaoList");
    }

    /**
     * easyui AJAX请求数据
     * @param request
     * @param response
     * @param dataGrid
     * @param user
     */
    @RequestMapping(params = "datagrid")
    public void datagrid(PlatformMinidaoEntity platformMinidao, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
        List<PlatformMinidaoEntity> list = platformMinidaoService.listAll(platformMinidao, dataGrid.getPage(), dataGrid.getRows());
        Integer count = platformMinidaoService.getCount();
        dataGrid.setTotal(count);
        dataGrid.setResults(list);
        String total_salary = String.valueOf(platformMinidaoService.getSumSalary());
        /*
         * 说明：格式为 字段名:值(可选，不写该值时为分页数据的合计) 多个合计 以 , 分割
         */
        dataGrid.setFooter("salary:" + (total_salary.equalsIgnoreCase("null") ? "0.0" : total_salary) + ",age,email:合计");
        TagUtil.datagrid(response, dataGrid);
    }

    /**
     * 删除Minidao例子
     * @return
     */
    @RequestMapping(params = "del")
    @ResponseBody
    public AjaxJson del(PlatformMinidaoEntity platformMinidao, HttpServletRequest request) {
        AjaxJson j = new AjaxJson();
        platformMinidao = platformMinidaoService.getEntity(PlatformMinidaoEntity.class, platformMinidao.getId());
        message = "Minidao例子删除成功";
        platformMinidaoService.delete(platformMinidao);
        systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);

        j.setMsg(message);
        return j;
    }

    /**
     * 添加Minidao例子
     * @param ids
     * @return
     */
    @RequestMapping(params = "save")
    @ResponseBody
    public AjaxJson save(PlatformMinidaoEntity platformMinidao, HttpServletRequest request) {
        AjaxJson j = new AjaxJson();
        if (StringUtil.isNotEmpty(platformMinidao.getId())) {
            message = "Minidao例子更新成功";
            PlatformMinidaoEntity t = platformMinidaoService.getEntity(PlatformMinidaoEntity.class, platformMinidao.getId());
            try {
                MyBeanUtils.copyBeanNotNull2Bean(platformMinidao, t);
                platformMinidaoService.update(t);
                systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
            } catch (Exception e) {
                e.printStackTrace();
                message = "Minidao例子更新失败";
            }
        } else {
            message = "Minidao例子添加成功";
            platformMinidao.setStatus("0");
            platformMinidaoService.insert(platformMinidao);
            systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
        }
        j.setMsg(message);
        return j;
    }

    /**
     * Minidao例子列表页面跳转
     * @return
     */
    @RequestMapping(params = "addorupdate")
    public ModelAndView addorupdate(PlatformMinidaoEntity platformMinidao, HttpServletRequest req) {
        // 获取部门信息
        List<TSDepart> departList = systemService.getList(TSDepart.class);
        req.setAttribute("departList", departList);

        if (StringUtil.isNotEmpty(platformMinidao.getId())) {
            platformMinidao = platformMinidaoService.getEntity(PlatformMinidaoEntity.class, platformMinidao.getId());
            req.setAttribute("platformMinidaoPage", platformMinidao);
        }
        return new ModelAndView("platform/demo/test/platformMinidao");
    }
}
