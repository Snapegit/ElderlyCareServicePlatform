package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.HuodongquyuEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.HuodongquyuView;


/**
 * 活动区域
 *
 * @author 
 * @email 
 * @date 2024-01-10 11:17:57
 */
public interface HuodongquyuService extends IService<HuodongquyuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<HuodongquyuView> selectListView(Wrapper<HuodongquyuEntity> wrapper);
   	
   	HuodongquyuView selectView(@Param("ew") Wrapper<HuodongquyuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<HuodongquyuEntity> wrapper);
   	

}

