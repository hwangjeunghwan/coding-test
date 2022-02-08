import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ·Îº¿Ã»¼Ò±â {
	static int dx[] = {-1,0,1,0}; //ºÏµ¿³²¼­
	static int dy[] = {0,1,0,-1};
	static int[][] map;


	static int n;
	static int m;
	static int count = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		int r = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();
		map = new int[n][m];
		 for(int i = 0; i < n; i++) {
	            for(int j = 0; j < m; j++) {
	                map[i][j] = sc.nextInt();
	            }
	        }
		 clean(r,c,d);
		System.out.println(count);

	}
	
	public static void clean(int r, int c, int d) {
		if(map[r][c]==0) {
			map[r][c] = 2;
			count++;
		}
		
		boolean flag = false;
		int origin = d;
		for(int i=0; i<4; i++) {
			int nd = (d+3)%4;
			int nr = r+dx[nd];
			int nc = c+dy[nd];
			
			if(nr>0&&nc>0&&nr<n&&nc<m) {
				if(map[nr][nc]==0) {
					clean(nr,nc,nd);
					flag = true;
					break;
				}
			}
			d = (d+3)%4;
		}
		
		if(flag == false) {
			int nd = (origin+2)%4;
			int nbr = r+dx[nd];
			int nbc = c+dy[nd];
			
			if(nbr>0&&nbc>0&&nbr<n&&nbc<m) {
				if(map[nbr][nbc]!=1) {
					clean(nbr,nbc,origin);
				}
			}
		}
	}
		
		
	
	
	
}
