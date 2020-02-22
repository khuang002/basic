package Practices.LeaveSystem;

public class FactoryManagerHandler extends Handler {
    @Override
    public void handleRequest(int day) {
        if(day <= 7){
            System.out.println("Handled by Factory Manager.");
        }else{
            if(super.successor != null){
                super.successor.handleRequest(day);
            }
        }
    }
}
