package com.kagura.command.ext;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2021/1/3
 */
public class ClickCommand implements Command {

    private int n;

    public ClickCommand(int n) {
        this.n = n;
    }

    @Override
    public void execute() {
        System.out.println("click " + n);
    }
}
