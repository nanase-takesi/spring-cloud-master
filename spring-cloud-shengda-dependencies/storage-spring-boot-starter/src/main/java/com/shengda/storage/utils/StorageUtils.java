package com.shengda.storage.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author takesi
 * @date 2020-03-19
 */
public class StorageUtils {

    public static String getFilePath(String filename) {
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        int begin = filename.indexOf(".");
        int last = filename.length();
        String ext = filename.substring(begin, last);
        return sdf.format(new Date()) + "/" + String.format("%s%s", UUID.randomUUID().toString(), ext);
    }

}
