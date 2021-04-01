package com.daxian.mybatis.sqlsession.proxy;

import com.daxian.mybatis.cfg.Configuration;
import com.daxian.mybatis.cfg.Mapper;
import com.daxian.mybatis.utils.Executor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Map;

//用于对方法增强，增强其实就是调用selectList方法。调用这个selectList方法需要把准备的内容准备出来，内容：拿出sql语句，映射信息
public class MapperProxy implements InvocationHandler {
    private Map<String, Mapper> mappers;//mapper里面有sql语句，怎么赋值呢，新建一个构造方法
    private Connection conn;
    public MapperProxy(Map<String,Mapper> mappers,Connection conn){
        this.mappers=mappers;
        this.conn=conn;
    }
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //1从mappers中找到mapper，mapper的key是全限定类名加上方法名，获取方法名
        String methodName=method.getName();
        //2获取方法的类的名称,找到方法声明类的名称
        String className=method.getDeclaringClass().getName();
        //3组合key
        String key=className+"."+methodName;
        //4获取mappers中的Mapper对象。
        Mapper mapper=mappers.get(key);
        //5判断是否有mapper,如果等于null就表示传的参数有问题
        if(mapper==null){
            throw new IllegalArgumentException("传入的参数有误");
        }
        //6调用工具类查询所有
        //mapper映射信息
        //没有connection需要在定义一个connection的变量
        return new Executor().selectList(mapper,conn);
    }
}
