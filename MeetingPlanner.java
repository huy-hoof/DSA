import java.io.*;
import java.util.*;

class Solution {

  static int[] meetingPlanner(int[][] slotsA, int[][] slotsB, int dur) {
    // your code goes here
    int[] ret = new int[2];

    int[][] a = slotsA, b = slotsB;

    int i = 0;
    int j = 0;
    while (i < a.length && j < b.length) {
        if (a[i][0] >= b[j][1]) {
          j++;
          
        } else if (b[j][0] >= a[i][1]) {
          i++;
          
        } else {
      
          int start = Math.max(a[i][0], b[j][0]);
          int end = Math.min(a[i][1], b[j][1]);

          if (start + dur <= end) {
            ret[0] = start;
            ret[1] = start + dur;
            return ret;

          } else if (i+1 < a.length && a[i+1][0] < b[j][1]) {
            i++;
            
          } else if (j+1 < b.length && b[j+1][0] < a[i][1]) {
            j++;
            
          } else {
              i++;
              j++;
          }
        }
      }
    
    return new int[0];
  }
  
  public static void main(String[] args) {

  }

}