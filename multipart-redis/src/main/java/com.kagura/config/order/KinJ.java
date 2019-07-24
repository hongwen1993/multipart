package com.kagura.config.order;

import org.springframework.core.Ordered;

/**
 * KingJ
 *
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/7/24 15:13
 * @since 1.0.0
 */
public class KinJ implements Ordered {

    public KinJ() {
        System.err.println("KinJ -> 构造");
    }

    @Override
    public int getOrder() {
        return Integer.MAX_VALUE;
    }
}
