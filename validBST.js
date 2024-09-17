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
//Iterative Solution
var isValidBST = function(root) {
    //iterative
    let prev = null;
    let st = [];
    while(root != null || st.length ){
        while(root != null){
            st.push(root);
            root = root.left;
        }
        root = st.pop();
        if(prev!=null && prev.val >= root.val) return false;
        prev = root;
        root = root.right;
    }
    return true;
    
};

//Time Complexity : O(N)-N: no. of nodes
//space conplexity : O(h)-h: height of the tree


//Recursive
let prev = null;
var isValidBST = function(root) {
    return inorder(root);
    
};

var inorder = function(root) {
    //base
    if(root == null) return true;
    //logic
    inorder(root.left);
    if(prev!= null && prev.val >= root.val ) return false;
    prev = root;
    return inorder(root.right);
}

//time complexity :O(N)
//space complexity : O(h)