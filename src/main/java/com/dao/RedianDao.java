package com.dao;

import com.entity.RedianEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.RedianView;

/**
 * 热点问题 Dao 接口
 *
 * @author 
 */
public interface RedianDao extends BaseMapper<RedianEntity> {

   List<RedianView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
