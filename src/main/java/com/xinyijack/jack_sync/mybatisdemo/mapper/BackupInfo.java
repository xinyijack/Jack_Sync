package com.xinyijack.jack_sync.mybatisdemo.mapper;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class BackupInfo {
    private String bpId;
    private String tdbName;
    private String tdbTablename;
    private String tdbBackupdate;
    private String tdbBackuptype;
    private String tdbBackupstatus;
}
