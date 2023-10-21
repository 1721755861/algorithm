package tree_sort;

import java.util.*;
public class Solution2 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 将给定数组排序
     * @param arr int整型一维数组 待排序的数组
     * @return int整型一维数组
     */
    public int[] MySort (int[] arr) {
        // write code here
        quick(arr,0,arr.length-1);
        return arr;
    }

    public static void quick(int[] a,int low,int high){
        int p;
        if(low<high){
            p = partition(a,low,high);
            quick(a,low,p-1);
            quick(a,p+1,high);
        }

    }

    public static int partition(int[] a,int low,int high){
        int pk = a[low];
        while(low < high){

            while(low<high && pk<=a[high]){
                high--;
            }
            a[low]=a[high];

            while(low<high && pk>=a[low]){
                low++;
            }
            a[high]=a[low];
        }
        a[low] = pk;
        return low;
    }

    public static void main(String[] args) {
        int[] a= {1,2,4,1,9,5,1,3,0,9,120,84,22};

        System.out.println(Arrays.toString(a));

        //因为high的值要作下标，所以是a.length-1
        quick(a,0,a.length-1);

        System.out.println(Arrays.toString(a));
    }
}