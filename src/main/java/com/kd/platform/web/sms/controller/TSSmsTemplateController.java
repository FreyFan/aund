package com.kd.platform.web.sms.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kd.platform.core.common.controller.BaseController;
import com.kd.platform.core.common.exception.BusinessException;
import com.kd.platform.core.common.hibernate.qbc.CriteriaQuery;
import com.kd.platform.core.common.model.json.AjaxJson;
import com.kd.platform.core.common.model.json.DataGrid;
import com.kd.platform.core.constant.Globals;
import com.kd.platform.core.extend.hqlsearch.HqlGenerateUtil;
import com.kd.platform.core.util.MyBeanUtils;
import com.kd.platform.core.util.StringUtil;
import com.kd.platform.tag.core.easyui.TagUtil;
import com.kd.platform.web.sms.entity.TSSmsTemplateEntity;
import com.kd.platform.web.system.service.SystemService;

/**   
 * @Title: Controller
 * @Description: 消息模本表
 * @author onlineGenerator
 * @date 2014-09-17 23:52:46
 * @version V1.0   
 */
@Scope("prototype")
@Controller
@RequestMapping("/tSSmsTemplateController")
public class TSSmsTemplateController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(TSSmsTemplateController.class);

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
	 * 消息模本表列表 页面跳转
	 * @return
	 */
	@RequestMapping(params = "tSSmsTemplate")
	public ModelAndView tSSmsTemplate(HttpServletRequest request) {
		return new ModelAndView("system/sms/tSSmsTemplateList");
	}

	/**
	 * easyui AJAX请求数据
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param user
	 */
	@RequestMapping(params = "datagrid")
	public void datagrid(TSSmsTemplateEntity tSSmsTemplate,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(TSSmsTemplateEntity.class, dataGrid);
		//查询条件组装器
		HqlGenerateUtil.installHql(cq, tSSmsTemplate, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.systemService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除消息模本表
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(TSSmsTemplateEntity tSSmsTemplate, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		tSSmsTemplate = systemService.getEntity(TSSmsTemplateEntity.class, tSSmsTemplate.getId());
		message = "消息模本表删除成功";
		try{
		    systemService.delete(tSSmsTemplate);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "消息模本表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除消息模本表
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		message = "消息模本表删除成功";
		try{
			for(String id:ids.split(",")){
				TSSmsTemplateEntity tSSmsTemplate = systemService.getEntity(TSSmsTemplateEntity.class, 
				id
				);
				systemService.delete(tSSmsTemplate);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "消息模本表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加消息模本表
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(TSSmsTemplateEntity tSSmsTemplate, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "消息模本表添加成功";
		try{
		    systemService.save(tSSmsTemplate);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "消息模本表添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新消息模本表
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(TSSmsTemplateEntity tSSmsTemplate, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "消息模本表更新成功";
		TSSmsTemplateEntity t = systemService.get(TSSmsTemplateEntity.class, tSSmsTemplate.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(tSSmsTemplate, t);
			systemService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "消息模本表更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 消息模本表新增页面跳转
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(TSSmsTemplateEntity tSSmsTemplate, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tSSmsTemplate.getId())) {
			tSSmsTemplate = systemService.getEntity(TSSmsTemplateEntity.class, tSSmsTemplate.getId());
			req.setAttribute("tSSmsTemplatePage", tSSmsTemplate);
		}
		return new ModelAndView("system/sms/tSSmsTemplate-add");
	}
	
	/**
	 * 消息模本表编辑页面跳转
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(TSSmsTemplateEntity tSSmsTemplate, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tSSmsTemplate.getId())) {
			tSSmsTemplate = systemService.getEntity(TSSmsTemplateEntity.class, tSSmsTemplate.getId());
			req.setAttribute("tSSmsTemplatePage", tSSmsTemplate);
		}
		return new ModelAndView("system/sms/tSSmsTemplate-update");
	}
	
	/**
	 * 导入功能跳转
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		return new ModelAndView("system/sms/tSSmsTemplateUpload");
	}
	
	/**
	 * 导出excel
	 * @param request
	 * @param response
	 */
//	@RequestMapping(params = "exportXls")
//	public void exportXls(TSSmsTemplateEntity tSSmsTemplate,HttpServletRequest request,HttpServletResponse response
//			, DataGrid dataGrid) {
//		response.setContentType("application/vnd.ms-excel");
//		String codedFileName = null;
//		OutputStream fOut = null;
//		try {
//			codedFileName = "消息模本表";
//			// 根据浏览器进行转码，使其支持中文文件名
//			if (BrowserUtils.isIE(request)) {
//				response.setHeader(
//						"content-disposition",
//						"attachment;filename="
//								+ java.net.URLEncoder.encode(codedFileName,
//										"UTF-8") + ".xls");
//			} else {
//				String newtitle = new String(codedFileName.getBytes("UTF-8"),
//						"ISO8859-1");
//				response.setHeader("content-disposition",
//						"attachment;filename=" + newtitle + ".xls");
//			}
//			// 产生工作簿对象
//			HSSFWorkbook workbook = null;
//			CriteriaQuery cq = new CriteriaQuery(TSSmsTemplateEntity.class, dataGrid);
//			HqlGenerateUtil.installHql(cq, tSSmsTemplate, request.getParameterMap());
//			
//			List<TSSmsTemplateEntity> tSSmsTemplates = this.tSSmsTemplateService.getListByCriteriaQuery(cq,false);
//			workbook = ExcelExportUtil.exportExcel(new ExportParams("消息模本表列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
//					"导出信息"), TSSmsTemplateEntity.class, tSSmsTemplates);
//			fOut = response.getOutputStream();
//			workbook.write(fOut);
//		} catch (Exception e) {
//		} finally {
//			try {
//				fOut.flush();
//				fOut.close();
//			} catch (IOException e) {
//
//			}
//		}
//	}
	
	/**
	 * 导出excel 使模板
	 * @param request
	 * @param response
	 */
//	@RequestMapping(params = "exportXlsByT")
//	public void exportXlsByT(TSSmsTemplateEntity tSSmsTemplate,HttpServletRequest request,HttpServletResponse response
//			, DataGrid dataGrid) {
//		response.setContentType("application/vnd.ms-excel");
//		String codedFileName = null;
//		OutputStream fOut = null;
//		try {
//			codedFileName = "消息模本表";
//			// 根据浏览器进行转码，使其支持中文文件名
//			if (BrowserUtils.isIE(request)) {
//				response.setHeader(
//						"content-disposition",
//						"attachment;filename="
//								+ java.net.URLEncoder.encode(codedFileName,
//										"UTF-8") + ".xls");
//			} else {
//				String newtitle = new String(codedFileName.getBytes("UTF-8"),
//						"ISO8859-1");
//				response.setHeader("content-disposition",
//						"attachment;filename=" + newtitle + ".xls");
//			}
//			// 产生工作簿对象
//			HSSFWorkbook workbook = null;
//			workbook = ExcelExportUtil.exportExcel(new ExportParams("消息模本表列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
//					"导出信息"), TSSmsTemplateEntity.class, null);
//			fOut = response.getOutputStream();
//			workbook.write(fOut);
//		} catch (Exception e) {
//		} finally {
//			try {
//				fOut.flush();
//				fOut.close();
//			} catch (IOException e) {
//
//			}
//		}
//	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(params = "importExcel", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson importExcel(HttpServletRequest request, HttpServletResponse response) {
		AjaxJson j = new AjaxJson();
		
//		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
//		Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
//		for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
//			MultipartFile file = entity.getValue();// 获取上传文件对象
//			ImportParams params = new ImportParams();
//			params.setTitleRows(2);
//			params.setSecondTitleRows(1);
//			params.setNeedSave(true);
//			try {
//				List<TSSmsTemplateEntity> listTSSmsTemplateEntitys = 
//					(List<TSSmsTemplateEntity>)ExcelImportUtil.importExcelByIs(file.getInputStream(),TSSmsTemplateEntity.class,params);
//				for (TSSmsTemplateEntity tSSmsTemplate : listTSSmsTemplateEntitys) {
//					tSSmsTemplateService.save(tSSmsTemplate);
//				}
//				j.setMsg("文件导入成功！");
//			} catch (Exception e) {
//				j.setMsg("文件导入失败！");
//				logger.error(ExceptionUtil.getExceptionMessage(e));
//			}finally{
//				try {
//					file.getInputStream().close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		}
		return j;
	}
}
