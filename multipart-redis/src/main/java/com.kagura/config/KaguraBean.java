package com.kagura.config;

import com.kagura.annotation.PushListener;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.beans.factory.config.BeanPostProcessor;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

//使用@Component的话,初始化无法动态赋值,只能写死private String name = "A";
@PushListener
public class KaguraBean implements InitializingBean, DisposableBean, SmartInitializingSingleton, BeanPostProcessor {

    private String name;

    public KaguraBean () {
        System.err.println("KaguraBean 造函数");
    }

    public String getName() {
        System.out.println("bean getName");
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("bean setName");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("postConstruct()");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("preDestroy()");
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("afterPropertiesSet()");
    }

    @Override
    public void destroy() {
        System.out.println("destroy()");
    }

    public void initMethod() {
        System.out.println("initMethod()");
    }

    public void destroyMethod() {
        System.out.println("destroyMethod()");
    }


    @Override
    public void afterSingletonsInstantiated() {
        System.err.println("KaguraBean -> afterSingletonsInstantiated()");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        //System.err.println("Bean1 -> postProcessBeforeInitialization()");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        //System.err.println("Bean1 -> postProcessAfterInitialization()");
        return bean;
    }
}
