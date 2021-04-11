// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach
class Solution {
    HashMap<Integer,Integer> inorderIndexMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inorderIndexMap = new HashMap<>();
        for(int i = 0 ; i <inorder.length ; i++){
            inorderIndexMap.put(inorder[i],i);
        }
        return helper(preorder,0,preorder.length-1);
    }
    
    private TreeNode helper(int[] preorder,int start,int end){
        if(start > end) return null;
        if(start == end){
            return new TreeNode(preorder[start]);
        }
        int rootValue = preorder[start];
        TreeNode root = new TreeNode(rootValue);
        
        root.left = helper(preorder,start+1,inorderIndexMap.get(rootValue));
        root.right = helper(preorder,inorderIndexMap.get(rootValue)+1,end);
        return root;
    }
}
