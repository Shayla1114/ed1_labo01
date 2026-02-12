package ed.lab;
import java.util.Random;
public class SortingAlgorithms {
    // Quicksort - último elemento como pivote
    public static <T extends Comparable<T>> void highPivotQuickSort(T[] array) {
        quickSortHigh(array, 0, array.length - 1);
    }

    private static <T extends Comparable<T>> void quickSortHigh(T[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partitionHigh(array, low, high);
            quickSortHigh(array, low, pivotIndex - 1);
            quickSortHigh(array, pivotIndex + 1, high);
        }
    }

    private static <T extends Comparable<T>> int partitionHigh(T[] array, int low, int high) {
        T pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j].compareTo(pivot) <= 0) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high);
        return i + 1;
    }


    //Quicksort - primier elemento como pivote
    public static <T extends Comparable<T>> void lowPivotQuickSort(T[] array) {
        quickSortLow(array, 0, array.length - 1);
    }

    private static <T extends Comparable<T>> void quickSortLow(T[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partitionLow(array, low, high);
            quickSortLow(array, low, pivotIndex - 1);
            quickSortLow(array, pivotIndex + 1, high);
        }
    }
    private static <T extends Comparable<T>> int partitionLow(T[] array, int low, int high) {
        T pivot = array[low];
        int i = high + 1;

        for (int j = high; j > low; j--) {
            if (array[j].compareTo(pivot) >= 0) {
                i--;
                swap(array, i, j);
            }
        }
        swap(array, i - 1, low);
        return i - 1;
    }

    //Quicksort - pivote aleatorio
    public static <T extends Comparable<T>> void randomPivotQuickSort(T[] array) {
        quickSortRandom(array, 0, array.length - 1);
    }

    private static <T extends Comparable<T>> void quickSortRandom(T[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partitionRandom(array, low, high);
            quickSortRandom(array, low, pivotIndex - 1);
            quickSortRandom(array, pivotIndex + 1, high);
        }
    }

    private static <T extends Comparable<T>> int partitionRandom(T[] array, int low, int high) {
        int randomIndex = low + new Random().nextInt(high - low + 1);
        swap(array, randomIndex, high);
        return partitionHigh(array, low, high);
    }

    //Intercambio
    private static <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
