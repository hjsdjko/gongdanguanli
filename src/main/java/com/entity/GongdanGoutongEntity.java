package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 工单沟通
 *
 * @author 
 * @email
 */
@TableName("gongdan_goutong")
public class GongdanGoutongEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public GongdanGoutongEntity() {

	}

	public GongdanGoutongEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 工单
     */
    @TableField(value = "gongdan_id")

    private Integer gongdanId;


    /**
     * 沟通内容
     */
    @TableField(value = "gongdan_goutong_content")

    private String gongdanGoutongContent;


    /**
     * 发起时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 回复人
     */
    @TableField(value = "yuangong_id")

    private Integer yuangongId;


    /**
     * 回复内容
     */
    @TableField(value = "gongdan_huifu_content")

    private String gongdanHuifuContent;


    /**
     * 回复时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "update_time",fill = FieldFill.UPDATE)

    private Date updateTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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
	 * 设置：工单
	 */
    public Integer getGongdanId() {
        return gongdanId;
    }


    /**
	 * 获取：工单
	 */

    public void setGongdanId(Integer gongdanId) {
        this.gongdanId = gongdanId;
    }
    /**
	 * 设置：沟通内容
	 */
    public String getGongdanGoutongContent() {
        return gongdanGoutongContent;
    }


    /**
	 * 获取：沟通内容
	 */

    public void setGongdanGoutongContent(String gongdanGoutongContent) {
        this.gongdanGoutongContent = gongdanGoutongContent;
    }
    /**
	 * 设置：发起时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：发起时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：回复人
	 */
    public Integer getYuangongId() {
        return yuangongId;
    }


    /**
	 * 获取：回复人
	 */

    public void setYuangongId(Integer yuangongId) {
        this.yuangongId = yuangongId;
    }
    /**
	 * 设置：回复内容
	 */
    public String getGongdanHuifuContent() {
        return gongdanHuifuContent;
    }


    /**
	 * 获取：回复内容
	 */

    public void setGongdanHuifuContent(String gongdanHuifuContent) {
        this.gongdanHuifuContent = gongdanHuifuContent;
    }
    /**
	 * 设置：回复时间
	 */
    public Date getUpdateTime() {
        return updateTime;
    }


    /**
	 * 获取：回复时间
	 */

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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

    @Override
    public String toString() {
        return "GongdanGoutong{" +
            "id=" + id +
            ", gongdanId=" + gongdanId +
            ", gongdanGoutongContent=" + gongdanGoutongContent +
            ", insertTime=" + insertTime +
            ", yuangongId=" + yuangongId +
            ", gongdanHuifuContent=" + gongdanHuifuContent +
            ", updateTime=" + updateTime +
            ", createTime=" + createTime +
        "}";
    }
}
