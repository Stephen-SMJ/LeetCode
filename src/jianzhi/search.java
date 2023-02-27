package jianzhi;

public class search {
    public static int search(int[] nums, int target) {
        int lefId = leftBinarySearch(nums,target);
        int rightId = rightBinarySearch(nums, target);
        if (lefId == -1){
            return 0;
        }
        else {
            return rightId - lefId + 1;
        }
    }
    public static int leftBinarySearch(int[] nums, int target){
        int left = 0;
        int right = nums.length-1;
        int mid = (left +  right) / 2;
        while (left <= right){
            if (target <= nums[mid]){ //二分查找当target等于mid时返回mid，但此时需要找第一个target，因此找到一个之后继续在做区间找
                right = mid - 1;
            }
            else {
                left = mid + 1; //由于是在左区间找，所以左区间的数一定都是小于等于target的，当mid小于target时一直在移动left，等于target时开始移动right
            } //因此最终返回的left就是第一个target的位置
            mid = (left + right) / 2;
        }
        if (left < nums.length && nums[left] == target){
            return left;
        }
        return -1;
    }
    public static int rightBinarySearch(int[] nums, int target){
        int left = 0;
        int right = nums.length-1;
        int mid = (left + right) / 2;
        while (left <= right){
            if (target >= nums[mid]){
                left = mid + 1;
            }
            else if (target < nums[mid]){
                right = mid - 1;
            }
            mid = (left + right) / 2;
        }
        if (right >= 0 && nums[right]==target){
            return right;
        }
        return -1;
    }
    public static int binarySearch(int[] nums, int target){
        int left = 0;
        int right = nums.length-1;
        int mid = (left +  right) / 2;
        while (left <= right){
            if (target < nums[mid]){
                right = mid - 1;
            }
            else if(target > nums[mid]){
                left = mid + 1;
            }
            else {
                return mid;
            }
            mid = (left + right) / 2;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] nums = {8,8,8,8,8,8,8,8,8,8};
        System.out.println(search.search(nums,2));
    }
}
