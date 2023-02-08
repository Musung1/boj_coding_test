import java.io.*;
import java.util.*;

//bubble sort
public class P11399 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bf.readLine());
        int[] A = new int[num];
        String[] strings = bf.readLine().split(" ");
        for (int i = 0; i < num; i++) {
            A[i] = Integer.parseInt(strings[i]);
        }

        //insert sort
        //1번 요소는 배열 완료
        //2번 요소부터 앞으로 배열 찾기
        // 마지막 요소 배열 찾으면 종료
        for (int i = 1; i < num; i++) {
            //자기보다 작은 요소 만나기 or index가 -1
            // 자기보다 작은요소 +1 에 삽입
            // 나머지 요소 다 앞으로 밀어주기
            int index = i;
            for (int j = i-1; j >= 0 ; j--) {
                //인덱스 바꿀 인덱스 요소 찾기
                if(A[j] < A[i]){
                    index = j+1;
                    break;
                }
                if(j == 0){
                    index = 0;
                }
            }
            // index to i 까지 요소들 밀기
            int temp = A[i];
            for (int j = i-1; j >= index ; j--) {
                A[j+1] = A[j];
            }
            A[index] = temp;
        }
        int count = 0;
        for(int i = 0; i < num; i++){
            count += A[i] * (num-i);
        }
        System.out.println(count);
        
    }
}