// Time Complexity :O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach


public class treeFromPreToIn {

    HashMap<Integer, Integer> sMap=new HashMap<>();
    int idx=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        for(int i=0;i<inorder.length;i++){
            sMap.put(inorder[i],i);
        }
        
        return helper(preorder, inorder, 0,inorder.length-1);       
    }
    
    private TreeNode helper(int[] preorder, int[] inorder, int start, int end){
        if(start>end)
            return null;
        
        TreeNode root=new TreeNode(preorder[idx]);
        idx++;
        
        if(root==null)
            return null;
        
        if(start==end)
            return root;
        
        int index=sMap.get(root.val);
        
        root.left = helper(preorder, inorder, start, index-1);
        root.right = helper(preorder, inorder, index+1, end);
        
        return root;
        
    }
    
}
