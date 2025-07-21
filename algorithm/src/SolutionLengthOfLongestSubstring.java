import java.util.*;

public class SolutionLengthOfLongestSubstring {
    
    public int lengthOfLongestSubstring(String s) {
        int res=0;
        Map<Character,Integer> map = new HashMap<>();
        char[] charArray = s.toCharArray();
        int start=0;

        for (int i = 0; i < charArray.length; i++) {
            // 当前子串中不包含这个字符
            if(!map.containsKey(charArray[i])){
                map.put(charArray[i], i);
                res = Math.max(res, map.keySet().size());
            }else {
                int pos = map.get(charArray[i]);
                // 将重复字符之前的字符都移出map
                while (start <=  pos) {
                    map.remove(charArray[start++]);
                }
                map.put(charArray[i], i);
            }
        }
        System.out.println(start);
        
        return res;
    }
    public static void main(String[] args) {
        SolutionLengthOfLongestSubstring solution = new SolutionLengthOfLongestSubstring();
        int res = solution.lengthOfLongestSubstring("aabaab!bb");
        System.out.println(res);
    }
}
