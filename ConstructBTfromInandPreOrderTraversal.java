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

/*
* The idea is tp use properties of both the traversals to construct the tree. 
Preorder -> root-left-right
Inorder -> left-root-right
* Bruteforce Approach: 
    *We can get the root from the first index of preorder array
    * Once we have the root, we can use inorder array to check the left subtree elements and right subtree elements
    * So everytime we find the root, we will have two subarrays; left and right from inorder and we can do the same process of finding the root using preorder

*/

//TC: O(n^2) -> repeated scanning and copying -> rootindex lookup for each recursive call and arraySlicing and deep copy O(k) but in worst case skewed tree it will be O(n) 
//SC: O(n^2) -> recursive stack and deep copy of array at each recursive stack call

//Approach: 1
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //base 
        if(preorder.length == 0)
            return null;
        //logic
        // get the rootindex val from preorder and find the index of root in inorder to split the array further into left and right
        int rootVal = preorder[0];
        int rootidx = -1;

        for(int i = 0; i < inorder.length; i++){
            if(inorder[i] == rootVal){
                rootidx = i;
                break;
            }
        }
        //make deep copy of left and right subarray for inorder and preorder arrays
        // copyOfRange takes one additional index i.e 0 to rootidx (exclusive)
        int[] inLeft = Arrays.copyOfRange(inorder, 0, rootidx);
        int[] inRight = Arrays.copyOfRange(inorder, rootidx + 1, inorder.length);

        // preorder starts from 1 because 0th will always be the root
        int[] preLeft = Arrays.copyOfRange(preorder, 1, inLeft.length + 1);
        int[] preRight = Arrays.copyOfRange(preorder, inLeft.length + 1, preorder.length);

        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(preLeft, inLeft);
        root.right = buildTree(preRight, inRight);

        return root;
    }
}

// Approach 2:

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

/*
* In the previous approach we saw that we were splitting the array in every recursive call and hence we needed to find root for everytime we create the subarray
* To optimize that, instead of splitting the array, we keep pointers
1. one pointer to get root on preorder array
2. pair of pointers to get left and right subtree on inorder array
    - to get the indices of left baby: the span of left subtree -> start(parent start) to rootVal idx - 1
    - to get the indices of right baby: the span of right subtree - > rootVal idx + 1 to end (parent end)
* Iterating over the inorder array to get index of the root node can be solved by using a map
*/

//TC: O(n) -> iterating through the array
// SC: O(n) -> map to get index of elements on inorder array
class Solution {
    //global variables
    // to store elements with indices in inorder
    HashMap<Integer, Integer> map;
    // iterate over preorder array to get the root
    int idx;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.map = new HashMap<>();
        this.idx = 0;

        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }

        return helper(preorder, 0, inorder.length - 1);   
    }

    // parameters: preorder to iterate through the array, pair of pointers to get the left and right subtree, we want the recursive call to bring the start and end with itself
    private TreeNode helper(int[] preorder, int start, int end){
        //base
        // start and end has crossed each other i.e no elements there, return null
        if(start > end)
            return null;
        //logic
        int rootVal = preorder[idx];
        int rootIdx = map.get(rootVal);

        TreeNode root = new TreeNode(preorder[idx]);
        idx++;
        root.left = helper(preorder, start, rootIdx - 1);
        root.right = helper(preorder, rootIdx + 1, end);
        return root;

    }
}
