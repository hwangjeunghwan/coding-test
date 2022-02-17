import java.util.HashMap;
import java.util.HashSet;

public class �Ű����ޱ� {

	static class Solution {
	    public int[] solution(String[] id_list, String[] report, int k) {
	    	 int[] answer = new int[id_list.length];
		        HashMap<String, Integer> reportcount = new HashMap<>();
		        HashMap<String, HashSet<String>> list = new HashMap<>(); //�ߺ����� ���� Set
		        
		        for(int i=0; i<id_list.length; i++) {
		        	reportcount.put(id_list[i], 0);
		        	list.put(id_list[i], new HashSet<>());
		        }
		        for(int i=0; i<report.length; i++) {
		        	String[] users = report[i].split(" ");
		        	String from = users[0]; //�Ű���
		        	String to = users[1]; //�Ű�������
		        	
		        	list.get(to).add(from);  //�Ű����������� �Ű��� ��� ���� �ֱ�
		 
		        }
		        
		        for(String data: list.keySet()) {
		        	HashSet<String> h = list.get(data); //�Ű��� �����
		        	if(h.size()>=k) { //�Ű��� ����� ũ�Ⱑ k���� ũ�ų� ������
		        		for(String user : h) { 
		        			int count = reportcount.get(user) + 1; //�Ű��� ����鿡�� mailī��Ʈ 1+
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
