import java.io.*;
import java.util.*;

public class P11047{
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int cost = scanner.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }
        int count = 0;
        for (int i = n-1; i >= 0 ; i--) {
            int share = cost/A[i];
            int mod = cost%A[i];
            count += share;
            cost = mod;
        }
        System.out.println(count);
    }
}