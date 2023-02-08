import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class P110003 {
    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 출력을 그때 그때 하는 것보다 버퍼에 넣고 한번에 출력하기 위해 BufferedWriter를 사용
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        Deque<Node> mydeque = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(st.nextToken());

            while(!mydeque.isEmpty() && mydeque.getLast().value > now){
                mydeque.removeLast();
            }
            mydeque.addLast(new Node(i,now));

            if(mydeque.getFirst().index <= i - L){
                mydeque.removeFirst();
            }
            bw.write(mydeque.getFirst().value + " ");
        }
        //1. 덱 만들기
        //2. 나중에 들어온게 가장 작으면 나머지 다 지움
        //3. index가 범위 초과면 안넣기


        bw.flush();
        bw.close();
    }

    static class Node {
        public int value;
        public int index;

        Node(int index, int value) {
            this.value = value;
            this.index = index;
        }
    }
}