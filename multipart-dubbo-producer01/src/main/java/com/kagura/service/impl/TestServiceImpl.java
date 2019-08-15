package com.kagura.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.api.service.TestService;
import org.springframework.stereotype.Component;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/8/15 14:22
 * @since 1.0.0
 */
@Service(interfaceClass = TestService.class)
@Component
public class TestServiceImpl implements TestService {

    @Override
    public String getOne() {
        System.err.println("do getOne Method");
        return "getOne success";
    }

}
