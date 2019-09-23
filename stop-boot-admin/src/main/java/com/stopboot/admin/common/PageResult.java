package com.stopboot.admin.common;

import com.github.pagehelper.PageInfo;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @description: 二次封装分页结果 取消不必要的展示数据
 * @author: Lianyutao
 * @create: 2019-09-20 10:16
 * @version:
 **/
@Data
public class PageResult<T> implements Serializable {
    //当前页
    private int pageNum;
    //每页的数量
    private int pageSize;
    //总记录数
    private long total;
    //总页数
    private int pages;
    //结果集
    private List<T> list;

    public PageResult() {
    }

    public PageResult(PageInfo<T> pageInfo){
        this.pageNum = pageInfo.getPageNum();
        this.pageSize = pageInfo.getPageSize();
        this.list = pageInfo.getList();
        this.pages = pageInfo.getPages();
        this.total = pageInfo.getTotal();
    }

    public void copyInfo(PageResult pageResult){
        this.pageNum = pageResult.getPageNum();
        this.pageSize = pageResult.getPageSize();
        this.pages = pageResult.getPages();
        this.total = pageResult.getTotal();
    }
}
