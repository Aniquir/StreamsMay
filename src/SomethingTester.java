
public class SomethingTester {

    //Method and Constructor References
    public static void main(String[] args) {
        Something something = new Something();

        Converter<String, String> converter = something::startsWith;
        String converted = converter.convert("Java");
        System.out.println(converted);
    }
}
