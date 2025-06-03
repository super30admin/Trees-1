"""
problem: Construct Binary Tree from Preorder and Inorder Traversal
Approach: the preorder gives us the next root to build and the inorder traversal gives the children for these roots. The inorder 
traversal gives us the children to the left and to the right of the current node. This information can be used to determine when to 
return (or stop going left or right and backtrack)
t.c.=> O(n) n is number of nodes
s.c. => O(n) for the hashmap of nodes to indices.
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        self.prePointer = 0
        inorderIndex = collections.defaultdict(int)
        n = len(inorder)
        
        for i in range(n):
            inorderIndex[inorder[i]] = i
        
        def helper(l, r):
            if l > r:
                return 
            
            rootval = preorder[self.prePointer]
            root = TreeNode(rootval)
            self.prePointer += 1
            idx = inorderIndex[rootval]
            root.left = helper(l, idx - 1)
            root.right = helper(idx + 1, r)

            return root
        return helper(0, n - 1)