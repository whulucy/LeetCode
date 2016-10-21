[LeetCode] Wiggle Subsequence 摆动子序列


A sequence of numbers is called a wiggle sequence if the differences between successive numbers strictly alternate between positive and negative. The first difference (if one exists) may be either positive or negative. A sequence with fewer than two elements is trivially a wiggle sequence.

For example, [1,7,4,9,2,5] is a wiggle sequence because the differences (6,-3,5,-7,3) are alternately positive and negative. In contrast, [1,4,7,2,5] and [1,7,4,5,5] are not wiggle sequences, the first because its first two differences are positive and the second because its last difference is zero.

Given a sequence of integers, return the length of the longest subsequence that is a wiggle sequence. A subsequence is obtained by deleting some number of elements (eventually, also zero) from the original sequence, leaving the remaining elements in their original order.

Examples:
Input: [1,7,4,9,2,5]
Output: 6
The entire sequence is a wiggle sequence.

Input: [1,17,5,10,13,15,10,5,16,8]
Output: 7
There are several subsequences that achieve this length. One is [1,17,10,13,10,16,8].

Input: [1,2,3,4,5,6,7,8,9]
Output: 2
Follow up:
Can you do it in O(n) time?

Credits:
Special thanks to @agave and @StefanPochmann for adding this problem and creating all test cases.



这道题给我了我们一个数组，让我们求最长摆动子序列，关于摆动Wiggle数组，可以参见LC上之前的两道题Wiggle Sort和Wiggle Sort II。题目中给的tag说明了这道题可以用DP和Greedy两种方法来做，那么我们先来看DP的做法，我们维护两个dp数组p和q，其中pos[i]表示到i位置时首差值为正的摆动子序列的最大长度，neg[i]表示到i位置时首差值为负的摆动子序列的最大长度。我们从i=1开始遍历数组，然后对于每个遍历到的数字，再从开头位置遍历到这个数字，然后比较nums[i]和nums[j]，分别更新对应的位置，参见代码如下：



解法一：


public class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        //pos[i] 序列代表到i位置为正的最长子序列
        //neg[i] 序列代表到i位置为负的最长子序列
        int[] pos = new int[nums.length];
        int[] neg = new int[nums.length];
        for (int i = 0; i < nums.length; i++){
            pos[i] = 1;
            neg[i] = 1;
        }
        for (int i = 1; i < nums.length; i++){
            for (int j = 0; j < i; j++){
                if (nums[j] < nums[i]){
                    pos[i] = Math.max(pos[i], neg[j] + 1);
                } else if (nums[j] > nums[i]){
                    neg[i] = Math.max(neg[i], pos[j] + 1);
                }
            }
        }
        return Math.max(pos[nums.length - 1], neg[nums.length - 1]);
    }
}



题目中有个Follow up说要在O(n)的时间内完成，而Greedy算法正好可以达到这个要求，这里我们不在维护两个dp数组，而是维护两个变量p和q，然后遍历数组，如果当前数字比前一个数字大，则p=q+1，如果比前一个数字小，则q=p+1，最后取p和q中的较大值跟n比较，取较小的那个，参见代码如下：



解法二：

复制代码
class Solution {
public:
    int wiggleMaxLength(vector<int>& nums) {
        int p = 1, q = 1, n = nums.size();
        for (int i = 1; i < n; ++i) {
            if (nums[i] > nums[i - 1]) p = q + 1;
            else if (nums[i] < nums[i - 1]) q = p + 1;
        }
        return min(n, max(p, q));
    }
};
