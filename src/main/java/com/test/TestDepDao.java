package com.test;

import com.dao.DepDao;
import com.entity.Dep;
import com.util.TimeUtil;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestDepDao {

    @Test
    public void test() throws Exception{
        ApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{"spring-mybatis.xml"});
        DepDao depDao = (DepDao) ac.getBean("depDaoID");
        depDao.add(new Dep(1,"部门A","A","春熙路"));
        depDao.add(new Dep(2,"部门B","B","解放碑"));
        depDao.add(new Dep(3,"部门C","C","三里屯"));
        depDao.add(new Dep(4,"部门D","D","新天地"));
        depDao.add(new Dep(5,"部门E","E","万象城"));
    }

    @Test
    public void testQuery() throws Exception{
        ApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{"spring-mybatis.xml"});
        DepDao depDao = (DepDao) ac.getBean("depDaoID");
        //List<Dep> depList = depDao.querybyId(5);
        List<Dep> depList = depDao.query();
        System.out.println("共有 " + depList.size() + " 条信息，如下：");
        for(Dep e : depList){
            String time = TimeUtil.TimeStamp2Date(e.getEmp().getInTime());
            System.out.println(e.getName()+":"+e.getNo()+":"+e.getEmp().getName()+":"+e.getEmp().getTel()+":"+time+":"+e.getEmp().getType());
        }
    }
}
