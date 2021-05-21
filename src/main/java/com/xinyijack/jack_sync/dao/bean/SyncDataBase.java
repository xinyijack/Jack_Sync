package com.xinyijack.jack_sync.dao.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@Component
@PropertySource("classpath:/config/jdbc.properties")
@ConfigurationProperties(prefix = "mydatabase")
public class SyncDataBase {
    private String host;
    private String port;
    private String username;
    private String password;
    //数据库名称
    private String database;
    private String outputfile;
    private String filename;
    private String filetype;
    private String databasetype;
    private Date backuptime;
    private String backuptype;
    private String backstatus;
    private String backupfrequency;
}
