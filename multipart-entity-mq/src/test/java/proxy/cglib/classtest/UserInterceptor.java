package proxy.cglib.classtest;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/9/2 16:44
 * @since 1.0.0
 */
public class UserInterceptor implements MethodInterceptor {

    private Object object;

    public UserInterceptor(Object object) {
        this.object = object;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.err.println("cglib before");
        Object ob = methodProxy.invoke(object, objects);
        System.err.println("cglib after");
        return ob;
    }
}
