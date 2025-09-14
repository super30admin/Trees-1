# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
"""
Space Complexity: O(N) -> for the hashmap
Time Complexity: O(N) -> Number of nodes visited
"""
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        idx = 0
        # create an inorder hashmap 
        mp = {}
        for i, v in enumerate(inorder): 
            mp[v] = i

        def build(start, end): 
            nonlocal idx
            # Base condition
            if start > end: 
                return None
            root = TreeNode(preorder[idx])
            idx+=1
            rootval = root.val

            root.left = build(start, mp[rootval]-1)
            root.right = build(mp[rootval]+1, end)

            return root

        return build(0, len(inorder)-1)



        



