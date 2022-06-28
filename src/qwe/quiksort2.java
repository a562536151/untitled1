package qwe;

import java.util.Arrays;

public class quiksort2 {
        /**
         * 截止范围
         */
        private static final int CUTOFF = 10;

        public static void main(String[] args) {
            Integer[] a = {8, 1, 4, 9, 6, 3, 5, 2, 7, 0};
            System.out.println("快速排序前：" + Arrays.toString(a));
            quicksort(a);
            System.out.println("快速排序后：" + Arrays.toString(a));
        }

        public static <T extends Comparable<? super T>> void quicksort(T[] a) {
            quicksort(a, 0, a.length - 1);
        }

        private static <T extends Comparable<? super T>> void quicksort(T[] a, int left, int right) {
            if (left + CUTOFF <= right) {
                //三数中值分割法获取枢纽元
                T pivot = median3(a, left, right);

                // 开始分割序列
                int i = left, j = right - 1;
                for (; ; ) {
                    while (a[++i].compareTo(pivot) < 0) {
                    }
                    while (a[--j].compareTo(pivot) > 0) {
                    }
                    if (i < j) {
                        swapReferences(a, i, j);
                    } else {
                        break;
                    }
                }
                //将枢纽元与位置i的元素交换位置
                swapReferences(a, i, right - 1);
                //排序小于枢纽元的序列
                quicksort(a, left, i - 1);
                //排序大于枢纽元的序列
                quicksort(a, i + 1, right);
            } else {
                //插入排序
                insertionSort(a, left, right);
            }
        }

        private static <T extends Comparable<? super T>> T median3(T[] a, int left, int right) {
            int center = (left + right) / 2;
            if (a[center].compareTo(a[left]) < 0) {

                swapReferences(a, left, center);
            }
            if (a[right].compareTo(a[left]) < 0) {
                swapReferences(a, left, right);
            }
            if (a[right].compareTo(a[center]) < 0) {
                swapReferences(a, center, right);
            }
            // 将枢纽元放置到right-1位置
            swapReferences(a, center, right - 1);
            return a[right - 1];
        }

        public static <T> void swapReferences(T[] a, int index1, int index2) {
            T tmp = a[index1];
            a[index1] = a[index2];
            a[index2] = tmp;
        }

        private static <T extends Comparable<? super T>> void insertionSort(T[] a, int left, int right) {
            for (int p = left + 1; p <= right; p++) {
                T tmp = a[p];
                int j;

                for (j = p; j > left && tmp.compareTo(a[j - 1]) < 0; j--) {
                    a[j] = a[j - 1];
                }

                a[j] = tmp;
            }
        }

}
