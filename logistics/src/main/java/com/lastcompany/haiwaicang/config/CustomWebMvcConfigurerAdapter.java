package com.lastcompany.haiwaicang.config;

import com.lastcompany.haiwaicang.interceptor.HouseLoginInterceptor;
import com.lastcompany.haiwaicang.interceptor.UserLoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;


//@Configuration   //标注此文件为一个配置项，spring boot才会扫描到该配置。该注解类似于之前使用xml进行配置
////@ImportResource(locations={"classpath:spring-mvc.xml"})
//public class CustomWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter {
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        // 多个拦截器组成一个拦截器链
//        // addPathPatterns 用于添加拦截规则
//        // excludePathPatterns 用户排除拦截
//
//        registry.addInterceptor(new HouseLoginInterceptor())
//                .addPathPatterns("/biz/auction/**")
//                .addPathPatterns("/biz/house/**")
//                .addPathPatterns("/house/**")
//                .excludePathPatterns("/biz/house/pre/**")
//                .excludePathPatterns("/biz/auction/auctionitem/search")
//                .excludePathPatterns("/biz/house/defaultKaptcha")
//                .excludePathPatterns("/biz/house/getsecurityno")
//                .excludePathPatterns("/biz/house/verify_username")
//                .excludePathPatterns("/biz/house/verify_email")
//                .excludePathPatterns("/biz/house/reset_pwd_by_house")
//                .excludePathPatterns("/biz/house/registration/update")
//                .excludePathPatterns("/biz/house/login")
//                .excludePathPatterns("/biz/house/logout")
//                .excludePathPatterns("/biz/house/pageView/add")
//                .excludePathPatterns("/biz/house/invoice/sendMail")
//                .excludePathPatterns("/house/auctionlive")
//                .excludePathPatterns("/house/login")
//                .excludePathPatterns("/image/**")
//                .excludePathPatterns("/house/test")
//                .excludePathPatterns("/house/pre_reg*");
//
//
//        registry.addInterceptor(new MemberLoginInterceptor())
//                .addPathPatterns("/biz/member/**")
//                .addPathPatterns("/member/**")
//                .excludePathPatterns("/biz/member/defaultKaptcha")
//                .excludePathPatterns("/biz/member/getsecurityno")
//                .excludePathPatterns("/biz/member/verify_username")
//                .excludePathPatterns("/biz/member/verify_email")
//                .excludePathPatterns("/biz/member/reset_pwd")
//                .excludePathPatterns("/biz/member/reset_pwd2")
//                .excludePathPatterns("/biz/member/checkToken")
//                .excludePathPatterns("/biz/member/activate")
//                .excludePathPatterns("/biz/member/reset_email_pwd")
//                .excludePathPatterns("/biz/member/bidding/getcurrentprice")
//                .excludePathPatterns("/biz/member/reg")
//                .excludePathPatterns("/biz/member/login")
//                .excludePathPatterns("/biz/member/logout")
//                .excludePathPatterns("/image/**")
//                .excludePathPatterns("/member/activateMember")
//                .excludePathPatterns("/member/resetemailredirct")
//                .excludePathPatterns("/member/resetpwd")
//                .excludePathPatterns("/member/reg")
//                .excludePathPatterns("/member/reg_success")
//                .excludePathPatterns("/member/login")
//                .excludePathPatterns("/member/auctionlive");
//
//        registry.addInterceptor(new AdminLoginInterceptor())
//                .addPathPatterns("/biz/admin/**")
//                .addPathPatterns("/admin/**")
//                .excludePathPatterns("/biz/admin/defaultKaptcha")
//                .excludePathPatterns("/biz/admin/getsecurityno")
//                .excludePathPatterns("/biz/admin/login")
//                .excludePathPatterns("/biz/admin/logout")
//                .excludePathPatterns("/image/**")
//                .excludePathPatterns("/admin/login");
//
//
//        super.addInterceptors(registry);
//    }
//}

@Configuration
public class CustomWebMvcConfigurerAdapter extends WebMvcConfigurationSupport {

        @Override
    public void addInterceptors(InterceptorRegistry registry) {
            // 多个拦截器组成一个拦截器链
            // addPathPatterns 用于添加拦截规则
            // excludePathPatterns 用户排除拦截

            InterceptorRegistration aa= registry.addInterceptor(new UserLoginInterceptor());

            aa.addPathPatterns("/user/**");
            aa.excludePathPatterns("/user/login");

            super.addInterceptors(registry);
        }

}