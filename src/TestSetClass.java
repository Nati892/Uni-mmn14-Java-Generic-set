import java.util.Random;

public class TestSetClass {
    private static final int UPPERBOUND = 100;
    private static Random rand = new Random();
    public static final int SETSIZE = 10;

    public static void main(String[] args) {


        test3Sets();

    }


    private static void test3Sets() {
        System.out.println("testing 3 Integer sets");

        Set<Integer> set1 = new Set<Integer>();
        Set<Integer> set2 = new Set<Integer>();
        Set<Integer> set3 = new Set<Integer>();

        fillIntegerSet(set1);
        fillIntegerSet(set2);
        fillIntegerSet(set3);

        //created sets
        System.out.println("First set: " + set1);
        System.out.println("Second set: " + set2);
        System.out.println("Third set: " + set3);

        //uniting set1 and set2
        set1.union(set2);
        System.out.println("Union of set1 and set2: " + set1);

        //intersecting set1 and set3
        set1.intersect(set3);
        System.out.println("Intersect of set1 and set3: " + set1);

    }


    private static void fillIntegerSet(Set<Integer> set) {

        for (int i = 0; i < SETSIZE; i++) {//TODO make group a psfs

            //could enter duplicates, so making sure that there are SIZE amount in each grop
            while (set.size() < i + 1) {
                set.insert(rand.nextInt(UPPERBOUND));
            }


        }

    }

}

