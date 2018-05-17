package functionalInterfaces;

//this is copy of Person class, its helps ThirdInterface, FourthInterface, FifthInterface classes
public class Person {

    String firstName;
    String lastName;

    Person() {}

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
