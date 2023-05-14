## Problem 1

# https://leetcode.com/problems/validate-binary-search-tree/

# Time Complexity : O(n)
# Space Complexity : O(h) where h is the height of the tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach: Recursion
# 1. For every node, check if it is in the range of min and max values. If not, return False
# 2. For every node, check if its left and right child are in the range of min and max values. If not, return False
# 3. If all the above conditions are satisfied, return True

class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        return self.helper(root, float('-inf'), float('inf'))

    def helper(self, root, min, max):
        if not root:
            return True
        if root.val <= min or root.val >= max:
            return False
        return self.helper(root.left, min, root.val) and self.helper(root.right, root.val, max)

# Approach: Iteration
# 1. Use a stack to store the nodes and a stack to store the min and max values
# 2. For every node, check if it is in the range of min and max values. If not, return False
# 3. For every node, check if its left and right child are in the range of min and max values. If not, return False
# 4. If all the above conditions are satisfied, return True

class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        if not root:
            return True
        stack = []
        stack.append(root)
        stack.append(float('-inf'))
        stack.append(float('inf'))
        while stack:
            max = stack.pop()
            min = stack.pop()
            node = stack.pop()
            if node.val <= min or node.val >= max:
                return False
            if node.left:
                stack.append(node.left)
                stack.append(min)
                stack.append(node.val)
            if node.right:
                stack.append(node.right)
                stack.append(node.val)
                stack.append(max)
        return True

## Problem 2

# https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

# Time Complexity : O(n)
# Space Complexity : O(n) where n is the number of nodes in the tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach: Recursion
# 1. The first element in the preorder list is the root of the tree
# 2. Find the index of the root in the inorder list
# 3. The elements to the left of the root index in the inorder list are the left subtree and the elements to the right of the root index in the inorder list are the right subtree
# 4. Recursively call the function on the left and right subtrees

class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        if not inorder or not preorder:
            return None
        root = TreeNode(preorder[0])
        index = inorder.index(preorder[0])
        root.left = self.buildTree(preorder[1:index + 1], inorder[:index])
        root.right = self.buildTree(preorder[index + 1:], inorder[index + 1:])
        return root

# Approach: Iteration

class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        if not inorder or not preorder:
            return None
        root = TreeNode(preorder[0])
        stack = []
        stack.append(root)
        index = 0
        for i in range(1, len(preorder)):
            node = TreeNode(preorder[i])
            if inorder[index] != stack[-1].val:
                stack[-1].left = node
                stack.append(node)
            else:
                while stack and inorder[index] == stack[-1].val:
                    curr = stack.pop()
                    index += 1
                curr.right = node
                stack.append(node)
        return root

