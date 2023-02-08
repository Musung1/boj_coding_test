import java.io.*;
import java.util.*;

public class P1874 {
    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int num = scanner.nextInt();
        Stack<Integer> myStack = new Stack<>();
        myStack.push(0);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < num; i++) {
            int now = scanner.nextInt();
            if (myStack.peek() <= now){
                int k = myStack.peek();
                while(myStack.peek() < now){
                    myStack.push(++k);
                    bw.write("+ \n");
                }
                myStack.pop();
                bw.write("- \n");

            }
            else{
                if(myStack.pop() != now){
                    System.out.println("NO");
                    //return;
                }
                else{
                    bw.write("- \n");
                }
            }
        }
        bw.flush();
        bw.close();
    }
}