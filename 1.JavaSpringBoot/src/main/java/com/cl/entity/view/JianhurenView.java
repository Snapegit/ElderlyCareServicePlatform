package com.cl.entity.view;

import com.cl.entity.JianhurenEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
 

/**
 * 监护人
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-01-10 11:17:56
 */
@TableName("jianhuren")
public class JianhurenView  extends JianhurenEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public JianhurenView(){
	}
 
 	public JianhurenView(JianhurenEntity jianhurenEntity){
 	try {
			BeanUtils.copyProperties(this, jianhurenEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}

}
