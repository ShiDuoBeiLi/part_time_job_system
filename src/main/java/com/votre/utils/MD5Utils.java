package com.votre.utils;

import org.springframework.util.DigestUtils;

public class MD5Utils {
    //盐
    public static final String salt ="surery###$$$@@@";

    public static String getMD5(String string){
        String val = string+salt;
        return DigestUtils.md5DigestAsHex(val.getBytes());
    }

}


