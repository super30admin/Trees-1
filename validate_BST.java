//T.C-O(N)- worst case when the tree is BST or the "bad" element is a rightmost leaf.
 //S.C- O(N) to keep stack.   *ITERATIVE INORDER TRAVERSAL*
 import java.util.Stack;

  public class validate_BST {
      int val;
      validate_BST left;
      validate_BST right;
      validate_BST() {}
      validate_BST(int val) { this.val = val; }
      validate_BST(int val, validate_BST left, validate_BST right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

 class Solution {
    public boolean isValidBST(validate_BST root) {
        if (root==null){
            return true;
        }
        Stack<validate_BST> stack= new Stack<>();
        Integer prev=null;
        //Compute inorder traversal list inorder.
        while(root!=null || !stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root=root.left;
            }
            root=stack.pop();
            if(prev!=null && root.val<=prev){ //Check if each element in inorder is smaller than the next one.
                return false;
            }
            prev= root.val;
            root=root.right;
        }
        return true;
    }
}