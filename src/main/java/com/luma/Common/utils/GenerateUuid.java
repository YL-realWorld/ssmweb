package com.luma.Common.utils;

import java.util.UUID;

public class GenerateUuid {

    public static String uuid16(){
        String preUuid = UUID.randomUUID().toString();
        String uuid16 = preUuid.substring(0,8)+preUuid.substring(9,13)+preUuid.substring(14,18);//+preUuid.substring(19,23)+preUuid.substring(24);
        return uuid16;
    }

    public static String uuid24(){
        String preUuid = UUID.randomUUID().toString();
        String uuid24 = preUuid.substring(0,8)+preUuid.substring(9,13)+preUuid.substring(14,18)+preUuid.substring(19,23);//+preUuid.substring(24);
        return uuid24;
    }

    public static String uuid32(){
        String preUuid = UUID.randomUUID().toString();
        String uuid32 = preUuid.substring(0,8)+preUuid.substring(9,13)+preUuid.substring(14,18)+preUuid.substring(19,23)+preUuid.substring(24);
        return uuid32;
    }
}
