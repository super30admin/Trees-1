// Construct Binary Tree from Preorder and Inorder Traversal (LC 105)
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : No
// Look at preorder and inorder to create left and right nodes and then create the tree

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
 * @param {number[]} preorder
 * @param {number[]} inorder
 * @return {TreeNode}
 */

var buildTree = function(preorder, inorder) {
    let n = preorder.length;
    if(n === 0){
        return null;
    }
    let hashMap = {};
    for(let i=0;i<inorder.length;i++){
        hashMap[inorder[i]] = i; 
    }
    function helper(preorder, inorder, k, h){
        if(k > h){
            return null;
        }
        let val = preorder.shift();
        let root = new TreeNode(val);
        index = hashMap[val];
        
        root.left = helper(preorder, inorder, k, index - 1);
        root.right = helper(preorder, inorder, index + 1, h);
        
        return root;
    }
    
    root = helper(preorder, inorder, 0, n-1);
    return root;
};
