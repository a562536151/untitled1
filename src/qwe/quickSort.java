package qwe;

import java.util.Arrays;

import static java.lang.Math.random;

public class quickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{9,1,3,5,6,7,2};
        int l = 0,r = arr.length-1;

        quickSorts(arr,0,arr.length-1);
        System.out.print(Arrays.toString(arr));
    }


/*    public static void insertsort(int[] arr,int l,int r){
        for(int i = 1;i<arr.length;i++){
            int j = i;
            while(j>=1&&arr[j]<arr[j-1]){
                swap(arr,j,j-1);
                j--;
            }
        }
    }*/



    public static void quickSorts(int[] arr,int l,int r){
        if(l>=r) return;
         int i = l,j = r;
/*         if(r-l+1<=20){
             insertsort(arr,l,r);
             return;
         }
         int pivot = (int)random()%(r-l+1)+l;
         swap(arr,pivot,l);*/
        while(i<j){
            while(i<j&&arr[j]>=arr[l]) j--;
            while(i<j&&arr[i]<=arr[l]) i++;
            swap(arr,i,j);
        }
        swap(arr,i,l);
        quickSorts(arr,l,i-1);
        quickSorts(arr,i+1,r);
    }

    private static void swap(int[] arr,int i,int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
//快速排序中效率的主要来源之一是引用位置，在引用位置中，计算机硬件经过优化，因此访问彼此相邻的内存位置往往比访问分散在整个内存中的内存位置更快。quicksort中的分区步骤通常具有很好的局部性，因为它访问前面和后面附近的连续数组元素。因此，快速排序往往比其他排序算法（如heapsort）执行得更好，尽管它通常执行大致相同数量的比较和交换，因为在heapsort的情况下，访问更加分散。
//
//此外，quicksort通常比其他排序算法快得多，因为它在原地运行，而不需要创建任何辅助数组来保存临时值。与merge sort相比，这是一个巨大的优势，因为分配和释放辅助数组所需的时间是显而易见的。就地操作也提高了quicksort的位置。
//
//使用链表时，这两个优点都不一定适用。由于链表单元通常分散在整个内存中，因此访问相邻的链表单元没有额外的局部性好处。因此，quicksort的一个巨大的性能优势被消耗殆尽。类似地，就地工作的好处不再适用，因为merge sort的链表算法不需要任何额外的辅助存储空间。
//
//也就是说，快速排序在链接列表中仍然非常快。合并排序往往更快，因为它更均匀地将列表分成两半，并且每次执行合并所做的工作比执行分区步骤所做的工作更少。
