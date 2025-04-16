
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	
	static class Node{
		int key;
		Node left,right;
		
		public Node(int item) {
			key=item;
			left=right=null;
		}
		
		Node root;
	
		
		//갑삽입하기
		
		public Node insert(Node root,int key) {
			if(root==null) {
				return new Node(key);
			}
			if(key<root.key) {
				root.left=insert(root.left,key);
			}
			else {
				root.right=insert(root.right,key);
			}
			
			return root;
			
		}
		
		
		//후위 순회 왼쪽 오른쪽 루트
		public void postorder(Node node) {
			if(node!=null) {
				postorder(node.left);
				postorder(node.right);
				
				System.out.println(node.key);
				
			}
		}
		
	
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(Integer.parseInt(br.readLine()));
        String input;
        while (true) {
            input = br.readLine();
            if (input == null || input.equals(""))
                break;
            arr.add(Integer.parseInt(input));
        }
        
        Node node=new Node(arr.get(0));
        node.root=node;
        for(int i=1;i<arr.size();i++) {
        	node.root=node.insert(node.root, arr.get(i));
        }
        
        node.postorder(node.root);
		
		
		
		

	}

}
