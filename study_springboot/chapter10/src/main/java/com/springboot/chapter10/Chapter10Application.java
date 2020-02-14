package com.springboot.chapter10;

import com.springboot.chapter10.interceptor.Interceptor1;
import com.springboot.chapter10.interceptor.MultiInterceptor1;
import com.springboot.chapter10.interceptor.MultiInterceptor2;
import com.springboot.chapter10.interceptor.MultiInterceptor3;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@SpringBootApplication(scanBasePackages = "com.springboot.chapter10")
public class Chapter10Application implements WebMvcConfigurer {
    private LocaleChangeInterceptor lci;

    @Bean(name = "localeResolver")
    public LocaleResolver initLocaleResolver() {
        SessionLocaleResolver slr = new SessionLocaleResolver();
        slr.setDefaultLocale(Locale.SIMPLIFIED_CHINESE);
        return slr;
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        if (lci != null) {
            return lci;
        }
        lci = new LocaleChangeInterceptor();
        lci.setParamName("language");
        return lci;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());

        InterceptorRegistration ir = registry.addInterceptor(new Interceptor1());
        InterceptorRegistration ir1 = registry.addInterceptor(new MultiInterceptor1());
        InterceptorRegistration ir2 = registry.addInterceptor(new MultiInterceptor2());
        InterceptorRegistration ir3 = registry.addInterceptor(new MultiInterceptor3());
        ir.addPathPatterns("/interceptor/*");
        ir1.addPathPatterns("/interceptor/*");
        ir2.addPathPatterns("/interceptor/*");
        ir3.addPathPatterns("/interceptor/*");
    }

    public static void main(String[] args) {
        SpringApplication.run(Chapter10Application.class, args);
    }

}
