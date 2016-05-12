package com.kd.platform.web.system.controller.core;

import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.quartz.CronTrigger;
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
import com.kd.platform.core.timer.DynamicTask;
import com.kd.platform.core.util.MyBeanUtils;
import com.kd.platform.core.util.StringUtil;
import com.kd.platform.tag.core.easyui.TagUtil;
import com.kd.platform.web.system.pojo.base.TSTimeTaskEntity;
import com.kd.platform.web.system.service.SystemService;

/**
 * <b>Application name:</b> TimeTaskController.java <br>
 * <b>Application describing: 定时任务管理</b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-7-6 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
@Scope("prototype")
@Controller
@RequestMapping("/timeTaskController")
public class TimeTaskController extends BaseController {

    @Autowired
    private DynamicTask dynamicTask;

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
     * 定时任务管理列表 页面跳转
     * @return
     */
    @RequestMapping(params = "timeTask")
    public ModelAndView timeTask(HttpServletRequest request) {
        return new ModelAndView("system/timetask/timeTaskList");
    }

    /**
     * easyui AJAX请求数据
     * @param request
     * @param response
     * @param dataGrid
     * @param user
     */
    @RequestMapping(params = "datagrid")
    public void datagrid(TSTimeTaskEntity timeTask, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
        CriteriaQuery cq = new CriteriaQuery(TSTimeTaskEntity.class, dataGrid);
        // 查询条件组装器
        HqlGenerateUtil.installHql(cq, timeTask, request.getParameterMap());
        this.systemService.getDataGridReturn(cq, true);
        TagUtil.datagrid(response, dataGrid);
    }

    /**
     * 删除定时任务管理
     * @return
     */
    @RequestMapping(params = "del")
    @ResponseBody
    public AjaxJson del(TSTimeTaskEntity timeTask, HttpServletRequest request) {
        AjaxJson j = new AjaxJson();
        timeTask = systemService.getEntity(TSTimeTaskEntity.class, timeTask.getId());
        message = "定时任务管理删除成功";
        systemService.delete(timeTask);
        systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
        j.setMsg(message);
        return j;
    }

    /**
     * 添加定时任务管理
     * @param ids
     * @return
     */
    @RequestMapping(params = "save")
    @ResponseBody
    public AjaxJson save(TSTimeTaskEntity timeTask, HttpServletRequest request) {
        AjaxJson j = new AjaxJson();
        CronTrigger trigger = new CronTrigger();
        try {
            trigger.setCronExpression(timeTask.getCronExpression());
        } catch (ParseException e) {
            j.setMsg("Cron表达式错误");
            return j;
        }
        if (StringUtil.isNotEmpty(timeTask.getId())) {
            message = "定时任务管理更新成功";
            TSTimeTaskEntity t = systemService.get(TSTimeTaskEntity.class, timeTask.getId());
            try {
                if (!timeTask.getCronExpression().equals(t.getCronExpression())) {
                    timeTask.setIsEffect("0");
                }
                MyBeanUtils.copyBeanNotNull2Bean(timeTask, t);
                systemService.saveOrUpdate(t);
                systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
            } catch (Exception e) {
                e.printStackTrace();
                message = "定时任务管理更新失败";
            }
        } else {
            message = "定时任务管理添加成功";
            systemService.save(timeTask);
            systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
        }
        j.setMsg(message);
        return j;
    }

    /**
     * 定时任务管理列表页面跳转
     * @return
     */
    @RequestMapping(params = "addorupdate")
    public ModelAndView addorupdate(TSTimeTaskEntity timeTask, HttpServletRequest req) {
        if (StringUtil.isNotEmpty(timeTask.getId())) {
            timeTask = systemService.getEntity(TSTimeTaskEntity.class, timeTask.getId());
            req.setAttribute("timeTaskPage", timeTask);
        }
        return new ModelAndView("system/timetask/timeTask");
    }

    /**
     * 更新任务时间使之生效
     */
    @RequestMapping(params = "updateTime")
    @ResponseBody
    public AjaxJson updateTime(TSTimeTaskEntity timeTask, HttpServletRequest request) {
        AjaxJson j = new AjaxJson();
        timeTask = systemService.get(TSTimeTaskEntity.class, timeTask.getId());
        boolean isUpdate = dynamicTask.updateCronExpression(timeTask.getTaskId(), timeTask.getCronExpression());
        if (isUpdate) {
            timeTask.setIsEffect("1");
            timeTask.setIsStart("1");
            systemService.updateEntitie(timeTask);
        }
        j.setMsg(isUpdate ? "定时任务管理更新成功" : "定时任务管理更新失败");
        return j;
    }

    /**
     * 启动或者停止任务
     */
    @RequestMapping(params = "startOrStopTask")
    @ResponseBody
    public AjaxJson startOrStopTask(TSTimeTaskEntity timeTask, HttpServletRequest request) {
        AjaxJson j = new AjaxJson();
        boolean isStart = timeTask.getIsStart().equals("1");
        timeTask = systemService.get(TSTimeTaskEntity.class, timeTask.getId());
        boolean isSuccess = dynamicTask.startOrStop(timeTask.getTaskId(), isStart);
        if (isSuccess) {
            timeTask.setIsStart(isStart ? "1" : "0");
            systemService.updateEntitie(timeTask);
            systemService.addLog((isStart ? "开启任务" : "停止任务") + timeTask.getTaskId(), Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
        }
        j.setMsg(isSuccess ? "定时任务管理更新成功" : "定时任务管理更新失败");
        return j;
    }
}
