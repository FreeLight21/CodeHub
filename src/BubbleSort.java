public class BubbleSort {
    //冒泡排序
    public static void main(String[] args) {
        int[] array = {5,1,6,3,7,9};
        for(int i=array.length-1; i>0; i--){
            for(int j=0; j<i; j++){
                int temp = 0;
                if(array[j]>array[j+1]){
                    temp = array[j];
                    array[j] =  array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        for(int i=0; i<array.length; i++){
            System.out.println(array[i]);
        }
    }
}
