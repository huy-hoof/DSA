import java.util.*;

public class BinarySearch {
    public static void main(String[] args) {
	int[] nums = new int[] {-1,0,3,5,9,12};
	int target = 9;
/*
[-1,0,3,5,9,12] ; 0
[-1,0,3,5,9,12] ; 12
[-1,0,3,5,9,12] ; -1
[-1,0,3,5,9,12]; 2
[5]; -5
*/
        int ret = binarySearch(nums, 0, nums.length - 1, target);
	System.out.println(ret);
    }
    
    public static int binarySearch(int[] nums, int start, int end, int target) {
        if (end - start < 1) {
            return (nums[start] == target) ? start : -1;
        }
        
        int mid = (end - start) / 2 + start;
        
        if (nums[mid] == target)
            return mid;
        else if (nums[mid] < target)
            return binarySearch(nums, mid+1, end, target);
        else
            return binarySearch(nums, start, mid-1, target);
    }
}