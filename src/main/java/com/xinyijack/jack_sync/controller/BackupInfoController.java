package com.xinyijack.jack_sync.controller;

import com.xinyijack.jack_sync.common.utils.UUIdGenId;
import com.xinyijack.jack_sync.mybatisdemo.mapper.BackupInfo;
import com.xinyijack.jack_sync.mybatisdemo.mapper.BackupMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/bpinfo")
public class BackupInfoController {
    @Autowired
    private BackupMapper backupMapper;

    @Autowired
    private UUIdGenId uuIdGenId;

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public int Insert(BackupInfo backupInfo) {
        int num = 0;
        String id;
        id = uuIdGenId.getUUID32();
        //ide = UUID.randomUUID().toString().replace("-","").toLowerCase(Locale.ROOT);
        backupInfo.setBpId(id);
        try {
            num = backupMapper.insertBackupInfo(backupInfo);
            System.out.println("新增数据完成 id=" + id + ",num= " + num );
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return num;
    }

    @RequestMapping(value = "/{bpId}", method = RequestMethod.PUT)
    public int DbUpdate(BackupInfo backupInfo) {
        int num = 0;
        if (null != backupInfo) {
            System.out.println(backupInfo.toString());
            try {
                num = backupMapper.updateBackupInfo(backupInfo);
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        return num;
    }

    @RequestMapping(value = "/{bpId}", method = RequestMethod.GET)
    public BackupInfo DbQueryById(@PathVariable("bpId") String id) {
        BackupInfo backupInfoById = backupMapper.getBackupInfo(id);
        try {
            System.out.println(backupInfoById.toString());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return backupInfoById;
    }

    @RequestMapping(value = "getlist", method = RequestMethod.GET)
    public List<BackupInfo> BpQuery() {
        List<BackupInfo> getListBackupInfo = backupMapper.getAllBackupInfo();
        System.out.println(getListBackupInfo.toString());
        return getListBackupInfo;
    }

    @RequestMapping(value = "/{bpId}", method = RequestMethod.DELETE)
    public int DbDelete(@PathVariable("bpId") String id) {
        int num = 0;
        if (id != null) {
            num = backupMapper.deleteBackupInfo(id);
        }
        return num;
    }
}
