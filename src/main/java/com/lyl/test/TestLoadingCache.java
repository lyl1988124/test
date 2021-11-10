package com.lyl.test;

import com.alibaba.fastjson.JSON;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * <p> Licence     : (C) Copyright 2019-2021, ZettaCloud Xi'an
 * <p> Description :
 *
 * @author : liuyuanlong
 * @date : 2021/11/9 10:59
 */
public class TestLoadingCache {
    private static final long CACHE_EXPIRE_SECONDS = 3;

    private LoadingCache<String, String> GEOSERVER_USER_CACHE;

    {
        GEOSERVER_USER_CACHE = CacheBuilder.newBuilder()
            .maximumSize(10)
            //.expireAfterWrite(CACHE_EXPIRE_SECONDS, TimeUnit.SECONDS)
            .expireAfterAccess(CACHE_EXPIRE_SECONDS, TimeUnit.SECONDS)
            .removalListener(removalNotification -> {
                System.out.println("##########remove =" + removalNotification.getKey() + " value=" + removalNotification.getValue());
            })
            .build(new CacheLoader<String, String>() {
                @Override
                public String load(String userId) {
                    return makeStr(userId);
                }
            });
    }

    private String makeStr(String userId) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String result = userId + "_" + sdf.format(new Date());

        return result;
    }

    private String getStrFromCache() {
        String result = null;
        try {
            System.out.println(JSON.toJSON(GEOSERVER_USER_CACHE.asMap()));
            result = GEOSERVER_USER_CACHE.get("aa");
        } catch (ExecutionException e) {
            e.printStackTrace();

        }
        return result;
    }

    public static void main(String[] args) throws InterruptedException {
        TestLoadingCache testCache = new TestLoadingCache();
        while (true) {
            System.out.println(testCache.getStrFromCache());
            Thread.sleep(1000L);
        }

    }
}
