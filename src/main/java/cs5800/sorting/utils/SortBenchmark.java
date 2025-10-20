package cs5800.sorting.utils;

import cs5800.sorting.Sort;
import java.util.Comparator;
import java.util.Objects;

/**
 * Decorator class that adds timing functionality to any Sort implementation. Uses the Decorator
 * pattern to wrap a Sort algorithm and measure its execution time.
 */
public class SortBenchmark<T> implements Sort<T> {

  private BenchmarkEntry<T> lastBenchmarkEntry;

  private final Sort<T> sortAlgorithm;

  public SortBenchmark(Sort<T> sortAlgorithm) {
    this.sortAlgorithm = sortAlgorithm;
    this.lastBenchmarkEntry = null;
  }

  @Override
  public T[] sort(T[] array, Comparator<T> comparator) {
    long startTime = System.nanoTime();
    T[] result = sortAlgorithm.sort(array, comparator);
    long endTime = System.nanoTime();

    createBenchmarkEntry(array, result, startTime, endTime);

    return result;
  }

  private void createBenchmarkEntry(T[] givenArray, T[] sortedArray, long startTime, long endTime) {
    this.lastBenchmarkEntry = new BenchmarkEntry<>(
        sortAlgorithm,
        givenArray,
        sortedArray,
        endTime - startTime,
        (endTime - startTime) / 1_000_000.0
    );
  }

  public BenchmarkEntry<T> getLastBenchmarkEntry() {
    if (Objects.nonNull(lastBenchmarkEntry)) {
      return lastBenchmarkEntry;
    } else {
      throw new RuntimeException(
          "There is no latest benchmark entry. Run the sort algorithm to generate the benchmark.");
    }
  }

  @Override
  public String toString() {
    return "SortBenchmark{" +
        "lastBenchmarkEntry=" + lastBenchmarkEntry.toString() +
        '}';
  }
}
