//Method 1: Iterative approach
// Time Complexity :O(N)
// Space Complexity :O(h) where h is height of tree from root to leaf
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :Yes


// Your code here along with comments explaining your approach
class Solution {

    public boolean isValidBST(TreeNode root) {
         if(root==null) return true;
         TreeNode prev=null;
         Stack<TreeNode> st=new Stack<>();
         while(root!=null||!st.isEmpty()){
             while(root!=null){
                 st.push(root);
                 root=root.left;
             }
             root=st.pop();
             if(prev!=null&&prev.val>=root.val) return false;
              prev=root;
              root=root.right;
         }
         return true;

    }

}
//Method 2: Recursive approach
// Time Complexity :O(N)
// Space Complexity :O(h) where h is height of tree from root to leaf
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :Yes

class Solution {
    TreeNode prev;
    boolean result;
    public boolean isValidBST(TreeNode root) {
        result=true;
        if(root==null)
            return result;
        inorder(root);
        return result;
    }
    private void inorder(TreeNode root){
        if (root==null) return;
        inorder(root.left);
        if(prev!=null&&prev.val>=root.val){
            result=false;
            return;
        }
        prev=root;
        inorder(root.right);
    }
}