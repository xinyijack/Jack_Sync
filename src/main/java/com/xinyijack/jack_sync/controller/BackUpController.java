package com.xinyijack.jack_sync.controller;


import com.xinyijack.jack_sync.bean.SyncDataBase;
import com.xinyijack.jack_sync.common.utils.DatabaseUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class BackUpController {

    @GetMapping("/backup")
    public void DatabaseBackup () throws IOException, InterruptedException {
        SyncDataBase syncDataBase = new SyncDataBase();
        String database = syncDataBase.getDatabase();
        boolean finstatus = DatabaseUtil.backup(syncDataBase.getHost(), syncDataBase.getPort(), syncDataBase.getUsername(),syncDataBase.getPassword(),syncDataBase.getDatabase(), syncDataBase.getOutputfile());
        if (finstatus){
            System.out.println("%s"+"数据库备份成功！",database);
        }
    }

}
