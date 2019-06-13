package com.kagura.filter;

import org.springframework.cloud.netflix.zuul.filters.post.SendErrorFilter;

import java.util.HashMap;
import java.util.Map;

public class GetErrorFilter extends SendErrorFilter {


    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        //map.put("aaa", "1");
        //map.put("aaa", null);
        System.out.println(map.containsKey("aaa"));
        System.out.println(map.get("aaa"));
    }

    public GetErrorFilter() {
        super();
    }


    @Override
    public String filterType() {
        return super.filterType();
    }


    @Override
    public int filterOrder() {
        return super.filterOrder();
    }


    @Override
    public boolean shouldFilter() {
        return super.shouldFilter();
    }


    @Override
    public Object run() {
        return super.run();
    }


    @Override
    protected ExceptionHolder findZuulException(Throwable throwable) {
        return super.findZuulException(throwable);
    }


    @Override
    public void setErrorPath(String errorPath) {
        super.setErrorPath(errorPath);
    }

}
