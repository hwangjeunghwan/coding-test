import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ¿ÀÇÂÃ¤ÆÃ¹æ {
	static class Solution {
	    public String[] solution(String[] record) {
	    	List<String> list = new ArrayList<>();
	   
	        
	        HashMap<String, String> map = new HashMap<>();
	        
	        for(String s : record) {
	        	String[] type = s.split(" ");
	        	if(type[0].equals("Enter")) {
	        	if(!map.containsKey(type[1])) {
		        		map.put(type[1], type[2]);
		        	}
		        	else {
		        		map.put(type[1], type[2]);
		        	}
	        	}
	        	if(type[0].equals("Change")) {
	        		map.put(type[1], type[2]);
	        	}
	        }
	        String name;
	        for(String s : record) {
	        	String[] type = s.split(" ");
	        	
	        	if(type[0].equals("Enter")) {
	        		name = map.get(type[1]);
	        		list.add(name+"´ÔÀÌ µé¾î¿Ô½À´Ï´Ù.");
	        	}
	        	if(type[0].equals("Leave")) {
	        		name = map.get(type[1]);
	        		list.add(name+"´ÔÀÌ ³ª°¬½À´Ï´Ù.");
	        	}
	        	
	        }
	      
	        
	        String[] answer = new String[list.size()];
	        int k = 0;
	        for(String i : list) {
	        	answer[k] = i;
	        	k++;
	        }
	        
	        for(String i : answer) {
	        	System.out.println(i);
	        }
	    
	        
	        return answer;
	    }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		System.out.println(s.solution(record));
	}

}
