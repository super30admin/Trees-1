//Time complexity : O(N)
//Space complexity : O(N)

//Time complexity : O(N)
//Space complexity : O(N)

class Solution {

    public boolean isValidBST(TreeNode root) {

        if(root == null) return true;
        return helper(root, null, null);
    }

    private boolean helper(TreeNode root, Integer min, Integer max){
        //base
        if(root == null) return true;
        //logic
        //boolean case1 = helper(root.left, min, root.val);
        if(min!=null && root.val<=min) return false;
        if(max!=null && root.val>=max) return false;
        // boolean case2 = helper(root.right, root.val, max);

        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }


}
















//iterative solution


class Solution {

    TreeNode prev;
    boolean isValid;
    public boolean isValidBST(TreeNode root) {
        if(root == null ) return true;
        //Iterative approach
        //     Stack<TreeNode> s= new Stack<>();
        //     while(root!=null || !s.isEmpty()){
        //         while(root!=null){
        //             s.push(root);
        //             root = root.left;
        //         }
        //         root = s.pop();
        //         System.out.println(root.val+" ");
        //         root = root.right;
        //     }
        // return false;

        isValid = true;
        inorder(root);
        return isValid;
    }

    private void inorder(TreeNode root){
        // base condition
        if(root == null ) return;
        inorder(root.left);
        if(prev != null && prev.val >= root.val ){
            isValid = false;
        }
        //System.out.println("Left: "+root.val);
        prev = root;
        inorder(root.right);
        //System.out.println("Left: "+root.val);
    }

}