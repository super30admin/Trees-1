//Time Complexity:O(N)
//Space Complexity:O(h) for stack space
public class ValidateBSTRecursive {
    TreeNode prev;
    boolean isValid;

    public boolean isValidBST(TreeNode root) {

        isValid = true;
        inorder(root);
        return isValid;
    }

    private void inorder(TreeNode root){

        if(root == null){
            return;
        }

        //stack.push();
        inorder(root.left);
        //stack.pop()
        System.out.println("Up");
        //
        System.out.println(root.val);
        if(prev != null && prev.val >= root.val){
            System.out.println("Prev Val:"+prev.val);
            System.out.println("Current Val:"+root.val);
            isValid = false;
            return;
        }
        prev = root;

        //stack.push()
        inorder(root.right);
        //stack.pop()
        System.out.println("Down");
        System.out.println(root.val);
    }
}
