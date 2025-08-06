import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionPartitionLabel {

//    public List<Integer> partitionLabels(String s) {
//        // 用map存储每个字母的最后一个字符
//        char[] array = s.toCharArray();
//        Map<Character,Integer> map = new HashMap<>();
//        for (int i = 0; i < array.length; i++) {
//            map.put(array[i],i);
//        }
//
//        List<Integer> ans = new ArrayList<>();
//        int start = 0,end;
//        while (start < array.length){
//            // 找到第一个字母的最后一个出现次数
//            end = map.get(array[start]);
//            for (int i = start+1; i < end; i++) {
//                end = Math.max(end,map.get(array[i]));
//            }
//            if(end > start) ans.add(end-start+1);
//            start = end+1;
//        }
//        return ans;
//    }

    public List<Integer> partitionLabels(String s) {
        // 存储每个字母的最后一个字符
        char[] array = s.toCharArray();
        int[] chs = new int[26];
        for (int i = 0; i < array.length; i++) {
            chs[array[i]-'a'] = i;
        }
        List<Integer> ans = new ArrayList<>();
        int start=0,end = 0;
        for (int i = 0; i < array.length; i++) {
            int index = array[i]-'a';
            end = chs[index] > end?chs[index]:end;
            if(i == end){
                ans.add(end-start+1);
                start = i+1;
                end=i+1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        SolutionPartitionLabel solutionPartitionLabel = new SolutionPartitionLabel();
        List<Integer> integers = solutionPartitionLabel.partitionLabels("ababcbacadefegdehijhklij");
        integers.forEach(System.out::println);
    }

}
