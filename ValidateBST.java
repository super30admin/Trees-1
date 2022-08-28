//Did this code run on LeetCode: Yes

//Approach 1 - Recursive approach
public class ValidateBST {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    TreeNode prev;
    boolean flag;

    public boolean isValidBST(TreeNode root) {
        flag = true;
        inorder(root);
        return flag;
}
    private void inorder(TreeNode root){
        //base
        if(root == null)
            return;
        //logic
        inorder(root.left);
        if(prev != null && prev.val >= root.val)
        {
            flag = false;
        }
        prev = root;
        inorder(root.right);
}
}

//Iterative approach for inorder traversal
public class ValidateBST {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

public boolean isValidBST(TreeNode root){
    Stack<TreeNode> st = new Stack<>();

    TreeNode prev = null;

    while(root != null || !st.isEmpty()){
        while(root != null){
            st.push(root);
            root = root.left;
        }
        root = st.pop();
        if(prev != null && prev.val >= root.val)
        {
            return false;
        }
        prev = root;
        root = root.right;
    }
    return true;
}    
}

//Approach 3 - Range of minimum and maximum
public boolean isValidBST(TreeNode root){
    return helper(root,null,null);
}

private boolean helper(TreeNode root, Integer min, Integer max){
    //base
    if(root == null)
        return true;
    if(min != null && root.val <= min)
        return false;
    if(max != null && root.val >=max)
        return false;
    //logic
    boolean left = helper(root.left,min,root.val);
    boolean right = helper(root.right,root.val,max);
    return left && right;
}