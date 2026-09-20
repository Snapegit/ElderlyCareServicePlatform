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


import com.cl.dao.FuwufenpaiDao;
import com.cl.entity.FuwufenpaiEntity;
import com.cl.service.FuwufenpaiService;
import com.cl.entity.view.FuwufenpaiView;

@Service("fuwufenpaiService")
public class FuwufenpaiServiceImpl extends ServiceImpl<FuwufenpaiDao, FuwufenpaiEntity> implements FuwufenpaiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<FuwufenpaiEntity> page = this.selectPage(
                new Query<FuwufenpaiEntity>(params).getPage(),
                new EntityWrapper<FuwufenpaiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<FuwufenpaiEntity> wrapper) {
		  Page<FuwufenpaiView> page =new Query<FuwufenpaiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<FuwufenpaiView> selectListView(Wrapper<FuwufenpaiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public FuwufenpaiView selectView(Wrapper<FuwufenpaiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
