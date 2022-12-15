import java.util.HashMap;
import java.util.Map;
//Time Complexity :O(N)+O(N) // N in building Map as well N in Traversing tree 
//Space Complexity :O(N)+ O(H) // N space for MAP 
//Did this code successfully run on Leetcode :yes
//Three line explanation of solution in plain english: Tricky part is to declare pre idx in class scope.  

//Your code here along with comments explaining your approach



public class ContructPreAndInOrder {
	 
	  int idx=0;
	  Map<Integer,Integer> map = new HashMap<>();
	    
	    public TreeNode buildTree(int[] preorder, int[] inorder) {
	        
	        // map to reduce time in search index of root in inorder array 
	        for(int i=0;i<inorder.length;i++){
	            map.put(inorder[i],i);
	        }
	        
	        return helper(preorder,0,inorder.length-1);
	    }
	    
	    public TreeNode helper(int[] pre,int start,int end){
	        // base condititon 
	        if(start>end)
	            return null;
	        
	        // logic 
	        int rootVal =pre[idx];
	        idx++;
	        
	        int rootIndex = map.get(rootVal);
	        
	        TreeNode root = new TreeNode(rootVal);
	        root.left = helper(pre,start,rootIndex-1);
	        root.right = helper(pre,rootIndex+1,end);
	        return root;
	        
	    }
}
