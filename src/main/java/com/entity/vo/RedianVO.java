package com.entity.vo;

import com.entity.RedianEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 热点问题
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("redian")
public class RedianVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 热点问题名称
     */

    @TableField(value = "redian_name")
    private String redianName;


    /**
     * 热点问题类型
     */

    @TableField(value = "redian_types")
    private Integer redianTypes;


    /**
     * 热点问题详情
     */

    @TableField(value = "redian_content")
    private String redianContent;


    /**
     * 解决方法
     */

    @TableField(value = "jiejue_content")
    private String jiejueContent;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：热点问题名称
	 */
    public String getRedianName() {
        return redianName;
    }


    /**
	 * 获取：热点问题名称
	 */

    public void setRedianName(String redianName) {
        this.redianName = redianName;
    }
    /**
	 * 设置：热点问题类型
	 */
    public Integer getRedianTypes() {
        return redianTypes;
    }


    /**
	 * 获取：热点问题类型
	 */

    public void setRedianTypes(Integer redianTypes) {
        this.redianTypes = redianTypes;
    }
    /**
	 * 设置：热点问题详情
	 */
    public String getRedianContent() {
        return redianContent;
    }


    /**
	 * 获取：热点问题详情
	 */

    public void setRedianContent(String redianContent) {
        this.redianContent = redianContent;
    }
    /**
	 * 设置：解决方法
	 */
    public String getJiejueContent() {
        return jiejueContent;
    }


    /**
	 * 获取：解决方法
	 */

    public void setJiejueContent(String jiejueContent) {
        this.jiejueContent = jiejueContent;
    }
    /**
	 * 设置：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：添加时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
