//design pattern: chain of responsibility pattern
package Practices.LeaveSystem;

public class Client {
    public static void main(String[] args){
        Handler groupLeaderHandler = new GroupLeaderHandler();
        Handler factoryManagerHandler = new FactoryManagerHandler();
        Handler bossHandler = new BossHandler();

        groupLeaderHandler.setSuccessor(factoryManagerHandler);
        factoryManagerHandler.setSuccessor(bossHandler);

        groupLeaderHandler.handleRequest(1);
        groupLeaderHandler.handleRequest(6);
        groupLeaderHandler.handleRequest(10);
        groupLeaderHandler.handleRequest(20);
    }
}
