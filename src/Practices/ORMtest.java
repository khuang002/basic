package Practices;

import javax.swing.*;
import java.sql.*;
import java.util.Scanner;

public class ORMtest {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/how2j?characterEncoding=UTF-8";
    // get from database and return a Hero object
    public static Hero get (int id){
        Hero hero = null;
        try{
            Class.forName(JDBC_DRIVER);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        try(Connection connection = DriverManager.getConnection(DB_URL, "root", "DBroot@123");
            Statement statement = connection.createStatement();){
            String sql = "SELECT * FROM hero WHERE id = " + id;
            ResultSet resultSet = statement.executeQuery(sql);
            if(resultSet.next()){
                hero = new Hero();
                String name = resultSet.getString(2);
                float hp = resultSet.getFloat("hp");
                int damage = resultSet.getInt(4);
                hero.name = name;
                hero.hp = hp;
                hero.damage =damage;
                hero.id = id;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hero;
    }
    public static void add (Hero h){
        try{
            Class.forName(JDBC_DRIVER);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        try(Connection connection = DriverManager.getConnection(DB_URL, "root", "DBroot@123");
            PreparedStatement statement = connection.prepareStatement("INSERT INTO hero(id, name, hp, damage) VALUES(null, ?, ?, ?)");){
            statement.setString(1, h.name);
            statement.setFloat(2, h.hp);
            statement.setInt(3, h.damage);
            int update;
            update = statement.executeUpdate();
            if (update == 1){
                System.out.printf("Successfully added %s\t%f\t%d%n", h.name, h.hp, h.damage);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
    public static void delete (Hero h){
        try{
            Class.forName(JDBC_DRIVER);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        try(Connection connection = DriverManager.getConnection(DB_URL, "root", "DBroot@123");
            PreparedStatement statement = connection.prepareStatement("DELETE FROM hero WHERE id=?");){
            statement.setInt(1, h.id);
            int update;
            update = statement.executeUpdate();
            if (update == 1){
                System.out.printf("Successfully deleted %s\t%f\t%d%n", h.name, h.hp, h.damage);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
    public static void update (Hero h, float health){
        try{
            Class.forName(JDBC_DRIVER);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        try(Connection connection = DriverManager.getConnection(DB_URL, "root", "DBroot@123");
            PreparedStatement statement = connection.prepareStatement("UPDATE hero set name=?, hp=?, damage=? WHERE id=?");){
            statement.setString(1, h.name);
            statement.setFloat(2, health);
            statement.setInt(3, h.damage);
            statement.setInt(4, h.id);
            int update;
            update = statement.executeUpdate();
            if (update == 1){
                System.out.printf("Successfully updated %s\t%f\t%d%n", h.name, h.hp, h.damage);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        Hero h = get(2);
        System.out.println(h.id+h.name);
        add(h);
        System.out.println("Sure to update?");
        Scanner scan = new Scanner(System.in);
        char c = scan.next().charAt(0);
        if ( c == 'Y' || c == 'y') {
            update(h, 666);
        }
        scan = new Scanner(System.in);
        System.out.println("Sure to delete?");
        c = scan.next().charAt(0);
        if ( c == 'Y' || c == 'y'){
            delete(h);
        }
    }
}
