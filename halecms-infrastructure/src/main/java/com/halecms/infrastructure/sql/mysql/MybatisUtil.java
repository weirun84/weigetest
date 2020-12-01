package com.halecms.infrastructure.sql.mysql;

import com.halecms.infrastructure.sql.mysql.entity.CtmonAd;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import org.apache.ibatis.io.Resources;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtil {
    private static SqlSessionFactory build = null;
    private static ThreadLocal<SqlSession> tl = new ThreadLocal<>();
    static {
        try {
            String resource = "/config/cmssql.xml";
            //使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
            //InputStream is = Mysqlconfig.class.getClassLoader().getResourceAsStream(resource);
            InputStream is = null;
            is = Resources.class.getResourceAsStream(resource);
            // 创建 SqlSessionFacoty 对象, 工厂类型资源
            build = new SqlSessionFactoryBuilder().build(is);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("没找到文件！");
        }
    }
    // 获取 SqlSession 对象
    private static SqlSession openSession() {
        // 如果线程中没有 SqlSession 对象，就创建一个
        SqlSession ss = tl.get();
        if (ss == null) {
            ss = build.openSession();
            tl.set(ss); // 把 SqlSession 放到线程中去
        }
        return ss;
    }
    // 获取 DAO 接口的实现类
    public static Object getMapper(Class clazz) {
        return openSession().getMapper(clazz);
    }
    // 控制事务,提交
    public static void commit() {
        openSession().commit();
        close();
    }
    // 控制事务，回滚
    public static void rollback() {
        openSession().rollback();
        close();
    }
    // 关闭资源
    public static void close() {
        openSession().close();
        tl.remove(); // 移除线程绑定
    }

}
