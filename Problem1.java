public class Problem1 {
}

// Recursive solution
class Solution1 {
    TreeNode prev;
    boolean flag;

    public boolean isValidBST(TreeNode root) {
        // list = new ArrayList<>();
        flag = true;
        inOrder(root);
        // for(int i = 1; i < list.size(); i++) {
        //     if( list.get(i-1) >= list.get(i)) {
        //         return false;
        //     }
        //     // System.out.println(list.get(i));
        // }
        return flag;
    }

    public void inOrder(TreeNode root) {
        if( !flag ) {
            return;
        }
        if( root == null) return;
        inOrder(root.left);
        // list.add(root.val);
        if( prev != null && prev.val >= root.val) {
            flag = false;
            return;
        }
        prev = root;
        inOrder(root.right);
    }
}
