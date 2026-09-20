package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.HuodongquyuDao;
import com.cl.entity.HuodongquyuEntity;
import com.cl.service.HuodongquyuService;
import com.cl.entity.view.HuodongquyuView;

@Service("huodongquyuService")
public class HuodongquyuServiceImpl extends ServiceImpl<HuodongquyuDao, HuodongquyuEntity> implements HuodongquyuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<HuodongquyuEntity> page = this.selectPage(
                new Query<HuodongquyuEntity>(params).getPage(),
                new EntityWrapper<HuodongquyuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<HuodongquyuEntity> wrapper) {
		  Page<HuodongquyuView> page =new Query<HuodongquyuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<HuodongquyuView> selectListView(Wrapper<HuodongquyuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public HuodongquyuView selectView(Wrapper<HuodongquyuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
