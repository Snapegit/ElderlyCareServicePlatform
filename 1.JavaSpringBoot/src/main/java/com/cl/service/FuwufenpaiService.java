package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.FuwufenpaiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.FuwufenpaiView;


/**
 * 服务分派
 *
 * @author 
 * @email 
 * @date 2024-01-10 11:17:57
 */
public interface FuwufenpaiService extends IService<FuwufenpaiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<FuwufenpaiView> selectListView(Wrapper<FuwufenpaiEntity> wrapper);
   	
   	FuwufenpaiView selectView(@Param("ew") Wrapper<FuwufenpaiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<FuwufenpaiEntity> wrapper);
   	

}

