package com.entity;


/**
 * 部门信息
 * @param no 部门编号 : A/B/C/D
 */
public class Dep {
    private Integer id;
    private String name;
    private String no;
    private Emp emp;//关联属性



    public Emp getEmp() {
        return emp;
    }

    public void setEmp(Emp emp) {
        this.emp = emp;
    }

    private String addr;

    public Dep() {}

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

    public Dep(Integer id, String name, String no, String addr) {
        this.id = id;
        this.name = name;
        this.no = no;
        this.addr = addr;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
}
