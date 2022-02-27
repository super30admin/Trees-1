
class Solution {

// space complexity - o(n) - number of nodes
      //time - o(n) where n is number of nodes
      //Ran on Leetcode successfully : Yes
      // Problem faced  : No
//recursive inorder, increasing order approach

    boolean flag = true;
    long i = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if(root == null) return false;
        inOrder(root);
        return flag;
    }

    public void inOrder(TreeNode root ){
        if( root == null) return;
        inOrder(root.left);
        if(i >= root.val) flag = false;
        i = root.val;
        inOrder(root.right);
    }

// Recursive preorder, range approach
    public boolean isValidBST(TreeNode root) {
        return preOrder(root,  Long.MIN_VALUE,  Long.MAX_VALUE);
    }

    public boolean preOrder(TreeNode root, Long low, Long high){

        if( root == null) return true;

        if(root.val <= low || root.val >= high ) return false;

        return preOrder(root.left, low, Long.valueOf(root.val)) &&
                preOrder(root.right,  Long.valueOf(root.val), high);
}

    //Iterative own stack inorder approach
    public boolean isValidBST(TreeNode root) {

        long i = Long.MIN_VALUE;

        Stack<TreeNode> s = new Stack<>();

        //Initalize stack with all the left elements i.e. go  to all the way to left
        while(root != null){
          s.push(root);
          root = root.left;
        }

// Now while stack is not empty , pop the elememt visit it and go to its right child, once you go to right child,
// NOw repeat teh same steps as above and go all the way to left most element
        while(!s.isEmpty()){
            root = s.pop();

            if(root.val <= i) return false;
            i = root.val;

            root = root.right;

            while(root != null){
              s.push(root);
              root = root.left;
            }
          }

        return true;
    }


}
