import java.util.ArrayList;
import java.util.List;

public class SolutionGenerateParenthesis {
    List<String> ans = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        traceback(0,0,new StringBuilder(),n);
        return ans;
    }

    private void traceback(int left,int right,StringBuilder sb,int n){
        if(left + right == n*2){
            ans.add(sb.toString());
            return;
        }

        if(left < n){
            sb.append('(');
            left++;
            traceback(left,right,sb,n);
            left--;
            sb.deleteCharAt(sb.length()-1);
        }
        if(right <n && right < left){
            sb.append('(');
            right++;
            traceback(left,right,sb,n);
            right--;
            sb.deleteCharAt(sb.length()-1);
        }

    }



}
