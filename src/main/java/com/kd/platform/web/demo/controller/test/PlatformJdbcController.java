package com.kd.platform.web.demo.controller.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kd.platform.web.demo.entity.test.PlatformJdbcEntity;
import com.kd.platform.web.demo.service.test.PlatformJdbcServiceI;
import com.kd.platform.web.system.service.SystemService;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import com.kd.platform.core.common.controller.BaseController;
import com.kd.platform.core.common.model.json.AjaxJson;
import com.kd.platform.core.common.model.json.DataGrid;
import com.kd.platform.core.constant.Globals;
import com.kd.platform.core.util.MyBeanUtils;
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
 * @Description: 通过JDBC访问数据库
 * @author Quainty
 * @date 2013-05-20 13:18:38
 * @version V1.0
 */
@Scope("prototype")
@Controller
@RequestMapping("/platformJdbcController")
public class PlatformJdbcController extends BaseController {
    /**
     * Logger for this class
     */
    private static final Logger logger = Logger.getLogger(PlatformJdbcController.class);

    @Autowired
    private PlatformJdbcServiceI platformJdbcService;

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
     * 通过JDBC访问数据库列表 页面跳转
     * @return
     */
    @RequestMapping(params = "platformJdbc")
    public ModelAndView platformJdbc(HttpServletRequest request) {
        return new ModelAndView("platform/demo/test/platformJdbcList");
    }

    /**
     * easyui AJAX请求数据
     * @param request
     * @param response
     * @param dataGrid
     * @param user
     */
    @RequestMapping(params = "datagrid")
    public void datagrid(PlatformJdbcEntity platformJdbc, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
        // 方式1, 用底层自带的方式往对象中设值 -------------------
        /*
         * this.platformJdbcService.getDatagrid1(platformJdbc, dataGrid); 
         * TagUtil.datagrid(response, dataGrid); 
         */
        // end of 方式1 =========================================
        /*
         * this.platformJdbcService.getDatagrid2(platformJdbc, dataGrid); 
         * TagUtil.datagrid(response, dataGrid); 
         // end of 方式2 =========================================
         */
        // *
        JSONObject jObject = this.platformJdbcService.getDatagrid3(platformJdbc, dataGrid);
        responseDatagrid(response, jObject);
        // end of 方式3 ========================================= */
    }

    /**
     * 删除通过JDBC访问数据库
     * @return
     */
    @RequestMapping(params = "del")
    @ResponseBody
    public AjaxJson del(PlatformJdbcEntity platformJdbc, HttpServletRequest request) {
        AjaxJson j = new AjaxJson();

        String sql = "delete from PLATFORM.platform_demo where id='" + platformJdbc.getId() + "'";
        platformJdbcService.executeSql(sql);

        message = "删除成功";
        systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);

        j.setMsg(message);
        return j;
    }

    /**
     * 添加通过JDBC访问数据库
     * @param ids
     * @return
     */
    @RequestMapping(params = "save")
    @ResponseBody
    public AjaxJson save(PlatformJdbcEntity platformJdbc, HttpServletRequest request) {
        AjaxJson j = new AjaxJson();
        if (StringUtil.isNotEmpty(platformJdbc.getId())) {
            message = "更新成功";
            PlatformJdbcEntity t = platformJdbcService.get(PlatformJdbcEntity.class, platformJdbc.getId());
            try {
                MyBeanUtils.copyBeanNotNull2Bean(platformJdbc, t);
                platformJdbcService.saveOrUpdate(t);
                systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            message = "添加成功";
            platformJdbcService.save(platformJdbc);
            systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
        }

        return j;
    }

    /**
     * 通过JDBC访问数据库列表页面跳转
     * @return
     */
    @RequestMapping(params = "addorupdate")
    public ModelAndView addorupdate(PlatformJdbcEntity platformJdbc, HttpServletRequest req) {
        if (StringUtil.isNotEmpty(platformJdbc.getId())) {
            platformJdbc = platformJdbcService.getEntity(PlatformJdbcEntity.class, platformJdbc.getId());
            req.setAttribute("platformJdbcPage", platformJdbc);
        }
        return new ModelAndView("platform/demo/test/platformJdbc");
    }

    // 以下各函数可以提成共用部件 (Add by Quainty)
    public void responseDatagrid(HttpServletResponse response, JSONObject jObject) {
        response.setContentType("application/json");
        response.setHeader("Cache-Control", "no-store");
        try {
            PrintWriter pw = response.getWriter();
            pw.write(jObject.toString());
            pw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(params = "dictParameter")
    public String dictParameter() {
        return "platform/demo/base/jdbc/jdbc-list";
    }

    /**
     * JDBC DEMO 显示列表
     * @return
     */
    @RequestMapping(params = "listAllDictParaByJdbc")
    public void listAllDictParaByJdbc(HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {

        this.platformJdbcService.listAllByJdbc(dataGrid);
        TagUtil.datagrid(response, dataGrid);
    }
}
