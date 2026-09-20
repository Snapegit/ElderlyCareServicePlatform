package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.FuwujiluEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.FuwujiluView;


/**
 * 服务记录
 *
 * @author 
 * @email 
 * @date 2024-01-10 11:17:57
 */
public interface FuwujiluService extends IService<FuwujiluEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<FuwujiluView> selectListView(Wrapper<FuwujiluEntity> wrapper);
   	
   	FuwujiluView selectView(@Param("ew") Wrapper<FuwujiluEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<FuwujiluEntity> wrapper);
   	

}

