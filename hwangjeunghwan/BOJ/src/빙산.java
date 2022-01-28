import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ºù»ê {
	static int[][] map;
	static int dx[] = {-1,0,1,0};
	static int dy[] = {0,-1,0,1};
	static class point {
		int x;
		int y;
		point(int x, int y){
			this.x =x;
			this.y =y;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		map = new int[n][m];
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		int cnt = 0;
		int ans = 0;
		while((cnt = dfscount(map,n,m))<2) {
			if (cnt == 0) {
                ans = 0;
                break;
            }
			melt(n,m);
			ans++;
		}
		
	
		System.out.println(ans);
	}
	static void melt(int n, int m) {
		
		int[][] temp = new int[n][m];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				temp[i][j] = map[i][j];
			}
			
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				int count = 0;
				if(map[i][j]!=0) {
					for(int k=0; k<4; k++) {
						int nx = i+dx[k];
						int ny = j+dy[k];
						
						if(nx<0||ny<0||nx>n-1||ny>m-1)continue;
						if(map[nx][ny]==0) {
							count++;
						}
					}
					temp[i][j] = temp[i][j]-count;
					if(temp[i][j]<0) temp[i][j]=0;
				}
				
			}
		}
		
		map = temp;
	}
	
	static int dfscount(int[][] map, int n, int m) {
		boolean[][] visited = new boolean[n][m];
		int count = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j]!=0&&visited[i][j]!=true) {
					dfs(map, i, j, visited, n, m);
					count++;
				}
			}
		}
		return count;
	}
	
	static void dfs(int[][] map, int i, int j, boolean[][] visited, int n, int m) {
		visited[i][j] = true;
		
		for(int k=0; k<4; k++) {
			int nx = i+dx[k];
			int ny = j+dy[k];
			
			if(nx<0||ny<0||nx>n-1||ny>m-1)continue;
			if(map[nx][ny]==0)continue;
			if(visited[nx][ny]) continue;
			visited[nx][ny]= true;
			dfs(map, nx, ny, visited, n, m);
		}
	}
}
