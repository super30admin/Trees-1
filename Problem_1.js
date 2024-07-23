// Time Complexity : O(n) // n is number of tree nodes
// Space Complexity : O(h) // height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {boolean}
 */
// Solution using inorder traversal since it produces a sorted tree items
// var isValidBST = function(root) {
//     var prev = null;
//     var flag = true; 


//     var inorderBST = function(root){
//         if(!flag) return;
//         if(root == null) return;
//         inorderBST(root.left);
//         if(prev!= null && prev.val >= root.val){
//             flag = false;
//         }
//         prev = root;
//         inorderBST(root.right);
//     }

//     inorderBST(root);
//     return flag;
// };
// Can do this using global flag i.e. void based recursion or booleab based i.e. where each recursion fn returns boolean value
//Also works with any order traversals i.e pre, in or post. 
var isValidBST = function(root) {
    var flag = true;

    var isValidBSTHelper = (root, min, max) => {
            //base case
            if(root === null) return;
            if(!flag) return; // conditional recursion
            if (min!= null && root.val <= min){
                flag = false;
            }
            if(max!=null && root.val >= max){
                flag = false; 
            }

            //logic
            isValidBSTHelper(root.left, min , root.val);

            isValidBSTHelper(root.right, root.val, max);
    }
    isValidBSTHelper(root, null, null);
    return flag;
 }

