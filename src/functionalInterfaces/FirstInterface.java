package functionalInterfaces;

import java.util.Objects;
import java.util.function.Predicate;

//Predicates
//Predicates are boolean-valued functions of one argument
//The interface contains various default methods for composing
// predicates to complex logical terms (and, or, negate)

//http://winterbe.com/posts/2014/03/16/java-8-tutorial/
public class FirstInterface {


    public static void main(String[] args) {
        Predicate<String> predicate = (s) -> s.length() > 0;

        predicate.test("foo");
        predicate.negate().test("foo");

        Predicate<Boolean> nonNull = Objects::nonNull;
        Predicate<Boolean> isNull = Objects::isNull;

        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNotEmpty = isEmpty.negate();
    }
}
