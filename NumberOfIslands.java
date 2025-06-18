
// Ibrahim is an interior designer wants to color wall of size M*N. 
// He plans to color the wall and put lights of two different colors

// The designer can lit the wall using M*N lights.The lights are Blue or pink
// in color. Blue colored lights represented with digit-1 and pink colored lights 
// represented with digit-0.

// The Blue colored lights forms different shapes, that are connected 4 directonally.
// The directons are upwards, downwards, left, and right. Ibrahim got an idea to 
// count the number of shapes formed by blue colored lights.

// You will be given the decorated wall as a matrix wall[][].
// Your task is to help Ibrahim to count the number of shapes by the lights.

// Input Format:
// -------------
// Line-1: Two space separated integers M and N, size of the wall.
// Next M lines: N space separated integers, either 0 or 1.

// Output Format:
// --------------
// Print an integer, Number of distinct shapes formed by Blue Lights.


// Sample Input-1:
// ---------------
// 4 5
// 1 1 0 1 1
// 1 1 0 0 1
// 0 0 0 0 0
// 1 1 0 0 0

// Sample Output-1:
// ----------------
// 3


// Sample Input-2:
// ---------------
// 5 5
// 1 1 0 1 1
// 1 0 0 0 1
// 0 0 0 0 0
// 1 0 0 0 1
// 1 1 0 1 1

// Sample Output-2:
// ----------------
// 4

// Note: 
// -------
// The shapes, 
// 1 1  		  1 1
// 1      and      1




import java.util.Scanner;
public class NumberOfIslands {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int[][] wall = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                wall[i][j] = sc.nextInt();
            }
        }
        boolean[][] visited = new boolean[M][N];
        int count = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (wall[i][j] == 1 && !visited[i][j]) {
                    dfs(wall, visited, i, j, M, N);
                    count++;
                }
            }
        }
        System.out.println(count);
    }
    private static void dfs(int[][] wall, boolean[][] visited, int i, int j, int M, int N) {
        if (i < 0 || i >= M || j < 0 || j >= N || wall[i][j] == 0 || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        dfs(wall, visited, i - 1, j, M, N); 
        dfs(wall, visited, i + 1, j, M, N); 
        dfs(wall, visited, i, j - 1, M, N); 
        dfs(wall, visited, i, j + 1, M, N); 
    }
}
