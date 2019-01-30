import com.amber.spring.cglib.CglibProxy;
import com.amber.spring.dao.RoomDao;
import com.amber.spring.jdkProxy.JdkProxy;
import com.amber.spring.dao.UserDao;
import com.amber.spring.dao.UserDaoImpl;
import org.junit.Test;

public class SpringDemo {

    @Test
    public void jdkProxy() {
        UserDao userDao = new UserDaoImpl();
        JdkProxy jdkProxy = new JdkProxy(userDao);
        UserDao userDaoProxy = (UserDao) jdkProxy.getUserDao();
        userDaoProxy.say();
    }

    @Test
    public void cglibProxy() {
        RoomDao roomDao = new RoomDao();
        CglibProxy cglibProxy = new CglibProxy(roomDao);
        RoomDao roomDaoProxy = (RoomDao) cglibProxy.getRoomDao();
        roomDaoProxy.save();
    }

}
