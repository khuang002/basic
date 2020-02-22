package Practices.BuildHouse;

public class HouseProxy implements HouseSubject {
    private HouseSubject target;

    public HouseProxy() {
        this.target = new HouseRealSubject();
    }

    @Override
    public void build() {
        System.out.println("Procuring materials.");
        target.build();
        System.out.println("Finished.");
    }
}
