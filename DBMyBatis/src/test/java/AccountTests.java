import com.htsc.dao.IAccountDao;
import com.htsc.domain.AccountUser;
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
public class AccountTests {
    private InputStream is;
    private SqlSessionFactory factory;
    private SqlSession session;
    private IAccountDao accountDao;

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
        accountDao = session.getMapper(IAccountDao.class);
    }

    @Test
    public void testFindAll() {
        List<AccountUser> accountUsers = accountDao.findAll();
        Assert.assertEquals(3,accountUsers.size());
        for(AccountUser au: accountUsers){
            System.out.println(au);
        }
    }

    @After
    public void tearDown() throws Exception {
        session.commit();
        session.close();
        is.close();
    }
}
