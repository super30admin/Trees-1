// Time Complexity :O(n)
// Space Complexity :O(n) 
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

class PreorderInorderTree {
    Map<Integer,Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null || preorder.length == 0) return null;
        if(preorder.length == 1) return new TreeNode(preorder[0]);
        
        map = new HashMap<>();
        for(int i = 0; i < preorder.length; i++){
            map.put(inorder[i],i);
        }
        return helper(preorder, inorder, 0, 0, preorder.length-1);        
    }
    
    public TreeNode helper(int[] preorder, int[] inorder, int proot, int left, int right){
        //base
        if(left > right || left < 0 || right >= preorder.length || proot < 0 || proot >= preorder.length) return null;
        
        //logic
        TreeNode node = new TreeNode(preorder[proot]);
        
        //find root in inorder
        int idx = map.get(preorder[proot]);
        
        //recurse
        node.left = helper(preorder, inorder, proot+1, left, idx-1);
        node.right = helper(preorder, inorder, proot+idx-left+1, idx+1, right);
        return node;
    }
}
