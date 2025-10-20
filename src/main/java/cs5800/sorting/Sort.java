package cs5800.sorting;

import java.util.Comparator;

public interface Sort<T> {

  public T[] sort(T[] array, Comparator<T> comparator);

}
