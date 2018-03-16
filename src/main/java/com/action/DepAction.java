package com.action;

import com.dao.DepDao;
import com.entity.Dep;
import com.util.MapUtil;
import net.sf.json.JSONArray;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping(value="/dep")
public class DepAction {

//    @RequestMapping(value = "/query")
//    public @ResponseBody Map<String,Object> show() throws Exception{
//
//        ApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{"spring-mybatis.xml"});
//        DepDao depDao = (DepDao) ac.getBean("depDaoID");
//        List<Dep> depList = depDao.query();
//        MapUtil mapUtil = new MapUtil();
//        Map<String,Object> map = mapUtil.format(depList);
//
//        //返回需要转JSON文本的对象
//        return map;
//
//    }

    @RequestMapping(value = "/query")
    public @ResponseBody JSONArray show() throws Exception{

        ApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{"spring-mybatis.xml"});
        DepDao depDao = (DepDao) ac.getBean("depDaoID");
        List<Dep> depList = depDao.query();
        MapUtil mapUtil = new MapUtil();
        return mapUtil.getJsonByList(depList);

        //返回需要转JSON文本的对象

    }

    @RequestMapping(value = "/query/id/{eid}")
    public @ResponseBody Map<String,Object> queryById(@PathVariable("eid") int eid) throws Exception{

        ApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{"spring-mybatis.xml"});
        DepDao depDao = (DepDao) ac.getBean("depDaoID");
        List<Dep> depList = depDao.querybyId(eid);
        MapUtil mapUtil = new MapUtil();
        Map<String,Object> map = mapUtil.format(depList);

        //返回需要转JSON文本的对象
        return map;

    }

//    @RequestMapping(value = "/query/id/{eid}")
//    public @ResponseBody
//    JSONArray queryById(@PathVariable("eid") int eid) throws Exception{
//
//        ApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{"spring-mybatis.xml"});
//        DepDao depDao = (DepDao) ac.getBean("depDaoID");
//        List<Dep> depList = depDao.querybyId(eid);
//        MapUtil mapUtil = new MapUtil();
//        //Map<String,Object> map = mapUtil.format(depList);
//        return mapUtil.getJsonByList(depList);
//
//        //返回需要转JSON文本的对象
//        //return map;
//
//    }


}
