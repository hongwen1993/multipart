package com.kagura.service;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/8/12 17:59
 * @since 1.0.0
 */
public class TestHystrixCommand extends HystrixCommand<String> {

    public TestHystrixCommand() {
        super(HystrixCommandGroupKey.Factory.asKey("test"));
    }

    @Override
    protected String run() throws Exception {
        //Thread.sleep(1000);
        return "success";
    }


    @Override
    protected String getFallback() {
        System.err.println("执行getFallback()");
        return "fail";
    }

    public static void main(String[] args) {
        // 调用TestHystrixCommand 的execute执行实际方法
        TestHystrixCommand command = new TestHystrixCommand();
        System.err.println(command.execute());
    }
}
