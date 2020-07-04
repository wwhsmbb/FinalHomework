package com.conference.common;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


@Configuration
public class LoginInterceptor implements WebMvcConfigurer {
	
	
    @Bean
    public SecurityInterceptor getSecurityInterceptor(){
        return  new SecurityInterceptor();
    }
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		//默认到登陆页
        registry.addViewController("/").setViewName("forward:/login");
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration addInterceptor = registry.addInterceptor(getSecurityInterceptor());

        //放行路径配置
        addInterceptor.excludePathPatterns("/login");
        addInterceptor.excludePathPatterns("/js/**");
        addInterceptor.excludePathPatterns("/css/**");
        addInterceptor.excludePathPatterns("/fonts/**");
        addInterceptor.excludePathPatterns("/img/**");
        addInterceptor.excludePathPatterns("/plugins/**");
        //拦截路径配置
        addInterceptor.addPathPatterns("/**");
	};
	
	private class SecurityInterceptor extends HandlerInterceptorAdapter{
		 @Override
		public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
				throws Exception,ServletException {
	        HttpSession session = request.getSession();
	      //判断是否已有该用户登录的session
            if(session.getAttribute("user") !=null){
                return true;
            }else if(session.getAttribute("employee") !=null) {
            	return true;
            }
            //跳转到登录页
            String url = "/conference/login";
            response.sendRedirect(url);
            return false;
		}
	}
}
