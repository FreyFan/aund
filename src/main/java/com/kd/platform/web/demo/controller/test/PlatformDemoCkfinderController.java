package com.kd.platform.web.demo.controller.test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kd.platform.core.common.controller.BaseController;
import com.kd.platform.core.common.hibernate.qbc.CriteriaQuery;
import com.kd.platform.core.common.model.json.AjaxJson;
import com.kd.platform.core.common.model.json.DataGrid;
import com.kd.platform.core.constant.Globals;
import com.kd.platform.core.extend.hqlsearch.HqlGenerateUtil;
import com.kd.platform.core.util.MyBeanUtils;
import com.kd.platform.core.util.StringUtil;
import com.kd.platform.tag.core.easyui.TagUtil;
import com.kd.platform.web.demo.entity.test.PlatformDemoCkfinderEntity;
import com.kd.platform.web.system.service.SystemService;

/**
 * @Title: Controller
 * @Description: ckeditor+ckfinder例子
 * @author Alexander
 * @date 2013-09-19 18:29:20
 * @version V1.0
 */
@Scope("prototype")
@Controller
@RequestMapping("/platformDemoCkfinderController")
public class PlatformDemoCkfinderController extends BaseController {

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
     * ckeditor+ckfinder例子列表 页面跳转
     * @return
     */
    @RequestMapping(params = "platformDemoCkfinder")
    public ModelAndView platformDemoCkfinder(HttpServletRequest request) {
        return new ModelAndView("platform/demo/test/platformDemoCkfinderList");
    }

    /**
     * easyui AJAX请求数据
     * @param request
     * @param response
     * @param dataGrid
     * @param user
     */
    @RequestMapping(params = "datagrid")
    public void datagrid(PlatformDemoCkfinderEntity platformDemoCkfinder, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
        CriteriaQuery cq = new CriteriaQuery(PlatformDemoCkfinderEntity.class, dataGrid);
        // 查询条件组装器
        HqlGenerateUtil.installHql(cq, platformDemoCkfinder, request.getParameterMap());
        this.systemService.getDataGridReturn(cq, true);
        TagUtil.datagrid(response, dataGrid);
    }

    /**
     * 删除ckeditor+ckfinder例子
     * @return
     */
    @RequestMapping(params = "del")
    @ResponseBody
    public AjaxJson del(PlatformDemoCkfinderEntity platformDemoCkfinder, HttpServletRequest request) {
        AjaxJson j = new AjaxJson();
        platformDemoCkfinder = systemService.getEntity(PlatformDemoCkfinderEntity.class, platformDemoCkfinder.getId());
        message = "ckeditor+ckfinder例子删除成功";
        systemService.delete(platformDemoCkfinder);
        systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);

        j.setMsg(message);
        return j;
    }

    /**
     * 添加ckeditor+ckfinder例子
     * @param ids
     * @return
     */
    @RequestMapping(params = "save")
    @ResponseBody
    public AjaxJson save(PlatformDemoCkfinderEntity platformDemoCkfinder, HttpServletRequest request) {
        AjaxJson j = new AjaxJson();
        if (StringUtil.isNotEmpty(platformDemoCkfinder.getId())) {
            message = "ckeditor+ckfinder例子更新成功";
            PlatformDemoCkfinderEntity t = systemService.get(PlatformDemoCkfinderEntity.class, platformDemoCkfinder.getId());
            try {
                MyBeanUtils.copyBeanNotNull2Bean(platformDemoCkfinder, t);
                systemService.saveOrUpdate(t);
                systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
            } catch (Exception e) {
                e.printStackTrace();
                message = "ckeditor+ckfinder例子更新失败";
            }
        } else {
            message = "ckeditor+ckfinder例子添加成功";
            systemService.save(platformDemoCkfinder);
            systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
        }
        j.setMsg(message);
        return j;
    }

    /**
     * ckeditor+ckfinder例子列表页面跳转
     * @return
     */
    @RequestMapping(params = "addorupdate")
    public ModelAndView addorupdate(PlatformDemoCkfinderEntity platformDemoCkfinder, HttpServletRequest req) {
        if (StringUtil.isNotEmpty(platformDemoCkfinder.getId())) {
            platformDemoCkfinder = systemService.getEntity(PlatformDemoCkfinderEntity.class, platformDemoCkfinder.getId());
            req.setAttribute("platformDemoCkfinderPage", platformDemoCkfinder);
        }
        return new ModelAndView("platform/demo/test/platformDemoCkfinder");
    }

    /**
     * ckeditor+ckfinder例子预览
     * @return
     */
    @RequestMapping(params = "preview")
    public ModelAndView preview(PlatformDemoCkfinderEntity platformDemoCkfinder, HttpServletRequest req) {
        if (StringUtil.isNotEmpty(platformDemoCkfinder.getId())) {
            platformDemoCkfinder = systemService.getEntity(PlatformDemoCkfinderEntity.class, platformDemoCkfinder.getId());
            req.setAttribute("ckfinderPreview", platformDemoCkfinder);
        }
        return new ModelAndView("platform/demo/test/platformDemoCkfinderPreview");
    }
}
