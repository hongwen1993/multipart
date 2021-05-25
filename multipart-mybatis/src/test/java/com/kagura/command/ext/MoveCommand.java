package com.kagura.command.ext;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2021/1/3
 */
public class MoveCommand implements Command {

    private int count;

    public MoveCommand(int count) {
        this.count = count;
    }

    @Override
    public void execute() {
        System.out.println("move " + count);
    }
}
