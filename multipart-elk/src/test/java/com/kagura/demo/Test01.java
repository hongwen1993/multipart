package com.kagura.demo;

import com.kagura.ElkApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ElkApplication.class)
public class Test01 {

    @Resource
    private RestTemplate restTemplate;

    @Test
    public void demo01 () {
        //Object object = restTemplate.getForObject("http://localhost:9200/_analyze", Object.class);
        //System.out.println(object);
        //

        Map<String, String> param = new HashMap<>();
        param.put("analyzer", "ik_max_word");
        param.put("text", "我是中国人");

        Object object = restTemplate.postForLocation("http://localhost:9200/_analyze", Object.class, param);
        System.out.println(object);
    }



}
