// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yess
// Any problem you faced while coding this : whilesplittong left and right node.


// Your code here along with comments explaining your approach: I used hashMap to fint the root value and did Recursion to make BT
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> map= new HashMap<>();
        for(int i=0;i<inorder.length; i++){
            map.put(inorder[i],i);
        }
        return constructBinaryTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, map);
        
    }
    public TreeNode constructBinaryTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, HashMap<Integer,Integer> map){

        if(preStart>preEnd || inStart>inEnd) return null;
        TreeNode root=new TreeNode(preorder[preStart]);
        int idx= map.get(root.val);
        int leftSize= idx-inStart;
    root.left=constructBinaryTree(preorder, preStart+1, preStart+leftSize, inorder, inStart, idx-1, map);
    root.right=constructBinaryTree(preorder, preStart+leftSize+1, preEnd, inorder, idx+1, inEnd, map);

    return root;
    }

}