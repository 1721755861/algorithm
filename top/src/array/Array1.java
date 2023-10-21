package array;
import java.util.*;
public class Array1 {
    /**
     *
     * @param numbers int整型一维数组
     * @param target int整型
     * @return int整型一维数组
     */
    public int[] twoSum (int[] numbers, int target) {
        // write code here
        //第一个是值，第二个是下标
        int[] ans = new int[2];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<numbers.length;i++){
            //先算后存，避免
            int t = target-numbers[i];
            if(map.containsKey(t)){

                //+1是因为要求下标从1开始，
                ans[0]=map.get(t)+1;
                ans[1]=i+1;
                return ans;
            }
            map.put(numbers[i],i);
        }
        return ans;


    }
}
