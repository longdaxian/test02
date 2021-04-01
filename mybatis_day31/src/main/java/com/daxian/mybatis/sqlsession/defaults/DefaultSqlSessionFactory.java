package com.daxian.mybatis.sqlsession.defaults;

import com.daxian.mybatis.cfg.Configuration;
import com.daxian.mybatis.sqlsession.SqlSession;
import com.daxian.mybatis.sqlsession.SqlSessionFactory;

//SqlSessionFactory接口的实现类
public class DefaultSqlSessionFactory implements SqlSessionFactory {
    private Configuration cfg;
    public DefaultSqlSessionFactory(Configuration cfg){
        this.cfg=cfg;
    }

    //用于创建一个新的操作数据库对象
    public SqlSession openSession() {
        //工厂需要创建一个sqlsession
        /*return new DefaultSqlSession(cfg);*/
        return new DefaultSqlSession(cfg);
    }
}
