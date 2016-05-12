package com.kd.platform.poi.cache;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import com.kd.platform.poi.cache.manager.POICacheManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Excel类型的缓存
 * @author Frey.Fan
 * @date 2014年2月11日
 * @version 1.0
 */
public final class ExcelCache {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExcelCache.class);

    public static Workbook getWorkbook(String url, Integer[] sheetNums, boolean needAll) {
        InputStream is = null;
        List<Integer> sheetList = Arrays.asList(sheetNums);
        try {
            is = POICacheManager.getFile(url);
            Workbook wb = WorkbookFactory.create(is);
            // 删除其他的sheet
            if (!needAll) {
                for (int i = wb.getNumberOfSheets() - 1; i >= 0; i--) {
                    if (!sheetList.contains(i)) {
                        wb.removeSheetAt(i);
                    }
                }
            }
            return wb;
        } catch (InvalidFormatException e) {
            LOGGER.error(e.getMessage(), e);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        } finally {
            try {
                is.close();
            } catch (Exception e) {
                LOGGER.error(e.getMessage(), e);
            }
        }
        return null;
    }

}
