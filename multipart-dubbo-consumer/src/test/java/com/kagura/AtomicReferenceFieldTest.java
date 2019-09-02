package com.kagura;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/9/2 9:46
 * @since 1.0.0
 */
public class AtomicReferenceFieldTest {

    private static class User {
        volatile String name;
    }

    public static void main(String[] args) {
        AtomicReferenceFieldUpdater<User, String> updater = AtomicReferenceFieldUpdater.newUpdater(User.class,
                String.class, "name");
        User user = new User();
        updater.compareAndSet(user, user.name, "kokodayo");
        // kokodayo
        System.err.println(user.name);
    }


    @Test
    public void test01() {
        LongAdder n = new LongAdder();
        n.add(1000L);
        System.err.println(n);
        n.increment();
        System.err.println(n);
        System.err.println();
        Mockito.any();
    }
}
