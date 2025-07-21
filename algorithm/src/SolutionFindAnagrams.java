import java.util.ArrayList;
import java.util.List;

public class SolutionFindAnagrams {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int dif=0;
        int[] arr = new int[26];
        for (int i = 0; i < p.length(); i++) {
            arr[p.charAt(i)-'a']++;
            dif++;
        }

        int left=0,right=0;
        while (right < s.length()) {
            if(arr[s.charAt(right)-'a'] > 0){   // 当前字母在子串中也存在
                dif--;
                arr[s.charAt(right)-'a']--;
                right++;
                if(dif == 0) res.add(left);
            }else{
                while (left < right && arr[s.charAt(right)-'a']<=0) {   // 当前字符在子串中不存在，移动做指针到右指针的位置
                    dif++;
                    arr[s.charAt(left)-'a']++;
                    left++;
                }
                if(arr[s.charAt(right)-'a']<=0){
                    right++;
                    left++;
                }

            }

        }
        
        return res;
    }
    public static void main(String[] args) {
        SolutionFindAnagrams solution = new SolutionFindAnagrams();
        List<Integer> list = solution.findAnagrams("aa", "bb");
        for (Integer integer : list) {
            System.out.print(integer+"\n");
        }
    }
}