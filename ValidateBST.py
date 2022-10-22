
# DFS Solution
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:

        def inorder(root):
            if root == None:
                return True
                # Returning true here because if the traversal reach the leaf node without returning False then it seems to be true

            if not inorder(root.left):
                return False
            # Returning False here because if any of the root.left recursive call was False then it will return False
            if root.val <= self.prev:
                return False

            # If the curr value is less than the previous then return False
            self.prev = root.val
            
            return inorder(root.right)
            # return the boolean value of right subtree

        self.prev = - math.inf
        return inorder(root)

        # Time Complexity: O(n) in  worst case
        # Space Complexity: O(n) considering recursive stack

# DFS Solution keeping track of min and max at each node
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:

        def valid(root, left, right):
            if root == None:
                return True

            if not (root.val > left and root.val < right):
                return False

            return valid(root.right,root.val, right) and valid(root.left, left, root.val)

        return valid(root, -math.inf, math.inf)

        # Using min and max method in DFS approach