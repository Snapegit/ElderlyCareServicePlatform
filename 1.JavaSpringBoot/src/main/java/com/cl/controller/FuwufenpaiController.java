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

import com.cl.entity.FuwufenpaiEntity;
import com.cl.entity.view.FuwufenpaiView;

import com.cl.service.FuwufenpaiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MD5Util;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 服务分派
 * 后端接口
 * @author 
 * @email 
 * @date 2024-01-10 11:17:57
 */
@RestController
@RequestMapping("/fuwufenpai")
public class FuwufenpaiController {
    @Autowired
    private FuwufenpaiService fuwufenpaiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,FuwufenpaiEntity fuwufenpai,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date fuwushijianstart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date fuwushijianend,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("laoren")) {
			fuwufenpai.setLaorenzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("zhiyuanzhe")) {
			fuwufenpai.setZhiyuanzhezhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<FuwufenpaiEntity> ew = new EntityWrapper<FuwufenpaiEntity>();
                if(fuwushijianstart!=null) ew.ge("fuwushijian", fuwushijianstart);
                if(fuwushijianend!=null) ew.le("fuwushijian", fuwushijianend);

		PageUtils page = fuwufenpaiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fuwufenpai), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,FuwufenpaiEntity fuwufenpai, 
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date fuwushijianstart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date fuwushijianend,
		HttpServletRequest request){
        EntityWrapper<FuwufenpaiEntity> ew = new EntityWrapper<FuwufenpaiEntity>();
                if(fuwushijianstart!=null) ew.ge("fuwushijian", fuwushijianstart);
                if(fuwushijianend!=null) ew.le("fuwushijian", fuwushijianend);

		PageUtils page = fuwufenpaiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fuwufenpai), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( FuwufenpaiEntity fuwufenpai){
       	EntityWrapper<FuwufenpaiEntity> ew = new EntityWrapper<FuwufenpaiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( fuwufenpai, "fuwufenpai")); 
        return R.ok().put("data", fuwufenpaiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(FuwufenpaiEntity fuwufenpai){
        EntityWrapper< FuwufenpaiEntity> ew = new EntityWrapper< FuwufenpaiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( fuwufenpai, "fuwufenpai")); 
		FuwufenpaiView fuwufenpaiView =  fuwufenpaiService.selectView(ew);
		return R.ok("查询服务分派成功").put("data", fuwufenpaiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        FuwufenpaiEntity fuwufenpai = fuwufenpaiService.selectById(id);
        return R.ok().put("data", fuwufenpai);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        FuwufenpaiEntity fuwufenpai = fuwufenpaiService.selectById(id);
        return R.ok().put("data", fuwufenpai);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody FuwufenpaiEntity fuwufenpai, HttpServletRequest request){
    	fuwufenpai.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(fuwufenpai);
        fuwufenpaiService.insert(fuwufenpai);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody FuwufenpaiEntity fuwufenpai, HttpServletRequest request){
    	fuwufenpai.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(fuwufenpai);
        fuwufenpaiService.insert(fuwufenpai);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody FuwufenpaiEntity fuwufenpai, HttpServletRequest request){
        //ValidatorUtils.validateEntity(fuwufenpai);
        fuwufenpaiService.updateById(fuwufenpai);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        fuwufenpaiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
