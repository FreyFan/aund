package com.kd.platform.poi.exception.word;

import com.kd.platform.poi.exception.word.enmus.WordExportEnum;

/**
 * <b>Application name:</b> WordExportException.java <br>
 * <b>Application describing:word导出异常 </b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-6-10 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class WordExportException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public WordExportException() {
        super();
    }

    public WordExportException(String msg) {
        super(msg);
    }

    public WordExportException(WordExportEnum exception) {
        super(exception.getMsg());
    }

}
