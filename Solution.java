// Time Complexity:O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack=new Stack<>();
        Integer pre=null;
        while(root!=null||!stack.isEmpty()){
         while(root!=null){
           stack.push(root); 
           root =root.left;
         }
         root=stack.pop();
         if( pre != null && root.val <= pre){
            return false;
         }
         pre =root.val;
         root =root.right;
        }
     return true;   
    }
}