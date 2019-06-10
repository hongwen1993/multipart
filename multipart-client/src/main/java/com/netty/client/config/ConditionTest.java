package com.netty.client.config;

import com.netty.client.example.spi.SPIServiceImpl01;
import org.springframework.context.annotation.*;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotatedTypeMetadata;

@Configuration
public class ConditionTest {

    // 只有Test.class中的matches方法返回true时才会实例化该Bean
    @Bean("sPIServiceImpl01")
    @Conditional(Test.class)
    public SPIServiceImpl01 sPIServiceImpl01() {
        System.out.println(7890);
        return new SPIServiceImpl01("6666666");
    }

    // 自定义Conditional规则, 判断b.txt是否存在
    static class Test implements Condition {
        @Override
        public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
            ResourceLoader resourceLoader = conditionContext.getResourceLoader();
            Resource resource = resourceLoader.getResource("b.txt");
            System.out.println(123456);
            return resource.exists();
        }
    }

}
