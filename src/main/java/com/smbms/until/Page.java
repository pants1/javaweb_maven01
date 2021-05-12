package com.smbms.until;

import java.util.List;

public class Page {
    private Integer currPageNo=1;//当前页码
    private  Integer pageSize=10;   //页面大小，就是每页显示多少
    private  Integer totalCount;  //记录总数
    private  Integer totalPageCount;  //总页数
    List<Object> newsList=null;

    public Page(Integer currPageNo, Integer pageSize,
                Integer totalCount, Integer totalPageCount, List<Object> newsList) {
        this.totalPageCount=totalPageCount;
        this.currPageNo = currPageNo;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.totalPageCount = totalPageCount;
        this.newsList = newsList;
    }

    public Page(Integer currPageNo, Integer pageSize, Integer totalCount) {
        this.totalPageCount=totalCount%pageSize==0?totalCount/pageSize:(totalCount/pageSize)+1;
        this.currPageNo = currPageNo;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
    }

    @Override
    public String toString() {
        return "Page{" +
                "currPageNo=" + currPageNo +
                ", pageSize=" + pageSize +
                ", totalCount=" + totalCount +
                ", totalPageCount=" + totalPageCount +
                '}';
    }

    public void setCurrPageNo(int currPageNo) {
        if(currPageNo<=0){
          currPageNo=1;
        }else if(currPageNo>=totalPageCount){
            currPageNo=totalPageCount;
        }
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public void setTotalPageCount(int totalPageCount) {

    this.totalPageCount=totalPageCount;
    }

    public int getCurrPageNo() {
        return currPageNo;
    }


    public int getPageSize() {
        return pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public int getTotalPageCount() {
        return totalPageCount;
    }

    public List<Object> getNewsList() {
        return newsList;
    }
    public void setNewsList(List<Object> newsList) {
        this.newsList = newsList;
    }
}
