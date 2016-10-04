package com.rain.boss.util;

public class Page {
	public static String SORTFIELD = "sort";

	public static String SORTORDER = "order";

	// 数据库类型
	public static String db = "mysql";

	// 前端参数: 第几页
	private Integer page;

	// 前端参数: 每页记录数
	private Integer rows;

	// sql 排序参数，包含排序字段、排序方式
	private String order;

	// mysql 分页参数 limit m,n 其中m从0开始，表示第一条记录，n表示取n条记录
	private Integer from;
	private Integer count;

	// oracle 分页参数 rownum 从1开始
	private Integer start; //第一条记录从0开始
	private Integer end; //直接取最后一条记录的rownum

	@SuppressWarnings("unused")
	private Page() {
	}

	public Page(int page, int rows) {
		this.page = page;
		this.rows = rows;

		init();
	}

	public Page(int page, int rows, String order) {
		this.page = page;
		this.rows = rows;
		this.order = order;

		init();
	}

	/**
	 * 功能：计算oracle和mysql的分页参数
	 * 
	 * void
	 * 
	 * @author rain
	 * @date 2016年9月12日
	 */
	private void init() {
		this.from = (page - 1) * rows;
		this.count = rows;

		//第1页，每页5条-->from = 0 end = 6
		//第2页，每页5条-->from = 5 end = 11
		this.start = rows * (page - 1);
		this.end = page * rows + 1;
	}

	public static String getDb() {
		return db;
	}

	public String getOrder() {
		return order;
	}

	public Integer getFrom() {
		return from;
	}

	public Integer getCount() {
		return count;
	}

	public Integer getStart() {
		return start;
	}

	public Integer getEnd() {
		return end;
	}
}
