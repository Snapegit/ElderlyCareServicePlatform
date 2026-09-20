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

import com.cl.entity.HuodongquyuEntity;
import com.cl.entity.view.HuodongquyuView;

import com.cl.service.HuodongquyuService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MD5Util;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 活动区域
 * 后端接口
 * @author 
 * @email 
 * @date 2024-01-10 11:17:57
 */
@RestController
@RequestMapping("/huodongquyu")
public class HuodongquyuController {
    @Autowired
    private HuodongquyuService huodongquyuService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,HuodongquyuEntity huodongquyu,
		HttpServletRequest request){
        EntityWrapper<HuodongquyuEntity> ew = new EntityWrapper<HuodongquyuEntity>();

		PageUtils page = huodongquyuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, huodongquyu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,HuodongquyuEntity huodongquyu, 
		HttpServletRequest request){
        EntityWrapper<HuodongquyuEntity> ew = new EntityWrapper<HuodongquyuEntity>();

		PageUtils page = huodongquyuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, huodongquyu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( HuodongquyuEntity huodongquyu){
       	EntityWrapper<HuodongquyuEntity> ew = new EntityWrapper<HuodongquyuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( huodongquyu, "huodongquyu")); 
        return R.ok().put("data", huodongquyuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(HuodongquyuEntity huodongquyu){
        EntityWrapper< HuodongquyuEntity> ew = new EntityWrapper< HuodongquyuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( huodongquyu, "huodongquyu")); 
		HuodongquyuView huodongquyuView =  huodongquyuService.selectView(ew);
		return R.ok("查询活动区域成功").put("data", huodongquyuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        HuodongquyuEntity huodongquyu = huodongquyuService.selectById(id);
        return R.ok().put("data", huodongquyu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        HuodongquyuEntity huodongquyu = huodongquyuService.selectById(id);
        return R.ok().put("data", huodongquyu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody HuodongquyuEntity huodongquyu, HttpServletRequest request){
    	huodongquyu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(huodongquyu);
        huodongquyuService.insert(huodongquyu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody HuodongquyuEntity huodongquyu, HttpServletRequest request){
    	huodongquyu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(huodongquyu);
        huodongquyuService.insert(huodongquyu);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody HuodongquyuEntity huodongquyu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(huodongquyu);
        huodongquyuService.updateById(huodongquyu);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        huodongquyuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
