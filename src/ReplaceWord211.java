import java.util.List;
import java.util.TreeMap;

class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        //加入到字典树当中
        Trie trieMap = new Trie();
        for(String key : dictionary){
            trieMap.addWord(key);
        }
        StringBuffer sb = new StringBuffer();
        String[] words = sentence.split(" "); //返回一个字符串数组
        for(int i=0; i<words.length; i++){
            //在 Trie 树中搜索最短词根（最短前缀）
            String prefix = trieMap.shortestPrefixOf(words[i]);
            if(!prefix.isEmpty()){
                sb.append(prefix);
            }else{
                //原样放回，没有前缀
                sb.append(words[i]);
            }
            if(i != words.length- 1){
                //添加单词间的空格
                sb.append(' ');
            }
        }
        return sb.toString();
    }
}
class Trie{
    private class Node{
        private boolean isWord;
        private TreeMap<Character,Node> next;

        public Node(boolean isWord){
            this.isWord = isWord;
            next = new TreeMap<>();
        }
        public Node(){
            this(false);
        }
    }

    private Node root;
    public Trie(){
        root = new Node();
    }

    public void addWord(String key){
        Node cur = root;
        for(int i=0; i<key.length(); i++){
            char c = key.charAt(i);
            if(cur.next.get(c) == null){
                cur.next.put(c,new Node());
            }
            //指向下一个节点
            cur = cur.next.get(c);
        }
        cur.isWord = true;
    }

    //在所有的key中寻找到query字符串最短的前缀
    public String shortestPrefixOf(String query){//"cattle"
        Node cur = root;
        for(int i=0; i<query.length(); i++){
            if(cur == null){
                return "";
            }
            if(cur.isWord != false){
                return query.substring(0,i);
            }
            char c = query.charAt(i);
            cur = cur.next.get(c);
        }
        if(cur != null && cur.isWord != false){
            return query;
        }
        return "";
    }
}
