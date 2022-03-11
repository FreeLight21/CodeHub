import java.util.ArrayList;

public class MaxHeap<E extends Comparable<E>> {
    private ArrayList<E> data;
    public MaxHeap(int capacity){
        data = new ArrayList<>(capacity);
    }

    public MaxHeap(){
        data = new ArrayList<>();
    }

    public int parent(int index){
        return (index-1)/2;
    }

    public int leftChild(int index){
        return 2*index+1;
    }

    public int rightChild(int index){
        return 2*index+2;
    }
    public int size(){
        return data.size();
    }

    public boolean isEmpty(){
        return data.isEmpty();
    }

    //整理成堆,假定这个数组是一个二叉堆，找到第一个非叶子节点(数组最后一个元素的父节点)下沉操作
    public void heapify(){
        for(int i=parent(data.size()-1); i>=0; i--){
            siftDown(i);
        }
    }
    public void add(E e){
        data.add(e);
        siftUp(data.size()-1);
    }


    public E findMax(){
        return data.get(0);
    }

    public E extractMax(){
       E ret = this.findMax();
       E last = data.get(data.size()-1);
       data.set(0,last);
       data.set(data.size()-1,ret);
       data.remove(data.size()-1);
       siftDown(0);
       return ret;
    }

    private void siftDown(int i) {
        while(leftChild(i)<data.size()){
            int j = leftChild(i);
            //右子树的值大于左子树
            if(rightChild(i) < data.size() && data.get(rightChild(i)).compareTo(data.get(leftChild(i)))>0){
                j++;
            }
            //这个位置不需要换
            if(data.get(i).compareTo(data.get(j))>0){
                break;
            }
            //data.swap(i,j);
            i = j; 
        }
    }

    private void siftUp(int i){
        while(i>0 && data.get(i).compareTo(data.get(parent(i)))>0){
            //data.swap(data.get(i),data.get(parent(i)));
            i = parent(i);
        }
    }



}
