package com.library.util.disklrucache;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.v4.app.ActivityCompat;

import com.jakewharton.disklrucache.DiskLruCache;
import com.library.util.ConvertUtils;
import com.library.util.FileUtils;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;

import static android.R.attr.versionCode;

/**
 * @author Mr'Dai
 * @date 2016/5/19 16:09
 * @Title: MobileLibrary
 * @Package com.library.util
 * @Description:
 */
public class DiskLruCacheUtils {
    private static final String DEFAULT_CACHE_DIR = "lruCache";
    private static DiskLruCacheUtils mDiskLruCacheUtils;

    public static DiskLruCacheUtils getInstance(Context mContext) {
        if (mDiskLruCacheUtils == null) {
            mDiskLruCacheUtils = new DiskLruCacheUtils(mContext);
        }
        return mDiskLruCacheUtils;
    }

    private File mDiskCacheFile;
    private DiskLruCache mDiskLruCache;

    public DiskLruCacheUtils(Context mContext) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            int hasWritePermission = mContext.checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE);
            if (hasWritePermission != PackageManager.PERMISSION_GRANTED) {
                if (mContext instanceof Activity) {
                    ActivityCompat.requestPermissions((Activity) mContext,
                            new String[]
                                    {Manifest.permission.WRITE_EXTERNAL_STORAGE,
                                            Manifest.permission.READ_EXTERNAL_STORAGE},
                            101);
                }
            } else {
                initDiskLruCache(mContext);
            }
        } else {
            initDiskLruCache(mContext);
        }
    }

    private void initDiskLruCache(Context mContext) {
        try {
            mDiskCacheFile = FileUtils.getDiskCacheDir(mContext, DEFAULT_CACHE_DIR);
            mDiskLruCache = DiskLruCache.open(mDiskCacheFile, versionCode, 1, 5 * 1024 * 1024);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void putDiskLruCache(String key, Bitmap bitmap) {
        String md5Key = ConvertUtils.md5(key);
        DiskLruCache.Editor mEdit = null;
        try {
            mEdit = mDiskLruCache.edit(md5Key);
            OutputStream outputStream = mEdit.newOutputStream(0);

            bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);

            outputStream.close();
            outputStream.flush();
            mEdit.commit();

            mDiskLruCache.flush();
        } catch (Exception e) {
            e.printStackTrace();

            try {
                mEdit.abort();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    public Bitmap getDiskLruCache(String key) {
        String md5Key = ConvertUtils.md5(key);
        try {
            DiskLruCache.Snapshot snapshot = mDiskLruCache.get(md5Key);
            if (snapshot != null) {
                InputStream inputStream = snapshot.getInputStream(0);
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                return bitmap;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
