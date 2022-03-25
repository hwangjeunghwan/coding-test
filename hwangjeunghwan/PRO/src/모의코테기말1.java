import java.util.*;
public class 모의코테기말1 {
	  static int[][] answer;
	  static boolean[][] visited;
	  static int[] dx = {-1,0,1,0};
	  static int[] dy = {0,-1,0,1};
	static class Solution {
	  
	    public int[][] solution(int rows, int columns, int max_virus, int[][] queries) {
	       answer = new int[rows][columns];
	       
	        for(int i=0; i<queries.length; i++){
	        	visited = new boolean[rows][columns];
	            dfs(queries[i][0]-1, queries[i][1]-1, max_virus, rows, columns);
	            for(int t=0; t<answer.length; t++) {
		        	for(int j=0; j<answer[t].length; j++) {
		        		System.out.print(answer[t][j]+" ");
		        	}
		        	System.out.println();
		        }
	        }
	        
	        return answer;
	    }

	}
	 static void dfs(int x, int y, int max_virus, int rows, int columns){
	        
	        if(answer[x][y]<max_virus){
	            answer[x][y]++;
	        }
	        else{
	        	visited[x][y]=true;
	            for(int i=0; i<4; i++){
	                int nx = dx[i]+x;
	                int ny = dy[i]+y;

	                if(nx<0||ny<0||nx>rows-1||ny>columns-1)continue;
	                if(visited[nx][ny])continue;
	                if(answer[nx][ny]<max_virus) {
	                	answer[nx][ny]++;
	                	visited[nx][ny]=true;
	                	
	                }
	                else {
	                	visited[nx][ny]=true;
	                	dfs(nx, ny, max_virus, rows, columns);
	                }    
	                
	                
	            }
	        }
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int rows =3;
		int columns=4;
		int max_virus=2;
		int[][] qu = {{3,2},{3,2},{2,2},{3,2},{1,4},{3,2},{2,3},{3,1}};
		Solution s = new Solution();
		s.solution(rows, columns, max_virus, qu);
		
	}

}
