import java.util.Scanner;

public class UniqueLetterFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] letters = scanner.nextLine().split(" ");
        scanner.close();

        int[] freq = new int[26]; 

       
        for (String letter : letters) {
            freq[letter.charAt(0) - 'a']++;
        }

       
        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 == 1) {
                System.out.println((char) (i + 'a'));
                return;
            }
        }

        System.out.println("-1"); 
    }
}
