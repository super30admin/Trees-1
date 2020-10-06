# Time COmplexity: O(N)
# Space Complexity: O(N)
# Leetcode all test cases passed: Yes
# Any difficulties: No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        dic = {}
        k = 0
        for idx, ele in enumerate(inorder):
            dic[ele] = idx
        
        def helper(left, right):
            nonlocal preorder, inorder, k
            if left > right:
                return None
            element = preorder[k]
            root = TreeNode(element)
            k+=1
            indexElement = dic[element]
            root.left = helper(left, indexElement-1)
            root.right = helper(indexElement+1, right)
            return root
        return helper(0, len(inorder)-1)
