package Three;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/*
Given a string, find the length of the longest substring without repeating characters.
分析：
就是找到一个给定字符串的最大无重复子串,我在第一次看到这个题目的时候，没能理解具体的题意，所以就先照着题解写了一遍code
 */
public class Three {
    public static void main(String[] args) {
        String s = "abcabc";
        System.out.println(s.length());
        System.out.println(new Solution3_2().lengthOfLongestSubstring(s));
    }
}

/**
 * 经过测试发现，s1方法的时间复杂度是 n^2，具体的推算过程是找到代码中运行次数最多的语句，分析下它的运行次数
 * 分析发现两个for循环之间的代码块运行次数最多
 * 当输入的字符串长度为n的时候，运行的次数是1 + 2 + 3 + ··· + n = n*(n+1) / 2 = O(n^2) 这样分析有问题。。。
 * 运行次数最多的地方应该是isRepeat 方法，算法的时间复杂度应该是O(n^3) ，计算的方法参考官网中暴力求解的分析
 * 思考下有咩有时间复杂度更优一点的算法呢？
 **/
class Solution1 {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        //times 记录for循环中代码运行的次数，证实下关于时间复杂度的计算
        int times = 0;
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                times++;
                String subStr = s.substring(j, i);
                if (!isRepeat(subStr)) {
                    int tempLength = Math.max(maxLength, subStr.length());
                    if (maxLength != tempLength) {
                        //输出一下子串
                        System.out.println("subStr = " + subStr);
                        maxLength = tempLength;
                    }
                }
            }
        }
        System.out.println(times);
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

class Solution2 {
    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        int ans = 0;
        Set<Character> characterSet = new HashSet<>();
        for (int i = 0, j = 0; i < length && j < length; ) {
            if (!characterSet.contains(s.charAt(j))) {
                characterSet.add(s.charAt(j++));
                System.out.println("add ->" + characterSet.toString());
                ans = Math.max(ans, j - i);
            } else {
                characterSet.removeAll(characterSet);
                System.out.println("remove ->" + characterSet.toString());
            }
        }
        return ans;
    }
}

class Solution3_1 {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;
        HashMap<Character, Integer> charToIndexMap = new HashMap<>();
        for (int i = 0, j = 0; j < n; j++) {
            if (charToIndexMap.containsKey(s.charAt(j)) && charToIndexMap.get(s.charAt(j)) >= i) {
                i = charToIndexMap.get(s.charAt(j)) + 1;
            }
            charToIndexMap.put(s.charAt(j), j);
            ans = Math.max(ans, j - i + 1);

        }
        return ans;
    }
}

class Solution3_2 {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int[] index = new int[128];
        int ans = 0;
        for (int i = 0, j = 0; j < n; j++) {
            System.out.println((int) s.charAt(j));
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }
}