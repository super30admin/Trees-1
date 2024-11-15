
 // Definition for a binary tree node.
  class TreeNode {
      val: number
      left: TreeNode | null
      right: TreeNode | null
      constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
          this.val = (val===undefined ? 0 : val)
          this.left = (left===undefined ? null : left)
          this.right = (right===undefined ? null : right)
      }
 }
 

 let prev: number | null = null;
 function isValidBST(root: TreeNode | null): boolean {
     prev = null;
     return helper(root);
 };
 
 const helper = (root: TreeNode | null): boolean => {
     if (root === null) return true;
     if( !helper(root.left)) return false;
     if (prev !== null && prev >= root.val) {
         return false
     }
     prev = root.val;
     return  helper(root.right);  
 }