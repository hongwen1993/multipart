package com.kagura.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * @author Karas
 * @date 2019/7/23 18:02
 */
public class TestServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("init(ServletConfig config)");
    }

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("init()");
    }



}
