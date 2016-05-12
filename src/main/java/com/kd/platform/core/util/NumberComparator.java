package com.kd.platform.core.util;

import java.util.Comparator;

import com.kd.platform.web.system.pojo.base.TSFunction;

/**
 * <b>Application name:</b> NumberComparator.java <br>
 * <b>Application describing:字符串比较器 </b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-6-29 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class NumberComparator implements Comparator<Object> {
    private boolean ignoreCase = true;

    public NumberComparator() {
    }

    public NumberComparator(boolean ignoreCase) {
        this.ignoreCase = ignoreCase;
    }

    public int compare(Object obj1, Object obj2) {
        String o1 = "";
        String o2 = "";
        if (ignoreCase) {
            TSFunction c1 = (TSFunction) obj1;
            TSFunction c2 = (TSFunction) obj2;
            o1 = c1.getFunctionOrder();
            o2 = c2.getFunctionOrder();
        }
        if (o1 != null && o2 != null) {
            for (int i = 0; i < o1.length(); i++) {
                if (i == o1.length() && i < o2.length()) {
                    return -1;
                } else if (i == o2.length() && i < o1.length()) {
                    return 1;
                }
                char ch1 = o1.charAt(i);
                char ch2 = o2.charAt(i);
                if (ch1 >= '0' && ch2 <= '9') {
                    int i1 = getNumber(o1.substring(i));
                    int i2 = getNumber(o2.substring(i));
                    if (i1 == i2) {
                        continue;
                    } else {
                        return i1 - i2;
                    }
                } else if (ch1 != ch2) {
                    return ch1 - ch2;
                }
            }
        }
        return 0;
    }

    private int getNumber(String str) {
        int num = Integer.MAX_VALUE;
        int bits = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                bits++;
            } else {
                break;
            }
        }
        if (bits > 0) {
            num = Integer.parseInt(str.substring(0, bits));
        }
        return num;
    }
}
