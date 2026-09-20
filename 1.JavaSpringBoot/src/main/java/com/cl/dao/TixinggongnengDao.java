package com.cl.dao;

import com.cl.entity.TixinggongnengEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.TixinggongnengView;


/**
 * 提醒功能
 * 
 * @author 
 * @email 
 * @date 2024-01-10 11:17:57
 */
public interface TixinggongnengDao extends BaseMapper<TixinggongnengEntity> {
	
	List<TixinggongnengView> selectListView(@Param("ew") Wrapper<TixinggongnengEntity> wrapper);

	List<TixinggongnengView> selectListView(Pagination page,@Param("ew") Wrapper<TixinggongnengEntity> wrapper);
	
	TixinggongnengView selectView(@Param("ew") Wrapper<TixinggongnengEntity> wrapper);
	

}
