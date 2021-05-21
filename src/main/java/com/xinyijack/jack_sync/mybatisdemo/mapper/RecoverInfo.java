package com.xinyijack.jack_sync.mybatisdemo.mapper;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@Component
public class RecoverInfo {
    private String rcId;
    private String tdbName;
    private String tdbTablename;
    private String tdbBackupdate;
    private String tdbBackuptype;
    private String tdbRecoverstatus;
}
