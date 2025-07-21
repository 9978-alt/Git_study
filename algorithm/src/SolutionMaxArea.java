public class SolutionMaxArea {
    public int maxArea(int[] height){
        if (height.length<2) return 0;
        int res=0;
        int left=0,right=height.length-1;
        while (left < right) {
            int ans = (right-left) * Math.min(height[left],height[right]);
            res = Math.max(res,ans);
            if(height[left]<height[right]) left++;
            else right--; 
        }
        return res;
    }
    public static void main(String[] args) {
        SolutionMaxArea solution = new SolutionMaxArea();
        int area = solution.maxArea(new int[]{1,1});
        System.out.println(area);
    }
}
