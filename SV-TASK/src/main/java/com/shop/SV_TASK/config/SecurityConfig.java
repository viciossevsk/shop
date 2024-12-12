package com.shop.SV_TASK.config;

import com.vaadin.flow.spring.security.VaadinWebSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableWebSecurity
public class SecurityConfig extends VaadinWebSecurity {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        setLoginView(http, "/product-service/login", "/product-service");
    }
}
