import java.util.LinkedList;
import java.util.List;

public class GenerateParenthesis {
    static LinkedList<String> str = new LinkedList<>();
    static List<String> ans = new LinkedList<>();
    public static void main(String[] args) {
        int n = 3;
        List<String> res = generateParenthesis(n);
        for(String v : res){
            System.out.println(v);
        }
    }

    public static List<String> generateParenthesis(int n) {
        backTrace(n,n,str);
        return ans;
    }

    //可用的左括号数量为 left 个，可用的右括号数量为 right 个
    private static void backTrace(int left, int right, LinkedList<String> str){

        if(right<left){
            return;
        }

        if(right < 0 || left <0) return;

        if(left == 0 && right == 0){
            ans.add(str.toString());
            return;
        }

        str.add("(");
        backTrace(left-1,right,str);
        str.removeLast();

        str.add(")");
        backTrace(left,right-1,str);
        str.removeLast();

    }
}
