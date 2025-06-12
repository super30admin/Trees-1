// ## Problem 1
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NONE, but understanding helper function early exit was tough

// https://leetcode.com/problems/validate-binary-search-tree/


var isValidBST = function(root,min= -Infinity,max=Infinity) {
    //baseCase
    if(!root)return true
    //     //**Time Complexity:  O(n) */
//     //**Space Complexity: O(1)without callstack or else O(h) h = height of tree*/
    if(!(min < root.val && root.val < max))
    {
       return false 
    }
    let left = isValidBST(root.left,min,root.val)
    let right = isValidBST(root.right,root.val,max)
    return left && right
}; 

// var isValidBST = function(root) {
        // HERE IN THIS METHOD WE HAVE TO USE in-Order to use prev
//     //**Time Complexity:  O(n) */
//     //**Space Complexity: O(1)without callstack or else O(h) h = height of tree*/
    
//     let prev = null
//     function inOrderHelper(root){
//         //Base Case
//         if(!root) return true

//         let left=inOrderHelper(root.left)
//         //process the node
//         if(prev!= null && prev.val >= root.val){
//             return false
//         }
//         prev = root
//         if (!left)return false 
//         let right=inOrderHelper(root.right)
//         return left && right //return bool
//     }
//     return inOrderHelper(root)
// };