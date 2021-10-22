package com.lyl.test.yaml;

import com.esotericsoftware.yamlbeans.YamlException;
import com.esotericsoftware.yamlbeans.YamlReader;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

public class YamlUtils {

    public static void main(String[] args) {
        YamlUtils yamlUtils = new YamlUtils();
        //System.out.println(yamlUtils.loadJsonFile());

        Yaml yaml = new Yaml();
        URL url = yamlUtils.loadURL();

        try {
            ExtentionConf hashMap =  yaml.loadAs(new FileInputStream(url.getFile()), ExtentionConf.class);

            ObjectMapper objectMapper = new ObjectMapper();
            try {
                String json = objectMapper.writeValueAsString(hashMap);
                System.out.println(json);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }

            new FileInputStream(url.getFile());

            YamlReader yamlReader = new YamlReader(new FileReader(url.getFile()));
            try {
                ExtentionConf extentionConf = yamlReader.read(ExtentionConf.class);
                System.out.println(extentionConf);
            } catch (YamlException e) {
                e.printStackTrace();
            }

            //System.out.println(hashMap);
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
            String content = FileUtils.readFileToString(new File(url.getPath()));
            return content;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
