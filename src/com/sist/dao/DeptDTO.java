package com.sist.dao;

/**
 * Created by sist on 2016-03-07.
 * CREATE TABLE MY_TABLE (
     DEPTNO NUMBER,
     DNAME VARCHAR2,
     LOC VARCHAR2
     );
 *
 */
public class DeptDTO {
    private int deptno;
    private String dname;
    private String loc;

    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }
}
