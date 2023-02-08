import java.io.*;
import java.util.*;

//bubble sort
public class P1427 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String tempString = bf.readLine();
        int[] A = new int[tempString.length()];
        for (int i = 0; i < tempString.length(); i++) {
            A[i] = tempString.toCharArray()[i] - '0';
        }
        for (int i = 0; i < tempString.length(); i++) {
            int max = i;
            for (int j = i; j < tempString.length(); j++) {
                if(A[j] > A[max]){
                    max = j;
                }
            }
            int temp;
            temp = A[i];
            A[i] = A[max];
            A[max] = temp;
        }
        for (int i = 0; i < tempString.length(); i++) {
            System.out.print(A[i]);
        }
    }
}