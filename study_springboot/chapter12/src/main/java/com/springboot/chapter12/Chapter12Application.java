package com.springboot.chapter12;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

import javax.sql.DataSource;

@SpringBootApplication(scanBasePackages = "com.springboot.chapter12")
public class Chapter12Application extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;

    @Value("${system.user.password.secret}")
    private String secret;

    String pwdQuery = "select user_name,pwd,available " +
            "from t_user_2 " +
            "where user_name=?";

    String roleQuery = "select u.user_name,r.role_name " +
            "from t_user_2 u,t_user_role ur,t_role r " +
            "where u.id=ur.user_id " +
            "and r.id=ur.role_id " +
            "and u.user_name=?";

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        PasswordEncoder passwordEncoder = new Pbkdf2PasswordEncoder(this.secret);

        //内存签名服务
        //方法一
//        auth.inMemoryAuthentication()
//                .passwordEncoder(passwordEncoder)
//                .withUser("admin")
//                .password("$2a$10$qcWjDEc9/SyhTKdxG6N68e2Er0QDTxRLie7Aobm.HLEHPi3w.u6Jm")
//                .roles("USER", "ADMIN")
//                .and()
//                .withUser("root")
//                .password("$2a$10$pdzsuJNXXJK8YFdHFA2hVunfEwuX4seiJ9woue8X4dCMY/Wz/0w.6")
//                .roles("USER");

        //方法二
//        InMemoryUserDetailsManagerConfigurer<AuthenticationManagerBuilder> userConfig = auth.inMemoryAuthentication().passwordEncoder(passwordEncoder);
//        userConfig.withUser("admin").password("$2a$10$qcWjDEc9/SyhTKdxG6N68e2Er0QDTxRLie7Aobm.HLEHPi3w.u6Jm")
//                .authorities("ROLE_USER", "ROLE_ADMIN");
//        userConfig.withUser("root").password("$2a$10$pdzsuJNXXJK8YFdHFA2hVunfEwuX4seiJ9woue8X4dCMY/Wz/0w.6")
//                .authorities("ROLE_USER");

        //数据库签名服务
        auth.jdbcAuthentication().
                passwordEncoder(passwordEncoder).
                dataSource(dataSource).
                usersByUsernameQuery(pwdQuery).
                authoritiesByUsernameQuery(roleQuery);

        //自定义签名服务
//        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                //限定此路径请求赋予角色ROLE_USER、ROLE_ADMIN
//                .antMatchers("/user/**").access("hasRole('USER') or hasRole('ADMIN')")
//                //限定此路径下所有请求权限赋予角色ROLE_ADMIN
//                .antMatchers("/admin/**").hasAnyRole("ROLE_ADMIN")
//                //其他路径允许签名后访问
//                .anyRequest().permitAll()
//                //对于没有配置权限的其他请求允许匿名访问
//                .and().anonymous()
//                //使用Spring Security默认登录页面
//                .and().formLogin()
//                //启动HTTP基础验证
//                .and().httpBasic();

        http.authorizeRequests().antMatchers("/admin/**").access("hasRole('ADMIN')")
                .and().rememberMe().tokenValiditySeconds(30).key("remember-me-key")
                .and().httpBasic()
                .and().authorizeRequests().antMatchers("/**").permitAll()
                .and().formLogin()
                .loginPage("/login/page")
                .defaultSuccessUrl("/admin/welcome1")
                .and().logout().logoutUrl("/logout/page")
                .logoutSuccessUrl("/welcome")
                .and().httpBasic().realmName("my-basic-name");
    }

    public static void main(String[] args) {
        SpringApplication.run(Chapter12Application.class, args);
    }

}
