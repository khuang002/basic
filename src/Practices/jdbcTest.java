package Practices;

import java.sql.*;

public class jdbcTest {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/how2j?characterEncoding=UTF-8";
    public static void main(String[] args){
        Statement  statement = null;
        Connection connection = null;
        try{
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL,
                    "root", "DBroot@123");
            String sql = "SELECT COUNT(*) FROM hero";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            int total = 0;
            while(resultSet.next()){
                total = resultSet.getInt(1);
            }
            System.out.println(total);
        } catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try{
                    statement.close();
                } catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
