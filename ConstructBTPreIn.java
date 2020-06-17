import java.util.HashMap;

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach
//1) HashMap is used to store the inorder elements and its locations. Initialize index,start,end
//2) Make a root with preorder index and calculate its position in the map.
//3) Recursively call left by changing end and call right by changing start.

public class ConstructBTPreIn {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) { this.val = val; }
		TreeNode(int val, TreeNode left, TreeNode right) {
		    this.val = val;
		    this.left = left;
		    this.right = right;
		}
	}
	
	HashMap<Integer, Integer> map = new HashMap<>();
    int index;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i< inorder.length;i++){
            map.put(inorder[i],i);
        }
        return helper(preorder,inorder,0,preorder.length-1);
    }
    
    public TreeNode helper(int[] preorder, int[] inorder, int start, int end){
        if(start>end || index == preorder.length)return null;
        TreeNode root = new TreeNode(preorder[index]);
        int inIdx = map.get(root.val);
        index++;
        root.left = helper(preorder,inorder,start, inIdx-1);
        root.right = helper(preorder,inorder,inIdx+1,end);
        return root;
    }
}
