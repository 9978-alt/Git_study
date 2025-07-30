import java.util.ArrayList;
import java.util.List;

public class SolutionLetterCombinations {
//    public List<String> letterCombinations(String digits) {
//        List<String> ans = new ArrayList<>();
//        if(digits == null || digits.equals("")) return ans;
//        String[] values = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
//        char[] charArray = digits.toCharArray();
//        ans.add("");
//        for(char ch : charArray){
//            int index = ch-'2';
//            String letters = values[index];
//            List<String> tmp = new ArrayList<>();
//            for(String s : ans){
//                for (int i = 0; i < letters.length(); i++) {
//                    tmp.add(s+letters.charAt(i));
//                }
//            }
//            ans = tmp;
//        }
//    return ans;
//    }
    String[] values = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    List<String> ans = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.equals("")) return ans;
        traceback(digits,0,new StringBuilder());
        return ans;
    }

    private void traceback(String digits,int k,StringBuilder sb){
        if(k >= digits.length()){
            ans.add(sb.toString());
            return;
        }
        int index = digits.charAt(k)-'2';
        String value = values[index];
        for (int j = 0; j < value.length(); j++) {
            sb.append(value.charAt(j));
            traceback(digits,k+1,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }

}
