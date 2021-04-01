package com.daxian.mybatis.sqlsession;

import com.daxian.mybatis.cfg.Configuration;
import com.daxian.mybatis.sqlsession.defaults.DefaultSqlSessionFactory;
import com.daxian.mybatis.utils.XMLConfigBuilder;

import java.io.InputStream;
//根据参数输入的字节流构建一个SqlSessionFactory工厂
public class SqlSessionFactoryBuilder {
    public DefaultSqlSessionFactory build(InputStream config){
        Configuration cfg= XMLConfigBuilder.loadConfiguration(config);
        //有了config还是没有工厂。这时候需要创建他的实现类default.DefaultSqlSesionFactory
        return new DefaultSqlSessionFactory(cfg);

    }
}