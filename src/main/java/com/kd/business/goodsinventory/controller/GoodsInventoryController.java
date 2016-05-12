package com.kd.business.goodsinventory.controller;
import com.kd.business.goodsinventory.entity.GoodsInventoryEntity;
import com.kd.business.goodsinventory.service.GoodsInventoryServiceI;
import java.util.List;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.context.annotation.Scope;
import com.kd.platform.core.common.controller.BaseController;
import com.kd.platform.core.common.exception.BusinessException;
import com.kd.platform.core.common.hibernate.qbc.CriteriaQuery;
import com.kd.platform.core.common.model.json.AjaxJson;
import com.kd.platform.core.common.model.json.DataGrid;
import com.kd.platform.core.constant.Globals;
import com.kd.platform.core.extend.hqlsearch.HqlGenerateUtil;
import com.kd.platform.core.util.StringUtil;
import com.kd.platform.tag.core.easyui.TagUtil;
import com.kd.platform.web.system.pojo.base.TSDepart;
import com.kd.platform.web.system.service.SystemService;
import com.kd.platform.core.util.MyBeanUtils;

import java.io.OutputStream;
import com.kd.platform.core.util.BrowserUtils;
import com.kd.platform.poi.excel.ExcelExportUtil;
import com.kd.platform.poi.excel.ExcelImportUtil;
import com.kd.platform.poi.excel.entity.ExportParams;
import com.kd.platform.poi.excel.entity.ImportParams;
import com.kd.platform.poi.excel.entity.TemplateExportParams;
import com.kd.platform.poi.excel.entity.vo.NormalExcelConstants;
import com.kd.platform.poi.excel.entity.vo.TemplateExcelConstants;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import com.kd.platform.core.util.ResourceUtil;
import java.io.IOException;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import java.util.Map;
import com.kd.platform.core.util.ExceptionUtil;

/**
 * <b>Application name:</b> GoodsInventoryController.java <br>
 * <b>Application describing:库存详情 </b> <br>
 * <b>Copyright:</b> Copyright &copy; 2014 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2016-04-17 11:00:32 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
@Scope("prototype")
@Controller
@RequestMapping("/goodsInventoryController")
public class GoodsInventoryController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(GoodsInventoryController.class);

	@Autowired
	private GoodsInventoryServiceI goodsInventoryService;
	
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
	 * 库存详情列表 页面跳转
	 * @return
	 */
	@RequestMapping(params = "goodsInventory",method = RequestMethod.GET)
	public ModelAndView goodsInventory(HttpServletRequest request) {
		return new ModelAndView("com/kd/business/goodsinventory/goodsInventoryList");
	}

	/**
	 * easyui AJAX请求数据
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param user
	 */
	@RequestMapping(params = "datagrid")
	public void datagrid(GoodsInventoryEntity goodsInventory,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(GoodsInventoryEntity.class, dataGrid);
		//查询条件组装器
		HqlGenerateUtil.installHql(cq, goodsInventory, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.goodsInventoryService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除库存详情
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(GoodsInventoryEntity goodsInventory, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		goodsInventory = systemService.getEntity(GoodsInventoryEntity.class, goodsInventory.getId());
		message = "库存详情删除成功";
		try{
			goodsInventoryService.delete(goodsInventory);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "库存详情删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除库存详情
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		message = "库存详情删除成功";
		try{
			for(String id:ids.split(",")){
				GoodsInventoryEntity goodsInventory = systemService.getEntity(GoodsInventoryEntity.class, 
				id
				);
				goodsInventoryService.delete(goodsInventory);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "库存详情删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加库存详情
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(GoodsInventoryEntity goodsInventory, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "库存详情添加成功";
		try{
			goodsInventoryService.save(goodsInventory);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "库存详情添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新库存详情
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(GoodsInventoryEntity goodsInventory, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "库存详情更新成功";
		GoodsInventoryEntity t = goodsInventoryService.get(GoodsInventoryEntity.class, goodsInventory.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(goodsInventory, t);
			goodsInventoryService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "库存详情更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 库存详情新增页面跳转
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(GoodsInventoryEntity goodsInventory, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(goodsInventory.getId())) {
			goodsInventory = goodsInventoryService.getEntity(GoodsInventoryEntity.class, goodsInventory.getId());
			req.setAttribute("goodsInventoryPage", goodsInventory);
		}
		return new ModelAndView("com/kd/business/goodsinventory/goodsInventory-add");
	}
	
	/**
	 * 库存详情编辑页面跳转
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(GoodsInventoryEntity goodsInventory, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(goodsInventory.getId())) {
			goodsInventory = goodsInventoryService.getEntity(GoodsInventoryEntity.class, goodsInventory.getId());
			req.setAttribute("goodsInventoryPage", goodsInventory);
		}
		return new ModelAndView("com/kd/business/goodsinventory/goodsInventory-update");
	}
	
	/**
	 * 导入功能跳转
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","goodsInventoryController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(GoodsInventoryEntity goodsInventory,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(GoodsInventoryEntity.class, dataGrid);
		HqlGenerateUtil.installHql(cq, goodsInventory, request.getParameterMap());
		List<GoodsInventoryEntity> goodsInventorys = this.goodsInventoryService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"库存详情");
		modelMap.put(NormalExcelConstants.CLASS,GoodsInventoryEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("库存详情列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,goodsInventorys);
		return NormalExcelConstants.PLATFORM_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(GoodsInventoryEntity goodsInventory,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		modelMap.put(TemplateExcelConstants.FILE_NAME, "库存详情");
		modelMap.put(TemplateExcelConstants.PARAMS,new TemplateExportParams("Excel模板地址"));
		modelMap.put(TemplateExcelConstants.MAP_DATA,null);
		modelMap.put(TemplateExcelConstants.CLASS,GoodsInventoryEntity.class);
		modelMap.put(TemplateExcelConstants.LIST_DATA,null);
		return TemplateExcelConstants.PLATFORM_TEMPLATE_EXCEL_VIEW;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(params = "importExcel", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson importExcel(HttpServletRequest request, HttpServletResponse response) {
		AjaxJson j = new AjaxJson();
		
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
		for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
			MultipartFile file = entity.getValue();// 获取上传文件对象
			ImportParams params = new ImportParams();
			params.setTitleRows(2);
			params.setHeadRows(1);
			params.setNeedSave(true);
			try {
				List<GoodsInventoryEntity> listGoodsInventoryEntitys = ExcelImportUtil.importExcel(file.getInputStream(),GoodsInventoryEntity.class,params);
				for (GoodsInventoryEntity goodsInventory : listGoodsInventoryEntitys) {
					goodsInventoryService.save(goodsInventory);
				}
				j.setMsg("文件导入成功！");
			} catch (Exception e) {
				j.setMsg("文件导入失败！");
				logger.error(ExceptionUtil.getExceptionMessage(e));
			}finally{
				try {
					file.getInputStream().close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return j;
	}
}
