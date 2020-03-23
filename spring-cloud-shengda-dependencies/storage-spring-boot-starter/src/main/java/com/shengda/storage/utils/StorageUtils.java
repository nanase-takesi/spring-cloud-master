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
        final SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd");
        String[] arrays = filename.split(".");
        assert arrays.length > 0;
        String ext = arrays[arrays.length - 1];
        filename = String.format("%s.%s", UUID.randomUUID().toString(), ext);
        return sdf.format(new Date()) + "/" + filename;
    }

}
