//---------------Problem Description--------------------

/*
Given a string, find the length of the longest substring T that contains at most 2 distinct characters.

For example, Given s = “eceba”,

T is "ece" which its length is 3.
*/

/*
The main idea is to maintain a sliding window with 2 unique characters.
The key is to store the last occurrence of each character as the value in the hashmap.
This way, whenever the size of the hashmap exceeds 2,
we can traverse through the map to find the character with the left most index,
and remove 1 character from our map. Since the range of characters is constrained,
we should be able to find the left most index in constant time.
*/
public class Solution {
  public int lengthOfLongestSubstringTwoDistinct(String s) {
      //The main idea is to save the last occurrence of each character in the map, whenever the size of the HashMap
      //exceeds 2, remove the leftmost character in the map, and update the start to be leftmost character index + 1
      if (s == null || s.length() == 0){
          return 0;
      }
      int start = 0, end = 0, maxLen = 0;
      HashMap<Character, Integer> index = new HashMap<Character, Integer>();
      while (end < s.length()){
          if (index.size() <= 2){
              index.put(s.charAt(end), end);
              end++;
          }
          if (index.size() > 2){
              int leftMost = s.length();
              for (int i : index.values()){
                  leftMost = Math.min(leftMost, i);
              }
              char c = s.charAt(leftMost);
              index.remove(c);
              start = leftMost + 1;
          }
          maxLen = Math.max(maxLen, end - start);
      }
      return maxLen;
  }
}
