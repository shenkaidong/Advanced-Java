package com.antra.demo.customer.response;

import com.antra.demo.customer.pojo.Customer;

import java.util.List;

public class PageResponse {
    private int totalRows;
    private int page;
    private List<Customer> data;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public List<Customer> getData() {
        return data;
    }

    public void setData(List<Customer> data) {
        this.data = data;
    }
}
