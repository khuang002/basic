//design pattern: proxy pattern

package Practices.BuildHouse;

public class HouseClient {
    public static void main(String[] args){
        HouseSubject proxy = new HouseProxy();
        proxy.build();
    }
}
