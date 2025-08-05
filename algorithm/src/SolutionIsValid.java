import java.util.Deque;
import java.util.LinkedList;

public class SolutionIsValid {
//    public boolean isValid(String s) {
//        int length = s.length();
//        Deque<Character> deque = new LinkedList<>();
//        char[] chars = s.toCharArray();
//        if(length % 2 !=0) return false;
//        if(chars[0] != '(' && chars[0] != '{' && chars[0] != '[') return false;
//        deque.push(chars[0]);
//        int index = 1;
//        while (!deque.isEmpty() || index < length){
//            // 如果是左括号，那么就直接入栈，如果是右括号，就出栈进行匹配
//            if(chars[index] == '(' || chars[index] == '{' || chars[index] == '['){
//                deque.push(chars[index]);
//            }else{
//                if(deque.isEmpty()) return false;
//                Character pop = deque.pop();
//                if((chars[index] == ')' && pop != '(') || (chars[index] == '}' && pop != '{') || (chars[index] == ']' && pop != '[')) return false;
//            }
//            index++;
//        }
//        return deque.isEmpty();
//    }

    public boolean isValid(String s) {
        if(s.length() %2!=0) return false;
        char[] chars = s.toCharArray();
        int top = 0;
        for(char ch:chars){
            if(ch == '(') chars[top++]=')';
            else if(ch == '{') chars[top++]='}';
            else if (ch == '[') chars[top++]=']';
            else if (top == 0 || chars[--top] != ch) return false;
        }
        return  top==0;
    }

    public static void main(String[] args) {
        SolutionIsValid solution = new SolutionIsValid();
        boolean valid = solution.isValid("(){}}{");
        System.out.println(valid);
    }
}
