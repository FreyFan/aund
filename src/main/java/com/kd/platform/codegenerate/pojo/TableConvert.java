package com.kd.platform.codegenerate.pojo;

import org.apache.commons.lang.StringUtils;

/**
 * <b>Application name:</b> TableConvert.java <br>
 * <b>Application describing: </b> <br>
 * <b>Copyright:</b> Copyright &copy; 2014 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2014-4-18 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class TableConvert {
    public static String getNullAble(String nullable) {
        if (("YES".equals(nullable)) || ("yes".equals(nullable)) || ("y".equals(nullable)) || ("Y".equals(nullable)) || ("f".equals(nullable))) {
            return "Y";
        }
        if (("NO".equals(nullable)) || ("N".equals(nullable)) || ("no".equals(nullable)) || ("n".equals(nullable)) || ("t".equals(nullable))) {
            return "N";
        }
        return null;
    }

    public static String getNullString(String nullable) {
        if (StringUtils.isBlank(nullable)) {
            return "";
        }
        return nullable;
    }

    public static String getV(String s) {
        return "'" + s + "'";
    }
}
