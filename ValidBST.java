// In this we are doing inorder traversal and at any given point of time we are just comparing the previous node value with current 
// node value, if the previous is greater than or equal then it is not a valid BST. 

// In other approach which is traversal independant, at any node we are maintaining min and max, set the min and max to null initially, 
// whenever we move left, we know that node value will be between parent's min and parent node val itself i.e. we dont know min yet but 
// max we know that it cannot exceed the parent's node val. And vice versa for whenever we are moving right. At each node, check if the 
// value lies between min and max or not. If yes than valid else invalid.

// Time Complexity : O(n) - no. of nodes
// Space Complexity : O(h) - height of the tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

// Recursive implementation of in-order traversal
class Solution {
    public boolean isValidBST(TreeNode root) {
        // Base case
        if (root == null) {
            return true;
        }
        // Call the recursive function with root as the parameters, doing inorder
        // traversal
        inorder(root);
        return true;
    }

    private void inorder(TreeNode root) {
        // Base case
        if (root == null) {
            return;
        }
        // Left recursive call
        inorder(root.left);
        // Processing
        System.out.println(root.val);
        // Right recursive call
        inorder(root.right);
    }
}

// Iterative implementation of in-order traversal
class Solution1 {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> s = new Stack<>();
        while (root != null || !s.isEmpty()) {
            while (root != null) {
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            System.out.println(root.val);
            root = root.right;

        }
        return true;
    }
}

// Solution for actual problem - recursive - with prev in global scope
class Solution2 {
    // Maintain a prev at each point, to compare it with current. Since we know that
    // inorder traversal gives sorted order, that means prev.val<curr.val always
    TreeNode prev;
    // Flag for valid
    Boolean isValid;

    public boolean isValidBST(TreeNode root) {
        // Base case
        if (root == null) {
            return true;
        }
        // Set the flag as true
        isValid = true;
        // Call recursive inorder method
        inorder(root);
        // Return flag
        return isValid;
    }

    private void inorder(TreeNode root) {
        // Base case
        if (root == null) {
            return;
        }
        // Left recursive call
        inorder(root.left);
        // Processing - check if prev >= curr, means it's a breach, set the flag to
        // false and return
        if (prev != null && prev.val >= root.val) {
            isValid = false;
            return;
        }
        // Else set prev to curr and move
        prev = root;
        // Right recursive call
        inorder(root.right);
    }
}

// Solution for actual problem - recursive - with prev in local scope - this
// will not work - for reason refer notes
class Solution2 {
    Boolean isValid;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        isValid = true;
        inorder(root, null);
        return isValid;
    }

    private void inorder(TreeNode root, TreeNode prev) {
        if (root == null) {
            return;
        }
        inorder(root.left, prev);
        if (prev != null && prev.val >= root.val) {
            isValid = false;
            return;
        }
        prev = root;
        inorder(root.right, prev);
    }
}

// Solution for actual problem - iterative - with prev in global scope
class Solution3 {
    TreeNode prev;
    Boolean isValid;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        isValid = true;
        Stack<TreeNode> s = new Stack<>();
        while (root != null || !s.isEmpty()) {
            while (root != null) {
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            if (prev != null && prev.val >= root.val) {
                isValid = false;
                break;
            }
            prev = root;
            root = root.right;
        }
        return isValid;
    }
}

// Solution for actual problem - iterative - with prev in local scope
class Solution3 {

    Boolean isValid;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        isValid = true;
        TreeNode prev = null;
        Stack<TreeNode> s = new Stack<>();
        while (root != null || !s.isEmpty()) {
            while (root != null) {
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            if (prev != null && prev.val >= root.val) {
                isValid = false;
                break;
            }
            prev = root;
            root = root.right;
        }
        return isValid;
    }
}

// Traversal independant solution: (min and max)
// In order
class Solution2 {
    // Flag for isValid
    Boolean isValid;

    public boolean isValidBST(TreeNode root) {
        // Base case
        if (root == null) {
            return true;
        }
        // Set flag to true
        isValid = true;
        // Call recursive function with min and max set to null
        inorder(root, null, null);
        return isValid;
    }

    private void inorder(TreeNode root, Integer min, Integer max) {
        // Base case
        if (root == null) {
            return;
        }
        // Left recursive call, with same min but max as root.val
        inorder(root.left, min, root.val);
        // Processing - check if the node val lies between min and max
        if ((min != null && min >= root.val) || (max != null && max <= root.val)) {
            isValid = false;
            return;
        }
        // Right recursive call, with same max but min as root.val
        inorder(root.right, root.val, max);
    }
}

// pre
class Solution2 {
    TreeNode prev;
    Boolean isValid;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        isValid = true;
        inorder(root, null, null);
        return isValid;
    }

    private void inorder(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return;
        }
        if ((min != null && min >= root.val) || (max != null && max <= root.val)) {
            isValid = false;
            return;
        }
        inorder(root.left, min, root.val);
        inorder(root.right, root.val, max);
    }
}

// Post
class Solution2 {
    TreeNode prev;
    Boolean isValid;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        isValid = true;
        inorder(root, null, null);
        return isValid;
    }

    private void inorder(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return;
        }

        inorder(root.left, min, root.val);
        inorder(root.right, root.val, max);
        if ((min != null && min >= root.val) || (max != null && max <= root.val)) {
            isValid = false;
            return;
        }
    }
}

class Solution2 {

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        // isValid = true;
        return inorder(root, null, null);
        // return isValid;
    }

    private boolean inorder(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }

        boolean case1 = inorder(root.left, min, root.val);
        boolean case2 = inorder(root.right, root.val, max);
        // Write this below if check between case1 and case2 or before or after, it will
        // work
        if ((min != null && min >= root.val) || (max != null && max <= root.val)) {
            return false;
        }
        return case1 && case2;
    }
}

// below also works
class Solution2 {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        // isValid = true;
        return inorder(root, null, null);
        // return isValid;
    }

    private boolean inorder(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }
        if ((min != null && min >= root.val) || (max != null && max <= root.val)) {
            return false;
        }
        return inorder(root.left, min, root.val) && inorder(root.right, root.val, max);
    }
}