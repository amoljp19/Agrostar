
package com.softaai.agrostarassigment.utils;

import com.softaai.agrostarassigment.enums.UploadImagePrefix;

import java.util.Date;


public class ImageUtil {

    public static String generateImageTitle(UploadImagePrefix prefix, String parentId) {
        if (parentId != null) {
            return prefix.toString() + parentId;
        }

        return prefix.toString() + new Date().getTime();
    }
}
