
/*
  Write a function to find the longest common prefix string amongst an array of strings.
*/

/*
解题思路: 先用数组的第一个字符串作为参照，每次从compare取一个character,
然后把这个character 跟数组里面剩余的其他字符串做比较，如果其他字符串也有这个character，
则将index 增加，否则，立即返回上一轮的结果
*/

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0){
            return "";
        }
        String compare = strs[0];
        int index = 0;
        while (index < compare.length()){
            char c = compare.charAt(index);
            for (int i = 1; i < strs.length; i++){
                if (strs[i].length() <= index || strs[i].charAt(index) != c)
                    return compare.substring(0, index);
            }
            index++;
        }
        return compare.substring(0, index);
    }
}
