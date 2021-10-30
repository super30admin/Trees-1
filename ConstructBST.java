// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    int p=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    	HashMap<Integer,Integer> map=new HashMap<>();
    	for(int i=0;i<inorder.length;i++) {
    		map.put(inorder[i],i);
    	}
        return helper(preorder,inorder,0,inorder.length-1,map);
    }
    
    public TreeNode helper(int[] preorder,int[] inorder, int i,int j,HashMap<Integer,Integer> map){
       
        if(i>j){
            return null;
        }
        
        TreeNode root=new TreeNode(preorder[p]);
        int inorderIndex=map.get(root.val);
        
        p++;
        root.left= helper(preorder,inorder,i,inorderIndex-1,map);
        root.right=helper(preorder,inorder,inorderIndex+1,j,map);
        return root;
    }
}