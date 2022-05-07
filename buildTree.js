// Time Complexity : O(n^2) where n in number of element in a tree
// Space Complexity : O(n) where n in number of element in a tree

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

// preorder = [3,9,20,15,7]
// inorder = [9,3,15,20,7]

//Solution 1 : Brute Force Solution
var buildTree = function(preorder, inorder) {
    //base case
    if(preorder.length === 0) return null;
    
    let root = new TreeNode(preorder[0]);
    let rIndex;
    for(let i=0;i<inorder.length;i++) {
        if(inorder[i]===root.val) {
            rIndex = i;
            break;
        }
    }
    let pl = preorder.slice(1,rIndex+1);
    let pr = preorder.slice(rIndex+1,preorder.length);
    let il = inorder.slice(0,rIndex);
    let ir = inorder.slice(rIndex+1,inorder.length);
    
    root.left = buildTree(pl,il);
    root.right = buildTree(pr,ir);
    return root;
};

//Time Complexity : O(n)
//Space Complexity : O(n)
//Solution 2 : HashMap solution
// var buildTree = function(preorder, inorder) {
//     let map = inorder.reduce((prev,curr,index) => {
//         prev.set(curr,index);
//         return prev;
//     },new Map());
//     let preIndex = 0;
//     let helper = function(left,right) {
//         //base case
//         if(left > right) return null;
//         //action
//         let root = new TreeNode(preorder[preIndex]);
//         preIndex++;
//         let rIndex = map.get(root.val);
//         root.left = helper(left,rIndex-1);
//         root.right = helper(rIndex+1,right);
//         return root;
//     }
//     return helper(0,inorder.length-1);
// };