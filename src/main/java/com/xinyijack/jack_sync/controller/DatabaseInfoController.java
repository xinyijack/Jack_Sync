package com.xinyijack.jack_sync.controller;

import com.xinyijack.jack_sync.common.utils.UUIdGenId;
import com.xinyijack.jack_sync.mybatisdemo.mapper.DatabaseInfo;
import com.xinyijack.jack_sync.mybatisdemo.mapper.DatabaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping("/dbinfo")
public class DatabaseInfoController {

    @Autowired
    private DatabaseMapper databaseMapper;

    //@Autowired
    //private BackupInfo backupInfo;

    @Autowired
    private UUIdGenId uuIdGenId;

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public int Insert(DatabaseInfo databaseInfo) {
        int num = 0;
        String id;
        id = uuIdGenId.getUUID32();
        //ide = UUID.randomUUID().toString().replace("-","").toLowerCase(Locale.ROOT);
        databaseInfo.setDbId(id);
        try {
            num = databaseMapper.insertDB(databaseInfo);
            System.out.println("新增数据完成 id=" + id + ",num= " + num );
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return num;
    }

    @RequestMapping(value = "/{Id}", method = RequestMethod.PUT)
    public int DbUpdate(DatabaseInfo editDatabaseInfo) {
        int num = 0;
        if (null != editDatabaseInfo) {
            System.out.println(editDatabaseInfo.toString());
            try {
                num = databaseMapper.updateDB(editDatabaseInfo);
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        return num;
    }

    @RequestMapping(value = "/{dbId}", method = RequestMethod.GET)
    public DatabaseInfo DbQueryById(@PathVariable("dbId") String id) {
        DatabaseInfo databaseInfoById = databaseMapper.getDBInfo(id);
        try {
            System.out.println(databaseInfoById.toString());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return databaseInfoById;
    }

    @RequestMapping(value = "getlist", method = RequestMethod.GET)
    public List<DatabaseInfo> DbQuery() {
        List<DatabaseInfo> getListDatabaseInfo = databaseMapper.getAllDBInfo();
        System.out.println(getListDatabaseInfo.toString());
        return getListDatabaseInfo;
    }

    @RequestMapping(value = "/{Id}", method = RequestMethod.DELETE)
    public int DbDelete(@PathVariable("Id") String id) {
        int num = 0;
        if (id != null) {
            num = databaseMapper.deleteDB(id);
        }
        return num;
    }
}
