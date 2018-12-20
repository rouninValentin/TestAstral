package ru.astral.config;

import ru.astral.authentication.MyDBAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
// @EnableWebSecurity = @EnableWebMVCSecurity + Extra features
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    MyDBAuthenticationService myDBAauthenticationService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        // For User in database.
        auth.userDetailsService(myDBAauthenticationService);

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();

        // Страницы доступны без авторизации
        http.authorizeRequests().antMatchers("/", "register","/welcome", "/login", "/logout").permitAll();

        // Страница доступна  узеру и админу.
        http.authorizeRequests().antMatchers("/note").access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')");

        // Только админ.
        http.authorizeRequests().antMatchers("/admin").access("hasRole('ROLE_ADMIN')");

        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");

        // Настройка логин.
        http.authorizeRequests().and().formLogin()//
                // Submit URL of login page.
                .loginProcessingUrl("/j_spring_security_check") // Submit URL
                .loginPage("/login")//
                .defaultSuccessUrl("/note")//
                .failureUrl("/login?error=true")//
                .usernameParameter("username")//
                .passwordParameter("password")
                // после выхода
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/logoutSuccessful");

    }
}