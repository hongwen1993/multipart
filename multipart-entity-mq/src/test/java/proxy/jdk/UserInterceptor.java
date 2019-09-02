package proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/9/2 16:09
 * @since 1.0.0
 */
public class UserInterceptor implements InvocationHandler {

    private Object object;

    public UserInterceptor(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.err.println("jdk before");
        Object o = method.invoke(object, args);
        System.err.println("jdk after");
        return o;
    }
}
