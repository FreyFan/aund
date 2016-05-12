package com.kd.platform.web.system.controller.core;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.batik.transcoder.Transcoder;
import org.apache.batik.transcoder.TranscoderException;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.JPEGTranscoder;
import org.apache.batik.transcoder.image.PNGTranscoder;
import org.apache.fop.svg.PDFTranscoder;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kd.platform.core.common.controller.BaseController;
import com.kd.platform.core.common.hibernate.qbc.CriteriaQuery;
import com.kd.platform.core.common.model.json.DataGrid;
import com.kd.platform.core.common.model.json.Highchart;
import com.kd.platform.core.util.DateUtils;
import com.kd.platform.core.util.MutiLangUtil;
import com.kd.platform.core.util.StringUtil;
import com.kd.platform.core.util.oConvertUtils;
import com.kd.platform.tag.core.easyui.TagUtil;
import com.kd.platform.web.system.pojo.base.TSLog;
import com.kd.platform.web.system.service.SystemService;

/**
 * <b>Application name:</b> LogController.java <br>
 * <b>Application describing: 日志处理类</b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-7-7 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
@Controller
@RequestMapping("/logController")
public class LogController extends BaseController {
    /**
     * Logger for this class
     */
    private static final Logger logger = Logger.getLogger(LogController.class);

    // 用户浏览器统计分析的国际化KEY
    private static final String USER_BROWSER_ANALYSIS = "user.browser.analysis";

    @Autowired
    private SystemService systemService;

    /**
     * 操作日志列表页面跳转
     * @return
     */
    @RequestMapping(params = "operationLog")
    public ModelAndView operationLog() {
        return new ModelAndView("system/log/operationLogList");
    }

    /**
     * easyuiAJAX请求数据
     * @param request
     * @param response
     * @param dataGrid
     */
    @RequestMapping(params = "operationDatagrid")
    public void operationDatagrid(HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
        CriteriaQuery cq = new CriteriaQuery(TSLog.class, dataGrid);
        String loglevel = request.getParameter("loglevel");
        if (loglevel == null || loglevel.equals("0")) {
            cq.notEq("loglevel", (short) 6);
        } else {
            cq.eq("loglevel", oConvertUtils.getShort(loglevel));
        }

        String operatetime_begin = request.getParameter("operatetime_begin");
        if (!StringUtil.isEmpty(operatetime_begin)) {
            Timestamp beginValue = null;
            try {
                beginValue = DateUtils.parseTimestamp(operatetime_begin, "yyyy-MM-dd");
            } catch (ParseException e) {
                e.printStackTrace();
            }
            cq.ge("operatetime", beginValue);
        }

        String operatetime_end = request.getParameter("operatetime_end");
        if (!StringUtil.isEmpty(operatetime_end)) {
            if (operatetime_end.length() == 10) {
                operatetime_end = operatetime_end + " 23:59:59";
            }
            Timestamp endValue = null;
            try {
                endValue = DateUtils.parseTimestamp(operatetime_end, "yyyy-MM-dd hh:mm:ss");
            } catch (ParseException e) {
                e.printStackTrace();
            }
            cq.le("operatetime", endValue);
        }

        cq.add();
        this.systemService.getDataGridReturn(cq, true);
        TagUtil.datagrid(response, dataGrid);
    }
    
    /**
     * 异常日志列表页面跳转
     * @return
     */
    @RequestMapping(params = "exceptionLog")
    public ModelAndView exceptionLog() {
        return new ModelAndView("system/log/exceptionLogList");
    }

    /**
     * easyuiAJAX请求数据
     * @param request
     * @param response
     * @param dataGrid
     */
    @RequestMapping(params = "exceptionDatagrid")
    public void exceptionDatagrid(HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
        CriteriaQuery cq = new CriteriaQuery(TSLog.class, dataGrid);
            
        cq.eq("loglevel", (short) 6);
        String operatetime_begin = request.getParameter("operatetime_begin");
        if (!StringUtil.isEmpty(operatetime_begin)) {
            Timestamp beginValue = null;
            try {
                beginValue = DateUtils.parseTimestamp(operatetime_begin, "yyyy-MM-dd");
            } catch (ParseException e) {
                e.printStackTrace();
            }
            cq.ge("operatetime", beginValue);
        }

        String operatetime_end = request.getParameter("operatetime_end");
        if (!StringUtil.isEmpty(operatetime_end)) {
            if (operatetime_end.length() == 10) {
                operatetime_end = operatetime_end + " 23:59:59";
            }
            Timestamp endValue = null;
            try {
                endValue = DateUtils.parseTimestamp(operatetime_end, "yyyy-MM-dd hh:mm:ss");
            } catch (ParseException e) {
                e.printStackTrace();
            }
            cq.le("operatetime", endValue);
        }

        cq.add();
        this.systemService.getDataGridReturn(cq, true);
        TagUtil.datagrid(response, dataGrid);
    }

    /**
     * 获取日志详情
     * @param tsLog
     * @param request
     * @return
     * @Author fangwenrong
     * @Date 2015-05-10
     */
    @RequestMapping(params = "logDetail")
    public ModelAndView logDetail(TSLog tsLog, HttpServletRequest request) {
        if (StringUtil.isNotEmpty(tsLog.getId())) {
            tsLog = systemService.getEntity(TSLog.class, tsLog.getId());
            request.setAttribute("tsLog", tsLog);
        }
        return new ModelAndView("system/log/logDetail");

    }

    /**
     * 统计集合页面
     * @return
     */
    @RequestMapping(params = "statisticTabs")
    public ModelAndView statisticTabs(HttpServletRequest request) {
        return new ModelAndView("system/log/statisticTabs");
    }

    /**
     * 用户浏览器使用统计图
     * @return
     */
    @RequestMapping(params = "userBroswer")
    public ModelAndView userBroswer(String reportType, HttpServletRequest request) {
        request.setAttribute("reportType", reportType);
        if ("pie".equals(reportType)) {
            return new ModelAndView("system/log/userBroswerPie");
        } else if ("line".equals(reportType)) {
            return new ModelAndView("system/log/userBroswerLine");
        }
        return new ModelAndView("system/log/userBroswerColumn");
    }

    /**
     * 报表数据生成
     * @return
     */
    @RequestMapping(params = "getBroswerBar")
    @ResponseBody
    public List<Highchart> getBroswerBar(HttpServletRequest request, String reportType, HttpServletResponse response) {
        List<Highchart> list = new ArrayList<Highchart>();
        Highchart hc = new Highchart();
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT broswer ,count(broswer) FROM TSLog group by broswer");
        List userBroswerList = systemService.findByQueryString(sb.toString());
        Long count = systemService.getCountForJdbc("SELECT COUNT(1) FROM PLATFORM.T_S_Log WHERE 1=1");
        List lt = new ArrayList();
        hc = new Highchart();
        hc.setName(MutiLangUtil.getMutiLangInstance().getLang(USER_BROWSER_ANALYSIS));
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
     * hightchart导出图片
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(params = "export")
    public void export(HttpServletRequest request, HttpServletResponse response) throws IOException {
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
                } else if (type.equals("image/svg+xml")) ext = "svg";
                response.addHeader("Content-Disposition", "attachment; filename=" + new String(filename.getBytes("GBK"), "ISO-8859-1") + "." + ext);
                response.addHeader("Content-Type", type);

                if (null != t) {
                    TranscoderInput input = new TranscoderInput(new StringReader(svg));
                    TranscoderOutput output = new TranscoderOutput(out);

                    try {
                        t.transcode(input, output);
                    } catch (TranscoderException e) {
                        out.print("Problem transcoding stream. See the web logs for more details.");
                        e.printStackTrace();
                    }
                } else if (ext.equals("svg")) {
                    // out.print(svg);
                    OutputStreamWriter writer = new OutputStreamWriter(out, "UTF-8");
                    writer.append(svg);
                    writer.close();
                } else
                    out.print("Invalid type: " + type);
            } else {
                response.addHeader("Content-Type", "text/html");
                out.println("Usage:\n\tParameter [svg]: The DOM Element to be converted." + "\n\tParameter [type]: The destination MIME type for the elment to be transcoded.");
            }
        } finally {
            if (out != null) {
                out.flush();
                out.close();
            }
        }
    }
}
