import java.util.*;

public class DieterPointsCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] calories = new int[n];
        for (int i = 0; i < n; i++) {
            calories[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        int lower = sc.nextInt();
        int upper = sc.nextInt();

        int totalPoints = 0;
        int currentSum = 0;
        
        for (int i = 0; i < k; i++) {
            currentSum += calories[i];
        }
        totalPoints += evaluatePoints(currentSum, lower, upper);
        
        for (int i = k; i < n; i++) {
            currentSum = currentSum - calories[i - k] + calories[i];
            totalPoints += evaluatePoints(currentSum, lower, upper);
        }
        
        System.out.println(totalPoints);
    }
    
    private static int evaluatePoints(int totalCalories, int lower, int upper) {
        if (totalCalories < lower) {
            return -1;
        } else if (totalCalories > upper) {
            return 1;
        }
        return 0;
    }
}
