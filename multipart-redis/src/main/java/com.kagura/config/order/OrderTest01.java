package com.kagura.config.order;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 优先级测试01
 *
 * @author Karas
 * @date 2019/7/16 15:37
 */
@Component
public class OrderTest01 {

    public OrderTest01() {
        System.out.println("OrderTest01");
    }
}
