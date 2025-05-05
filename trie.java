// // Barnaby loved finding hidden words in his big storybook. He had a special list of his favorite words.
// // For each favorite word he found in the story, he would write down where it began and where it ended.
// // Can you help Barnaby find all his favorite words and their starting and ending spots in the storybook?

// // Example 1:
// // ----------
// // input= 
// // thestoryofleetcodeandme
// // story fleet leetcode

// // Output=
// // 3 7
// // 9 13 
// // 10 17

// // Example 2:
// // ----------
// // input= 
// // ababa
// // aba ab
// // output=
// // 0 1 
// // 0 2 
// // 2 3
// // 2 4

// // Explanation: 
// // Notice that matches can overlap, see "aba" is found in [0,2] and [2,4].

// // Note: Input formate is string and followed by substring ,
// //       Output print starting and ending index pairs.






// import java.util.ArrayList;
// import java.util.List;
// import java.util.Scanner;
// class trie{
// public int[][] indexPairs(String text, String[] words){
//     Trie trie=new Trie(); 
//     for(String s:words){
//     Trie cur=trie; 
//     for(char c:s.toCharArray()){
//     if(cur.children[c-'a']==null){
//         cur.children[c-'a']=new Trie(); 
//         } 
//         cur=cur.children[c-'a']; 
//     } 
//         cur.end=true;    
//    } 
//     int len=text.length(); 
//     List<int[]> list=new ArrayList<>(); 
//     for(int i=0;i<len;i++){
//    Trie cur=trie; 
//             char cc=text.charAt(i); 
//             int j=i; 
//             while(cur.children[cc-'a']!=null){
//                 cur=cur.children[cc-'a']; 
//                 if(cur.end){
//                     list.add(new int[]{i,j}); 
//                 } 
//                 j++; 
//                 if(j==len){
//                     break; 
//                 } 
//                 else{
//                    cc=text.charAt(j);   
//                 } 
//             } 
//         } 
//         int size=list.size(); 
//         int[][] res=new int[size][2]; 
//         int i=0; 
//         for(int[] r:list){
//             res[i]=r; 
//             i++; 
//         } 
//         return res; 
//     } 
// } 
// class Trie{
//     Trie[] children; 
//     boolean end;  
//     public Trie(){
//         end=false; 
//         children=new Trie[26]; 
//     } 

// } 
// class {
//  public static void main(String args[]){
//   Scanner sc=new Scanner(System.in); 
//   String str=sc.nextLine(); 
//   String dict[]=sc.nextLine().split(" "); 
//   int r[][]=new solution1().indexPairs(str,dict); 
//   for(int[] ans: r){
//       System.out.println(ans[0]+" "+ans[1]); 
//     } 
//    } 
// } 