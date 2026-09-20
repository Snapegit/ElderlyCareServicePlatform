package com.cl.dao;

import com.cl.entity.HuodongquyuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.HuodongquyuView;


/**
 * 活动区域
 * 
 * @author 
 * @email 
 * @date 2024-01-10 11:17:57
 */
public interface HuodongquyuDao extends BaseMapper<HuodongquyuEntity> {
	
	List<HuodongquyuView> selectListView(@Param("ew") Wrapper<HuodongquyuEntity> wrapper);

	List<HuodongquyuView> selectListView(Pagination page,@Param("ew") Wrapper<HuodongquyuEntity> wrapper);
	
	HuodongquyuView selectView(@Param("ew") Wrapper<HuodongquyuEntity> wrapper);
	

}
