import java.util.Arrays;
import java.util.Scanner;

public class MeiTuanWeek10 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int x = s.nextInt();
        int y = s.nextInt();
        int[] scores = new int[n];
        for(int i=0; i<n; i++){
            scores[i] = s.nextInt();
        }
        Arrays.sort(scores);
        int min =  minScore(scores, x, y);
        System.out.println(min);
    }

    //m分数线越低，淘汰的人就越少，单调增
    public static boolean fun(int[] nums, int m, int x, int y){
        //淘汰的人数
        int count = 0;
        for(int i=0;i<nums.length; i++){
            if(nums[i] <= m){
                count++;
            }
        }
        //晋级的人数
        int  n = nums.length - count;
        if(count >= x && count <= y && n >= x && n <= y){
            return true;
        }
        return false;
    }

    //目标值在一个范围内，不是一个值的情况
    public static int minScore(int[] scores, int x, int y){
        //m的取值范围left..right,[left..  right)
        int left = scores[0], right = scores[scores.length-1];
        while(left < right){
            int mid = left + (right-left)/2;
            if(fun(scores, mid, x, y)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
}

/*

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int[] nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }
        sc.close();
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            int position = findPosition(nums, nums[i]);
            if(x<=position&&y>=position&&(n-x)>=position&&(n-y)<=position){
                System.out.println(nums[i]);
                return;
            }
        }
        System.out.println(-1);
    }
    //二分查找右边界（右边界定义：返回的数组下标值为小于target的个数），本题中返回数组下标值即为淘汰的人数
    private static int findPosition(int[] nums,int target){
        if(nums.length==0) return -1;
        int left =0;
        int right=nums.length;
        while(left<right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target){
                left=mid+1;
            }else if(nums[mid]<target){
                left=mid+1;
            }else if(nums[mid]>target){
                right=mid;
            }
        }
        return left;
    }
 */
