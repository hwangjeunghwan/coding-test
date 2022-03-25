import java.util.*;
public class 모의코테기말2 {
	static String[][] graph;
	static boolean[] visited;
	static List<String> list = new ArrayList<>();
	static class Solution {
	    public String[] solution(String[] s1, String[] s2, String k) {
	        String[] answer = {};
	        graph = new String[s1.length][2];
	        visited = new boolean[graph.length];
	        for(int i=0; i<s1.length; i++) {
	        	graph[i][0] = s2[i];
	        	graph[i][1] = s1[i];
	        }
	       dfs(0, "", k, s1, s2); 
	       System.out.println(list);
	        return answer;
	    }
	    
	    static void dfs(int idx, String result, String k, String[] s1, String[] s2) {
	    	if(idx == s1.length) {
	    		list.add(result);
	    		return;
	    	}
	    	for(int i=0; i<s1.length; i++) {
	    		if(!visited[i]&&k.equals(s2[i])) {
	    			visited[i] = true;
	    			System.out.println(s1[i]);
	    			dfs(idx+1, result+" "+s1[i], s1[i], s1, s2);
	    			visited[i] = false;
	    		}
	    		
	    	}
	    	
	    }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		String[] s1 = {"A", "E", "B", "D", "B", "H", "F", "H", "C"};
		String[] s2 = {"G", "C", "G", "F", "J", "E", "B", "F", "B"};
		String k = "B";
		s.solution(s1, s2, k);
	}

}
