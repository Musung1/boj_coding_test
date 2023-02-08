import java.io.*;
import java.util.*;

public class P2164 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bf.readLine());
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= num; i++){
            queue.add(i);
        }
        while(queue.size() > 1){
            queue.poll();
            queue.add(queue.poll());
        }
        System.out.println(queue.poll());

    }
}