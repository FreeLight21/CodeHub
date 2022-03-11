public class TestBinarySearch {
    public static void main(String[] args) {
        int[]  nums = {2,3,5,7};
        int target = 8;
        int index = left_bound(nums,target);
        System.out.println("index: " + index);

    }

    private static int left_bound(int[] nums, int target){
        int left = 0, right = nums.length;
        if(nums.length == 0){return -1; }
        while(left < right){
            int mid = left + (right-left)/2;
            if(nums[mid] > target){
                right = mid;
            }else if(nums[mid] < target){
                left = mid+1;
            }else if(nums[mid] == target){
                right = mid;
            }
        }
        return left;
    }

    private static int right_bound(int[] nums, int target){
        int left = 0, right = nums.length;
        if(nums.length == 0){return -1; }
        while(left < right){
            int mid = left + (right-left)/2;
            if(nums[mid] > target){
                left = mid+1;
            }else if(nums[mid] < target){
                left = mid+1;
            }else if(nums[mid] == target){
                right = mid;
            }
        }
        return left-1;
    }


}
