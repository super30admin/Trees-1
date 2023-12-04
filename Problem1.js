//https://leetcode.com/problems/validate-binary-search-tree/
// Accepted in Leetcode
//TC is O(n) and SC is O(n)

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
var isValidBST = function(root) {

    const validate = (node)=>{
        return helper(node, Number.MIN_SAFE_INTEGER, Number.MAX_SAFE_INTEGER)
    }

    const helper=(node, min, max)=>{
        if(node === null) return true;
    
        if(node.val<=min || node.val>=max){
            return false
        }

        return(
                helper(node.left, min, node.val) && helper(node.right,node. val, max))
    }

return validate(root);
    
};
