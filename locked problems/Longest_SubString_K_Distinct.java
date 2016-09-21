//-------------------problem----------------------------------
/*
Given a string, find the length of the longest substring T that contains at most k distinct characters.

For example, Given s = “eceba” and k = 2,

T is "ece" which its length is 3.
*/

public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0){
            return 0;
        }
        int start = 0, end = 0, maxLen = 0;
        HashMap<Character, Integer> index = new HashMap<Character, Integer>();
        while (end < s.length()){
            if (index.size() <= k){
                index.put(s.charAt(end), end);
                end++;
            }
            if (index.size() > k){
                int leftMost = s.length();
                for (int i : index.values()){
                    leftMost = Math.min(leftMost, i);
                }
                char c = s.charAt(leftMost);
                index.remove(c);
                start = leftMost + 1;
            }

            //update the maxLen
            maxLen = Math.max(maxLen, end - start);
        }
        return maxLen;
    }
}
