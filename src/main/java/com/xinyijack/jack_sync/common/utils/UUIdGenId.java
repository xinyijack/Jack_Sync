package com.xinyijack.jack_sync.common.utils;

import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.UUID;

@Component
public class UUIdGenId  {
    public String getUUID32() {
        String uuid;
        uuid = UUID.randomUUID().toString().replace("-","").toLowerCase(Locale.ROOT);
        return uuid;
    }
}
