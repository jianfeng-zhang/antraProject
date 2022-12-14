package com.example.university.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
    //让server发request到另一个地方
    @Bean
    public RestTemplate getRestTemplate(){
        return  new RestTemplate();
    }

}
