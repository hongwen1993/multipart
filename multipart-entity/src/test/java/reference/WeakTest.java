package reference;

import org.junit.Test;

import java.lang.ref.WeakReference;

public class WeakTest {

    @Test
    public void test01() {
        String name = new String("hhh");
        WeakReference<String> weak = new WeakReference<>(name);
        // hhh
        System.out.println(weak.get());
        name = new String("www");
        // hhh
        System.out.println(weak.get());
        System.gc();
        // null
        System.out.println(weak.get());
    }

    @Test
    public void test02() {
        String name = "hhh";
        WeakReference<String> weak = new WeakReference<>(name);
        // hhh
        System.out.println(weak.get());
        name = "www";
        // hhh
        System.out.println(weak.get());
        System.gc();
        // hhh
        System.out.println(weak.get());
    }

}
