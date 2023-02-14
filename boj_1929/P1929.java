import java.io.*;
import java.util.*;

public class P1929{
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int start = scanner.nextInt();
        int end = scanner.nextInt();
        int[] A = new int[end + 1];
        for(int i = 2; i <= end; i++){
            A[i] = i;
        }
        for (int i = 2; i <= Math.sqrt(end); i++) {
            if(A[i] == 0) continue;
            for(int j = i+i; j<= end; j += i){
                A[j] = 0;
            }
        }
        for (int i = start; i <= end; i++) {
            if(A[i] != 0){
                System.out.println(A[i]);
            }
        }
    }
}