package com.kagura;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/8/1 9:00
 * @since 1.0.0
 */
@SpringBootApplication
public class BaseApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(BaseApplication.class, args);
        //Runtime.getRuntime().exec("java -jar b.jar");
        //Runtime.getRuntime().exec("java -jar c.jar");
        //Runtime.getRuntime().exec("java -jar d.jar");
        
    }

}
