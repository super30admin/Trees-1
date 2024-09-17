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
    if(preorder.length == 0 || inorder.length == 0) return null;
   
    let root = new TreeNode(preorder[0]);
    //root index in inorder
    const index=inorder.indexOf(preorder[0]);
    let inleft = inorder.slice(0,index);
   let inright = inorder.slice(index+1,inorder.length);
   let preleft = preorder.slice(1,index+1);
   let  preright = preorder.slice(index+1,preorder.length);
    root.left = buildTree(preleft,inleft);
    root.right = buildTree(preright,inright);
    return root;
    
};

//time complexity : O(n)
//space complexity : O(1)