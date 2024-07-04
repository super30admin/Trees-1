public class ConstructBinaryTree {
}


/**
    LC - 105. Construct Binary Tree from Preorder and Inorder Traversal

    Approach: Recursion with HashMap

    Working:
        Having preorder and inorder array
        Root L R - Preorder array - can be used for getting the root
        L Root R - inorder array = can be used for get the left and right subtrees

        Declare an index idx = 0
        Declare a hash map -> (inorder[i], i) and adding the inorder array based on {value, index} key pair

        recurse(int[] preorder, int start, int end)
            //base case

            get the rootValue from preorder array with idx
            increment idx //to get the next root in the following recursion

            create a tree node with rootValue

            //now whe have to determine the left and right subtree of the root
            //the left and right subtree range will be obtained from inorder traversal array

            get the rootIndex from the inorder {value, index} map

            //recurse
            //recurse to form left and right subtree
            root.left = recurse(preorder, start, rootIndex-1)
            root.right = recurse(preorder, rootIndex+1, end)

            return root





    Time Complexity: O(n)

    Space Complexity: O(2n) -> O(n)
        O(n) - adding values in hash map
        O(n) - construction a tree

 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    HashMap<Integer, Integer> map;
    int idx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if(preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
            return null;
        }

        map = new HashMap<>();
        for(int i=0;i<inorder.length;i++) {
            map.put(inorder[i], i);       //adding the inorder array to map, to get value base index
        }
        idx = 0;

        return recurse(preorder, 0, preorder.length-1);
    }

    private TreeNode recurse(int[] preorder, int start, int end) {

        if(start > end) {
            return null;
        }

        int rootVal = preorder[idx]; //getting the root from preorder traversal
        idx++;
        TreeNode root = new TreeNode(rootVal);

        /*
            getting the index value of root in inorder L Root R
            so that we can get the left and right subtree boundries

        */
        int rootIndex = map.get(rootVal);

        //recurse to form left and right subtree
        root.left = recurse(preorder, start, rootIndex-1);
        root.right = recurse(preorder, rootIndex+1, end);

        return root;
    }
}