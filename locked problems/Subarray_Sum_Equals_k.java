325. Maximum Size Subarray Sum Equals k   QuestionEditorial Solution  My Submissions
Total Accepted: 13197
Total Submissions: 31845
Difficulty: Medium
Contributors: Admin
Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.

Note:
The sum of the entire nums array is guaranteed to fit within the 32-bit signed integer range.

Example 1:
Given nums = [1, -1, 5, -2, 3], k = 3,
return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)

Example 2:
Given nums = [-2, -1, 2, 1], k = 1,
return 2. (because the subarray [-1, 2] sums to 1 and is the longest)

Follow Up:
Can you do it in O(n) time?

Show Company Tags
Show Tags
Show Similar Problems



public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return 0;
        int[] prefixSum = new int[nums.length + 1];
        //prefixSum[i] 代表前 i - 1 个数之和
        for (int i = 1; i < prefixSum.length; i++){
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1); //前面-1个元素之和是 0
        int res = 0;
        for (int i = 1; i < prefixSum.length; i++){
            if (map.containsKey(prefixSum[i] - k)){
                //update res
                int previousIndex = map.get(prefixSum[i] - k) + 1;
                res = Math.max(res, i - previousIndex);
            }
            if (map.containsKey(prefixSum[i])){
                continue;
            } else {
                map.put(prefixSum[i], i - 1);
            }
        }
        return res;
    }
}
