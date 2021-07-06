# Both the approaches will have the same analysis!
# Time Complexity : O(n), where n is the number of nodes in the tree.
# Space Complexity : O(h), where h is the height of the tree.
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

# Your code here along with comments explaining your approach
class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution(object):
    def __init__(self):
        self.prev = None

    # This approach utilises inorder traversal and maintains a previous node
    # pointer and compares it's value for a violation of the BST property.
    def isValidBSTInorder(self, root):
        return self.helperInorder(root)

    def helperInorder(self, root):
        if root == None:
            return True
        # inorder left
        if not self.helperInorder(root.left):
            return False
        # parent val comparison with current
        if self.prev != None and self.prev.val >= root.val:
            return False
        self.prev = root
        # inorder right
        return self.helperInorder(root.right)

    # this approach uses a range and for every node compares to see
    # if the node falls within a particular range, if not returns false.
    def isValidBSTRange(self, root):
        return self.helperRange(root, float('-inf'), float('inf'))

    def helperRange(self, root, minVal, maxVal):
        if root == None:
            return True
        # compare current node
        if not minVal < root.val < maxVal:
            return False
        return self.helperRange(root.left, minVal, root.val) and self.helperRange(root.right, root.val, maxVal)


# root = TreeNode(5, TreeNode(1, None, None), TreeNode(4, TreeNode(3, None, None), TreeNode(6, None, None)))  # False
root = TreeNode(2, TreeNode(1, None, None), TreeNode(3, None, None))  # True
print(Solution().isValidBSTInorder(root), Solution().isValidBSTRange(root))
