public class SelectSort {
    //最小的元素放在数组的最左边，
    public static void main(String[] args) {
        int[] arr = {3,8,1,9,10,23,11};
        for(int i=0; i<arr.length; i++){
            int min = i;
            for(int j=i+1; j<arr.length;j++){
                if(arr[min]>arr[j]){
                    min = j;
                }
            }
            //交换元素
            if(min != i){
                int temp = 0;
                temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
            }
        }
        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i]);
        }
    }

}
