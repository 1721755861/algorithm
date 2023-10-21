package heap;

/**
 *
 * 堆排序可以使用大顶堆和小顶堆，这是两种完全不同的思路
 * 大顶堆是全序
 * 小顶堆是偏序
 *
 *
 * 小顶堆可以用来处理数据很大，内存都无法加载的情况，
 *
 *
 */
public class FinalSolution {

    // 最终解法，用前k个元素构造小顶堆
    public int findKthLargest(int[] nums, int k) {
        // nums[0...k-1]建小根堆，所以j不从k开始，从最后一个节点的父节点开始往前heapify，其余基本与上个版本一致

        for(int j = (k - 2) / 2; j >= 0; j--) {
            heapify(nums, j, k);
        }


        for(int j = k; j < nums.length; ++j) {
            if(nums[0] >= nums[j]) {
                continue;
            }

            swap(nums, 0, j);
            heapify(nums, 0, k);
        }

        return nums[0];
    }


    /**
     * 调整大小为size的堆arr中的i号元素
     * @param arr 数组
     * @param i 待调整的元素的index
     * @param size 堆的大小
     */
    public void heapify(int[] arr, int i, int size){
        int left = i * 2 + 1;
        while(left < size) {
            int small = left + 1 < size && arr[left] > arr[left + 1]
                    ? left + 1 : left;

            if(arr[i] <= arr[small]) {
                break;
            }

            swap(arr,i,small);
            i = small;
            left = i * 2 + 1;
        }
    }

    public void swap(int[] nums,int a,int b){
        //本题中调用swap时已经确定a!=b，因此不用判断
        // ^异或运算符
        nums[a] ^= nums[b];
        nums[b] ^= nums[a];
        nums[a] ^= nums[b];
    }

}
