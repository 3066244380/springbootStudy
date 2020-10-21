package com.selfstudy.springboot.component;

import org.springframework.web.servlet.HandlerInterceptor;
import org.thymeleaf.util.ObjectUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ClassName :LoginHandlerInterceptor
 * Package :com.selfstudy.springboot.component
 * Description :登录   拦截器 HandlerInterceptor
 *
 * @author :张哈哈
 * @date :2020/10/18 21:06
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object loginUser = request.getSession().getAttribute("loginUser");
        if (loginUser == null){
            //未登录
            request.setAttribute("msg", "没有权限请登录");
            request.getRequestDispatcher("/index.html").forward(request, response);
            return false;
        }else{
            //登录
            return true;
        }
    }
}
