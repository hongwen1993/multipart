package proxy.jdk;

import java.lang.reflect.Proxy;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/9/2 16:13
 * @since 1.0.0
 */
public class Main {

    public static void main(String[] args) {

        User user = (User) Proxy.newProxyInstance(User.class.getClassLoader(), User.class.getInterfaces(),
                new UserInterceptor(new UserImpl()));
        user.eat();
    }

}
