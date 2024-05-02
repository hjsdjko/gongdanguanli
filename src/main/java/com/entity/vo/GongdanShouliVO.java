package com.entity.vo;

import com.entity.GongdanShouliEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 工单受理
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("gongdan_shouli")
public class GongdanShouliVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 工单
     */

    @TableField(value = "gongdan_id")
    private Integer gongdanId;


    /**
     * 员工
     */

    @TableField(value = "yuangong_id")
    private Integer yuangongId;


    /**
     * 受理时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 工单状态
     */

    @TableField(value = "gongdan_shenhe_types")
    private Integer gongdanShenheTypes;


    /**
     * 工单审核详情
     */

    @TableField(value = "gongdan_shouli_content")
    private String gongdanShouliContent;


    /**
     * 工单评价
     */

    @TableField(value = "gongdan_pingjia_content")
    private String gongdanPingjiaContent;


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
	 * 设置：员工
	 */
    public Integer getYuangongId() {
        return yuangongId;
    }


    /**
	 * 获取：员工
	 */

    public void setYuangongId(Integer yuangongId) {
        this.yuangongId = yuangongId;
    }
    /**
	 * 设置：受理时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：受理时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：工单状态
	 */
    public Integer getGongdanShenheTypes() {
        return gongdanShenheTypes;
    }


    /**
	 * 获取：工单状态
	 */

    public void setGongdanShenheTypes(Integer gongdanShenheTypes) {
        this.gongdanShenheTypes = gongdanShenheTypes;
    }
    /**
	 * 设置：工单审核详情
	 */
    public String getGongdanShouliContent() {
        return gongdanShouliContent;
    }


    /**
	 * 获取：工单审核详情
	 */

    public void setGongdanShouliContent(String gongdanShouliContent) {
        this.gongdanShouliContent = gongdanShouliContent;
    }
    /**
	 * 设置：工单评价
	 */
    public String getGongdanPingjiaContent() {
        return gongdanPingjiaContent;
    }


    /**
	 * 获取：工单评价
	 */

    public void setGongdanPingjiaContent(String gongdanPingjiaContent) {
        this.gongdanPingjiaContent = gongdanPingjiaContent;
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
