package Maps;

import java.util.*;

public class Maps {

    private static void LinkedHashMap() {

        System.out.printf("A Linked HashMap maintains insertion order; a HashMap does not\n");

        /**
         * Linked Hash Maps maintain insertion order
         */
        final Map<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(1, 2);
        linkedHashMap.put(3, 4);
        linkedHashMap.put(-3, 4);
        linkedHashMap.put(5, 6);

        linkedHashMap.put(3, -6);
        linkedHashMap.put(-3, -6);

        // iterating through these will show the values in insertion order (earliest first)
        for(Map.Entry<Integer, Integer> e: linkedHashMap.entrySet()) {
            System.out.printf("[%d => %d]\n", e.getKey(), e.getValue());
        }

        System.out.printf("\tLinkedHashMap: %s\n",linkedHashMap.toString());

        final Map<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(1, 2);
        hashMap.put(3, 4);
        hashMap.put(-3, 4);
        hashMap.put(5, 6);

        System.out.printf("\tHashMap: %s\n",hashMap.toString());
    }

    private static void sortedMaps() {
        System.out.printf("Sorted Maps basically impose some relative ordering on their subjects and allow you to gather keys within ranges\n");

        final SortedMap<Integer, String> sortedMap = new TreeMap<>();
        for(int i = 0; i< 10; i++) {
            sortedMap.put(i, String.valueOf(i));
        }

        System.out.printf("Given the following SortedMap: %s\n", sortedMap.toString());

        System.out.printf("\tYou can get all value strictly less than some number by using headMap\n");
        final SortedMap<Integer, String> lessThanFive = sortedMap.headMap(5);
        System.out.printf("\tAll Values Less Than the key: 5 => headMap(5) => %s\n\n", lessThanFive.toString());

        System.out.printf("\tYou can get all value >= than some number by using tailMap\n");
        final SortedMap<Integer, String> greaterThanEqualsFive = sortedMap.tailMap(5);
        System.out.printf("\tAll Values Greater Than or Equal to the key: 5 => tailMap(5) => %s\n\n", greaterThanEqualsFive.toString());

        System.out.printf("Get the first or last Keys:\n");
        System.out.printf("\tFirst (lowest) Key: firstKey(): %d\n\tLast (highest) key: lastKey(): %d\n\n", sortedMap.firstKey(), sortedMap.lastKey());

        System.out.printf("\tYou can get all value between some range using a subMap\n");
        final SortedMap<Integer, String> betweenRange = sortedMap.subMap(4, 9);
        System.out.printf("\tAll Values between: [4, 9] => subMap(4, 9) => %s\n\n", betweenRange.toString());
    }


    private static void mapLambdas() {
        // The compute() function can be used to update all the values of a map
        // if the new value is null, then the key is removed
        System.out.printf("The compute() function can be used to update all the values of a map\n");
        final Map<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(1, 2);
        hashMap.put(3, 4);
        hashMap.put(-3, 4);
        hashMap.put(5, 6);
        System.out.printf("Original Hashmap: %s\n", hashMap.toString());
        for(Integer key: hashMap.keySet()) {
            hashMap.compute(key, (k, v) -> {
                return k + v;
            });
        }
        System.out.printf("New HashMap: %s\n\n", hashMap.toString());

        // The computeIfPresent() function computes a new mapping for a key only if a value exists for a key and is non-null
        // The computeIfAbsent() function computes a new mapping for a key only if the key does not arleady exist (or is associated with null).


        System.out.printf("the putIfAbsent(K, V) inserts an item into the map if key doesn't already exist. Returns V if there is a mapping or null if no prior mapping\n");
        Integer v = hashMap.putIfAbsent(100, 100);
        System.out.printf("We put 100 into the map (it doesn't already exist) and got: %d\n\n", v);
    }

    private static void mapIteration() {
        final Map<Integer, String> map = new HashMap<>();
        for(int i = 0; i< 10; i++) {
            map.put(i, String.valueOf(i));
        }

        System.out.printf("You may use forEach() to quickly iterate through the map using a lambda\n");
        map.forEach((k, v) -> System.out.printf("[key: %d, value: %s]", k, v));
        System.out.println();

    }

    public static void main(String[] args) {
        // mapLambdas();
        sortedMaps();
        // mapIteration();
    }

}
