package com.cl.dao;

import com.cl.entity.YuyuequxiaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YuyuequxiaoView;


/**
 * 预约取消
 * 
 * @author 
 * @email 
 * @date 2024-01-10 11:17:57
 */
public interface YuyuequxiaoDao extends BaseMapper<YuyuequxiaoEntity> {
	
	List<YuyuequxiaoView> selectListView(@Param("ew") Wrapper<YuyuequxiaoEntity> wrapper);

	List<YuyuequxiaoView> selectListView(Pagination page,@Param("ew") Wrapper<YuyuequxiaoEntity> wrapper);
	
	YuyuequxiaoView selectView(@Param("ew") Wrapper<YuyuequxiaoEntity> wrapper);
	

}
