package com.kd.platform.web.demo.controller.test;

import com.kd.platform.core.common.controller.BaseController;
import com.kd.platform.core.common.hibernate.qbc.CriteriaQuery;
import com.kd.platform.core.common.model.json.AjaxJson;
import com.kd.platform.core.common.model.json.ComboTree;
import com.kd.platform.core.common.model.json.TreeGrid;
import com.kd.platform.core.constant.Globals;
import com.kd.platform.core.extend.hqlsearch.HqlGenerateUtil;
import com.kd.platform.core.util.MyBeanUtils;
import com.kd.platform.core.util.StringUtil;
import com.kd.platform.tag.vo.easyui.ComboTreeModel;
import com.kd.platform.tag.vo.easyui.TreeGridModel;
import com.kd.platform.web.demo.entity.test.PlatformMatterBom;
import com.kd.platform.web.demo.service.test.PlatformMatterBomServiceI;
import com.kd.platform.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * <b>Application name:</b> PlatformMatterBomController.java <br>
 * <b>Application describing:物料Bom显示控制类 </b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-7-2 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
@Scope("prototype")
@Controller
@RequestMapping("/platformMatterBomController")
public class PlatformMatterBomController extends BaseController {

    @Autowired
    private PlatformMatterBomServiceI platformMatterBomService;

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
     * {跳转到物料Bom列表页面}
     * @param request
     * @return
     * @author: Frey.Fan
     */
    @RequestMapping(params = "goList")
    public ModelAndView goList(HttpServletRequest request) {
        return new ModelAndView("platform/demo/test/platformMatterBomList");
    }

    /**
     * {获取物料Bom treegrid集合}
     * @param entity
     * @param request
     * @param response
     * @param treegrid
     * @return
     * @author: Frey.Fan
     */
    @RequestMapping(params = "doTreeGrid")
    @ResponseBody
    public List<TreeGrid> doTreeGrid(PlatformMatterBom entity, HttpServletRequest request, HttpServletResponse response, TreeGrid treegrid) {
        CriteriaQuery cq = new CriteriaQuery(PlatformMatterBom.class);
        if ("yes".equals(request.getParameter("isSearch"))) {
            treegrid.setId(null);
            entity.setId(null);
        }
        if (null != entity.getCode()) {
            HqlGenerateUtil.installHql(cq, entity);
        }
        if (treegrid.getId() != null) {
            cq.eq("parent.id", treegrid.getId());
        } else {
            cq.isNull("parent");
        }
        cq.add();
        List<TreeGrid> list = platformMatterBomService.getListByCriteriaQuery(cq, false);
        if (list.size() == 0 && entity.getCode() != null) {
            cq = new CriteriaQuery(PlatformMatterBom.class);
            PlatformMatterBom parent = new PlatformMatterBom();
            entity.setParent(parent);
            HqlGenerateUtil.installHql(cq, entity);
            list = platformMatterBomService.getListByCriteriaQuery(cq, false);
        }
        List<TreeGrid> treeGrids = new ArrayList<TreeGrid>();
        TreeGridModel treeGridModel = new TreeGridModel();
        treeGridModel.setTextField("name");
        treeGridModel.setParentText("parent_name");
        treeGridModel.setParentId("parent_id");
        treeGridModel.setSrc("code");
        treeGridModel.setIdField("id");
        treeGridModel.setChildList("children");
        treeGrids = platformMatterBomService.treegrid(list, treeGridModel);
        return treeGrids;
    }

    /**
     * {跳转到录入或编辑页面}
     * @param entity
     * @param request
     * @return
     * @author: Frey.Fan
     */
    @RequestMapping(params = "goEdit")
    public ModelAndView goEdit(PlatformMatterBom entity, HttpServletRequest request) {
        if (StringUtil.isNotEmpty(entity.getId())) {
            entity = platformMatterBomService.getEntity(PlatformMatterBom.class, entity.getId());
            request.setAttribute("entity", entity);
        }
        return new ModelAndView("platform/demo/test/platformMatterBom");
    }

    /**
     * {获取物料Bom ComboTree集合}
     * @param request
     * @param comboTree
     * @return
     * @author: Frey.Fan
     */
    @RequestMapping(params = "getChildren")
    @ResponseBody
    public List<ComboTree> getChildren(HttpServletRequest request, ComboTree comboTree) {
        CriteriaQuery cq = new CriteriaQuery(PlatformMatterBom.class);
        if (comboTree.getId() != null) {
            cq.eq("parent.id", comboTree.getId());
        } else {
            cq.isNull("parent");
        }
        cq.add();
        List<PlatformMatterBom> list = platformMatterBomService.getListByCriteriaQuery(cq, false);
        ComboTreeModel comboTreeModel = new ComboTreeModel("id", "name", "children");
        List<ComboTree> comboTrees = systemService.ComboTree(list, comboTreeModel, null, false);
        return comboTrees;

    }

    /**
     * {保存或更新物料Bom}
     * @param entity
     * @param request
     * @return
     * @author: Frey.Fan
     */
    @RequestMapping(params = "doSave")
    @ResponseBody
    public AjaxJson doSave(PlatformMatterBom entity, HttpServletRequest request) {
        AjaxJson j = new AjaxJson();
        // 设置上级物料Bom
        String parentId = request.getParameter("parent.id");
        if (StringUtil.isEmpty(parentId)) {
            entity.setParent(null);
        }
        if (StringUtil.isNotEmpty(entity.getId())) {
            message = "更新成功";
            PlatformMatterBom t = platformMatterBomService.get(PlatformMatterBom.class, entity.getId());
            try {
                MyBeanUtils.copyBeanNotNull2Bean(entity, t);
                platformMatterBomService.saveOrUpdate(t);
                systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            message = "添加成功";
            platformMatterBomService.save(entity);
            systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
        }
        return j;
    }

    /**
     * {删除物料Bom}
     * @param entity
     * @param request
     * @return
     * @author: Frey.Fan
     */
    @RequestMapping(params = "doDelete")
    @ResponseBody
    public AjaxJson doDelete(PlatformMatterBom entity, HttpServletRequest request) {
        AjaxJson j = new AjaxJson();

        platformMatterBomService.deleteEntityById(PlatformMatterBom.class, entity.getId());

        message = "删除成功";
        systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);

        j.setMsg(message);
        return j;
    }
}
