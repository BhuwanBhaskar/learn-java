class Array {

  public static void printArray(int[] arr) {
    int n = arr.length;
    for (int i=0; i<n; ++i)
      System.out.print(arr[i]+" ");

    System.out.println();
  }

  /**
   * Reverse array [beg, end] inplace
   * How: arr[beg] and arr[end] would be swapped
   * arr[beg] and arr[end] would be swapped
   * .........
   * arr[beg + k] and arr[end-k] would be swapped until we
   * reach a point where arr[beg+k] == arr[end-k]
   */
  public static void reverse(int[] arr, int beg, int end) {
    int start = beg, stop = end;
    while(start < stop) {
      int temp = arr[start];
      arr[start] = arr[stop];
      arr[stop] = temp;

      start++;
      stop--;
    }

    // Array.printArray(arr);
  }

  // java % operator does remainder
  public static int getMod(int n, int m) {
    return ((n%m) + m) % m;
  }

  public static void rotateBy(int[] arr, int amount) {
    System.out.print("Before Rotation: ");
    amount = (-1 * amount);

    printArray(arr);

    // [1,2,3,4,5] => Rotate Left By 2 => [3, 4, 5, 1, 2]
    // [1,2,3,4,5] => Rotate Right By 2 => [4, 5, 1, 2, 3]
    // [1,2,3,4,5] => Rotate Left By -2 (same as right) => [4, 5, 1, 2, 3]
    // [1,2,3,4,5] => Rotate Left By 3 (same as above => [4, 5, 1, 2, 3]
    // [1,2,3,4,5] => Rotate Left By 4 => [5, 1, 2, 3, 4]
    // [1,2,3,4,5] => Rotate Left By 5 => [5, 1, 2, 3, 4]
    // [1,2,3,4,5] => Rotate Left By 8 (same as left by 3 as array length is 5 so 8-5 = 3) => [4, 5, 1, 2, 3]
    // first check if amount passed is negative or greater than array length
    // if amount is negative, it means we need to do right rotation or left rotation by array + (-ve) amount
    // similarly if amount is more than array length, we need to left rotation by amount - (array length)
    // what if amount is negative and more than array length?
    // [1,2,3,4,5] => Rotate Left By -8 =>  Rotate left by (5 + (-8)) = -3 => Rotate left by 5 + (-3) = 2

    // below line is equivalent to converting negative number to positive
    // and ensuring that amount is less than  array length
    amount = Array.getMod(amount, arr.length);

    if (amount == 0) {
      return;
    }

    // We should assume now that amount would always by positive and less than array length

    // Now we can divide whole array in two parts.
    // first part would range from [0 to amount)
    // second part would range from [amount to length)
    // then we reverse both array
    // [1,2,3,4,5]
    System.out.println("Doing left rotation by amount: " + amount);
    Array.reverse(arr, 0, amount-1); // [2, 1, 3, 4, 5]
    Array.reverse(arr, amount, arr.length - 1); // [2, 1, 5, 4, 3]
    Array.reverse(arr, 0, arr.length - 1);

    System.out.print("After Rotation: ");
    printArray(arr);
    System.out.println();
  }

  public static int[] getArray() {
    int[] arr = {1,2,3,4,5,6,7};
    return arr;
  }


  public static void main(String[] args) {
    // [5,6,7,1,2,3,4]
    // Array.reverse(Array.getArray(), 0, 3);
    Array.rotateBy(Array.getArray(), 3);
    // Array.rotateBy(Array.getArray(), -2);
    // Array.rotateBy(Array.getArray(), 3);
    // Array.rotateBy(Array.getArray(), 4);
    // Array.rotateBy(Array.getArray(), 5);
    // Array.rotateBy(Array.getArray(), 8);
  }
}
