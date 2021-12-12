package com.atcwl.sixthTask;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCTask {
    public static Connection getConnection() throws Exception {
        InputStream stream = JDBCTask.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties pros = new Properties();
        pros.load(stream);

        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        String url = pros.getProperty("url");
        String driver = pros.getProperty("driverClass");

        Class.forName(driver);
        Connection conn = DriverManager.getConnection(url, user, password);

        return conn;
    }

    public static void insertConn(Connection conn) throws SQLException {
        String sql1 = "insert into Students values (?,?,?,?)";
        PreparedStatement p = conn.prepareStatement(sql1);
        p.setString(1, "s001");
        p.setString(2, "老大");
        p.setInt(3, 20);
        p.setString(4, "计算机学院");
//        p.execute();

        p.setString(1, "s002");
        p.setString(2, "老二");
        p.setInt(3, 19);
        p.setString(4, "计算机学院");
//        p.execute();

        p.setString(1, "s003");
        p.setString(2, "老三");
        p.setInt(3, 18);
        p.setString(4, "计算机学院");
//        p.execute();

        p.setString(1, "s004");
        p.setString(2, "老四");
        p.setInt(3, 17);
        p.setString(4, "计算机学院");

        p.execute();
        p.close();
    }

    public static void getResult(Connection conn) throws SQLException {
        String sql = "select SNO,name,Age,College from Students";
        PreparedStatement p = conn.prepareStatement(sql);
        ResultSet resultSet = p.executeQuery();
        Student[] students = new Student[10];
        int index = 0;
        System.out.println("SNO\t\tname\tAge\tCollege");
        while(resultSet.next()) {
            String SNO = resultSet.getString(1);
            String name = resultSet.getString(2);
            int Age = resultSet.getInt(3);
            String College = resultSet.getString(4);
            students[index++] = new Student(SNO, name, Age, College);
        }

        for (int i = 0; i < index; i++) {
            System.out.println(students[i]);
        }
        p.close();
    }

    public static void deleteInformation(Connection conn) throws SQLException {
        String sql = "delete from Students where SNO=?";
        PreparedStatement p = conn.prepareStatement(sql);
        p.setString(1, "s004");
        p.execute();
        p.close();
    }

    public static void selectInformation(Connection conn) throws SQLException {
        String sql = "select SNO,name,Age,College from Students where SNO=?";
        PreparedStatement p = conn.prepareStatement(sql);
        p.setString(1, "s003");
        ResultSet resultSet = p.executeQuery();
        Student s = null;
        if(resultSet.next()) {
            String SNO = resultSet.getString(1);
            String name = resultSet.getString(2);
            int Age = resultSet.getInt(3);
            String College = resultSet.getString(4);
            s = new Student(SNO, name, Age, College);
        }
        System.out.println(s);
        p.close();
    }

    public static void modifyInformation(Connection conn) throws SQLException {
        String sql = "update Students set College=? where SNO=?";
        PreparedStatement p = conn.prepareStatement(sql);
        p.setString(1, "通信学院");
        p.setString(2, "s001");
        p.execute();
        p.close();
    }

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement p = null;
        try{
            try {
                conn = getConnection();
            } catch (Exception e) {
                e.printStackTrace();
            }

            if(conn == null) {
                System.out.println("数据库连接失败");
                return;
            }

//--------------------------------------------------------------
            //添加信息
            try {
                insertConn(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println("添加信息已完成");

//--------------------------------------------------------------
            //查询信息
            System.out.println("第一题和第二题的效果");
            System.out.println("查询学生信息");
            try {
                getResult(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            System.out.println();
//--------------------------------------------------------------
            //删除学生信息
            System.out.println("第三题的效果");
            System.out.println("删除SNO为s004的学生记录");
            try {
                deleteInformation(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                getResult(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println();

//--------------------------------------------------------------
            //查询SNO为s003的学生的记录
            System.out.println("第四题的效果");
            System.out.println("查询SNO为s003的学生记录");
            try {
                selectInformation(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            System.out.println();
//--------------------------------------------------------------
            //修改SNO为s001的学生的记录
            System.out.println("第五题的效果");
            System.out.println("修改SNO为s001的学生记录");
            try {
                modifyInformation(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                getResult(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }finally {
            try {
                if(conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
