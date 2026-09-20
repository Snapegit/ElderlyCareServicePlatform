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


import com.cl.dao.DiscussfuwujiluDao;
import com.cl.entity.DiscussfuwujiluEntity;
import com.cl.service.DiscussfuwujiluService;
import com.cl.entity.view.DiscussfuwujiluView;

@Service("discussfuwujiluService")
public class DiscussfuwujiluServiceImpl extends ServiceImpl<DiscussfuwujiluDao, DiscussfuwujiluEntity> implements DiscussfuwujiluService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussfuwujiluEntity> page = this.selectPage(
                new Query<DiscussfuwujiluEntity>(params).getPage(),
                new EntityWrapper<DiscussfuwujiluEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussfuwujiluEntity> wrapper) {
		  Page<DiscussfuwujiluView> page =new Query<DiscussfuwujiluView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<DiscussfuwujiluView> selectListView(Wrapper<DiscussfuwujiluEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussfuwujiluView selectView(Wrapper<DiscussfuwujiluEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
