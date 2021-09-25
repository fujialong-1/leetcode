package tree;


import java.util.HashSet;
import java.util.Set;

// 前缀树
public class P208 {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("ab");
        System.out.println(trie.search("abc"));
        System.out.println(trie.search("ab"));
        System.out.println(trie.startsWith("abc"));
        System.out.println(trie.startsWith("ab"));
        //System.out.println(trie.insert("app");
        //System.out.println(trie.search("app"));
        trie.insert("ab");
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("abc"));
        trie.insert("abc");
        System.out.println(trie.search("abc"));
        System.out.println(trie.startsWith("abc"));
    }

}

class Trie {

    Set<String> stringSet;

    public Trie() {
        stringSet = new HashSet<>();
    }

    public void insert(String word) {
        stringSet.add(word);
    }

    public boolean search(String word) {
        return stringSet.contains(word);
    }

    public boolean startsWith(String prefix) {
        for (String item : stringSet) {
            if (item.startsWith(prefix)) {
                return true;
            } else {
                continue;
            }
        }
        return false;
    }
}
