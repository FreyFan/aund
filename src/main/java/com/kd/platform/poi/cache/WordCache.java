package com.kd.platform.poi.cache;

import java.io.InputStream;

import com.kd.platform.poi.cache.manager.POICacheManager;
import com.kd.platform.poi.word.entity.MyXWPFDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <b>Application name:</b> WordCache.java <br>
 * <b>Application describing:word 缓存中心 </b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-6-9 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class WordCache {

    private static final Logger LOGGER = LoggerFactory.getLogger(WordCache.class);

    public static MyXWPFDocument getXWPFDocumen(String url) {
        InputStream is = null;
        try {
            is = POICacheManager.getFile(url);
            MyXWPFDocument doc = new MyXWPFDocument(is);
            return doc;
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
