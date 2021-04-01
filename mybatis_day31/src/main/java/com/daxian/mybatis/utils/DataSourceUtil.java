package com.daxian.mybatis.utils;

import com.daxian.mybatis.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;

//用于创建数据源的工具类
public class DataSourceUtil {
    //这个方法用于获取一个连接，写完这个类连接就有了
    public static Connection getConnection(Configuration cfg) {
    //这个方法有一个返回值，直接return回去
        try {
            Class.forName(cfg.getDriver());
           return DriverManager.getConnection(cfg.getUrl(), cfg.getUsername(), cfg.getPassword());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
