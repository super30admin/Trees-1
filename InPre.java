public class InPre {
	int pre_idx = 0;
	public class Node {
		private int data;
		private Node leftChild;
		private  Node rightChild;
		
		  Node(int value){
			    this.data=value;
			    leftChild=null;
			    rightChild=null;
			  }
		
		 public Node getLeftChild(){return leftChild;}
		 public Node getRightChild(){return rightChild;}
		 public int  getData(){return data;}
		 public void setData(int value){this.data=value;}
		 public void setLeftChild(Node left){this.leftChild=left;}
		 public void setRightChild(Node right){this.rightChild=right;}

	}

	
	public Node build(int[] inorder, int[] preorder, int in_start, int in_end) {
		
		 if (in_start > in_end) 
	            return null; 
	
		
		int root_val = preorder[pre_idx++];
		Node root = new Node(root_val);

//		 if (in_start == in_end) 
//	            return root;

		 int index = search(inorder, in_start, in_end, root.getData()); 
	    root.setLeftChild(build(inorder,preorder,in_start,index-1));
	    root.setRightChild(build(inorder,preorder,index+1,in_end));
	    
	    return root;
	    
	}
	
	   int search(int arr[], int strt, int end, int value) 
	    { 
	        int i; 
	        for (i = strt; i <= end; i++) { 
	            if (arr[i] == value) 
	                return i; 
	        } 
	        return i; 
	    } 
	   
	   void printInorder(Node node) 
	    { 
	        if (node == null) 
	            return; 
	  
	        /* first recur on left child */
	        printInorder(node.getLeftChild()); 
	  
	        /* then print the data of node */
	        System.out.print(node.getData() + " "); 
	  
	        /* now recur on right child */
	        printInorder(node.getRightChild()); 
	    } 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] preorder = {3,9,20,15,7};
		int[] inorder =  {9,3,15,20,7};
		
		InPre obj = new InPre();
		int in_start = 0;
		int in_end = inorder.length-1;
		Node root = obj.build(inorder,preorder,in_start,in_end);
		
		obj.printInorder(root);
	}

}

