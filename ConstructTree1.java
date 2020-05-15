package LeetCode;

public class ConstructTree1 {
	
	  public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	 
	class Solution { 
	    private TreeNode constructTree(int[] in, int[] pre, int inS, int inE, int prS, int prE, Map<Integer, Integer> lookup){
	        if(inS > inE) return null;
	        int rootData = pre[prS];
	    
	    
	    
	        TreeNode root = new TreeNode(rootData);
	        int rootIndex = lookup.get(rootData);
	    
	        int lInS = inS;  //left inorder start
	        int lInE = rootIndex -1; //left inorder end
	        int lPrS = prS +1; //left preorder start
	        int lPrE = lInE - lInS + lPrS; //left pre order end
	        int rInS = rootIndex +1; //right inorder start
	        int rInE = inE; //right inorder end
	        int rPrS = lPrE +1; // right preorder start
	        int rPrE = prE; //right preorder end
	    
	        root.left = constructTree(in, pre, lInS, lInE, lPrS, lPrE, lookup);
	        root.right = constructTree(in, pre, rInS, rInE, rPrS, rPrE, lookup);
	        return root;
	    }
	    public TreeNode buildTree(int[] preorder, int[] inorder) {
	        Map<Integer, Integer> map = new HashMap<>();
	        
	        for(int i=0; i<inorder.length; i++)
	           map.put(inorder[i],i);
	        return constructTree(inorder, preorder, 0, inorder.length - 1, 0, preorder.length - 1, map);
	    }
	}
}


/*
TC - O(n)  There is no need to copy arrays, we can use start preorder, start inorder & end preorder, end inorder indexes for both left and right hand side of inorder & preorder arrays instead.

SC : O(H) sine we are storing the entire tree
*/