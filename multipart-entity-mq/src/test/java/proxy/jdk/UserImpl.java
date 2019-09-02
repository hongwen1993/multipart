package proxy.jdk;

public class UserImpl implements User {
    @Override
    public void eat() {
        System.out.println("jdk user eat");
    }

    @Override
    public void play() {
        System.out.println("jdk user play");
    }
}
