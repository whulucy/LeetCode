Given two strings S and T, determine if they are both one edit distance apart.

//思路， 双指针，因为只能差一个修改距离，所以用双指针遍历分别遍历两个字符串
//如果匹配，两个字符串同时往前移动，如何不匹配，则只移动较短的字符串
//最后要注意一个字符串遍历结束，另外一个字符串还剩一位的情况

public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if (s == null || s.length() == 0){
            return t.length() == 1;
        }
        if (t == null || t.length() == 0){
            return s.length() == 1;
        }
        int lenS = s.length();
        int lenT = t.length();
        if (Math.abs(lenS - lenT) > 1)
            return false;
        int i = 0;
        int j = 0;
        int edit = 0;
        while (i < lenS && j < lenT){
            if (s.charAt(i) == t.charAt(j)){
                i++;
                j++;
            } else {
                if (lenS == lenT){
                    i++;
                    j++;
                } else if (lenS < lenT){
                    j++;
                } else {
                    i++;
                }
                edit++;
                if (edit > 1)
                    return false;
            }
        }
        if (i == lenS && j == lenT){
            return edit == 1;
        }
        if (i == lenS - 1 || j == lenT - 1){
            return edit == 0;
        }
        return false;
    }
}


/*
 * There're 3 possibilities to satisfy one edit distance apart:
 *
 * 1) Replace 1 char:
 	  s: a B c
 	  t: a D c
 * 2) Delete 1 char from s:
	  s: a D  b c
	  t: a    b c
 * 3) Delete 1 char from t
	  s: a   b c
	  t: a D b c
 */
public boolean isOneEditDistance(String s, String t) {
    for (int i = 0; i < Math.min(s.length(), t.length()); i++) {
    	if (s.charAt(i) != t.charAt(i)) {
    		if (s.length() == t.length()) // s has the same length as t, so the only possibility is replacing one char in s and t
    			return s.substring(i + 1).equals(t.substring(i + 1));
			else if (s.length() < t.length()) // t is longer than s, so the only possibility is deleting one char from t
				return s.substring(i).equals(t.substring(i + 1));
			else // s is longer than t, so the only possibility is deleting one char from s
				return t.substring(i).equals(s.substring(i + 1));
    	}
    }
    //All previous chars are the same, the only possibility is deleting the end char in the longer one of s and t
    return Math.abs(s.length() - t.length()) == 1;
}
