package com.kd.platform.web.demo.controller.test;

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
import com.kd.platform.core.common.hibernate.qbc.CriteriaQuery;
import com.kd.platform.core.common.model.json.AjaxJson;
import com.kd.platform.core.common.model.json.DataGrid;
import com.kd.platform.core.constant.Globals;
import com.kd.platform.core.extend.hqlsearch.HqlGenerateUtil;
import com.kd.platform.core.util.StringUtil;
import com.kd.platform.tag.core.easyui.TagUtil;
import com.kd.platform.web.demo.entity.test.PlatformNoteEntity;
import com.kd.platform.web.system.service.SystemService;

/**
 * @Title: Controller
 * @Description: 公告
 * @author Frey.Fan
 * @date 2013-03-12 14:06:34
 * @version V1.0
 */
@Scope("prototype")
@Controller
@RequestMapping("/platformNoteController")
public class PlatformNoteController extends BaseController {
    /**
     * Logger for this class
     */
    private static final Logger logger = Logger.getLogger(PlatformNoteController.class);

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
     * 公告列表 页面跳转
     * @return
     */
    @RequestMapping(params = "platformNote")
    public ModelAndView platformNote(HttpServletRequest request) {
        return new ModelAndView("platform/demo/test/platformNoteList");
    }

    /**
     * easyui AJAX请求数据
     * @param request
     * @param response
     * @param dataGrid
     * @param user
     */

    @RequestMapping(params = "datagrid")
    public void datagrid(PlatformNoteEntity platformNote, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
        CriteriaQuery cq = new CriteriaQuery(PlatformNoteEntity.class, dataGrid);
        // 查询条件组装器
        HqlGenerateUtil.installHql(cq, platformNote);
        this.systemService.getDataGridReturn(cq, true);
        TagUtil.datagrid(response, dataGrid);
    }

    /**
     * 删除公告
     * @return
     */
    @RequestMapping(params = "del")
    @ResponseBody
    public AjaxJson del(PlatformNoteEntity platformNote, HttpServletRequest request) {
        AjaxJson j = new AjaxJson();
        platformNote = systemService.getEntity(PlatformNoteEntity.class, platformNote.getId());
        message = "删除成功";
        systemService.delete(platformNote);
        systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);

        j.setMsg(message);
        return j;
    }

    /**
     * 添加公告
     * @param ids
     * @return
     */
    @RequestMapping(params = "save")
    @ResponseBody
    public AjaxJson save(PlatformNoteEntity platformNote, HttpServletRequest request) {
        AjaxJson j = new AjaxJson();
        if (StringUtil.isNotEmpty(platformNote.getId())) {
            message = "更新成功";
            systemService.saveOrUpdate(platformNote);
            systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
        } else {
            message = "添加成功";
            systemService.save(platformNote);
            systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
        }
        return j;
    }

    /**
     * 公告列表页面跳转
     * @return
     */
    @RequestMapping(params = "addorupdate")
    public ModelAndView addorupdate(PlatformNoteEntity platformNote, HttpServletRequest req) {
        if (StringUtil.isNotEmpty(platformNote.getId())) {
            platformNote = systemService.getEntity(PlatformNoteEntity.class, platformNote.getId());
            req.setAttribute("platformNotePage", platformNote);
        }
        return new ModelAndView("platform/demo/test/platformNote");
    }

    /**
     * 公告列表页面跳转
     * @return
     */
    @RequestMapping(params = "addorupdateNoBtn")
    public ModelAndView addorupdateNoBtn(PlatformNoteEntity platformNote, HttpServletRequest req) {
        if (StringUtil.isNotEmpty(platformNote.getId())) {
            platformNote = systemService.getEntity(PlatformNoteEntity.class, platformNote.getId());
            req.setAttribute("platformNotePage", platformNote);
        }
        return new ModelAndView("platform/demo/test/platformNoteNoBtn");
    }
}
