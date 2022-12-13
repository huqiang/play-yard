package qiang.hu.sort;

public class QuickSort {
    public static void quickSort(int[] arr){
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int left, int right){
        if(left >= right){
            return;
        }

        int pivot = arr[left];
        int i = left;
        int j = right;

        while(i < j){
            while(i < j && arr[j] >= pivot){
                j--;
            }
            arr[i] = arr[j];
            while(i < j && arr[i] <= pivot){
                i++;
            }
            arr[j] = arr[i];
        }
        arr[i] = pivot;

        quickSort(arr, left, i - 1);
        quickSort(arr, i + 1, right);
    }
}
