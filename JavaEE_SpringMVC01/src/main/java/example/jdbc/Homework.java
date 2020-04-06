package example.jdbc;

import example.model.Student;
import example.model.StudentHomework;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Homework {
    public static List<Student> showStudent(){


        String url = "jdbc:mysql://127.0.0.1:3306/school?serverTimezone=UTC";
        String driverName = "com.mysql.cj.jdbc.Driver";
        String sqlString = "SELECT * FROM s_student";

        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        List<Student> list = new ArrayList<>();
        try (Connection connection = DatabasePool.getHikariDataSource().getConnection()) {
            //Statement创建对象用来执行sql语句
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery(sqlString)) {
                    //获取执行结果
                    while (resultSet.next()) {
                        Student s = new Student();
                        s.setId(resultSet.getString("id"));
                        s.setName(resultSet.getString("name"));
                        s.setCreateTime(resultSet.getTimestamp("create_time"));
                        list.add(s);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //返回list
        return list;
    }


    public static void main(String[] args) {
        List<Student> list=showStudent();
        for (Student sh:list){
            System.out.println(sh.getName());
        }
    }
}

