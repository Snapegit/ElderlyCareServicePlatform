package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DiscussfuwujiluEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussfuwujiluView;


/**
 * 服务记录评论表
 *
 * @author 
 * @email 
 * @date 2024-01-10 11:17:57
 */
public interface DiscussfuwujiluService extends IService<DiscussfuwujiluEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussfuwujiluView> selectListView(Wrapper<DiscussfuwujiluEntity> wrapper);
   	
   	DiscussfuwujiluView selectView(@Param("ew") Wrapper<DiscussfuwujiluEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussfuwujiluEntity> wrapper);
   	

}

