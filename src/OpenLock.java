import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class OpenLock {
    public static void main(String[] args) {
        String[] deadends = new String[]{"0201","0101","0102","1212","2002"};
        String target = "0202";
        int count = openLock(deadends,target);
        System.out.println("最终输出结果：" + count);

    }

    public static int openLock(String[] deadends, String target) {
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        int step = 0;
        Set<String> deads = new HashSet<>();
        for(String dead : deadends){
            deads.add(dead);
        }

        q.offer("0000");
        visited.add("0000");
        while(!q.isEmpty()){
            int sz = q.size();
            for(int i=0; i<sz; i++){
                String curStr = q.poll();
                if(deads.contains(curStr)){
                    continue;
                }
                if(target.equals(curStr)){
                    return step;
                }
                for(int j=0; j<4; j++){
                    String s0 = plusOne(curStr,j);
                    if(!visited.contains(s0)){
                        q.offer(s0);
                        visited.add(s0);
                    }
                    String s1 = minusOne(curStr,j);
                    if(!visited.contains(s1)){
                        q.offer(s1);
                        visited.add(s1);
                    }
                }
            }
            step++;
        }
        return -1;
    }
    //将s[j]向上拨动一次
    public static String plusOne(String s, int j){
        char[] ch = s.toCharArray();
        if(ch[j] == '9'){
            ch[j] = '0';
        }else{
            ch[j] += 1;
        }
        return new String(ch);
    }
    //向下拨动一次
    public static String minusOne(String s, int j){
        char[] ch = s.toCharArray();
        if(ch[j] == '0'){
            ch[j] = '9';
        }else{
            ch[j] -= 1;

        }
        return new String(ch);
    }
}
