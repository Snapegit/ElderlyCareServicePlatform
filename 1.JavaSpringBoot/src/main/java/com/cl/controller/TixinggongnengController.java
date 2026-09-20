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

import com.cl.entity.TixinggongnengEntity;
import com.cl.entity.view.TixinggongnengView;

import com.cl.service.TixinggongnengService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MD5Util;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 提醒功能
 * 后端接口
 * @author 
 * @email 
 * @date 2024-01-10 11:17:57
 */
@RestController
@RequestMapping("/tixinggongneng")
public class TixinggongnengController {
    @Autowired
    private TixinggongnengService tixinggongnengService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,TixinggongnengEntity tixinggongneng,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date riqistart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date riqiend,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jianhuren")) {
			tixinggongneng.setJianhurenzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("laoren")) {
			tixinggongneng.setLaorenzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<TixinggongnengEntity> ew = new EntityWrapper<TixinggongnengEntity>();
                if(riqistart!=null) ew.ge("riqi", riqistart);
                if(riqiend!=null) ew.le("riqi", riqiend);

		PageUtils page = tixinggongnengService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tixinggongneng), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,TixinggongnengEntity tixinggongneng, 
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date riqistart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date riqiend,
		HttpServletRequest request){
        EntityWrapper<TixinggongnengEntity> ew = new EntityWrapper<TixinggongnengEntity>();
                if(riqistart!=null) ew.ge("riqi", riqistart);
                if(riqiend!=null) ew.le("riqi", riqiend);

		PageUtils page = tixinggongnengService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tixinggongneng), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( TixinggongnengEntity tixinggongneng){
       	EntityWrapper<TixinggongnengEntity> ew = new EntityWrapper<TixinggongnengEntity>();
      	ew.allEq(MPUtil.allEQMapPre( tixinggongneng, "tixinggongneng")); 
        return R.ok().put("data", tixinggongnengService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(TixinggongnengEntity tixinggongneng){
        EntityWrapper< TixinggongnengEntity> ew = new EntityWrapper< TixinggongnengEntity>();
 		ew.allEq(MPUtil.allEQMapPre( tixinggongneng, "tixinggongneng")); 
		TixinggongnengView tixinggongnengView =  tixinggongnengService.selectView(ew);
		return R.ok("查询提醒功能成功").put("data", tixinggongnengView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        TixinggongnengEntity tixinggongneng = tixinggongnengService.selectById(id);
        return R.ok().put("data", tixinggongneng);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        TixinggongnengEntity tixinggongneng = tixinggongnengService.selectById(id);
        return R.ok().put("data", tixinggongneng);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody TixinggongnengEntity tixinggongneng, HttpServletRequest request){
    	tixinggongneng.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(tixinggongneng);
        tixinggongnengService.insert(tixinggongneng);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody TixinggongnengEntity tixinggongneng, HttpServletRequest request){
    	tixinggongneng.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(tixinggongneng);
        tixinggongnengService.insert(tixinggongneng);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody TixinggongnengEntity tixinggongneng, HttpServletRequest request){
        //ValidatorUtils.validateEntity(tixinggongneng);
        tixinggongnengService.updateById(tixinggongneng);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        tixinggongnengService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
