package com.entity.model;

import com.entity.GongdanGoutongEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 工单沟通
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class GongdanGoutongModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 工单
     */
    private Integer gongdanId;


    /**
     * 沟通内容
     */
    private String gongdanGoutongContent;


    /**
     * 发起时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 回复人
     */
    private Integer yuangongId;


    /**
     * 回复内容
     */
    private String gongdanHuifuContent;


    /**
     * 回复时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date updateTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：工单
	 */
    public Integer getGongdanId() {
        return gongdanId;
    }


    /**
	 * 设置：工单
	 */
    public void setGongdanId(Integer gongdanId) {
        this.gongdanId = gongdanId;
    }
    /**
	 * 获取：沟通内容
	 */
    public String getGongdanGoutongContent() {
        return gongdanGoutongContent;
    }


    /**
	 * 设置：沟通内容
	 */
    public void setGongdanGoutongContent(String gongdanGoutongContent) {
        this.gongdanGoutongContent = gongdanGoutongContent;
    }
    /**
	 * 获取：发起时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：发起时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：回复人
	 */
    public Integer getYuangongId() {
        return yuangongId;
    }


    /**
	 * 设置：回复人
	 */
    public void setYuangongId(Integer yuangongId) {
        this.yuangongId = yuangongId;
    }
    /**
	 * 获取：回复内容
	 */
    public String getGongdanHuifuContent() {
        return gongdanHuifuContent;
    }


    /**
	 * 设置：回复内容
	 */
    public void setGongdanHuifuContent(String gongdanHuifuContent) {
        this.gongdanHuifuContent = gongdanHuifuContent;
    }
    /**
	 * 获取：回复时间
	 */
    public Date getUpdateTime() {
        return updateTime;
    }


    /**
	 * 设置：回复时间
	 */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
