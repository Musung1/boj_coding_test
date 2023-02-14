import java.io.*;
import java.util.*;

public class P2343{
    //1. 이진탐색 사용
    //2. start = 처음 값, end = 수 다 더한 값 비교
    //3. start 값에 맞춰서 이진 탐색 시작
    //4. div 가 목표값보다 크면 start, 중간값, div가 목표값보다 작으면 중간값 , 맥스
    //5. div가 목표값에 도달하면

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int div = scanner.nextInt();
        int[] A = new int[n];

        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }
        int start = Arrays.stream(A).max().getAsInt();
        int max = Arrays.stream(A).sum();

        while(start <= max){
            int mid = (start+max)/2;
            int count = 0;
            int sum = 0;
            // div 갯수 정하기
            for (int i = 0; i < n; i++) {
                sum += A[i];
                if(sum > mid){
                    count++;
                    sum = A[i];
                }
            }
            if(sum!=0){
                count++;
            }
            if(div < count){
                start = mid+1;
            }
            else{
                max = mid-1;
            }
        }
        System.out.println(start);
    }
}