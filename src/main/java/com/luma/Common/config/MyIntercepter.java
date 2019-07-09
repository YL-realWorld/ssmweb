package com.luma.Common.config;

import com.luma.Common.pojos.vo.UserLogin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 自定义拦截器，拦截用户操作
 */
public class MyIntercepter implements HandlerInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyIntercepter.class);

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String requestURI = httpServletRequest.getRequestURI();
        LOGGER.info("RequestURI:{}", requestURI);
        if (requestURI.endsWith("/") || requestURI.equals("/home/login.php") || requestURI.equals("/home/error.php")) {
            return true;
        }
        HttpSession session = httpServletRequest.getSession();
        Object login = session.getAttribute(UserLogin.PathType.LOGIN.getValue());
        if (login instanceof String) {
            if (login.equals(UserLogin.Role.ADMIN.getValue())) {
                LOGGER.info("check user pass.");
                return true;
            }
        }
        httpServletResponse.sendRedirect("/");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
