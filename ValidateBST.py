# TC: O(N) since we are traversing all the nodes of the tree. 
# SC: O(H) where H is the height of the binary tree/ H is the max size of a stack at any point in iterative solution. 

class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        self.prev = None    
        def inorder(root):
            if not root:
                return True
            if not inorder(root.left):
                return False
            if self.prev and self.prev.val >= root.val:
                return False
            self.prev = root
            return inorder(root.right)
        
        return inorder(root)
