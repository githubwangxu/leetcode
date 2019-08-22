package Three;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/*
Given a string, find the length of the longest substring without repeating characters.
分析：
就是找到一个给定字符串的最大无重复子串,我在第一次看到这个题目的时候，没能理解具体的题意，所以就先照着题解写了一遍code
 */
public class Three {
    public static void main(String[] args) {
        String s = " ";
        System.out.println(s.length());
        System.out.println(new Solution().lengthOfLongestSubstring(s));
    }


}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                String subStr = s.substring(j, i);
                if (!isRepeat(subStr)) {
                    maxLength = Math.max(maxLength, subStr.length());
                }

            }
        }
        return maxLength;
    }

    private boolean isRepeat(String str) {
        Set<Character> characterSet = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            if (characterSet.contains(str.charAt(i))) {
                return true;
            }
            characterSet.add(str.charAt(i));
        }
        return false;
    }
}