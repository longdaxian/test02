package com.daxian.dao.impl;

import com.daxian.dao.IUserDao;
import com.daxian.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.util.List;

public class IUserDaoImpl implements IUserDao {
    private SqlSessionFactory factory;
    public IUserDaoImpl(SqlSessionFactory factory){
        this.factory=factory;
    }
    public List<User> findall(){
        SqlSession session=factory.openSession();
        List<User> users=session.selectList("com.daxian.dao.IUserDao.findall");
        session.close();
        return users;
    }
}
