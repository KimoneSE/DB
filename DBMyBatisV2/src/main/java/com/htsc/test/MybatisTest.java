package com.htsc.test;

import com.htsc.dao.IUserDao;
import com.htsc.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * created by Kimone
 * date 2020/9/2
 */
public class MybatisTest {
    public static void main(String[] args) {
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = builder.build(is);
            SqlSession session = factory.openSession();
            IUserDao userDao = session.getMapper(IUserDao.class);
            List<User> users = userDao.findAll();
            for(User user:users) {
                System.out.println(user);
            }

            session.close();
            is.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
