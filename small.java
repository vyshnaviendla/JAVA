// The Smallest Number Challenge

// Shyam a third class boyt has been given a large number, he can remove a few digits to make it as small as possible. 

// The goal is to carefully choose which digits to remove so that the remaining number is the smallest possible.

// You must remove exactly k digits.
// The final number cannot have unnecessary leading zeros (unless it becomes "0").
// If removing k digits removes all the digits, the result should simply be "0".
// Can you figure out the best way to help shyam to  remove the digits and get the smallest possible number?
// If the result is an empty string, return 0 instead.


// input = 1432219  
// 3  
// output =1219

// Explanation:
// By removing the digits 4, 3, and 2, the smallest possible number is 1219


// Input=10200 
// 1  
// Output=200

// Explanation:
// Removing "1" results in "0200", which simplifies to "200" after removing the leading zero.


// Input="10"  
// 2  
// Output=0

// Explanation:
// All digits are removed, so the result is "0"

//if top of the stack is greater then pop the element 


import java.util.Scanner;
import java.util.Stack;

public class small{


    public static String removeKDigits(String num, int k){
        if (num.length() == k) return "0";
        Stack<Character> stack = new Stack<>();
        for (char digit : num.toCharArray()){
            while (!stack.isEmpty() && k > 0 && stack.peek() > digit){ // and operator checks all condiotions if not true all are false
                stack.pop();
                k--;
            }
            stack.push(digit);
        }
        while (k > 0 && !stack.isEmpty()){
            stack.pop();
            k--;
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()){
            result.append(stack.pop());
        }
        result.reverse();

        while (result.length() > 0 && result.charAt(0) == '0'){
            result.deleteCharAt(0);
        }

        return result.length() == 0 ? "0" : result.toString();
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String num = scanner.nextLine();
        int k = scanner.nextInt();
        String result = removeKDigits(num, k);
        System.out.println(result);

       
    }

}
//s.peek  should be greater than c

// int remove (String string,int k){
//     string="1432219";
//     k=3;
//     Stack<Character> s=new Stack<>();
//     for(char c:stringtoCharArray){
//         while(k>0 && i)
//     }

// }