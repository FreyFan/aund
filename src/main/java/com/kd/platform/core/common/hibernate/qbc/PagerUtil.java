package com.kd.platform.core.common.hibernate.qbc;

import java.util.Map;

import com.kd.platform.core.util.LogUtil;

/**
 * <b>Application name:</b> PagerUtil.java <br>
 * <b>Application describing: 分页工具类</b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-6-29 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class PagerUtil {
    public PagerUtil() {

    }

    public static String getBar(String action, String form, int allCounts, int curPageNO, int pageSize, Map<String, Object> map) {
        Pager pager = null;
        try {
            if (curPageNO > (int) Math.ceil((double) allCounts / pageSize)) curPageNO = (int) Math.ceil((double) allCounts / pageSize);
            if (curPageNO <= 1) curPageNO = 1;
            // 得到offset
            pager = new Pager(allCounts, curPageNO, pageSize, map);
        } catch (Exception e) {
            LogUtil.info("生成工具条出错!");
        }
        return pager.getToolBar(action, form);
    }

    public static String getBar(String url, int allCounts, int curPageNO, int pageSize, Map<String, Object> map) {
        Pager pager = null;
        try {
            if (curPageNO > (int) Math.ceil((double) allCounts / pageSize)) curPageNO = (int) Math.ceil((double) allCounts / pageSize);
            if (curPageNO <= 1) curPageNO = 1;
            // 得到offset
            // 生成工具条
            pager = new Pager(allCounts, curPageNO, pageSize, map);
        } catch (Exception e) {
            LogUtil.info("生成工具条出错!");
        }
        return pager.getToolBar(url);
    }

    public static int getOffset(int rowCounts, int curPageNO, int pageSize) {
        int offset = 0;
        try {
            if (curPageNO > (int) Math.ceil((double) rowCounts / pageSize)) curPageNO = (int) Math.ceil((double) rowCounts / pageSize);
            // 得到第几页
            if (curPageNO <= 1) curPageNO = 1;
            // 得到offset
            offset = (curPageNO - 1) * pageSize;
        } catch (Exception e) {
            LogUtil.info("getOffset出错!");
        }
        return offset;
    }

    public static int getcurPageNo(int rowCounts, int curPageNO, int pageSize) {
        try {
            // 得到第几页
            if (curPageNO > (int) Math.ceil((double) rowCounts / pageSize)) curPageNO = (int) Math.ceil((double) rowCounts / pageSize);
            if (curPageNO <= 1) curPageNO = 1;
        } catch (Exception e) {
            LogUtil.info("getOffset出错!");
        }
        return curPageNO;
    }
}
