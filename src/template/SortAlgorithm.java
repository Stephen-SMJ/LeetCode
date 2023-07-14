package template;

import jianzhi.CQueue;

import java.util.Arrays;

public class SortAlgorithm {
    public static int[] bubbleSort(int[] arr){
        int n = arr.length-1; //指针只需要走到倒数第二个就行。不然arr[j+1]会outofindex
        for(int i=0; i<n; i++){
            boolean flag = false;
            for (int j=0; j<n - i; j++){ //每一轮循环，最大的数字已经被放置到末尾。因此-i
                if (arr[j] > arr[j+1]){
                    int tem = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tem;
                    flag = true;
                }
            }
            if (!flag)
                break;
        }
        return arr;
    }

    //选择排序:每个位置的元素跟后面所有元素去比，把后面最小/最大的元素替换到当前位置（一次内循环中可能有多次替换）。
     static int[] selectSort (int arr[]) {
        int n = arr.length-1;
        for(int i=0;i<=n;i++)
            for(int j=i+1;j<=n;j++)
                if(arr[i]>arr[j]){
                    int tem=arr[i];
                    arr[i]=arr[j];
                    arr[j]=tem;
                }
        return arr;
    }

    /*
    以最左边为pivot，在右边的序列中做以下：
    1.从右边开始遍历，找到一个比pivot下的数。
    2.从左边开始遍历，找到一个比pivot大的数。
    3.交换这两个数。
    4.一轮循环结束后。将pivot与遍历结束的终点进行交换（left或right），这样就保证了在pivot左边的数都比pivot小，右边的数都比pivot大。
    5.继续递归遍历pivot左边和右边的序列。
    6.递归退出条件：left>=right。
     */

    public static void quickSort(int[] arr, int left, int right){
        if (left>=right)
            return;
        int pivot = partition(arr,left,right);
        quickSort(arr,left,pivot-1); //piovt这个数已经包含在有序序列里了，因此不需要包含pivot
        quickSort(arr,pivot+1,right);
    }
    static int partition(int[] arr, int left, int right){
        int i=left;
        int pivot = arr[left];
        while(left<right){
            while(left<right && pivot<=arr[right])
                right--;
            while (left<right && pivot>=arr[left])
                left++;
            //循环结束要么找到了(left<right)，要么left=right
            if(left<right){ //left=right的情况不需要交换。
                int tmp=arr[left];
                arr[left]=arr[right];
                arr[right]=tmp;
            }
        }
        arr[i] = arr[left]; //结束时是left=right，跟哪个交换都行
        arr[left] = pivot;
        return left;
    }

    public static void mergeSort(int[] arr, int left, int right){
        if (left>=right){
            return;
        }
        int mid = (left+right)/2;
        mergeSort(arr,left,mid);
        mergeSort(arr,mid+1,right);
        merge(arr,left,mid,right);
    }

    static void merge(int[] arr, int left, int mid, int right){
        int len_l = mid-left+1;  //l:0 + r:5, mid:2
        int len_r = right-mid;
        int[] left_arr = new int[len_l];
        int[] right_arr = new int[len_r];

        for(int i=0; i<len_l; i++)
            left_arr[i] = arr[left+i]; //从left开始
        for (int j=0; j<len_r; j++)
            right_arr[j] = arr[mid+1+j]; //从right+1开始
        int i=0, j=0;
        int k=left; //开始合并的起始位置
        while (i<len_l && j<len_r){
            arr[k++] = left_arr[i] < right_arr[j] ? left_arr[i++] : right_arr[j++];
        }
        while(i<len_l)
            arr[k++] = left_arr[i++];
        while(i<len_r)
            arr[k++] = right_arr[j++];

    }


    public static void main(String[] args) {
        int[] arr = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        //System.out.println(Arrays.toString(selectSort(arr)));
        mergeSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
