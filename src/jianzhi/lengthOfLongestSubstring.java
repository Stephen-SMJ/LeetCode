package jianzhi;

import java.util.Objects;

public class lengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        //dp[i] 表示当前最长不重复子串的长度
        // dp[i] = dp[i-1]+s[i] (if s[i] not in s[b,i])
        // else dp[i] = dp[i] - 重复的index
        if (Objects.equals(s, ""))
            return 0;
        int max = 1; //最大不重复长度，初始化为1，至少为1
        int res = 1; //dp[i]中当前的最大不重复长度
        int b = 0; //当前不重复字符串的起始位置，比如advaf, 当i遍历到3的时候发现a是重复的，此时b应该等于1了，后续在[1,i]中遍历
        for (int i=1; i<s.length(); i++){
            int flg = s.substring(b,i).indexOf(s.charAt(i)); //用来记录当前遍历到的字符在不重复字符串中[b:i]的位置
            if (flg == -1){
                res += 1;
                if (res > max)
                    max = res;
            }else {
                res -= flg; //当发现重复时，此位置的不重复的长度就等于当前的index - [b,i]中重复字符串的index,如adva中当i=3时，res=3-0=3，不重复长度依然为3.
                b = b + flg + 1;  //发现重复后更新b的值
            }
        }
        return max;

    }

    public static void main(String[] args) {
        String s = "advaf";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
