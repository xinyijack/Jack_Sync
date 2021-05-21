package com.xinyijack.jack_sync.controller;

import com.xinyijack.jack_sync.common.utils.DatabaseUtil;
import com.xinyijack.jack_sync.mybatisdemo.mapper.DatabaseInfo;
import com.xinyijack.jack_sync.mybatisdemo.mapper.DatabaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class RecoverController {
    @Autowired
    DatabaseMapper databaseMapper;

    @GetMapping("/recover/{dbId}")
    public void DatabaseBackup (@PathVariable("dbId") String id) throws IOException, InterruptedException {
        DatabaseInfo recoverDatabaseInfo = databaseMapper.getDBInfo(id);
        DatabaseUtil.recover(recoverDatabaseInfo.getDbHost(), recoverDatabaseInfo.getDbUsername(),recoverDatabaseInfo.getDbPassword(),recoverDatabaseInfo.getDbDatabase(), recoverDatabaseInfo.getDbOutputfile(), recoverDatabaseInfo.getDbFilename());
        System.out.println("finished!");
    }
}
