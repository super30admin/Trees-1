// Time Complexity : O(T(n/2)+n)where N/2 is because we are dividing and n because of the for loop which is O(n)(Masters Theorm) 
// Space Complexity : O(n^2)  since we are making two lists(of size n) n times
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

// we use a recursive approach where our base case is if preorder/inorder null(return null for this which can be used in root.left or root.right of subtree in case they are null)
//if not  here we know that the first element of preorder of any subprob will give me the current root.
// we find that value in the inorder(say at idx,this is where our root is present for inorder)  and break into right(exclude root) and left subarray(exclude root)
// at that idx we break our preorder as well into left(start from 1 since first is root) and right subarray 
// create a new node ROOT with val as the val of the first element in preorder(root) 
// for root.left,we will  buildtree(preleft and inleft)(subprob) similarly for the root.right(subprob)
// return the new root created

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        // base case
        if (preorder == null || preorder.length == 0)
            return null;

        int val = preorder[0];
        int i;
        TreeNode root = new TreeNode(val);

        for (i = 0; i < inorder.length; i++) {
            if (val == inorder[i])
                break;
        }

        int[] preLeft = Arrays.copyOfRange(preorder, 1, i + 1);
        int[] preRight = Arrays.copyOfRange(preorder, i + 1, preorder.length);

        int inLeft[] = Arrays.copyOfRange(inorder, 0, i);
        ;
        int inRight[] = Arrays.copyOfRange(inorder, i + 1, inorder.length);

        root.left = buildTree(preLeft, inLeft);
        root.right = buildTree(preRight, inRight);
        return root;
    }
}