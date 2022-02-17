import java.util.HashMap;
import java.util.HashSet;

public class 신고결과받기 {

	static class Solution {
	    public int[] solution(String[] id_list, String[] report, int k) {
	    	 int[] answer = new int[id_list.length];
		        HashMap<String, Integer> reportcount = new HashMap<>();
		        HashMap<String, HashSet<String>> list = new HashMap<>(); //중복없기 위한 Set
		        
		        for(int i=0; i<id_list.length; i++) {
		        	reportcount.put(id_list[i], 0);
		        	list.put(id_list[i], new HashSet<>());
		        }
		        for(int i=0; i<report.length; i++) {
		        	String[] users = report[i].split(" ");
		        	String from = users[0]; //신고자
		        	String to = users[1]; //신고받은사람
		        	
		        	list.get(to).add(from);  //신고받은사람에게 신고한 사람 내역 넣기
		 
		        }
		        
		        for(String data: list.keySet()) {
		        	HashSet<String> h = list.get(data); //신고한 사람들
		        	if(h.size()>=k) { //신고한 사람들 크기가 k보다 크거나 같으면
		        		for(String user : h) { 
		        			int count = reportcount.get(user) + 1; //신고한 사람들에게 mail카운트 1+
		        			reportcount.put(user, count);
		        		}
		        	}
		        }
		        int i = 0;
		        for(String data : id_list) {
		        	answer[i] = reportcount.get(data);
		        	i++;
		        }
		        
		        return answer;
	    }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] id_list = {"muzi", "frodo", "apeach", "neo"};
		String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
		int k = 2;
		
		Solution s = new Solution();
		System.out.println(s.solution(id_list, report, k));
		
		
		
	}

}
