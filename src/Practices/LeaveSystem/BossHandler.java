package Practices.LeaveSystem;

public class BossHandler extends Handler {
    @Override
    public void handleRequest(int day) {
        if(day <= 15){
            System.out.println("Handled by Boss.");
        }else{
            System.out.println("Exceeded the max leave limmit.");
        }
    }
}
