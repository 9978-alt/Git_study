public class SolutionMajorityElement {
    public int majorityElement(int[] nums) {
        int num=nums[0];
        int cnt = 1;
        for (int i = 1; i < nums.length; i++) {
            if(num != nums[i] && cnt > 0){
                cnt--;
            }else if(cnt <=0){
                num = nums[i];
                cnt = 1;
            }else {
                cnt++;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        SolutionMajorityElement solutionMajorityElement = new SolutionMajorityElement();
        int i = solutionMajorityElement.majorityElement(new int[]{3, 2, 3});
        System.out.println(i);
    }
}
