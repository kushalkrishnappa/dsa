package cs5800.sorting.utils;

import cs5800.sorting.Sort;

public class BenchmarkEntry<T> {

  private final Sort<T> sortAlgorithm;
  private final T[] givenArray;
  private final T[] sortedArray;
  private final long sortTimeNanos;
  private final double sortTimeMillis;

  public BenchmarkEntry(
      Sort<T> sortAlgorithm,
      T[] givenArray,
      T[] sortedArray,
      long sortTimeNanos,
      double sortTimeMillis) {
    this.sortAlgorithm = sortAlgorithm;
    this.givenArray = givenArray;
    this.sortedArray = sortedArray;
    this.sortTimeNanos = sortTimeNanos;
    this.sortTimeMillis = sortTimeMillis;
  }

  public String getSortAlgorithm() {
    return sortAlgorithm.getClass().getSimpleName();
  }

  public T[] getGivenArray() {
    return givenArray;
  }

  public T[] getSortedArray() {
    return sortedArray;
  }

  public long getSortTimeNanos() {
    return sortTimeNanos;
  }

  public double getSortTimeMillis() {
    return sortTimeMillis;
  }

  @Override
  public String toString() {
    return "BenchmarkEntry{" +
        "sortAlgorithm=" + getSortAlgorithm() +
        ", givenArray=" + java.util.Arrays.toString(givenArray) +
        ", sortedArray=" + java.util.Arrays.toString(sortedArray) +
        ", sortTimeNanos=" + sortTimeNanos +
        ", sortTimeMillis=" + sortTimeMillis +
        '}';
  }
}
