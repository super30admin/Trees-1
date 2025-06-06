''' 
Problem: Construct Binary Tree from Preorder and Inorder Traversal 
Leetcode Link: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/

Approach:
- A binary tree can be constructed from its preorder and inorder traversal lists.
- The first element of the preorder list is the root of the tree.
- The inorder list helps to determine the left and right subtrees of the root.
- We recursively build the left and right subtrees using the respective segments of the preorder and inorder lists.
Time Complexity: O(N^2) as we traverse each node once and for each node, we search for its index in the inorder list.
Space Complexity: O(N^2) as we create a new list for each recursive call, leading to O(N) space for the recursion stack and O(N) space for the lists.
'''


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:

        def solve(preorder, inorder):
            if len(preorder) == 0:
                return None
            root = preorder[0]
            rootIndex = -1
            N = len(inorder)
            for i in range(len(inorder)):
                if inorder[i] == root:
                    rootIndex = i
                    break

            left_in = inorder[:rootIndex]
            right_in = inorder[rootIndex+1:] 

            left_pre = preorder[1:1+len(left_in)]
            right_pre = preorder[len(left_in)+1:]

            root = TreeNode(preorder[0])
            root.left = solve(left_pre, left_in)
            root.right = solve(right_pre, right_in)

            return root

        return solve(preorder, inorder)
