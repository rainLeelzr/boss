package com.rain.boss.util;

import java.beans.PropertyEditorSupport;
import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * 日期类型转换器，可以将表单中的日期(yyyy-MM-dd) 字符串转换成java.sql.Date。 由于Spring预置的日期转换器不完善，因此自己写
 * 了这个转换器，解决它的一些问题。
 */
public class DateEditor extends PropertyEditorSupport {

	// 默认转换的日期格式
	private String pattern = "yyyy-MM-dd";

	/**
	 * 默认构造器，将采用默认格式转换日期
	 */
	public DateEditor() {

	}

	/**
	 * 有参构造器，可以指定特殊的日期格式
	 */
	public DateEditor(String pattern) {
		this.pattern = pattern;
	}

	/*
	 * text参数就是页面传入的日期字符串。 该方法中需要将这个字符串转型成java.sql.Date， 并给对象的属性赋值。
	 */
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if (text == null || text.length() == 0) {
			// 如果日期字符串为空，则将null赋值给对象属性
			setValue(null);
		} else {
			SimpleDateFormat sf = new SimpleDateFormat(this.pattern);
			String dateStr = sf.format(Date.valueOf(text));
			// 格式化日期，将结果赋值给对象属性
			setValue(Date.valueOf(dateStr));
		}
	}

}
