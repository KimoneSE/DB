import com.htsc.dao.IUserDao;
import com.htsc.domain.QueryVo;
import com.htsc.domain.QueryVoIds;
import com.htsc.domain.User;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * created by Kimone
 * date 2020/9/2
 */
public class UserDaoCrudTest {
    private InputStream is;
    private SqlSessionFactory factory;
    private SqlSession session;
    private IUserDao userDao;

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
        userDao = session.getMapper(IUserDao.class);
    }

    @Test
    public void testFindAll() {
        List<User> users = userDao.findAll();
        for(User user:users) {
            System.out.println(user.toString());
        }
    }

    @Test
    public void testFindOne() {
        User user = userDao.findById(41);
        System.out.println(user);
        Assert.assertEquals("张三", user.getUsername());
    }

    @Test
    public void testSave(){
        User user = new User();
        user.setUsername("华泰3");
        user.setAddress("南京市建邺区");
        user.setSex("男");
        user.setBirthday(new Date());

        int id = userDao.saveUser(user);
        Assert.assertEquals(1, id);

        User savedUser = userDao.findById(user.getId());
        Assert.assertEquals("华泰3", savedUser.getUsername());
    }

    @Test
    public void testUpdateUser(){
        int id = 52;
        User user = userDao.findById(id);
        user.setAddress("南京市鼓楼区");
        int res = userDao.updateUser(user);

        User savedUser = userDao.findById(id);
        Assert.assertEquals("南京市鼓楼区",savedUser.getAddress());

        System.out.println(user.getRefAddress());
        System.out.println(savedUser.getRefAddress());
    }

    @Test
    public void testDeleteUser() {
        int res = userDao.deleteUser(54);
        Assert.assertEquals(1,res);
    }

    @Test
    public void testFindByName() {
        List<User> users = userDao.findByName("%王%");
        Assert.assertEquals(2,users.size());
        for(User user:users) {
            System.out.println(user);
        }
    }

    @Test
    public void testCount() {
        int res = userDao.count();
        Assert.assertEquals(13, res);
    }

    @Test
    public void testFindByVo() {
        QueryVo vo = new QueryVo();
        vo.setName("%王%");
        vo.setAddress("%南京%");
        List<User> users = userDao.findByVo(vo);
        Assert.assertEquals(1,users.size());
    }

    @Test
    public void testFindInIds() {
        QueryVoIds queryVoIds = new QueryVoIds();
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(41);
        ids.add(42);
        ids.add(45);
        ids.add(46);
        queryVoIds.setIds(ids);

        List<User> users = userDao.findInIds(queryVoIds);
        Assert.assertEquals(4,users.size());
    }

    @After
    public void tearDown() throws Exception {
        session.commit();
        session.close();
        is.close();
    }
}
