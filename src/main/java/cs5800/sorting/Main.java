package cs5800.sorting;

import cs5800.sorting.comparison.InsertionSort;
import cs5800.sorting.utils.SortBenchmark;
import java.util.Comparator;

public class Main {

  public static void main(String[] args) {

    Integer[] nums = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

    InsertionSort<Integer> insertionSort = new InsertionSort<>();

    Integer[] sortedNums1 = runSortAlgorithm(nums, insertionSort, Integer::compareTo, true);

    Integer[] sortedNums2 = runSortAlgorithm(
        new Integer[]{20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1},
        insertionSort, Integer::compareTo, true);

  }

  private static <T> T[] runSortAlgorithm(T[] array, Sort<T> sortAlgorithm,
      Comparator<T> comparator, boolean showSortStatistics) {
    SortBenchmark<T> timedSortAlgorithm = new SortBenchmark<>(sortAlgorithm);
    T[] sorted = timedSortAlgorithm.sort(array, comparator);
    if (showSortStatistics) {
      printRuntime(timedSortAlgorithm);
    }
    return sorted;
  }

  private static <T> void printRuntime(SortBenchmark<T> timedSortAlgorithm) {
    System.out.println(timedSortAlgorithm.toString());
  }
}