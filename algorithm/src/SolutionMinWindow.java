import java.util.*;

public class SolutionMinWindow {
        public String minWindow(String s, String t) {
            if(s.length() < t.length()) return "";
            int left=0,right=0, minLen=s.length()+1,leftSub = -1;
            Map<Character,Integer> map= new HashMap<>();
            for (int i = 0; i < t.length(); i++) {
                map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0)+1);
            }
            int diff = t.length();
            while (right < s.length()) {
                char ch = s.charAt(right);
                if(map.containsKey(ch)) {    //统计字符在t中，且没有达到t中的个数
                    if(map.get(ch)>0) diff--;
                    map.put(ch, map.get(ch)-1);
                }
                right++;
                while (left < right) {
                    if(!map.containsKey(s.charAt(left))){
                        left++;
                        continue;
                    }
                    if(map.get(s.charAt(left)) < 0){
                        map.put(s.charAt(left), map.get(s.charAt(left))+1);
                        left++;
                        continue;
                    }
                    if (map.get(s.charAt(left)) >= 0){
                        break;
                    }
                }
                if(diff ==0 && right - left < minLen){
                    minLen=right-left;
                    leftSub = left;
                }
            }
            return leftSub>=0?s.substring(leftSub, leftSub+minLen):"";
        }
        public static void main(String[] args) {
            String s = "AA",t = "AA";
            SolutionMinWindow solution = new SolutionMinWindow();
            System.out.println(solution.minWindow(s, t));
        }
}