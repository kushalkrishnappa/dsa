package cs5800.sorting.comparison;

import cs5800.sorting.Sort;
import java.util.Comparator;

public class InsertionSort<T> implements Sort<T> {

  @Override
  public T[] sort(T[] array, Comparator<T> comparator) {
    // Base checks to return early
    if (array == null || array.length == 0) {
      return array;
    }

    // Check if the comparator is provided
    if (comparator == null) {
      throw new IllegalArgumentException("Comparator cannot be null");
    }

    // Create a clone to avoid altering the original array
    T[] arrCopy = array.clone();

    // Insertion sort
    for (int i = 1; i < arrCopy.length; i++) {
      T key = arrCopy[i];
      int j = i - 1;
      while (j >= 0 && comparator.compare(arrCopy[j], key) > 0) {
        arrCopy[j + 1] = arrCopy[j];
        j -= 1;
      }
      arrCopy[j + 1] = key;
    }
    return arrCopy;
  }
}
