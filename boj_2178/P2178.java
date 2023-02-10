import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2178{
    //미로 탐색하기
    //1. 미로 배열 만들기
    //2. 상,하,좌,우 이동 하는 그래프
    //3. out of index or visited 면 탐색 x
    //4. depth 저장
    // 5. 0,0 -> n,m 도달하면   리턴
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //상 하 좌 우
        int[] dx = new int[] {0,0,-1,1};
        int[] dy = new int[] {-1,1,0,0};
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] A = new int[N+1][M+1];
        for (int i = 1; i < N+1; i++) {
            String currentLine = br.readLine();
            for (int j = 1; j < M+1; j++) {
                int currentNum = currentLine.charAt(j-1) - '0';
                A[i][j] = currentNum;
            }
        }
        ///BFS 시작
        boolean[][] visited = new boolean[N+1][M+1];
        int count = 1;
        LinkedList<int[]> queue = new LinkedList<>();
        // 1,1 넣으면 시작
        int[] start = new int[]{1,1,1};
        queue.add(start);
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            //System.out.println(current[0] + " , " + current[1] + "탐색");
            if(current[0] == N && current[1] == M){
                System.out.println(current[2]);
                break;
            }
            for (int i = 0; i < 4; i++) {
                int x = current[1] + dx[i];
                int y = current[0] + dy[i];
                int depth = current[2];
                if(x>0 && x <= M && y >0 && y <= N && !visited[y][x] && A[y][x] == 1){
                    queue.add(new int[]{y,x,depth+1});
                    visited[y][x] = true;
                }
                //x,y 범위 에 있는지
                //x,y visited 된건지
            }
        }
    }
}