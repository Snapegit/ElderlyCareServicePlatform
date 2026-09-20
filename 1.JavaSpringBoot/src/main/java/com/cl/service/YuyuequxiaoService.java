package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.YuyuequxiaoEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YuyuequxiaoView;


/**
 * 预约取消
 *
 * @author 
 * @email 
 * @date 2024-01-10 11:17:57
 */
public interface YuyuequxiaoService extends IService<YuyuequxiaoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YuyuequxiaoView> selectListView(Wrapper<YuyuequxiaoEntity> wrapper);
   	
   	YuyuequxiaoView selectView(@Param("ew") Wrapper<YuyuequxiaoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YuyuequxiaoEntity> wrapper);
   	

}

