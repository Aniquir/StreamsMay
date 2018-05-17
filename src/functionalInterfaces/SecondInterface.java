package functionalInterfaces;

import java.util.function.Function;

//Functions
//Functions accept one argument and produce a result.
//Default methods can be used to chain multiple functions together (compose, andThen).
public class SecondInterface {

    public static void main(String[] args) {
        Function<String, Integer> toInteger = Integer::valueOf;
        Function<String, String> backToString = toInteger.andThen(String::valueOf);

        backToString.apply("123");
    }
}
