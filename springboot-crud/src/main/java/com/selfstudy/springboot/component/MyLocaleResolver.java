package com.selfstudy.springboot.component;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * ClassName :MyLocaleResolver
 * Package :com.selfstudy.springboot.component
 * Description : 区域信息解析器
 *LocaleResolver区域信息解析器条件好之后添加到bean容器中
 * @author :张哈哈
 * @date :2020/10/18 18:26
 */
public class MyLocaleResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        String l = httpServletRequest.getParameter("l");
        Locale locale = Locale.getDefault();
        if (!StringUtils.isEmpty(l)){
            String[] split = l.split("_");
            locale =new Locale(split[0],split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
