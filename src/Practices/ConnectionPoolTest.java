package Practices;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionPoolTest {
    public static void main(String[] args){
        ConnectionPool cp = new ConnectionPool(3);
        for(int i=0; i<100; i++){
            new WorkingThread("working thread" +i, cp).start();
        }
    }
}
class WorkingThread extends Thread{
    private ConnectionPool cp;
    public WorkingThread(String name, ConnectionPool cp){
        super(name);
        this.cp=cp;
    }
    public void run(){
        Connection c = cp.getConnection();
        System.out.println(this.getName()+":\t has gotten one thread and start working.");
        try(Statement statement = c.createStatement()){
            Thread.sleep(1000);
            statement.execute("INSERT INTO hero(id, name, hp, damage) VALUES(null, 'Jack', 11, 4)");
        } catch (SQLException | InterruptedException e) {
            e.printStackTrace();
        }
        cp.returnConnection(c);
    }
}