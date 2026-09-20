package com.cl.dao;

import com.cl.entity.FuwujiluEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.FuwujiluView;


/**
 * 服务记录
 * 
 * @author 
 * @email 
 * @date 2024-01-10 11:17:57
 */
public interface FuwujiluDao extends BaseMapper<FuwujiluEntity> {
	
	List<FuwujiluView> selectListView(@Param("ew") Wrapper<FuwujiluEntity> wrapper);

	List<FuwujiluView> selectListView(Pagination page,@Param("ew") Wrapper<FuwujiluEntity> wrapper);
	
	FuwujiluView selectView(@Param("ew") Wrapper<FuwujiluEntity> wrapper);
	

}
