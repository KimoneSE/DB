import com.htsc.dao.IRoleDao;
import com.htsc.domain.Role;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * created by Kimone
 * date 2020/9/2
 */
public class RoleTest {
    private InputStream is;
    private SqlSessionFactory factory;
    private SqlSession session;
    private IRoleDao roleDao;

    @Before
    public void setUp() throws IOException {
        // 1.读取配置文件
        is = Resources.getResourceAsStream("mybatis-config.xml");
        // 2.创建构造者对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        // 3.创建SqlSession工厂对象
        factory = builder.build(is);
        // 4.创建SqlSession对象
        session = factory.openSession();
        // 5.创建Dao的代理对象
        roleDao = session.getMapper(IRoleDao.class);
    }

    @Test
    public void testFindAll() {
        List<Role> roles = roleDao.findAll();
        Assert.assertEquals(3,roles.size());
        for(Role role:roles) {
            System.out.println("每个角色的信息");
            System.out.println(role);
            System.out.println(role.getUsers());
        }
    }

    @After
    public void tearDown() throws Exception {
        session.commit();
        session.close();
        is.close();
    }
}
