/* 59. Spiral Matrix II
Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]

*/


public class Solution {
    public int[][] generateMatrix(int n) {
        //illegal input
        if (n <= 0){
            return new int[0][0];
        }
        int[][] res = new int[n][n];
        int num = 1;
        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;
        while (true){
            for (int j = left; j <= right; j++){
                res[top][j] = num++;
            }
            top++;
            if (crossBoundary(top, bottom, left, right))
                break;
            for (int i = top; i <= bottom; i++){
                res[i][right] = num++;
            }
            right--;
            if (crossBoundary(top, bottom, left, right))
                break;
            for (int j = right; j >= left; j--){
                res[bottom][j] = num++;
            }
            bottom--;
            if (crossBoundary(top, bottom, left, right))
                break;
            for (int i = bottom; i >= top; i--){
                res[i][left] = num++;
            }
            left++;
            if (crossBoundary(top, bottom, left, right))
                break;
        }
        return res;
    }
    private boolean crossBoundary(int top, int bottom, int left, int right){
        if (top > bottom || left > right){
            return true;
        }
        return false;
    }
}
