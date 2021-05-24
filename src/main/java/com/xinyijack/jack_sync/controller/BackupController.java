package com.xinyijack.jack_sync.controller;


import com.xinyijack.jack_sync.common.utils.DatabaseUtil;
import com.xinyijack.jack_sync.common.utils.DateUtil;
import com.xinyijack.jack_sync.common.utils.UUIdGenId;
import com.xinyijack.jack_sync.mybatisdemo.mapper.BackupInfo;
import com.xinyijack.jack_sync.mybatisdemo.mapper.BackupMapper;
import com.xinyijack.jack_sync.mybatisdemo.mapper.DatabaseInfo;
import com.xinyijack.jack_sync.mybatisdemo.mapper.DatabaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class BackupController {
    @Autowired
    private DatabaseMapper databaseMapper;

    @Autowired
    private BackupMapper backupMapper;

    @Autowired
    BackupInfo backupInfo;

    @Autowired
    private DateUtil dateUtil;

    @Autowired
    private UUIdGenId uuIdGenId;

    @PostMapping(value = "/backup/{dbId}")
    public void DatabaseBackup (BackupInfo backupInfo, @PathVariable("dbId") String id) throws IOException, InterruptedException {
        DatabaseInfo backupDatabaseInfo = databaseMapper.getDBInfo(id);
        DatabaseUtil.backup(backupDatabaseInfo.getDbHost(), backupDatabaseInfo.getDbUsername(), backupDatabaseInfo.getDbPassword(), backupDatabaseInfo.getDbDatabase(), backupDatabaseInfo.getDbOutputfile(), backupDatabaseInfo.getDbFilename());
        String backuptime = dateUtil.getDataNowStr();
        String bpId = uuIdGenId.getUUID32();
        backupInfo.setBpId(bpId);
        backupInfo.setTdbBackupdate(backuptime);
        backupMapper.insertBackupInfo(backupInfo);
        System.out.println("finished!");
    }
}
