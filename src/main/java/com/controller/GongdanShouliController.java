package com.controller;


import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;

import com.entity.YuangongEntity;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.StringUtil;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.GongdanShouliEntity;

import com.service.GongdanShouliService;
import com.entity.view.GongdanShouliView;
import com.service.GongdanService;
import com.entity.GongdanEntity;
import com.service.YonghuService;
import com.service.YuangongService;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 工单受理
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/gongdanShouli")
public class GongdanShouliController {
    private static final Logger logger = LoggerFactory.getLogger(GongdanShouliController.class);

    @Autowired
    private GongdanShouliService gongdanShouliService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;



    //级联表service
    @Autowired
    private GongdanService gongdanService;
    @Autowired
    private YonghuService yonghuService;
    @Autowired
    private YuangongService yuangongService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("员工".equals(role))
            params.put("yuangongId",request.getSession().getAttribute("userId"));
        params.put("orderBy","id");
        PageUtils page = gongdanShouliService.queryPage(params);

        //字典表数据转换
        List<GongdanShouliView> list =(List<GongdanShouliView>)page.getList();
        for(GongdanShouliView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        GongdanShouliEntity gongdanShouli = gongdanShouliService.selectById(id);
        if(gongdanShouli !=null){
            //entity转view
            GongdanShouliView view = new GongdanShouliView();
            BeanUtils.copyProperties( gongdanShouli , view );//把实体数据重构到view中

            //级联表
            GongdanEntity gongdan = gongdanService.selectById(gongdanShouli.getGongdanId());
            if(gongdan != null){
                BeanUtils.copyProperties( gongdan , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setGongdanId(gongdan.getId());
            }
            //级联表
            YuangongEntity yuangong = yuangongService.selectById(gongdanShouli.getYuangongId());
            if(yuangong != null){
                BeanUtils.copyProperties( yuangong , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setYuangongId(yuangong.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody GongdanShouliEntity gongdanShouli, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,gongdanShouli:{}",this.getClass().getName(),gongdanShouli.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        else if("员工".equals(role))
            gongdanShouli.setYuangongId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        Wrapper<GongdanShouliEntity> queryWrapper = new EntityWrapper<GongdanShouliEntity>()
            .eq("gongdan_id", gongdanShouli.getGongdanId())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        GongdanShouliEntity gongdanShouliEntity = gongdanShouliService.selectOne(queryWrapper);
        if(gongdanShouliEntity==null){
            gongdanShouli.setInsertTime(new Date());
            gongdanShouli.setCreateTime(new Date());
            gongdanShouli.setGongdanShenheTypes(1);
            gongdanShouliService.insert(gongdanShouli);
            return R.ok();
        }else {
            return R.error(511,"该工单已被受理");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody GongdanShouliEntity gongdanShouli, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,gongdanShouli:{}",this.getClass().getName(),gongdanShouli.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        //根据字段查询是否有相同数据
        Wrapper<GongdanShouliEntity> queryWrapper = new EntityWrapper<GongdanShouliEntity>()
            .notIn("id",gongdanShouli.getId())
            .andNew()
            .eq("gongdan_id", gongdanShouli.getGongdanId())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        GongdanShouliEntity gongdanShouliEntity = gongdanShouliService.selectOne(queryWrapper);
        if(gongdanShouliEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      gongdanShouli.set
            //  }
            gongdanShouliService.updateById(gongdanShouli);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"工单已被受理");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        gongdanShouliService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }






}

