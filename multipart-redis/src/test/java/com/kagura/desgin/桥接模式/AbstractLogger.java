package com.kagura.desgin.桥接模式;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/7/26 13:42
 * @since 1.0.0
 */
abstract class AbstractLogger {
    // 将日志组合进来
    private Logger logger = Logger.info();

    public AbstractLogger() {
    }

    public AbstractLogger(Logger logger) {
        this.logger = logger;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    public void print(String message) {
        logger.log(message);
    }
}
