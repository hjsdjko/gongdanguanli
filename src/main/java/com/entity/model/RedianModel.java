package com.entity.model;

import com.entity.RedianEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 热点问题
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class RedianModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 热点问题名称
     */
    private String redianName;


    /**
     * 热点问题类型
     */
    private Integer redianTypes;


    /**
     * 热点问题详情
     */
    private String redianContent;


    /**
     * 解决方法
     */
    private String jiejueContent;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


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
	 * 获取：热点问题名称
	 */
    public String getRedianName() {
        return redianName;
    }


    /**
	 * 设置：热点问题名称
	 */
    public void setRedianName(String redianName) {
        this.redianName = redianName;
    }
    /**
	 * 获取：热点问题类型
	 */
    public Integer getRedianTypes() {
        return redianTypes;
    }


    /**
	 * 设置：热点问题类型
	 */
    public void setRedianTypes(Integer redianTypes) {
        this.redianTypes = redianTypes;
    }
    /**
	 * 获取：热点问题详情
	 */
    public String getRedianContent() {
        return redianContent;
    }


    /**
	 * 设置：热点问题详情
	 */
    public void setRedianContent(String redianContent) {
        this.redianContent = redianContent;
    }
    /**
	 * 获取：解决方法
	 */
    public String getJiejueContent() {
        return jiejueContent;
    }


    /**
	 * 设置：解决方法
	 */
    public void setJiejueContent(String jiejueContent) {
        this.jiejueContent = jiejueContent;
    }
    /**
	 * 获取：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：添加时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
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
