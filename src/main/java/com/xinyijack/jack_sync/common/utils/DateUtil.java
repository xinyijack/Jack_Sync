package com.xinyijack.jack_sync.common.utils;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class DateUtil {
    public String getDataNowStr() {
        Date time = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dataNowStr = df.format(time);
        return dataNowStr;
    }

}
