public class Sort {

  // Prints the array
  static void printArray(int arr[]) {
    int n = arr.length;
    for (int i=0; i<n; ++i)
      System.out.print(arr[i]+" ");
    System.out.println();
  }

  static String getSubstring(String s, int beg, int end) {
    String sub = "";
    for(int i = beg; i < end; i++) {
        sub += s.charAt(i);
    }
    return sub;
  }

  // Get index of minimum element in the array
  static int indexOfMinimum(int[] arr, int start) {
    int min = arr[start];
    int minIndex = start;
    for(int ind = start + 1; ind < arr.length; ind++) {
      if (min > arr[ind]) {
        min = arr[ind];
        minIndex = ind;
      }
    }

    return minIndex;
  }

  // Sort using selection sort
  // https://www.geeksforgeeks.org/selection-sort/
  // pick minimum and place it at end of sorted array
  static void selectionSort(int[] arr) {
    // assume that first element is always at correct position
    int sortedEndIndex = 0;

    for(int ind = 0; ind < arr.length; ind++) {
      int indexOfMinInUnsorted = indexOfMinimum(arr, ind);
      // since we know our array from 0th till sortedEndIndex is sorted
      // so we need to just place it at end of sorted array by swapping

      // now swap
      if(arr[indexOfMinInUnsorted] != arr[indexOfMinInUnsorted]) {
        int temp = arr[sortedEndIndex];
        arr[sortedEndIndex] = arr[indexOfMinInUnsorted];
        arr[indexOfMinInUnsorted] = temp;
      }
      sortedEndIndex++;
    }
  }

  public static void main(String[] args) {
    int[] arr = {5,2,3,1,8,7,-6,0,45, -1};
    Sort.selectionSort(arr);
    Sort.printArray(arr);
    String sub = Sort.getSubstring("zcljvnsvuehve", 3, 7);
    System.out.println(sub);
  }
}