import java.util.Arrays;

public class MergeSortAlgo {
    public static void main(String args[]) {
      int arr[] = {10, 2, 0, 5, -1, 0, 9};

      //ms [10, 2, 0] [5, -1, 0, 9]; m = 3
      //[10]   ms [2, 0]           [5, -1] [0, 9];
      //[10]   [2] [0]
      //[10]   m [0, 2]
      //m [0, 2, 10]
      
      
      //ms [5][-1]   ms [0][9];
      //m [-1, 5]    m [0, 9];
      //m [-1, 5]    m [0, 9];
      //m [-1, 0, 5, 9]
      
      arr = mergeSort(arr);
      
      for (int a: arr) {
          System.out.println(a);
      }

    }
    
    public static int[] mergeSort(int arr[]) {
        if (arr.length == 1) return arr; //-->
        
        int m = arr.length / 2;
        int left[] = Arrays.copyOfRange(arr, 0, m);
        int right[] = Arrays.copyOfRange(arr, m, arr.length);
        
        //divide
        left = mergeSort(left);
        right = mergeSort(right);
        
        //conquer
        return merge(left, right); //-->
    }
    
    public static int[] merge(int left[], int right[]) {
        int arr[] = new int[left.length + right.length];
        
        int li = 0;
        int ri = 0;
        int ai = 0;
        
      //[10] [0, 2]
      //m [0, 2, 10]
        while (ai < arr.length) {
            if (li >= left.length) {
                //copy left over of right[]
                arr[ai++] = right[ri++];
                
            } else if (ri >= right.length) {
                //copy left over of left[]
                arr[ai++] = left[li++];

            } else if (left[li] <= right[ri]) {
                arr[ai++] = left[li++];
                
            } else {
                arr[ai++] = right[ri++];
            }

        }
        
        return arr; //-->
    }
}