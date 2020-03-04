package dao;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/java_image_server?characterEncoding=utf8&useSSL=true";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root123";

    //DataSource——Java内置的一个类
    //volatile这个属性内存可见，第一个线程操作之后，其他线程也能看见数值更新
    private static volatile DataSource dataSource = null;

    //一、获取dataSource
    //单例模式
    public static DataSource getDataSource() {
        // 通过这个方法来创建 DataSource 的实例
        if (dataSource == null) {
            //synchronized加锁：防止两次访问同时对dataSource对象进行创建
            //两个if保证只在第一次的时候用锁，减少锁的使用，防止锁之间发生冲突，而且加锁也是一个耗时费力的过程
            synchronized (DBUtil.class) {
                if (dataSource == null) {
                    dataSource = new MysqlDataSource();
                    //类型强转：将dataSource强转为MysqlDataSource
                    MysqlDataSource tmpDataSource = (MysqlDataSource) dataSource;
                    tmpDataSource.setURL(URL);
                    tmpDataSource.setUser(USERNAME);
                    tmpDataSource.setPassword(PASSWORD);
                }
            }
        }
        return dataSource;
    }

    //二、获取连接
    public static Connection getConnection() {
        try {
            return getDataSource().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //三、关闭连接（先开后关）
    public static void close(Connection connection, PreparedStatement statement, ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}