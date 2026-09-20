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
 * 健康信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-01-10 11:17:56
 */
@TableName("jiankangxinxi")
public class JiankangxinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public JiankangxinxiEntity() {
		
	}
	
	public JiankangxinxiEntity(T t) {
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
	 * 老人账号
	 */
					
	private String laorenzhanghao;
	
	/**
	 * 老人姓名
	 */
					
	private String laorenxingming;
	
	/**
	 * 性别
	 */
					
	private String xingbie;
	
	/**
	 * 年龄
	 */
					
	private String nianling;
	
	/**
	 * 监护人账号
	 */
					
	private String jianhurenzhanghao;
	
	/**
	 * 监护人姓名
	 */
					
	private String jianhurenxingming;
	
	/**
	 * 健康状况
	 */
					
	private String jiankangzhuangkuang;
	
	/**
	 * 慢性病
	 */
					
	private String manxingbing;
	
	/**
	 * 家族病史
	 */
					
	private String jiazubingshi;
	
	/**
	 * 登记时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date dengjishijian;
	
	
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
	/**
	 * 设置：性别
	 */
	public void setXingbie(String xingbie) {
		this.xingbie = xingbie;
	}
	/**
	 * 获取：性别
	 */
	public String getXingbie() {
		return xingbie;
	}
	/**
	 * 设置：年龄
	 */
	public void setNianling(String nianling) {
		this.nianling = nianling;
	}
	/**
	 * 获取：年龄
	 */
	public String getNianling() {
		return nianling;
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
	 * 设置：健康状况
	 */
	public void setJiankangzhuangkuang(String jiankangzhuangkuang) {
		this.jiankangzhuangkuang = jiankangzhuangkuang;
	}
	/**
	 * 获取：健康状况
	 */
	public String getJiankangzhuangkuang() {
		return jiankangzhuangkuang;
	}
	/**
	 * 设置：慢性病
	 */
	public void setManxingbing(String manxingbing) {
		this.manxingbing = manxingbing;
	}
	/**
	 * 获取：慢性病
	 */
	public String getManxingbing() {
		return manxingbing;
	}
	/**
	 * 设置：家族病史
	 */
	public void setJiazubingshi(String jiazubingshi) {
		this.jiazubingshi = jiazubingshi;
	}
	/**
	 * 获取：家族病史
	 */
	public String getJiazubingshi() {
		return jiazubingshi;
	}
	/**
	 * 设置：登记时间
	 */
	public void setDengjishijian(Date dengjishijian) {
		this.dengjishijian = dengjishijian;
	}
	/**
	 * 获取：登记时间
	 */
	public Date getDengjishijian() {
		return dengjishijian;
	}

}
