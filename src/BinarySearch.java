public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,4,7,8,9,10,17};
        int index = binarySearch(arr,10);
        System.out.println(index == -1 ? "元素不存在":"元素下标是"+index);
    }
    private static int binarySearch(int[] src, int dest){
        //二分法的边界怎么确定
        int begin = 0;
        int end = src.length-1;
        while(begin<=end){
            int mid = (begin+end)/2;
            if(src[mid] == dest){
                return mid;
            }else if(src[mid]>dest){
                end = mid-1;
            }else{
                begin = mid+1;
            }
        }
        return -1;
    }
}
