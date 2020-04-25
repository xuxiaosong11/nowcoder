package com.example.nowcoder.entiy;

/**
 * @author admin
 * @ClassName Page.java
 * @Description 封装分页相关的信息
 * @createTime 2020年04月25日 13:51:00
 */

public class Page {

    private int current=1;
    private int limit=10;
    private int rows;
    private String path;

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        if (current>=1) {
            this.current = current;
        }
        }


    public int getLimit() {

        return limit;
    }

    public void setLimit(int limit) {
        if (limit>=1 && limit<=100) {
            this.limit = limit;
        }
    }


    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        if (rows>=0) {
            this.rows = rows;
        }
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    /**
     * @title
     * @description 获取当前页的第一个数
     * @author admin No such property: code for class: Script1
     * @updateTime 2020/4/25
     */
    public int getOffset() {
         return (current-1)*limit;
    }
    /**
     * @title
     * @description 获取总的页数
     * @author admin No such property: code for class: Script1
     * @updateTime 2020/4/25
     */
    public int getTotal() {
        if (rows % limit==0) {
            return rows/limit;
        }else {
            return rows/limit +1;
        }
    }
   /**
    * @title
    * @description 获取起始页
    * @author admin No such property: code for class: Script1
    * @updateTime 2020/4/25
    */
    public int getFrom() {
        int from =current-2;
        return from<1?1:from;
    }

     /**
      * @title
      * @description  获取尾页
      * @author admin No such property: code for class: Script1
      * @updateTime 2020/4/25
      */
    public int getTo() {
        int to=current+2;
        int total=getTotal();
        return to>total?total:to;
    }

}
