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

import com.cl.entity.YuyuequxiaoEntity;
import com.cl.entity.view.YuyuequxiaoView;

import com.cl.service.YuyuequxiaoService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MD5Util;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 预约取消
 * 后端接口
 * @author 
 * @email 
 * @date 2024-01-10 11:17:57
 */
@RestController
@RequestMapping("/yuyuequxiao")
public class YuyuequxiaoController {
    @Autowired
    private YuyuequxiaoService yuyuequxiaoService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YuyuequxiaoEntity yuyuequxiao,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date fuwushijianstart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date fuwushijianend,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("laoren")) {
			yuyuequxiao.setLaorenzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("jianhuren")) {
			yuyuequxiao.setJianhurenzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<YuyuequxiaoEntity> ew = new EntityWrapper<YuyuequxiaoEntity>();
                if(fuwushijianstart!=null) ew.ge("fuwushijian", fuwushijianstart);
                if(fuwushijianend!=null) ew.le("fuwushijian", fuwushijianend);

		PageUtils page = yuyuequxiaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yuyuequxiao), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YuyuequxiaoEntity yuyuequxiao, 
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date fuwushijianstart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date fuwushijianend,
		HttpServletRequest request){
        EntityWrapper<YuyuequxiaoEntity> ew = new EntityWrapper<YuyuequxiaoEntity>();
                if(fuwushijianstart!=null) ew.ge("fuwushijian", fuwushijianstart);
                if(fuwushijianend!=null) ew.le("fuwushijian", fuwushijianend);

		PageUtils page = yuyuequxiaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yuyuequxiao), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YuyuequxiaoEntity yuyuequxiao){
       	EntityWrapper<YuyuequxiaoEntity> ew = new EntityWrapper<YuyuequxiaoEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yuyuequxiao, "yuyuequxiao")); 
        return R.ok().put("data", yuyuequxiaoService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YuyuequxiaoEntity yuyuequxiao){
        EntityWrapper< YuyuequxiaoEntity> ew = new EntityWrapper< YuyuequxiaoEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yuyuequxiao, "yuyuequxiao")); 
		YuyuequxiaoView yuyuequxiaoView =  yuyuequxiaoService.selectView(ew);
		return R.ok("查询预约取消成功").put("data", yuyuequxiaoView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YuyuequxiaoEntity yuyuequxiao = yuyuequxiaoService.selectById(id);
        return R.ok().put("data", yuyuequxiao);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YuyuequxiaoEntity yuyuequxiao = yuyuequxiaoService.selectById(id);
        return R.ok().put("data", yuyuequxiao);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YuyuequxiaoEntity yuyuequxiao, HttpServletRequest request){
    	yuyuequxiao.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yuyuequxiao);
        yuyuequxiaoService.insert(yuyuequxiao);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YuyuequxiaoEntity yuyuequxiao, HttpServletRequest request){
    	yuyuequxiao.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yuyuequxiao);
        yuyuequxiaoService.insert(yuyuequxiao);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YuyuequxiaoEntity yuyuequxiao, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yuyuequxiao);
        yuyuequxiaoService.updateById(yuyuequxiao);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yuyuequxiaoService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
