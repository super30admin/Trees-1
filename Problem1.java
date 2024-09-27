/*
* Time Complexity - O(n) - n - nodes in tree
* Space Complexity - O(logn)
*/



class Solution {
    TreeNode prev = null;
    public boolean isValidBST(TreeNode root) {

//         Stack<TreeNode> stack = new Stack<>();
//         TreeNode prev = null;
//         while(root != null || !stack.isEmpty()){
//           while(root != null){
//             stack.push(root);
//             root = root.left;
//             }
//         root = stack.pop();
//         if(prev!= null && prev.val >= root.val){
//             return false;
//         }
//         prev = root;
//         root = root.right;
//         }
//        return true;

        return helper(root, null, null);

    }

//     private boolean helper(TreeNode curr){

//         if(curr == null){
//             return true;
//         }

//         if(!helper(curr.left)){
//             return false;
//         }

//         if(prev != null && prev.val >= curr.val){
//             return false;
//         }

//         prev = curr;

//         return helper(curr.right);

//     }

    private boolean helper(TreeNode curr, Integer min, Integer max){

        if(curr == null)
            return true;

        if(min != null && curr.val <= min) return false;

        if(max != null && curr.val >= max) return false;

        return helper(curr.left, min,curr.val) && helper(curr.right,curr.val,max);

    }


}