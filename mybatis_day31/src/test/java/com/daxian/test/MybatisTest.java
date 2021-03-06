package com.daxian.test;
import com.daxian.dao.IUserDao;
import com.daxian.domain.User;

import com.daxian.mybatis.io.Resources;
import com.daxian.mybatis.sqlsession.SqlSession;
import com.daxian.mybatis.sqlsession.SqlSessionFactory;
import com.daxian.mybatis.sqlsession.SqlSessionFactoryBuilder;
import java.io.InputStream;
import java.util.List;
public class MybatisTest{
    public static void main(String[] args) throws Exception{
        InputStream in= Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        SqlSessionFactory factory=builder.build(in);
        SqlSession session=factory.openSession();
        IUserDao userDao=session.getMapper(IUserDao.class);
        List<User> users=userDao.findall();
        for (User user:users)
        {
            System.out.println(user);
        }
        session.close();
        in.close();
    }
}
