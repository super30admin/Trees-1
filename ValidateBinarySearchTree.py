'''
In this problem we have to validate if the given root array is a Binary Search Tree.
Here I used a recursiveHelper function to traverse on the tree until the base condition is met(when root is null).
Validating based on Binary Search Tree(BST) definition, the left node elements are always smaller than the root, and right nodes are greater than root, by taking them as previous and current elements.
Once we reach the end of the root we are moving to the right subtree during inorder.
If at any point the tree is not a valid BST the flag returns false.
'''
class Solution:
    def __init__(self):
        self.flag = True
        self.prev = None

    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        if root == None: return True
        self.recursiveHelper(root)
        return self.flag
    
    def recursiveHelper(self, root):
        # conditon
        if root is None: return
        # doing inorder traversal
        self.recursiveHelper(root.left)
        # processing root: checking if previous root is greater than current root
        if self.prev is not None and self.prev.val >= root.val:
            self.flag = False
        
        self.prev = root
        self.recursiveHelper(root.right)
'''
Time Complexity: O(n)
Since we are iterating on each node once, time taken is O(n).
Space Complexity: O(h)
At most the number of elements present inside the stack is equal to height of the tree.
'''