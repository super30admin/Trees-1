#Time Complexity O(N)
#Space Complexity O(N)
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        def inorder(root):
            if not root:
                return True
            if not inorder(root.left):
                return False
            if root.val<=self.prev:
                return False
            self.prev= root.val
            return inorder(root.right)
            
        self.prev= -math.inf
        return inorder(root)
        
