package com.shengda.storage.utils;

import org.junit.jupiter.api.Test;

/**
 * @author takesi
 * @date 2020-04-06
 */
class StorageUtilsTest {

    @Test
    void getFilePath() {
        String ext = ".jpg";
        String filePath = StorageUtils.getFilePath(ext);
        System.out.println(filePath);
    }
}
