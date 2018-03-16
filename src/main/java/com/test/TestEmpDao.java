package com.test;

import com.dao.EmpDao;
import com.entity.Emp;
import org.junit.Test;
import com.util.TimeUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestEmpDao {

    @Test
    public void testAdd() throws Exception{

        ApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{"spring-mybatis.xml"});
        EmpDao empDao = (EmpDao) ac.getBean("empDaoID");
        String time = TimeUtil.Date2TimeStamp("2015-01-01 12:12:12");
        empDao.add(new Emp(1,"jason","001","1300",time,1,time,"A"));
        empDao.add(new Emp(2,"kangkang","002","1300",time,1,time,"A"));
        empDao.add(new Emp(3,"luis","003","1300",time,2,time,"B"));
        empDao.add(new Emp(4,"hugh","004","1300",time,3,time,"B"));
        empDao.add(new Emp(5,"messi","005","1300",time,4,time,"C"));
        empDao.add(new Emp(6,"David","006","1300",time,5,time,"D"));
        empDao.add(new Emp(7,"Tomas","007","1300",time,6,time,"E"));

    }

}




















