import java.util.ArrayList;
import java.util.Scanner;

class slidingwindow {
    public static ArrayList<Integer> slidingwindow(int[] arr, int n, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i<=n-k; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < k; j++) {
                min = Math.min(min, arr[i + j]);
            }
            list.add(min);
        }
        return list;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println(slidingwindow(arr, n, k));
        
    }
   
}