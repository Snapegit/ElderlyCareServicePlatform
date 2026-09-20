package com.cl.dao;

import com.cl.entity.DiscussfuwujiluEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussfuwujiluView;


/**
 * 服务记录评论表
 * 
 * @author 
 * @email 
 * @date 2024-01-10 11:17:57
 */
public interface DiscussfuwujiluDao extends BaseMapper<DiscussfuwujiluEntity> {
	
	List<DiscussfuwujiluView> selectListView(@Param("ew") Wrapper<DiscussfuwujiluEntity> wrapper);

	List<DiscussfuwujiluView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussfuwujiluEntity> wrapper);
	
	DiscussfuwujiluView selectView(@Param("ew") Wrapper<DiscussfuwujiluEntity> wrapper);
	

}
