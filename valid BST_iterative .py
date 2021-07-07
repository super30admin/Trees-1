
# ITERATIVE SOLUTION / DFS APPROACH

#  ===> Solution : BETTER than creating a list out of  the inorder traversal of tree and then checking if it is in increasing order as this solution returns False immediately when a breach happens.

# Time Complexity: O(N), WORST CASE of perfect BST, it has to traverse through all nodes to return True
# Space Complexity: No additional space, except the Recursive stack
# Did problem run on Leetcode: yes

class TreeNode:
    def __init__(self, key):
        self.key = key
        self.left = None
        self.right = None

class Solution:

    def isValidBST(self, root):
        return self.helper(root, None, None)

    def helper(self, root, min, max):
        # BASE CASE
        if not root:
            return True

        # LOGIC
        if min != None and root.key <= min:
            return False
        if max != None and root.key >= max:
            return False
        return self.helper(root.left, min, root.key) and self.helper(root.right, root.key, max)
        


a = TreeNode(20)
a.left = TreeNode(15)
a.right = TreeNode(25)
a.left.left = TreeNode(13)
a.left.right = TreeNode(18)
a.right.left = TreeNode(24)
a.right.right = TreeNode(27)
a.left.left.left = TreeNode(10)
a.left.left.right = TreeNode(14)
a.left.right.left = TreeNode(16)
a.left.right.right = TreeNode(19)

obj = Solution()
print(obj.isValidBST(root = a))




            
        











