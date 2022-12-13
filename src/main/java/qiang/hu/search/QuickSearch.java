package qiang.hu.search;

public class QuickSearch {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) >> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        QuickSearch quickSearch = new QuickSearch();
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = 5;
        int result = quickSearch.search(nums, target);
        System.out.println(result);
    }
}
