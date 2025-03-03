import java.util.Scanner;

public class solution1{
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        String categories = scanner.nextLine();
        String[] priceStrings = scanner.nextLine().split(" ");
        
        int[] prices = new int[26];
        for (int i = 0; i < 26; i++){


            prices[i] = Integer.parseInt(priceStrings[i]);
        }

        int[] frequency = new int[26];
        for (char c : categories.toCharArray()){


            frequency[c - 'A']++;
        }

        int totalPrice = 0;
        for (int i = 0; i < 26; i++){


            if (frequency[i] > 0){


                totalPrice += frequency[i] * prices[i]; 
            }
        }

        System.out.println(totalPrice);
        scanner.close();
    }

}