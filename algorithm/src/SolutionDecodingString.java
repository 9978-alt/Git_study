import java.util.Deque;
import java.util.LinkedList;

public class SolutionDecodingString {

    public String decodeString(String s) {
        Deque<Integer> stackNum = new LinkedList<>();
        Deque<String> stack = new LinkedList<>();
        char[] array = s.toCharArray();
        int curNum = 0;
        StringBuilder sb = new StringBuilder();
        for(char ch : array){
            if(Character.isDigit(ch)){  // 如果该字符是一个数字，那么就记录当前的数字
                curNum = curNum*10+(ch-'0');
            }else if(ch == '['){    // 如果是左括号，数字和字符串入栈
                stack.push(sb.toString());
                stackNum.push(curNum);
                curNum = 0;
                sb = new StringBuilder();
            }else if (ch == ']'){
                //  取出最近的字符和数字进行遍历
                int repeat = stackNum.pop();
                String popString = stack.pop();
                StringBuilder prev = new StringBuilder(popString);
                while (repeat>0){
                    prev.append(sb.toString());
                    repeat--;
                }
                sb = prev;
            }else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

}
