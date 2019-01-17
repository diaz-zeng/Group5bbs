package com.soft863.group5.bbs.controller;
import java.io.Serializable;

/**
 * author zhaosl
 * date 2019/1/17 9:40
 *
 * @version 1.0
 */
public class Pagination implements Serializable{
    //当前页
    private Integer currentPage;
    //每页尺寸
    private Integer size;
    //总共多少天记录
    private Integer total;
    //总页数
    private Integer totalPage;
    //第几页
    private Integer position;
    //结束
    private Integer end;

    public Pagination(){}
    public Pagination(Integer currentPage,Integer size,Integer total){
        this.currentPage=currentPage;
        this.size=size;
        this.total=total;;
        this.position=(currentPage-1)*size+1;
        this.end=currentPage*size;
        this.totalPage=total%size==0 ? total/size : total/size+1;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Integer getEnd() {
        return end;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }
}
