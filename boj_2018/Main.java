import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    //백준 2018번 문제
    public static void main(String[] args) throws IOException {
        //1. dna 길이, window크기, 문자열, dna 최소 갯수 입력받기
        //2. 문자열 시작 -> 윈도우 크기만큼 이동, 업데이트
        //3. 결과 만족하는 수 count
        // A-0,C-1,G-2,T-3
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int length = Integer.parseInt(st.nextToken());
        int window = Integer.parseInt(st.nextToken());
        char[] dna_char_list = bf.readLine().toCharArray();
        int[] least_condition = new int[4];
        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < 4; i++){
            least_condition[i] = Integer.parseInt(st.nextToken());
        }
        int start = 0;
        int end = window-1;
        int[] condition = new int[]{0,0,0,0};

        //initialize condition
        for (int i = 0; i < window; i++) {
            condition[dna_mapper(dna_char_list[i])]++;
        }
        int count = 0;

        while(end<length){

            if(isSatisfy(condition,least_condition)) {
                count++;
            }
            if(end == length-1)break;
            condition[dna_mapper(dna_char_list[start++])]--;
            condition[dna_mapper(dna_char_list[++end])]++;

        }
        System.out.println(count);
    }
    public static boolean isSatisfy(int[] condition, int[] least_condition){
        for (int i = 0; i < 4; i++) {
            if(condition[i] <least_condition[i]){
                return false;
            }
        }
        return true;
    }
    public static int dna_mapper(char a){
        int result = 0;
        switch (a){
            case 'A':
                result = 0;
                break;
            case 'C':
                result = 1;
                break;
            case 'G':
                result = 2;
                break;
            case 'T':
                result = 3;
                break;
        }
        return result;
    }
}