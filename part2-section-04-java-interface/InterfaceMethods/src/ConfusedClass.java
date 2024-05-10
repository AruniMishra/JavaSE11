/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 3: Interfaces
Topic:  Default methods
*/

// Interface walkable has an abstract method and a default method
interface Walkable {
    void walk();

    default float getGait() {
        return 3.5f;
    }
}

// Interface Strollable has an abstract method and a default method
interface Strollable {
    void stroll();

    default float getGait() {
        return 2.5f;
    }
}

// ConfusedClass implements both interfaces that both have the same
// default method defined
public class ConfusedClass implements Walkable, Strollable {
    public static void main(String[] args) {
        ConfusedClass c = new ConfusedClass();
        c.walk();
        c.stroll();
    }

    public void walk() {
        System.out.println("When walking, gait is " + getGait());

        // or,
        System.out.println(Walkable.super.getGait());
    }

    public void stroll() {
        System.out.println("When strolling, gait is " + getGait());

        // or,
        Strollable.super.getGait();
    }

    @Override
    public float getGait() {
        // Overrides both methods and implements it's own custom code
        return 5.2f;
    }
}
