class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int right = (matrix.length * matrix[0].length) -1;
        int n = matrix[0].length;


        while (left <= right){
            int mid = (left + right)/2;
            int row = mid / n;
            int col = mid % n;

            int midNum = matrix[row][col];

            if (midNum < target){
                left = mid + 1;

            }
            else if (midNum > target){
                right = mid - 1;

            }
            else{
                return true;
            }
        }
        return false;
        



    }
}
