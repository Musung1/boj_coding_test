import java.io.*;
import java.util.*;

//bubble sort
public class P2023 {
    //신기한 소수 찾기
    // 모든 자리 수가 소수면 신기한 소수
    // 입력 N - 자릿수
    // 자릿수에 있는 신기한 소수 찾기
    // 1의 자리 소수 2,3,5,7

    // ex) 2-> 21,22,23,24,25,... 탐색 -> 소수인것 선택 -> 3자리 탐색...-> N까지
    // DFS(int preNum,int 남은 자릿수)
    // preNum + 1 to 9 ->  소수 판별 , 소수 면 DFS , 마지막 자릿수면 숫자 리턴

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        DFS(2,N);
        DFS(3,N);
        DFS(5,N);
        DFS(7,N);

    }
    public static void DFS(int preNum, int N){
        if(N == 1){
            System.out.println(preNum);
        }
        for(int i = 0; i < 10; i++){
            int currentNum = preNum*10 + i;
            if(isPrime(currentNum)){
                DFS(currentNum,N-1);
            }
        }
    }

    private static boolean isPrime(int currentNum) {
        for (int i = 2; i < currentNum/2 ; i++) {
            if((currentNum % i) == 0){
                return false;
            }
        }
        return true;
    }
}