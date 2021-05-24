package com.sfzjh.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;


/**
 * @Author 孙飞
 * @Date 2021年05月21日  21:09
 * @PackageName com.sfzjh.config
 * @Name MyWebSecurityConfig
 * @Version 1.0
 * @Description TODO
 * Created with IntelliJ IDEA.
 */
@Configuration
public class MyWebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("root").password("123456").roles("ADMIN", "DBA")
                .and()
                .withUser("admin").password("123456").roles("ADMIN", "USER")
                .and()
                .withUser("administrator").password("456789").roles("USER");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/demo/admin/**").hasRole("ADMIN")
                .antMatchers("/demo/user/**").access("hasAnyRole('ADMIN', 'USER')")
                .antMatchers("/demo/db/**").access("hasAnyRole('ADMIN') and hasAnyRole('DBA')")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login_page")
                .loginProcessingUrl("/login")
                .usernameParameter("name")
                .passwordParameter("password")
                .successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                        Object principal = authentication.getPrincipal();
                        PrintWriter writer = response.getWriter();
                        response.setStatus(200);
                        Map<String, Object> map = new HashMap<>();
                        map.put("status", 200);
                        map.put("msg", principal);
                        ObjectMapper mapper = new ObjectMapper();
                        writer.write(mapper.writeValueAsString(map));
                        writer.flush();
                        writer.close();
                    }
                })
                .failureHandler(new AuthenticationFailureHandler() {
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
                        response.setContentType("application/json;charset=utf-8");
                        PrintWriter writer = response.getWriter();
                        Map<String, Object> mapException = new HashMap<>();
                        mapException.put("status", 401);
                        if (e instanceof LockedException) {
                            mapException.put("msg", "账户被锁定，登录失败！");
                        } else if (e instanceof BadCredentialsException) {
                            mapException.put("msg", "账户名或密码输入错误，登录失败！");
                        }else if (e instanceof DisabledException) {
                            mapException.put("msg", "账户被禁用，登录失败！");
                        }else if (e instanceof AccountExpiredException) {
                            mapException.put("msg", "账户已过期，登录失败！");
                        }else if (e instanceof CredentialsExpiredException) {
                            mapException.put("msg", "密码已过期，登录失败！");
                        }else {
                            mapException.put("msg", "登录失败！");
                        }
                    }
                })
                .permitAll()
                .and()
                .csrf().disable();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/v2/api-docs", "/configuration/ui", "/swagger-resources", "/configuration/security", "/swagger-ui.html", "/webjars/**");
    }
}
