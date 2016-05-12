package com.kd.platform.web.demo.controller.test;

import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.kd.platform.core.common.controller.BaseController;
import com.kd.platform.core.common.hibernate.qbc.CriteriaQuery;
import com.kd.platform.core.common.model.json.AjaxJson;
import com.kd.platform.core.common.model.json.DataGrid;
import com.kd.platform.core.constant.Globals;
import com.kd.platform.core.extend.hqlsearch.HqlGenerateUtil;
import com.kd.platform.core.util.ExceptionUtil;
import com.kd.platform.core.util.MyBeanUtils;
import com.kd.platform.core.util.StringUtil;
import com.kd.platform.tag.core.easyui.TagUtil;
import com.kd.platform.web.demo.entity.test.PlatformBlobDataEntity;
import com.kd.platform.web.demo.service.test.PlatformBlobDataServiceI;
import com.kd.platform.web.system.service.SystemService;

/**
 * @Title: Controller
 * @Description: Blob型数据操作例子
 * @author Quainty
 * @date 2013-06-07 14:46:08
 * @version V1.0
 */
@Scope("prototype")
@Controller
@RequestMapping("/platformBlobDataController")
public class PlatformBlobDataController extends BaseController {
    /**
     * Logger for this class
     */
    private static final Logger logger = Logger.getLogger(PlatformBlobDataController.class);

    @Autowired
    private PlatformBlobDataServiceI platformBlobDataService;

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
     * Blob型数据操作例子列表 页面跳转
     * @return
     */
    @RequestMapping(params = "platformBlobData")
    public ModelAndView platformBlobData(HttpServletRequest request) {
        return new ModelAndView("platform/demo/test/platformBlobDataList");
    }

    /**
     * easyui AJAX请求数据
     * @param request
     * @param response
     * @param dataGrid
     * @param user
     */
    @RequestMapping(params = "datagrid")
    public void datagrid(PlatformBlobDataEntity platformBlobData, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
        CriteriaQuery cq = new CriteriaQuery(PlatformBlobDataEntity.class, dataGrid);
        // 查询条件组装器
        HqlGenerateUtil.installHql(cq, platformBlobData);
        this.platformBlobDataService.getDataGridReturn(cq, true);
        TagUtil.datagrid(response, dataGrid);
    }

    /**
     * 删除Blob型数据操作例子
     * @return
     */
    @RequestMapping(params = "del")
    @ResponseBody
    public AjaxJson del(PlatformBlobDataEntity platformBlobData, HttpServletRequest request) {
        AjaxJson j = new AjaxJson();
        platformBlobData = systemService.getEntity(PlatformBlobDataEntity.class, platformBlobData.getId());
        message = "删除成功";
        platformBlobDataService.delete(platformBlobData);
        systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);

        j.setMsg(message);
        return j;
    }

    @RequestMapping(params = "download")
    public void exportXls(HttpServletRequest request, String fileId, HttpServletResponse response) {
        // 从数据库取得数据
        PlatformBlobDataEntity obj = systemService.getEntity(PlatformBlobDataEntity.class, fileId);
        try {
            Blob attachment = obj.getAttachmentcontent();
            response.setContentType("application/x-msdownload;");
            response.setHeader("Content-disposition", "attachment; filename=" + new String((obj.getAttachmenttitle() + "." + obj.getExtend()).getBytes("GBK"), "ISO8859-1"));
            // 从数据库中读取出来 , 输出给下载用
            InputStream bis = attachment.getBinaryStream();
            BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
            byte[] buff = new byte[2048];
            int bytesRead;
            long lTotalLen = 0;
            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                bos.write(buff, 0, bytesRead);
                lTotalLen += bytesRead;
            }
            response.setHeader("Content-Length", String.valueOf(lTotalLen));
            bos.flush();
            bos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(params = "upload")
    @ResponseBody
    public AjaxJson upload(HttpServletRequest request, String documentTitle, HttpServletResponse response) {
        AjaxJson j = new AjaxJson();

        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
        for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
            MultipartFile file = entity.getValue();// 获取上传文件对象
            try {
                platformBlobDataService.saveObj(documentTitle, file);
                j.setMsg("文件导入成功！");
            } catch (Exception e) {
                j.setMsg("文件导入失败！");
                logger.error(ExceptionUtil.getExceptionMessage(e));
            }
            // break; // 不支持多个文件导入？
        }

        return j;
    }

    /**
     * 添加Blob型数据操作例子
     * @param ids
     * @return
     */
    @RequestMapping(params = "save")
    @ResponseBody
    public AjaxJson save(PlatformBlobDataEntity platformBlobData, HttpServletRequest request) {
        AjaxJson j = new AjaxJson();
        if (StringUtil.isNotEmpty(platformBlobData.getId())) {
            message = "更新成功";
            PlatformBlobDataEntity t = platformBlobDataService.get(PlatformBlobDataEntity.class, platformBlobData.getId());
            try {
                MyBeanUtils.copyBeanNotNull2Bean(platformBlobData, t);
                platformBlobDataService.saveOrUpdate(t);
                systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            message = "添加成功";
            platformBlobDataService.save(platformBlobData);
            systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
        }

        return j;
    }

    /**
     * Blob型数据操作例子列表页面跳转
     * @return
     */
    @RequestMapping(params = "addorupdate")
    public ModelAndView addorupdate(PlatformBlobDataEntity platformBlobData, HttpServletRequest req) {
        if (StringUtil.isNotEmpty(platformBlobData.getId())) {
            platformBlobData = platformBlobDataService.getEntity(PlatformBlobDataEntity.class, platformBlobData.getId());
            req.setAttribute("platformBlobDataPage", platformBlobData);
        }
        return new ModelAndView("platform/demo/test/platformBlobData");
    }
}
