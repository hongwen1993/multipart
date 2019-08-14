package com.kagura.config;

import org.springframework.context.annotation.Configuration;

/**
 * 测试创建自动装配
 *
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/8/14 23:55
 * @since 1.0.0
 */
@Configuration
public class WebTestAutoConfiguration {

    public WebTestAutoConfiguration() {
        System.err.println("WebTestAutoConfiguration");
    }
}
