package Three;

import java.util.HashSet;
import java.util.Set;

/*
Given a string, find the length of the longest substring without repeating characters.
分析：
就是找到一个给定字符串的最大无重复子串,我在第一次看到这个题目的时候，没能理解具体的题意，所以就先照着题解写了一遍code
 */
public class Three {
    public static void main(String[] args) {
        String s = "bbbbbbb";
        System.out.println(new Solution().lengthOfLongestSubstring(s));
    }


}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j <= n; j++)
                if (isUnique(s, i, j))
                    ans = Math.max(ans, j - i);
        return ans;
    }

    private boolean isUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            char c = s.charAt(i);
            if (set.contains(c)) return false;
            set.add(c);
        }
        return true;
    }
}