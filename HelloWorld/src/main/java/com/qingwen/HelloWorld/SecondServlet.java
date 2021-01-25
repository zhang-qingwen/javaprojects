package com.qingwen.HelloWorld;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

public class SecondServlet implements Servlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("Second servlet execution!");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }
}
