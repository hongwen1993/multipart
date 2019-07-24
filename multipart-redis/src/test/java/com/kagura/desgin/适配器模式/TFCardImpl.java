package com.kagura.desgin.适配器模式;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/7/24 15:47
 * @since 1.0.0
 */
public class TFCardImpl implements TFCard{

    @Override
    public void readTFCard() {
        System.out.println("readTFCard success");
    }
}
