public class DriverR{
  //Printing Methods
  public static String printArray(int[] ary){
    if (ary.length == 0){
      return "[]";
    }
    String output = "[";
    for (int i = 0; i < ary.length - 1; i++){
      output += ary[i] + ", ";
    }
    return output + ary[ary.length - 1] + "]";
  }
  public static String printArray(int[][] ary){
    String output = "[\n";
    for (int x = 0; x < ary.length; x++){
      output += "  " + printArray(ary[x]);
      if (x != ary.length - 1){
       output += ",\n";
      }
      else output += "\n";
    }
    return output + "]";
  }
  public static void main(String[]args){
    int[][] a = new int[][]{
      {},
      {1, 2, 3},
      {-2, 4, 0},
      {9, -2, 5},
      {-3, 7}
    };
    int[][] b = new int[][]{
      {9, 2, -7},
      {2, 2},
      {4, 5, 8}
    };
    int[][] c = new int[][]{
      {9, 8, 7, 10},
      {6, 5, 4, 11},
      {3, 2, 1, 12}
    };
    int[][] empty = new int[][]{
      {},
      {},
      {},
      {},
      {},
    };
    int[][] magicRow = new int[][]{
      {1, 1, 1, 1, 1, 1},
      {2, -2, 2, 2, -2, -2, 6},
      {3, 3, 6, -4, -2},
      {0, 10, -5, 1}
    };
    int[][] magicRow2 = new int[][]{
      {12},
      {9, 0, 2, 1},
      {-24, 36},
      {4, 4, 2, 2, 0},
      {7, 5}
    };
    int[][] magicColumn = new int[][]{
      {8},
      {-9, 0, 3, -1, 8},
      {2, 1, 2},
      {7, 7, 3, 9}
    };
    int[][] magicColumn2 = new int[][]{
      {17, 2, 7},
      {5, -6, 12, -16},
      {-14, 10, -11, 0, 8},
      {0, 2, 0, 24}
    };
    System.out.println("\n\n--------Testing printArray(int[] ary)--------");
    System.out.println("a[1]--> Should print [1, 2, 3]: " + printArray(a[1]));
    System.out.println("b[1]--> Should print [2, 2]: " + printArray(b[1]));
    System.out.println("c[2]--> Should print [3, 2, 1, 12]: " + printArray(c[2]));
    System.out.println("empty[0]--> Should print []: " + printArray(empty[0]));
    //--------------------------------------------------------------------//
    System.out.println("\n\n--------Testing printArray(int[][] ary)--------");
    System.out.println("magicRow--> Should print [[1, 1, 1, 1, 1, 1], [2, -2, 2, 2, -2, -2, 6], [3, 3, 6, -4, -2], [0, 10, -5, 1]]: \n" + printArray(magicRow));
    System.out.println("magicColumn--> Should print [[8], [-9, 0, 3, -1, 8], [2, 1, 2], [7, 7, 3, 9]]: \n" + printArray(magicColumn));
    //--------------------------------------------------------------------//
    System.out.println("\n\n--------Phase 1 Testing--------");
    try{
      System.out.println("\n--------Testing int rowSum(int[][] ary, int x)--------");
      System.out.println("Should print 34: " + ArrayMethods.rowSum(c, 0));
      System.out.println("Should print 6: " + ArrayMethods.rowSum(a, 1));
      System.out.println("Should print 4: " + ArrayMethods.rowSum(b, 0));
      /*Commented out: Instead of an error, this should be 0
      System.out.println("\nIndex too big --> Should print printStackTrace: ");
      */
      System.out.println("Index too large--> Should print 0: " + ArrayMethods.rowSum(b,3)); //Error Testing
    }
    catch (IndexOutOfBoundsException e){
      //Should not happen!
      System.out.println("You're throwing an IndexOutOfBoundsException when the index is too large in rowSum. Return 0 instead!");
      e.printStackTrace();
    }
    //Error Testing
    /*Commented out: Mr. K will not be testing negative indices
    try{
      System.out.println("\nNegative Index --> Should print printStackTrace: ");
      System.out.println(ArrayMethods.rowSum(b, -1)); //Error Testing
    }
    catch (IllegalArgumentException e){
      e.printStackTrace();
    }
    */
    try{
      System.out.println("Empty Array: should print 0: "+ ArrayMethods.columnSum(empty,0));
    }
    catch (IndexOutOfBoundsException e){
      //Should not happen!
      e.printStackTrace();
    }
    //--------------------------------------------------------------------//
    try{
      System.out.println("\n\n--------Testing int columnSum(int[][] ary, int x)--------");
      System.out.println("Should print 18: " + ArrayMethods.columnSum(c,0));
      System.out.println("Should print 9: " + ArrayMethods.columnSum(b,1));
      System.out.println("Should print 1: " + ArrayMethods.columnSum(b,2));
      //^^^Here one of the rows is shorter than others
      System.out.println("Should print 5: " + ArrayMethods.columnSum(a,0));
      /*Commented out: Instead of an error, this should be 0
      System.out.println("\nIndex too big --> Should print printStackTrace: ");
      */
      System.out.println("Index too large--> Should print 0: " + ArrayMethods.columnSum(a, 3)); //Error Testing
    }
    catch (IndexOutOfBoundsException e){
      //Should not happen!
      System.out.println("You're throwing an IndexOutOfBoundsException when the index is too large in columnSum. Return 0 instead!");
      e.printStackTrace();
    }
    //Error Testing
    /*Commented out: Mr. K will not be testing negative indices
    try{
      System.out.println("\nNegative Index --> Should print printStackTrace: ");
      System.out.println(ArrayMethods.columnSum(a, -1)); //Error Testing
    }
    catch (IllegalArgumentException e){
      e.printStackTrace();
    }
    */
    try{
      System.out.println("Empty Array: should print 0: "+ ArrayMethods.columnSum(empty,0));
    }
    catch (IndexOutOfBoundsException e){
      //Should not happen!
      System.out.println("You're throwing an IndexOutofBoundsException when finding the columnSum of an empty array. Return 0 instead!");
      e.printStackTrace();
    }

    //--------------------------------------------------------------------//
    System.out.println("\n\n--------Phase 2 Testing--------");
    try{
      System.out.println("\n--------Testing allRowSums(int[][] ary)--------");
      System.out.println("Should print [4, 4, 17]: " + printArray(ArrayMethods.allRowSums(b)));
      System.out.println("Should print [34, 26, 18]: " + printArray(ArrayMethods.allRowSums(c)));
      System.out.println("Empty Array: should print [0, 0, 0, 0, 0]: " + printArray(ArrayMethods.allRowSums(empty)));
    }
    catch (IndexOutOfBoundsException e){
      //Should not happen!
      System.out.println("You're throwing an IndexOutOfBoundsException when running ArrayMethods.allRowSums on an empty array!");
      e.printStackTrace();
    }
    //Error Testing
    try{
      System.out.println("Should print [0, 6, 2, 12, 4]: " + printArray(ArrayMethods.allRowSums(a)));
    }
    catch (IndexOutOfBoundsException e){
      //Should not happen!
      System.out.println("You're throwing an IndexOutOfBoundsException when running ArrayMethods.allRowSums on an array containing an empty array!");
      e.printStackTrace();
    }
    //--------------------------------------------------------------------//
    try{
      System.out.println("\n--------Testing allColSums(int[][] ary)--------");
      System.out.println("Should print [18, 15, 12, 33]: " + printArray(ArrayMethods.allColSums(c)));
      System.out.println("Should print [15, 9, 1]: " + printArray(ArrayMethods.allColSums(b)));
      System.out.println("Should print [5, 11, 8]: " + printArray(ArrayMethods.allColSums(a)));
    }
    catch (IndexOutOfBoundsException e){
      //Should not happen!
      System.out.println("You're throwing an IndexOutOfBoundsException when running ArrayMethods.allColSums on an uneven array!");
      e.printStackTrace();
    }
    //--------------------------------------------------------------------//
    System.out.println("\n\n--------Phase 3 Testing--------");
    try{
      System.out.println("\n--------Testing isRowMagic(int[][] ary)--------");
      System.out.println("Should print true: " + ArrayMethods.isRowMagic(magicRow));
      System.out.println("Should print true: " + ArrayMethods.isRowMagic(magicRow2));
      System.out.println("Should print true: " + ArrayMethods.isRowMagic(empty));
      System.out.println("Should print false: " + ArrayMethods.isRowMagic(a));
      System.out.println("Should print false: " + ArrayMethods.isRowMagic(b));
      System.out.println("Should print false: " + ArrayMethods.isRowMagic(c));
    }
    catch (IndexOutOfBoundsException e){
      //Should not happen!
      System.out.println("You're throwing an IndexOutOfBoundsException when running isRowMagic");
      e.printStackTrace();
    }
    //--------------------------------------------------------------------//
    try{
      System.out.println("\n--------Testing isColumnMagic(int[][] ary)--------");
      System.out.println("Should print true: " + ArrayMethods.isColumnMagic(magicColumn));
      System.out.println("Should print true: " + ArrayMethods.isColumnMagic(magicColumn2));
      System.out.println("Should print true: " + ArrayMethods.isColumnMagic(empty));
      System.out.println("Should print false: " + ArrayMethods.isColumnMagic(a));
      System.out.println("Should print false: " + ArrayMethods.isColumnMagic(b));
      System.out.println("Should print false: " + ArrayMethods.isColumnMagic(c));
    }
    catch (IndexOutOfBoundsException e){
      //Should not happen!
      System.out.println("You're throwing an IndexOutOfBoundsException when running isColumnMagic");
      e.printStackTrace();
    }
  }
}
