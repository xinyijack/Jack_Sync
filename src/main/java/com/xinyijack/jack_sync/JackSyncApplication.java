package com.xinyijack.jack_sync;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
@MapperScan("com.xinyijack.jack_sync.mybatisdemo.mapper")
public class JackSyncApplication {

    public static void main(String[] args) {
        SpringApplication.run(JackSyncApplication.class, args);
    }

}
