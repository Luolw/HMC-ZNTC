package com.hmc.zntc.user.service;


public interface   RedisService {

    /**
     * set存登入图片验证码，
     * @param key
     * @param value
     * @return
     */
    Object setCode(String key, String value,Integer second);


    /**
     * set存数据，自定义保存时间，单位天
     * @param key
     * @param value
     * @param day 保存多少天
     * @return
     */
    boolean setDay(String key, String value, Integer day);

    /**
     * get获取数据
     *
     * @param key
     * @return
     */
    String get(String key);


    /**
     * 移除数据
     *
     * @param key
     * @return
     */
    boolean remove(String key);


}
