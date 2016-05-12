package com.kd.platform.web.sms.util.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.kd.platform.core.util.LogUtil;
import com.kd.platform.web.sms.service.TSSmsServiceI;

/**
 * <b>Application name:</b> SmsSendTask.java <br>
 * <b>Application describing: 所有信息的发送定时任务类</b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-6-11 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
@Service("smsSendTask")
public class SmsSendTaskJob {

    @Autowired
    private TSSmsServiceI tSSmsService;

//    @Scheduled(cron = "0 0/1 * * * ?")
    public void run() {
        long start = System.currentTimeMillis();
        LogUtil.info("===================消息中间件定时任务开始===================");
        tSSmsService.send();
        LogUtil.info("===================消息中间件定时任务结束===================");
        long end = System.currentTimeMillis();
        long times = end - start;
        LogUtil.info("总耗时" + times + "毫秒");
    }
}
