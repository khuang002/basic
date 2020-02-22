package Practices;

import java.io.*;

public class ReadWriteObject {
    public static void main(String[] args){
        File file = new File("/Users/kun/IdeaProjects/basic/src/Practices/test/1.txt");
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))){
            objectOutputStream.writeObject(new User("Jason","password"));
            objectOutputStream.writeObject(new User("Michael","password"));
            objectOutputStream.flush();
        }catch(IOException e){
            e.printStackTrace();
        }
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))){
            User user = (User) objectInputStream.readObject();
            System.out.println(user.toString());
        }catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    static class User implements Serializable{
        private String username;
        private String password;

        public User(String username, String password) {
            this.username = username;
            this.password = password;
        }
        @Override
        public String toString(){
            return "User{" +
                    "username='" + username + '\'' +
                    ", password='" + password + '\'' +
                    '}';
        }
    }
}
