package com.lyl.test;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kafka.utils.Json;
import org.apache.commons.io.FileUtils;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class YamlUtils {

    public static void main(String[] args) {
        YamlUtils yamlUtils = new YamlUtils();
        System.out.println(yamlUtils.loadJsonFile());

        Yaml yaml = new Yaml();
        URL url = yamlUtils.loadURL();

        try {
            HashMap hashMap =  yaml.loadAs(new FileInputStream(url.getFile()), HashMap.class);

            ObjectMapper objectMapper = new ObjectMapper();
            try {
                String json = objectMapper.writeValueAsString(hashMap);
                System.out.println(json);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            ExecutorService executors = Executors.newFixedThreadPool(2);
            System.out.println(hashMap);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public URL loadURL(){
        return this.getClass().getResource("/translate.yaml");
    }

    public String loadJsonFile() {
        //获取文件的URL
        URL url = this.getClass().getResource("/translate.yaml");
        try {
            String content = FileUtils.readFileToString(new File(url.getPath()), StandardCharsets.UTF_8);
            return content;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
