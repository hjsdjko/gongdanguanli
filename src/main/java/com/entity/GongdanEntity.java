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
 * 工单
 *
 * @author 
 * @email
 */
@TableName("gongdan")
public class GongdanEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public GongdanEntity() {

	}

	public GongdanEntity(T t) {
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
     * 申请人
     */
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 工单编号
     */
    @TableField(value = "gongdan_danhao_number")

    private String gongdanDanhaoNumber;


    /**
     * 工单名称
     */
    @TableField(value = "gongdan_name")

    private String gongdanName;


    /**
     * 工单类型
     */
    @TableField(value = "gongdan_types")

    private Integer gongdanTypes;


    /**
     * 工单图片
     */
    @TableField(value = "gongdan_photo")

    private String gongdanPhoto;


    /**
     * 提交时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 工单详情
     */
    @TableField(value = "gongdan_content")

    private String gongdanContent;


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
	 * 设置：申请人
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：申请人
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：工单编号
	 */
    public String getGongdanDanhaoNumber() {
        return gongdanDanhaoNumber;
    }


    /**
	 * 获取：工单编号
	 */

    public void setGongdanDanhaoNumber(String gongdanDanhaoNumber) {
        this.gongdanDanhaoNumber = gongdanDanhaoNumber;
    }
    /**
	 * 设置：工单名称
	 */
    public String getGongdanName() {
        return gongdanName;
    }


    /**
	 * 获取：工单名称
	 */

    public void setGongdanName(String gongdanName) {
        this.gongdanName = gongdanName;
    }
    /**
	 * 设置：工单类型
	 */
    public Integer getGongdanTypes() {
        return gongdanTypes;
    }


    /**
	 * 获取：工单类型
	 */

    public void setGongdanTypes(Integer gongdanTypes) {
        this.gongdanTypes = gongdanTypes;
    }
    /**
	 * 设置：工单图片
	 */
    public String getGongdanPhoto() {
        return gongdanPhoto;
    }


    /**
	 * 获取：工单图片
	 */

    public void setGongdanPhoto(String gongdanPhoto) {
        this.gongdanPhoto = gongdanPhoto;
    }
    /**
	 * 设置：提交时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：提交时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：工单详情
	 */
    public String getGongdanContent() {
        return gongdanContent;
    }


    /**
	 * 获取：工单详情
	 */

    public void setGongdanContent(String gongdanContent) {
        this.gongdanContent = gongdanContent;
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
        return "Gongdan{" +
            "id=" + id +
            ", yonghuId=" + yonghuId +
            ", gongdanDanhaoNumber=" + gongdanDanhaoNumber +
            ", gongdanName=" + gongdanName +
            ", gongdanTypes=" + gongdanTypes +
            ", gongdanPhoto=" + gongdanPhoto +
            ", insertTime=" + insertTime +
            ", gongdanContent=" + gongdanContent +
            ", createTime=" + createTime +
        "}";
    }
}
