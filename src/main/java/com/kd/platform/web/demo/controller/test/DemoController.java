package com.kd.platform.web.demo.controller.test;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.kd.platform.web.system.pojo.base.TSDemo;
import com.kd.platform.web.system.pojo.base.TSFunction;
import com.kd.platform.web.system.service.SystemService;

import org.apache.log4j.Logger;
import com.kd.platform.core.common.controller.BaseController;
import com.kd.platform.core.common.hibernate.qbc.CriteriaQuery;
import com.kd.platform.core.common.model.json.AjaxJson;
import com.kd.platform.core.common.model.json.ComboTree;
import com.kd.platform.core.common.model.json.TreeGrid;
import com.kd.platform.core.constant.Globals;
import com.kd.platform.core.util.MyBeanUtils;
import com.kd.platform.core.util.StringUtil;
import com.kd.platform.core.util.oConvertUtils;
import com.kd.platform.tag.vo.easyui.ComboTreeModel;
import com.kd.platform.tag.vo.easyui.TreeGridModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.HtmlUtils;

/**
 * <b>Application name:</b> DemoController.java <br>
 * <b>Application describing: 演示例子处理类</b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-7-2 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
@Scope("prototype")
@Controller
@RequestMapping("/demoController")
public class DemoController extends BaseController {
    private static final Logger logger = Logger.getLogger(DemoController.class);

    @Autowired
    private SystemService systemService;

    private String message;

    public String getMessage() {
        return message;
    }

    /**
     * demo添加页面跳转
     */
    @RequestMapping(params = "aorudemo")
    public ModelAndView aorudemo(TSDemo demo, HttpServletRequest request) {
        String type = oConvertUtils.getString(request.getParameter("type"));
        if (demo.getId() != null) {
            demo = systemService.getEntity(TSDemo.class, demo.getId());
            request.setAttribute("demo", demo);
        }
        if (type.equals("table")) {
            return new ModelAndView("platform/demo/base/tabledemo");
        } else if (type.equals("tableupdate")) {
            return new ModelAndView("platform/demo/base/demoTab");
        } else {
            return new ModelAndView("platform/demo/base/demo");
        }
    }

    /**
     * 父级DEMO下拉菜单
     */
    @RequestMapping(params = "pDemoList")
    @ResponseBody
    public List<ComboTree> pDemoList(HttpServletRequest request, ComboTree comboTree) {
        CriteriaQuery cq = new CriteriaQuery(TSDemo.class);
        if (comboTree.getId() != null) {
            cq.eq("TSDemo.id", comboTree.getId());
        }
        if (comboTree.getId() == null) {
            cq.isNull("TSDemo");
        }
        cq.add();
        List<TSDemo> demoList = systemService.getListByCriteriaQuery(cq, false);
        List<ComboTree> comboTrees = new ArrayList<ComboTree>();
        ComboTreeModel comboTreeModel = new ComboTreeModel("id", "demotitle", "tsDemos", "demourl");
        comboTrees = systemService.ComboTree(demoList, comboTreeModel, null, false);
        return comboTrees;
    }

    @RequestMapping(params = "demoTurn")
    @ResponseBody
    public String demoTurn(String id) {
        String code = systemService.get(TSDemo.class, id).getDemocode();
        return HtmlUtils.htmlUnescape(code);
    }

    /**
     * demo页面跳转
     */
    @RequestMapping(params = "demoIframe")
    public ModelAndView demoIframe(HttpServletRequest request) {
        CriteriaQuery cq = new CriteriaQuery(TSDemo.class);
        cq.isNull("TSDemo.id");
        cq.add();
        List<TSDemo> demoList = systemService.getListByCriteriaQuery(cq, false);
        request.setAttribute("demoList", demoList);
        return new ModelAndView("platform/demo/base/demoIframe");
    }

    /**
     * demo页面跳转
     */
    @RequestMapping(params = "demoList")
    public ModelAndView demoList(HttpServletRequest request) {
        return new ModelAndView("platform/demo/base/demoList");
    }

    /**
     * 权限列表
     */
    @RequestMapping(params = "demoGrid")
    @ResponseBody
    public List<TreeGrid> demoGrid(HttpServletRequest request, TreeGrid treegrid) {
        CriteriaQuery cq = new CriteriaQuery(TSDemo.class);
        if (treegrid.getId() != null) {
            cq.eq("TSDemo.id", treegrid.getId());
        }
        if (treegrid.getId() == null) {
            cq.isNull("TSDemo");
        }
        cq.add();
        List<TSDemo> demoList = systemService.getListByCriteriaQuery(cq, false);
        TreeGridModel treeGridModel = new TreeGridModel();
        treeGridModel.setTextField("demotitle");
        treeGridModel.setParentText("TSDemo_demotitle");
        treeGridModel.setParentId("TSDemo_id");
        treeGridModel.setSrc("demourl");
        treeGridModel.setIdField("id");
        treeGridModel.setChildList("tsDemos");
        List<TreeGrid> treeGrids = systemService.treegrid(demoList, treeGridModel);
        return treeGrids;
    }

    /**
     * demoCode页面跳转
     */
    @RequestMapping(params = "demoCode")
    public ModelAndView demoCode(TSDemo demo, HttpServletRequest request) {
        List<TSDemo> list = systemService.getList(TSDemo.class);
        demo = list.get(0);
        request.setAttribute("demo", demo);
        return new ModelAndView("platform/demo/base/democode");
    }

    /**
     * AJAX 示例下拉框
     * @param req
     * @return
     */
    @RequestMapping(params = "getDemo")
    @ResponseBody
    public AjaxJson getDemo(HttpServletRequest req) {
        AjaxJson j = new AjaxJson();
        String id = StringUtil.getEncodePra(req.getParameter("id"));
        String floor = "";
        CriteriaQuery cq = new CriteriaQuery(TSFunction.class);
        cq.eq("TSFunction.id", id);
        cq.add();
        List<TSFunction> functions = systemService.getListByCriteriaQuery(cq, false);
        if (functions.size() > 0) {
            for (TSFunction function : functions) {
                floor += "<input type=\"checkbox\"  name=\"floornum\" id=\"floornum\" value=\"" + function.getId() + "\">" + function.getFunctionName() + "&nbsp;&nbsp;";
            }
        } else {
            floor += "没有子项目!";
        }

        j.setMsg(floor);
        return j;
    }

    /**
     * 上传TABS跳转
     */
    @RequestMapping(params = "uploadTabs")
    public ModelAndView uploadTabs(HttpServletRequest request) {
        return new ModelAndView("platform/demo/base/upload/uploadTabs");
    }

    /**
     * 图片预览TABS跳转
     */
    @RequestMapping(params = "imgViewTabs")
    public ModelAndView imgViewTabs(HttpServletRequest request) {
        return new ModelAndView("platform/demo/base/picview/imgViewTabs");
    }

    /**
     * 表单验证TABS跳转
     */
    @RequestMapping(params = "formTabs")
    public ModelAndView formTabs(HttpServletRequest request) {
        return new ModelAndView("platform/demo/base/formvalid/formTabs");
    }

    /**
     * 动态模板TABS跳转
     */
    @RequestMapping(params = "templeteTabs")
    public ModelAndView templeteTabs(HttpServletRequest request) {
        return new ModelAndView("platform/demo/base/template/templateiframe");
    }

    /**
     * 上传演示
     */
    @RequestMapping(params = "autoupload")
    public ModelAndView autoupload(HttpServletRequest request) {
        String turn = oConvertUtils.getString(request.getParameter("turn"));
        return new ModelAndView("platform/demo/base/" + turn + "");
    }

    /**
     * 下拉联动跳转
     */
    @RequestMapping(params = "select")
    public ModelAndView select(HttpServletRequest request) {
        // 新闻
        CriteriaQuery cq2 = new CriteriaQuery(TSFunction.class);
        cq2.eq("functionLevel", Globals.Function_Leave_ONE);
        cq2.add();
        List<TSFunction> funList = systemService.getListByCriteriaQuery(cq2, true);
        request.setAttribute("funList", funList);
        return new ModelAndView("platform/demo/base/AJAX/select");
    }

    /**
     * 数据字典下拉
     */
    @RequestMapping(params = "dictSelect")
    public ModelAndView dictSelect(HttpServletRequest request) {
        request.setAttribute("process", "default");
        return new ModelAndView("platform/demo/base/dict/dictSelect");
    }

    /**
     * 地图demo
     * @param request
     * @return
     */
    @RequestMapping(params = "mapDemo")
    public ModelAndView mapDemo(HttpServletRequest request) {
        return new ModelAndView("platform/demo/base/map/mapDemo2");
    }

    /**
     * 保存DEMO维护
     * @param platformDemo
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "saveDemo")
    @ResponseBody
    public AjaxJson saveDemo(TSDemo demo, HttpServletRequest request) throws Exception {
        AjaxJson j = new AjaxJson();
        if (!StringUtil.isEmpty(demo.getId())) {
            message = "Demo维护例子: " + demo.getDemotitle() + "被更新成功";
            TSDemo entity = this.systemService.get(TSDemo.class, demo.getId());
            MyBeanUtils.copyBeanNotNull2Bean(demo, entity);

            if (demo.getTSDemo() == null || StringUtil.isEmpty(demo.getTSDemo().getId())) {
                entity.setTSDemo(null);
            }
            this.systemService.saveOrUpdate(entity);
        } else {
            message = "Demo例子: " + demo.getDemotitle() + "被添加成功";
            if (demo.getTSDemo() == null || StringUtil.isEmpty(demo.getTSDemo().getId())) {
                demo.setTSDemo(null);
            }
            this.systemService.save(demo);
        }
        j.setMsg(message);
        return j;
    }

    /**
     * 删除Demo
     * @return
     */
    @RequestMapping(params = "delDemo")
    @ResponseBody
    public AjaxJson del(TSDemo demo, HttpServletRequest request) {
        AjaxJson j = new AjaxJson();
        demo = systemService.getEntity(TSDemo.class, demo.getId());
        message = "Demo: " + demo.getDemotitle() + "被删除 成功";
        // 删除部门之前更新与之相关的实体
        // upEntity(demo);
        systemService.delete(demo);
        systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);

        j.setMsg(message);
        return j;
    }
}