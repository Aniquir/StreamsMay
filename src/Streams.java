import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class Streams {

    //http://winterbe.com/posts/2014/03/16/java-8-tutorial/
    public static void main(String[] args) {
        //STREAMS
        System.out.println(" > > > STREAMS < < < ");
        List<String> stringCollection = new ArrayList<>();
        stringCollection.add("ddd2");
        stringCollection.add("aaa2");
        stringCollection.add("bbb1");
        stringCollection.add("aaa1");
        stringCollection.add("bbb3");
        stringCollection.add("ccc");
        stringCollection.add("bbb2");
        stringCollection.add("ddd1");

//        operations:
        //Filter ==================
        System.out.println("filter ==================");
        stringCollection
                .stream()
                .filter((s) -> s.startsWith("a"))
                .forEach(System.out::println);

        //Sorted ==================
        System.out.println("sorted ==================");
        stringCollection
                .stream()
                .sorted()
                .filter((s -> s.startsWith("a")))
                .forEach(System.out::println);
        //but ordering of stringCollections is untouched
        System.out.println(stringCollection);

        //Map ==================
        System.out.println("map ==================");
        stringCollection
                .stream()
                .map(String::toUpperCase)
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);

        //Match ==================
        System.out.println("match ==================");
        boolean anyStartsWithA =
                stringCollection
                    .stream()
                    .anyMatch(s -> s.startsWith("a"));

        System.out.println(anyStartsWithA);//true

        boolean allStartsWithA =
                stringCollection
                    .stream()
                    .allMatch(s -> s.startsWith("a"));//false

        System.out.println(allStartsWithA);

        boolean noneStartsWithZ =
                stringCollection
                    .stream()
                    .noneMatch(s -> s.startsWith("z"));

        System.out.println(noneStartsWithZ);//true

        //Count ==================
        System.out.println("count ==================");
        long startsWithB =
                stringCollection
                    .stream()
                    .filter(s -> s.startsWith("b"))
                    .count();

        System.out.println(startsWithB);

        //Reduce ==================
        System.out.println("reduce ==================");
        Optional<String> reduced =
                stringCollection
                    .stream()
                    .sorted()
                    .reduce((s1, s2) -> s1 + "#" + s2);

        reduced.ifPresent(System.out::println);
        //==========================================
        //PARALLEL STREAMS
        System.out.println(" > > > PARALLEL STREAMS < < < ");
        //large list of unique elements
        int max = 1000000;
        List<String> values = new ArrayList<>(max);
        for (int i = 0; i < max; i++) {
            UUID uuid = UUID.randomUUID();
            values.add(uuid.toString());
        }
        //we measure the time it takes to sort a stream of this collection
        //sequential sort
        System.out.println("====================================");
        long t0 = System.nanoTime();

        long count = values.stream().sorted().count();
        System.out.println(count);

        long t1 = System.nanoTime();

        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(String.format("sequential sort took: %d ms", millis));

        //parallel sort
        long t2 = System.nanoTime();

        long count1 = values.parallelStream().sorted().count();
        System.out.println(count1);

        long t3 = System.nanoTime();

        long millis1 = TimeUnit.NANOSECONDS.toMillis(t3 - t2);
        System.out.println(String.format("parallel sort took: %d ms", millis1));

        //Map ==================
        System.out.println("map ==================");
        Map<Integer, String> map = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            map.putIfAbsent(i, "val" + i);
        }
        map.forEach((id, val) -> System.out.println(val));

        //how to compute code
        map.computeIfPresent(3, (num, val) -> val + num);
        map.get(3);//val33

        map.computeIfPresent(9, (num, val) -> null);
        map.containsKey(9); //false

        map.computeIfAbsent(23, num -> "val" + num);
        map.containsKey(23);//true

        map.computeIfAbsent(3, num -> "bam");
        map.get(3); //val33

        //how to remove entries
        map.remove(3, "val3");
        map.get(3);//val33

        map.remove(3, "val33");
        map.get(3);//null

        //another helpful method
        map.getOrDefault(42, "not found");//"not found"

        //merging entries of a map
        map.merge(9, "val9", (value, newValue) -> value.concat(newValue));
        map.get(9); //val9

        map.merge(9, "concat", (value, newValue) -> value.concat(newValue));
        map.get(9);//val9concat
        System.out.println(map.get(9));



    }
}
