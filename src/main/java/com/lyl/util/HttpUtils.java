package com.lyl.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.common.base.Charsets;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.TimeZone;

/**
 * <p> Licence     : (C) Copyright 2019-2021, ZettaCloud Xi'an
 * <p> Description :
 *
 * @author : liuyuanlong
 * @date : 2021/8/30 14:36
 */
public class HttpUtils {

    public static RestTemplate newRestTemplate() {
        RestTemplate REST_TEMPLATE = new RestTemplate();

        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();

        ObjectMapper objectMapper = mappingJackson2HttpMessageConverter.getObjectMapper();
        objectMapper.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

        mappingJackson2HttpMessageConverter.setDefaultCharset(Charsets.UTF_8);

        REST_TEMPLATE.getMessageConverters().add(0, mappingJackson2HttpMessageConverter);

        ((SimpleClientHttpRequestFactory) REST_TEMPLATE.getRequestFactory()).setReadTimeout(10 * 1000);
        ((SimpleClientHttpRequestFactory) REST_TEMPLATE.getRequestFactory()).setConnectTimeout(10 * 1000);

        return REST_TEMPLATE;
    }

    private static final RestTemplate REST_TEMPLATE = newRestTemplate();

    public static void geoWorkspaces(String url){

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Accept", "text/html");
        httpHeaders.add("Content-Type", "application/json");


        String user = "admin";
        String password = "geoserver";
        String userMsg = user + ":" + password;
        String base64UserMsg = Base64.getEncoder().encodeToString(userMsg.getBytes());

        httpHeaders.add(HttpHeaders.AUTHORIZATION, "Basic "+base64UserMsg);

        HttpEntity<String> entity = new HttpEntity<>( httpHeaders);

        ResponseEntity obj = REST_TEMPLATE.exchange(url, HttpMethod.GET, new HttpEntity<String>(httpHeaders),String.class);
        System.out.println(obj.getBody());
    }

    public static void main(String[] args) {

        StringBuilder url = new StringBuilder("http://localhost:18082/geoserver/rest/");
       // url.append("workspaces/geoVerify/layers/10G_ovr_tile");
       // url.append("layers");
        url.append("layers/test:cut_top?f=json");


        geoWorkspaces(url.toString());
    }
}