import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import cs5800.sorting.comparison.InsertionSort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;


public class InsertionSortTest {

  private InsertionSort<Integer> insertionSort;
  private Comparator<Integer> naturalOrderComparator;

  @BeforeEach
  void setUp() {
    insertionSort = new InsertionSort<>();
    naturalOrderComparator = Integer::compareTo;
  }

  @Test
  void testNullArray() {
    Integer[] result = insertionSort.sort(null, naturalOrderComparator);
    assertNull(result, "Sorting null array should return null");
  }

  @Test
  void testEmptyArray() {
    Integer[] arr = {};
    Integer[] result = insertionSort.sort(arr, naturalOrderComparator);
    assertNotNull(result, "Result should not be null");
    assertEquals(0, result.length, "Empty array should remain empty");
  }

  @Test
  void testSingleElementArray() {
    Integer[] arr = {5};
    Integer[] result = insertionSort.sort(arr, naturalOrderComparator);
    assertArrayEquals(new Integer[]{5}, result, "Single element array should remain unchanged");
  }

  @Test
  void testMultipleElementArray() {
    Integer[] arr = {5, 2, 8, 1, 9};
    Integer[] result = insertionSort.sort(arr, naturalOrderComparator);
    assertArrayEquals(new Integer[]{1, 2, 5, 8, 9}, result, "Array should be sorted in ascending order");
  }

  @Test
  void testAlreadySortedArray() {
    Integer[] arr = {1, 2, 3, 4, 5};
    Integer[] result = insertionSort.sort(arr, naturalOrderComparator);
    assertArrayEquals(new Integer[]{1, 2, 3, 4, 5}, result, "Already sorted array should remain sorted");
  }

  @Test
  void testReverseSortedArray() {
    Integer[] arr = {5, 4, 3, 2, 1};
    Integer[] result = insertionSort.sort(arr, naturalOrderComparator);
    assertArrayEquals(new Integer[]{1, 2, 3, 4, 5}, result, "Reverse sorted array should be sorted correctly");
  }

  @Test
  void testArrayWithDuplicates() {
    Integer[] arr = {5, 2, 8, 2, 9, 5};
    Integer[] result = insertionSort.sort(arr, naturalOrderComparator);
    assertArrayEquals(new Integer[]{2, 2, 5, 5, 8, 9}, result, "Array with duplicates should be sorted correctly");
  }

  @Test
  void testNullComparator() {
    Integer[] arr = {5, 2, 8, 1, 9};
    assertThrows(IllegalArgumentException.class, () -> {
      insertionSort.sort(arr, null);
    }, "Should throw IllegalArgumentException when comparator is null");
  }

  @Test
  void testReverseOrderComparator() {
    Integer[] arr = {5, 2, 8, 1, 9};
    Comparator<Integer> reverseComparator = (a, b) -> b.compareTo(a);
    Integer[] result = insertionSort.sort(arr, reverseComparator);
    assertArrayEquals(new Integer[]{9, 8, 5, 2, 1}, result, "Array should be sorted in descending order");
  }

  @Test
  void testOriginalArrayNotModified() {
    Integer[] arr = {5, 2, 8, 1, 9};
    Integer[] original = arr.clone();
    insertionSort.sort(arr, naturalOrderComparator);
    assertArrayEquals(original, arr, "Original array should not be modified");
  }

  @Test
  void testWithStrings() {
    InsertionSort<String> stringSort = new InsertionSort<>();
    String[] arr = {"banana", "apple", "cherry", "date"};
    String[] result = stringSort.sort(arr, String::compareTo);
    assertArrayEquals(new String[]{"apple", "banana", "cherry", "date"}, result, "String array should be sorted alphabetically");
  }

  @Test
  void testArrayWithNegativeNumbers() {
    Integer[] arr = {-5, 3, -1, 0, 2, -8};
    Integer[] result = insertionSort.sort(arr, naturalOrderComparator);
    assertArrayEquals(new Integer[]{-8, -5, -1, 0, 2, 3}, result, "Array with negative numbers should be sorted correctly");
  }
}
