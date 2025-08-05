import java.util.Deque;
import java.util.LinkedList;

public class SolutionLargestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new LinkedList<>();
        int length = heights.length;
        int res = Integer.MIN_VALUE;

        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()] ){
                Integer index = stack.pop();
                int height = heights[index];
                int width = stack.isEmpty()? i:i-stack.peek()-1;
                res = Math.max(res, width * height);
            }
            stack.push(i);
        }

        while (!stack.isEmpty()){
            Integer index = stack.pop();
            int height = heights[index];
            int width = stack.isEmpty()? length:length-stack.peek()-1;
            res = Math.max(res,height*width);

        }
        return res;
    }

    public static void main(String[] args) {
        SolutionLargestRectangleArea solution = new SolutionLargestRectangleArea();
        System.out.println(solution.largestRectangleArea(new int[]{2,3,1}));

    }
}
