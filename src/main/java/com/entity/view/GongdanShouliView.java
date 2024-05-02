package com.entity.view;

import com.entity.GongdanShouliEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 工单受理
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("gongdan_shouli")
public class GongdanShouliView extends GongdanShouliEntity implements Serializable {
    private static final long serialVersionUID = 1L;
		/**
		* 工单状态的值
		*/
		private String gongdanShenheValue;



		//级联表 gongdan
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
				* 工单类型的值
				*/
				private String gongdanValue;
			/**
			* 工单图片
			*/
			private String gongdanPhoto;
			@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
			@DateTimeFormat
			/**
			* 提交时间
			*/
			private Date insertTime;
			/**
			* 工单详情
			*/
			private String gongdanContent;

		//级联表 yuangong
			/**
			* 员工姓名
			*/
			private String yuangongName;
			/**
			* 员工手机号
			*/
			private String yuangongPhone;
			/**
			* 员工身份证号
			*/
			private String yuangongIdNumber;
			/**
			* 员工照片
			*/
			private String yuangongPhoto;

	public GongdanShouliView() {

	}

	public GongdanShouliView(GongdanShouliEntity gongdanShouliEntity) {
		try {
			BeanUtils.copyProperties(this, gongdanShouliEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 工单状态的值
			*/
			public String getGongdanShenheValue() {
				return gongdanShenheValue;
			}
			/**
			* 设置： 工单状态的值
			*/
			public void setGongdanShenheValue(String gongdanShenheValue) {
				this.gongdanShenheValue = gongdanShenheValue;
			}







				//级联表的get和set gongdan
					/**
					* 获取： 申请人
					*/
					public Integer getYonghuId() {
						return yonghuId;
					}
					/**
					* 设置： 申请人
					*/
					public void setYonghuId(Integer yonghuId) {
						this.yonghuId = yonghuId;
					}
					/**
					* 获取： 工单编号
					*/
					public String getGongdanDanhaoNumber() {
						return gongdanDanhaoNumber;
					}
					/**
					* 设置： 工单编号
					*/
					public void setGongdanDanhaoNumber(String gongdanDanhaoNumber) {
						this.gongdanDanhaoNumber = gongdanDanhaoNumber;
					}
					/**
					* 获取： 工单名称
					*/
					public String getGongdanName() {
						return gongdanName;
					}
					/**
					* 设置： 工单名称
					*/
					public void setGongdanName(String gongdanName) {
						this.gongdanName = gongdanName;
					}
					/**
					* 获取： 工单类型
					*/
					public Integer getGongdanTypes() {
						return gongdanTypes;
					}
					/**
					* 设置： 工单类型
					*/
					public void setGongdanTypes(Integer gongdanTypes) {
						this.gongdanTypes = gongdanTypes;
					}


						/**
						* 获取： 工单类型的值
						*/
						public String getGongdanValue() {
							return gongdanValue;
						}
						/**
						* 设置： 工单类型的值
						*/
						public void setGongdanValue(String gongdanValue) {
							this.gongdanValue = gongdanValue;
						}
					/**
					* 获取： 工单图片
					*/
					public String getGongdanPhoto() {
						return gongdanPhoto;
					}
					/**
					* 设置： 工单图片
					*/
					public void setGongdanPhoto(String gongdanPhoto) {
						this.gongdanPhoto = gongdanPhoto;
					}
					/**
					* 获取： 提交时间
					*/
					public Date getInsertTime() {
						return insertTime;
					}
					/**
					* 设置： 提交时间
					*/
					public void setInsertTime(Date insertTime) {
						this.insertTime = insertTime;
					}
					/**
					* 获取： 工单详情
					*/
					public String getGongdanContent() {
						return gongdanContent;
					}
					/**
					* 设置： 工单详情
					*/
					public void setGongdanContent(String gongdanContent) {
						this.gongdanContent = gongdanContent;
					}



















				//级联表的get和set yuangong
					/**
					* 获取： 员工姓名
					*/
					public String getYuangongName() {
						return yuangongName;
					}
					/**
					* 设置： 员工姓名
					*/
					public void setYuangongName(String yuangongName) {
						this.yuangongName = yuangongName;
					}
					/**
					* 获取： 员工手机号
					*/
					public String getYuangongPhone() {
						return yuangongPhone;
					}
					/**
					* 设置： 员工手机号
					*/
					public void setYuangongPhone(String yuangongPhone) {
						this.yuangongPhone = yuangongPhone;
					}
					/**
					* 获取： 员工身份证号
					*/
					public String getYuangongIdNumber() {
						return yuangongIdNumber;
					}
					/**
					* 设置： 员工身份证号
					*/
					public void setYuangongIdNumber(String yuangongIdNumber) {
						this.yuangongIdNumber = yuangongIdNumber;
					}
					/**
					* 获取： 员工照片
					*/
					public String getYuangongPhoto() {
						return yuangongPhoto;
					}
					/**
					* 设置： 员工照片
					*/
					public void setYuangongPhoto(String yuangongPhoto) {
						this.yuangongPhoto = yuangongPhoto;
					}



}
