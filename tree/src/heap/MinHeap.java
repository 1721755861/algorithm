package heap;

import java.util.PriorityQueue;

public class MinHeap {



    public void heapInsert(int[] a,int i){
        while(a[i] > a[(i-1)/2]){//(i-1)/2为i的父节点下标
            swap(a,i,(i-1)/2);
            i = (i-1)/2;
        }
    }
    //堆大小为heapSize的情况下向下调整i位置的数
    public void heapify(int[] a,int i,int heapSize){
        int left = 2 * i + 1;// 左孩子下标
        while(left < heapSize){
            int largest = left + 1 < heapSize && a[left] < a[left+1] ? left+1 : left;
            //找到两个孩子中更大的那个，比爹还大就交换，比爹小说明调整已完成
            if(a[i] < a[largest]) {
                swap(a, i, largest);
                i = largest;
                left = 2 * i + 1;
            }
            else
                break;
        }
    }

    public void swap(int[] nums,int a,int b){
        //本题中调用swap时已经确定a!=b，因此不用判断
        // ^异或运算符
        nums[a] ^= nums[b];
        nums[b] ^= nums[a];
        nums[a] ^= nums[b];
    }


    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();//系统默认即为小根堆
        int i = 0;
        for(; i < k; i++)
            queue.add(nums[i]);//前k个元素建堆，也可以用offer
        System.out.println(queue);

        for(; i < nums.length; i++)
            if(queue.peek() < nums[i]){//peek拿出堆顶元素比大小
//              java中没有replace操作，所以拆分成两步,移除队列头部元素再添加
                queue.poll();
                queue.add(nums[i]);
            }
        return queue.peek();
    }





    public static void main(String[] args) {
        int[] array = new int[]{2, 5, 0, 4, 1, 8, 9, 3, 6};

        int res = findKthLargest(array, 5);

        System.out.println(res);


    }

}
