#Time Complexity: O(n)
#Space Complexity: O(n)
#Submit on Leetcode: yes 


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def buildTree(self, preorder, inorder):
        if not preorder or not inorder:
            return None

        root_val = preorder.pop(0)
        root = TreeNode(root_val)
        inorder_index = inorder.index(root_val)

        root.left = self.buildTree(preorder, inorder[:inorder_index])
        root.right = self.buildTree(preorder, inorder[inorder_index + 1:])

        return root


def printTreeInorder(root):
    if root:
        printTreeInorder(root.left)
        print(root.val, end=" ")
        printTreeInorder(root.right)

sol = Solution()
preorder = [3, 9, 20, 15, 7]
inorder = [9, 3, 15, 20, 7]

tree_root = sol.buildTree(preorder, inorder)

def printTreePreorder(root):
    if root:
        print(root.val, end=" ")
        printTreePreorder(root.left)
        printTreePreorder(root.right)

sol = Solution()
preorder = [3, 9, 20, 15, 7]
inorder = [9, 3, 15, 20, 7]

tree_root = sol.buildTree(preorder, inorder)


# Print the inorder traversal of the constructed tree
print("Inorder Traversal:")
printTreeInorder(tree_root)

# Print the inorder traversal of the constructed tree
print("Preorder Traversal:")
printTreePreorder(tree_root)



