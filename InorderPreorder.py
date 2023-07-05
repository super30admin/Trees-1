# Time Complexity : O(n), n is the number of nodes
# Space Complexity : O(H), height of the tree (for recursive stack)

# The code ran on LeetCode

# The first element in preorder list is the root of the binary tree. Maintain a hash map to get the index of root node in the inorder array. The left portion of the root node corresponds to the left sub tree and the right portion of the root node corresponds to the right sub tree.
# Recursively call the helper function on the left and right sub portion of the array

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:

        in_map = {}
        # Store indices of inorder array in a Hash Map. We can get the root index in O(1) time
        for i in range(len(inorder)):
            in_map[inorder[i]] = i
        idx = 0
        start = 0; end = len(inorder) - 1

        def construct(preorder, start, end):
            nonlocal idx
            if start > end:
                return None

            rootVal = preorder[idx]
            idx+=1
    
            root = TreeNode(rootVal)
            rootIdx = in_map[rootVal]
            root.left = construct(preorder, start, rootIdx - 1)
            root.right = construct(preorder, rootIdx + 1, end)

            return root

        return construct(preorder, start, end)
