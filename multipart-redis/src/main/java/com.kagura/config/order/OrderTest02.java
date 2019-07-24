package com.kagura.config.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 优先级测试02
 *
 * @author Karas
 * @date 2019/7/16 15:38
 */
//@Component
public class OrderTest02 implements Ordered{

    public OrderTest02() {
        System.err.println("OrderTest02 -> 构造");
    }

    @Override
    public int getOrder() {
        return Integer.MIN_VALUE;
    }
}
