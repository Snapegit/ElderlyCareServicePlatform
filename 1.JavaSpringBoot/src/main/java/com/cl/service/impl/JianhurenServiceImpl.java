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


import com.cl.dao.JianhurenDao;
import com.cl.entity.JianhurenEntity;
import com.cl.service.JianhurenService;
import com.cl.entity.view.JianhurenView;

@Service("jianhurenService")
public class JianhurenServiceImpl extends ServiceImpl<JianhurenDao, JianhurenEntity> implements JianhurenService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JianhurenEntity> page = this.selectPage(
                new Query<JianhurenEntity>(params).getPage(),
                new EntityWrapper<JianhurenEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JianhurenEntity> wrapper) {
		  Page<JianhurenView> page =new Query<JianhurenView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<JianhurenView> selectListView(Wrapper<JianhurenEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JianhurenView selectView(Wrapper<JianhurenEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
