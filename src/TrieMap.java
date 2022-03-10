import sun.awt.image.ImageWatched;

import java.util.LinkedList;
import java.util.List;

//前缀树Trie模板
public class TrieMap<V> {
    //ASCII码个数
    private static final int R = 256;
    //map中的键值个数
    private int size = 0;
    //Trie的根节点
    private TrieNode<V> root = null;
    private static class TrieNode<V>{
        public V val;
        public TrieNode[] children;

        public TrieNode (){
            val = null;
            children = new TrieNode[R];
        }

    }
    // 从节点 node 开始搜索 key，如果存在返回对应节点， null
    private TrieNode<V> getNode(TrieNode<V> node, String key) {
       TrieNode<V> p = node;
       for(int i=0; i<key.length();i++){
           if(p == null) {
               return null;
           }
           char c = key.charAt(i);
           p = p.children[c];
       }
       return p;
    }

    //crud--增删改查
    //增/改， map中添加或者修改键值对
    public void put(String key, V val){
        if(!containsKey(key)){
            size++;
        }
        root = put(root,key,val,0);
    }

    private TrieNode<V> put(TrieNode<V> node, String key, V val,int i) {
        if(node == null){
            node = new TrieNode<>();
        }
        if(i==key.length()){
            node.val = val;
            return node;
        }
        char c = key.charAt(i);
        // 递归插入子节点，并接收返回值
        node.children[c] = put(node.children[c], key, val, i + 1);
        return node;
    }

    //删除
    public void remove(String key){

    }

    //查,x不为null,只能说明字符串key是一个前缀，除非x.val !=null 才说明key是map中的键
    public V get(String key){
        TrieNode<V> x = getNode(root,key);
        if(x == null || x.val == null){
            //x 为空或 x 的 val 字段为空都说明 key 没有对应的值
            return null;
        }
        return x.val;
    }

    // 判断 key 是否存在在 Map 中
    public boolean containsKey(String key){
        return get(key) != null;
    }
    //在 Map 的所有键中搜索 query 的最短前缀
    public String shortestPrefixOf(String query){
        TrieNode<V> p = root;
        for(int i=0; i<query.length();i++){
            if(p == null){
                return "";
            }
            if(p.val != null){
                return query.substring(0,i);
            }
            char c = query.charAt(i);
            p = p.children[c];
        }
        //找到了最后一个节点,query正好是map中的键
        if(p!=null && p.val !=null){
            return query;
        }
        return "";
    }

    //在 Map 的所有键中搜索 query 的最长前缀
    //rie 树中「树枝」存储字符串，「节点」存储字符串对应的值，for 循环相当于只遍历了「树枝」，但漏掉了最后一个「节点」
    public String longestPrefixOf(String query){
        int max_len = 0;
        TrieNode<V> p = root;
        for(int i=0; i<query.length();i++){
            if(p == null){
                return "";
            }
            if(p.val != null){
                //找到一个query的前缀，更新前缀max_len的最大长度
                max_len = i;
            }
            char c = query.charAt(i);
            p = p.children[c];
        }
        //找到了最后一个节点,query正好是map中的键
        if(p!=null && p.val !=null){
            return query;
        }
        return query.substring(0,max_len);
    }

    //搜索所有前缀为 prefix 的键
    public List<String> keysWithPrefix(String prefix){
        List<String> res = new LinkedList<>();
        // 找到匹配 prefix 在 Trie 树中的那个节点
        TrieNode<V>  x = getNode(root,prefix);
        if(x == null){
            return res;
        }
        // DFS 遍历以 x 为根的这棵 Trie 树
        traverse(x,new StringBuffer(prefix),res);
        return  res;

    }

    private void traverse(TrieNode<V> node, StringBuffer path, List<String> res) {
        if(node == null) {
            //到达了Trie树底部叶子节点
            return ;
        }
        if(node.val != null){
            //找到一个key,添加到结果列表中
            res.add(path.toString());
        }
        //回溯算法的遍历框架
        for(char c=0; c<R;c++){
            //做选择,遍历多叉树的枝节
            path.append(c);
            traverse(node.children[c],path,res);
            //撤销选择
            path.deleteCharAt(path.length()-1);
        }

    }

    //是否存在前缀为 prefix 的键
    public boolean hasKeyWithPrefix(String prefix){
        return getNode(root,prefix) != null;
    }

    //通配符 . 匹配任意字符，搜索所有匹配的键
    public List<String> keysWithPattern(String pattern){
        List<String> res = new LinkedList<>();
        traverse(root,new StringBuffer(),0,pattern,res);
        return res;
    }
    //回溯算法框架，遍历函数，尝试在「以 node 为根的 Trie 树中」匹配 pattern[i..]
    private void traverse(TrieNode<V> node, StringBuffer path, int i, String pattern, List<String> res) {
        if(root == null){
            return;
        }
        //匹配完成了
        if(i == pattern.length()){
            if(node.val != null){
                //找到了匹配的key
                res.add(path.toString());
            }
            return;
        }
        char ch = pattern.charAt(i);
        if(ch == '.'){
            //'.'匹配所有的字符
            for(char c=0; c<R; c++){
                path.append(c);
                traverse(node.children[c],path,i+1,pattern,res);
                path.deleteCharAt(path.length()-1);
            }
        }else{
            //如果是普通字符，原样放回
            path.append(ch);
            traverse(node.children[ch],path,i+1,pattern,res);
            path.deleteCharAt(path.length()-1);
        }
    }


    // 通配符 . 匹配任意字符，判断是否存在匹配的键
    public boolean hasKeyWithPattern(String pattern){
      return hasKeyWithPattern(pattern,root,0);
    }

    private boolean hasKeyWithPattern(String pattern, TrieNode<V> node, int i) {
        if(node == null){
            return false;
        }
        if(i == pattern.length()){
            return node.val != null;
        }
        char c = pattern.charAt(i);
        //没有遇到通配符.
        if(c != '.'){
            return hasKeyWithPattern(pattern,node.children[c],i+1);
        }else{
            for(char ch=0; ch<R; ch++){
                if( hasKeyWithPattern(pattern,node.children[ch],i+1)){
                    return true;
                }
            }
        }
        //都没有匹配到
        return false;
    }

    // 返回 Map 中键值对的数量
    public int size(){
        return size;
    }

}
