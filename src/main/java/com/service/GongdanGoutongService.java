package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.GongdanGoutongEntity;
import java.util.Map;

/**
 * 工单沟通 服务类
 */
public interface GongdanGoutongService extends IService<GongdanGoutongEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);
}