package qwe;
import java.lang.reflect.Array;
import java.util.*;

public class tests {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
            String s = sc.nextLine();
            int n = sc.nextInt();
            String a = reverseLeftWords(s,n);
            System.out.println(a);
    }



    public static String reverseLeftWords(String s, int n) {
        StringBuilder res = new StringBuilder();
        for(int i=n;i<s.length();i++){
            res.append(s.charAt(i));
        }
        for(int i=0;i<n;i++){
            res.append(s.charAt(i));
        }
        return res.toString();
    }
}