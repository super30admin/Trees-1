
# Recursive
# Time Complexity: O(n)
# Space Complexity: O(n)

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def buildTree(self, preorder, inorder):
        if not preorder or not inorder:
            return None
        
        root = TreeNode(preorder[0])
        index = inorder.index(preorder[0])
        
        root.left = self.buildTree(preorder[1:index+1], inorder[:index])
        root.right = self.buildTree(preorder[index+1:], inorder[index+1:])
        

      return root

# Iterative
# Time Complexity: O(n)
# Space Complexity: O(n)


class Solution:
    def buildTree(self, preorder, inorder):
        if not preorder or not inorder:
            return None
        
        root = TreeNode(preorder[0])
        stack = [root]
        inorder_index = 0
        
        for i in range(1, len(preorder)):
            if stack and stack[-1].val != inorder[inorder_index]:
                node = TreeNode(preorder[i])
                stack[-1].left = node
                stack.append(node)
            else:
                while stack and stack[-1].val == inorder[inorder_index]:
                    node = stack.pop()
                    inorder_index += 1
                node = TreeNode(preorder[i])
                stack[-1].right = node
                stack.append(node)
        
        return root
