// There are N small cartoons, and each cartoon contains a balloon of a specific color, represented by an integer.

// You need to pick P consecutive cartoons at a time and determine the number of unique colored balloons within that selection. 
// Repeat this for each possible selection of P cartoons from the given sequence.

// The total number of such selections will be (N - P + 1), and for each selection, 
// you must return the count of unique balloon colors.

// Input Format:
// -------------
// Line-1: Two space-separated integers N (total number of cartoons) and P (number of cartoons selected at a time).
// Line-2: N space-separated integers, representing the color of balloons inside each cartoon.

// Output Format:
// ---------------
// Line-1: Print space-separated (N - P + 1) integers, where each integer represents the number of unique balloon colors in each selection of P cartoons.

// Sample Input-1:
// ---------------
// 7 4
// 1 2 2 3 3 4 4

// Sample Output-1:
// ----------------
// 3 2 3 2

// Explanation: 
// ------------
// The number of distinct elements in each subarray of size P goes as follows:
// - nums[0:3] = [1,2,2,3] so ans[0] = 3
// - nums[1:4] = [2,2,3,3] so ans[1] = 2
// - nums[2:5] = [2,3,3,4] so ans[2] = 3
// - nums[3:6] = [3,3,4,4] so ans[3] = 2


// Sample Input-2:
// ---------------
// 6 3
// 1 1 1 1 1 1

// Sample Output-2:
// ----------------
// 1 1 1 1

// Explanation:
// ------------
// The number of distinct elements in each subarray goes as follows:
// - nums[0:2] = [1,1,1] so ans[0] = 1
// - nums[1:3] = [1,1,1] so ans[1] = 1
// - nums[2:4] = [1,1,1] so ans[2] = 1
// - nums[3:5] = [1,1,1] so ans[3] = 1


// Sample Input-3:
// ---------------
// 7 3
// 1 2 3 4 2 1 3

// Sample Output-3:
// ----------------
// 3 3 3 3 3


public class program {
    public static void main(String[] args) {
        int a = 0b101;
        System.out.println(a);
    }
    
}
