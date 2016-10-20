Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

a) Insert a character
b) Delete a character
c) Replace a character


public class Solution {
    public int minDistance(String word1, String word2) {
        if (word1 == null || word1.length() == 0){
            return word2 == null ? 0 : word2.length(); //需要插入word2.length() 个元素
        }
        if (word2 == null || word2.length() == 0){
            return word1.length(); //需要删除word1.length() 个元素
        }
        int m = word1.length();
        int n = word2.length();
        // 定义： dp[i][j] 前面 word1 的 前 i 个 元素 转变为 word2 的 前 j 个 元素
        int[][] dp = new int[m  + 1][n + 1];
        for (int i = 0; i <= m; i++){
            dp[i][0] = 1 * i; //the distance of any first string to an empty second string, require i deletions
        }
        for (int j = 0; j <= n; j++){
            dp[0][j] = 1 * j; // the distance of any second string to an empty first string, require j insertions
        }
        for (int i = 1; i <= m; i++){
            for (int j = 1; j <= n; j++){
                if (word1.charAt(i - 1) == word2.charAt(j - 1)){ //off by one error
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 1, dp[i - 1][j] + 1);
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
