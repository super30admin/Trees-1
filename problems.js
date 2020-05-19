// ## Problem 1, Validate Binary Search Tree

// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes

// https://leetcode.com/problems/validate-binary-search-tree/

const isValidBST = function(root) {
    let st = [];
    let prev = null;
    while(root !== null || st.length > 0) {
        while(root !== null) {
            st.push(root);
            root = root.left;
        }
        // root is null
        root = st.pop();
        if(prev !== null && prev.val >= root.val) return false;
        prev = root;
        root = root.right;
    }
    return true;
};



// ## Problem 2, Construct Binary Tree from Preorder and Inorder Traversal
// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes

var buildTree = function(preorder, inorder) {
    function helper(p1, p2, i1, i2) {
        if (p1 > p2 || i1 > i2) return null; // sanity check

        var value = preorder[p1],           // get the root value
            index = inorder.indexOf(value), // get inorder position
            nLeft = index - i1,             // count nodes in left subtree
            root  = new TreeNode(value);    // build the root node

        // build the left and right subtrees recursively
        root.left  = helper(p1 + 1, p1 + nLeft, i1, index - 1);
        root.right = helper(p1 + nLeft + 1, p2, index + 1, i2);

        return root;
    }
    
    return helper(0, preorder.length - 1, 0, inorder.length - 1);
};