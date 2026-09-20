package com.cl.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 提醒功能
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-01-10 11:17:57
 */
@TableName("tixinggongneng")
public class TixinggongnengEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public TixinggongnengEntity() {
		
	}
	
	public TixinggongnengEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 日期
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date riqi;
	
	/**
	 * 提醒标题
	 */
					
	private String tixingbiaoti;
	
	/**
	 * 提醒内容
	 */
					
	private String tixingneirong;
	
	/**
	 * 监护人账号
	 */
					
	private String jianhurenzhanghao;
	
	/**
	 * 监护人姓名
	 */
					
	private String jianhurenxingming;
	
	/**
	 * 老人账号
	 */
					
	private String laorenzhanghao;
	
	/**
	 * 老人姓名
	 */
					
	private String laorenxingming;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：日期
	 */
	public void setRiqi(Date riqi) {
		this.riqi = riqi;
	}
	/**
	 * 获取：日期
	 */
	public Date getRiqi() {
		return riqi;
	}
	/**
	 * 设置：提醒标题
	 */
	public void setTixingbiaoti(String tixingbiaoti) {
		this.tixingbiaoti = tixingbiaoti;
	}
	/**
	 * 获取：提醒标题
	 */
	public String getTixingbiaoti() {
		return tixingbiaoti;
	}
	/**
	 * 设置：提醒内容
	 */
	public void setTixingneirong(String tixingneirong) {
		this.tixingneirong = tixingneirong;
	}
	/**
	 * 获取：提醒内容
	 */
	public String getTixingneirong() {
		return tixingneirong;
	}
	/**
	 * 设置：监护人账号
	 */
	public void setJianhurenzhanghao(String jianhurenzhanghao) {
		this.jianhurenzhanghao = jianhurenzhanghao;
	}
	/**
	 * 获取：监护人账号
	 */
	public String getJianhurenzhanghao() {
		return jianhurenzhanghao;
	}
	/**
	 * 设置：监护人姓名
	 */
	public void setJianhurenxingming(String jianhurenxingming) {
		this.jianhurenxingming = jianhurenxingming;
	}
	/**
	 * 获取：监护人姓名
	 */
	public String getJianhurenxingming() {
		return jianhurenxingming;
	}
	/**
	 * 设置：老人账号
	 */
	public void setLaorenzhanghao(String laorenzhanghao) {
		this.laorenzhanghao = laorenzhanghao;
	}
	/**
	 * 获取：老人账号
	 */
	public String getLaorenzhanghao() {
		return laorenzhanghao;
	}
	/**
	 * 设置：老人姓名
	 */
	public void setLaorenxingming(String laorenxingming) {
		this.laorenxingming = laorenxingming;
	}
	/**
	 * 获取：老人姓名
	 */
	public String getLaorenxingming() {
		return laorenxingming;
	}

}
