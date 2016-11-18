package com.rain.boss.data.page;

import java.util.List;

public class PaginationData {
    private int count;

    private List<?> data;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }
}
