package proxy.cglib;

import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EnhancerTest {

    @Test
    public void test01 () {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserImpl.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("method name : " + method.getName());
                return methodProxy.invokeSuper(o, objects);
            }
        });

        User user = (User) enhancer.create();
        user.eat();




    }

    public static void main(String[] args) {

    }

    @Test
    public void test02() {
        List<User> list = new ArrayList<>();

    }



}
