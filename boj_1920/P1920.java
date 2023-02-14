import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class P1920{
    static int data_n;
    static int[] A;
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        data_n = scanner.nextInt();
        A = new int[data_n];
        for (int i = 0; i < data_n; i++) {
            A[i] = scanner.nextInt();
        }
        Arrays.sort(A);
        int find_n = scanner.nextInt();
        int[] find_A = new int[find_n];
        for (int i = 0; i < find_n; i++) {
            find_A[i] = scanner.nextInt();
        }

        for (int element : find_A) {
            find(element);
        }
    }
    static void find(int element){
        //이진탐색
        int start = 0;
        int end = data_n-1;
        int mid = (start+end)/2;
        while(start<=end){
            mid = (start+end)/2;
            if(A[mid] == element){
                System.out.println(1);
                return;
            }
            else if (A[mid] > element) end = mid-1;
            else start = mid+1;
        }
        System.out.println(0);

    }
}