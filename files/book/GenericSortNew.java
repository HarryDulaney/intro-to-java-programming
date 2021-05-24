public class GenericSortNew {
  /** Sort an array of comparable objects */
  public static <E extends Comparable<E>> void sort(E[] list) {
    E currentMax;
    int currentMaxIndex;

    for (int i = list.length - 1; i >= 1; i--) {
      // Finds the maximum in the list[0..i]
      currentMax = list[i];
      currentMaxIndex = i;

      for (int j = i - 1; j >= 0; j--) {
        if (currentMax.compareTo(list[j]) < 0) {
          currentMax = list[j];
          currentMaxIndex = j;
        }
      }

      // Swap list[i] with list[currentMaxIndex] if necessary;
      if (currentMaxIndex != i) {
        list[currentMaxIndex] = list[i];
        list[i] = currentMax;
      }
    }
  }

  public static void main(String[] args) {
    // Create a String array
    String[] stringArray = {"Tom", "John", "Fred"};

    sort(stringArray);

    for (int i = 0; i < stringArray.length; i++)
      System.out.print(stringArray[i] + " ");
  }
}
