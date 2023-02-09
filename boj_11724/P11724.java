import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

//bubble sort
public class P11724{
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        //1. stack 생성
        //2. root 노드 stack에 넣기
        //3. root 노드 연관 노드 순서대로 node 에 넣기 재귀로 -> 방문한 배열은 건너뛰기
        //4. 탐색 노드 없으면 출력 후 리턴
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        A = new ArrayList[N+1];
        visited = new boolean[N+1];
        for(int i = 1; i <= N; i++){
            A[i] = new ArrayList<>();
        }
        for (int i = 0; i < E ; i++) {
            st = new StringTokenizer(bf.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            A[first].add(second);
            A[second].add(first);
        }
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if(!visited[i]){
                DFS(i);
                count++;
            }
        }
        System.out.println(count);
    }
    public static void DFS(int n){
        if(visited[n])return;
        visited[n] = true;
        A[n].stream().forEach((element)->{
            DFS(element);
        });
    }
}