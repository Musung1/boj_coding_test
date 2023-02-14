import java.io.*;
import java.util.*;

public class P1931{

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] A = new int[n][2];
        for(int i = 0; i< n; i++){
            A[i][0] = scanner.nextInt();
            A[i][1] = scanner.nextInt();
        }
        //1. sort(앞 , 뒤 우선순위)
        //2. 끝 시간 이상부터 시작하는 회의 중 끝 시간이 가장 짧은 것 선택 -> 반복
        Arrays.sort(A, new Comparator<int[]>() {
            @Override
            public int compare(int[] S, int[] E) {
                if(S[1] == E[1]){
                    return S[0] - E[0];
                }
                return S[1] - E[1];
            }
        });
        int count = 0;
        int end = -1;
        for (int i = 0; i < n; i++) {
            if(A[i][0] >= end){
                count++;
                end = A[i][1];
            }
        }
        System.out.println(count);
    }
}