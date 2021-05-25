package com.kagura.command.ext;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2021/1/3
 */
public class Request {

    private Command command;

    public Request(Command command) {
        this.command = command;
    }

    public void next() {
        command.execute();
    }

}
