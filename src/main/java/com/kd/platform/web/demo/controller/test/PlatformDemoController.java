package com.kd.platform.web.demo.controller.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.transport.socket.SocketAcceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kd.mina.SocketAcceptorFactory;
import com.kd.platform.core.annotation.config.AutoMenu;
import com.kd.platform.core.annotation.config.AutoMenuOperation;
import com.kd.platform.core.common.controller.BaseController;
import com.kd.platform.core.common.hibernate.qbc.CriteriaQuery;
import com.kd.platform.core.common.model.json.AjaxJson;
import com.kd.platform.core.common.model.json.DataGrid;
import com.kd.platform.core.constant.Globals;
import com.kd.platform.core.extend.hqlsearch.HqlGenerateUtil;
import com.kd.platform.core.util.MyBeanUtils;
import com.kd.platform.core.util.StringUtil;
import com.kd.platform.tag.core.easyui.TagUtil;
import com.kd.platform.web.demo.entity.test.CKEditorEntity;
import com.kd.platform.web.demo.entity.test.PlatformDemo;
import com.kd.platform.web.system.pojo.base.TSDepart;
import com.kd.platform.web.system.service.SystemService;

/**
 * @Title: Controller
 * @Description: 单表模型（DEMO）
 * @author Frey.Fan
 * @date 2013-01-23 17:12:40
 * @version V1.0
 */
@Scope("prototype")
@Controller
@RequestMapping("/platformDemoController")
@AutoMenu(name = "常用Demo", url = "platformDemoController.do?platformDemo")
public class PlatformDemoController extends BaseController {
    /**
     * Logger for this class
     */
    private static final Logger logger = Logger.getLogger(PlatformDemoController.class);

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
     * popup 例子
     * @param request
     * @return
     */
    @RequestMapping(params = "popup")
    public ModelAndView popup(HttpServletRequest request) {
        return new ModelAndView("platform/demo/platformDemo/popup");
    }

    /**
     * popup 例子
     * @param request
     * @return
     */
    @RequestMapping(params = "selectUserList")
    public ModelAndView selectUserList(HttpServletRequest request) {
        String departsReplace = "";
        List<TSDepart> departList = systemService.getList(TSDepart.class);
        for (TSDepart depart : departList) {
            if (departsReplace.length() > 0) {
                departsReplace += ",";
            }
            departsReplace += depart.getDepartname() + "_" + depart.getId();
        }
        request.setAttribute("departsReplace", departsReplace);
        return new ModelAndView("platform/demo/platformDemo/selectUserList");
    }

    /**
     * ckeditor 例子
     * @return
     */
    @RequestMapping(params = "ckeditor")
    public ModelAndView ckeditor(HttpServletRequest request) {
        // CKEditorEntity t = platformDemoService.get(CKEditorEntity.class, "1");
        CKEditorEntity t = systemService.loadAll(CKEditorEntity.class).get(0);
        request.setAttribute("cKEditorEntity", t);
        if (t.getContents() == null) {
            request.setAttribute("contents", "");
        } else {
            request.setAttribute("contents", new String(t.getContents()));
        }
        return new ModelAndView("platform/demo/platformDemo/ckeditor");
    }

    /**
     * ckeditor saveCkeditor
     * @return
     */
    @RequestMapping(params = "saveCkeditor")
    @ResponseBody
    public AjaxJson saveCkeditor(HttpServletRequest request, CKEditorEntity cKEditor, String contents) {
        AjaxJson j = new AjaxJson();
        if (StringUtil.isNotEmpty(cKEditor.getId())) {
            CKEditorEntity t = systemService.get(CKEditorEntity.class, cKEditor.getId());
            try {
                MyBeanUtils.copyBeanNotNull2Bean(cKEditor, t);
                t.setContents(contents.getBytes());
                systemService.saveOrUpdate(t);
                j.setMsg("更新成功");
            } catch (Exception e) {
                e.printStackTrace();
                j.setMsg("更新失败");
            }
        } else {
            cKEditor.setContents(contents.getBytes());
            systemService.save(cKEditor);
        }
        return j;
    }

    /**
     * PlatformDemo 打印预览跳转
     * @param platformDemo
     * @param req
     * @return
     */
    @RequestMapping(params = "print")
    public ModelAndView print(PlatformDemo platformDemo, HttpServletRequest req) {
        // 获取部门信息
        List<TSDepart> departList = systemService.getList(TSDepart.class);
        req.setAttribute("departList", departList);

        if (StringUtil.isNotEmpty(platformDemo.getId())) {
            platformDemo = systemService.getEntity(PlatformDemo.class, platformDemo.getId());
            req.setAttribute("jgDemo", platformDemo);
            if ("0".equals(platformDemo.getSex())) req.setAttribute("sex", "男");
            if ("1".equals(platformDemo.getSex())) req.setAttribute("sex", "女");
        }
        return new ModelAndView("platform/demo/platformDemo/platformDemoPrint");
    }

    /**
     * PlatformDemo例子列表 页面跳转
     * @return
     */
    @RequestMapping(params = "platformDemo")
    public ModelAndView platformDemo(HttpServletRequest request) {
        return new ModelAndView("platform/demo/platformDemo/platformDemoList");
    }

    /**
     * PlatformDemo例子列表 页面跳转
     * @return
     */
    @RequestMapping(params = "platformDemo2")
    public ModelAndView platformDemo2(HttpServletRequest request) {
        // request.setAttribute("sex", "1");
        request.setAttribute("status", "1");
        return new ModelAndView("platform/demo/platformDemo/platformDemoList2");
    }

    /**
     * easyuiAJAX请求数据
     * @param request
     * @param response
     * @param dataGrid
     * @param user
     */

    @RequestMapping(params = "datagrid")
    public void datagrid(PlatformDemo platformDemo, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
        CriteriaQuery cq = new CriteriaQuery(PlatformDemo.class, dataGrid);
        // 查询条件组装器
        HqlGenerateUtil.installHql(cq, platformDemo, request.getParameterMap());
        this.systemService.getDataGridReturn(cq, true);
        String total_salary = String.valueOf(systemService.findOneForJdbc("select sum(salary) as ssum from PLATFORM.platform_demo").get("ssum"));
        /*
         * 说明：格式为 字段名:值(可选，不写该值时为分页数据的合计) 多个合计 以 , 分割
         */
        dataGrid.setFooter("salary:" + (total_salary.equalsIgnoreCase("null") ? "0.0" : total_salary) + ",age,email:合计");
        TagUtil.datagrid(response, dataGrid);
    }

    @RequestMapping(params = "datagrid2")
    public void datagrid2(PlatformDemo platformDemo, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
        CriteriaQuery cq = new CriteriaQuery(PlatformDemo.class, dataGrid);
        // 查询条件组装器
        HqlGenerateUtil.installHql(cq, platformDemo, request.getParameterMap());
        this.systemService.getDataGridReturn(cq, true);
        // String total_salary =
        // String.valueOf(platformDemoService.findOneForJdbc("select sum(salary) as ssum from platform_demo").get("ssum"));
        // request.setAttribute("maptest", "1");
        /*
         * 说明：格式为 字段名:值(可选，不写该值时为分页数据的合计) 多个合计 以 , 分割
         */
        // dataGrid.setFooter("salary:"+(total_salary.equalsIgnoreCase("null")?"0.0":total_salary)+",age,email:合计");

        TagUtil.datagrid(response, dataGrid);
    }

    /**
     * 权限列表
     */
    @RequestMapping(params = "combox")
    @ResponseBody
    public List<PlatformDemo> combox(HttpServletRequest request, DataGrid dataGrid) {
        CriteriaQuery cq = new CriteriaQuery(PlatformDemo.class);
        List<PlatformDemo> ls = this.systemService.getListByCriteriaQuery(cq, false);
        return ls;
    }

    /**
     * 删除PlatformDemo例子
     * @return
     */
    @RequestMapping(params = "del")
    @ResponseBody
    public AjaxJson del(PlatformDemo platformDemo, HttpServletRequest request) {
        AjaxJson j = new AjaxJson();
        platformDemo = systemService.getEntity(PlatformDemo.class, platformDemo.getId());
        message = "PlatformDemo例子: " + platformDemo.getUserName() + "被删除 成功";
        systemService.delete(platformDemo);
        systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);

        j.setMsg(message);
        return j;
    }

    /**
     * 添加PlatformDemo例子
     * @param ids
     * @return
     */
    @RequestMapping(params = "save")
    @ResponseBody
    @AutoMenuOperation(name = "添加", code = "add")
    public AjaxJson save(PlatformDemo platformDemo, HttpServletRequest request) {
        AjaxJson j = new AjaxJson();
        if (StringUtil.isNotEmpty(platformDemo.getId())) {
            message = "PlatformDemo例子: " + platformDemo.getUserName() + "被更新成功";
            PlatformDemo t = systemService.get(PlatformDemo.class, platformDemo.getId());
            try {
                MyBeanUtils.copyBeanNotNull2Bean(platformDemo, t);
                systemService.saveOrUpdate(t);
                systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            message = "PlatformDemo例子: " + platformDemo.getUserName() + "被添加成功";
            platformDemo.setStatus("0");
            systemService.save(platformDemo);
            systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
        }

        return j;
    }

    /**
     * 审核报错
     * @param ids
     * @return
     */
    @RequestMapping(params = "saveAuthor")
    @ResponseBody
    public AjaxJson saveAuthor(PlatformDemo platformDemo, HttpServletRequest request) {
        AjaxJson j = new AjaxJson();
        if (StringUtil.isNotEmpty(platformDemo.getId())) {
            message = "测试-用户申请成功";
            PlatformDemo t = systemService.get(PlatformDemo.class, platformDemo.getId());
            try {
                MyBeanUtils.copyBeanNotNull2Bean(platformDemo, t);
                t.setStatus("1");
                systemService.saveOrUpdate(t);
                j.setMsg(message);
                systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return j;
    }

    /**
     * PlatformDemo例子列表页面跳转
     * @return
     */
    @RequestMapping(params = "addorupdate")
    public ModelAndView addorupdate(PlatformDemo platformDemo, HttpServletRequest req) {
        // 获取部门信息
        List<TSDepart> departList = systemService.getList(TSDepart.class);
        req.setAttribute("departList", departList);

        Map sexMap = new HashMap();
        sexMap.put(0, "男");
        sexMap.put(1, "女");
        req.setAttribute("sexMap", sexMap);

        if (StringUtil.isNotEmpty(platformDemo.getId())) {
            platformDemo = systemService.getEntity(PlatformDemo.class, platformDemo.getId());
            req.setAttribute("jgDemo", platformDemo);
        }
        return new ModelAndView("platform/demo/platformDemo/platformDemo");
    }

    /**
     * PlatformDemo例子列表页面跳转
     * @return
     */
    @RequestMapping(params = "addorupdatemobile")
    public ModelAndView addorupdatemobile(PlatformDemo platformDemo, HttpServletRequest req) {
        // 获取部门信息
        List<TSDepart> departList = systemService.getList(TSDepart.class);
        req.setAttribute("departList", departList);

        Map sexMap = new HashMap();
        sexMap.put(0, "男");
        sexMap.put(1, "女");
        req.setAttribute("sexMap", sexMap);

        if (StringUtil.isNotEmpty(platformDemo.getId())) {
            platformDemo = systemService.getEntity(PlatformDemo.class, platformDemo.getId());
            req.setAttribute("jgDemo", platformDemo);
        }
        return new ModelAndView("platform/demo/platformDemo/platformDemomobile");
    }

    /**
     * 设置签名跳转页面
     * @param request
     * @return
     */
    @RequestMapping(params = "doCheck")
    public ModelAndView doCheck(HttpServletRequest request) {
        String id = request.getParameter("id");
        request.setAttribute("id", id);
        if (StringUtil.isNotEmpty(id)) {
            PlatformDemo platformDemo = systemService.getEntity(PlatformDemo.class, id);
            request.setAttribute("platformDemo", platformDemo);
        }
        return new ModelAndView("platform/demo/platformDemo/platformDemo-check");
    }

    /**
     * 全选删除Demo实例管理
     * @return
     * @author tanghan
     * @date 2013-07-13 14:53:00
     */
    @RequestMapping(params = "doDeleteALLSelect")
    @ResponseBody
    public AjaxJson doDeleteALLSelect(PlatformDemo platformDemo, HttpServletRequest request) {
        AjaxJson j = new AjaxJson();
        String ids = request.getParameter("ids");
        String[] entitys = ids.split(",");
        List<PlatformDemo> list = new ArrayList<PlatformDemo>();
        for (int i = 0; i < entitys.length; i++) {
            platformDemo = systemService.getEntity(PlatformDemo.class, entitys[i]);
            list.add(platformDemo);
        }
        message = "删除成功";
        systemService.deleteAllEntitie(list);
        systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
        j.setMsg(message);
        return j;
    }

    @RequestMapping(params = "goDemo")
    public ModelAndView goDemo(HttpServletRequest request) {
        return new ModelAndView("platform/demo/platformDemo/" + request.getParameter("demoPage"));
    }
    
    /**
     * PlatformDemo 打印预览跳转
     * @param platformDemo
     * @param req
     * @return
     */
    @RequestMapping(params = "socket")
    public ModelAndView socket(PlatformDemo platformDemo, HttpServletRequest req) {
    	SocketAcceptor socketAcc = SocketAcceptorFactory.getSocketAcceptor();
		Collection<IoSession> sessions = socketAcc.getManagedSessions().values();
		logger.error(sessions);
        // 向所有客户端发送数据
        for (IoSession sess : sessions) {
            sess.write("server send kkk");
        }
        return new ModelAndView("platform/demo/platformDemo/print"); 
    }

}
