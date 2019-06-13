package com.netty.client2.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import com.netty.client2.entity.User;
import com.netty.client2.service.FeignTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("index")
public class UserController {

    @Resource
    FeignTest feignTest;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;


    @GetMapping(path = "/id")
    public Object test01() {
        //List<ServiceInstance> list = discoveryClient.getInstances("user-service");
        //ServiceInstance instance = list.get(0);
        //System.out.println(instance.getHost());
        //System.out.println(instance.getPort());
        //System.out.println(instance.getUri() + "/user/id");
        //return ResponseEntity.ok(1);
        System.out.println(666666);
        return feignTest.test01();

    }

    /**
     * Ribbon + RestTemplate 测试
     */
    @GetMapping(path = "/id2")
    public String test02() {
        URI uri = discoveryClient.getInstances("user-service").get(0).getUri();
        // http://127.0.0.1:8092/user
        String u = uri.toString() + "/user";

        // 直接填写服务名即可
        String url = "http://user-service/user/";
        System.out.println("test02 : " + url);

        // 结果就是会均衡调用注册到user-service名的服务
        Object o = restTemplate.getForObject(url, Object.class);
        System.out.println(o);
        return "\"success\"";
    }

    /**
     * Hystrix - 熔断测试
     */
    @GetMapping(path = "/id3")
    @HystrixCommand(fallbackMethod = "getTest03Bak")
    public Object test03() {
        return feignTest.test01();
    }

    public Object getTest03Bak() {
        System.out.println("getTest03Bak()");
        return "getTest03Bak";
    }


    /**
     * Valid效验测试
     */
    @GetMapping(path = "/valid")
    public Object test04(@Valid User user) {

        System.out.println(user);

        return "ok";
    }





}
