package com.hmc.zntc.user.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;

import java.util.Date;

public class JsonTool {
    public static final String DEFAULT_DATEFORMAT = "yyyy-MM-dd HH:mm:ss";
    private static final SerializeConfig config = new SerializeConfig();
    private static SerializerFeature[] features;

    public JsonTool() {
    }

    public static String toJson(Object o) {
        return toJson(o, "yyyy-MM-dd HH:mm:ss");
    }

    public static String toJson(Object o, String dateFormat) {
        String dateformat = null == dateFormat ? "yyyy-MM-dd HH:mm:ss" : dateFormat;
        return JSON.toJSONStringWithDateFormat(o, dateformat, features);
    }

    public static String toJson(Object o, SerializeFilter filter) {
        return JSONObject.toJSONString(o, config, filter, features);
    }

    public static String toJson(Object o, SerializeFilter... filters) {
        return JSONObject.toJSONString(o, config, filters, features);
    }

    public static void addFeatures(SerializerFeature newFeature) {
        int size = features.length;
        SerializerFeature[] newFeatures = new SerializerFeature[size + 1];
        System.arraycopy(features, 0, newFeatures, 0, size);
        newFeatures[size] = newFeature;
        features = newFeatures;
    }

    static {
        config.put(Date.class, new SimpleDateFormatSerializer("yyyy-MM-dd HH:mm:ss"));
        features = new SerializerFeature[]{SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat, SerializerFeature.WriteNullListAsEmpty, SerializerFeature.WriteNullNumberAsZero, SerializerFeature.WriteNullBooleanAsFalse, SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.DisableCircularReferenceDetect};
    }
}
