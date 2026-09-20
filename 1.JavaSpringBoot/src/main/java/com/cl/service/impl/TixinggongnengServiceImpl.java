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


import com.cl.dao.TixinggongnengDao;
import com.cl.entity.TixinggongnengEntity;
import com.cl.service.TixinggongnengService;
import com.cl.entity.view.TixinggongnengView;

@Service("tixinggongnengService")
public class TixinggongnengServiceImpl extends ServiceImpl<TixinggongnengDao, TixinggongnengEntity> implements TixinggongnengService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<TixinggongnengEntity> page = this.selectPage(
                new Query<TixinggongnengEntity>(params).getPage(),
                new EntityWrapper<TixinggongnengEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<TixinggongnengEntity> wrapper) {
		  Page<TixinggongnengView> page =new Query<TixinggongnengView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<TixinggongnengView> selectListView(Wrapper<TixinggongnengEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public TixinggongnengView selectView(Wrapper<TixinggongnengEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
