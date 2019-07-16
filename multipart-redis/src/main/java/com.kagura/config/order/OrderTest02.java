package com.kagura.config.order;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 优先级测试02
 *
 * @author Karas
 * @date 2019/7/16 15:38
 */
@Component
public class OrderTest02 {

    public OrderTest02() {
        System.out.println("OrderTest02");
    }
}
