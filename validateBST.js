// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

var isValidBST = function(root) {

    const stack = [];
    let prev = -Infinity, curr = root;
    while (curr || stack.length) {
        while (curr) {
            stack.push(curr);
            curr = curr.left;
        }
        curr = stack.pop();
        if (prev >= curr.val) {
            return false;
        }
        prev = curr.val;
        curr = curr.right;
    }
    return true;
};

