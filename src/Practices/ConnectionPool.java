package Practices;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {
    List<Connection> connections = new ArrayList<Connection>();
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://192.168.154.128/how2j?characterEncoding=UTF-8";
    int size;
    public ConnectionPool(int size){
        this.size = size;
        init();
    }
    public void init(){
        try{
            Class.forName(JDBC_DRIVER);
            for (int i=0; i<size; i++){
                Connection connection = DriverManager.getConnection(DB_URL, "remote", "DBremote@123");
                connections.add(connection);
        }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public synchronized Connection getConnection(){
        while(connections.isEmpty()){
            try{
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Connection c = connections.remove(0);
        return c;
    }
    public synchronized void returnConnection(Connection c){
        connections.add(c);
        this.notifyAll();
    }
}
