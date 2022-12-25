package qiang.hu.leetcode.solution;

/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 * use quick sort to find the kth largest element
 */
public class LC215 {
    public int findKthLargest(int[] nums, int k) {
        return quickSort(nums, 0, nums.length - 1, nums.length - k);
    }

    private int quickSort(int[] nums, int left, int right, int k){
        if(left >= right) {
            return nums[left];
        }
        int pivot = nums[left];
        int i = left, j = right;
        while(i<j){
            while(i<j && nums[j] >= pivot){
                j--;
            }
            nums[i] = nums[j];
            while(i<j && nums[i] <= pivot){
                i++;
            }
            nums[j] = nums[i];
        }
        nums[i] = pivot;
        if( k == i) {
            return pivot;
        }
        if(k < i){
            return quickSort(nums, left, i - 1, k);
        } else {
            return quickSort(nums, i + 1, right, k);
        }
    }

    public static void main(String[] args) {
        LC215 lc215 = new LC215();
        System.out.println(lc215.findKthLargest(new int[]{3,2,1,5,6,4}, 2));
        System.out.println(lc215.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
    }
}
