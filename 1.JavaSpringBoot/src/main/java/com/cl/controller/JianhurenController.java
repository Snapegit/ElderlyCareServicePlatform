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

import com.cl.entity.JianhurenEntity;
import com.cl.entity.view.JianhurenView;

import com.cl.service.JianhurenService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MD5Util;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 监护人
 * 后端接口
 * @author 
 * @email 
 * @date 2024-01-10 11:17:56
 */
@RestController
@RequestMapping("/jianhuren")
public class JianhurenController {
    @Autowired
    private JianhurenService jianhurenService;



    
	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		JianhurenEntity u = jianhurenService.selectOne(new EntityWrapper<JianhurenEntity>().eq("jianhurenzhanghao", username));
		if(u==null || !u.getJianhurenmima().equals(MD5Util.md5(password))) {
			return R.error("账号或密码不正确");
		}
		String token = tokenService.generateToken(u.getId(), username,"jianhuren",  "监护人" );
		return R.ok().put("token", token);
	}

	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody JianhurenEntity jianhuren){
    	//ValidatorUtils.validateEntity(jianhuren);
    	JianhurenEntity u = jianhurenService.selectOne(new EntityWrapper<JianhurenEntity>().eq("jianhurenzhanghao", jianhuren.getJianhurenzhanghao()));
		if(u!=null) {
			return R.error("注册用户已存在");
		}
		Long uId = new Date().getTime();
		jianhuren.setId(uId);
                jianhuren.setJianhurenmima(MD5Util.md5(jianhuren.getJianhurenmima()));
        jianhurenService.insert(jianhuren);
        return R.ok();
    }

	
	/**
	 * 退出
	 */
	@RequestMapping("/logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("退出成功");
	}
	
	/**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        JianhurenEntity u = jianhurenService.selectById(id);
        return R.ok().put("data", u);
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	JianhurenEntity u = jianhurenService.selectOne(new EntityWrapper<JianhurenEntity>().eq("jianhurenzhanghao", username));
    	if(u==null) {
    		return R.error("账号不存在");
    	}
        u.setJianhurenmima(MD5Util.md5("123456"));
        jianhurenService.updateById(u);
        return R.ok("密码已重置为：123456");
    }


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JianhurenEntity jianhuren,
		HttpServletRequest request){
        EntityWrapper<JianhurenEntity> ew = new EntityWrapper<JianhurenEntity>();

		PageUtils page = jianhurenService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jianhuren), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JianhurenEntity jianhuren, 
		HttpServletRequest request){
        EntityWrapper<JianhurenEntity> ew = new EntityWrapper<JianhurenEntity>();

		PageUtils page = jianhurenService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jianhuren), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JianhurenEntity jianhuren){
       	EntityWrapper<JianhurenEntity> ew = new EntityWrapper<JianhurenEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jianhuren, "jianhuren")); 
        return R.ok().put("data", jianhurenService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JianhurenEntity jianhuren){
        EntityWrapper< JianhurenEntity> ew = new EntityWrapper< JianhurenEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jianhuren, "jianhuren")); 
		JianhurenView jianhurenView =  jianhurenService.selectView(ew);
		return R.ok("查询监护人成功").put("data", jianhurenView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JianhurenEntity jianhuren = jianhurenService.selectById(id);
        return R.ok().put("data", jianhuren);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JianhurenEntity jianhuren = jianhurenService.selectById(id);
        return R.ok().put("data", jianhuren);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JianhurenEntity jianhuren, HttpServletRequest request){
    	jianhuren.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jianhuren);
    	JianhurenEntity u = jianhurenService.selectOne(new EntityWrapper<JianhurenEntity>().eq("jianhurenzhanghao", jianhuren.getJianhurenzhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		jianhuren.setId(new Date().getTime());
                jianhuren.setJianhurenmima(MD5Util.md5(jianhuren.getJianhurenmima())); 
        jianhurenService.insert(jianhuren);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JianhurenEntity jianhuren, HttpServletRequest request){
    	jianhuren.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jianhuren);
    	JianhurenEntity u = jianhurenService.selectOne(new EntityWrapper<JianhurenEntity>().eq("jianhurenzhanghao", jianhuren.getJianhurenzhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		jianhuren.setId(new Date().getTime());
                jianhuren.setJianhurenmima(MD5Util.md5(jianhuren.getJianhurenmima()));
        jianhurenService.insert(jianhuren);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JianhurenEntity jianhuren, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jianhuren);
	JianhurenEntity jianhurenEntity = jianhurenService.selectById(jianhuren.getId());
        if(StringUtils.isNotBlank(jianhuren.getJianhurenmima()) && !jianhuren.getJianhurenmima().equals(jianhurenEntity.getJianhurenmima())) {
                jianhuren.setJianhurenmima(MD5Util.md5(jianhuren.getJianhurenmima()));
        }
        jianhurenService.updateById(jianhuren);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jianhurenService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
