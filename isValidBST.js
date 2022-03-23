// Time Complexity : O(n) where n in number of element in a tree
// Space Complexity : O(n) where n in number of element in a tree
// Did this code successfully run on GeeksForGeeks : Yes
// Any problem you faced while coding this : No

// Implemented Inorder Traversal using Stack and added a condition to check if new value getting added to the res Stack is greater than top value in res Stack. 
// If not return false and break

var isValidBST = function(root) {
    let stack = [];
    let res = [];
    while(root !== null || stack.length != 0) {
        while (root !== null){
            stack.push(root);
            root = root.left;
        }
        root = stack.pop();
        if(root.val <= res[res.length-1]) {
            return false;
            break;
        }
        res.push(root.val);
        root = root.right;
    }
    return true;
};