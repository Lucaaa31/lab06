package it.unibo.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;


/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private UseListsAndMaps() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        List<Integer> list = new ArrayList<>();
        for(int i = 1000; i < 2000; i++){
            list.add(i);
        }
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        List<Integer> link = new LinkedList<>(List.copyOf(list));
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        int tmp = list.get(0);
        list.set(0, list.get(list.size() - 1));
        list.set(list.size() - 1, tmp);

        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        long time = System.nanoTime();
        for(int i = 0; i < 100000; i++){
            list.add(0, i);
        }

        time = System.nanoTime() - time;
        var millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(// NOPMD
            "\n\n\n Adding 100000 element at the ArrayList and took: "
                + time
                + "ns ("
                + millis
                + "ms)"
        );

        time = System.nanoTime();
        for(int i = 0; i < 100000; i++){
            link.add(i);
        }

        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(// NOPMD
            "\n Adding 100000 element at the LinkedList and took: "
                + time
                + "ns ("
                + millis
                + "ms)"
        );
        

        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        time = System.nanoTime();
        tmp = list.get(list.size()/2);
        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println("\n Numero in mezzo | ArrayList: " + time + " ns in (" + millis + "ms)");

        time = System.nanoTime();
        tmp = link.get(link.size()/2);
        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println("\n Numero in mezzo | LinkedList: " + time + " ns in (" + millis + "ms)");

        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */
        final long AFRICA= 1110635000;
        final long AMERICAS= 972005000;
        final long ANTARTICA= 0;
        final long ASIA = 4298723000L;
        final long EUROPE = 742452000;
        final long OCEANIA= 38304000;

        Map<String, Long> continenti = new HashMap<>();
        continenti.put("Africa", AFRICA);
        continenti.put("Americas", AMERICAS);
        continenti.put("Antartica", ANTARTICA);
        continenti.put("Asia", ASIA);
        continenti.put("Europe", EUROPE);
        continenti.put("Oceania", OCEANIA);


        /*
         * 8) Compute the population of the world
         */
        long population = 0;
        for (Long continentPop : continenti.values()) {
            population = population + continentPop;
        }
        System.out.println("\n Popolazione mondiale: " + population);
    }
}
