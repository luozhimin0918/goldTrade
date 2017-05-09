package com.library.util;

import android.content.Context;
import android.os.Environment;

import java.io.File;
import java.io.IOException;

/**
 * @author Mr'Dai
 * @date 2016/5/16 16:00
 * @Title: MobileLibrary
 * @Package com.library.util
 * @Description:
 */
public class FileUtils {
    /**
     * 将图片保存到Android文件夹下的Cache目录下面
     */
    public static File getDiskCacheDir(Context context, String uniqueName) {
        String cachePath = getSaveFilePath(context);
        File file = new File(cachePath + File.separator + uniqueName);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    /**
     * 得到文件存储路径
     */
    public static String getSaveFilePath(Context context) {
        String cachePath;
        cachePath = context.getApplicationContext().getFilesDir().getPath();
        return cachePath;
    }

    public static String getSDSaveFilePath(Context context) {
        String sdCachePath = "";
        if ((Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState()) ||
                !Environment.isExternalStorageRemovable())) {
            sdCachePath = context.getExternalCacheDir().getPath();
            File file = new File(sdCachePath);
            if (!file.exists()) {
                try {
                    file.mkdirs();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return sdCachePath;
    }
}
