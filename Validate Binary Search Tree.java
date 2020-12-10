/*
# Iterative
class Solution:
def isValidBST(self, root: TreeNode) -> bool:
    if root is None:
        return True
    
    prev = None
    stack = []
    while root is not None or len(stack) > 0:
        while root is not None:
            stack.append(root)
            root = root.left
        
        root = stack.pop()
        
        if prev is not None and prev.val >= root.val:
            return False
        
        prev = root
        root = root.right
    return True

# Recursive
class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        global prev
        prev = None
        def inorder(root):
            global prev
            if root is None:
                return True
            
            if inorder(root.left) is False:
                return False
            
            if prev is not None and prev.val >= root.val:
                return False
            
            prev = root
            return inorder(root.right)
         
        return inorder(root)

# This below code will not work as with every recursive call it will also store prev with root now and it will try to compare
# root to the stored prev. It may work for certain cases though        
class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        prev = None
        def inorder(root, prev):
            
            if root is None:
                return True
            
            if inorder(root.left, prev) is False:
                return False
            
            if prev is not None and prev.val >= root.val:
                return False
            
            prev = root
            return inorder(root.right, prev)
         
        return inorder(root, prev)


# Fixed the above code by passing list instead of variable as string and list are passed by reference so any changes will be reflected
# overall
class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        prev = [None]
        def inorder(root, prev):
            
            if root is None:
                return True
            
            if inorder(root.left, prev) is False:
                return False
            
            if prev[0] is not None and prev[0].val >= root.val:
                return False
            
            prev[0] = root
            return inorder(root.right, prev)
         
        return inorder(root, prev)

# Another sol with min and max value
class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        
        def inorder(root, min_value, max_value):
            
            if root is None:
                return True
            
            if min_value is not None and min_value >= root.val:
                return False
            
            if max_value is not None and max_value <= root.val:
                return False
            
            return inorder(root.left, min_value, root.val) and inorder(root.right, root.val, max_value)
         
        return inorder(root, None, None)
*/

/*
class Solution {
    public boolean isValidBST(TreeNode root) {
        return inorder(root, null, null);
    }
    
    private boolean inorder(TreeNode root, TreeNode min, TreeNode max){
        if (root == null){
            return true;
        }
        
        if (min != null && min.val >= root.val){
            return false;
        }
        if (max != null && max.val <= root.val){
            return false;
        }
        
        return (inorder(root.left, min, root) && inorder(root.right, root, max));
    }
}

*/

// Time Complexity : O(N) where N is number of nodes in tree
// Space Complexity : O(N) where tree is left or right skewed otherwise O(h) where h is heigth of tree
// Did this code successfully run on Leetcode : Yes

// Your code here along with comments explaining your approach: Started with root I maintained a prev pointer and every time I popped
// from stack I checked it prev if its greater or not as a binary tree would have elements in ascending order if done inorder traversal


class Solution {
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        prev = null;
        return inorder(root);
    }
    
    private boolean inorder(TreeNode root){
        if (root == null){
            return true;
        }
        if (inorder(root.left) == false){
            return false;
        }
        if (prev != null && prev.val >= root.val){
            return false;
        }
        prev = root;
        return inorder(root.right);
    }
}