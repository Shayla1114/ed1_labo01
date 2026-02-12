package ed.lab;
import ed.lab.SortingAlgorithms;
import java.util.Random;

public class Main {
    // Generadores con String
    private static final ArrayGenerator<String> sortedArrayGenerator = (int length) -> {
        String[] array = new String[length];
        for (int i = 0; i < length; i++) array[i] = String.valueOf(i);
        return array;
    };

    private static final ArrayGenerator<String> invertedArrayGenerator = (int length) -> {
        String[] array = new String[length];
        for (int i = 0; i < length; i++) array[i] = String.valueOf(length - i);
        return array;
    };

    private static final ArrayGenerator<String> randomArrayGenerator = (int length) -> {
        Random random = new Random();
        String[] array = new String[length];
        for (int i = 0; i < length; i++) array[i] = String.valueOf(random.nextInt(length));
        return array;
    };

    // Quicksort con String
    private static final QuickSort<String> highPivotQuickSort = SortingAlgorithms::highPivotQuickSort;
    private static final QuickSort<String> lowPivotQuickSort = SortingAlgorithms::lowPivotQuickSort;
    private static final QuickSort<String> randomPivotQuickSort = SortingAlgorithms::randomPivotQuickSort;

    // Getters con String
    public static QuickSort<String> getHighPivotQuickSort() { return highPivotQuickSort; }
    public static QuickSort<String> getLowPivotQuickSort() { return lowPivotQuickSort; }
    public static QuickSort<String> getRandomPivotQuickSort() { return randomPivotQuickSort; }
    public static ArrayGenerator<String> getSortedArrayGenerator() { return sortedArrayGenerator; }
    public static ArrayGenerator<String> getInvertedArrayGenerator() { return invertedArrayGenerator; }
    public static ArrayGenerator<String> getRandomArrayGenerator() { return randomArrayGenerator; }

    // Main con String
    public static void main(String[] args) {
        final SortingTester<String> tester = new SortingTester<>();

        System.out.println("Ordenando un arreglo ordenado:");
        System.out.println("\tUtilizando el último elemento como pivote: ");
        tester.testSorting(sortedArrayGenerator, highPivotQuickSort);
        System.out.println("\tUtilizando el primer elemento como pivote: ");
        tester.testSorting(sortedArrayGenerator, lowPivotQuickSort);
        System.out.println("\tUtilizando un elemento aleatorio como pivote: ");
        tester.testSorting(sortedArrayGenerator, randomPivotQuickSort);
        System.out.println("================================");

        System.out.println("Ordenando un arreglo invertido:");
        System.out.println("\tUtilizando el último elemento como pivote: ");
        tester.testSorting(invertedArrayGenerator, highPivotQuickSort);
        System.out.println("\tUtilizando el primer elemento como pivote: ");
        tester.testSorting(invertedArrayGenerator, lowPivotQuickSort);
        System.out.println("\tUtilizando un elemento aleatorio como pivote: ");
        tester.testSorting(invertedArrayGenerator, randomPivotQuickSort);
        System.out.println("================================");

        System.out.println("Ordenando un arreglo aleatorio:");
        System.out.println("\tUtilizando el último elemento como pivote: ");
        tester.testSorting(randomArrayGenerator, highPivotQuickSort);
        System.out.println("\tUtilizando el primer elemento como pivote: ");
        tester.testSorting(randomArrayGenerator, lowPivotQuickSort);
        System.out.println("\tUtilizando un elemento aleatorio como pivote: ");
        tester.testSorting(randomArrayGenerator, randomPivotQuickSort);
        System.out.println("================================");
    }
}

/*
highPivot y lowPivot con arreglos ordenados/invertidos son O(n²).
Por eso se redujo ARRAY_SIZE y TEST_SIZE en SortingTester, randomPivot es más rápido y estable en todos los casos
*/