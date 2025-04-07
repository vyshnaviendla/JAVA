import java.util.Scanner;
class RemoveAllOnesWithFlips {
    public boolean removeOnes(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        for (int c = 0; c < cols; c++) {
            if (grid[0][c] == 1) {
                for (int r = 0; r < rows; r++) {
                    grid[r][c] ^= 1;
                }
            }
        }
        for (int r = 1; r < rows; r++) {
            int count = 0;
            for (int c = 0; c < cols; c++) {
                count += grid[r][c];
            }

            if (count != 0 && count != cols) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        boolean result = new RemoveAllOnesWithFlips().removeOnes(grid);
        System.out.println(result);
    }
}
