package proxy;

public class ProxyTest {

    public static void main(String[] args) {
        //创建目标对象
        IUserDao userDao = new UserDao();
        System.out.println("目标对象：" + userDao.getClass());
        userDao.save();
        //创建代理对象
        IUserDao proxyUserDao = (IUserDao) new ProxyFactory(userDao).getProxyInstance();
        System.out.println("代理对象：" + proxyUserDao.getClass());
        proxyUserDao.save();
    }

}
