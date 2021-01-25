package com.qingwen.ServletDemo;

import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;

public class AServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init()...");
        Enumeration<String> initParameterNames = servletConfig.getInitParameterNames();
        while (initParameterNames.hasMoreElements()){
            System.out.println(initParameterNames.nextElement());
//            System.out.println(servletConfig.getServletName());
        }

        ServletContext servletContext = servletConfig.getServletContext();
        System.out.println(servletContext.getServerInfo());
    }

    @Override
    public ServletConfig getServletConfig() {
        System.out.println("getServletConfig()...");
        return null;
    }

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        System.out.println("service()....");
    }

    @Override
    public String getServletInfo() {
        System.out.println("getServletInfo()...");
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("destroy()....");
    }
}
