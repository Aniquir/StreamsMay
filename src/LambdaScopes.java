public class LambdaScopes {

    public static void main(String[] args) {
        //num must be final (implicitly final for the code to compile, it can't be changed later)
        final int num = 1;
        Converter<Integer, String> stringConverter =
                (from) -> String.valueOf(from + num);

        stringConverter.convert(2);
        System.out.println(stringConverter);
    }

}
