package ed.lab;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortingTester<T extends Comparable<T>> {
    private static final int ARRAY_SIZE = 1000;
    private static final int TEST_SIZE = 100;

    public void testSorting(ArrayGenerator<T> generator, QuickSort<T> quickSort) {
        T[] array = generator.generate(ARRAY_SIZE);

        List<Duration> durations = new ArrayList<>(TEST_SIZE);

        for (int i = 0; i < TEST_SIZE; i++) {
            T[] copy = Arrays.copyOf(array, array.length);

            final LocalDateTime start = LocalDateTime.now();

            quickSort.sort(copy);

            final LocalDateTime end = LocalDateTime.now();
            durations.add(Duration.between(start, end));
        }

        double average = durations.stream()
                .mapToLong(Duration::toMillis)
                .average()
                .orElse(0);

        /*long sum = durations.stream()
                .mapToLong(Duration::toMillis)
                .sum();*/

        long sumaTotal = durations.stream()
                .mapToLong(Duration::toMillis)
                .sum();

        System.out.printf("\t\tTiempo promedio: %s ms\n", average);
        System.out.printf("\t\tSuma de todos los tiempos: %s ms\n", sumaTotal);
    }
}
/*
ARRAY_SIZE y TEST_SIZE bajados a 1000 y 100 respectivamente porque con highPivotQuickSort y lowPivotQuickSort en arreglos
ordenados/invertidos pues la complejidad de tiempo  es O(n²) y se queda trabada la PC.
Con valores más pequeños el programa corre rápido y estable
*/