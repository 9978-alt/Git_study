import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutiongroupAnagrams {
    
        /**
         * @param strs
         * @return
         */
        public List<List<String>> groupAnagrams(String[] strs) {

            Map<String,List<String>> map = new HashMap<>();
            List<List<String>> res = new ArrayList<>();

            for(String str:strs){
                char[] chars = str.toCharArray();
                Arrays.sort(chars);
                String sortedChar = new String(chars);
                System.out.println(sortedChar);
                List<String> list = map.getOrDefault(sortedChar,new ArrayList<>());
                list.add(str);
                map.put(sortedChar, list);
            }

            res.addAll(map.values());
            return res;

            
    }

    public static void main(String[] args) {
        SolutiongroupAnagrams solution = new SolutiongroupAnagrams();
        
        // 测试用例1: 常规情况
        String[] test1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println("测试用例1:");
        printResult(solution.groupAnagrams(test1));
        
        // 测试用例2: 空输入
        // String[] test2 = {};
        // System.out.println("\n测试用例2:");
        // printResult(solution.groupAnagrams(test2));
        
        // // 测试用例3: 单个元素
        // String[] test3 = {"a"};
        // System.out.println("\n测试用例3:");
        // printResult(solution.groupAnagrams(test3));
        
        // // 测试用例4: 多个空字符串
        // String[] test4 = {"", "", ""};
        // System.out.println("\n测试用例4:");
        // printResult(solution.groupAnagrams(test4));
    }

    private static void printResult(List<List<String>> result) {
        for (List<String> group : result) {
            System.out.println(group);
        }
    }
}
