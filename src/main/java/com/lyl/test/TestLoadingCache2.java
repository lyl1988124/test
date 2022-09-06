package com.lyl.test;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * <p> Licence     : (C) Copyright 2019-2021, ZettaCloud Xi'an
 * <p> Description :
 *
 * @author : liuyuanlong
 * @date : 2021/11/9 10:59
 */
public class TestLoadingCache2 {
    private static final long CACHE_EXPIRE_SECONDS = 3;

    public static LoadingCache<String, Optional<String>> GEOSERVER_USER_CACHE;

    static {
        GEOSERVER_USER_CACHE = CacheBuilder.newBuilder()
            .maximumSize(10)
            .expireAfterWrite(CACHE_EXPIRE_SECONDS, TimeUnit.SECONDS)
            .expireAfterAccess(CACHE_EXPIRE_SECONDS, TimeUnit.SECONDS)
            .removalListener(removalNotification -> {
                System.out.println("##########remove =" + removalNotification.getKey() + " value=" + removalNotification.getValue());
            })
            .build(new CacheLoader<String, Optional<String>>() {
                @Override
                public Optional<String> load(String userId) {
                    return Optional.empty();
                }
            });
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        TestLoadingCache2 testCache = new TestLoadingCache2();
        GEOSERVER_USER_CACHE.put("11", Optional.of("11"));
        System.out.println(GEOSERVER_USER_CACHE.asMap());

        int cnt = 0;
        while (true) {
            System.out.println("22===" + GEOSERVER_USER_CACHE.get("22"));
            Thread.sleep(1000L);
            System.out.println("11===" + GEOSERVER_USER_CACHE.get("11"));
            cnt++;
//            if (cnt >= 3) {
//                System.out.println("11===" + GEOSERVER_USER_CACHE.get("11"));
//                //GEOSERVER_USER_CACHE.invalidate("11");
//            }
        }

    }
}
