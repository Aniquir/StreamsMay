import static java.lang.Integer.valueOf;

public class ConverterTester {
    public static void main(String[] args) {
        Converter<String, Integer> converter = Integer::valueOf;
        Integer converted = converter.convert("123");
        System.out.println(converted);
    }
}
