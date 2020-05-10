package com.gl52.euv.config;

import com.gl52.euv.component.LoginHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/EUV").setViewName("login1");
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/main.html").setViewName("homePage");
        registry.addViewController("/showProject.html").setViewName("projects");

    }
    //注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //做好静态资源映射 不处理静态资源
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/","/EUV", "/main.html","/User/toLogin.do");
    }
}
