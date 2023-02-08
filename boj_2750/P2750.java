import java.io.*;
import java.util.*;

//bubble sort
public class P2750 {

    public static void main(String[] args) throws IOException {
        //1. num, array 생성
        //2. 1번 for문, 2번 for문
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bf.readLine());
        int[] A = new int[num];
        for(int i = 0; i < num; i++){
            A[i] = Integer.parseInt(bf.readLine());
        }
        for(int i = 0; i < num; i++){
            for(int j = 0; j < num-i-1; j++){
                if(A[j] > A[j+1]){
                    int temp;
                    temp = A[j];
                    A[j] = A[j+1];
                    A[j+1] = temp;
                }
            }
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < num; i++) {
            bw.write(A[i] + "\n");
        }
        bw.flush();
        bw.close();
    }
}