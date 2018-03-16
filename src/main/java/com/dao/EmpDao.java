package com.dao;

import com.entity.Emp;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import java.util.List;
import java.util.Map;

public class EmpDao {
    private SqlSessionFactory sqlSessionFactory;

    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }


    public void add(Emp emp) throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.insert("empNamespace.add",emp);
        sqlSession.close();
    }

    public List<Emp> query() throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<Emp> empList = sqlSession.selectList("empNamespace.query");
        sqlSession.close();
        return empList;
    }


    public int update(Map<String,Object> map){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int res = sqlSession.update("empNamespace.updateBatch",map);
        sqlSession.close();
        return res;
    }

    public List<Emp> checkTime(String dno) throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<Emp> empList = sqlSession.selectList("empNamespace.checkTime",dno);
        sqlSession.close();
        return empList;

    }

}
