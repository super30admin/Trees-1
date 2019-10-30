/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/* 105. Construct Binary Tree from Preorder and Inorder Traversal, no duplicates
Time Complexity: O(n^2) for every recursive call we are searching for an element, we are finding the root of the subtrees everytime. Worst case when tree is left skewed
Space Complexity: O(n)
*/

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0) return null;

        TreeNode root= new TreeNode(preorder[0]);
        int index = -1;
        for(int i=0; i<inorder.length; i++){
            if(inorder[i] == root.val){
                index = i;
                break;
            }
        }

        int[] pre_left = Arrays.copyOfRange(preorder, 1, index+1);
        int[] pre_right = Arrays.copyOfRange(preorder, index+1, preorder.length);
        int[] in_left = Arrays.copyOfRange(inorder, 0, index);
        int[] in_right = Arrays.copyOfRange(inorder, index+1, inorder.length);

        root.left = buildTree(pre_left, in_left);
        root.right = buildTree(pre_right, in_right);

        return root;
    }
}

/* 105. Construct Binary Tree from Preorder and Inorder Traversal, no duplicates
Time Complexity: O(n)
Space Complexity: O(n)
*/
class Solution {
    int pre_index = 0;
    int[] preorder;
    int[] inorder;
    HashMap<Integer, Integer> index_map = new HashMap<>();

    public TreeNode helper(int index_left, int index_right){
        if(index_left == index_right)
            return null;

        TreeNode root = new TreeNode(preorder[pre_index]);

        int search_index = index_map.get(root.val);

        //recursion
        pre_index++;
        root.left = helper(index_left, search_index);
        root.right = helper(search_index+1, index_right);

        return root;
    }


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;

        int index = 0;
        for(Integer i: inorder)
            index_map.put(i, index++);

        return helper(0, inorder.length);
    }
}

