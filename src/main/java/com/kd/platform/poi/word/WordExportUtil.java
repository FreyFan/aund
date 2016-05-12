package com.kd.platform.poi.word;

import java.util.Map;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import com.kd.platform.poi.word.parse.ParseWord07;

/**
 * <b>Application name:</b> WordExportUtil.java <br>
 * <b>Application describing:Word使用模板导出工具类 </b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-6-10 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public final class WordExportUtil {

    private WordExportUtil() {

    }

    /**
     * 解析Word2007版本
     * @param url 模板地址
     * @param map 解析数据源
     * @return
     */
    public static XWPFDocument exportWord07(String url, Map<String, Object> map) throws Exception {
        return new ParseWord07().parseWord(url, map);
    }

    /**
     * 解析Word2007版本
     * @param XWPFDocument 模板
     * @param map 解析数据源
     * @return
     */
    public static void exportWord07(XWPFDocument document, Map<String, Object> map) throws Exception {
        new ParseWord07().parseWord(document, map);
    }
}
