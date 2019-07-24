package com.kagura.desgin.适配器模式;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/7/24 15:42
 * @since 1.0.0
 */
public class SDCardImpl implements SDCard{
    @Override
    public void readSDCard() {
        System.out.println("readSDCard success");
    }
}
