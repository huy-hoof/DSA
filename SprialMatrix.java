import java.io.*;
import java.util.*;

class SpriralMatrix {

  static int[] spiralCopy(int[][] inputMatrix) {
    // your code goes here
    
    int n = inputMatrix.length;
    int m = inputMatrix[0].length;
    
    if (n == 1) return inputMatrix[0];
    
    ArrayList<Integer> ret = new ArrayList();
  
    int j;
    System.out.println("n: " + n);
    for (int i = 0; i < n/2; i++) {

      for (j = i; j < m - i; j++) { //top
        ret.add(inputMatrix[i][j]);
      }

      for (j = i + 1; j < n - i; j++) { //right
          ret.add(inputMatrix[j][m-1 - i]);
      }

      for (j = m-2 - i; j >= i; j--) { //bottom
         ret.add(inputMatrix[n-1 - i][j]);
      }

      for (j = n-2 - i; j > i; j--) { //left
         ret.add(inputMatrix[j][i]);
      }

    }
  
    // ret.forEach(i -> System.out.print(i + " "));
    // System.out.println();
      
    return ret.stream().mapToInt(i -> i).toArray();
  }

  public static void main(String[] args) {
    int[][] matrix = new int[][]{{1,    2,   3,  4,    5},
//{6,    7,   8,  9,   10},
//{11,  12,  13,  14,  15},
//{16,  17,  18,  19,  20},
//{116,  117,  118,  119,  120}

  };
  
    int[] ret = spiralCopy(matrix);
    
    System.out.println(Arrays.toString(ret));
  }
 

}


/*
[1,    2,   3,  4,    5],
[6,    7,   8,  9,   10],
[11,  12,  13,  14,  15],
[16,  17,  18,  19,  20]

n * m
4 * 5
1 * 5

layers = n/2
for (0 -> n/2-1) 0 -> 1 O(n/2) = O(n)
  [0][0]
  [1][1]
  printBorderNumbers(int layerIndex) {   0     1
    [layerIndex][layerIndex] -> [layerIndex][m-1 - layerIndex] //top  
    check 
    [layerIndex + 1][m-1 - layerIndex] -> [n-1 - layerIndex][m-1 - layerIndex] //right 
    check
    [n-1 - layerIndex][m-2 - layerIndex] -> [n-1 - layerIndex][layerIndex] //bottom   
    check
    [n-2 - layerIndex][layerIndex] -> [layerIndex+1][layerIndex] //left

    ArrayList.add([][])  O(1) * n*m
  }
}

*/