package com.qingwen.demo;

import org.junit.Test;

import java.sql.*;

public class demo1 {
    @Test
    public void fun1() {
        //声明Connection对象
        Connection con;
        //驱动程序名
        String driver = "com.mysql.cj.jdbc.Driver";
        //URL指向要访问的数据库名mydata
        String url = "jdbc:mysql://quotation-prod.cluster-cojemua46qv2.us-east-1.rds.amazonaws.com/quotation-prod";
        //MySQL配置时的用户名
        String user = "zhangqw6-readyonly";
        //MySQL配置时的密码
        String password = "R99Vpqny";
        //遍历查询结果集
        try {
            //加载驱动程序
//            Class.forName(driver);
            //1.getConnection()方法，连接MySQL数据库！！
            con = DriverManager.getConnection(url, user, password);
            if (!con.isClosed())
                System.out.println("Succeeded connecting to the Database!");
            //2.创建statement类对象，用来执行SQL语句！！
            Statement statement = con.createStatement();
            //要执行的SQL语句
            String sql = "select * from quote limit 1, 100";
            //3.ResultSet类，用来存放获取的结果集！！
            ResultSet rs = statement.executeQuery(sql);
            System.out.println("--------------------------------------------------------------------");
            System.out.println("Executed Result:");
            System.out.println("--------------------------------------------------------------------");
            System.out.println("id" + "\t" + "quote number" + "\t" + "Quote Name");
            System.out.println("--------------------------------------------------------------------");

            String name = null;
            String code = null;
            String quote_number = null;
            while (rs.next()) {
                //获取stuname这列数据
                code = rs.getString("id");
                //获取stuid这列数据
                quote_number = rs.getString("quote_number");
                name = rs.getString("name");
                //输出结果
                System.out.println(code + "\t" + quote_number + "\t" + name);
            }
            rs.close();
            con.close();
        } catch (Exception e) {
            //数据库驱动类异常处理
            System.out.println("Sorry,can`t find the Driver!");
            e.printStackTrace();
        } finally {
            System.out.println("数据库数据获取测试结束！！");
        }
    }
}
