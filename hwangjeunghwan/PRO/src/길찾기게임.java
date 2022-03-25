import java.util.*;
public class 길찾기게임 {
	class Tree{
		Tree left;
		Tree right;
		int id;
		int x;
		int y;
		
		Tree(int x, int y, int id){
			this.x = x;
			this.y = y;
			this.id =id;
		}
		
		
		
	}
	
	Comparator<Tree> comx = new Comparator<Tree>() {

		@Override
		public int compare(Tree o1, Tree o2) {
			// TODO Auto-generated method stub
			if(o1.y-o2.y==0) {
				return o1.x-o2.x;
			}else {
				return o2.y-o1.y;
			}
		}
	};
	int[][] answer;
	static int idx = 0;
	List<Tree> list = new LinkedList<>();
	public int[][] solution(int[][] nodeinfo) {
        
        
        
        for(int i=0; i<nodeinfo.length; i++) {
        	list.add(new Tree(nodeinfo[i][0], nodeinfo[i][1], i+1));
        }
        list.sort(comx);
        for(Tree t : list) {
     //   	System.out.println(t.id);
        }
        Tree root = list.get(0);
        for(int i=1; i<list.size(); i++) {
        	add(root, list.get(i));
        }
        answer = new int[2][list.size()];
        preorder(root);
        idx = 0;
       // postorder(root);
       
        return answer;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] nodeinfo = {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};
		길찾기게임 s = new 길찾기게임();
		s.solution(nodeinfo);
	}
	public static void add(Tree root, Tree node) {
		if(root.x>node.x) {
    		if(root.left==null) {
    			root.left = node;
    		}
    		else {
    			root = root.left;
    			add(root, node);
    		}
    	}
    	else if(root.x<node.x) {
    		if(root.right==null) {
    			root.right = node;
    		}
    		else {
    			root = root.right;
    			add(root, node);
    		}
    	}
	}
	
	public void preorder(Tree node) { //VLR
		if(node == null) return;
		
			System.out.print(node.id);
			//answer[0][idx++] = node.id;
			preorder(node.left);
			preorder(node.right);
		
	}
	public void postorder(Tree node) { //LRV
		if(node == null) return;
		
			preorder(node.left);
			preorder(node.right);
		//	System.out.println(node.id);
		//	answer[1][idx++] = node.id;
		
	}

}
