package proxy.cglib;

public class UserImpl extends User {
    @Override
    public void eat() {
        System.out.println("UserImpl eat ");
    }

    @Override
    public void play() {
        System.out.println("UserImpl play ");
    }
}
