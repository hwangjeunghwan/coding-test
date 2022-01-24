import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ��ŸƮ��ũ {

	static int F;
	static int S;
	static int G;
	static int U;
	static int D;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		F = sc.nextInt(); // �� F��
		S = sc.nextInt(); // ���� �ִ� ��
		G = sc.nextInt(); // ��ŸƮ ��ũ�� �ִ� ��
		U = sc.nextInt(); // ���� �ö󰡴� ����
		D = sc.nextInt(); // �Ʒ��� �������� ����
		
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
