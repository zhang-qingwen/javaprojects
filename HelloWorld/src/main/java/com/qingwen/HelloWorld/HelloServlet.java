package com.qingwen.HelloWorld;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

// @WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public HelloServlet() {
        System.out.println("HelloServlet Constructor....");
    }

    public void init() {
        System.out.println("Initialization executed");
        message = "Hello World!";

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
        Person person = new Person("zhangsan", 20, "Woman");
        System.out.println(person);
    }

    public void destroy() {
        System.out.println("destroy executed");
    }
}