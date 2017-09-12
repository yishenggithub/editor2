package db;

/**
 * Created by easom on 2017/9/8.
 */
import java.sql.*;
public class DBUtil {

    private static final String URL="jdbc:mysql://127.0.0.1:3306/editor?useUnicode=true&amp;characterEncoding=utf-8";
    private static final String USER="root";
    private static final String PASSWORD="583376938";

    private static Connection conn=null;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        return conn;
    }
}
