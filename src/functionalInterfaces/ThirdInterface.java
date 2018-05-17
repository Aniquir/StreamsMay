package functionalInterfaces;

import java.util.function.Supplier;

//Suppliers
//Suppliers produce a result of a given generic type. Unlike Functions, Suppliers don't accept arguments.
public class ThirdInterface {

    public static void main(String[] args) {
        Supplier<Person> personSupplier = Person::new;
        personSupplier.get();
    }


}
