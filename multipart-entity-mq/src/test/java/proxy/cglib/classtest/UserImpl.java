package proxy.cglib.classtest;


public class UserImpl implements User {

    @Override
    public void eatClass() {
        System.err.println("eatClass");
    }

    @Override
    public void playClass() {
        System.err.println("playClass");
    }
}
