//Time: O(N) //traversing through n elements
//Space: O(h) //max space used in the stack is one whole path
//Iterative approach to print BST inorder
class Solution{
    public boolean inorderBST(TreeNode root){
        if(root == null)
            return true;
        
        Stack<TreeNode> stack = new Stack<>();

        while(root != null || !stack.isEmpty()){
            //left
            while(root!= null){
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            System.out.println(root.val);

            //right
            root = root.right;
        }

        return true;
    }
}