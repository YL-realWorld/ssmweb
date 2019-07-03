package com.luma.Common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

/**
 * 自动生成UUID
 */
public class GenerateUuid {

    private static final Logger LOGGER = LoggerFactory.getLogger(GenerateUuid.class);

    /**
     * 16位
     * @return
     */
    public static String uuid16() {
        String preUuid = UUID.randomUUID().toString();
        String uuid16 = preUuid.substring(0, 8) + preUuid.substring(9, 13) + preUuid.substring(14, 18);//+preUuid.substring(19,23)+preUuid.substring(24);
        return uuid16;
    }

    public static String uuid24() {
        String preUuid = UUID.randomUUID().toString();
        String uuid24 = preUuid.substring(0, 8) + preUuid.substring(9, 13) + preUuid.substring(14, 18) + preUuid.substring(19, 23);//+preUuid.substring(24);
        return uuid24;
    }

    public static String uuid32() {
        String preUuid = UUID.randomUUID().toString();
        String uuid32 = preUuid.substring(0, 8) + preUuid.substring(9, 13) + preUuid.substring(14, 18) + preUuid.substring(19, 23) + preUuid.substring(24);
        return uuid32;
    }

}
