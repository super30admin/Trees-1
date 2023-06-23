import java.util.Stack;

public class ValidateBST_Iterative {


    //ITERATION


        public boolean isValidBST(TreeNode root) {

            if(root == null)  return true;

            Stack<TreeNode> nodeStack = new Stack<>();

            TreeNode prev = null;

            while(root != null || !nodeStack.isEmpty()){

                while(root != null) {

                    nodeStack.push(root);

                    root = root.left;
                }

                root = nodeStack.pop();

                if(prev != null && prev.val >= root.val) return false;

                prev = root;

                root = root.right;
            }
            return true;
        }

}
