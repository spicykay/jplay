
package Comparator;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * https://www.geeksforgeeks.org/comparator-comparingint-in-java-with-examples/
 */
class User implements Comparable<User> {
    public String name;
    public int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(User u1) {
        return name.compareTo(u1.name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User [name=" + name
                + ", age=" + age + "]";
    }
}

public class ComparingInts {

    /**
     * @param args
     */
    public static void main(String[] args) {

        // create some user objects
        User u1 = new User("Aaman", 25);
        User u2 = new User("Joyita", 22);
        User u3 = new User("Suvam", 28);
        User u4 = new User("mahafuj", 25);

        // before sort
        List<User> list = Arrays.asList(u2, u1, u4, u3);
        System.out.println("Before Sort:");
        list.forEach(User -> System.out.println("User age "
                + User.getAge()));

        Collections.sort(list,
                Comparator.comparingInt(
                        User::getAge));
        System.out.println("\nAfterSort:");
        list.forEach(User -> System.out.println("User age "
                + User.getAge()));
    }
}
