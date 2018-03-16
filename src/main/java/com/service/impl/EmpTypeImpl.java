package com.service.impl;

import com.dao.EmpDao;
import com.entity.Emp;
import com.service.EmpType;
import com.util.TimeUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmpTypeImpl implements EmpType {


    public Integer updateEmpType(int updatePeriod, String type) {
        int updateRows = 0;
        ApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{"spring-mybatis.xml"});
        EmpDao empDao = (EmpDao) ac.getBean("empDaoID");
        List<Emp> empList = null;
        try {
            empList = empDao.checkTime(type);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String nowTimeStamp = TimeUtil.getNowTimeStamp();
        int nowTime = Integer.parseInt(nowTimeStamp);
        ArrayList list = new ArrayList();
        Map<String,Object> map = new HashMap<String, Object>();
        for(Emp e : empList){
            int updateTime = Integer.parseInt(e.getUpdateTime());

            //入职超过一年
            if(nowTime - updateTime > updatePeriod){
                list.add(e.getId());
                map.put("updateTime", TimeUtil.getNowTimeStamp());
                map.put("ids",list);
                updateRows = empDao.update(map);
                System.out.println(updateRows + " 条数据更新成功!");
            }
        }
        return updateRows;
    }
}
