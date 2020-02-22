package Practices;

import java.util.HashMap;
import java.util.Objects;

public class Rabbit {
    // Map (id, count, age)
    private static HashMap<Integer, Paras> number = new HashMap<Integer, Paras>();
    public static void main(String[] args){
        int id;
        for (id=1; id<20; id++){
            System.out.println("The number of pair of rabbit is "+generate(id));
        }
    }
    private static int generate(int nextID){
        if (number.size() == 0){
            Paras next = new Paras(1,1);
            number.put(nextID,next);
            // update the age for every rabbit
            System.out.println("debug count: "+number.get(1).getCount());
            System.out.println("debug age: "+number.get(1).getAge());
            return 1;
        } else{
            int counting = 0;
            int newRabbit = 0;
            boolean ifHaveNew = false;
            for (Paras value: number.values()){
                // if rabbit is >= 3 year old, get the count
                if (value.getAge() >= 2){
                    newRabbit = newRabbit + value.getCount();
                    ifHaveNew = true;
                }
                // get the total number of rabbits
                counting = counting + value.getCount();
                // update the age for every rabbit
                value.setAge(value.getAge()+1);
            }
            if (ifHaveNew){
                Paras next = new Paras(newRabbit, 1);
                number.put(nextID,next);
            }
            return counting+newRabbit;
        }
    }
}

class Paras{
    private int count;
    private int age;
    public Paras(int count, int age) {
        this.count = count;
        this.age = age;
    }

    public int getCount() {
        return count;
    }

    public int getAge() {
        return age;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count, age);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paras paras = (Paras) o;
        return count == paras.count &&
                age == paras.age;
    }
}

