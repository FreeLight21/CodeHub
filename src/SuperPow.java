import java.util.*;


public class SuperPow {
    static int base = 1337;
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Scanner s = new Scanner(System.in);
        int count = s.nextInt();
        System.out.println(count);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Stack<Integer> stack = new Stack<>();
        pq.add(1);
    }

    public static int superp(int a, LinkedList<Integer> list){
        if(list.isEmpty()){
            return 1;
        }
        int last = list.getLast();
        list.removeLast();
        int part1 = mypow(a,last);
        int part2 = mypow(superp(a,list),10);
        return part1*part2;

    }

    public static int mypow(int a, int k){
        a %= base;
        int res = 1;
        for(int i=0; i<k;  i++){
            res *= a;
            res %= base;
        }
        return res;
    }
}
