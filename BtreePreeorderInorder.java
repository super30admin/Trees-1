/**
// Time Complexity : O(n)
// Space Complexity :O(n) store index and val from inorder array.
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english
  //1.do div and conq on inorder array.
  //2.preorder array dictates which node should be created next.
  //using next elem in preorder find the index of node to be created in inorder
  //array, use this index for div aqnd conq.
  //3.in div and conq on inorder array, elems to left of node.
  //are left sub tree kids, and right are right sub tree kids.
 */
class Solution {
    int preIndx = 0;
    HashMap<Integer, Integer>inorderindx = new HashMap<>();
    private TreeNode helper(int[] preorder, int[] inorder, int strt, int end){

        if(strt > end)
            return null;

        int rootVal = preorder[preIndx];
        int rootIndx = inorderindx.get(rootVal);

        TreeNode node = new TreeNode(rootVal);
        preIndx++;

        node.left = helper(preorder, inorder, strt, rootIndx-1);
        node.right = helper(preorder, inorder, rootIndx+1, end);

        return node;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0 ; i < inorder.length; i++){
            inorderindx.put(inorder[i], i);
        }
        return helper(preorder, inorder, 0, inorder.length -1);
    }
}
