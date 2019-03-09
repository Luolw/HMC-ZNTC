package com.hmc.zntc.admin.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

/**
 *
 *
 * @author chengxinghua
 * @email sunlightcs@gmail.com
 * @date 2018-11-16 13:11:56
 */
@TableName("tb_sms")
public class SmsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 短信ID
	 */
	@TableId(type =  IdType.AUTO)
	private Integer id;
	/**
	 * 手机号码
	 */
	private String phoneNumber;
	/**
	 * register(用户注册)，modifyPwd(修改密码)，setTradePwd(设置交易密码)
	 */
	private String busicCode;
	/**
	 * 验证码
	 */
	private String verifyCode;
	/**
	 * 发送时间
	 */
	private Date sendTime;
	/**
	 * 到期时间
	 */
	private Date expireTime;
	/**
	 * 有效时间
	 */
	private Date validMinus;
	/**
	 * 0、未验证；1、已验证；2、已过期
	 */
	private Integer state;

	/**
	 * 设置：短信ID
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：短信ID
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：手机号码
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	/**
	 * 获取：手机号码
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * 设置：register(用户注册)，modifyPwd(修改密码)，setTradePwd(设置交易密码)
	 */
	public void setBusicCode(String busicCode) {
		this.busicCode = busicCode;
	}
	/**
	 * 获取：register(用户注册)，modifyPwd(修改密码)，setTradePwd(设置交易密码)
	 */
	public String getBusicCode() {
		return busicCode;
	}
	/**
	 * 设置：验证码
	 */
	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}
	/**
	 * 获取：验证码
	 */
	public String getVerifyCode() {
		return verifyCode;
	}
	/**
	 * 设置：发送时间
	 */
	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}
	/**
	 * 获取：发送时间
	 */
	public Date getSendTime() {
		return sendTime;
	}
	/**
	 * 设置：到期时间
	 */
	public void setExpireTime(Date expireTime) {
		this.expireTime = expireTime;
	}
	/**
	 * 获取：到期时间
	 */
	public Date getExpireTime() {
		return expireTime;
	}
	/**
	 * 设置：有效时间
	 */
	public void setValidMinus(Date validMinus) {
		this.validMinus = validMinus;
	}
	/**
	 * 获取：有效时间
	 */
	public Date getValidMinus() {
		return validMinus;
	}
	/**
	 * 设置：0、未验证；1、已验证；2、已过期
	 */
	public void setState(Integer state) {
		this.state = state;
	}
	/**
	 * 获取：0、未验证；1、已验证；2、已过期
	 */
	public Integer getState() {
		return state;
	}
}
