package com.kd.platform.web.sms.util.msg.util;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * <b>Application name:</b> MsgActivityTimer.java <br>
 * <b>Application describing:做激活测试用的判断是否在连接如果不在进行链路连接. </b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-6-11 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class MsgActivityTimer extends QuartzJobBean {
    /**
     * 短信接口长链接，定时进行链路检查.
     * @param arg0 JobExecutionContext
     * @exception JobExecutionException JobExecutionException
     */
    protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
        System.out.println("×××××××××××××开始链路检查××××××××××××××");
        int count = 0;
        boolean result = MsgContainer.activityTestISMG();
        while (!result) {
            count++;
            result = MsgContainer.activityTestISMG();
            if (count >= (MsgConfig.getConnectCount() - 1)) {// 如果再次链路检查次数超过两次则终止连接
                break;
            }
        }
        System.out.println("×××××××××××××链路检查结束××××××××××××××");
    }
}
