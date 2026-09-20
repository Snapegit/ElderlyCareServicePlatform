package com.cl.entity.view;

import com.cl.entity.DiscussfuwujiluEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
 

/**
 * 服务记录评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-01-10 11:17:57
 */
@TableName("discussfuwujilu")
public class DiscussfuwujiluView  extends DiscussfuwujiluEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussfuwujiluView(){
	}
 
 	public DiscussfuwujiluView(DiscussfuwujiluEntity discussfuwujiluEntity){
 	try {
			BeanUtils.copyProperties(this, discussfuwujiluEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}

}
