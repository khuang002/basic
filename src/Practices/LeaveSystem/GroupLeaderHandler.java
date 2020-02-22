package Practices.LeaveSystem;

public class GroupLeaderHandler extends Handler{

    @Override
    public void handleRequest(int day) {
        if(day <= 2){
            System.out.println("Handled by Group Leader.");
        }else{
            if(super.successor != null){
                super.successor.handleRequest(day);
            }
        }
    }
}
