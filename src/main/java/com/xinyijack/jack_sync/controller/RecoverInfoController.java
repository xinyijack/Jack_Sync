package com.xinyijack.jack_sync.controller;

import com.xinyijack.jack_sync.common.utils.UUIdGenId;
import com.xinyijack.jack_sync.mybatisdemo.mapper.RecoverInfo;
import com.xinyijack.jack_sync.mybatisdemo.mapper.RecoverMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/rcinfo")
public class RecoverInfoController {
    @Autowired
    private RecoverInfo recoverInfo;

    @Autowired
    private RecoverMapper recoverMapper;

    @Autowired
    private UUIdGenId uuIdGenId;

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public int Insert(RecoverInfo recoverInfo) {
        int num = 0;
        String id;
        id = uuIdGenId.getUUID32();
        //ide = UUID.randomUUID().toString().replace("-","").toLowerCase(Locale.ROOT);
        recoverInfo.setRcId(id);
        try {
            num = recoverMapper.insertRecoverInfo(recoverInfo);
            System.out.println("新增数据完成 id=" + id + ",num= " + num );
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return num;
    }

    @RequestMapping(value = "/{bpId}", method = RequestMethod.PUT)
    public int DbUpdate(RecoverInfo recoverInfo) {
        int num = 0;
        if (null != recoverInfo) {
            System.out.println(recoverInfo.toString());
            try {
                num = recoverMapper.updateRecoverInfo(recoverInfo);
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        return num;
    }

    @RequestMapping(value = "/{rcId}", method = RequestMethod.GET)
    public RecoverInfo DbQueryById(@PathVariable("rcId") String id) {
        RecoverInfo recoverInfoById = recoverMapper.getRecoverInfo(id);
        try {
            System.out.println(recoverInfoById.toString());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return recoverInfoById;
    }

    @RequestMapping(value = "getlist", method = RequestMethod.GET)
    public List<RecoverInfo> RcQuery() {
        List<RecoverInfo> getListRecoverInfo = recoverMapper.getAllRecoverInfo();
        System.out.println(getListRecoverInfo.toString());
        return getListRecoverInfo;
    }

    @RequestMapping(value = "/{rcId}", method = RequestMethod.DELETE)
    public int DbDelete(@PathVariable("rcId") String id) {
        int num = 0;
        if (id != null) {
            num = recoverMapper.deleteRecoverInfo(id);
        }
        return num;
    }
}
