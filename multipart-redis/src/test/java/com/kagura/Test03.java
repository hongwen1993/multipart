package com.kagura;

import com.kagura.annotation.PushListener;
import com.kagura.utils.SpringContextUtils;
import org.apache.commons.lang.ArrayUtils;
import org.junit.Test;
import org.junit.runner.FilterFactory;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Test03 {

    @Test
    public void test01() {
        Map<String, Object> map = SpringContextUtils.getApplicationContext()
                .getBeansWithAnnotation(PushListener.class);
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }


    @Test
    public void test02() {

    }


}

