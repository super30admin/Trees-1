//Time Complexity: O(n)
//Space Complexity: O(n)
//Runs: Yes


var isValidBST = function (root) {
    let result = true;
    let prev;
    var inorder = function (root) {
        if (root === null) return;

        inorder(root.left);
        if (prev !== undefined && prev >= root.val) {
            result = false;
            return;
        }
        prev = root.val;
        inorder(root.right);
    }

    inorder(root);
    return result;
};