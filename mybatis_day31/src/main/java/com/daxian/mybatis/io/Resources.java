
package com.daxian.mybatis.io;

        import java.io.InputStream;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * 使用类加载器读取配置文件的类
 */
public class Resources {

    /**
     * 根据传入的参数，获取一个字节输入流
     * @param filePath
     * @return
     */
    //读取配置文件用到io中的Resources类，读出来这个流就是找到了我们要的这些信息交给了构建者SqlsessionFactoryBuilder，
    // 构建者使用工具类给我们构建了一个工厂对象，工厂对象里面的openSession给我们提供了一个session方法，
    // 接下来我们要干的是在session方法里面实现创建代理对象和查询所有的操作，
    public static InputStream getResourceAsStream(String filePath){
        return Resources.class.getClassLoader().getResourceAsStream(filePath);
    }
}
