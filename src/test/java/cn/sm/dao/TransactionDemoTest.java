package cn.sm.dao;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionDemoTest {
    @Test
    public void JDBCtransaction() throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn= null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/javadb", "root", "123456");
            //关闭事务的自动提交
            // 在我们默认的jdbc中事务是自动提交的
            conn.setAutoCommit(false);
            //先减100
            String sql="update bank set money=money-? where name=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1, 100);
            ps.setString(2, "A");
            // 增删改操作全部都要用update来执行
            ps.executeUpdate();
            //模拟中间发生错误
            int a=10/0;
            //再加100
            ps.setInt(1, -100);
            ps.setString(2, "B");
            ps.executeUpdate();
            //如果都没有问题则提交事务
            conn.commit();
        } catch (SQLException e) {
            //如果中间发生错误则在这里回滚事务
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
    }
}
