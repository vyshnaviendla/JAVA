import java.util.ArrayList;
import java.util.Scanner;
class Solution{
    public static boolean pali(String s){
        int l =0, r = s.length()-1;
        while(l<r){
            if(s.charAt(l) != s.charAt(r)) return false;
            else{
                l++;
                r--;
            }
        }
        return true;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int len = s.length();
        ArrayList<String> pal = new ArrayList<>();
        for(int i= 0; i<len; i++){
            for(int j = i+1; j<=len; j++){
                String sub = s.substring(i,j);
                if(pali(sub)) pal.add(sub);
            }
        }
        System.out.println(pal.size());
    }
}