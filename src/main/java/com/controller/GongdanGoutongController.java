package com.controller;


import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;

import com.entity.GongdanShouliEntity;
import com.service.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;

import com.utils.StringUtil;
import java.lang.reflect.InvocationTargetException;

import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.GongdanGoutongEntity;

import com.entity.view.GongdanGoutongView;
import com.entity.GongdanEntity;
import com.entity.YuangongEntity;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 工单沟通
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/gongdanGoutong")
public class GongdanGoutongController {
    private static final Logger logger = LoggerFactory.getLogger(GongdanGoutongController.class);

    @Autowired
    private GongdanGoutongService gongdanGoutongService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;



    //级联表service
    @Autowired
    private GongdanService gongdanService;
    @Autowired
    private YuangongService yuangongService;
    @Autowired
    private YonghuService yonghuService;

    @Autowired
    private GongdanShouliService gongdanShouliService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        else if("用户".equals(role)){
            params.put("yonghuId",request.getSession().getAttribute("userId"));

            Wrapper<GongdanEntity> queryWrapper1 = new EntityWrapper<GongdanEntity>();
            queryWrapper1.eq("yonghu_id",request.getSession().getAttribute("userId"));
            List<GongdanEntity> list1 = gongdanService.selectList(queryWrapper1);
            List<Integer> ids = new ArrayList<>();
            for(GongdanEntity g: list1){
                ids.add(g.getId());
            }
            if(ids != null && ids.size()>0){
                params.put("ids",ids);
            }else{
                ids.add(0);
                params.put("ids",ids);
            }
        }
        else if("员工".equals(role)){


            Wrapper<GongdanShouliEntity> queryWrapper = new EntityWrapper<GongdanShouliEntity>();
            queryWrapper.eq("yuangong_id",request.getSession().getAttribute("userId"));
            List<GongdanShouliEntity> lists = gongdanShouliService.selectList(queryWrapper);
            List<Integer> ads = new ArrayList<>();
            for(GongdanShouliEntity g: lists){
                ads.add(g.getGongdanId());
            }
            if(ads != null && ads.size()>0){
                params.put("ads",ads);
            }


            params.put("yuangongId",request.getSession().getAttribute("userId"));
        }
        params.put("orderBy","id");
        PageUtils page = gongdanGoutongService.queryPage(params);

        //字典表数据转换
        List<GongdanGoutongView> list =(List<GongdanGoutongView>)page.getList();
        for(GongdanGoutongView c:list){
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
        GongdanGoutongEntity gongdanGoutong = gongdanGoutongService.selectById(id);
        if(gongdanGoutong !=null){
            //entity转view
            GongdanGoutongView view = new GongdanGoutongView();
            BeanUtils.copyProperties( gongdanGoutong , view );//把实体数据重构到view中

            //级联表
            GongdanEntity gongdan = gongdanService.selectById(gongdanGoutong.getGongdanId());
            if(gongdan != null){
                BeanUtils.copyProperties( gongdan , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setGongdanId(gongdan.getId());
            }
            //级联表
            YuangongEntity yuangong = yuangongService.selectById(gongdanGoutong.getYuangongId());
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
    public R save(@RequestBody GongdanGoutongEntity gongdanGoutong, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,gongdanGoutong:{}",this.getClass().getName(),gongdanGoutong.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        else if("员工".equals(role))
            gongdanGoutong.setYuangongId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        Wrapper<GongdanShouliEntity> queryWrapper = new EntityWrapper<GongdanShouliEntity>()
            .eq("gongdan_id", gongdanGoutong.getGongdanId())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        GongdanShouliEntity gongdanShouliEntity = gongdanShouliService.selectOne(queryWrapper);
        if(gongdanShouliEntity!=null){
            gongdanGoutong.setInsertTime(new Date());
            gongdanGoutong.setCreateTime(new Date());
            gongdanGoutongService.insert(gongdanGoutong);
            return R.ok();
        }else {
            return R.error(511,"工单未受理,无法沟通");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody GongdanGoutongEntity gongdanGoutong, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,gongdanGoutong:{}",this.getClass().getName(),gongdanGoutong.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        else if("员工".equals(role))
            gongdanGoutong.setYuangongId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        gongdanGoutong.setUpdateTime(new Date());
        gongdanGoutongService.updateById(gongdanGoutong);//根据id更新
        return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        gongdanGoutongService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }






}

