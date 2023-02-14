import java.io.*;
import java.util.*;

public class P1744{

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        PriorityQueue<Integer> positive_pq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> negative_pq = new PriorityQueue<>();
        int num_one = 0;
        int num_zero = 0;
        for (int i = 0; i < n; i++) {
            int now = scanner.nextInt();
            if (now == 1)num_one ++;
            else if (now == 0) num_zero++;
            else if (now > 1) positive_pq.add(now);
            else negative_pq.add(now);
        }
        int sum = 0;
        // positive .....

        while(!positive_pq.isEmpty()){
            int data1 = 0;
            int data2 = 0;
            data1 = positive_pq.remove();
            if(positive_pq.isEmpty()){
                sum += data1;
                break;
            }
            data2 = positive_pq.remove();
            sum += data1 * data2;
        }
         //negative ...
        while(!negative_pq.isEmpty()){
            int data1 = 0;
            int data2 = 0;
            data1 = negative_pq.remove();
            if(negative_pq.isEmpty()){
                if (num_zero == 0) {
                    sum += data1;
                }
                break;
            }
            data2 = negative_pq.remove();
            sum += data1 * data2;
        }
        sum += num_one;
        System.out.println(sum);
    }
}