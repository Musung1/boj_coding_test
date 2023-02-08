import java.io.*;
import java.util.*;

public class P17298 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[] A = new int[num];
        for (int i = 0; i < num; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        int[] result = new int[num];
        //1. 스택 생성
        //2. 스택에 하나씩 넣음
        //3. 다음 넣는 차례가 이미 있던 수보다 크면 기존요소 pop, 새로운 요소 push -> 스택에 있는만큼 반복
        //4. stack에 새로 넣을게 없으면 종료
        Stack<Integer> S = new Stack<>();
        S.push(0); // initialize
        for (int i = 1; i < num ; i++) {
            while(!S.isEmpty() && A[S.peek()] < A[i]){
                result[S.pop()] = A[i];
            }
            S.push(i);
        }
        while(!S.isEmpty()){
            result[S.pop()] = -1;
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < num; i++) {
            bw.write(result[i] + " ");
        }
        bw.write("\n");
        bw.flush();
    }
}