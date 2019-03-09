package com.hmc.zntc.admin.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;

/**
 * 广告设置
 * 
 * @author hmc
 * @email hmc@qq.com
 * @date 2019-01-07 14:41:12
 */
@TableName("tb_advert")
public class AdvertEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 自增id
	 */
	@TableId
	private Integer id;
	/**
	 * 资源ID
	 */
	private String uuid;
	/**
	 * -1禁止 0正常 
	 */
	private Integer status;
	/**
	 * 广告来源
	 */
	private String orgin;
	/**
	 * 开始时间
	 */
	private Date startTime;
	/**
	 * 结束时间
	 */
	private Date endTime;
	/**
	 * 一体机数量
	 */
	private Integer count;
	/**
	 * 曝光次数
	 */
	private Integer playTimes;
	/**
	 * 轮播速度
	 */
	private BigDecimal playSpeed;
	/**
	 * 颜色
	 */
	private String color;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;

	/**
	 * 设置：自增id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：自增id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：资源ID
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	/**
	 * 获取：资源ID
	 */
	public String getUuid() {
		return uuid;
	}
	/**
	 * 设置：-1禁止 0正常 
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：-1禁止 0正常 
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：广告来源
	 */
	public void setOrgin(String orgin) {
		this.orgin = orgin;
	}
	/**
	 * 获取：广告来源
	 */
	public String getOrgin() {
		return orgin;
	}
	/**
	 * 设置：开始时间
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	/**
	 * 获取：开始时间
	 */
	public Date getStartTime() {
		return startTime;
	}
	/**
	 * 设置：结束时间
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	/**
	 * 获取：结束时间
	 */
	public Date getEndTime() {
		return endTime;
	}
	/**
	 * 设置：一体机数量
	 */
	public void setCount(Integer count) {
		this.count = count;
	}
	/**
	 * 获取：一体机数量
	 */
	public Integer getCount() {
		return count;
	}
	/**
	 * 设置：曝光次数
	 */
	public void setPlayTimes(Integer playTimes) {
		this.playTimes = playTimes;
	}
	/**
	 * 获取：曝光次数
	 */
	public Integer getPlayTimes() {
		return playTimes;
	}
	/**
	 * 设置：轮播速度
	 */
	public void setPlaySpeed(BigDecimal playSpeed) {
		this.playSpeed = playSpeed;
	}
	/**
	 * 获取：轮播速度
	 */
	public BigDecimal getPlaySpeed() {
		return playSpeed;
	}
	/**
	 * 设置：颜色
	 */
	public void setColor(String color) {
		this.color = color;
	}
	/**
	 * 获取：颜色
	 */
	public String getColor() {
		return color;
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
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
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
}
