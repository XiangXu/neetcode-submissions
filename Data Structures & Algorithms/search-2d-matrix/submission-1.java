class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int COLUMN = matrix[0].length;
        int ROW = matrix.length;

        int top = 0;
        int bottom = ROW - 1;
        // This is to identify which row target value is in
        while(top <= bottom) {
            int row = top + (bottom - top) / 2;
            if(target > matrix[row][COLUMN - 1]) {
                top = row + 1;
            }
            else if(target < matrix[row][0]) {
                bottom = row - 1;
            }
            else {
                // the target must be in this row
                break;
            }
        }

        if(top > bottom) {
            return false;
        }

        int row = top + (bottom - top) / 2;
        int left = 0;
        int right = COLUMN - 1;
        while(left <= right) {
            int middle = left + (right - left) / 2;
            if(target > matrix[row][middle]) {
                left = middle + 1;
            }
            else if(target < matrix[row][middle]) {
                right = middle - 1;
            }
            else {
                return true;
            }
        }

        return false;
    }
}
