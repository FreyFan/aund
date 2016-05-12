package com.kd.platform.poi.word.parse.excel;

import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import com.kd.platform.poi.util.PoiPublicUtil;

/**
 * <b>Application name:</b> ExcelMapParse.java <br>
 * <b>Application describing:处理和生成Map 类型的数据变成表格 </b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-6-10 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public final class ExcelMapParse {

    /**
     * 解析参数行,获取参数列表
     * @Author Frey.Fan
     * @date 2013-11-18
     * @param currentRow
     * @return
     */
    private static String[] parseCurrentRowGetParams(XWPFTableRow currentRow) {
        List<XWPFTableCell> cells = currentRow.getTableCells();
        String[] params = new String[cells.size()];
        String text;
        for (int i = 0; i < cells.size(); i++) {
            text = cells.get(i).getText();
            params[i] = text == null ? "" : text.trim().replace("{{", "").replace("}}", "");
        }
        return params;
    }

    /**
     * 解析下一行,并且生成更多的行
     * @Author Frey.Fan
     * @date 2013-11-18
     * @param table
     * @param listobj2
     */
    public static void parseNextRowAndAddRow(XWPFTable table, int index, List<Object> list) throws Exception {
        XWPFTableRow currentRow = table.getRow(index);
        String[] params = parseCurrentRowGetParams(currentRow);
        table.removeRow(index);// 移除这一行
        int cellIndex = 0;// 创建完成对象一行好像多了一个cell
        for (Object obj : list) {
            currentRow = table.createRow();
            for (cellIndex = 0; cellIndex < currentRow.getTableCells().size(); cellIndex++) {
                currentRow.getTableCells().get(cellIndex).setText(PoiPublicUtil.getValueDoWhile(obj, params[cellIndex].split("\\."), 0).toString());
            }
            for (; cellIndex < params.length; cellIndex++) {
                currentRow.createCell().setText(PoiPublicUtil.getValueDoWhile(obj, params[cellIndex].split("\\."), 0).toString());
            }
        }

    }

}
