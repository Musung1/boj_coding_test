import java.io.*;
import java.util.Arrays;

public class P11004 {
    static int[] A;
    static int index;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] first = bf.readLine().split(" ");
        int num = Integer.parseInt(first[0]);
        index = Integer.parseInt(first[1])-1;
        String[] second = bf.readLine().split(" ");
        A = new int[num];
        for(int i = 0; i < num; i++){
            A[i] = Integer.parseInt(second[i]);
        }
        quickSort(0,num-1);
        System.out.println(Arrays.toString(A));
        //quick sort
    }
    //insertion sort
    //1. start <= pivot -> start++
    //2. end >= pivot -> end--;
    //3. start > pivot , end < pivot -> swap(start,end) , start++. end --
    //4. start, end 만나면 -> swap(start,pivot) , insertionSort(0,start-1),insertionSort(start+1,end)

    public static void quickSort(int start, int end){
        int part=partition(start,end);
        if(start<part-1) quickSort(start,part-1);
        if(end>part) quickSort(part,end);

    }
    public static int partition(int start, int end){
        int pivot = end;
        while(start <= end){
            while(A[start] < A[pivot])start++;
            while(A[end] > A[pivot])end--;
            if(start <= end){
                swap(start,end);
                start++;
                end--;
            }
        }
        return start;
    }
    public static void swap(int start, int end){
        int temp = A[start];
        A[start] = A[end];
        A[end] = temp;
    }

}