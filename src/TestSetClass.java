import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class TestSetClass {
    private static final int UPPERBOUND = 100;
    private static Random rand = new Random();
    private static final int SETSIZE = 10;
    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);//init scanner

        test3Sets();

    }

    //TODO delete method
    private static <E> void toDel(E x, E y) {
        System.out.println(x.equals(y));


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

        Set<Integer> set4 = new Set<Integer>();
        System.out.println("Creating a 4'th set from two ints that you are going to input");

        System.out.println("input 2 numbers to a new set4");
        set4.insert(new Integer(inputNum()));
        set4.insert(new Integer(inputNum()));


        System.out.println("set4: " + set4);

        if (set1.isSubset(set4))
            System.out.println("the new set is a subset of set1");

        if (set2.isSubset(set4))
            System.out.println("the new set is a subset of set2");

        if (set3.isSubset(set4))
            System.out.println("the new set is a subset of set3");


    }


    private static void fillIntegerSet(Set<Integer> set) {

        for (int i = 0; i < SETSIZE; i++) {//TODO make group a psfs

            //could enter duplicates, so making sure that there are SIZE amount in each grop
            while (set.size() < i + 1) {
                set.insert(rand.nextInt(UPPERBOUND));
            }


        }

    }


    private static int inputNum() {
        int res = 0;
        boolean good_input = false;
        while (!good_input) {
            System.out.println("trying int");
            try {
                System.out.println("please enter an integer");
                res = Integer.parseInt(scanner.next());
                good_input = true;
            } catch (Exception e) {
                System.out.println("please re-enter integer");
            }
        }
        return res;
    }


}

