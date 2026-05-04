class Solution:

    def isValidBST(self, root):
        self.result = True
        self.prev = None
        self.helper(root)
        return self.result

    def helper(self, root):

        # Base
        if root == None:
            return 
        
        # Logic
        if self.result:
            self.helper(root.left)
        
        if self.prev is not None and self.prev.val >= root.val:
            self.result = False

        self.prev = root

        if self.result:
            self.helper(root.right)

# Time complexity: O(N), worst case if the violation is in the right most last node, we visit/traverse all nodes
# Space complexity: O(H), where h is the height of the tree (consider example of skewed tree)

