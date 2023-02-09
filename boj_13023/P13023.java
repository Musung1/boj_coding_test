import java.io.*;
import java.util.*;

public class P13023{
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static boolean isCounted;

    // DFS  했을 때 A -> B -> C -> D -> E 까지 가는 루트가 있는지 판별
    // root to end  == 5 라면  return true;
    // dfs(int root, int level)

    public static void DFS(int root, int level){
        if(level == 5 || isCounted){
            isCounted = true;
            return;
        }
        visited[root] = true;
        for (int element : A[root]) {
            if(!visited[element]){
                DFS(element,level+1);
            }
        }
        visited[root] = false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        A = new ArrayList[N];
        visited = new boolean[N];
        isCounted = false;
        for (int i = 0; i < N; i++) {
            A[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            A[start].add(end);
            A[end].add(start);
        }
        for(int i = 0; i< N; i++){
            DFS(i,1);
            if(isCounted){
                break;
            }
        }
        if(isCounted){
            System.out.println(1);
        }
        else{
            System.out.println(0);
        }

    }
}