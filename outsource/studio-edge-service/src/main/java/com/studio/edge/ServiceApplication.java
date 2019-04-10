package com.studio.edge;

import com.studio.edge.filter.StudioFilter;
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
        StudioFilter studioFilter = new StudioFilter();
        filterRegistrationBean.setFilter(studioFilter);
        List<String> urlPatterns=new ArrayList<>();
        urlPatterns.add("/studio/*");
        filterRegistrationBean.setUrlPatterns(urlPatterns);
        return filterRegistrationBean;
    }
}
