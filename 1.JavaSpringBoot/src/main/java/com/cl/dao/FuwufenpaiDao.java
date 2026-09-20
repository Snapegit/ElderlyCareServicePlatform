package com.cl.dao;

import com.cl.entity.FuwufenpaiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.FuwufenpaiView;


/**
 * 服务分派
 * 
 * @author 
 * @email 
 * @date 2024-01-10 11:17:57
 */
public interface FuwufenpaiDao extends BaseMapper<FuwufenpaiEntity> {
	
	List<FuwufenpaiView> selectListView(@Param("ew") Wrapper<FuwufenpaiEntity> wrapper);

	List<FuwufenpaiView> selectListView(Pagination page,@Param("ew") Wrapper<FuwufenpaiEntity> wrapper);
	
	FuwufenpaiView selectView(@Param("ew") Wrapper<FuwufenpaiEntity> wrapper);
	

}
