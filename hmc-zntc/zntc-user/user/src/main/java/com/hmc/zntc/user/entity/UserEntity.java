package com.hmc.zntc.user.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;

/**
 * 用户
 *
 * @author hmc
 * @email hmc@qq.com
 * @date 2019-01-07 10:49:14
 */
@TableName("tb_user")
public class UserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id主键
	 */
	@TableId
	private String id;
	/**
	 * 编号
	 */
	private String uuid;
	/**
	 * 用户名
	 */
	private String name;
	/**
	 * 密码
	 */
	private String pwd;
	/**
	 * 电话
	 */
	private String phone;
	/**
	 * 头像
	 */
	private String photo;
	/**
	 * 邮箱
	 */
	private String email;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 0男1女
	 */
	private Integer sex;
	/**
	 * 盐
	 */
	private String salt;
	/**
	 * 余额
	 */
	private BigDecimal money;
	/**
	 * 状态(1正常 -1禁用)
	 */
	private String status;
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
	 * 设置：编号
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	/**
	 * 获取：编号
	 */
	public String getUuid() {
		return uuid;
	}
	/**
	 * 设置：用户名
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：用户名
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：密码
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	/**
	 * 获取：密码
	 */
	public String getPwd() {
		return pwd;
	}
	/**
	 * 设置：电话
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 获取：电话
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 设置：头像
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	/**
	 * 获取：头像
	 */
	public String getPhoto() {
		return photo;
	}
	/**
	 * 设置：邮箱
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 获取：邮箱
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * 设置：备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：备注
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 设置：0男1女
	 */
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	/**
	 * 获取：0男1女
	 */
	public Integer getSex() {
		return sex;
	}
	/**
	 * 设置：盐
	 */
	public void setSalt(String salt) {
		this.salt = salt;
	}
	/**
	 * 获取：盐
	 */
	public String getSalt() {
		return salt;
	}
	/**
	 * 设置：余额
	 */
	public void setMoney(BigDecimal money) {
		this.money = money;
	}
	/**
	 * 获取：余额
	 */
	public BigDecimal getMoney() {
		return money;
	}
	/**
	 * 设置：状态(1正常 -1禁用)
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：状态(1正常 -1禁用)
	 */
	public String getStatus() {
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
