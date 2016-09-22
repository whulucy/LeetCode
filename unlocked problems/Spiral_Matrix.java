/* 54. Spiral Matrix
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].
*/



public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return res;
        }
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        while (true){
            //print top
            for (int j = left; j <= right; j++){
                res.add(matrix[top][j]);
            }
            top++;
            if (crossBoundary(top, bottom, left, right))
                break;
            //print rightmost
            for (int i = top; i <= bottom; i++){
                res.add(matrix[i][right]);
            }
            right--;
            if (crossBoundary(top, bottom, left, right))
                break;
            //print bottom
            for (int j = right; j >= left; j--){
                res.add(matrix[bottom][j]);
            }
            bottom--;
            if (crossBoundary(top, bottom, left, right))
                break;
            //print left
            for (int i = bottom; i >= top; i--){
                res.add(matrix[i][left]);
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
        } else {
            return false;
        }
    }
}
