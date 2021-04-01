package com.daxian.mybatis.sqlsession.defaults;

import com.daxian.mybatis.cfg.Configuration;
import com.daxian.mybatis.sqlsession.SqlSession;
import com.daxian.mybatis.sqlsession.proxy.MapperProxy;
import com.daxian.mybatis.utils.DataSourceUtil;

import java.lang.reflect.Proxy;
import java.sql.Connection;

//Session接口的实现类
public class DefaultSqlSession implements SqlSession {
    private Configuration cfg;
    private Connection connection;
    public DefaultSqlSession(Configuration cfg){
        //创建对象的时候就给connection赋值
        this.cfg=cfg;
        this.connection= DataSourceUtil.getConnection(cfg);
    }
    //用于创建代理对象,用类加载器
    //代理谁就和谁有相同的接口，本身是一个接口了，我们new一个class数组//如何代理呢？new一个mapper
    public <T> T getMapper(Class<T> daoInterfaceClass) {
        Proxy.newProxyInstance(daoInterfaceClass.getClassLoader(),
             new Class[]{daoInterfaceClass}, new MapperProxy(cfg.getMappers(),connection));
        return null;
    }
   // MapperProxy用于对方法增强，增强其实就是调用selectList方法。调用这个selectList方法需要把准备的内容准备出来，
   // 内容：拿出sql语句，映射信息,操作:cfg.getMappers();在MapperProxy中添加private cfg;
    //用于释放资源
    public void close() {
        //上面的connection为什么单独写出来呢，因为我们要在这里进行connection的关闭方法、

        if(connection!=null){
            try {
                connection.close();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
