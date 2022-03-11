public class TestBinarySearch {
    public static void main(String[] args) {
        int[]  nums = {1,2,2,4};
        int target = 0;
        int index = left_bound1(nums,target);
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
                right = mid;
            }else if(nums[mid] < target){
                left = mid+1;
            }else if(nums[mid] == target){
                right = mid;
            }
        }
        return left-1;
    }

    private static int left_bound1(int[] nums, int target){
        int left = 0, right = nums.length-1;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(nums[mid] > target){
                right = mid-1;
            }else if(nums[mid] < target){
                left = mid+1;
            }else if(nums[mid] == target){
                right = mid-1;
            }
        }
        //left越界， right = -1的情况，一直搜索到最左边， nums[left] != target都不是目标值，没找到，目标值比所有的值都小
        if(left >= nums.length || nums[left] != target){
            return -1;
        }
        return left;
    }

    private static int right_bound1(int[] nums, int target){
        int left = 0, right = nums.length-1;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(nums[mid] > target){
                right = mid-1;
            }else if(nums[mid] < target){
                left = mid+1;
            }else if(nums[mid] == target){
                left = mid+1;
            }
        }
        //right越界
        if(right < 0 || nums[right] != target){
            return -1;
        }
        return right;
    }



}
