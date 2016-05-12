package com.kd.business.member.controller;
import com.kd.business.member.entity.MemberEntity;
import com.kd.business.member.service.MemberServiceI;
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
 * <b>Application name:</b> MemberController.java <br>
 * <b>Application describing:会员表 </b> <br>
 * <b>Copyright:</b> Copyright &copy; 2014 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2016-03-19 23:12:42 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
@Scope("prototype")
@Controller
@RequestMapping("/memberController")
public class MemberController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(MemberController.class);

	@Autowired
	private MemberServiceI memberService;
	
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
	 * 会员表列表 页面跳转
	 * @return
	 */
	@RequestMapping(params = "member")
	public ModelAndView member(HttpServletRequest request) {
		return new ModelAndView("com/kd/business/member/memberList");
	}

	/**
	 * easyui AJAX请求数据
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param user
	 */
	@RequestMapping(params = "datagrid")
	public void datagrid(MemberEntity member,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(MemberEntity.class, dataGrid);
		//查询条件组装器
		HqlGenerateUtil.installHql(cq, member, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.memberService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除会员表
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(MemberEntity member, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		member = systemService.getEntity(MemberEntity.class, member.getId());
		message = "会员表删除成功";
		try{
			memberService.delete(member);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "会员表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除会员表
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		message = "会员表删除成功";
		try{
			for(String id:ids.split(",")){
				MemberEntity member = systemService.getEntity(MemberEntity.class, 
				id
				);
				memberService.delete(member);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "会员表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加会员表
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(MemberEntity member, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "会员表添加成功";
		try{
			memberService.save(member);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "会员表添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新会员表
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(MemberEntity member, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "会员表更新成功";
		MemberEntity t = memberService.get(MemberEntity.class, member.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(member, t);
			memberService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "会员表更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 会员表新增页面跳转
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(MemberEntity member, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(member.getId())) {
			member = memberService.getEntity(MemberEntity.class, member.getId());
			req.setAttribute("memberPage", member);
		}
		return new ModelAndView("com/kd/business/member/member-add");
	}
	
	/**
	 * 会员表编辑页面跳转
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(MemberEntity member, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(member.getId())) {
			member = memberService.getEntity(MemberEntity.class, member.getId());
			req.setAttribute("memberPage", member);
		}
		return new ModelAndView("com/kd/business/member/member-update");
	}
	
	/**
	 * 导入功能跳转
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","memberController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(MemberEntity member,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(MemberEntity.class, dataGrid);
		HqlGenerateUtil.installHql(cq, member, request.getParameterMap());
		List<MemberEntity> members = this.memberService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"会员表");
		modelMap.put(NormalExcelConstants.CLASS,MemberEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("会员表列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,members);
		return NormalExcelConstants.PLATFORM_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(MemberEntity member,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		modelMap.put(TemplateExcelConstants.FILE_NAME, "会员表");
		modelMap.put(TemplateExcelConstants.PARAMS,new TemplateExportParams("Excel模板地址"));
		modelMap.put(TemplateExcelConstants.MAP_DATA,null);
		modelMap.put(TemplateExcelConstants.CLASS,MemberEntity.class);
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
				List<MemberEntity> listMemberEntitys = ExcelImportUtil.importExcel(file.getInputStream(),MemberEntity.class,params);
				for (MemberEntity member : listMemberEntitys) {
					memberService.save(member);
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
