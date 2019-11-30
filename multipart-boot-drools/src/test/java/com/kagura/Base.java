package com.kagura;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/11/30
 * @since 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Base {

    @Before
    public void before() throws InterruptedException {
        Thread.sleep(1000);
    }
}
