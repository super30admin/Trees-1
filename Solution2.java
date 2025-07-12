// Time Complexity:O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


class Solution {
    int preOrderIndex=0;

    Map<Integer, Integer> inOrderMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
       for(int i=0;i<inorder.length;i++){
       inOrderMap.put(inorder[i],i);
       
       } 
        return helper(preorder,0,inorder.length-1);
       }
        public TreeNode helper(int[] preorder, int left,int right) {
            if (left>right){
                return null;
            }
           int rootvalue = preorder[preOrderIndex++]; 
           TreeNode root = new TreeNode(rootvalue);
           int inorderIndex = inOrderMap.get(rootvalue);
            root.left  =helper(preorder,left,inorderIndex - 1);
            root.right =helper(preorder,inorderIndex + 1,right);
            return root;
           }
           }