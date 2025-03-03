// In a mysterious manuscript, scholars have discovered a sequence S consisting of letters and numbers. 
// Your task is to analyze this sequence and determine how many distinct patterns exist.

// A pattern is a continuous segment where all characters are identical. 
// Each individual character is also considered a valid pattern.

// Input Format:
// A single string S.

// Output Format:
// Print a single integer representing the total number of distinct patterns present in S.

// Sample Input-1:
// ---------------
// paddy
 
// Sample Output-1:
// ----------------
// 6

// Explanation:
// ------------
// The words are : p, a, d, d, dd, y


// Sample Input-2:
// ---------------
// abcde

// Sample Output-2:
// ----------------
// 5

// Explanation:
// ------------
// The words are : a,b,c,d,e





import java.util.*;
class script{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        int n=s.length();
        int ans=1;
        int res=1;
        for(int i=1;i<n;i++){
            if(s.charAt(i)==s.charAt(i-1)){
                ans++;
            }
            else ans=1;
            res+=ans;
        }
        System.out.print(res);
    }
}