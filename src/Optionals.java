//Optionals are not functional interfaces, instead it's a
// nifty utility to prevent NullPointerException

//Optional is a simple container for a value which may be null or non-null.
// Think of a method which may return a non-null result but sometimes return nothing.
// Instead of returning null you return an Optional in Java 8.

import java.util.Optional;

//http://winterbe.com/posts/2014/03/16/java-8-tutorial/
public class Optionals {

    public static void main(String[] args) {
        Optional<String> optional = Optional.of("bam");

        optional.isPresent();//true
        optional.get();//"bam"
        optional.orElse("fallback");//"bam"

        optional.ifPresent((s) -> System.out.println(s.charAt(0)));//"b"
    }
}
