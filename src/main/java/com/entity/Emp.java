package com.entity;

import java.util.List;

/**
 * 员工信息
 * @param einTime 入职时间 时间戳
 * @param updateTime 职级更新时间 时间戳
 */
public class Emp {
    private Integer id;
    private String name;
    private String no;
    private String tel;
    private String inTime;
    private Integer type;
    private String updateTime;
    private String dno;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public Emp(Integer id, String name, String no, String tel, String inTime, Integer type, String updateTime, String dno) {

        this.id = id;
        this.name = name;
        this.no = no;
        this.tel = tel;
        this.inTime = inTime;
        this.type = type;
        this.updateTime = updateTime;
        this.dno = dno;
    }

    private List<Dep> depList;

    public List<Dep> getDepList() {
        return depList;
    }

    public void setDepList(List<Dep> depList) {
        this.depList = depList;
    }



    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public Emp(){}

    public String getDno() {
        return dno;
    }

    public void setDno(String dno) {
        this.dno = dno;
    }


    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getInTime() {
        return inTime;
    }

    public void setInTime(String inTime) {
        this.inTime = inTime;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
