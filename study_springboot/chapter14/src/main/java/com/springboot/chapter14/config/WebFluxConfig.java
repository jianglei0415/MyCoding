//package com.springboot.chapter14.config;
//
//import com.springboot.chapter14.enumeration.SexEnum;
//import com.springboot.chapter14.pojo.User;
//import com.springboot.chapter14.validator.UserValidator;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.convert.converter.Converter;
//import org.springframework.format.FormatterRegistry;
//import org.springframework.http.CacheControl;
//import org.springframework.validation.Validator;
//import org.springframework.web.reactive.config.ResourceHandlerRegistry;
//import org.springframework.web.reactive.config.WebFluxConfigurer;
//import sun.misc.Cache;
//
//import java.util.concurrent.TimeUnit;
//
///**
// * @author: jianglei
// * @date: 2020/2/2 17:21
// */
//@Configuration
//public class WebFluxConfig implements WebFluxConfigurer {
//    @Override
//    public void addFormatters(FormatterRegistry registry) {
//        registry.addConverter(stringToUserConverter());
//    }
//
//    private Converter<String, User> stringToUserConverter() {
//        Converter<String, User> converter = s -> {
//            String[] strArr = s.split("-");
//            User user = new User();
//            Long id = Long.valueOf(strArr[0]);
//            user.setId(id);
//            user.setUserName(strArr[1]);
//            Integer sexCode = Integer.valueOf(strArr[2]);
//            SexEnum sex = SexEnum.getSexEnum(sexCode);
//            user.setSex(sex);
//            user.setNote(strArr[3]);
//            return user;
//        };
//        return converter;
//    }
////
////    @Override
////    public Validator getValidator() {
////        return new UserValidator();
////    }
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry
//                //注册资源，可以通过URI访问
//                .addResourceHandler("/resources/static/**")
//                //注册spring资源，可以在spring机制中访问
//                .addResourceLocations("/public", "classpath:/static/")
//                //缓存
//                .setCacheControl(CacheControl.maxAge(365, TimeUnit.DAYS));
//    }
//}
