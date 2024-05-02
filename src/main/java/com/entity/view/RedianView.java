package com.entity.view;

import com.entity.RedianEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 热点问题
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("redian")
public class RedianView extends RedianEntity implements Serializable {
    private static final long serialVersionUID = 1L;
		/**
		* 热点问题类型的值
		*/
		private String redianValue;



	public RedianView() {

	}

	public RedianView(RedianEntity redianEntity) {
		try {
			BeanUtils.copyProperties(this, redianEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 热点问题类型的值
			*/
			public String getRedianValue() {
				return redianValue;
			}
			/**
			* 设置： 热点问题类型的值
			*/
			public void setRedianValue(String redianValue) {
				this.redianValue = redianValue;
			}











}
