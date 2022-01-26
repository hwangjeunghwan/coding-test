import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 안전영역 {
	
	static class point{
		int x;
		int y;
		point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};

static int N;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int[][] Graph = new int[N][N];
		
		int maxh = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				Graph[i][j] = sc.nextInt();
				if(Graph[i][j]> maxh) {
					maxh = Graph[i][j];
				}
			}
		}
		int result = 0;
		for(int i=0; i<maxh+1; i++) {
			int count = 0;
			boolean[][] visited = new boolean[N][N];
			for(int k=0; k<N; k++) {
				for(int j=0; j<N; j++) {
					if(visited[k][j] !=true&&Graph[k][j]>i) {
						
						count += dfs(i, Graph, visited, k, j);
					}
				}
			}
			result = Math.max(count, result);
		}
		System.out.println(result);
	}
	
	
	
	static int dfs(int h, int[][] Graph, boolean[][] visited, int i, int j) {
		
		visited[i][j] = true;
			
			for(int k=0; k<4; k++) {
				int nx = i + dx[k];
				int ny = j + dy[k];
				
				if(nx<0||ny<0||nx>N-1||ny>N-1)continue;
				if(visited[nx][ny]) continue;
				if(Graph[nx][ny]<=h)continue;
				visited[nx][ny] = true;
				dfs(h, Graph, visited, nx, ny);
			}
		
			return 1;
	}
}
