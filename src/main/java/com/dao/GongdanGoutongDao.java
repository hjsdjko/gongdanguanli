package com.dao;

import com.entity.GongdanGoutongEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.GongdanGoutongView;

/**
 * 工单沟通 Dao 接口
 *
 * @author 
 */
public interface GongdanGoutongDao extends BaseMapper<GongdanGoutongEntity> {

   List<GongdanGoutongView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
