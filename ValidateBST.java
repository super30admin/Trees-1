/*
    Time Complexity - O(N)
    Space Complexity - O(N)
    Solved to problem using iterative process by going over the inorder of BST and checking if the current value is lower or equal to the
    previous value. Yes, the code passed all the test cases in leetcode.
*/


class Solution {
    public boolean isValidBST(TreeNode root) {

        double highest = -Double.MAX_VALUE; boolean isBST = true;

        Stack<TreeNode> stack = new Stack<>(); TreeNode curr=root;

        while(curr!=null || !stack.empty()){


            while(curr!=null){
                stack.add(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            if(curr.val<=highest){
                isBST = false;
                break;
            }

            highest = curr.val;
            curr = curr.right;
        }

        return isBST;

    }
}