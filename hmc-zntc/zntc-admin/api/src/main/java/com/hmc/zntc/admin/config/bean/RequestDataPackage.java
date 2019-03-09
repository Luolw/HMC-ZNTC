package com.hmc.zntc.admin.config.bean;

import com.alibaba.fastjson.JSONObject;
import com.hmc.zntc.admin.utils.JsonTool;
import com.hmc.zntc.admin.utils.SecurityTool;
import com.hmc.zntc.admin.utils.TypeUtil;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Map;

public class RequestDataPackage {
    private Map<String, Object> global;
    private Map<String, Object> data;

    public RequestDataPackage() {
    }

    public Map<String, Object> getGlobal() {
        return this.global;
    }

    public void setGlobal(Map<String, Object> global) {
        this.global = global;
    }

    public Map<String, Object> getData() {
        if (null == this.data) {
            throw new IllegalArgumentException(" data not null");
        } else {
            return this.data;
        }
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public String getLoc() {
        return this.checkStr(this.getGlobal().get("loc"), (String)null);
    }

    public String getOs() {
        return this.checkStr(this.getGlobal().get("os"), (String)null);
    }

    public String getPort() {
        return this.checkStr(this.getGlobal().get("port"), (String)null);
    }

    public String getSign() {
        return (String)this.getGlobal().get("sign");
    }

    public String getToken() {
        return (String)this.getGlobal().get("token");
    }

    public String getAppKey() {
        return this.checkStr(this.getGlobal().get("appKey"), (String)null);
    }

    public String getDataJson() {
        return JsonTool.toJson(this.getData());
    }

    public <M> M getDataBean(Class<M> clazz) {
        return JSONObject.parseObject(this.getDataJson(), clazz);
    }

    public <M> M getData(String key) {
        Object getDataValue = this.getData().get(key);
        return getDataValue instanceof Double ? (M) (((Double)getDataValue).intValue() + "") : (M) getDataValue;
    }

    public <M> M getGlobal(String key) {
        return (M) this.getGlobal().get(key);
    }

    public String getDataSecurityStr(String key) {
        String str = (String)this.getData(key);
        return SecurityTool.replaceNoSecurityStr(str);
    }

    public String getDataChildQueryString(String key) {
        Map<String, Object> queryMap = (Map)this.getData().get("queryString");
        return queryMap == null ? null : this.checkStr(queryMap.get(key), (String)null);
    }

    public String toString() {
        return "RequestDataPackage [global=" + this.global + ", data=" + this.data + "]";
    }

    String checkStr(Object str, String defaultStr) {
        if (str != null && str.toString().length() != 0) {
            if (str instanceof Double) {
                Double object = (Double)str;
                return object.intValue() + "";
            } else {
                return SecurityTool.replaceNoSecurityStr(str.toString());
            }
        } else {
            return defaultStr;
        }
    }

    public String getDataToString(String key) {
        return TypeUtil.castToString(this.getData().get(key));
    }

    public Byte getDataToByte(String key) {
        return TypeUtil.castToByte(this.getData().get(key));
    }

    public Character getDataToChar(String key) {
        return TypeUtil.castToChar(this.getData().get(key));
    }

    public Short getDataToShort(String key) {
        return TypeUtil.castToShort(this.getData().get(key));
    }

    public BigDecimal getDataToBigDecimal(String key) {
        return TypeUtil.castToBigDecimal(this.getData().get(key));
    }

    public BigInteger getDataToBigInteger(String key) {
        return TypeUtil.castToBigInteger(this.getData().get(key));
    }

    public Float getDataToFloat(String key) {
        return TypeUtil.castToFloat(this.getData().get(key));
    }

    public Double getDataToDouble(String key) {
        return TypeUtil.castToDouble(this.getData().get(key));
    }

    public Timestamp getDataToTimestamp(String key) {
        return TypeUtil.castToTimestamp(this.getData().get(key));
    }

    public Long getDataToLong(String key) {
        return TypeUtil.castToLong(this.getData().get(key));
    }

    public Integer getDataToInt(String key) {
        return TypeUtil.castToInt(this.getData().get(key));
    }

    public byte[] getDataToBytes(String key) {
        return TypeUtil.castToBytes(this.getData().get(key));
    }

    public Boolean getDataToBoolean(String key) {
        return TypeUtil.castToBoolean(this.getData().get(key));
    }
}

