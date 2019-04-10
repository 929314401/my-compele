package com.company.edge;

import com.company.edge.filter.CompanyFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ServiceApplication {
    public static void main(String args[]){
        SpringApplication.run(ServiceApplication.class,args);
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        CompanyFilter courseFilter = new CompanyFilter();
        filterRegistrationBean.setFilter(courseFilter);
        List<String> urlPatterns=new ArrayList<>();
        urlPatterns.add("/company/*");
        filterRegistrationBean.setUrlPatterns(urlPatterns);
        return filterRegistrationBean;
    }
}
