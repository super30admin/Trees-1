import java.util.Stack;

public class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode() {}
  TreeNode(int val) { this.val = val; }
  TreeNode(int val, TreeNode left, TreeNode right) {
  this.val = val;
  this.left = left;
  this.right = right;
  }
  }
 

/*This approach uses the iterative approach using stack and inorder traversal and compares the current element with previous element
Since for the inorder traversal we will have a asecending order for the binary search tree
Time Complexity -> O(n);
Space COmplexity -> O(n) -> Stack space
*/
class Solution1 {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return false;
        }
        TreeNode prev = null;
        Stack<TreeNode> s = new Stack<>();
        while (root != null || !s.isEmpty()) {
            while (root != null) {
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            if (prev != null && prev.val >= root.val) {
                return false;

            }
            prev = root;
            root = root.right;
        }
        return true;
    }
}

/*
This approach uses recursive approach of inorder traversal ans compares the previous element with the current element
Time COmplexity -> O(N)
Space Complexity -> O(H) recursive stack space which is equal to the height of the tree
*/

class Solution2 {
    TreeNode prev;
    boolean isValid;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        isValid = true;
        inOrder(root);
        return isValid;
    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        if (prev != null && prev.val >= root.val) {
            isValid = false;
            return;
        }
        prev = root;
        inOrder(root.right);

    }
}

/*
This approach uses recursive one here the function will return boolean instead of having the void
Time COmplexity -> o(N)
space Complexity -> O(H)
*/

class Solution3 {
    TreeNode prev;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return inOrder(root);
        
    }

    private boolean inOrder(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean case1 = inOrder(root.left);
        if (prev != null && prev.val >= root.val) {
            return false;
        }
        prev = root;
        boolean case2 = inOrder(root.right);
        return case1 && case2;

    }
}

/*
This approach uses the recursive one and any traversal order can be used
Time COmplexity ->O(N)
Space Complexity -> O(H)
*/


class Solution4 {
    boolean isValid;
    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }
        isValid = true;
        inOrder(root, null, null);
        return isValid;
    }

    private void inOrder(TreeNode root, Integer min, Integer max) {
        if(root == null) {
            return;
        }
        inOrder(root.left, min, root.val);
        if((min != null && min>= root.val) || (max != null && max<=root.val)) {
            isValid = false;
            return;
        }
        inOrder(root.right, root.val, max);
    }
}


class Solution5 {

    public boolean isValidBST(TreeNode root) {
        return inOrder(root, null, null);
    }

    private boolean inOrder(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }
        boolean case1 = inOrder(root.left, min, root.val);
        if ((min != null && min >= root.val) || (max != null && max <= root.val)) {
            return false;
        }
        boolean case2 = inOrder(root.right, root.val, max);
        return case1 && case2;
    }
}