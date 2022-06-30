package com.lyl.work.sensitiveutils.sensitive;

/**
 * <p> Description : sadf
 * 脱敏工具
 *
 * @author : liuyuanlong
 * @date : 2022/6/23 15:02
 */

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 
 * <p> Description : SensitiveInfoUtils
 *
 * @author : liuyuanlong
 * @date : 2022/6/23 15:07
 */
public final class SensitiveInfoUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(SensitiveInfoUtils.class);

    /**
     * 脱敏
     *
     * @param value  需要脱敏的对象
     * @param filter 脱敏属性名列表
     * @return
     */
    public static JsonNode desensitization(Object value, List<String> filter) {

        if (null == value) {
            return null;
        }

        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = null;

        try {
            String json = mapper.writeValueAsString(value);
            jsonNode = mapper.readTree(json);
        } catch (JsonProcessingException e) {
            LOGGER.warn("desensitization writeValueAsString error. value={}", value);
            return new TextNode(value.getClass().getName());
        } catch (IOException e) {
            LOGGER.error("desensitization error. e=", e);
        }
        jsonLeaf(jsonNode, filter);

        return jsonNode;
    }

    /**
     * 遍历 jsonnode 并脱敏指定名成的node
     *
     * @param node        node
     * @param filterNames 处理字段
     */
    public static void jsonLeaf(JsonNode node, List<String> filterNames) {

        if (node.isObject()) {

            ObjectNode objectNode = (ObjectNode) node;
            Iterator<Map.Entry<String, JsonNode>> fields = objectNode.fields();
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> entry = fields.next();

                if (filterNames.contains(entry.getKey())) {
                    String value = getStringByLength(entry.getValue().textValue());

                    JsonNode newNode;
                    if (StringUtils.isBlank(value)) {
                        newNode = new TextNode("");
                    } else {
                        newNode = new TextNode(value);
                    }
                    entry.setValue(newNode);
                }
            }
            Iterator<Map.Entry<String, JsonNode>> it = node.fields();

            while (it.hasNext()) {
                Map.Entry<String, JsonNode> entry = it.next();
                jsonLeaf(entry.getValue(), filterNames);
            }
        }

        if (node.isArray()) {
            Iterator<JsonNode> it = node.iterator();
            while (it.hasNext()) {
                jsonLeaf(it.next(), filterNames);
            }
        }
    }

    private static String getStringByLength(String value) {
        if (StringUtils.isBlank(value)) {
            return value;
        }

        int length = value.length();
        if (length == 2) {
            value = value.substring(0, 1) + "*";
        } else if (length == 3) {
            value = value.substring(0, 1) + "*" + value.substring(length - 1);
        } else if (length > 3 && length <= 5) {
            value = value.substring(0, 1) + "**" + value.substring(length - 2);
        } else if (length > 5 && length <= 7) {
            value = value.substring(0, 2) + "***" + value.substring(length - 2);
        } else if (length > 7) {
            value = value.substring(0, 3) + "*****" + value.substring(length - 3);
        }
        return value;
    }
}
