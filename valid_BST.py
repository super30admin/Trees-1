################## Iterative solution
# Time complexity: O(n)
# Space complexity: O(h) # depth of tree
# Worked on leetcode: yes
# We do the inorder traversal of the BST tree, and if the tree is valid, inorder traversal should be a sorted array.
# To check if its sorted, we just check the current node, with its previous node, and if it is not true, the list is not sorted.


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        if root == None:
            return True

        prev = None
        stack = []

        while (root != None or len(stack) != 0):  # when the right child is None, but stack is still not empty
            # go to the left most node
            while (root != None):
                stack.append(root)
                root = root.left

            # now get the top node from the stack to process
            curr_node = stack.pop()

            # process the current node: check if the inorder traversal array is sorted by checking it with immediate previous node
            if prev != None and prev.val >= curr_node.val:
                return False

            prev = curr_node

            root = curr_node.right  # look at the right of currently processed node

        return True


root = TreeNode(2)
root.left = TreeNode(1)
root.right = TreeNode(3)
result = Solution()
print(result.isValidBST(root))