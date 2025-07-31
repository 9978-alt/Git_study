import java.util.ArrayList;
import java.util.List;

public class SolutionPartition {
//    List<List<String>> ans = new ArrayList<>();
//    public List<List<String>> partition(String s) {
//        if(s == null || s.equals("")) return ans;
//        traceback(s,0,new ArrayList<>());
//        return ans;
//    }
//
//    private void traceback(String s,int k,List<String> list){
//        if(k==s.length()){
//            ans.add(new ArrayList<>(list));
//            return;
//        }
//        for (int i = k+1; i <= s.length(); i++) {
//            String sub = s.substring(k,i);
//            if(isPalindrome(sub)){
//                list.add(sub);
//                traceback(s,i,list);
//                list.remove(list.size()-1);
//            }
//        }
//    }
//
//    private boolean isPalindrome(String sub) {
//        int left = 0,right = sub.length()-1;
//        while (left < right){
//            if(sub.charAt(left) != sub.charAt(right)){
//                return false;
//            }
//            left++;
//            right--;
//        }
//        return true;
//    }

}
