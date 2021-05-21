package com.xinyijack.jack_sync.mybatisdemo.mapper;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class DatabaseInfo {
    private String dbId;
    private String dbHost;
    private String dbPort;
    private String dbUsername;
    private String dbPassword;
    private String dbDatabase;
    private String dbOutputfile;
    private String dbFilename;
}
