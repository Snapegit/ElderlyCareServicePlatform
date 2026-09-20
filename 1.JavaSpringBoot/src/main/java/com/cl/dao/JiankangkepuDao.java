package com.cl.dao;

import com.cl.entity.JiankangkepuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JiankangkepuView;


/**
 * 健康科普
 * 
 * @author 
 * @email 
 * @date 2024-01-10 11:17:56
 */
public interface JiankangkepuDao extends BaseMapper<JiankangkepuEntity> {
	
	List<JiankangkepuView> selectListView(@Param("ew") Wrapper<JiankangkepuEntity> wrapper);

	List<JiankangkepuView> selectListView(Pagination page,@Param("ew") Wrapper<JiankangkepuEntity> wrapper);
	
	JiankangkepuView selectView(@Param("ew") Wrapper<JiankangkepuEntity> wrapper);
	

}
