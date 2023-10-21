package heap;

public class HeapBaseMethods {

    /**
     *
     * @param nums
     * @param a
     * @param b
     */
    public static void swap(int[] nums,int a,int b){
        //本题中调用swap时已经确定a != b，因此不用判断
        // ^异或运算符
        nums[a] ^= nums[b];
        nums[b] ^= nums[a];
        nums[a] ^= nums[b];
    }
}
