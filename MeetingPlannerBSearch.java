import java.io.*;
import java.util.*;
import java.lang.*;

class MeetingPlannerBSearch {

  public static void main(String[] args) {
    //int [][]slotsA = {{10, 50}, {60, 120}, {140, 210}};
    //int [][]slotsB = {{0, 15}, {60, 70}};
    //int dur = 8;
    
    int [][]slotsA = {{6,12}};
    int [][]slotsB = {{2,11}};
    int dur = 5;

    int [] ret = meetingPlanner(slotsA, slotsB, dur);

    System.out.print(Arrays.toString(ret));
  }
  
  public static int[] meetingPlanner(int[][] slotsA, int[][] slotsB, int dur) {
    // your code goes here
    
    int[] ret = new int[2];

    int[][] a = slotsA, b = slotsB;
    if (slotsA.length < slotsB.length) {
      a = slotsB;
      b = slotsA;
    }
      
    for (int i = 0; i < b.length; i++) {
      if (b[i][0] < a[0][0] || b[i][0] > a[a.length-1][1])
        continue;
      
      int aIndex = binarySearchFindStart(a, b[i][0], 0, a.length-1);
      if (aIndex < 0) {
        continue;
        
      } else {
        int start = Math.max(a[aIndex][0], b[i][0]);
        int end = start + dur;
        if (end > a[aIndex][1] || end > b[i][1]) {
          continue;
            
        } else {
          ret[0] = start;
          ret[1] = end;
          return ret;
        }
      }
    }
    
    return new int[0];
  }
  
  public static int binarySearchFindStart(int[][]a, int b, int start, int end) {
    if (end - start == 1) {
      if (a[start][0] <= b) {
        return start;
      } else {
        return -1;
      }
    }
      
    int mid = (end - start) / 2;
    
    if (a[mid][0] == b) {
      return mid;
    } else if (a[mid][0] < b) {
      binarySearchFindStart(a, b, mid, end);
    } else {
      binarySearchFindStart(a, b, start, mid);
    }
  
    return -1;
  }

}