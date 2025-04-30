/*
In a school, the students are given an array of strings words[]. Students have to find the longest string in words[] such that every prefix of it is also in words.
For example, let words = ["a", "app", "ap","appl", "apply"]. The string "apply" has prefixes "ap","app","appl" and "a", all of which are in words.
Your task is to find and return the longest string in words as described above.
If there is more than one string with the same length, return the lexicographically
smallest one, and if no string exists, return "".

Input Format
-------------
Line1: string separated by spaces
 
Output Format
--------------
string 

Sample Input-1:
---------------
k kmi km kmit

Sample Output-1:
---------------
kmit

Explanation:
------------
"kmit" has prefixes "kmi", "km", "k" and all of them appear in words.

a
Sample Input-2:
---------------
t tanker tup tupl tu tuple tupla

Sample Output-2:
----------------
tupla

Explanation:
------------
Both "tuple" and "tupla" have all their prefixes in words.
However, "tupla" is lexicographically smaller, so we return that.


Sample Input-3:
---------------
abc bc ab abcd

Sample Output-3:
----------------
""
*/
import java.util.Scanner;

class Solution2{
    Trie root = new Trie();
    String res = "";
    public String longestWord(String[] words){
        for (String word : words) addWord(word);
        for (String word : words) searchPrefix(word);
        return res;
    }
    private void searchPrefix(String word){
        Trie node = root;
        for (char ch : word.toCharArray()){
            int idx = ch - 'a';
            if (node.children[idx] == null || !node.children[idx].isWord){
                return;
            }
            node = node.children[idx];
        }
        
        if (word.length() > res.length() || 
            (word.length() == res.length() && word.compareTo(res) < 0)){
            res = word;
        }
    }
    private void addWord(String word){
        Trie node = root;
        for (char ch : word.toCharArray()){
            int idx = ch - 'a';
            if (node.children[idx] == null){
                node.children[idx] = new Trie();
            }
            node = node.children[idx];
        }
        node.isWord = true;
    }
}
class Trie{
    Trie[] children = new Trie[26];
    boolean isWord;
    }
class LongestWord{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String dict[] = sc.nextLine().split(" ");
        System.out.println(new Solution2().longestWord(dict));
    }
}