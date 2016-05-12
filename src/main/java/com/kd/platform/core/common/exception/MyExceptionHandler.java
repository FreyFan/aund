package com.kd.platform.core.common.exception;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.kd.platform.core.util.ExceptionUtil;

/**
 * <b>Application name:</b> MyExceptionHandler.java <br>
 * <b>Application describing: spring mvc异常捕获类</b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-6-29 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
@Component
public class MyExceptionHandler implements HandlerExceptionResolver {

    private static final Logger logger = Logger.getLogger(MyExceptionHandler.class);

    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        String exceptionMessage = ExceptionUtil.getExceptionMessage(ex);
        logger.error(exceptionMessage);
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("exceptionMessage", exceptionMessage);
        model.put("ex", ex);
        return new ModelAndView("common/error", model);
    }
}
