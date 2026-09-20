package com.cl.dao;

import com.cl.entity.JianhurenEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JianhurenView;


/**
 * 监护人
 * 
 * @author 
 * @email 
 * @date 2024-01-10 11:17:56
 */
public interface JianhurenDao extends BaseMapper<JianhurenEntity> {
	
	List<JianhurenView> selectListView(@Param("ew") Wrapper<JianhurenEntity> wrapper);

	List<JianhurenView> selectListView(Pagination page,@Param("ew") Wrapper<JianhurenEntity> wrapper);
	
	JianhurenView selectView(@Param("ew") Wrapper<JianhurenEntity> wrapper);
	

}
