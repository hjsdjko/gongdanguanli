package com.controller;


import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;

import com.entity.GongdanGoutongEntity;
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

import com.entity.GongdanEntity;

import com.entity.view.GongdanView;
import com.entity.YonghuEntity;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 工单
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/gongdan")
public class GongdanController {
    private static final Logger logger = LoggerFactory.getLogger(GongdanController.class);

    @Autowired
    private GongdanService gongdanService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;



    //级联表service
    @Autowired
    private YonghuService yonghuService;
    @Autowired
    private YuangongService yuangongService;
    @Autowired
    private GongdanGoutongService gongdanGoutongService;
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
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("员工".equals(role))
            params.put("yuangongId",request.getSession().getAttribute("userId"));
        params.put("orderBy","id");
        PageUtils page = gongdanService.queryPage(params);

        //字典表数据转换
        List<GongdanView> list =(List<GongdanView>)page.getList();
        for(GongdanView c:list){
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
        GongdanEntity gongdan = gongdanService.selectById(id);
        if(gongdan !=null){
            //entity转view
            GongdanView view = new GongdanView();
            BeanUtils.copyProperties( gongdan , view );//把实体数据重构到view中

            //级联表
            YonghuEntity yonghu = yonghuService.selectById(gongdan.getYonghuId());
            if(yonghu != null){
                BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setYonghuId(yonghu.getId());
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
    public R save(@RequestBody GongdanEntity gongdan, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,gongdan:{}",this.getClass().getName(),gongdan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        else if("用户".equals(role))
            gongdan.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        Wrapper<GongdanEntity> queryWrapper = new EntityWrapper<GongdanEntity>()
            .eq("yonghu_id", gongdan.getYonghuId())
            .eq("gongdan_danhao_number", gongdan.getGongdanDanhaoNumber())
            .eq("gongdan_name", gongdan.getGongdanName())
            .eq("gongdan_types", gongdan.getGongdanTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        GongdanEntity gongdanEntity = gongdanService.selectOne(queryWrapper);
        if(gongdanEntity==null){
            gongdan.setInsertTime(new Date());
            gongdan.setCreateTime(new Date());
            gongdanService.insert(gongdan);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody GongdanEntity gongdan, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,gongdan:{}",this.getClass().getName(),gongdan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        else if("用户".equals(role))
            gongdan.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<GongdanEntity> queryWrapper = new EntityWrapper<GongdanEntity>()
            .notIn("id",gongdan.getId())
            .andNew()
            .eq("yonghu_id", gongdan.getYonghuId())
            .eq("gongdan_danhao_number", gongdan.getGongdanDanhaoNumber())
            .eq("gongdan_name", gongdan.getGongdanName())
            .eq("gongdan_types", gongdan.getGongdanTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        GongdanEntity gongdanEntity = gongdanService.selectOne(queryWrapper);
        if("".equals(gongdan.getGongdanPhoto()) || "null".equals(gongdan.getGongdanPhoto())){
                gongdan.setGongdanPhoto(null);
        }
        if(gongdanEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      gongdan.set
            //  }
            gongdanService.updateById(gongdan);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        gongdanService.deleteBatchIds(Arrays.asList(ids));

        gongdanGoutongService.delete(new EntityWrapper<GongdanGoutongEntity>().in("gongdan_id",Arrays.asList(ids)));

        gongdanShouliService.delete(new EntityWrapper<GongdanShouliEntity>().in("gongdan_id",Arrays.asList(ids)));

        return R.ok();
    }






}

