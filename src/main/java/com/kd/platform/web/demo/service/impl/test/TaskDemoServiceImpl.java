package com.kd.platform.web.demo.service.impl.test;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.kd.platform.core.util.LogUtil;
import com.kd.platform.web.demo.service.test.TaskDemoServiceI;

@Service("taskDemoService")
public class TaskDemoServiceImpl implements TaskDemoServiceI {
    public void work() {
        LogUtil.info(new Date().getTime());
        LogUtil.info("----------任务测试-------");
    }
}
