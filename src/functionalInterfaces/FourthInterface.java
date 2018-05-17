package functionalInterfaces;

import java.util.function.Consumer;

//Consumers
//Consumers represents operations to be performed on a single input argument.
public class FourthInterface {

    public static void main(String[] args) {
        Consumer<Person> greeter = (p) -> System.out.println("Hello, " + p.firstName);
        greeter.accept(new Person("Luke", "Skywalker"));
    }
}
