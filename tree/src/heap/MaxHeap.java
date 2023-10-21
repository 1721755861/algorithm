package heap;

import static heap.HeapBaseMethods.swap;


/**
 * 大顶堆
 *
 */
public class MaxHeap {

    public void heapInsert(int[] a,int i){
        // (i-1)/2为i的父节点下标
        while(a[i] > a[(i-1) / 2]) {
            swap(a, i, (i-1) / 2);
            i = (i - 1) / 2;
        }
    }
    //堆大小为heapSize的情况下向下调整i位置的数
    public static void heapify(int[] a, int i, int heapSize){
        // 左孩子下标
        int left = 2 * i + 1;

        while(left < heapSize) {

            int largest = left + 1 < heapSize && a[left] < a[left + 1]
                    ? left + 1
                    : left;

            //找到两个孩子中更大的那个，比爹还大就交换，比爹小说明调整已完成
            if(a[i] < a[largest]) {
                swap(a, i, largest);
                i = largest;
                left = 2 * i + 1;
            } else {
                break;
            }

        }
    }


}
