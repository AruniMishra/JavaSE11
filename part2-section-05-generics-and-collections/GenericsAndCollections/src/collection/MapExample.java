package collection;/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 4: Generics and Collections
Topic:  Collections, Map: HashMap, TreeMap, LinkedHashMap
*/

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.BiFunction;

public class MapExample {

    public static void main(String[] args) {

        /*
        HashMap and LinkedHashMap can accept allow 1 null key but TreeMap cannot accept null keys.

        LinkedHashMap by default keeps an insertion order so every time you iterate the map, you get same result.
         */


        // Create three maps with String keys and Integer values.

        // NonOrdered; allows "null" key; allows "null" value
        Map<String, Integer> h = new HashMap<>();

        // Natural Order or Comparator; NO "null" key; allows "null" value
        Map<String, Integer> t = new TreeMap<>();

        // Predictable Insertion order; allows "null" key; allows "null" value
        Map<String, Integer> l = new LinkedHashMap<>();

        String[] names = new String[]{"Barry",
                "George", "Harold", "Ida", "John"};

        // Fill the map with some data, using put.
        for (int i = 0; i < names.length; i++) {
            h.put(names[i], (i + 1));
            t.put(names[i], (i + 1));
            l.put(names[i], (i + 1));
        }

        // h.entrySet().forEach((s) ->
        //         System.out.print(s + "; "));

        // Test if null keys and null values are allowed
        Map<String, Integer> currentMap;
        for (int i = 0; i < 3; i++) {
            if (i == 0) currentMap = l;
            else if (i == 1) currentMap = h;
            else currentMap = t;
            try {
                // Insert map entry with a null value
                currentMap.put("NullValue", null);

                // Insert map entry with a null key
                currentMap.put(null, 12);

            } catch (Exception e) {
                System.out.println(currentMap.getClass().toGenericString() +
                        " does not support null keys");
                System.out.println(e.toString());

            }
        }

        // Print out data, the entire set, then each element of set.
        System.out.println("\n--- HashMap: " + h);
        h.entrySet().forEach((s) ->
                System.out.println(s.getClass().getName() + " : " + s));

        // Print out data, the entire set, then each element of set.
        System.out.println("--- TreeMap: " + t);
        t.entrySet().forEach((s) ->
                System.out.println(s.getClass().getName() + " : " + s));

        // Print out data, the entire set, then each element of set.
        System.out.println("--- LinkedHashMap: " + l);
        l.entrySet().forEach((s) ->
                System.out.println(s.getClass().getName() + " : " + s));


        System.out.println("\n---- LinkedHashMap: do Simple Stuff -------");
        doSimpleMapStuff(l);


        System.out.println("\n--- LinkedHashMap: test compute methods ---");
        // Simplify map
        l.remove("NullValue");
        l.remove(null);
        l.remove("Maggie");
        testComputes(l);


        System.out.println("\n--- LinkedHashMap: test merge methods ---");
        testMerges(l);

    }

    private static void doSimpleMapStuff(Map<String, Integer> m) {
        System.out.println("The value of m.get(Jane)) = "
                + m.get("Jane") + " : " + m);
        System.out.println("The value of m.get(John)) = "
                + m.get("John") + " : " + m);

        // Does map exist?
        System.out.println("Map contains a key 'Barry'?: " +
                m.containsKey("Barry") + " : " + m);
        // Does value exist
        System.out.println("Map contains a value '7'?: " +
                m.containsValue(7) + " : " + m);

        // Replacing values - Always replaces value for NullValue to 77
        System.out.println("m.replace(NullValue, 77): " +
                m.replace("NullValue", 77) + " : " + m);

        // Replaces value in Barry to 10 if current value is 1,
        // returns true
        System.out.println("m.replace(Barry, 1, 10): " +
                m.replace("Barry", 1, 10) + " : " + m);

        // Replaces value in Barry to 11 if current value is 7,
        // returns false because value in Barry is not 7
        System.out.println("m.replace(Barry, 7, 11): " +
                m.replace("Barry", 7, 11) + " : " + m);

        // Simple removal by key
        System.out.println("remove(Ida): " + m.remove("Ida")
                + " : " + m);

        // Conditional removal by key if value matches second argument
        System.out.println("remove(Harold, 10) : " + m.remove("Harold", 10)
                + " : " + m);

        // Conditional removal by key if value matches second argument
        System.out.println("remove(Harold, 3) : " + m.remove("Harold", 3)
                + " : " + m);

        // putIfAbsent adds Key/Value if key doesn't exist
        System.out.println("putIfAbsent(Harold, 8) : " +
                m.putIfAbsent("Harold", 8) + " : " + m);

        // put always updates the Harold value
        System.out.println("put(Harold, 100) : " +
                m.put("Harold", 100) + " : " + m);

        // putIfAbsent will not update Harold if it exists
        System.out.println("putIfAbsent(Harold, 200) : " +
                m.putIfAbsent("Harold", 200) + " : " + m);

        // putIfAbsent will insert Maggie with value of 200
        System.out.println("putIfAbsent(Maggie, 200) : " +
                m.putIfAbsent("Maggie", 200) + " : " + m);

    }


    private static void testComputes(Map<String, Integer> m) {
        System.out.println("Original State: " + m);
        // If John exist and value is not null, apply function
        System.out.println(m.compute("John",
                (key, val) ->
                {
                    System.out.println("key: " + key + "; val:" + val);
                    return (val == null) ? 0 : val * 100;
                }
        ));


        BiFunction<String, Integer, Integer> biFunction = (key, val) -> (val == null) ? 0 : val * 100;


        System.out.println("compute(John, val*100): " + m);
        System.out.println();

        try {
            // Ilene does not exist
            m.compute("Ilene", (key, val) -> {
                System.out.println("key: " + key + "; val:" + val);
                return (val == null) ? 0 : val * 100;
            });
            System.out.println(m);
        } catch (Exception e) {
            System.out.println("Using compute(Ilene) threw error: " + e);
        }
        System.out.println();

        try {
            m.put("John", null);
            System.out.println("Set value in John to null: " + m);
            // If value in John entry is null, NullPointer Exception thrown.
            m.compute("John", (key, val) -> (val == null) ? 0 : val * 100);
            System.out.println(m);
        } catch (Exception e) {
            System.out.println("Using compute(John) where John exist " +
                    " but has a null value threw error: " + e);
        }

        // You can use following methods without try catch...
        int defaultVal = 30;

        // Mary will get added with value result of computation
        System.out.println("\nMary gets added with value = " +
                m.computeIfAbsent("Mary", (val) -> {
                    System.out.println("-- val:" + val);
                    return defaultVal * 3;

                }));


        System.out.println("m.computeIfAbsent(Mary, (30) * 3): " + m);

        // Mary exists, no computation made, value left unchanged
        System.out.println("Mary value is unchanged = " +
                m.computeIfAbsent("Mary", (val) -> defaultVal * 3));
        System.out.println("m.computeIfAbsent(Mary, (30) * 3): " + m);

        // Mary exists, computation made and value updated
        System.out.println("\nMary gets updated using computeIfPresent" +
                " with value = " +
                m.computeIfPresent(
                        "Mary", (key, val) -> {
                            return val * 3;
                        }));
        System.out.println("m.computeIfPresent(Mary, (val) * 3): " + m);

        // Ralph does not exist, and does not get added.
        System.out.println("Ralph does not exist, computeIfPresent " +
                " does nothing = " +
                m.computeIfPresent(
                        "Ralph", (key, val) -> {
                            System.out.println("code is executed");
                            return val * 3;
                        }));
        System.out.println("m.computeIfPresent(Ralph, (val) * 3): " + m);
    }


    private static void testMerges(Map<String, Integer> m) {

        // key is an old value
        System.out.println("\nOriginal State: " + m);
        //  If Mary exists and is not null, use the function
        System.out.println("After merge(Mary,100,(oldValue, newValue) -> oldValue / 3)), return value : " +
                m.merge("Mary", 100,
                        (oldValue, newValue) ->
                        {
                            System.out.println(oldValue + "  " + newValue);
                            return (oldValue / 3);
                        }));
        System.out.println("After merge(Mary,100,oldValue/3): " + m);

        System.out.println("After put(Mary, null), return value : " +
                m.put("Mary", null));
        System.out.println("After put(Mary, null); " + m);

        // If Mary exists, and value is null, use the value, not the function
        System.out.println("After merge(Mary,100,val/3), return value : " +
                m.merge("Mary", 100, (key, val) -> val / 3));
        System.out.println("After merge(Mary,100,val/3): " + m);

        // If Mary exists, and value is not null , use the function
        System.out.println("After merge(Mary,20,val/5), return value : " +
                m.merge("Mary", 20, (key, val) -> val / 5));
        System.out.println("-After merge(Mary,33,val/5): " + m);

        // If Mary exists, and return value of the function is null, Mary
        // gets removed from map
        System.out.println("After merge(Mary,100,null), return value : " +
                m.merge("Mary", 100, (key, val) -> null));
        System.out.println("--After merge(Mary,100,null): " + m);

        // If Nat does not exist, use the value, not the function
        System.out.println("After merge(Nat,100,val*2), return value : " +
                m.merge("Nat", 100, (key, val) -> val * 2));
        System.out.println("After merge(Nat,100,val*2): " + m);

        System.out.println("After merge(Nat,150,val*2), return value : " +
                m.merge("Nat", 150, (key, val) -> val * 2));
        System.out.println("After merge(Nat,150,val*2): " + m);

        m.put("Barry", null);
        System.out.println("Set value in Barry to null: " + m);
        m.replaceAll((key, val) -> {
            if (val == null) return 0;
            else return val + 1;
        });
        System.out.println("replaceAll: null values get 0, " +
                "otherwise add 1 to existing value: " + m);


        System.out.println("-----------------");

        var map = new LinkedHashMap<Integer, String>();

        String s01 = null;
        String s02 = "One";
        // System.out.println(s01.concat(s02)); // NLP

        map.put(1, null);
        map.put(2, "TWO");
        map.put(3, "THREE");
        map.merge(1, "ONE", (s1, s2) -> {
            System.out.println(s1 + "  " + s2);
            return s1.concat(s2);
        }); // Line n1
        map.merge(2, "2-", (s1, s2) -> s2 + ":" + s1); // Line n2
        map.merge(3, "3-", (s1, s2) -> null); // Line n3
        System.out.println(map);

        System.out.println("-----------------");
        var map2 = new LinkedHashMap<String, String>();
        map2.put("1", null);
        map2.put("2", "John");
        map2.put("3", "Evelyn");
        map2.merge("1", "Harper", String::concat); // Line n1
        map2.merge("2", "Lucy", (s1, s2) -> s2 + ":" + s1); // Line n2
        map2.merge("3", "Juliet", (s1, s2) -> s1.concat(":").concat(s2)); // Line n3
        System.out.println(map2);


    }

}