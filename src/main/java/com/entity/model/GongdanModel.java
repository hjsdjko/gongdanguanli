package com.entity.model;

import com.entity.GongdanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 工单
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class GongdanModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 申请人
     */
    private Integer yonghuId;


    /**
     * 工单编号
     */
    private String gongdanDanhaoNumber;


    /**
     * 工单名称
     */
    private String gongdanName;


    /**
     * 工单类型
     */
    private Integer gongdanTypes;


    /**
     * 工单图片
     */
    private String gongdanPhoto;


    /**
     * 提交时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 工单详情
     */
    private String gongdanContent;


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
	 * 获取：申请人
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：申请人
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：工单编号
	 */
    public String getGongdanDanhaoNumber() {
        return gongdanDanhaoNumber;
    }


    /**
	 * 设置：工单编号
	 */
    public void setGongdanDanhaoNumber(String gongdanDanhaoNumber) {
        this.gongdanDanhaoNumber = gongdanDanhaoNumber;
    }
    /**
	 * 获取：工单名称
	 */
    public String getGongdanName() {
        return gongdanName;
    }


    /**
	 * 设置：工单名称
	 */
    public void setGongdanName(String gongdanName) {
        this.gongdanName = gongdanName;
    }
    /**
	 * 获取：工单类型
	 */
    public Integer getGongdanTypes() {
        return gongdanTypes;
    }


    /**
	 * 设置：工单类型
	 */
    public void setGongdanTypes(Integer gongdanTypes) {
        this.gongdanTypes = gongdanTypes;
    }
    /**
	 * 获取：工单图片
	 */
    public String getGongdanPhoto() {
        return gongdanPhoto;
    }


    /**
	 * 设置：工单图片
	 */
    public void setGongdanPhoto(String gongdanPhoto) {
        this.gongdanPhoto = gongdanPhoto;
    }
    /**
	 * 获取：提交时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：提交时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：工单详情
	 */
    public String getGongdanContent() {
        return gongdanContent;
    }


    /**
	 * 设置：工单详情
	 */
    public void setGongdanContent(String gongdanContent) {
        this.gongdanContent = gongdanContent;
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
