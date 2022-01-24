import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 스타트링크 {

	static int F;
	static int S;
	static int G;
	static int U;
	static int D;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		F = sc.nextInt(); // 총 F층
		S = sc.nextInt(); // 지금 있는 층
		G = sc.nextInt(); // 스타트 링크가 있는 층
		U = sc.nextInt(); // 위로 올라가는 층수
		D = sc.nextInt(); // 아래로 내려가는 층수
		
		int[] visited = new int[F+1];
		
		dfs(visited);
		
		
	}

	static void dfs(int[] visited) {
		
		visited[S] = 1;
		Queue<Integer> q= new LinkedList<>();
		
		q.add(S);
		
		while(!q.isEmpty()) {
			
			int curr = q.poll();
		//v	System.out.println(curr);
			
			if(curr == G) {
				System.out.println(visited[curr]-1);
			}
	
					int su = curr+U;
					int sd = curr-D;
					
						if(su>0&&su<=F) {
							if(visited[su] == 0) {
							q.add(su);
							visited[su] = visited[curr]+1;
						} 
					}
					
						if(sd>0&&sd<=F) {
							if(visited[sd] == 0) {
							q.add(sd);
							visited[sd] = visited[curr]+1;;
						} 
					}
				
			
		}
		if(visited[G]==0) System.out.println("use the stairs");
	}
}
