import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;

public class NextGreatElement {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        //倒着入栈，正在出栈
        for(int i=nums.length-1; i>=0; i--){
            while(!stack.isEmpty() && stack.peek()<=nums[i]){
                // 矮个起开，反正也被挡着了。。。
                stack.pop();
            }
            res[i] = stack.isEmpty() ? -1:stack.peek();
            stack.push(nums[i]);
            ConcurrentHashMap<Integer,Integer> map  = new ConcurrentHashMap<>();
            HashMap<Integer,Integer> map1 = new HashMap<>();
            map1.remove(1);
            String a = "abc";
            System.out.println("hello,change");
            System.out.println("hot-fix remove");
            System.out.println("xiugai ");
        }
        return res;
    }
}
