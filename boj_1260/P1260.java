import java.io.*;
import java.util.*;

public class P1260 {
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    public static void DFS(int root){
        if(visited[root])return;
        System.out.print(root + " ");
        visited[root] = true;
        A[root].stream().sorted().forEach((element)->{
            DFS(element);
        });
    }
    public static void BFS(int root){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(root);
        visited[root] = true;
        while(!queue.isEmpty()) {
            int currentNode = queue.poll();
            System.out.print(currentNode + " ");
            A[currentNode].stream()
                    .sorted()
                    .forEach((element)-> {
                        if(!visited[element]){
                            queue.add(element);
                            visited[element] = true;
                        }
            });
        }
    }
//private static void BFS(int node) {  // BFS구현
//    Queue<Integer> queue = new LinkedList<Integer>();
//    queue.add(node);
//    visited[node] = true;
//
//    while (!queue.isEmpty()) {
//        int now_node = queue.poll();
//        System.out.print(now_node + " ");
//        Collections.sort(A[now_node]);
//        for (int i : A[now_node]) {
//            if (!visited[i]) {
//                visited[i] = true;
//                queue.add(i);
//            }
//        }
//    }}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // n,e,s initialize
        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        visited = new boolean[N+1];
        //graph init
        A = new ArrayList[N+1];
        for (int i = 1; i < N+1; i++) {
            A[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            A[first].add(second);
            A[second].add(first);
        }
        DFS(S);
        System.out.println();
        visited = new boolean[N+1];
        BFS(S);
        System.out.println();
    }
}