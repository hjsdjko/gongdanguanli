package com.controller;


import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
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

import com.entity.RedianEntity;

import com.service.RedianService;
import com.entity.view.RedianView;
import com.service.YonghuService;
import com.service.YuangongService;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 热点问题
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/redian")
public class RedianController {
    private static final Logger logger = LoggerFactory.getLogger(RedianController.class);

    @Autowired
    private RedianService redianService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;



    //级联表service
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
        PageUtils page = redianService.queryPage(params);

        //字典表数据转换
        List<RedianView> list =(List<RedianView>)page.getList();
        for(RedianView c:list){
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
        RedianEntity redian = redianService.selectById(id);
        if(redian !=null){
            //entity转view
            RedianView view = new RedianView();
            BeanUtils.copyProperties( redian , view );//把实体数据重构到view中

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
    public R save(@RequestBody RedianEntity redian, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,redian:{}",this.getClass().getName(),redian.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        Wrapper<RedianEntity> queryWrapper = new EntityWrapper<RedianEntity>()
            .eq("redian_name", redian.getRedianName())
            .eq("redian_types", redian.getRedianTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        RedianEntity redianEntity = redianService.selectOne(queryWrapper);
        if(redianEntity==null){
            redian.setInsertTime(new Date());
            redian.setCreateTime(new Date());
            redianService.insert(redian);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody RedianEntity redian, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,redian:{}",this.getClass().getName(),redian.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        //根据字段查询是否有相同数据
        Wrapper<RedianEntity> queryWrapper = new EntityWrapper<RedianEntity>()
            .notIn("id",redian.getId())
            .andNew()
            .eq("redian_name", redian.getRedianName())
            .eq("redian_types", redian.getRedianTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        RedianEntity redianEntity = redianService.selectOne(queryWrapper);
        if(redianEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      redian.set
            //  }
            redianService.updateById(redian);//根据id更新
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
        redianService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }






}

