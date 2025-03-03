/* 
There are N small cartoons, and each cartoon contains a balloon of a specific color, represented by an integer.

You need to pick P consecutive cartoons at a time and determine the number of unique colored balloons within that selection. 
Repeat this for each possible selection of P cartoons from the given sequence.

The total number of such selections will be (N - P + 1), and for each selection, 
you must return the count of unique balloon colors.

Input Format:
-------------
Line-1: Two space-separated integers N (total number of cartoons) and P (number of cartoons selected at a time).
Line-2: N space-separated integers, representing the color of balloons inside each cartoon.

Output Format:
---------------
Line-1: Print space-separated (N - P + 1) integers, where each integer represents the number of unique balloon colors in each selection of P cartoons.

Sample Input-1:
---------------
7 4
1 2 2 3 3 4 4

Sample Output-1:
----------------
3 2 3 2

Explanation: 
------------
The number of distinct elements in each subarray of size P goes as follows:
- nums[0:3] = [1,2,2,3] so ans[0] = 3
- nums[1:4] = [2,2,3,3] so ans[1] = 2
- nums[2:5] = [2,3,3,4] so ans[2] = 3
- nums[3:6] = [3,3,4,4] so ans[3] = 2


Sample Input-2:
---------------
6 3
1 1 1 1 1 1

Sample Output-2:
----------------
1 1 1 1

Explanation:
------------
The number of distinct elements in each subarray goes as follows:
- nums[0:2] = [1,1,1] so ans[0] = 1
- nums[1:3] = [1,1,1] so ans[1] = 1
- nums[2:4] = [1,1,1] so ans[2] = 1
- nums[3:5] = [1,1,1] so ans[3] = 1


Sample Input-3:
---------------
7 3
1 2 3 4 2 1 3

Sample Output-3:
----------------
3 3 3 3 3

*/

// import java.util.*;
// class Solution{
    
//     public int check(List<Integer> arr){
//         HashSet<Integer> set = new HashSet();
//         for(int i: arr){
//             set.add(i);
//         }
//         return set.size();
//     }
//     public static void main(String[] args){
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         int p = sc.nextInt();
//         ArrayList<Integer> arr = new ArrayList();
//         for(int i=0; i<n; i++){
//             arr.add(sc.nextInt());
//         }
        
//         ArrayList<Integer> res = new ArrayList();
        
//         Solution sol = new Solution();
//         for(int i=0; i<=arr.size()-p; i++){
//             int r = sol.check(arr.subList(i, i+p));
//             res.add(r);
//         }
        
//         for(int i: res){
//             System.out.print(i + " ");
//         }
//     }
// }

/*
 Mr.Ram is a sales manager of Dmart, for his analysis he has to monitor 
sales of Dmart every day. He need to send report of maximum sales 
of every K consecutive days from given N number of days sales.
Write a java program to do his task easy.

Input Format:
-------------
Line-1: Two space separated integers, N and K
Line-2: N space separated integers, sales[].

Output Format:
--------------
Print maximum sales of every K consecutive days


Sample Input 1:
---------------
9 3
1 2 3 1 4 5 2 3 6

Sample output 1:
----------------
3 3 4 5 5 5 6

Explanation: 
------------
Maximum of subarray {1, 2, 3} is 3
Maximum of subarray {2, 3, 1} is 3
Maximum of subarray {3, 1, 4} is 4
Maximum of subarray {1, 4, 5} is 5
Maximum of subarray {4, 5, 2} is 5
Maximum of subarray {5, 2, 3} is 5
Maximum of subarray {2, 3, 6} is 6

 */

// import java.util.*;
// class Solution{
    
//     public int max(List<Integer> arr){
//         int max=Integer.MIN_VALUE;
//         for(int i: arr){
//             max = Math.max(max, i);
//         }
//         return max;
//     }
//     public static void main(String[] args){
//         Scanner sc = new Scanner(System.in);
//         int n=sc.nextInt();
//         int w = sc.nextInt();
        
//         ArrayList<Integer> arr = new ArrayList();
//         ArrayList<Integer> res = new ArrayList();
//         for(int i =0; i<n; i++){
//             arr.add(sc.nextInt());
//         }
//         Solution sol = new Solution();
//         for(int i=0; i<=n-w; i++){
//             int max = sol.max(arr.subList(i,i+w));
//             res.add(max);
//         }
        
//         for(int i: res){
//             System.out.print(i+ " ");
//         }
        
        
//     }
// }


/*
 In a shopping mall, there is a Lift with a capacity of 500kgs only.
There are N persons waiting for the lift, and their weights (weights[]) are given.
If The Lift is overloaded, it will not move.
 
Your task is to find out the maximum number of persons can use the Lift,
without any overloading issue.

Input Format:
-------------
Line-1: An integer N, number of persons
Line-2: N space separated integers, weights of the persons.

Output Format:
--------------
Print an integer, max num of persons can use the lift.


Sample Input-1:
---------------
6
98 121 76 135 142 65

Sample Output-1:
----------------
5


Sample Input-2:
---------------
7
85 67 69 83 54 61 50

Sample Output-2:
----------------
7
 */

//  import java.util.*;
//  class Solution{
//      public static void main(String[] args){
//          Scanner sc = new Scanner(System.in);
//          int s = sc.nextInt();
         
//          ArrayList<Integer> arr = new ArrayList();
         
//          for(int i=0; i<s; i++){
//              arr.add(sc.nextInt());
//          }
         
//          Collections.sort(arr);
         
//          int w =0; int res =0;
//          for(int i: arr){
//              if(w+i <=500){
//                  w+=i;
//                  res++;
//              }
//          }
         
//          System.out.println(res);
         
//      }
//  }

/*
 Rahul is given a row of numbers where each row and columns are same. 
Rahul now prints the numbers of the rows as shown in the following manner. 
Help Rahul to write the code .

The first line of input consists of the size followed by the row numbers. 

Sample Input:
3
1 2 3 
4 5 6
7 8 9


Explanation:

1<-2<-3 
|
4->5->6
             |
7<-8<-9
   

Sample Output: 
3 2 1 4 5 6 9 8 7
 */

// import java.util.*;
// class Solution{
//      public static void main(String[] args){
//          Scanner sc = new Scanner(System.in);
//          int s = sc.nextInt();
//          ArrayList<Integer> arr = new ArrayList();
         
//          for(int i=0; i<s*s; i++){
//              arr.add(sc.nextInt());
//          }
         
//          for(int i=0; i<s*s; i+=2*s){
//              Collections.reverse(arr.subList(i, Math.min(i+s, arr.size())));
//          }
         
//          for(int i: arr){
//              System.out.print(i + " ");
//          }
//      }
//  }