package kagura;

import org.junit.Test;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/8/27 11:57
 * @since 1.0.0
 */
public class Test02 {

    @Test
    public void test01() {
        byte[] bytes = "a".getBytes();
        // 1
        System.err.println(bytes.length);
        bytes = "我".getBytes();
        // 3
        System.err.println(bytes.length);
    }
}
