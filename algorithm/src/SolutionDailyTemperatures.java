import java.util.Deque;
import java.util.LinkedList;

public class SolutionDailyTemperatures {
//    public int[] dailyTemperatures(int[] temperatures) {
//        int length = temperatures.length;
//        int[] ans = new int[length];
//
//        for (int i = 0; i < length; i++) {
//            for (int j = i+1; j < length; j++) {
//                if(temperatures[j] > temperatures[i]){
//                    ans[i] = j-i;
//                    break;
//                }
//            }
//        }
//        return ans;
//    }


    // 单调栈
    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] ans = new int[length];

        Deque<Integer> stack  = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            int temperature = temperatures[i];
            // 栈不为空且当前元素大于栈顶元素，栈顶元素出栈
            while (!stack.isEmpty() && temperature > temperatures[stack.peek()]){
                Integer index = stack.pop();
                ans[index] = i-index;
            }
            stack.push(i);
        }
        return ans;
    }
}
