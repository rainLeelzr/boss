package com.rain.boss.data.page;

public class Page {
    public static String SORT_FIELD = "sortField";

    public static String SORT_ORDER = "sortOrder";

    // 数据库类型
    public static String db = "mysql";

    // 前端参数: 第几页
    private Integer pageIndex;

    // 前端参数: 每页记录数
    private Integer pageSize;

    // 前端参数: 排序字段
    private String sortField;

    // 前端参数: 排序方式
    private String sortOrder;

    // mysql 分页参数 limit m,n 其中m从0开始，表示第一条记录，n表示取n条记录
    private Integer from;
    private Integer count;

    // oracle 分页参数 rownum 从1开始
    private Integer start; //第一条记录从0开始
    private Integer end; //直接取最后一条记录的rownum

    //mybatis拼接的order by 排序参数
    private String order;

    public Page() {
    }

    public static String getDb() {
        return db;
    }

    /**
     * 功能：计算oracle和mysql的分页参数
     * <p>
     * void
     *
     * @author rain
     * @date 2016年9月12日
     */
    public void calculate() {
        //不填时，默认取第一页，每页10条
        pageIndex = pageIndex == null || pageIndex < 0 ? 0 : pageIndex;
        pageSize = pageSize == null || pageSize < 0 ? 10 : pageSize;

        //计算mysql 分页参数
        //第1页，每页5条-->pageIndex = 0 pageSize = 5 --> from = 0 count = 5
        //第2页，每页5条-->pageIndex = 1 pageSize = 5 --> from = 5 count = 5
        //第2页，每页10条-->pageIndex = 1 pageSize = 10 --> from = 10 count = 10
        this.from = pageIndex * pageSize;
        this.count = pageSize;

        //计算oracle 分页参数
        //第1页，每页5条-->pageIndex = 0 pageSize = 5 --> start = 0 end = 5
        //第2页，每页5条-->pageIndex = 1 pageSize = 5 --> start = 5 end = 10
        //第2页，每页10条-->pageIndex = 1 pageSize = 10 --> start = 10 end = 20
        this.start = (pageIndex) * pageSize;
        this.end = (pageIndex + 1) * pageSize;

        //拼接order by 参数
        if (sortField != null && sortField.length() != 0) {
            order = sortField;
            if (sortOrder != null && sortOrder.length() != 0) {
                order += " " + sortOrder;
            }
        }
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

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getSortField() {
        return sortField;
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Integer getEnd() {
        return end;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
