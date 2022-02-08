import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 맥주마시면서걸어가기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=0; i<t; i++) {
			int n = sc.nextInt();
			List<int[]> list = new ArrayList<>();
			boolean[][] visited = new boolean[n+2][n+2];
			for(int j=0; j<n+2; j++) {
				int x= sc.nextInt();
				int y = sc.nextInt();
				list.add(new int[] {x,y});
			}
				
			for(int a=0; a<n+2; a++) {
				for(int b=0; b<n+2; b++) {
					int[] pos = list.get(a), next = list.get(b);
					int dis = Math.abs(pos[0]-next[0])+Math.abs(pos[1]-next[1]);
					if(dis<=1000)visited[a][b] = true;
				}
			}
			
			for(int k=0; k<n+2; k++) {
				for(int a=0; a<n+2; a++) {
					for(int b=0; b<n+2; b++) {
						if(visited[a][k] && visited[k][b]) {
							visited[a][b] = true;
						}
					}
				}
			}
			
			System.out.println(visited[0][n+1] ? "happy": "sad");
			}
		
		}
	

}
