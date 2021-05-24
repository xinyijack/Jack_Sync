package com.xinyijack.jack_sync.controller;

import com.xinyijack.jack_sync.common.utils.DatabaseUtil;
import com.xinyijack.jack_sync.common.utils.DateUtil;
import com.xinyijack.jack_sync.common.utils.UUIdGenId;
import com.xinyijack.jack_sync.mybatisdemo.mapper.DatabaseInfo;
import com.xinyijack.jack_sync.mybatisdemo.mapper.DatabaseMapper;
import com.xinyijack.jack_sync.mybatisdemo.mapper.RecoverInfo;
import com.xinyijack.jack_sync.mybatisdemo.mapper.RecoverMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class RecoverController {


    @Autowired
    DatabaseMapper databaseMapper;

    @Autowired
    RecoverMapper recoverMapper;

    @Autowired
    RecoverInfo recoverInfo;

    @Autowired
    DateUtil dateUtil;

    @Autowired
    UUIdGenId uuIdGenId;

    @PostMapping("/recover/{dbId}")
    public void DatabaseBackup (RecoverInfo recoverInfo, @PathVariable("dbId") String id) throws IOException, InterruptedException {
        DatabaseInfo recoverDatabaseInfo = databaseMapper.getDBInfo(id);
        DatabaseUtil.recover(recoverDatabaseInfo.getDbHost(), recoverDatabaseInfo.getDbUsername(), recoverDatabaseInfo.getDbPassword(), recoverDatabaseInfo.getDbDatabase(), recoverDatabaseInfo.getDbOutputfile(), recoverDatabaseInfo.getDbFilename());
        String recovertime = dateUtil.getDataNowStr();
        String rcId = uuIdGenId.getUUID32();
        recoverInfo.setRcId(rcId);
        recoverInfo.setTdbRecoverdate(recovertime);
        recoverMapper.insertRecoverInfo(recoverInfo);
        System.out.println("finished!");
    }
}
