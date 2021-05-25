package com.kagura.command.ext;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2021/1/3
 */
public class Demo {

    public static void main(String[] args) {
        // 移动9步
        new Request(new MoveCommand(9)).next();
        // 点击6次
        new Request(new ClickCommand(6)).next();


    }

}
