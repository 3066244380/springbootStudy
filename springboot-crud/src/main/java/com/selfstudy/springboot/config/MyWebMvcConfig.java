package com.selfstudy.springboot.config;

import com.selfstudy.springboot.component.LoginHandlerInterceptor;
import com.selfstudy.springboot.component.MyLocaleResolver;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Locale;

/**
 * ClassName :MyWebMvcConfig
 * Package :com.selfstudy.springboot.config
 * Description :
 *
 * @author :张哈哈
 * @date :2020/10/16 20:14
 */
@Configuration
public class MyWebMvcConfig extends WebMvcConfigurerAdapter {

    //所有的WebMvcConfigurerAdapter组件都会一起起作用
    @Bean //将组件注册在容器
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter(){
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("index");
                registry.addViewController("/index.html").setViewName("index");
                registry.addViewController("/main.html").setViewName("dashboard");

            }

            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                //super.addInterceptors(registry);
                //当静态文件css样式不显示的时候在拦截器中加入"/asserts/**","/webjars/**"
                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                        .excludePathPatterns("/crud","/index.html","/user/login","/asserts/**","/webjars/**");
            }
        };
        return adapter;
    }


    @Bean
    public LocaleResolver localeResolver(){
        return  new MyLocaleResolver();
    }

}
