# Time Complexity: O(N), N is the number of nodes in the tree
# Space Complexity: O(H), where H is the number of recursive function calls in the stack
# O (log N) in best case where the tree is balanced and O(N) in the worst case where the tree is skewed
# Did this code successfully run on Leetcode: Yes


from typing import List, Optional

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        
class Solution:
    def __init__(self):
        self.pre_order_index = 0

    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        index_map = {}
        for index in range(len(inorder)):
            index_map[inorder[index]] = index
            
        return self.helper(preorder, inorder, index_map, 0, len(inorder) - 1)
    
    def helper(self, pre_order, in_order, index_map, in_order_start, in_order_end):
        if in_order_start > in_order_end:
            return None

        root_val = pre_order[self.pre_order_index]
        self.pre_order_index += 1
        root = TreeNode(root_val)
        

        root_index = index_map[root_val]

        root.left = self.helper(pre_order, in_order, index_map, in_order_start, root_index - 1)
        root.right = self.helper(pre_order, in_order, index_map, root_index + 1, in_order_end)

        return root

