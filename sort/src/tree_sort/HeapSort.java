package tree_sort;

import java.util.Arrays;

/**
 * Created by zhoujunfu on 2018/9/26.
 */
public class HeapSort {

    public static void main(String []args){
        int []arr = {4,6,8,5,9,0,1,1,0,2,99,10,-2,-1,100,-65};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void sort(int []arr){
        //1.构建大顶堆，堆的对应数组的第一个值是堆顶，所以大顶堆的对应数组的第1个值是最大值
        //从第一个非叶子结点从下至上，从右至左调整结构
        //第一个非叶子节点，就是
        for(int i=arr.length/2-1; i>=0; i--){
            //为什么从始至终没有看到建立堆？因为待排序数组是一个【完全二叉树】，需要调整将其调整成堆
            adjustHeap(arr, i, arr.length);
        }

        //2.调整堆结构+交换堆顶元素与末尾元素
        for(int j = arr.length-1; j>0; j--){
            swap(arr, 0, j);//将堆顶元素与末尾元素进行交换
            adjustHeap(arr, 0, j);//重新对堆进行调整
        }

    }

    /**
     * 调整大顶堆（仅是调整过程，建立在大顶堆已构建的基础上）
     * @param arr
     * @param i
     * @param length
     */
    public static void adjustHeap(int[] arr,int i,int length){
        int temp = arr[i];//先取出当前元素i
        for(int k=i*2+1; k<length; k=k*2+1){//从i结点的左子结点开始，也就是2i+1处开始
            if(k+1 < length && arr[k] < arr[k+1]){//如果左子结点小于右子结点，k指向右子结点
                k++;
            }
            if(arr[k] > temp){//如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
                arr[i] = arr[k];
                i = k;
            }else{
                break;
            }
        }
        arr[i] = temp;//将temp值放到最终的位置
    }

    /**
     * 交换元素
     * @param arr
     * @param a
     * @param b
     */
    public static void swap(int []arr,int a ,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
