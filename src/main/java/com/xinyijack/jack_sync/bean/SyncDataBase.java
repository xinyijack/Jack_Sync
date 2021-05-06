package com.xinyijack.jack_sync.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "mydatabase")
public class SyncDataBase {
    private String port;
    private String username;
    private String host;
    private String password;
    private String database;
    private String outputfile;
}
