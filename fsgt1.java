// A pangram is a sentence where every letter of the English alphabet appears at least once.
// Given a string sentence containing only lowercase English letters, return true if sentence is a pangram, or false otherwise.
// Example 1:
// Input: sentence = "thequickbrownfoxjumpsoverthelazydog"
// Output: true
// Explanation: sentence contains at least one of every letter of the English alphabet.
// Example 2:
// Input: sentence = "leetcode"
// Output: false

import java.util.Scanner;

class fsgt1{

    public static boolean check(String s){
        if(s.length()<26){
            return false;
        }
        for(char ch='a';ch<='z';ch++){
            if(s.indexOf(ch)<26){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s= sc.nextLine().toLowerCase();
        if(check(s)){
            System.out.println("it is panagram");
        }
        else{
            System.out.println("Not a panagram");
        }
    }
    
}