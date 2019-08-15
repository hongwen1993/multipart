package com.kagura2.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.kagura2.service.FoodService;
import org.springframework.stereotype.Component;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/8/15 13:28
 * @since 1.0.0
 */
@Service(interfaceClass = FoodService.class)
@Component
public class FoodServiceImpl implements FoodService {

    @Override
    public String saveFood(Long id) {
        System.err.println("save food success");
        return "save food ok";
    }

}
