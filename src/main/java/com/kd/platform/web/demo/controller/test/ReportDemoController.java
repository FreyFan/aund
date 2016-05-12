package com.kd.platform.web.demo.controller.test;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kd.platform.web.system.service.MutiLangServiceI;
import com.kd.platform.web.system.service.SystemService;
import org.apache.batik.transcoder.Transcoder;
import org.apache.batik.transcoder.TranscoderException;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.JPEGTranscoder;
import org.apache.batik.transcoder.image.PNGTranscoder;
import org.apache.fop.svg.PDFTranscoder;
import org.apache.log4j.Logger;
import com.kd.platform.core.common.controller.BaseController;
import com.kd.platform.core.common.dao.jdbc.JdbcDao;
import com.kd.platform.core.common.model.json.DataGrid;
import com.kd.platform.core.common.model.json.Highchart;
import com.kd.platform.core.util.DBTypeUtil;
import com.kd.platform.tag.core.easyui.TagUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 报表demo控制器
 * 
 * @author xiehs
 */
@Controller
@RequestMapping("/reportDemoController")
public class ReportDemoController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger
			.getLogger(ReportDemoController.class);

	@Autowired
	private SystemService systemService;

	@Autowired
	private MutiLangServiceI mutiLangService;

	@RequestMapping(params = "listAllStatisticByJdbc")
	public void listAllStatisticByJdbc(HttpServletRequest request,
			HttpServletResponse response, DataGrid dataGrid) {
		List<Map<String, Object>> maplist = systemService
				.findForJdbc(
						"SELECT s.classname classname ,count(className) personcount FROM PLATFORM.T_s_Student s group by s.className",
						null);
		Long countSutent = systemService
				.getCountForJdbc("SELECT COUNT(1) FROM PLATFORM.T_S_student WHERE 1=1");
		for (Map map : maplist) {
			Long personcount = Long
					.parseLong(map.get("personcount").toString());
			Double percentage = 0.0;
			if (personcount != null && personcount.intValue() != 0) {
				percentage = new Double(personcount) / countSutent;
			}

			map.put("rate", String.format("%.2f", percentage * 100) + "%");
		}
		Long count = 0L;
		if (JdbcDao.DATABSE_TYPE_SQLSERVER.equals(DBTypeUtil.getDBType())) {
			count = systemService
					.getCountForJdbcParam(
							"select count(0) from (SELECT s.className  classname ,count(className) totalclass FROM PLATFORM.T_s_Student  s group by s.className) as t( classname, totalclass)",
							null);
		} else {
			count = systemService
					.getCountForJdbcParam(
							"select count(0) from (SELECT s.className ,count(className) FROM PLATFORM.T_s_Student s group by s.className)t",
							null);
		}

		dataGrid.setTotal(count.intValue());
		dataGrid.setResults(maplist);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 统计集合页面
	 * 
	 * @return
	 */
	@RequestMapping(params = "studentStatisticTabs")
	public ModelAndView studentStatisticTabs(HttpServletRequest request) {
		// SmartSocketAnalyze reportDemo
		return new ModelAndView("platform/demo/base/report/reportDemo");
	}

	/**
	 * 报表数据生成
	 * 
	 * @return
	 */
	@RequestMapping(params = "studentCount")
	@ResponseBody
	public List<Highchart> studentCount(HttpServletRequest request,
			String reportType, HttpServletResponse response) {
		List<Highchart> list = new ArrayList<Highchart>();
		Highchart hc = new Highchart();
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT className ,count(className) FROM TSStudent group by className");
		List userBroswerList = systemService.findByQueryString(sb.toString());
		Long count = systemService
				.getCountForJdbc("SELECT COUNT(1) FROM PLATFORM.T_S_student WHERE 1=1");
		List lt = new ArrayList();
		hc = new Highchart();
		hc.setName("停电时户数分析");
		hc.setType(reportType);
		Map<String, Object> map;
		if (userBroswerList.size() > 0) {
			for (Object object : userBroswerList) {
				map = new HashMap<String, Object>();
				Object[] obj = (Object[]) object;
				map.put("name", obj[0]);
				map.put("y", obj[1]);
				Long groupCount = (Long) obj[1];
				Double percentage = 0.0;
				if (count != null && count.intValue() != 0) {
					percentage = new Double(groupCount) / count;
				}
				map.put("percentage", percentage * 100);
				lt.add(map);
			}
		}
		hc.setData(lt);
		list.add(hc);
		return list;
	}

	/**
	 * 设备状态
	 * 
	 * @return
	 */
	@RequestMapping(params = "deviceStatus")
	@ResponseBody
	public List<Highchart> deviceStatus(HttpServletRequest request,
			String reportType, HttpServletResponse response) {
		List<Highchart> list = new ArrayList<Highchart>();
		Highchart hc = new Highchart();
		List lt = new ArrayList();
		hc = new Highchart();
		hc.setName("设备状态");
		hc.setType(reportType);
		Map<String, Object> map;
		map = new HashMap<String, Object>();
		map.put("name", "失联状态");
		map.put("y", 20);
		map.put("percentage", 20 / 600 * 100);
		lt.add(map);
		
		map = new HashMap<String, Object>();
		map.put("name", "连通状态");
		map.put("y", 500);
		map.put("percentage", 500 / 600 * 100);
		lt.add(map);
		
		map = new HashMap<String, Object>();
		map.put("name", "关闭状态");
		map.put("y", 80);
		map.put("percentage", 66 / 600 * 100);
		lt.add(map);
		
		map = new HashMap<String, Object>();
		map.put("name", "离线状态");
		map.put("y", 80);
		map.put("percentage", 14 / 600 * 100);
		lt.add(map);
		hc.setData(lt);
		list.add(hc);
		return list;
	}
	
	/**
	 * 设备位置分布情况
	 * 
	 * @return
	 */
	@RequestMapping(params = "equipmentPosition")
	@ResponseBody
	public List<Highchart> equipmentPosition(HttpServletRequest request,
			String reportType, HttpServletResponse response) {
		List<Highchart> list = new ArrayList<Highchart>();
		Highchart hc = new Highchart();
		List lt = new ArrayList();
		hc = new Highchart();
		hc.setName("设备位置分布情况");
		hc.setType(reportType);
		Map<String, Object> map;
		map = new HashMap<String, Object>();
		map.put("name", "科研楼");
		map.put("y", 150);
		map.put("percentage", 150);
		lt.add(map);
		
		map = new HashMap<String, Object>();
		map.put("name", "教学楼");
		map.put("y", 100);
		map.put("percentage", 100);
		lt.add(map);
		
		map = new HashMap<String, Object>();
		map.put("name", "冶金楼");
		map.put("y", 200);
		map.put("percentage", 200);
		lt.add(map);
		
		map = new HashMap<String, Object>();
		map.put("name", "逸夫楼");
		map.put("y", 150);
		map.put("percentage", 150);
		lt.add(map);
		hc.setData(lt);
		list.add(hc);
		return list;
	}
	
	/**
	 * 设备功能分布情况
	 * 
	 * @return
	 */
	@RequestMapping(params = "deviceFunction")
	@ResponseBody
	public List<Highchart> deviceFunction(HttpServletRequest request,
			String reportType, HttpServletResponse response) {
		List<Highchart> list = new ArrayList<Highchart>();
		Highchart hc = new Highchart();
		List lt = new ArrayList();
		hc = new Highchart();
		hc.setName("设备功能分布情况");
		hc.setType(reportType);
		Map<String, Object> map;
		map = new HashMap<String, Object>();
		map.put("name", "饮水机");
		map.put("y", 110);
		map.put("percentage", 110);
		lt.add(map);
		
		map = new HashMap<String, Object>();
		map.put("name", "打印机");
		map.put("y", 80);
		map.put("percentage", 80);
		lt.add(map);
		
		map = new HashMap<String, Object>();
		map.put("name", "空调");
		map.put("y", 50);
		map.put("percentage", 50);
		lt.add(map);
		
		map = new HashMap<String, Object>();
		map.put("name", "计算机");
		map.put("y", 220);
		map.put("percentage", 220);
		lt.add(map);
		
		map = new HashMap<String, Object>();
		map.put("name", "其他");
		map.put("y", 140);
		map.put("percentage", 140);
		lt.add(map);
		hc.setData(lt);
		list.add(hc);
		return list;
	}

	/**
	 * 报表打印
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(params = "export")
	public void export(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String type = request.getParameter("type");
		String svg = request.getParameter("svg");
		String filename = request.getParameter("filename");

		filename = filename == null ? "chart" : filename;
		ServletOutputStream out = response.getOutputStream();
		try {
			if (null != type && null != svg) {
				svg = svg.replaceAll(":rect", "rect");
				String ext = "";
				Transcoder t = null;
				if (type.equals("image/png")) {
					ext = "png";
					t = new PNGTranscoder();
				} else if (type.equals("image/jpeg")) {
					ext = "jpg";
					t = new JPEGTranscoder();
				} else if (type.equals("application/pdf")) {
					ext = "pdf";
					t = (Transcoder) new PDFTranscoder();
				} else if (type.equals("image/svg+xml"))
					ext = "svg";
				response.addHeader(
						"Content-Disposition",
						"attachment; filename="
								+ new String(filename.getBytes("GBK"),
										"ISO-8859-1") + "." + ext);
				response.addHeader("Content-Type", type);

				if (null != t) {
					TranscoderInput input = new TranscoderInput(
							new StringReader(svg));
					TranscoderOutput output = new TranscoderOutput(out);

					try {
						t.transcode(input, output);
					} catch (TranscoderException e) {
						out.print("Problem transcoding stream. See the web logs for more details.");
						e.printStackTrace();
					}
				} else if (ext.equals("svg")) {
					// out.print(svg);
					OutputStreamWriter writer = new OutputStreamWriter(out,
							"UTF-8");
					writer.append(svg);
					writer.close();
				} else
					out.print("Invalid type: " + type);
			} else {
				response.addHeader("Content-Type", "text/html");
				out.println("Usage:\n\tParameter [svg]: The DOM Element to be converted."
						+ "\n\tParameter [type]: The destination MIME type for the elment to be transcoded.");
			}
		} finally {
			if (out != null) {
				out.flush();
				out.close();
			}
		}
	}
}