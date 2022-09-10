class Solution {    
    public boolean searchMatrix(int[][] matrix, int target) {       
        //n x m
        int n = matrix.length;
        int m = matrix[0].length;
        
        if (n == 1 && m == 1) {
            return matrix[0][0] == target;
        }
        
        int start = matrixToArrayIndex(m, 0, 0);
        int end = matrixToArrayIndex(m, n-1, m-1);
    
        int ret = binarySearch(matrix, start, end, target);
                               
	    return ret != -1;
    }
    
    public int binarySearch(int[][] matrix, int start, int end, int target) {
        if (end - start < 1) {
            return (getMatrixNumAt(matrix, start) == target) ? start : -1;
        }
        
        int mid = (end - start) / 2 + start;
        
        int midNum = getMatrixNumAt(matrix, mid);
        
        if (midNum == target)
            return mid;
        else if (midNum < target)
            return binarySearch(matrix, mid+1, end, target);
        else
            return binarySearch(matrix, start, mid-1, target);
    }
                               
    public int matrixToArrayIndex(int rowLen, int i, int j) {
        //(i,j) ->:  i * rowLen + j         
        return i * rowLen + j;
    }

    public int[] arrayToMatrixIndex(int rowLen, int arrayIndex) {
        int[] matrixIndex = new int[2];
        matrixIndex[0] = arrayIndex / rowLen;
        matrixIndex[1] = arrayIndex % rowLen;
        
        return matrixIndex;
    }
                               
    public int getMatrixNumAt(int[][] matrix, int arrayIndex) {
        int[] matrixIndex = arrayToMatrixIndex(matrix[0].length, arrayIndex);
        return matrix[matrixIndex[0]][matrixIndex[1]];
    }

}