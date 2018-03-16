package com.test;

import com.dao.EmpDao;
import com.entity.Emp;
import com.util.TimeUtil;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestJudgeDao {

    @Test
    public void test() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{"spring-mybatis.xml"});
        EmpDao empDao = (EmpDao) ac.getBean("empDaoID");
        List<Emp> empList = empDao.checkTime("B");

        String nowTimeStamp = TimeUtil.getNowTimeStamp();
        int nowTime = Integer.parseInt(nowTimeStamp);
        ArrayList list = new ArrayList();
        Map<String,Object> map = new HashMap<String, Object>();
        for(Emp e : empList){
            int updateTime = Integer.parseInt(e.getUpdateTime());

            //入职超过一年
            if(nowTime - updateTime > 31536000){
                list.add(e.getId());
                System.out.println(e.getId()+":yes:"+ TimeUtil.TimeStamp2Date(e.getUpdateTime()));
                map.put("updateTime", TimeUtil.getNowTimeStamp());
                map.put("ids",list);
                int i = empDao.update(map);
                System.out.println(i + " 条数据更新成功!");
            }
        }

    }

}




















