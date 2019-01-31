package proxy;

public class UserDao implements IUserDao {

    @Override
    public void save() {
        System.out.println("save...");
    }

    @Override
    public void select() {
        System.out.println("select...");
    }
}
