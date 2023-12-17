package com.example.S2.config;


import com.example.S2.context.RequestContext;
import com.example.S2.interceptor.MainInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private MainInterceptor mainInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(mainInterceptor).addPathPatterns("/requestPK/**");;
        // You can also specify URL patterns to include or exclude.
        // Example: registry.addInterceptor(myInterceptor).addPathPatterns("/api/*");
    }
}
