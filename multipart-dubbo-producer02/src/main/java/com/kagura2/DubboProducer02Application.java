package com.kagura2;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 测试多配置中心的配置
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/8/1 9:00
 * @since 1.0.0
 */
@SpringBootApplication
@EnableDubboConfiguration
public class DubboProducer02Application {

    public static void main(String[] args) {
        SpringApplication.run(DubboProducer02Application.class, args);
    }

}
