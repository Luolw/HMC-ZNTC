package com.hmc.zntc.user.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 短信
 *
 * @author hmc
 * @email hmc@qq.com
 * @date 2019-01-07 11:20:54
 */
@TableName("tb_user_sms")
public class UserSmsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id主键
	 */
	@TableId
	private String id;
	/**
	 * 唯一id
	 */
	private String uuid;
	/**
	 * 手机号
	 */
	private String phone;
	/**
	 * 短信类型
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
	 * 状态(1正常 -1禁用)
	 */
	private Integer status;
	/**
	 * 更新时间
	 */
	private Date updateTime;
	/**
	 * 新建时间
	 */
	private Date createTime;

	/**
	 * 设置：id主键
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取：id主键
	 */
	public String getId() {
		return id;
	}
	/**
	 * 设置：唯一id
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	/**
	 * 获取：唯一id
	 */
	public String getUuid() {
		return uuid;
	}
	/**
	 * 设置：手机号
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 获取：手机号
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 设置：短信类型
	 */
	public void setBusicCode(String busicCode) {
		this.busicCode = busicCode;
	}
	/**
	 * 获取：短信类型
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
	 * 设置：状态(1正常 -1禁用)
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：状态(1正常 -1禁用)
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：更新时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：更新时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * 设置：新建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：新建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
}
