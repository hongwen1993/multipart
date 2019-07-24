package com.kagura.config.order;

import org.springframework.beans.factory.annotation.Autowired;
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
public class OrderTest01 implements Ordered{

    public OrderTest01() {
        System.err.println("OrderTest01");
    }

    @Override
    public int getOrder() {
        return Integer.MAX_VALUE;
    }
}
