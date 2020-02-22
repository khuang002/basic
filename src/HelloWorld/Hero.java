package HelloWorld;

public class Hero {
    String name;
    int hp;
    int armor;
    int moveSpeed;

    public static void main(String[] args){
        Hero garen      = new Hero();
        garen.name      = "Garen";
        garen.hp        = 616;
        garen.armor     = 27;
        garen.moveSpeed = 350;

        Hero teemo      = new Hero();
        teemo.name      = "Teemo";
        teemo.hp        = 383;
        teemo.armor     = 14;
        teemo.moveSpeed = 330;

        System.out.println(teemo.name+" speed is "+teemo.moveSpeed);
        System.out.println(garen.name+"'s armor is "+garen.armor);
    }

}
