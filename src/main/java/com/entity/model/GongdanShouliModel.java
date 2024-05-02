package com.entity.model;

import com.entity.GongdanShouliEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 工单受理
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class GongdanShouliModel implements Serializable {
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
     * 员工
     */
    private Integer yuangongId;


    /**
     * 受理时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 工单状态
     */
    private Integer gongdanShenheTypes;


    /**
     * 工单审核详情
     */
    private String gongdanShouliContent;


    /**
     * 工单评价
     */
    private String gongdanPingjiaContent;


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
	 * 获取：员工
	 */
    public Integer getYuangongId() {
        return yuangongId;
    }


    /**
	 * 设置：员工
	 */
    public void setYuangongId(Integer yuangongId) {
        this.yuangongId = yuangongId;
    }
    /**
	 * 获取：受理时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：受理时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：工单状态
	 */
    public Integer getGongdanShenheTypes() {
        return gongdanShenheTypes;
    }


    /**
	 * 设置：工单状态
	 */
    public void setGongdanShenheTypes(Integer gongdanShenheTypes) {
        this.gongdanShenheTypes = gongdanShenheTypes;
    }
    /**
	 * 获取：工单审核详情
	 */
    public String getGongdanShouliContent() {
        return gongdanShouliContent;
    }


    /**
	 * 设置：工单审核详情
	 */
    public void setGongdanShouliContent(String gongdanShouliContent) {
        this.gongdanShouliContent = gongdanShouliContent;
    }
    /**
	 * 获取：工单评价
	 */
    public String getGongdanPingjiaContent() {
        return gongdanPingjiaContent;
    }


    /**
	 * 设置：工单评价
	 */
    public void setGongdanPingjiaContent(String gongdanPingjiaContent) {
        this.gongdanPingjiaContent = gongdanPingjiaContent;
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
