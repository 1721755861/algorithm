package tree_sort;

import java.util.Arrays;

public class Quick {

    public int[] MySort (int[] arr) {
        // write code here
        quick(arr,0,arr.length-1);
        return arr;
    }

    public void quick(int[] arr,int low,int high){
        int p = partition2(arr,0,arr.length-1);
        if(low<high){
            quick(arr,low,p-1);
            quick(arr,p+1,high);
        }

    }

    public int partition2(int[] a,int low,int high){
        int pk = a[low];
        while(low < high){

            while(low < high && pk<a[high]){
                high--;
            }
            a[low]=a[high];

            while(low<high && pk>a[low]){
                low++;
            }
            a[high]=a[low];
        }
        a[low] = pk;
        return low;
    }

    public static void main(String[] args) {
        // 进行测试
        int[] a= {1,2,4,1,9,5,1,3,0,9,120,84,22};

        System.out.println(Arrays.toString(a));

        //因为high的值要作下标，所以是a.length-1
        quickSort(a,0,a.length-1);

        System.out.println(Arrays.toString(a));


    }

    //low：一般是数组起始下标，就是0
    //high：数组结束下标
    public static void quickSort(int[] a,int low,int high){
        int pivot;
        if(low<high){
            //首先需要计算出位置，
            //partition方法对序列进行排序，pivot是下标位置，不是数组元素的值            
            pivot = partition(a,low,high);

            //分割两个序列继续进行快排操作            
            quickSort(a,low,pivot-1);

            quickSort(a,pivot+1,high);
        }
    }

    //这个方法有两个作用
    // 1.返回基准值位置
    // 2.将数组进行粗略的位置调整，将小于基准值的放前面，大于基准值的放后面
    // 不仅仅是找到一个基准值，还对数组进行了分组
    public static int partition(int[] a,int low,int high){
        //把数组第1个值作为基准值
        int pivotkey=a[low];
        while(low<high){

            //从后往前找，直到找到小于pivotkey的元素
            while(high>low && a[high]>=pivotkey){
                high--;
            }

            //将元素直接赋予给左边第一个，即pivotkey所在的位置
            //a[low]的值已经在本方法的第一行储存过了，在这之后就不会再有覆盖了，
            // 因为每个值在被覆盖前已经把自己的值传走了

            //找到之后就把这个小于pivotkey的值赋值给第1位元素，然后开始从左往右找
            a[low]=a[high];
            //a[high] = pivotkey;        

            //从序列的左边开始往右遍历，直到找到大于基准值的元素  
            while(high>low && a[low]<=pivotkey){
                low++;
            }
             //找到之后就把这个比基准值大的元素移到原来从右往左找找到的那个小于pivotkey的位置上
            a[high]=a[low];
        }
        //经过以上两步，就能够找到基准值应该在的位置了
        //这一步是把pivotkey放到a[low]位置上，因为保存的话pivotkey的值就丢失了
        //而pivotkey的值最初是从a[low]来的
        a[low]=pivotkey;
        return low;
    }
}

