import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ExercisesOfStreams {

    public static void main(String[] args) {

        // sorting before streams
        List<String> names = Arrays.asList("peter", "mara", "xenia", "mark", "andrev", "lalaluna");

        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println(names);

        //sorting after streams
        List<String> names2 = Arrays.asList("peter", "mara", "xenia", "mark", "andrev", "lalaluna");

        Collections.sort(names2, (String a, String b) -> {
            return a.compareTo(b);
        });

        System.out.println(names2);
        //shorter record
        List<String> names3 = Arrays.asList("peter", "mara", "xenia", "mark", "andrev", "lalaluna");
        Collections.sort(names3, (String a, String b) -> a.compareTo(b));

        System.out.println(names3);
        //shorter record
        List<String> names4 = Arrays.asList("peter", "mara", "xenia", "mark", "andrev", "lalaluna");

        Collections.sort(names4, (a, b) -> a.compareTo(b));

        System.out.println(names4);
        // the final version (sorting in one way)
        List<String> names5 = Arrays.asList("peter", "mara", "xenia", "mark", "andrev", "lalaluna");
        names5.sort(String::compareTo);

        System.out.println(names5);
    }
}
