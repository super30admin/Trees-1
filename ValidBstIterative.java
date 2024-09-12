//Iterative
//T.C = O(N) we traverse each node
//S.C = O(H) where H=height of the tree

class Solution {

    public boolean isValidBST(TreeNode root) {
      if(root==null)return true;
      Stack<TreeNode>s=new Stack<>();
      TreeNode prev=null;
      while(root!=null || !s.isEmpty()){
           while(root!=null){
              s.push(root);
                root=root.left;
             }
            root=s.pop();
           if(prev!=null && prev.val>=root.val){
             return false;
           }             
           prev=root;
           root=root.right;
        }

       return true;
    }

}
