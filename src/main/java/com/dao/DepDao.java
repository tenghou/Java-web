package com.dao;

import com.entity.Dep;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DepDao {
    private SqlSessionFactory sqlSessionFactory;

    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public List<Dep> query(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<Dep> depList = sqlSession.selectList("depNamespace.query");
        sqlSession.close();
        return depList;

    }

    public List<Dep> querybyId(int id){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Map<String,Object> map = new LinkedHashMap<String, Object>();
        map.put("eid",id);
        List<Dep> depList = sqlSession.selectList("depNamespace.querybyid",map);
        sqlSession.close();
        return depList;

    }

    public void add(Dep dep) throws Exception{

        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.insert("depNamespace.add",dep);
        sqlSession.close();
    }

}
