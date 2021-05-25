package com.kagura.command.func;

import java.util.function.Function;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2021/1/3
 */
public class Command {

    static class Request {

        private Function<Integer, Integer> func;
        private int number;

        public Request(Function<Integer, Integer> func, int number) {
            this.func = func;
            this.number = number;
        }

        void handle() {
            // print
            System.out.println(func.apply(number));
            // do something......

        }

    }

    public static void main(String... args) {
        new Request(n -> n + 10, 90).handle();
        new Request(n -> n - 10, 90).handle();
    }


}
