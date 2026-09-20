package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.FuwujiluEntity;
import com.cl.entity.view.FuwujiluView;

import com.cl.service.FuwujiluService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MD5Util;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 服务记录
 * 后端接口
 * @author 
 * @email 
 * @date 2024-01-10 11:17:57
 */
@RestController
@RequestMapping("/fuwujilu")
public class FuwujiluController {
    @Autowired
    private FuwujiluService fuwujiluService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,FuwujiluEntity fuwujilu,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("zhiyuanzhe")) {
			fuwujilu.setZhiyuanzhezhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<FuwujiluEntity> ew = new EntityWrapper<FuwujiluEntity>();

		PageUtils page = fuwujiluService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fuwujilu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,FuwujiluEntity fuwujilu, 
		HttpServletRequest request){
        EntityWrapper<FuwujiluEntity> ew = new EntityWrapper<FuwujiluEntity>();

		PageUtils page = fuwujiluService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fuwujilu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( FuwujiluEntity fuwujilu){
       	EntityWrapper<FuwujiluEntity> ew = new EntityWrapper<FuwujiluEntity>();
      	ew.allEq(MPUtil.allEQMapPre( fuwujilu, "fuwujilu")); 
        return R.ok().put("data", fuwujiluService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(FuwujiluEntity fuwujilu){
        EntityWrapper< FuwujiluEntity> ew = new EntityWrapper< FuwujiluEntity>();
 		ew.allEq(MPUtil.allEQMapPre( fuwujilu, "fuwujilu")); 
		FuwujiluView fuwujiluView =  fuwujiluService.selectView(ew);
		return R.ok("查询服务记录成功").put("data", fuwujiluView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        FuwujiluEntity fuwujilu = fuwujiluService.selectById(id);
        return R.ok().put("data", fuwujilu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        FuwujiluEntity fuwujilu = fuwujiluService.selectById(id);
        return R.ok().put("data", fuwujilu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody FuwujiluEntity fuwujilu, HttpServletRequest request){
    	fuwujilu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(fuwujilu);
        fuwujiluService.insert(fuwujilu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody FuwujiluEntity fuwujilu, HttpServletRequest request){
    	fuwujilu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(fuwujilu);
        fuwujiluService.insert(fuwujilu);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody FuwujiluEntity fuwujilu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(fuwujilu);
        fuwujiluService.updateById(fuwujilu);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        fuwujiluService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
